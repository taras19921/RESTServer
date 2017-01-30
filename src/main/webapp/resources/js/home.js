

jQuery(document).ready(function ($) {
    $('#tasks-select').change(function() {
        var taskId = $("#tasks-select option:selected").val();
        if (taskId == 0) {
            window.location.href = "/rest-server/task0";
        }
    });
});