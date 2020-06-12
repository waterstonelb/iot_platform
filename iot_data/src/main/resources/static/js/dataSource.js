$(document).ready(function(){
    localStorage.clear();

    getDeviceList();

    $(".category").hover(function(){
        this.style.cursor='pointer';
    });

    $(".category").click(function(){
        $(".category").each(function(){
            $(this).css("background-color","white");
        });
        $(this).css("background-color","darkgrey");
        var text=$(this).text();
        if(text=="设备数据"){
            isFirst=true;
            addDevice();
        }
        else{
            isFirst=false;
            addExternal();
        }
    })

    function addDevice() {
        var text="<button type='button' id='addDeviceData'> + 添加设备数据</button>";
        $('#fileForm').hide();
        $('#devicename').val('');
        $('#filepath').val('');
        $('.add').html(text);
    }

    function addExternal(){
        var text="<button type='button' id='addExternalData'> + 添加外部数据</button>";
        $('#deviceForm').hide();
        $('#devicename').val('');
        $('#filepath').val('');
        $('.add').html(text);
    }

    $('.add').on('click','#addDeviceData',function(){
        $('#deviceForm').show();
    })
    $('.add').on('click','#addExternalData',function(){
        $('#fileForm').show();
    })

    $('.Form').on('click','#btn1',function(){
        var name=$('#devicename').val();
        alert(name);
        var list=[];
        var map={name:name};
        var data=new Object();
        data.name=name;
        data.id=1;
        data.temperature=11.1;
        data.press=23.33;
        data.time='234';
        data.ip='23d';
        list.push(data);

        $.ajax({
            type:'POST',
            url: '/addDeviceData',
            data: JSON.stringify({
                list:list
            }),
            contentType: "application/json",
            dataType:"json",
            asnyc: true,
            success:function(res){
                alert(res);
                $('#deviceForm').hide();
                $('#devicename').val('');
                getDeviceList();
            },
            error:function(res){
                alert(res);
            }
        })
    })

    $('.Form').on('click','#btn2',function(){
        var filepath=$('#filepath').val();
        $.ajax({
            type:'POST',
            url: '/addExternalData',
            data: JSON.stringify(filepath),
            asnyc: true,
            success:function(res){
                if(res>0)
                    alert('成功添加'+res+'条数据');
                else if(res==0)
                    alert('文件数据已存在');
                else
                    alert("找不到文件路径");
                $('#filepath').val('');
                $('#fileForm').hide();
                getDeviceList();
            },
            error:function(res){
                alert('failure');
            }
        })
    })

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
                var text="<ul>";
                for(var i=0;i<deviceList.length;i++){
                    text+="<li style='display:flex;justify-content: space-around'><div style='width:200px;margin-right:10px'>"+deviceList[i]+"</div>" +
                        "<div>" +
                        "<button type='button' id='query' device-name='"+deviceList[i]+"' style='background-color: deepskyblue;color:white'>查看</button>" +
                        "<button type='button' id='delete' device-name='"+deviceList[i]+"' style='background-color: red;color:white'>删除</button></div></li>";
                }
                text+="</ul>";
                $('.device-list').html(text);
            },
            error:function(res){
                alert(res);
            }
        })
    }

    $('.device-list').on('click','#query',function(){
        var name=$(this).attr('device-name');
        localStorage.setItem('deviceName',name);
        window.location.href='dataAsset';
    })

    $('.device-list').on('click','#delete',function(){
        var name=$(this).attr('device-name');
        $.ajax({
            type:'POST',
            url: '/deleteDeviceData',
            data: JSON.stringify(name),
            asnyc: true,
            success:function(res){
                alert('操作成功');
                getDeviceList();
            },
            error:function(res){
                alert('操作失败');
            }
        })
    })
})