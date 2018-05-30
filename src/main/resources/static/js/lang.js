function changeLanguage(lang) {
    let currentUrl = window.location.toString();
    let cleanUrl = currentUrl.split("?")[0];

    window.history.replace({}, window.title, cleanUrl + "?lang=" + lang);
}

$("#select-lang").change(function(){
    changeLanguage($(this).val());
});