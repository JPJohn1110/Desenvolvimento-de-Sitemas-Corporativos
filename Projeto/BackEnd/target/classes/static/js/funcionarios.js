const modal = document.querySelector('.modal-container')
const tbody = document.querySelector('#aeronaveTbody')
const sCargo = document.querySelector('#m-cargo')
let sAcesso = document.querySelector('#m-cacesso')
const btnSalvar = document.querySelector('#btnSalvar')
const url ='http://localhost:8080/usuario'
let usuariosT = []
let id

//Requisição GET
function loadUsuario(){
    const token = sessionStorage.getItem('token');
    fetch(url,{
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
        .then(response => response.json())
        .then(usuarios => {
            usuariosT = [];
            tbody.innerHTML = ''

            usuarios.forEach((usuario) => {
                usuariosT.push(usuario)
                inserirUsuario(usuario);
            });
        })
}

//Requisição POST
btnSalvar.onclick = e => {
    if(sCargo.value === '' || sAcesso.value === '') {
        return
    }

    e.preventDefault();

    const novoFuncionario = {
        role: sCargo.value,
        codigoAcesso: sAcesso.value
    }

    if(id !== undefined){
        novoFuncionario.id = id
        atualizarUsuario(novoFuncionario)
        return
    }

    const token = sessionStorage.getItem('token');

    fetch(url, {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoFuncionario)
    })
        .then(response => {
            if(!response.ok) {
                throw new Error('Erro ao cadastrar o funcionario')
            }
            return response.text();
        })
        .then(data => {
            console.log(data);
            loadUsuario();
            id = undefined
        })
        .catch(error => console.error('Erro:', error));

    sCargo.value = ''
    sAcesso.value = ''
}

//Requisição PUT
function atualizarUsuario(usuario) {
    const token = sessionStorage.getItem('token');
    fetch(url, {
        method: 'PUT',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao atualizar o funcionario');
            }
            return response.text();
        })
        .then(data => {
            console.log(data);
            loadUsuario();
        })
        .catch(error => console.error('Erro:', error));
}

//Requisição DELETE
function deleteUsuario(id){
    const token = sessionStorage.getItem('token');
    fetch(`${url}/${id}`, {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao excluir o funcionario');
            }
            return response.text();
        })
        .then(data => {
            console.log(data);
            loadUsuario();
        })
        .catch(error => console.error('Erro:', error));
}

//Renderizaar os Usuarios na tela
function inserirUsuario(usuario) {
    let tr =document.createElement('tr');

    tr.innerHTML = `
      <td>${usuario.nome}</td>
      <td>${usuario.email}</td>
      <td>${usuario.cpf}</td>
      <td>${usuario.role}</td>
      <td>${usuario.codigoAcesso}</td>
      <td class="acao">
          <button onclick="editUsuario(${usuario.id})"><i class='bx bx-edit'></i>Editar</button>
      </td>
      <td class="acao">
          <button onclick="deleteUsuario(${usuario.id})"><i class='bx bx-trash'></i>Excluir</button>
      </td>
  `;
    tbody.appendChild(tr);
}

//responde o botão editar
function editUsuario(id) {
    const usuario = encontrarUsuario(id);
    if (usuario) {
        openModal(true, usuario);
    } else {
        console.error('Funcionario não encontrado');
    }
}

//procurar a aeronave no array
function encontrarUsuario(id) {
    return usuariosT.find(usuario => usuario.id === id);
}

//modal para a inserção e atualização
function openModal(edit = false, usuario) {
    modal.classList.add('active')

    modal.onclick = e => {
        if (e.target.className.indexOf('modal-container') !== -1) {
            modal.classList.remove('active')
        }
    }

    if (edit) {
        sCargo.value = usuario.role
        sAcesso = usuario.codigoAcesso
        id = usuario.id
    } else {
        sCargo.value = ''
        sAcesso.value = gerarCodigoAcesso()
        id = undefined
    }
}

//chama a renderização
loadUsuario()

//Validação
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
    const token = sessionStorage.getItem('token');

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
                        sessionStorage.removeItem('token');
                        window.location.href = '/login';
                    }
                })
                .catch(error => {
                    console.error('Erro ao validar token no backend:', error);
                    sessionStorage.removeItem('token');
                    window.location.href = '/login';
                });
        } else {
            sessionStorage.removeItem('token');
            window.location.href = '/login';
        }
    } else {
        window.location.href = '/login';
    }
}

document.addEventListener('DOMContentLoaded', (event) => {
    validateAndRedirect();
    verificarUsuario();
});


function gerarCodigoAcesso(tamanho = 12) {
    const caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let codigoAcesso = '';
    for (let i = 0; i < tamanho; i++) {
        const indice = Math.floor(Math.random() * caracteres.length);
        codigoAcesso += caracteres.charAt(indice);
    }
    return codigoAcesso;
}

function verificarUsuario() {
    const token = sessionStorage.getItem('token');

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
            <i class="fas fa-users"></i> 
            <div>Funcionários</div>
        </a>
    `;
    sidebar.appendChild(funcionariosItem);
}