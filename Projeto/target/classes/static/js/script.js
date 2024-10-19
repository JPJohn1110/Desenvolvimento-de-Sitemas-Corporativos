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

    if (token) {
        if (!isTokenExpired(token)) {
            fetch('/validate-token', {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
                .then(response => {
                    if (!response.ok) {
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
    validateAndRedirect();
    verificarUsuario();
    buscarNome();
});

function verificarUsuario() {
    const token = localStorage.getItem('token');

    if (token) {
        const decodedToken = parseJwt(token);
        const roles = decodedToken.roles; // Acesso correto ao array de roles

        // Verifica se a role "ROLE_ADMIN" está presente no array de roles
        if (roles.includes('ROLE_ADMIN')) {
            adicionarFuncionariosNaSidebar();
        }
    }
}

function adicionarFuncionariosNaSidebar() {
    const sidebar = document.getElementById('sidebar');
    const funcionariosItem = document.createElement('li');
    funcionariosItem.innerHTML = `
        <a href="funcionarios">
            <i><img src="images/func.png" alt=""></i> 
            <div>Funcionários</div>
        </a>
    `;
    sidebar.appendChild(funcionariosItem);
}

function buscarNome(){
    const token = localStorage.getItem('token');
    const decodedToken = parseJwt(token);
    const email = decodedToken.sub;

    const urlBusca = `http://localhost:8080/usuario/buscar/email?email=${encodeURIComponent(email)}`

    console.log(email)

    fetch(urlBusca,{
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
        .then(response => response.json())
        .then(data => {
            console.log(data.nome)
            const span = document.getElementById('nomeUsuario');
            span.innerHTML = `${data.nome}`
        })
}
   