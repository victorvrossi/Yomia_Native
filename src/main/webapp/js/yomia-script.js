function verificaSeDeuErro(data) {
    if (data == null || data == "") {
        imprimeErroDefaultNaTela();
        return false;
    }

    if (data.includes("codigoErro")) {
        return true;
    }

    return false;
}
function imprimeErroNaTela(json) {
    $("#tituloError").html("" + json.titulo);
    $("#codErro").html("" + json.codigoErro);
    $("#descrierro").html("" + json.descricao);

    $('#modalErro').modal('toggle');
    $('#modalErro').modal('show');
    $('#modalErro').modal('hide');
}
function imprimeErroDefaultNaTela() {
    $("#tituloError").html("JSV-001");
    $("#codErro").html("JSV-001");
    $("#descrierro").html("Falha ao processar resposta do servidor, entre em contato com ao Administrador do sistema para mais detalhes.");

    $('#modalErro').modal('toggle');
    $('#modalErro').modal('show');
    $('#modalErro').modal('hide');
}

function carregaModalparaErros() {
    var modal = "" +
            "		<div class='modal fade' id='modalErro' tabindex='-1' role='dialog' aria-labelledby='modalErro' aria-hidden='true'>" +
            "            <div class='modal-dialog' role='document'>" +
            "                <div class='modal-content'>" +
            "                    <div class='modal-header'>" +
            "                        <h5 class='modal-title' id='tituloError'>Atividade ATB-54154</h5>" +
            "                        <button type='button' class='close' data-dismiss='modal' aria-label='Close'>" +
            "                            <span aria-hidden='true'>&times;</span>" +
            "                        </button>" +
            "                    </div>" +
            "                    <div class='modal-body'>" +
            "                        <div><span id='codErro'></span><p id='descrierro'></p></div>" +
            "                    </div>" +
            "                    <div class='modal-footer'>" +
            "                        Para mais detalhes entre em contato com o suporte técnico. Informe o código do erro e o detalhe." +
            "                    </div>" +
            "                </div>" +
            "            </div>" +
            "        </div>";
    $("#saidaDeErro").html(modal);
}