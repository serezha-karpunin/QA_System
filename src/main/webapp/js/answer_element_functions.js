function addDeleteAnswerListeners(){
    $('.delete_answer_button').click(function () {
        $('#mask').fadeIn(250);
        $('#confirm_answer_deletion_form_wrapper').fadeIn(250);
        document.cookie = "id_answer_to_delete=" + $(this).val() + "; path=/;";
    });
}

function addLikeListeners() {
    var unpressed = $('.unpressed_like_answer_button');
    unpressed.off('click');
    unpressed.click(unpressedListener);

    var pressed = $('.pressed_like_answer_button');
    pressed.off('click');
    pressed.click(pressedListener);
}

var unpressedListener = function(){
    $.ajax({
        type: "POST",
        url: "/toggle_like",
        data: {
            "idAnswer": $(this).val(),
            "addLike": true
        },
        success: function () {
        }
    });
    var p = $(this).closest('div').children('p');
    p.html(parseInt(p.html())+1);
    $(this).toggleClass('pressed_like_answer_button unpressed_like_answer_button');
    $(this).off('click');
    $(this).click(pressedListener);
};

var pressedListener = function() {
    $.ajax({
        type: "POST",
        url: "/toggle_like",
        data: {
            "idAnswer": $(this).val(),
            "addLike": false
        },
        success: function () {
        }
    });
    var p = $(this).closest('div').children('p');
    p.html(parseInt(p.html()) - 1);
    $(this).toggleClass('pressed_like_answer_button unpressed_like_answer_button');
    $(this).off('click');
    $(this).click(unpressedListener);
};