$('.switch').click(function(){
   $(this).children('i').toggleClass('fa-pencil');
   $('.login').animate({height: "toggle", opacity: "toggle"}, "slow");
   $('.register').animate({height: "toggle", opacity: "toggle"}, "slow");
});