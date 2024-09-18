document.getElementById("accountButton").onclick = function(event) {
    const modal = document.getElementById("accountModal");

    // Alternar a visibilidade do modal
    if (modal.style.display === "block") {
        modal.style.display = "none";
    } else {
        modal.style.display = "block";

        // Ajuste para exibir abaixo do botão sem sobrepor
        const buttonRect = event.target.getBoundingClientRect();
        modal.style.top = buttonRect.bottom + window.scrollY + "px"; // Exibir logo abaixo do botão
        modal.style.left = buttonRect.left + window.scrollX + "px"; // Alinhamento à esquerda do botão
    }
}

document.getElementById("closeModal").onclick = function() {
    document.getElementById("accountModal").style.display = "none";
}

// Fechar o modal ao clicar fora
window.onclick = function(event) {
    const modal = document.getElementById("accountModal");
    if (event.target !== modal && event.target !== document.getElementById("accountButton")) {
        modal.style.display = "none";
    }
}

document.querySelector('.create-account-btn').onclick = function() {
    window.location.href = "/cadastrar";
}

document.querySelector('.login-btn').onclick = function() {
    window.location.href = "/login";
}

console.log("Teste")