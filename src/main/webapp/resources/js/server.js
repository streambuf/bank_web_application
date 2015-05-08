$(function () {
    var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

function sendPost(url, callSuccess, callError) {
    var data = $(this).serializeForm();

    // TODO delete log in production
    console.log("Json data for server")
    console.log(data);

    $.ajax({
        'type': 'POST',
        'url': url,
        'contentType': 'application/json',
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function(result) {
            if (result.status=="OK") {
                console.log("sendPost: OK");
                callSuccess(result);
            } else {
                console.log("sendPost: ERROR")
                callError(result);
            }
        },
        'error': function(result) {
            console.log("sendPost: Server Fail");
            // TODO delete alert in production
            alert("sendPost: Server Fail")
        }
    });
}

$.fn.serializeForm = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};