document.getElementById("formCadastro").addEventListener("submit", async function(event) {
    event.preventDefault(); // Evita o comportamento padrão de envio do formulário

    // Capturando os dados do formulário
    const formData = {
        cpf: document.getElementById("cpf").value,
        nome: document.getElementById("nome").value,
        dataNascimento: document.getElementById("dataNascimento").value,
        genero: document.getElementById("genero").value,
        email: document.getElementById("email").value,
        login: document.getElementById("login").value,
        senha: document.getElementById("senha").value,
        confirmaSenha: document.getElementById("confirma-senha").value,
        numeroDocumento: document.getElementById("document-number").value,
        telefone: document.getElementById("phone-number").value,
        tipoDocumento: document.getElementById("document-type").value,
        cep: document.getElementById("cep").value,
        promoCode: document.getElementById("promo-code").value
    };

    // Validando se as senhas coincidem
    if (formData.senha !== formData.confirmaSenha) {
        document.getElementById("mensagem").innerText = "As senhas não coincidem!";
        return;
    }

    try {
        // Enviando os dados ao backend via POST
        const response = await fetch("http://localhost:8080/usuario", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        });

        // Tratando a resposta
        if (response.ok) {
            const result = await response.json();
            document.getElementById("mensagem").innerText = "Cadastro realizado com sucesso!";
        } else {
            document.getElementById("mensagem").innerText = "Erro ao cadastrar. Tente novamente.";
        }
    } catch (error) {
        document.getElementById("mensagem").innerText = "Erro de conexão com o servidor.";
    }
});

