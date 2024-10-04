const sNome = document.querySelector('#nome');
const sCpf = document.querySelector('#cpf');
const sEmail = document.querySelector('#email');
const sSenha = document.querySelector('#senha');
const sConfirmaSenha = document.querySelector('#confsenha');
const sTelefone = document.querySelector('#telefone');
const sChavedeAcesso = document.querySelector('#chave');
const btnSignup = document.querySelector('#btnsignup');
const url = 'http://localhost:8080/usuario';

// Elementos de erro
const erroNome = document.querySelector('#erroNome');
const erroCpf = document.querySelector('#erroCpf');
const erroEmail = document.querySelector('#erroEmail');
const erroSenha = document.querySelector('#erroSenha');
const erroConfirmaSenha = document.querySelector('#erroConfirmaSenha');
const erroTelefone = document.querySelector('#erroTelefone');
const erroChave = document.querySelector('#erroChave');

function validaSenha() {
    const senha = sSenha.value;
    const regexSenha = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (!regexSenha.test(senha)) {
        erroSenha.innerHTML = `
            A senha deve ter no mínimo 8 caracteres:<br>
            <ul>
                <li>Uma letra maiúscula</li>
                <li>Uma letra minúscula</li>
                <li>Um número</li>
                <li>Um caractere especial</li>
            </ul>
        `;
        return false;
    }

    if (senha !== sConfirmaSenha.value) {
        erroConfirmaSenha.textContent = "As senhas não coincidem!";
        return false;
    } else {
        erroConfirmaSenha.textContent = ""; // Limpa o erro se for válido
    }

    return true;
}

btnSignup.onclick = e => {
    e.preventDefault(); // Impede o envio padrão do formulário

    let formValido = true;

    // Limpa mensagens de erro
    erroNome.textContent = "";
    erroCpf.textContent = "";
    erroEmail.textContent = "";
    erroSenha.textContent = "";
    erroConfirmaSenha.textContent = "";
    erroTelefone.textContent = "";
    erroChave.textContent = "";

    // Verifica se todos os campos estão preenchidos
    if (sNome.value === '') {
        erroNome.textContent = "Nome é obrigatório!";
        formValido = false;
    }
    if (sCpf.value === '') {
        erroCpf.textContent = "CPF é obrigatório!";
        formValido = false;
    }
    if (sEmail.value === '') {
        erroEmail.textContent = "E-mail é obrigatório!";
        formValido = false;
    }
    if (sSenha.value === '') {
        erroSenha.textContent = "Senha é obrigatória!";
        formValido = false;
    }
    if (sTelefone.value === '') {
        erroTelefone.textContent = "Telefone é obrigatório!";
        formValido = false;
    }
    if (sChavedeAcesso.value === '') {
        erroChave.textContent = "Chave de Acesso é obrigatória!";
        formValido = false;
    }

    // Validação da senha
    if (!validaSenha()) {
        formValido = false;
    }

    // Se o formulário não for válido, interrompe o processo
    if (!formValido) {
        return;
    }

    // Cria o objeto de cadastro
    const novoCadastro = {
        nome: sNome.value,
        email: sEmail.value,
        senha: sSenha.value,
        telefone: sTelefone.value,
        codigoAcesso: sChavedeAcesso.value,
        cpf: sCpf.value
    };

    // Envia os dados para o servidor
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoCadastro)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao cadastrar o usuário');
        }
        return response.text();
    })
    .then(data => {
        console.log(data);
        alert("Cadastro realizado com sucesso!");

        // Limpa os campos após o sucesso
        sNome.value = '';
        sCpf.value = '';
        sEmail.value = '';
        sSenha.value = '';
        sConfirmaSenha.value = '';
        sTelefone.value = '';
        sChavedeAcesso.value = '';
    })
    .catch(error => {
        console.error('Erro:', error);
        alert("Erro ao cadastrar o usuário. Tente novamente.");
    });
};
