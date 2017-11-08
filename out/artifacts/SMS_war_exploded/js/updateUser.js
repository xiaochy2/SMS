/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2017-04-02 21:31:18
 * @version $Id$
 */
//update users
$(function(){
    $('#updateUser').click(function(){
        if($(".resultsTable input[type=checkbox]").is(":checked")==false){
            alert("Please choose one record!");
        }
        else{
            $('.theme-popover-mask').fadeIn(100);
            $('.updateMsg-popover').slideDown(200);
        }
        var checkedRow=$(".resultsTable input[type=checkbox]:checked").parents("tr");
        var checkedUserId=checkedRow.find(".tdUsrId").html();
        var checkedUserName=checkedRow.find(".tdUsrName").html();
        var checkedPassword=checkedRow.find(".tdPwd").html();
        var checkedRole=checkedRow.find(".tdRole").html();
        var checkedRoleId=checkedRow.find(".tdRoleId").html();

        $('#userId').val(checkedUserId);
        $('#updateuserName').val(checkedUserName);
        $('#updatepassword').val(checkedPassword);
        $('#updaterole').val(checkedRole);
        $('#updateroleId').val(checkedRoleId);
    });
    $('.updateMsg-popover .theme-poptit .popclose,#updatemsgCancel').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.updateMsg-popover').slideUp(200);
        $('#updateForm')[0].reset();
        $('#updateForm')[1].reset();
        $('#updateForm')[2].reset();
        $('#updateForm')[3].reset();
    });
})
 
