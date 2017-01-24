$(function () {
    var isEmailCorrect = function () {
        var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        var email = $('#registration_email_field').val();

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
    var isLoginCorrect = function () {
        var login_regex = /^[a-zA-Z0-9_-]{3,15}$/;
        var login = $('#registration_login_field').val();

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
    var isPasswordCorrect = function () {
        var password_regex = /^[a-zA-Z0-9_-]{3,16}$/;
        var password = $('#registration_password_field').val();

        $('#registration_form').find('.password_errors').hide();

        if (password === '') {
            $('#password_missing_error').show();
            return false;
        }

        if (!password_regex.test(password)) {
            $('#password_not_valid_error').show();
            return false;
        }

        var confirm_password = $('#registration_confirm_password_field').val();
        if (confirm_password !== '' && confirm_password !== password) {
            $('#confirm_password_not_valid_error').show();
            return false;
        }

        return true;
    };
    var isConfirmPasswordCorrect = function () {
        var password = $('#registration_password_field').val();
        var confirm_password = $('#registration_confirm_password_field').val();

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

    checkErrors();


    // $('#registration_email_field').change(isEmailCorrect);
    // $('#registration_login_field').change(isLoginCorrect);
    // $('#registration_password_field').change(isPasswordCorrect);
    // $('#registration_confirm_password_field').change(isConfirmPasswordCorrect);
    //
    // $('#registration_form').submit(function () {
    //     if(isEmailCorrect()&isLoginCorrect()&isPasswordCorrect()&isConfirmPasswordCorrect()){
    //         // $.post(
    //         //     $(this).attr('action'),
    //         //     $(this).serialize()
    //         // );
    //     }
    //     else return false;
    //
    // });


});

function checkErrors() {
    if ($('#registration_form').is(':visible')) { //if the container is visible on the page

        if (typeof get_cookie("email_missing_error") != 'undefined') $('#email_missing_error').show();
        if (typeof get_cookie("email_not_valid_error") != 'undefined') $('#email_not_valid_error').show();
        if (typeof get_cookie("email_already_used_error") != 'undefined') $('#email_already_used_error').show();

        if (typeof get_cookie("login_missing_error") != 'undefined') $('#login_missing_error').show();
        if (typeof get_cookie("login_not_valid_error") != 'undefined') $('#login_not_valid_error').show();
        if (typeof get_cookie("login_already_used_error") != 'undefined') $('#login_already_used_error').show();

        if (typeof get_cookie("password_missing_error") != 'undefined') $('#password_missing_error').show();
        if (typeof get_cookie("password_not_valid_error") != 'undefined') $('#password_not_valid_error').show();

        if (typeof get_cookie("confirm_password_missing_error") != 'undefined') $('#confirm_password_missing_error').show();
        if (typeof get_cookie("confirm_password_not_valid_error") != 'undefined') $('#confirm_password_not_valid_error').show();

        clearErrorCookies();
    } else {
        setTimeout(checkErrors, 100); //wait 50 ms, then try again
    }
}

function clearErrorCookies() {
    var cookieArray = document.cookie.split(';');
    for (var j = 0; j < cookieArray.length; j++) {
        cookieArray[j] = cookieArray[j].replace(/(\s*)\B(\s*)/g, '');
        console.log(cookieArray[j]);
    }

    for (var i = 0; i < cookieArray.length; i++) {
        var keyValue = cookieArray[i].split('=');
        if(keyValue[0].indexOf("_error") !== -1){
            console.log("delete: "+ keyValue[0]);
            delete_cookie(keyValue[0]);
        }
    }
}

