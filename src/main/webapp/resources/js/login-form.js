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
                console.log(result);
                showError(result.errors);
            },
            function(result) {
                console.log("error");
                console.log(result);
            }
        );
    });

});

