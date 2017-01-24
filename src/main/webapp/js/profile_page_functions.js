$(function () {
    $('#tab_questions').prop('checked', true);
    $('#questions_content').show();

    $('#tab_questions').change(function () {
        $('#page_wrapper').find('section').hide();
        $('#questions_content').toggle();
    });

    $('#tab_answers').change(function () {
        $('#page_wrapper').find('section').hide();
        $('#answers_content').toggle();
    });
    addLikeListeners();
    addDeleteAnswerListeners();
});