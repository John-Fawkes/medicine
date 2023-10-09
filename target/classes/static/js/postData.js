function postData() {
    const form = document.getElementById('myForm');
    // const email = document.getElementById("email").value;
    // const password = document.getElementById("password").value;
    // const loginPersonData= {
    //     email: email,
    //     password: password
    // }
    // document.getElementById("myForm").addEventListener("submit", function (event) {
    //     var emailErrors = document.querySelector('[name="email"] + span');
    //     var passwordErrors = document.querySelector('[name="password"] + span');
    //
    //     if (emailErrors.textContent !== "" || passwordErrors.textContent !== "") {
    //         var errorData={
    //             hasError:true
    //         }
    //         fetch('/login', {
    //             method: 'POST',
    //             headers: {
    //                 'Content-Type': 'application/json'
    //             },
    //             body: JSON.stringify(loginPersonData)
    //         })
    form.submit();
        }
