$(function(){
    var li_num = document.getElementById('meta.page.li.num').value;
    $($(".sidebar-menu > li")[li_num]).addClass("active");

});


$(function() {
    $(".operation").submit(function(e) {
        e.preventDefault();
        sendPost($(this),
            function(result) {
                console.log("OK");
                //$("#register").hide();
                //$(".alert").empty().append(result.data.message);
            },
            function(result) {
                console.log("error");
                //showError(result.data);
            }
        );
    });

});

