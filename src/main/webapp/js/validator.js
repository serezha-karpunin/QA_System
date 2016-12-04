$(function () {
    var isEmailCorrect = function () {
        var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        var email = $('#email_field').val();
        console.log("email checkin");

        $('#registration_form').find('.email_errors').hide();

        if (email === '') {
            // $(this).
            $('#email_missing_error').show();
            return false;
        }

        if (!email_regex.test(email)) {
            $('#email_not_valid_error').show();
            return false;
        }


        $.ajax({
            url: "/check_email",
            type: "POST",
            data: {"email": email},
            success: function (data) {
                if (data == "true") {
                    $('#email_already_used_error').show();
                    return false;
                }
            }
        });
        return true;
    };
    var isLoginCorrect =  function () {
        var login_regex = /^[a-zA-Z0-9_-]{3,16}$/;
        var login = $('#login_field').val();

        $('#registration_form').find('.login_errors').hide();

        if (login === '') {
            $('#login_missing_error').show();
            return false;
        }

        if (!login_regex.test(login)) {
            $('#login_not_valid_error').show();
            return false;
        }


        $.ajax({
            url: "/check_login",
            type: "POST",
            data: {"login": login},
            success: function (data) {
                if (data == "true") {
                    $('#login_already_used_error').show();
                    return false;
                }
            }
        });

        return true;
    };
    var isPasswordCorrect =  function () {
        console.log("pass checking");
        var password_regex = /^[a-zA-Z0-9_-]{3,16}$/;
        var password = $('#password_field').val();

        $('#registration_form').find('.password_errors').hide();

        if (password === '') {
            $('#password_missing_error').show();
            return false;
        }

        if (!password_regex.test(password)) {
            $('#password_not_valid_error').show();
            return false;
        }

        var confirm_password = $('#confirm_password_field').val();
        if (confirm_password !== '' && confirm_password !== password) {
            $('#confirm_password_not_valid_error').show();
            return false;
        }

        return true;
    };
    var  isConfirmPasswordCorrect = function() {
        var password = $('#password_field').val();
        var confirm_password = $('#confirm_password_field').val();

        $('#registration_form').find('.confirm_password_errors').hide();

        if (confirm_password === '') {
            $('#confirm_password_missing_error').show();
            return false;
        }

        if (confirm_password !== password) {
            $('#confirm_password_not_valid_error').show();
            return false;
        }
        return true;
    };


    $('#email_field').change(isEmailCorrect);
    $('#login_field').change(isLoginCorrect);
    $('#password_field').change(isPasswordCorrect);
    $('#confirm_password_field').change(isConfirmPasswordCorrect);

    $('#registration_form').submit(function () {
        if(isEmailCorrect()&isLoginCorrect()&isPasswordCorrect()&isConfirmPasswordCorrect()){
           console.log("all good");
            $.post(
                $(this).attr('action'),
                $(this).serialize()
            );
        }
        console.log("badd");
        return false;

    });


});
