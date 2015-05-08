function hideAndEmptyErrors(locator) {
    $(locator).each(function() {
        $(this).hide().empty();
    });
}

function showError(errors) {
    for (var key in errors) {
        $("input[name="+key+"]").prev().append(errors[key]).show();
    }
}