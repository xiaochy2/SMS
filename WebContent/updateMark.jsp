<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Mark</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="commonUI.jsp" />
<div class="g-content">
    <h2 class="content-title">Update Mark</h2>
    <div class="opeBtns">
        <a href="#" id="addMark">Add</a>
        <a href="deleteMark.action" id="delMark">Delete</a>
        <a href="#" id="updateMark">Update</a>
    </div>
    <div class="NumMark">
        <i>You have <b><% out.println(request.getAttribute("NumOfUnmark")); %></b>unmarked students!</i>
        <br>
        <i>You have <b><% out.println(request.getAttribute("NumOfMarked")); %></b>marked students!</i>
    </div>
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
                <td><input type="checkbox" value=${mark.stuName}></td>
                <td hidden class="tdMarkId">${mark.id}</td>
                <td class="tdStuId">${mark.stuId}</td>
                <td class="tdStuName">${mark.stuName}</td>
                <td class="tdEnglish">${mark.markEng}</td>
                <td class="tdMath">${mark.markMath}</td>
                <td class="tdPhysics">${mark.markPhy}</td>
                <td>${mark.state}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="addMsg-popover theme-popover">
        <div class="theme-poptit">
            <a href="javascript:void(0);" title="关闭" class="popclose"><i class="fa fa-times fa-2x"></i></a>
            <h3>Add Mark</h3>
        </div>
        <div class="theme-popbod dform m-pop">
            <form action="addMark.action" method="post" id="msgForm">
                <div class="msgInp">
                    <label for="studentId">StudentID</label>
                    <input type="text" id="studentId" name="studentId" placeholder="StudentID" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="studentName">StudentName</label>
                    <input type="text" id="studentName" name="studentName" placeholder="StudentName" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="english">English</label>
                    <input type="text" id="english" name="english" placeholder="English" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="math">Math</label>
                    <input type="text" id="math" name="math" placeholder="Math" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="physics">Physics</label>
                    <input type="text" id="physics" name="physics" placeholder="physics" required="required" maxlength="50">
                </div>
                <div class="msgBtns">
                    <button type="submit" id="msgSub" class="subBtn">Submit</button>
                    <button type="button" id="msgCancel" class="cancelBtn">Cancel</button>
                </div>
            </form>
        </div>
    </div>
    <div class="updateMsg-popover theme-popover">
        <div class="theme-poptit">
            <a href="javascript:void(0);" title="关闭" class="popclose"><i class="fa fa-times fa-2x"></i></a>
            <h3>Update Mark</h3>
        </div>
        <div class="theme-popbod dform m-pop">
            <form action="updateMarkGrade.action" method="post" id="updateForm">
                <div class="msgInp" hidden>
                    <label for="markId">MarkId</label>
                    <input type="text" id="markId" name="markId" placeholder="markId" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="studentId">StudentID</label>
                    <input type="text" id="updatestudentId" name="studentId" placeholder="StudentID" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="studentName">StudentName</label>
                    <input type="text" id="updatestudentName" name="studentName" placeholder="StudentName" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="english">English</label>
                    <input type="text" id="updateenglish" name="english" placeholder="English" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="math">Math</label>
                    <input type="text" id="updatemath" name="math" placeholder="Math" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="physics">Physics</label>
                    <input type="text" id="updatephysics" name="physics" placeholder="physics" required="required" maxlength="50">
                </div>
                <div class="msgBtns">
                    <button type="submit" id="updatemsgSub" class="subBtn">Submit</button>
                    <button type="button" id="updatemsgCancel" class="cancelBtn">Cancel</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/addMark.js"></script>
    <script type="text/javascript" src="js/updateMark.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#delMark").click(function(){
//                var checkedUserName = [];
//                $.each($("input[type=checkbox]:checked"), function(){
//                    checkedUserName.push($(this).val());
//                });
                if($(".resultsTable input[type=checkbox]").is(":checked")==false){
                    alert("Please choose one record!");
                    $(this).href="#";
                }
                var checkedStuName=$(".resultsTable input[type=checkbox]:checked").val();
                $.ajax({
                    type: "POST",
                    url: "deleteMark.action",
                    data:{
                        stuName: checkedStuName,
                    },
                    dataType: "json"
                });
            });
        })
    </script>
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