$(function () {
    checkAnswersTextArea();

    $('#post_answer_button').click(function () {
        var text = $('#answer_text_field').val();
        if (text !== '') {
            $.ajax({
                type: "POST",
                url: "/add_answer",
                data: {"text": text},
                success: function (data) {
                    $('#answers_area').html(data);
                    $('#answer_text_field').val('');
                    addLikeListeners();
                    addDeleteAnswerListeners();
                }
            });
        }
    });
});

function checkAnswersTextArea() {
    if($('#answers_area').is(':visible')){
        $.ajax({
                    type: "POST",
                    url: "/load_answers",
                    success: function (data) {
                        $('#answers_area').html(data);
                        addLikeListeners();
                        addDeleteAnswerListeners();
                    }

                })
    } else {
        setTimeout(checkAnswersTextArea, 100);
    }
}