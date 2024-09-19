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
            // Verificar se as senhas coincidem
            if (formData.senha !== formData.confirmaSenha) {
                exibirModal("As senhas não coincidem!");
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

                // Tratando a resposta como texto
                const result = await response.text();

                if (response.ok) {
                    exibirModal(result);  // Mostra a mensagem de sucesso no modal
                } else {
                    exibirModal("Erro ao cadastrar. Tente novamente.");  // Mostra a mensagem de erro
                }

            } catch (error) {
                exibirModal("Erro de conexão com o servidor.");  // Mostra erro de conexão no modal
            }
        });

        // Funções de exibição do modal e eventos de fechamento
   const modal = document.getElementById("modalMensagem");
   const closeButton = document.getElementsByClassName("close")[0];

   closeButton.onclick = function() {
       modal.style.display = "none";
   }

   window.onclick = function(event) {
       if (event.target == modal) {
           modal.style.display = "none";
       }
   }
   
   function exibirModal(mensagem) {
    document.getElementById("mensagemModal").innerText = mensagem;
    modal.style.display = "flex";  // Exibe o modal
}
