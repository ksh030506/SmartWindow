package com.example.SmartWindow;

import java.util.HashMap;
import java.util.Map;

public class WeatherIcon{
    private String className;
    private String imgName;

    public void setWeater(String weater) {
        this.weater = weater;
    }

    private String weater;
    private Map<String, Object> WeatherIcon = new HashMap<>();
    public Map<String,Object> ProductIcon(){
        switch (weater){
            case "Clear":
            case "맑음":
                WeatherIcon.put("className", "clear1");
                WeatherIcon.put("imgName", "img/clear1.png");
            break;
            case "Partly Cloudy":
            case "구름조금":
                WeatherIcon.put("className", "clear1");
                WeatherIcon.put("imgName", "img/Partly Cloudy1.png");
                break;
            case "Cloudy":
            case "흐림":
                WeatherIcon.put("className", "cloudy");
                WeatherIcon.put("imgName", "img/Cloudy.png");
                break;
            case "Rain":
            case "흐리고 비":
            case "구름많고 비":
                WeatherIcon.put("className", "rain");
                WeatherIcon.put("imgName", "img/Rain.png");
                break;
            case "Snow/Rain":
            case "흐리고 비/눈":
            case "흐리고 눈/비":
            case "구름많고 눈/비":
            case "구름많고 비/눈":
                WeatherIcon.put("className", "snow");
                WeatherIcon.put("imgName", "img/snow&rain1.png");
                break;
            case "Snow":
            case "흐리고 눈":
            case "구름많고 눈":
                WeatherIcon.put("className", "snow");
                WeatherIcon.put("imgName", "img/Snow1 (2).png");
                break;
            case "Mostly Cloudy":
            case "구름많음":
                WeatherIcon.put("className", "mostlyCloudy");
                WeatherIcon.put("imgName", "img/Mostly Cloudy1.png");
                break;
            default:
                break;
        }
        System.out.println(WeatherIcon);
        return WeatherIcon;
    }
}
