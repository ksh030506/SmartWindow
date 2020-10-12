package com.example.SmartWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekWeather {
    private XmlParse xmlParse;
    private String WeekName;
    private String addr;
    private Map<String, Object> data = new HashMap<>();
    private String Day_week;

    public List<Map<String, Object>> getWeekList() {
        return WeekList;
    }

    private List<Map<String,Object>> WeekList;
    public WeekWeather(String addr){
        this.addr = addr;
        xmlParse= new XmlParse(addr);
        Day_week = xmlParse.getList().get(1).get("week").toString();
        Func();
    }
    public void Func(){
        WeekList = new ArrayList<Map<String,Object>>();
        data = new HashMap<String, Object>();
        data.put("week",WeekCheck(Day_week));
        data.put("temp",xmlParse.getList().get(1).get("temp").toString());
        data.put("wfEn",xmlParse.getList().get(1).get("wfEn").toString());
        WeekList.add(data);
        for(int i = 2;i<xmlParse.getList().size();i++){
            if(!xmlParse.getList().get(i).get("week").toString().equals(Day_week)){
                Day_week = xmlParse.getList().get(i).get("week").toString();
                data = new HashMap<String, Object>();
                data.put("week",WeekCheck(Day_week));
                data.put("temp",xmlParse.getList().get(i).get("temp").toString());
                data.put("wfEn",xmlParse.getList().get(i).get("wfEn").toString());
                WeekList.add(data);
            }
        }
        System.out.println("weeklist"+WeekList);
    }
    public String WeekCheck(String Day_of_week){
        if(Day_of_week.equals("1"))WeekName = "일";
         else if(Day_of_week.equals("2"))WeekName = "월";
        else if(Day_of_week.equals("3"))WeekName = "화";
        else if(Day_of_week.equals("4"))WeekName = "수";
        else if(Day_of_week.equals("5"))WeekName = "목";
        else if(Day_of_week.equals("6"))WeekName = "금";
        else if(Day_of_week.equals("7"))WeekName = "토";

        return WeekName;
    }
}
