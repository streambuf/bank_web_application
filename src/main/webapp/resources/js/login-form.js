$('.switch').click(function(){
   $(this).children('i').toggleClass('fa-pencil');
   $('.login').animate({height: "toggle", opacity: "toggle"}, "slow");
   $('.register').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$(function() {
    $("#register").submit(function(e) {
        e.preventDefault();
        sendPost($(this).attr('action'),
            function(result) {
                alert(result);
            },
            function(result) {
                alert(result);
            }
        );
    });

});