$(function () {
    $('#login_page_login_form').submit(function () {
        console.log("checking");
        // console.log("email: " + $('#login_page_email_field').val());
        // console.log("pass: " + $('#login_page_email_field').val());
        if ($('#login_page_email_field').val() == '' || $('#login_page_password_field').val() == '') {
            return false;
        }
    });
});