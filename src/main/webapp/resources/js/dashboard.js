$(function(){

    var li_num = document.getElementById('meta.page.li.num').value;
    $($(".sidebar-menu > li")[li_num]).addClass("active");

    var tree_li_num = document.getElementById('meta.page.tree.li.num')
    if (tree_li_num) $($($(".sidebar-menu > li")[6]).find("li")[tree_li_num.value]).addClass("active")


    $("input[type=number]");

});

$(document).on('input', '[type="number"]', function () {
    var $item = $(this),
    value = $item.val();
    if (value.indexOf(".") != '-1') {
        $item.val(value.substring(0, value.indexOf(".") + 3));
    }
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

    $(".delete").submit(function(e) {
        e.preventDefault();
        var form = $(this);
        sendPost($(this),
            function(result) {
                console.log("OK");
                if (result.data.delete == "OK") {
                    $(form).parents("tr").hide();
                }
            },
            function(result) {
                console.log("error");
                showError(result.data);
            }
        );
    });

    $("#accountPayee").mask("9999999999999999999");

});

