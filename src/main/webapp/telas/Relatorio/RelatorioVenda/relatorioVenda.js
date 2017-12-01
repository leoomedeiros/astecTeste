// está funcionando para logar usuário.
function iniciar() {

    let perfil = document.querySelector('#perfil').value;
    if (perfil.localeCompare('diretoria') === 0) {
        diretoria();
    } else if (perfil.localeCompare('gerencia') === 0){
        gerencia();
    } else if (perfil.localeCompare('backoffice') === 0){
        backoffice();
    }
}

function diretoria() {
	let ladoDireito= document.querySelector("#direito");
    ladoDireito.addEventListener("click",esconder);
	
    let relatorio = document.querySelector(".menu li:nth-child(5)");
    relatorio.addEventListener("click", subRel);
    
    let produto = document.querySelector(".menu li:nth-child(2) a");
    let cliente = document.querySelector(".menu li:nth-child(3) a");
    let venda = document.querySelector(".menu li:nth-child(4) a");
    let usuario = document.querySelector(".menu li:nth-child(6) a");

    let outrosMenus = [produto, cliente, venda, usuario];
    for (let element of outrosMenus) {
        element.style.color = "gray";
        console.log(element);
    }
}

function gerencia() {
    
    let ladoDireito= document.querySelector("#direito");
    ladoDireito.addEventListener("click",esconder);

    let produto = document.querySelector(".menu li:nth-child(2)");
    produto.addEventListener("click",subPro);

    let cliente = document.querySelector(".menu li:nth-child(3)");
    cliente.addEventListener("click", subCli);
    
    let relatorio = document.querySelector(".menu li:nth-child(5)");
    relatorio.addEventListener("click", subRel);

    let usuario = document.querySelector(".menu li:nth-child(6)");
    usuario.addEventListener("click", subUsu);
    
}

function backoffice() {

    let ladoDireito = document.querySelector("#direito");
    ladoDireito.addEventListener("click", esconder);

    let produto = document.querySelector(".menu li:nth-child(2)");
    produto.addEventListener("click", subPro);

    let relatorio = document.querySelector(".menu li:nth-child(5)");
    relatorio.addEventListener("click", subRel);

    anularBackoffice();

}

function anularBackoffice() {
    let cliente = document.querySelector(".menu li:nth-child(3) a");

    let venda = document.querySelector(".menu li:nth-child(4) a");

    let usuario = document.querySelector(".menu li:nth-child(6) a");

    let outrosMenus = [cliente, usuario, venda];
    for (let element of outrosMenus) {
        element.style.color = "gray";
        console.log(element);
    }
}

function subPro (){
    esconder();
    let subProduto = document.querySelector("#subProduto");
    subProduto.style.visibility="visible";
}

function subCli (){
    esconder();
    let subCliente = document.querySelector("#subCliente");
    subCliente.style.visibility="visible";
}

function subRel (){
    esconder();
    let subRelatorio = document.querySelector("#subRelatorio");
    subRelatorio.style.visibility="visible";
}

function subUsu (){
    esconder();
    let subUsuario = document.querySelector("#subUsuario");
    subUsuario.style.visibility="visible";
}
function esconder (){
    let submenus = document.querySelectorAll("div.sub");
    for (let i=0;i<submenus.length;i++){
        submenus[i].style.visibility="hidden";
    }
}

window.addEventListener("load", iniciar);