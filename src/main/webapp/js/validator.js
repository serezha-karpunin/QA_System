function checkEmailField() {

    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!re.test(document.getElementById("email_field").value)){
        document.getElementById("email_field").style.borderColor = 'red';
    }else{
        document.getElementById("email_field").style.borderColor = '#abb2e1';
    }
}
