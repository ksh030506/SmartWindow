
<%@ page language="java" contentType="text/html; charset = utf-8" pageEncoding="utf-8"%>
<%@ page import="com.example.SmartWindow.JsonFileProduce" %>
<%@ page import="java.util.Calendar" %>
<%
    Calendar time = Calendar.getInstance();
    int mon = time.get(Calendar.MONTH)+1;
    int day = time.get(Calendar.DATE);
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset= utf-8">
    <meta name = "viewport" content="width = device-width", initial-scale = "1">
    <link rel = "stylesheet" href = "css/bootstrap.css">
    <link rel = "stylesheet" href = "css/today.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src = "js/bootstrap.js"></script>
</head>
<body>
<div class="row">
    <div class="col-sm-12 col-xs-12 col-md-12" id = "">
        <div class = "row">
            <div class="col-sm-12 col-xs-12 col-md-12">
                <h1 id = "TodayText"><%=mon%>월 <%=day%>일</h1>
            </div>
            <div class="col-sm-12 col-xs-12 col-md-12">
                <p id = "NomeanText">환기 시키기 적절한 시간은?</p>
            </div>
        </div>
    </div>
    <div class="col-sm-12 col-xs-12 col-md-12" id = "MarginLine1">
    </div>
    <div class="col-sm-12 col-xs-12 col-md-12">
        <div class="row">
            <div class = "col-sm-1 col-xs-1 col-md-1">
            </div>
            <div class = "col-sm-2 col-xs-2 col-md-2" id = "circleDiv">
                <div class = "circle1">
                </div>
                <hr class = "CircleHr">
                <div class = "circle2">
                </div>
            </div>
            <div class = "col-sm-6 col-xs-6 col-md-6" id = "Windowtime">
                <div class="col-sm-12 col-xs-12 col-md-12">
                    <p id = "Am">오전</p>
                </div>
                <div class="col-sm-12 col-xs-12 col-md-12">
                    <h1 id = "time1">10:30 </h1>
                </div>
                <div class="col-sm-12 col-xs-12 col-md-12">
                    <p id = "Pm">오후</p>
                </div>
                <div class="col-sm-12 col-xs-12 col-md-12">
                    <h1 id = "time2">7:25</h1>
                </div>
            </div>
            <div class = "col-sm-3 col-xs-3 col-md-3">
                <div class="col-sm-12 col-xs-12 col-md-12">
                </div>
                <div class="col-sm-12 col-xs-12 col-md-12">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>