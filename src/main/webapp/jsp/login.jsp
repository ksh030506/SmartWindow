<%@ page language="java" contentType="text/html; charset = utf-8" pageEncoding="utf-8"%>
<%@ page import="com.example.SmartWindow.JsonFileProduce" %>
<%
    JsonFileProduce jsonFileProduce = new JsonFileProduce();
    jsonFileProduce.Parsing("http://www.kma.go.kr/DFSROOT/POINT/DATA/top.json.txt");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset= utf-8">
    <meta name = "viewport" content="width = device-width" initial-scale = "1">
    <link rel = "stylesheet" href = "css/bootstrap.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src = "js/bootstrap.js"></script>
    </head>
    <body>
    <div class = "col-md-12 col-xs-12 col-lg-12">
        <div class="row">
            <div class = "col-md-12 col-xs-12 col-lg-12">
                <select class="form-control">
                    <div class = "option">
                    </div>
                </select>
            </div>
            <div class = "col-md-12 col-xs-12 col-lg-12">
                <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class = "col-md-12 col-xs-12 col-lg-12">
                <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
        </div>
    </div>
    </body>
<script>
</script>
</html>