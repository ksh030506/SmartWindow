package com.example.SmartWindow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonFileProduce{

    private URL url;
    private String Url;
    private Map<String, Object> map;

    private ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

    public void Parsing(String Url){
        this.Url = Url;
        try{
            url = new URL(Url);
            URLConnection con = (URLConnection)url.openConnection();
            InputStreamReader reader = new InputStreamReader(con.getInputStream(), "utf-8");


            BufferedReader buff = new BufferedReader(reader);
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = (JsonArray) jsonParser.parse(buff);
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject object = (JsonObject) jsonArray.get(i);
                String code = object.get("code").toString();
                String value = object.get("value").toString();
                map = new HashMap<>();
                map.put("code", code);
                map.put("value", value);
                arrayList.add(map);
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Map<String, Object>> getArrayList() {
        return arrayList;
    }
}

