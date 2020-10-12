
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.example.SmartWindow.XmlParse" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.SmartWindow.WeekWeather" %>
<%@ page import="java.lang.ref.WeakReference" %>
<%@ page import="com.example.SmartWindow.WeatherIcon" %>
<%
    XmlParse xmlParse = new XmlParse("2920051500");
    XmlParse CityPars = new XmlParse("156");
    WeekWeather weekWeather = new WeekWeather("2920051500");
    WeatherIcon weatherIcon = new WeatherIcon();
    Map<String, Object> Icon = new HashMap<>();
%>

<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset= utf-8">
    <meta name = "viewport" content="width = device-width" initial-scale = "1">
    <meta http-equiv="refresh" content="3600">
    <link rel = "stylesheet" href = "css/bootstrap.css">
    <script src="https://code.jquery.com/jquery-3.1.0.js"></script>
    <script src = "js/bootstrap.js"></script>
    <link rel = "stylesheet" href = "css/home2.css">
    <link rel="stylesheet" href="css/swiper.min.css">
    <script>

        function AddClass(addclass){
            var element = document.getElementById("body");
            element.classList.add(addclass);
        }

    </script>
</head>
<body id = "body">
<div class = "col-md-12 col-xs-12 col-sm-12">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <div class = "col-md-12 col-xs-12 col-sm-12">
                    <div class = "row">
                        <div class = "col-sm-12 col-xs-12  col-md-12" id  = "marginPart">
                        </div>
                        <div class = "col-sm-12 col-xs-12 col-md-12">
                            <div class = "row">
                                <div class = "col-sm-12 col-xs-12 col-md-12">
                                    <div class = "row">
                                        <div class="col-xs-4 col-sm-4 col-md-4"></div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <%
                                                String temp = xmlParse.getList().get(1).get("temp").toString();
                                                String[] str = temp.split("");
                                                String tmp = str[0]+str[1];
                                            %>
                                            <h1 id = "temp"><%=tmp%></h1>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4">
                                            <h1 id = "tempIcon">˚</h1>
                                        </div>
                                    </div>
                                </div>
                                <div class = "col-sm-12 col-xs-12 col-md-12">
                                    <div class="row">
                                        <div class="col-xs-3 col-sm-3 col-md-3">
                                        </div>
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <h1 id = "xmKor"><%=xmlParse.getList().get(1).get("wfKor")%></h1>
                                        </div>
                                        <div class="col-xs-3 col-sm-3 col-md-3">
                                        </div>
                                    </div>
                                </div>
                                <div class = "col-sm-12 col-xs-12 col-md-12">
                                    <div class="row">
                                        <div class="col-xs-3 col-sm-3 col-md-3">
                                        </div>
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <%
                                                weatherIcon.setWeater(xmlParse.getList().get(1).get("wfEn").toString());
                                                Icon = weatherIcon.ProductIcon();
                                            %>
                                            <img src="<%=Icon.get("imgName")%>" id = "weatherIcon">
                                            <script>AddClass("<%=Icon.get("className")%>")</script>

                                        </div>
                                        <div class="col-xs-3 col-sm-3 col-md-3">
                                        </div>
                                    </div>
                                </div>
                                <div class = "col-sm-12 col-xs-12 col-md-12">
                                    <hr id = "Line">
                                </div>
                                <div class = "col-sm-12 col-xs-12 col-md-12">
                                    <div class="row">
                                        <div class = "col-sm-12 col-xs-12 col-md-12">
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <p id = "Minifont1">오늘</p>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <p id = "Minifont2">내일</p>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <p id = "Minifont3">모레</p>
                                            </div>
                                        </div>
                                        <div class = "col-sm-12 col-xs-12 col-md-12">
                                            <div class="col-xs-3 col-sm-3 col-md-3">
                                                <%
                                                    weatherIcon.setWeater(weekWeather.getWeekList().get(0).get("wfEn").toString());
                                                    Icon = weatherIcon.ProductIcon();
                                                %>
                                                <img src="<%=Icon.get("imgName")%>" id = "weatherIcon1">
                                            </div>
                                            <div class="col-xs-3 col-sm-3 col-md-3">
                                                <%
                                                    weatherIcon.setWeater(weekWeather.getWeekList().get(1).get("wfEn").toString());
                                                    Icon = weatherIcon.ProductIcon();
                                                %>
                                                <img src="<%=Icon.get("imgName")%>" id = "weatherIcon2">
                                            </div>
                                            <div class="col-xs-3 col-sm-3 col-md-3">
                                                <%
                                                    weatherIcon.setWeater(CityPars.getCitylist().get(0).get("wfKor").toString());
                                                    Icon = weatherIcon.ProductIcon();
                                                %>
                                                <img src="<%=Icon.get("imgName")%>" id = "weatherIcon3">
                                            </div>
                                        </div>
                                        <div class = "col-sm-12 col-xs-12 col-md-12">
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <p id = "tempFont1">
                                                    <%
                                                        temp = xmlParse.getList().get(1).get("temp").toString();
                                                        str = temp.split("");
                                                        tmp = str[0]+str[1];
                                                    %><%=tmp%>˚</p>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <p id = "tempFont2">
                                                    <%
                                                        temp = xmlParse.getList().get(1).get("temp").toString();
                                                        str = temp.split("");
                                                        tmp = str[0]+str[1];
                                                    %><%=tmp%>˚</p>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4">
                                                <p id = "tempFont3"><%=CityPars.getCitylist().get(0).get("tmx").toString()%>˚</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="swiper-slide">
                <div class = "col-md-12 col-xs-12 col-sm-12">
                <jsp:include page="today.jsp" flush="false" />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/swiper.min.js"></script>
<script>
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        parallax: true,
        speed: 600,
    });
</script>
</html>