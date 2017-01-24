$(function () {
    $('#login_page_login_form').submit(function () {
        if ($('#login_page_email_field').val() == '' || $('#login_page_password_field').val() == '') {
            return false;
        }
    });
});