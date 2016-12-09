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
    $('#tab_sub').change(function () {
        $('#page_wrapper').find('section').hide();
        $('#subscription_content').toggle();
    });
});