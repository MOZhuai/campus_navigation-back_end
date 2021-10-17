function storeUser(phone, password) {
    var ajaxObj = new XMLHttpRequest();
    ajaxObj.open('post', 'user/login');
    ajaxObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajaxObj.send('phone='+phone+'&password='+password);
    ajaxObj.onreadystatechange = function () {
        if (ajaxObj.readyState == 4 && ajaxObj.status == 200) {
            alert(ajaxObj.responseText);
        }
    };
    // sessionStorage.clear()
    // $.ajax({
    //     url:"user/login",
    //     data:{
    //         "phone":phone,
    //         "password":password
    //     },
    //     type:"POST",
    //     success:function (result) {
    //         alert("hello");
    //     }
    // });
    // sessionStorage.setItem("phone", phone);
    // sessionStorage.setItem("password", password);
}

function checkLogin() {

}