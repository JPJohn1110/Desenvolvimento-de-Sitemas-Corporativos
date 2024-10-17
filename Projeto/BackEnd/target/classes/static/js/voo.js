const modal = document.querySelector('.modal-container')
const tbody = document.querySelector('#aeronaveTbody')
const url ='http://localhost:8080/crud/voo'
const btnSalvar = document.querySelector('#btnSalvar')
const btnSearch = document.querySelector('#search')

const sTextoBusca = document.querySelector('#searchInput')
const sTipoBusca = document.querySelector('#searchCriteria')
const snumVoo = document.querySelector('#m-numvoo')
const sAeronave = document.querySelector('#m-aeronave')
const sDuracao = document.querySelector('#m-duracao')
const sOrigem = document.querySelector('#m-origem')
const sDestino = document.querySelector('#m-destino')
let voos = []
let aeronavesT = []
let id
let token = localStorage.getItem('token');

//Requisição GET
function loadVoo(){
  fetch(url,{
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
    .then(response => response.json())
    .then(voosT => {
      tbody.innerHTML = ''

      voosT.forEach((voo) => {
        voos.push(voo)
        inserirVoo(voo);
      });
    })
}

btnSearch.onclick = e => {
  if (sTextoBusca.value === ''){
    loadVoo()
    return
  }

  const urlBusca = `http://localhost:8080/crud/voo/buscar?${sTipoBusca.value}=${encodeURIComponent(sTextoBusca.value)}`

  fetch(urlBusca,{
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
    .then(response => response.json())
    .then(voosT => {
      tbody.innerHTML = ''

      voosT.forEach((voo) => {
        voos.push(voo)
        inserirVoo(voo);
      });
    })
}

//Requisição POST
btnSalvar.onclick = e => {
  if(snumVoo.value === '' || sAeronave.value === '' || sDuracao.value === '' || sOrigem.value === '' || sDestino.value === '') {
    return
  }

  e.preventDefault();

  const novoVoo = {
    numeroVoo: snumVoo.value,
    aeronave: {id: parseInt(sAeronave.value) },
    duracao: sDuracao.value,
    origem: sOrigem.value,
    destino: sDestino.value,
  }

  if(id !== undefined){
    novoVoo.id = id
    atualizarVoo(novoVoo)
    return
  }

  fetch(url, {
    method: 'POST',
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(novoVoo)
  })
  .then(response => {
    if(!response.ok) {
      throw new Error('Erro ao cadastrar o Voo')
    }
    return response.text();
  })
  .then(data => {
      console.log(data);
      loadVoo();
      id = undefined
  })
  .catch(error => console.error('Erro:', error));

  snumVoo.value = ''
  sAeronave.value = ''
  sDuracao.value = ''
  sOrigem.value = ''
  sDestino.value = ''
}

//Requisição PUT
function atualizarVoo(voo) {
  fetch(url, {
    method: 'PUT',
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(voo)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Erro ao atualizar o Voo');
    }
    return response.text();
  })
  .then(data => {
    console.log(data);
    loadVoo();
  })
  .catch(error => console.error('Erro:', error));
}

//Requisição DELETE
function deleteVoo(id){
  fetch(`${url}/${id}`, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Erro ao excluir o Voo');
    }
    return response.text();
  })
  .then(data => {
    console.log(data);
    loadVoo();
  })
  .catch(error => console.error('Erro:', error));
}

//Renderizaar os voos na tela
function inserirVoo(voo) {
  let tr =document.createElement('tr');

  tr.innerHTML = `
      <td>${voo.numeroVoo}</td>
      <td>${voo.aeronave.modelo}</td>
      <td>${voo.duracao}</td>
      <td>${voo.origem}</td>
      <td>${voo.destino}</td>
      <td class="acao">
          <button onclick="editVoo(${voo.id})"><i class='bx bx-edit'></i>Editar</button>
      </td>
      <td class="acao">
          <button onclick="deleteVoo(${voo.id})"><i class='bx bx-trash'></i>Excluir</button>
      </td>
  `;
  tbody.appendChild(tr);
}

//Redenrizar aeronaves
function loadAeronaves(){
  fetch('http://localhost:8080/crud/aeronave', {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
    .then(response => response.json())
    .then(aeronaves => {
      const select = document.getElementById('m-aeronave');
      aeronaves.forEach(aeronave => {
        aeronavesT.push(aeronave)
        const opcao = document.createElement('option');
        opcao.value = aeronave.id;
        opcao.textContent = aeronave.modelo;
        select.appendChild(opcao)
      })
    })
}

//responde o botão editar
function editVoo(id) {
  const voo = encontrarVoo(id);
  if (voo) {
    openModal(true, voo);
  } else {
    console.error('Voo não encontrado');
  }
}

//procurar voo no array
function encontrarVoo(id) {
  return voos.find(voo => voo.id === id);
}

//modal para a inserção e atualização
function openModal(edit = false, voo) {
  modal.classList.add('active')

  modal.onclick = e => {
    if (e.target.className.indexOf('modal-container') !== -1) {
      modal.classList.remove('active')
    }
  }

  if (edit) {
    snumVoo.value = voo.numeroVoo
    sAeronave.value = voo.aeronave.id
    sDuracao.value = voo.duracao
    sOrigem.value = voo.origem
    sDestino.value = voo.destino
    id = voo.id
  } else {
    snumVoo.value = ''
    sAeronave.value = ''
    sDuracao.value = ''
    sOrigem.value = ''
    sDestino.value = ''
    id = undefined
  }
}

//chama a renderização
loadVoo()
loadAeronaves()

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
