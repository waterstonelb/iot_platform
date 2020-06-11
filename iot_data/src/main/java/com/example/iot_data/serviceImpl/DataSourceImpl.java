package com.example.iot_data.serviceImpl;

import com.example.iot_data.dao.DataSourceMapper;
import com.example.iot_data.po.deviceData;

import com.example.iot_data.service.DataSourceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataSourceImpl implements DataSourceInter {
    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public int addDeviceData(String name){
        return 0;
    }

    @Override
    public void deleteDeviceData(String name){dataSourceMapper.delete(name);}

    @Override
    public int addExternalData(String path){

        if(path==null){
            return -1;
        }
        int count = 0;
        List<deviceData> newList = readExcel(path);
        if(newList!=null) {

            for (int i = 0; i < newList.size(); i++) {
                String name = newList.get(i).getName();
                int id = newList.get(i).getId();
                String time=newList.get(i).getTime();
                String ip=newList.get(i).getIp();
                List<deviceData> indexList = dataSourceMapper.getDeviceData(id,name,time,ip);
                if (indexList.size() != 0) { //有重复的数据
                    continue;
                } else { //没有重复的数据，可以添加数据
                    double temp=newList.get(i).getTemperature();
                    double press=newList.get(i).getPress();
                    count++;
                    dataSourceMapper.addDeviceData(id,name,temp,press,time,ip);
                }
            }
            return count;
        }else{
            return -1;
        }

    }

    private List<deviceData> readExcel(String filePath){
        try{
            List<deviceData> list = new ArrayList<>();
            InputStream is = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            int maxRow = sheet.getLastRowNum();

            for(int row = 1;row<=maxRow;row++){
                deviceData info = new deviceData();

                int id = (int)Double.parseDouble(sheet.getRow(row).getCell(0).toString());
                String name = sheet.getRow(row).getCell(1).toString();
                double temp = Double.parseDouble(sheet.getRow(row).getCell(2).toString());
                double press = Double.parseDouble(sheet.getRow(row).getCell(3).toString());
                String time = sheet.getRow(row).getCell(4).toString();
                String ip=sheet.getRow(row).getCell(5).toString();

                info.setId(id);
                info.setName(name);
                info.setTemperature(temp);
                info.setPress(press);
                info.setIp(ip);
                info.setTime(time);
                list.add(info);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}