const sEmail = document.querySelector('#email');
const sSenha = document.querySelector('#senha');
const btnSignup = document.querySelector('#btnlogin');
const url = 'http://localhost:8080/login';
let token = localStorage.getItem('token');

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
            return response.json();
        })
        .then(data => {
            const token = data.token;
            localStorage.setItem('token', token);
            validateAndRedirect();
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}

function parseJwt(token) {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}

function isTokenExpired(token) {
    const decodedToken = parseJwt(token);
    const currentTime = Math.floor(Date.now() / 1000);
    return decodedToken.exp < currentTime;
}

function validateAndRedirect() {
    const token = localStorage.getItem('token');
    const url2 = 'http://localhost:8080/validate-token'

    if (token) {
        console.log("entrou")
        if (!isTokenExpired(token)) {
            fetch(url2, {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
                .then(response => {
                    if (response.ok) {
                        window.location.href = '/index';
                    } else {
                        localStorage.removeItem('token');
                        window.location.href = '/login';
                    }
                })
                .catch(error => {
                    console.error('Erro ao validar token no backend:', error);
                    localStorage.removeItem('token');
                    window.location.href = '/login';
                });
        } else {
            localStorage.removeItem('token');
            window.location.href = '/login';
        }
    } else {
        window.location.href = '/login';
    }
}

document.addEventListener('DOMContentLoaded', (event) => {
    if (token) {
        validateAndRedirect();
    }
});