$(document).ready(function () {
    var deviceName=localStorage.getItem('deviceName');
    getDeviceList();
    if(deviceName!=''&&deviceName!=null){
        getTable();
    }

    $('.select-device').on('change','#device',function(){
        deviceName=$(this).val();
        localStorage.clear();
        getTable();
    });

    function getDeviceList(){
        $.ajax({
            type:'POST',
            url: '/getDeviceList',
            asnyc: true,
            contentType: 'application/json',
            processData: false,
            success:function(res){
                var deviceList = res.map(function (item) {
                    return item.name;
                });
                var text="<select id='device'>" +
                    "<option value='' style='display:none'>选择设备</option>";
                for(var i=0;i<deviceList.length;i++){
                    text+="<option value='"+deviceList[i]+"'>"+deviceList[i]+"</option>";
                }
                text+="</select>";
                $('.select-device').html(text);
            },
            error:function(res){
                alert('failure:'+res);
            }
        })
    }

    function getTable(){
        $.ajax({
            type:'POST',
            url: '/getData',
            asnyc: true,
            data: JSON.stringify(deviceName),
            contentType: 'application/json',
            processData: false,
            success:function(res){
                $('#data-table').html("");
                var text="<thead>" +
                    "<tr>" +
                    "<th scope='col'>设备名称</th>" +
                    "<th scope='col' style='white-space: nowrap'>温度</th>" +
                    "<th scope='col' style='white-space: nowrap'>压力</th>" +
                    "<th scope='col' style='white-space: nowrap'>创建时间</th>" +
                    "</tr>" +
                    "</thead>"+
                    "<tbody id='table'>"

                for(var i=0;i<res.length;i++){
                    text+="<tr>" +
                        "<td>" + res[i].name + "</td>" +
                        "<td>" + res[i].temperature.toFixed(1) + "</td>" +
                        "<td>" + res[i].press.toFixed(2) + "</td>" +
                        "<td>" + res[i].time + "</td>" +
                        "</tr>";
                }
                text+="</tbody>";

                $('#data-table').append(text);
            },
            error:function(res){
                alert(res);
            }
        })
    }

});