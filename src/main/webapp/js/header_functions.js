$(function () {
    $('#call_login_menu_button').click(function () {
        $('#login_menu').toggle();
        $('#auth_menu_arrow').toggle();
    });

    $('#unauth_header_login_form').submit(function () {
        if ($('#unauth_header_email_field').val() == '' || $('#unauth_header_password_field').val() == '') {
            return false;
        }
    });


    $('#auth_header_call_options_menu_button').click(function () {
        $('#options_menu').toggle();
        $('#options_menu_arrow').toggle();
    });

    $('#question_form').submit(function () {
        if ($('#question_form_title_field').val() == '' && $('#question_form_text_area').val() == '') {
            $('#question_form_error_message').show();
            return false;
        }
    });

    $('#auth_header_ask_question_button').click(function () {
        $('#mask').show();
        $('#question_form_wrapper').show();
    });

    $('#question_form_close_button').click(function () {
        $('#mask').hide();
        $('#question_form_wrapper').hide();
    })
});