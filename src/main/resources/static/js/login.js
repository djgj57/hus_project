window.addEventListener("load", function () {


    let $ = item => document.querySelector(item);
    $('#formLogin').addEventListener('submit', validarLogin);

    function validarLogin(event) {
        event.preventDefault();
        console.log("iniciando validacion...")
        let datos = {
            username: $('#login').value,
            password: $('#password').value
        }

        fetch('http://localhost:8080/api/login', {
            method: 'POST',
            body: new URLSearchParams(datos),
        })
            .then(function (response) {
                if (response.ok)
                    return response.json()
                else
                    throw new Error(response.status)
            })
            .then(function (data) {
                // sessionStorage.setItem('dataUser', JSON.stringify(data))
                console.log(data)
                console.log('puede direccionar a otra pagina')
            })
            .catch(function (error) {
                console.log('Hubo un problema con la petición Fetch:' + error.message)
            });
    }
})

