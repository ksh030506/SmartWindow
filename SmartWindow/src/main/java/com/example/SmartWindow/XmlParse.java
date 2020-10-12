package com.example.SmartWindow;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import javax.print.DocFlavor;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XmlParse {

    private Map<String, Object> data = new HashMap<>();
    private Map<String, Object> Citydata = new HashMap<>();
    private Calendar time;
    private String addr;
    private Boolean CityorLocal;
    private List<Map<String,Object>> list;


    private List<Map<String,Object>> Citylist;

    public XmlParse(String addr){
        time = Calendar.getInstance();
        list = new ArrayList<Map<String,Object>>();
        Citylist = new ArrayList<Map<String,Object>>();
        this.addr = addr;
        MapProduce();
    }
    public void MapProduce(){
        String xml = "";
        if(addr.length() <4){addr = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId="+addr; CityorLocal=false;}
        else{ addr = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+addr; CityorLocal=true;}
        try{
            URL url = new URL(addr);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setConnectTimeout(10000);
            http.setUseCaches(false);

            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while(true){
                String line = br.readLine();
                if(line ==null)break;
                stringBuffer.append(line);
            }

            xml = stringBuffer.toString();
            br.close();
            http.disconnect();
        }catch (Exception e){
            System.out.println("xml 파싱 실패");
        }
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
            Document document = documentBuilder.parse(inputStream);
            Element element = document.getDocumentElement();
            if(CityorLocal == true)Map1Produce(element);
            else Map2Produce(element);
        }catch (Exception e){
            System.out.println("xml 파싱 또 불가");
        }


    }
    public void Map1Produce(Element element){
        try{
            int week=time.get(Calendar.DAY_OF_WEEK);
            NodeList list1 = element.getElementsByTagName("data");
            NodeList list2 = element.getElementsByTagName("category");
            Node node_t = list2.item(0);
            Map<String,Object> localmap = new HashMap<>();
            localmap.put("title",node_t.getTextContent().toString());
            list.add(localmap);
            int cnt = 0;
            for (int i = 0; i < list1.getLength(); i++) {
                for (Node localnode = list1.item(i).getFirstChild(); localnode != null; localnode = localnode.getNextSibling()) {
                    switch(localnode.getNodeName().toString()){
                        case "hour":
                            data = new HashMap<String, Object>();
                            data.put("hour", localnode.getTextContent().toString());

                        case "day":
                            if( localnode.getTextContent().toString().equals("0"))data.put("week", week);
                            else if(localnode.getTextContent().toString().equals("1")) {
                                if(cnt == 0){week++;cnt++;}
                                if(week==8){ week = 1;data.put("week", week); }
                                else data.put("week", week);
                            }else if(localnode.getTextContent().toString().equals("2")) {
                                if(cnt == 1){ week++;cnt++;}
                                if(week==8){ week = 1;data.put("week", week); }
                                else data.put("week", week);
                            }
                            data.put("day", localnode.getTextContent().toString());
                            break;
                        case "temp":
                            data.put("temp", localnode.getTextContent().toString());
                            break;
                        case "tmx":
                            data.put("tmx", localnode.getTextContent().toString());
                            break;
                        case "tmn":
                            data.put("tmn", localnode.getTextContent().toString());
                            break;
                        case "wfKor":
                            data.put("wfKor", localnode.getTextContent().toString());
                            break;
                        case "wfEn":
                            data.put("wfEn", localnode.getTextContent().toString());
                            break;
                        case "pop":
                            data.put("pop", localnode.getTextContent().toString());
                            break;
                        case "ws":
                            data.put("ws", localnode.getTextContent().toString());
                            break;
                        case "wd":
                            data.put("wd", localnode.getTextContent().toString());
                            break;
                        case "wdKor":
                            data.put("wdKor", localnode.getTextContent().toString());
                            break;
                        case "wdEn":
                            data.put("wdEn", localnode.getTextContent().toString());
                            break;
                        case "reh":
                            data.put("reh", localnode.getTextContent().toString());
                            list.add(data);
                            break;
                    }
                }
            }
        }catch (Exception e){

        }
        System.out.println(list);
    }
    public void Map2Produce(Element element){
        try{
            NodeList list = element.getElementsByTagName("data");
            NodeList GangjuNode;
            Map<String,Object> Citymap = new HashMap<>();
            for(int i = 1;i<=12;i++){
                if(i == 10 || i == 11 || i == 12){
                    for (Node Citynode = list.item(i).getFirstChild(); Citynode != null; Citynode = Citynode.getNextSibling()) {
                        switch (Citynode.getNodeName().toString()) {
                            case "tmEf":
                                Citydata = new HashMap<>();
                                Citydata.put("tmEf", Citynode.getTextContent().toString());
                                break;
                            case "wf":
                                Citydata.put("wfKor", Citynode.getTextContent().toString());
                                break;
                            case "tmn":
                                Citydata.put("tmn", Citynode.getTextContent().toString());
                                break;
                            case "tmx":
                                Citydata.put("tmx", Citynode.getTextContent().toString());
                                Citylist.add(Citydata);
                                break;
                        }
                    }
                }
                else if(i%2 !=0){
                    for (Node Citynode = list.item(i-1).getFirstChild(); Citynode != null; Citynode = Citynode.getNextSibling()) {
                        switch (Citynode.getNodeName().toString()) {
                            case "tmEf":
                                Citydata = new HashMap<>();
                                Citydata.put("tmEf", Citynode.getTextContent().toString());
                                break;
                            case "wf":
                                Citydata.put("wfKor", Citynode.getTextContent().toString());
                                break;
                            case "tmn":
                                Citydata.put("tmn", Citynode.getTextContent().toString());
                                break;
                            case "tmx":
                                Citydata.put("tmx", Citynode.getTextContent().toString());
                                Citylist.add(Citydata);
                                break;
                        }
                    }
                }
            }
            System.out.println("Citylist = "+Citylist);
        }catch (Exception e){

        }


    }
    public Map<String, Object> getData() {
        return data;
    }
    public List<Map<String, Object>> getList() {
        return list;
    }
    public List<Map<String, Object>> getCitylist() {
        return Citylist;
    }

}
