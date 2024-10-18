const url ='http://localhost:8080/crud/aeronave/plano'
let token = localStorage.getItem('token');
const tbody = document.querySelector('#planejamentoTbody')
const btnSearch = document.querySelector('#search')
const sBusca = document.querySelector('#searchAeronave')



//Renderizaar o planejamento na tela
function inserirPlanejamento(planejamento) {
    let tr =document.createElement('tr');

    tr.innerHTML = `
        <td>${planejamento.modelo}</td>
        <td>${planejamento.autonomia}</td>
        <td>${planejamento.primeiraClasse}</td>
        <td>${planejamento.economicaClasse}</td>
        <td>${planejamento.pesoDisponivel}</td>
        <td>${planejamento.quantidade}</td>
    `;
    tbody.appendChild(tr);
}

function loadPlanejamento(){
    fetch(url,{
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
        .then(response => response.json())
        .then(planejamentos => {
            tbody.innerHTML = ''

            planejamentos.forEach((planejamento) => {
                inserirPlanejamento(planejamento);
            });
        })
}

function loadAeronaves(){
    fetch('http://localhost:8080/crud/aeronave', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
        .then(response => response.json())
        .then(aeronaves => {
            const select = document.getElementById('searchAeronave');
            aeronaves.forEach(aeronave => {
                const opcao = document.createElement('option');
                opcao.value = aeronave.modelo;
                opcao.textContent = aeronave.modelo;
                select.appendChild(opcao)
            })
        })
}

btnSearch.onclick = e => {
    if (sBusca.value === 'Todos'){
        loadPlanejamento()
        return
    }

    const urlBusca =`http://localhost:8080/crud/aeronave/plano/buscar?modelo=${encodeURIComponent(sBusca.value)}`
    const token = localStorage.getItem('token');

    fetch(urlBusca,{
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
        .then(response => response.json())
        .then(planejamentos => {
            tbody.innerHTML = ''

            planejamentos.forEach((planejamento) => {
                inserirPlanejamento(planejamento);
            });
        })
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

loadAeronaves()
loadPlanejamento()
buscarNome()

document.addEventListener('DOMContentLoaded', (event) => {
    validateAndRedirect()
    verificarUsuario()
});

//autenticação
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

function verificarUsuario() {
    const token = localStorage.getItem('token');

    if (token) {
        const decodedToken = parseJwt(token);
        const roles = decodedToken.roles;

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
