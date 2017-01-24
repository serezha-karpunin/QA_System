$(function () {
    $('#call_login_menu_button').click(function () {
        $('#login_menu').fadeToggle(200);
        $('#auth_menu_arrow').fadeToggle(200);
    });

    $('#unauth_header_login_form').submit(function () {
        if ($('#unauth_header_email_field').val() == '' || $('#unauth_header_password_field').val() == '') {
            $('#unauth_header_missing_fields_error').show();
            return false;
        }
    });


    $('#auth_header_call_options_menu_button').click(function () {
        $('#options_menu').fadeToggle(200);
        $('#options_menu_arrow').fadeToggle(200);
    });

    $('#question_form').submit(function () {
        if ($('#question_form_title_field').val() == '' || $('#question_form_text_area').val() == '') {
            $('#question_form_error_message').show();
            return false;
        }
    });

    $('#auth_header_ask_question_button').click(function () {
        $('#mask').fadeIn(250);
        $('#question_form_wrapper').fadeIn(250);
    });

    $('#question_form_close_button').click(function () {
        $('#mask').fadeOut(250);
        $('#question_form_wrapper').fadeOut(250);
    });

    $("#search_box_form").submit(function(e){
        if($('#search_box').val()==''){
            e.preventDefault();
        }
    });

    $(".tags button").click(function () {
        $("#search_box").val($(this).val());
        $('#search_box_form').submit();
    });

    $('.delete_question_button').click(function () {
        $('#mask').fadeIn(250);
        $('#confirm_question_deletion_form_wrapper').fadeIn(250);
        document.cookie = "id_question_to_delete=" + $(this).val() + "; path=/;";
    });


    $('.confirm_deletion_close_button').click(function () {
        $('#mask').fadeOut(250);
        $('#confirm_question_deletion_form_wrapper').fadeOut(250);
        $('#confirm_answer_deletion_form_wrapper').fadeOut(250);
        delete_cookie("id_answer_to_delete");
        delete_cookie("id_question_to_delete");
    })
});

function delete_cookie ( cookie_name )
{
    var cookie_date = new Date ( );  // Текущая дата и время
    cookie_date.setTime ( cookie_date.getTime() - 1 );
    document.cookie = cookie_name + "=; expires=" + cookie_date.toGMTString() + "; path=/;";
}

function get_cookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}