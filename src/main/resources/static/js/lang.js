//2018 - Aleksander Lejawa
function changeLanguage(lang){
    window.history.pushState(null, null, window.location.pathname);

    var currentUrl = window.location.href;

    window.location.replace(currentUrl + "?lang=" + lang);
}

$("#select-lang").change(function(){
    changeLanguage($(this).val());
});