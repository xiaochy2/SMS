/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2017-04-02 21:31:18
 * @version $Id$
 */
//update marks
$(function(){
    $('#updateMark').click(function(){
        if($(".resultsTable input[type=checkbox]").is(":checked")==false){
            alert("Please choose one record!");
        }
        else{
            $('.theme-popover-mask').fadeIn(100);
            $('.updateMsg-popover').slideDown(200);
        }
        var checkedRow=$(".resultsTable input[type=checkbox]:checked").parents("tr");
        var checkedMarkId=checkedRow.find(".tdMarkId").html();
        var checkedStuId=checkedRow.find(".tdStuId").html();
        var checkedStuName=checkedRow.find(".tdStuName").html();
        var checkedEnglish=checkedRow.find(".tdEnglish").html();
        var checkedMath=checkedRow.find(".tdMath").html();
        var checkedPhysics=checkedRow.find(".tdPhysics").html();

        $('#markId').val(checkedMarkId);
        $('#updatestudentId').val(checkedStuId);
        $('#updatestudentName').val(checkedStuName);
        $('#updateenglish').val(checkedEnglish);
        $('#updatemath').val(checkedMath);
        $('#updatephysics').val(checkedPhysics);
    });
    $('.updateMsg-popover .theme-poptit .popclose,#updatemsgCancel').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.updateMsg-popover').slideUp(200);
        $('#updateForm')[0].reset();
        $('#updateForm')[1].reset();
        $('#updateForm')[2].reset();
        $('#updateForm')[3].reset();
        $('#updateForm')[4].reset();
        $('#updateForm')[5].reset();
    });
})
 
