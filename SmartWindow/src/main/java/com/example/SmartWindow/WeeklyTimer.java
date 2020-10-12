package com.example.SmartWindow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WeeklyTimer{
    private JsonFileProduce CityProduce;
    private JsonFileProduce AreaProduce;
    private JsonFileProduce VilProduce;
    private XmlParse xmlParse;
    private File file;
    private FileWriter writer;

    public WeeklyTimer(){
        CityProduce = new JsonFileProduce();
        file = new File("D:/Spring/SmartWindow/src/main/webapp/txt/weather.txt");
        writer = null;
        TimerParsing();
    }
    public void TimerParsing(){
        CityProduce.Parsing("http://www.kma.go.kr/DFSROOT/POINT/DATA/top.json.txt");
        for(int i = 0; i<CityProduce.getArrayList().size();i++){
            String code = CityProduce.getArrayList().get(i).get("code").toString();
            String areaUrl = "http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl." + code + ".json.txt";
            System.out.println(areaUrl);
            AreaProduce = new JsonFileProduce();
            AreaProduce.Parsing(areaUrl);
            for(int k = 0; k<AreaProduce.getArrayList().size();k++){
                String Areadcode = AreaProduce.getArrayList().get(k).get("code").toString();
                for(int j = 0;j<AreaProduce.getArrayList().size();j++){
                    String vilUrl = "http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf."+code+Areadcode+".json.txt";
                    VilProduce.Parsing(vilUrl);
                    String Vilcode = VilProduce.getArrayList().get(i).get("code").toString();
                    xmlParse = new XmlParse(code+Areadcode+Vilcode);
                    System.out.println(xmlParse.getList().get(2).get("hour"));
                    try{
                        writer = new FileWriter(file, false);
                        writer.write(code+Areadcode+Vilcode+ " : ["+xmlParse.getList().get(0).get("hour")+","+xmlParse.getList().get(0).get("wfKor")+","+xmlParse.getList().get(0).get("temp")+"]"+","+"["+xmlParse.getList().get(1).get("hour")+","+xmlParse.getList().get(1).get("wfKor")+","+xmlParse.getList().get(1).get("temp")+"]"+
                                "["+xmlParse.getList().get(2).get("hour")+","+xmlParse.getList().get(2).get("wfKor")+","+xmlParse.getList().get(2).get("temp")+"]"+","+"["+xmlParse.getList().get(3).get("hour")+","+xmlParse.getList().get(3).get("wfKor")+","+xmlParse.getList().get(3).get("temp")+"]"+","+
                                "["+xmlParse.getList().get(4).get("hour")+","+xmlParse.getList().get(4).get("wfKor")+","+xmlParse.getList().get(4).get("temp")+"]");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try{
                            if(writer != null)writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        WeeklyTimer weeklyTimer = new WeeklyTimer();
    }
}