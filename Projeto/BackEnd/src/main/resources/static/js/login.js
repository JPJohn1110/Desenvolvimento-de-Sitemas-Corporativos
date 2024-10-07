const sEmail = document.querySelector('#email');
const sSenha = document.querySelector('#senha');
const btnSignup = document.querySelector('#btnlogin');
const url = 'http://localhost:8080/login';

btnSignup.onclick = e => {
    e.preventDefault();

    const login = {
        email: sEmail.value,
        senha: sSenha.value
    };

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(login)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao realizar o login');
        }
        return response.text();
    })
    .then(data => {
        sessionStorage.setItem('token', data);
        acessar();
    })

}

function acessar(){
    const token = sessionStorage.getItem('token');
    console.log(token)
    fetch('/index', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}` // Envia o token no cabeçalho
        }
    })
    .then(response => {
        if (response.ok) {
            return response.text(); // ou response.json(), dependendo do que você precisa
        } else {
            throw new Error('Você não tem autorização para acessar esta página.');
        }
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Erro:', error);
        //window.location.href = '/login';
    });
}