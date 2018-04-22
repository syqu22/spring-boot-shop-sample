//2018 - Aleksander Lejawa
function changeLanguage(lang){
    const currentUrl = window.location.href;
    window.history.pushState(null, null, window.location.pathname);
    window.location.replace(currentUrl + "?lang=" + lang);
}

$("#select-lang").change(function(){
    changeLanguage($(this).val());
});