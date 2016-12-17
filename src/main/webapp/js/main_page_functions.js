$(function () {
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
});
