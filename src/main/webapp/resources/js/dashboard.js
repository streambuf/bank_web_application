$(function(){
    var li_num = document.getElementById('meta.page.li.num').value;
    $($(".sidebar-menu > li")[li_num]).addClass("active");
});
