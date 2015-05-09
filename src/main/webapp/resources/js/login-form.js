$('.switch').click(function(){
   $(this).children('i').toggleClass('fa-pencil');
   $('.login').animate({height: "toggle", opacity: "toggle"}, "slow");
   $('.register').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$(function() {
    $("#register").submit(function(e) {
        e.preventDefault();
        hideAndEmptyErrors(".error");
        sendPost($(this),
            function(result) {
                console.log("OK");
                $("#register").hide();
                $(".alert").empty().append(result.data.message);
            },
            function(result) {
                console.log("error");
                showError(result.data);
            }
        );
    });

});

