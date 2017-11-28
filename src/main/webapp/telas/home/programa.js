
 function iniciar() {
    
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