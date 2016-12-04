function checkEmailField() {

    //
    // if (!re.test(document.getElementById("email_field").value)){
    //     document.getElementById("email_field").style.borderColor = 'red';
    // }else{
    //     document.getElementById("email_field").style.borderColor = '#abb2e1';
    // }
}

$(function () {
    $('#email_field').change(function () {
        var email_regex  = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        var email = $('#email_field').val();

        $('#registration_form').find('.email_errors').hide();

        if(email === '') {
            $('#email_missing_error').show();
            return;
        }

        if(!email_regex.test(email)){
            $('#email_not_valid_error').show();
            return;
        }


        $.ajax({
            url: "/check_email",
            type: "POST",
            data: {"email": email},
            success: function (data) {
                if(data){
                    $('#email_already_used_error').show();
                }
            }
        });
    });

    $('#loqin_field').change(function () {
        var login = $('#login_field').val();

        var login_error_text;
        var $login_error_wrapper = $('#error_email');

        var password = $('#password_field').val();
        var confirm_password = $('#confirm_password_field').val();
    });



});
