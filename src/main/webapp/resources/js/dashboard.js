$(function(){
    var li_num = document.getElementById('meta.page.li.num').value;
    $($(".sidebar-menu > li")[li_num]).addClass("active");

});


$(function() {
    $(".operation").submit(function(e) {
        e.preventDefault();
        hideAndEmptyErrors(".error");
        sendPost($(this),
            function(result) {
                console.log("OK");
                $(".operation .box-body .form-group").hide();
                $(".box-footer").hide();
                var suc = $(".callout-success").show();
                suc.find("h4").empty().append(result.data.message);
            },
            function(result) {
                console.log("error");
                showError(result.data);
            }
        );
    });

    $("#accountPayee").mask("9999999999999999999");

});

