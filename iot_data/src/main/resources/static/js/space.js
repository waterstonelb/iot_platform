$(document).ready(function(){
    localStorage.clear();

    getPoint();
    var data=[];
    var geoCoordMap={};

    function getPoint(){
        $.ajax({
            type:'POST',
            url: '/getPoint',
            asnyc: true,
            success:function(res){

                for(var i=0;i<res.length;i++){
                    var map={};
                    map['name']=res[i].name;
                    var temp=[];
                    temp.push(res[i].x);
                    temp.push(res[i].y);
                    temp.push(100);
                    map['value']=temp;
                    data.push(map);
                }
                getMap();
            },
            error:function(res){
                alert(res);
            }
        })

        /*var data=[
            {name:'zc',value:100},
            {name:'asd',value:100}
        ];
        var geoCoordMap={
            'zc':[110,32],
            'asd':[130,56]
        };
         */

        //var bmap = Chart.getModel().getComponent('bmap').getBMap();
        //bmap.addControl(new BMap.MapTypeControl());
    }

    function getMap(){
        /*var convertData=function(data){
            var res = [];
            for (var i = 0; i < data.length; i++) {
                var geoCoord = geoCoordMap[data[i].name];
                if (geoCoord) {
                    res.push({
                        name: data[i].name,
                        value: geoCoord.concat(data[i].value)
                    });
                }
            }
            return res;
        };*/

        var option={
            geo: {
                map: 'china',
                roam:true,
                zoom:5
            },
            tooltip:{
                trigger:'item',
                formatter: '{a}:{b}'
            },

            series:[
                {
                    name:'设备名称',
                    type:'scatter',
                    coordinateSystem:'geo',
                    data:data,
                    roam:true,
                    zoom:1,
                    symbolSize: function (val) {
                        return val[2] / 10;
                    },
                    encode: {
                        value: 2
                    },
                    label: {
                        formatter: '{b}',
                        position: 'right',
                        show: false
                    },
                    itemStyle: {
                        color: 'purple'
                    },
                    emphasis: {
                        label: {
                            show: false
                        }
                    }
                }
            ]
        };

        document.getElementById("map").style.width="100%";
        document.getElementById("map").style.height="600%";

        var Chart=echarts.init(document.getElementById("map"));
        Chart.setOption(option);

        Chart.on('click',function(param){
            var name=param.name;
            localStorage.setItem('deviceName',name);
            window.location.href="dataAsset";
        })
    }

})