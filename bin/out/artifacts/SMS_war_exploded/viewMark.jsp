<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Mark</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="commonUI.jsp" />
<div class="g-content">
    <h2 class="content-title">View Mark</h2>
    <form action="viewMark.action" class="searchBox">
        <label>StuName</label><input type="text" name="stuName" class="searchBoxInp">
        <div class="searchBoxCheck">
            <label>English</label><input type="checkbox" name="subject" value="english">
            <br>
            <label>Math</label><input type="checkbox" name="subject" value="math">
            <br>
            <label>Physics</label><input type="checkbox" name="subject" value="physics">
        </div>
        <input type="submit" value="search" class="searchBoxSub">
    </form>
    <div class="showGrade"><i>Grade:<% out.println(request.getAttribute("grade")); %></i></div>
    <table class="resultsTable sortable">
        <tr>
            <th></th>
            <th hidden>MarkId</th>
            <th>Student Id</th>
            <th>Student Name</th>
            <th>English</th>
            <th>Math</th>
            <th>Physics</th>
            <th>State</th>
        </tr>
        <c:forEach var="mark" items="${marks}">
            <tr>
                <td><input type="checkbox" value=${mark.id}></td>
                <td hidden class="tdMarkId">${mark.id}</td>
                <td>${mark.stuId}</td>
                <td>${mark.stuName}</td>
                <td>${mark.markEng}</td>
                <td>${mark.markMath}</td>
                <td>${mark.markPhy}</td>
                <td>${mark.state}</td>
            </tr>
        </c:forEach>
    </table>
    <div id="container" class="showGraph"></div>
    <script type="text/javascript">
        $(function() {
            var Eng=[];
            var Math=[];
            var Phy=[];
            var EngSum=0;
            var MathSum=0;
            var PhySum=0;
            var EngAve = 0;
            var MathAve = 0;
            var PhyAve = 0;

            $("tbody tr td:nth-child(5)").each(function(){
                Eng.push(parseInt($(this).text()));
            });
            $("tbody tr td:nth-child(6)").each(function(){
                Math.push(parseInt($(this).text()));
            });
            $("tbody tr td:nth-child(7)").each(function(){
                Phy.push(parseInt($(this).text()));
            });



            for(var i=0;i<Eng.length;i++){
                EngSum+=Eng[i];
                MathSum+=Math[i];
                PhySum+=Phy[i];
            }

            EngAve = EngSum/(Eng.length);
            MathAve = MathSum/(Eng.length);
            PhyAve = PhySum/(Eng.length);

            Highcharts.chart('container', {
                title: {
                    text: 'Student Mark Average'
                },
                chart: {
                    type: 'column'
                },
                xAxis: {
                    type: 'category'
                },
                yAxis: {
                    title: {
                        text: 'Number'
                    }
                },
                series: [{
                    name: 'Average',
                    colorByPoint: true,
                    data:[{
                        name: 'English',
                        y: EngAve
                    }, {
                        name: 'Math',
                        y: MathAve
                    }, {
                        name: 'Physics',
                        y: PhyAve
                    }]
                }]
            })
        })
    </script>
</div>
</body>
</html>