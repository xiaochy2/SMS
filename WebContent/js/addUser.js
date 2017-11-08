/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2017-04-02 21:31:18
 * @version $Id$
 */
//新增msg
$(function(){
    $('#addUser').click(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.addMsg-popover').slideDown(200);
    })
    $('.addMsg-popover .theme-poptit .popclose,#msgCancel').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.addMsg-popover').slideUp(200);
        $('#msgForm')[0].reset();
        $('#msgForm')[1].reset();
        $('#msgForm')[2].reset();
        $('#msgForm')[3].reset();

    });
})
 
