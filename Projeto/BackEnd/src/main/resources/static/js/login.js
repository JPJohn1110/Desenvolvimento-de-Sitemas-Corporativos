const sEmail = document.querySelector('#email');
const sSenha = document.querySelector('#senha');
const btnSignup = document.querySelector('#btnlogin');
const url = 'http://localhost:8080/login';
sessionStorage.clear()

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
        console.log(token)
        sessionStorage.setItem('token', token);
        fetch('/index', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}` // Adiciona o token no cabeçalho
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao acessar a página inicial');
            }
            return response.text(); // ou response.json() se a resposta for em JSON
        })
        .then(html => {
            document.open();
            document.write(html); // Escreve o conteúdo HTML da página inicial
            document.close();
        })
        .catch(error => {
            console.error('Erro:', error);
        });
    })

}
