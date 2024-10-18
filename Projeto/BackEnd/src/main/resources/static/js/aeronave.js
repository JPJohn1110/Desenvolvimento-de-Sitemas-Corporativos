const modal = document.querySelector('.modal-container')
const tbody = document.querySelector('#aeronaveTbody')
const sModelo = document.querySelector('#m-modelo')
const stipo = document.querySelector('#m-tipo')
const sPesoDecol = document.querySelector('#m-pesoDecol')
const sPesoVazio = document.querySelector('#m-pesoVazio')
const sMaxocup = document.querySelector('#m-maxocup')
const sVelomed = document.querySelector('#m-velomed')
const sCombmax = document.querySelector('#m-combmax')
const sCombhora = document.querySelector('#m-combhora')
const btnSalvar = document.querySelector('#btnSalvar')
const url ='http://localhost:8080/crud/aeronave'
let aeronavesT = []
let id

//Requisição GET
function loadAeronave(){
  const token = localStorage.getItem('token');
  fetch(url,{
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
    .then(response => response.json())
    .then(aeronaves => {
      tbody.innerHTML = ''

      aeronaves.forEach((aeronave) => {
        aeronavesT.push(aeronave)
        inserirAeronave(aeronave);
      });
    })
}

//Requisição POST
btnSalvar.onclick = e => {
  if(sModelo.value == '' || stipo.value == '' || sPesoDecol.value == '' || sPesoVazio.value == '' || sMaxocup.value == '' || sVelomed.value == '' || sCombmax == '' || sCombhora == '') {
    return
  }

  e.preventDefault();

  const novaAeronave = {
    modelo: sModelo.value,
    tipo: stipo.value,
    pesoMaxDecol: sPesoDecol.value,
    pesoVazio: sPesoVazio.value,
    capacidadeOcupantes: sMaxocup.value,
    velocidadeMedia: sVelomed.value,
    combustivelMax: sCombmax.value,
    consumoHora: sCombhora.value
  }

  if(id !== undefined){
    novaAeronave.id = id
    atualizarAeronave(novaAeronave)
    return
  }

  const token = localStorage.getItem('token');

  fetch(url, {
    method: 'POST',
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(novaAeronave)
  })
  .then(response => {
    if(!response.ok) {
      throw new Error('Erro ao cadastrar a arenove')
    }
    return response.text();
  })
  .then(data => {
      console.log(data);
      loadAeronave();
      id = undefined
  })
  .catch(error => console.error('Erro:', error));

  sModelo.value = ''
  stipo.value = ''
  sPesoDecol.value = ''
  sPesoVazio.value = ''
  sMaxocup.value = ''
  sVelomed.value = ''
  sCombmax.value = ''
  sCombhora.value = ''
}

//Requisição PUT
function atualizarAeronave(aeronave) {
  const token = localStorage.getItem('token');
  fetch(url, {
    method: 'PUT',
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(aeronave)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Erro ao atualizar a aeronave');
    }
    return response.text();
  })
  .then(data => {
    console.log(data);
    loadAeronave();
  })
  .catch(error => console.error('Erro:', error));
}

//Requisição DELETE
function deleteAeronave(id){
  const token = localStorage.getItem('token');
  fetch(`${url}/${id}`, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Erro ao excluir a aeronave');
    }
    return response.text();
  })
  .then(data => {
    console.log(data);
    loadAeronave();
  })
  .catch(error => console.error('Erro:', error));
}

//Renderizaar as aeronaves na tela
function inserirAeronave(aeronave) {
  let tr =document.createElement('tr');

  tr.innerHTML = `
      <td>${aeronave.modelo}</td>
      <td>${aeronave.tipo}</td>
      <td>${aeronave.pesoMaxDecol}</td>
      <td>${aeronave.pesoVazio}</td>
      <td>${aeronave.capacidadeOcupantes}</td>
      <td>${aeronave.velocidadeMedia}</td>
      <td>${aeronave.combustivelMax}</td>
      <td>${aeronave.consumoHora}</td>
      <td class="acao">
          <button onclick="editAeronave(${aeronave.id})"><i class='bx bx-edit'></i>Editar</button>
      </td>
      <td class="acao">
          <button onclick="deleteAeronave(${aeronave.id})"><i class='bx bx-trash'></i>Excluir</button>
      </td>
  `;
  tbody.appendChild(tr);
}

//responde o botão editar
function editAeronave(id) {
  const aeronave = encontrarAeronave(id);
  if (aeronave) {
    openModal(true, aeronave);
  } else {
    console.error('Aeronave não encontrada');
  }
}

//procurar a aeronave no array
function encontrarAeronave(id) {
  return aeronavesT.find(aeronave => aeronave.id === id);
}

//modal para a inserção e atualização
function openModal(edit = false, aeronave) {
  modal.classList.add('active')

  modal.onclick = e => {
    if (e.target.className.indexOf('modal-container') !== -1) {
      modal.classList.remove('active')
    }
  }

  if (edit) {
    sModelo.value = aeronave.modelo 
    stipo.value = aeronave.tipo
    sPesoDecol.value = aeronave.pesoMaxDecol
    sPesoVazio.value = aeronave.pesoVazio
    sMaxocup.value = aeronave.capacidadeOcupantes
    sVelomed.value = aeronave.velocidadeMedia
    sCombmax.value = aeronave.combustivelMax
    sCombhora.value = aeronave.consumoHora
    id = aeronave.id
  } else {
    sModelo.value = ''
    stipo.value = ''
    sPesoDecol.value = ''
    sPesoVazio.value = ''
    sMaxocup.value = ''
    sVelomed.value = ''
    sCombmax.value = ''
    sCombhora.value = ''
    id = undefined
  }
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

//chama a renderização
loadAeronave();
buscarNome();

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
