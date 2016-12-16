$(function () {
    // $('#tab_last').toggle();
    $('#tab_last').prop('checked', true);
    $('#last_content').show();

    $('#tab_last').change(function () {
        $('#page_wrapper').find('section').hide();
        $('#last_content').toggle();
    });
    $('#tab_interest').change(function () {
        $('#page_wrapper').find('section').hide();
        $('#interesting_content').toggle();
    });
    // $('#tab_sub').change(function () {
    //     $('#page_wrapper').find('section').hide();
    //     $('#subscription_content').toggle();
    // });

    $('#login_page_login_form').submit(function () {
        if ($('#login_page_email_field').val() !== '' && $('#login_page_password_field') !== '') {
            // $.post(
            //     $(this).attr('action'),
            //     $(this).serialize()
            // );
        } else {
            return false;
        }

    });
    
    $('#answers_area').ready(function () {
        $.ajax({
            type: "POST",
            url: "/load_answers",
            success: function(data){
                $('#answers_area').html(data);
            }

        });
    });

    $('#post_answer_button').click(function () {
        var text = $('#answer_text_field').val();
        if(text !==''){
            $.ajax({
                type: "POST",
                url: "/add_answer",
                data: {"text": text},
                success: function(data){
                    $('#answers_area').html(data);
                    $('#answer_text_field').val('');
                }
            });
        }
    });
});
