$(document).ready(function(){
    localStorage.clear();

    var isFirst=1;
    var deviceName;
    var time1='2010-01-01';
    var time2='2021-01-01';
    var temp1=0;
    var temp2=100;
    var press1=0;
    var press2=1000;
    var attr='time';
    var p=1;

    $(".category").hover(function(){
        this.style.cursor='pointer';
    });

    $(".category").click(function(){
        $(".category").each(function(){
            $(this).css("background-color","white");
        });
        $(this).css("background-color","darkgrey");
        var text=$(this).text();
        if(text=="时序透视"){
            isFirst=1;
            analyze();
        }
        else if(text=="可视化分析"){
            isFirst=2;
            visual();
        }
        else{
            isFirst=3;
            sql();
        }
    })

    function analyze() {
        var text="<button type='button' id='createAnalyze'> + 新建时序透视</button>";
        $('.create').html(text);
    }

    function visual(){
        var text="<button type='button' id='createAnalyze'> + 新建可视化分析</button>";
        $('.create').html(text);
    }

    function sql(){
        var text="<button type='button' id='createSQLAnalyze'> + 新建SQL分析</button>";
        $('.create').html(text);
    }

    $('.create').on('click','#createAnalyze',function(){
        $('.container').html("");
        getDeviceList();
    })

    $('.create').on('click','#createSQLAnalyze',function(){
        $('.container').html("");
        getSQL();
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
                var text="<div class='select-device'><select id='device'>" +
                    "<option value='' style='display:none'>选择设备</option>";
                for(var i=0;i<deviceList.length;i++){
                    text+="<option value='"+deviceList[i]+"'>"+deviceList[i]+"</option>";
                }
                text+="</select></div>"+
                    "<div class='console' id='graph' style='margin-top: 10px'></div>";
                $('.container').html(text);
            },
            error:function(res){
                alert('failure:'+res);
            }
        })
    }

    function getSQL(){
        var text="<div class='sql-console' style='text-align: center'>" +
            "<form>" +
            "<textarea id='sql-content' cols='150' rows='5' placeholder='请输入SQL语句'></textarea>" +
            "<button type='button' id='run' style='background-color:blue;color:white'>运行</button>" +
            "</form></div>" +
            "<div class='console' id='graph' style='margin-top: 10px'></div>";
        $('.container').html(text);
    }

    $('.container').on('change','#device',function(){
        deviceName=$(this).val();
        getTable();
    });

    function getTable(){
        $.ajax({
            type:'POST',
            url: '/visual',
            asnyc: true,
            data: JSON.stringify(deviceName),
            contentType: 'application/json',
            processData: false,
            success:function(res){
                if(isFirst==1){
                    var text="<label style='margin-left: 50%'>请选择时间区间：</label><input id='time1' type='date'/>——<input id='time2' type='date'/>";
                    $('.select-device').append(text);
                    timeAnalyze(res);
                }
                else if(isFirst==2){
                    var text="<label style='margin-left: 10%'>时间区间：</label><input id='times1' type='date'/> —— <input id='times2' type='date'/>"+
                        "<label style='margin-left: 1%'>温度：</label><input id='temp1' style='width:30px' type='text'/>℃ —— <input id='temp2' style='width:30px' type='text'/>℃"+
                        "<label style='margin-left: 1%'>压力：</label><input id='press1' style='width:30px' type='text'/>N —— <input id='press2' style='width:30px' type='text'/>N";
                    $('.select-device').append(text);
                    visualAnalyze(res);
                }
            },
            error:function(res){
                alert(res);
            }
        })
    }

    function timeAnalyze(res){
        var timeList = res.map(function (item) {
            return item.time;
        });
        var temperatureList=res.map(function(item){
            return item.temperature;
        });
        var pressList=res.map(function(item){
            return item.press;
        });

        var option = {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['温度', '压力']
            },
            grid: {
                left: '4%',
                right: '4%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: timeList.reverse()
            },
            yAxis: [{
                name:'温度/℃',
                type: 'value',
                scale:true,
                max:60,
                min:0,
                splitNumber:6
            },
                {
                    name:'压力/N',
                    type:'value',
                    scale:true,
                    max:600,
                    min:0,
                    splitNumber:6
                }],
            series: [
                {
                    name: '温度',
                    type: 'line',
                    data: temperatureList.reverse()
                },
                {
                    name: '压力',
                    type: 'line',
                    yAxisIndex: 1,
                    data: pressList.reverse()
                }
            ]
        };

        document.getElementById("graph").style.width="90%";
        document.getElementById("graph").style.height="500%";

        var Chart=echarts.init(document.getElementById("graph"));
        Chart.setOption(option);
    }

    function visualAnalyze(res){
        var text="<table style='margin: 0 auto'><thead>" +
            "<tr>" +
            "<th scope='col' style='white-space: nowrap'><p>设备名称</p><p></p><p></p></th>" +
            "<th scope='col' style='white-space: nowrap'><p>温度</p><p class='sort1'>↓</p><p class='sort2'>↑</p></th>" +
            "<th scope='col' style='white-space: nowrap'><p>压力</p><p class='sort3'>↓</p><p class='sort4'>↑</p></th>" +
            "<th scope='col' style='white-space: nowrap'><p>创建时间</p><p class='sort5'>↓</p><p class='sort6'>↑</p></th>" +
            "</tr>" +
            "</thead>"+
            "<tbody id='table'>";

        for(var i=0;i<res.length;i++){
            text+="<tr>" +
                "<td>" + res[i].name + "</td>" +
                "<td>" + res[i].temperature.toFixed(1) + "</td>" +
                "<td>" + res[i].press.toFixed(2) + "</td>" +
                "<td>" + res[i].time + "</td>" +
                "</tr>";
        }
        text+="</tbody></table>";
        $('.console').html("");
        $('.console').append(text);
    }

    $('.container').on('change','#time1',function(){
        time1=$(this).val();
        getDataByTime();
    });
    $('.container').on('change','#time2',function(){
        time2=$(this).val();
        getDataByTime();
    });
    $('.container').on('change','#times1',function(){
        time1=$(this).val();
        getDataByCondition();
    });
    $('.container').on('change','#times2',function(){
        time2=$(this).val();
        getDataByCondition();
    });
    $('.container').on('change','#temp1',function(){
        temp1=$(this).val();
        getDataByCondition();
    });
    $('.container').on('change','#temp2',function(){
        temp2=$(this).val();
        getDataByCondition();
    });
    $('.container').on('change','#press1',function(){
        press1=$(this).val();
        getDataByCondition();
    });
    $('.container').on('change','#press2',function(){
        press2=$(this).val();
        getDataByCondition();
    });
    $('.container').on('click','.sort1',function(){
        attr='temp';
        p=1;
        getDataByCondition();
    });
    $('.container').on('click','.sort2',function(){
        attr='temp';
        p=2;
        getDataByCondition();
    });
    $('.container').on('click','.sort3',function(){
        attr='press';
        p=1;
        getDataByCondition();
    });
    $('.container').on('click','.sort4',function(){
        attr='press';
        p=2;
        getDataByCondition();
    });
    $('.container').on('click','.sort5',function(){
        attr='time';
        p=1;
        getDataByCondition();
    });
    $('.container').on('click','.sort6',function(){
        attr='time';
        p=2;
        getDataByCondition();
    });

    function getDataByTime(){
        var data={};
        data['名称']=deviceName;
        data['时间1']=time1;
        data['时间2']=time2;
        $.ajax({
            type:'POST',
            url: '/timeAnalyze',
            asnyc: true,
            data: JSON.stringify(data),
            contentType: 'application/json',
            processData: false,
            success:function(res){
                timeAnalyze(res);
            },
            error:function(res){
                alert(res);
            }
        })
    }

    function getDataByCondition(){
        var data={};
        data['名称']=deviceName;
        data['时间1']=time1;
        data['时间2']=time2;
        data['温度1']=temp1;
        data['温度2']=temp2;
        data['压力1']=press1;
        data['压力2']=press2;
        data['属性']=attr;
        data['顺序']=p;
        $.ajax({
            type:'POST',
            url: '/visualByCondition',
            asnyc: true,
            data: JSON.stringify(data),
            contentType: 'application/json',
            processData: false,
            success:function(res){
                visualAnalyze(res);
            },
            error:function(res){
                alert(res);
            }
        })
    }

    $('.container').on('click','#run',function(){
        var sql=$('#sql-content').val();
        if(!sql.startsWith('select'))
            alert('仅支持查询操作');

        else{
            $.ajax({
                type:'POST',
                url: '/sql',
                asnyc: true,
                data: JSON.stringify(sql),
                contentType: 'application/json',
                processData: false,
                success:function(res){
                    if(res==null||res.length==0)
                        alert('请检查SQL语句是否正确');
                    else
                        sqlTable(res);
                },
                error:function (res) {
                    alert(res);
                }
            })
        }
    })

    function sqlTable(res){
        var text="<table style='margin: 0 auto'><thead>" +
            "<tr>";

        if(res[0].name!=null)
            text+="<th scope='col' style='white-space: nowrap'>设备名称</th>";
        if(res[0].temperature!=0.0)
            text+= "<th scope='col' style='white-space: nowrap'>温度</th>";
        if(res[0].press!=0.0)
            text+="<th scope='col' style='white-space: nowrap'>压力</th>";
        if(res[0].time!=null)
            text+="<th scope='col' style='white-space: nowrap'>创建时间</th>";
        text+="</tr>" +
            "</thead>"+
            "<tbody id='table'>";

        for(var i=0;i<res.length;i++){
            text+="<tr>";
            if(res[i].name!=null)
                text+="<td>" + res[i].name + "</td>";
            if(res[i].temperature!=0.0)
                text+="<td>" + res[i].temperature.toFixed(1) + "</td>";
            if(res[i].press!=0.0)
                text+="<td>" + res[i].press.toFixed(2) + "</td>";
            if(res[i].time!=null)
                text+="<td>" + res[i].time + "</td>";
            text+="</tr>";
        }
        text+="</tbody></table>";

        $('.console').html(text);
    }
})