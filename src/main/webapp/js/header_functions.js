$(function () {
    $('#call_login_menu_button').click(function () {
        $('#login_menu').toggle();
        $('.arrow-up').toggle();
    });

    $('#login_form').submit(function () {
        if($('#auth_email_field').val()!== '' && $('#auth_password_field')!=='') {
            $.post(
                $(this).attr('action'),
                $(this).serialize()
            );
        }
    })
});