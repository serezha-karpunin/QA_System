$(function () {
    $('#call_login_menu_button').click(function () {
        $('#login_menu').toggle();
        $('#auth_menu_arrow').toggle();
    });

    $('#unauth_header_login_form').submit(function () {
        console.log("listener in header")
        if ($('#unauth_header_email_field').val() != '' && $('#unauth_header_password_field') != '') {
            console.log("gogogog");
            $.post(
                $(this).attr('action'),
                $(this).serialize()
            );
        } else {
            return false;
        }
    });

    $('#login_page_login_form').submit(function () {
        if ($('#login_page_email_field').val() !== '' && $('#login_page_password_field') !== '') {
            $.post(
                $(this).attr('action'),
                $(this).serialize()
            );
        } else {
            return false;
        }

    });

    $('#auth_header_call_options_menu_button').click(function () {
        $('#options_menu').toggle();
        $('#options_menu_arrow').toggle();
    });
});