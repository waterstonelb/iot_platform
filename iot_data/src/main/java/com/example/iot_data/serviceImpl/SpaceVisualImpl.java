package com.example.iot_data.serviceImpl;

import com.example.iot_data.dao.SpaceVisualMapper;
import com.example.iot_data.po.deviceData;
import com.example.iot_data.po.point;
import com.example.iot_data.service.SpaceVisualInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceVisualImpl implements SpaceVisualInter {

    @Autowired
    private SpaceVisualMapper spaceVisualMapper;

    @Override
    public List<point> getPoint(){
        List<deviceData> devices=spaceVisualMapper.getPoint();
        List<point> res=new ArrayList<>();

        for(int i=0;i<devices.size();i++){
            point p=new point();
            p.setName(devices.get(i).getName());
            String ip=devices.get(i).getIp();
            String[] xy=getIPXY(ip);
            p.setX(Double.parseDouble(xy[0]));
            p.setY(Double.parseDouble(xy[1]));
            res.add(p);
        }

        return res;
    }

    public static String[] getIPXY(String ip) {

        String ak = "2N9LHmjQvQueZrxtIYUbNo4psXPVYlGC";

        try {

            URL url = new URL("http://api.map.baidu.com/location/ip?ak=" + ak
                    + "&ip=" + ip + "&coor=bd09ll");
            InputStream inputStream = url.openStream();
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputReader);
            StringBuffer sb = new StringBuffer();
            String str;
            do {
                str = reader.readLine();
                sb.append(str);
            } while (null != str);


            str = sb.toString();
            if (null == str || str.isEmpty()) {
                return null;
            }


// 获取坐标位子
            int index = str.indexOf("point");
            int end = str.indexOf("}}", index);


            if (index == -1 || end == -1) {
                return null;
            }


            str = str.substring(index - 1, end + 1);
            if (null == str || str.isEmpty()) {
                return null;
            }


            String[] ss = str.split(":");
            if (ss.length != 4) {
                return null;
            }


            String x = ss[2].split(",")[0];
            String y = ss[3];


            x = x.substring(x.indexOf("\"") + 1, x.indexOf("\"", 1));
            y = y.substring(y.indexOf("\"") + 1, y.indexOf("\"", 1));


            return new String[] { x, y };


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
