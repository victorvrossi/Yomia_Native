<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <%@include file="part/head.jsp" %>

    </head>

    <body id="page-top" class="sidebar-toggled">

        <!-- Page Wrapper -->
        <div id="wrapper">



            <%@include file="part/SideBar.jsp" %>


            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">


                    <%@include file="part/top.jsp" %>

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Painel geral</h1>

                        <div class="row">
                            <div class="col-lg-6 col-md-12 col-sm-12 ">
                                <div class="card shadow mb-4">
                                    <div class="card border-left-primary shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col mr-12">
                                                    <div class="text font-weight-bold text-danger text-uppercase mb-1">Filtra atividades por:</div>
                                                </div>
                                            </div>
                                            <hr/>
                                            <div class="row ">
                                                <div class="col-lg-3 col-sm-3 col-md-3 col-4">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><a href="#" class="btn btn-block btn-info btn-icon-split"><span class="text">Cliente</span></a></div>
                                                </div>
                                                <div class="col-lg-3 col-sm-3 col-md-3 col-4">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><a href="#" class="btn btn-block btn-info btn-icon-split"><span class="text">Estratégico</span></a></div>
                                                </div>
                                                <div class="col-lg-3 col-sm-3 col-md-3 col-4">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><a href="#" class="btn btn-block btn-info btn-icon-split"><span class="text">Operação</span></a></div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 ">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Minhas Atividades </h6>
                                    </div>


                                    <div class="card-body">
                                        <div class="table-responsive">

                                            <table class="table table-bordered" id="dataTable"  cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>titulo</th>
                                                        <th>titulo</th>
                                                        <th>titulo</th>
                                                        <th>titulo</th>
                                                        <th>titulo</th>
                                                        <th>titulo</th>
                                                        <th>titulo</th>
                                                    </tr>
                                                </thead>

                                                <tbody id="tabls">




                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <!-- /.container-fluid -->

                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2019</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->


        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.jsp">Logout</a>
                    </div>
                </div>
            </div>
        </div>





        <!-- Modal para lançamento de erros-->
        <div id="saidaDeErro"></div>
        <!-- END Modal para lançamento de erros-->

        <!-- Modal Detalhe de ATIVIDADE-->
        <div class="modal fade" id="modalDetalhe" tabindex="-1" role="dialog" aria-labelledby="modalDetalhe" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modTitulo" >Mais informações sobre o Ticket</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container">

                            <div class="row mb-2">
                                <div class="col-md-5 col-lg-2 align-self-center  ">
                                    <span class="h5 font-weight-bold "  >Atividade: </span>      
                                </div>
                                <div class="col-md-7 col-lg ">
                                    <span class=" font-weight-bold " id="modTituloAtividade">Criar botão na interface genrenciadora</span>

                                </div>
                            </div>

                            <div class="row mb-2">
                                <div class="col-md-5 col-lg-2 align-self-center  ">
                                    <span class="h5 font-weight-bold " >Descrição</span>      
                                </div>
                                <div class="col-md-7 col-lg ">
                                    <p class=" font-weight-bold " id="modDescricao">Criar botão na interface genrenciadora para ajustar de forma correta o tamanho da linha vertical de uma onda que vem chegando</p>

                                </div>
                            </div>
                            <div class="row mb-2">
                                <div class="col-md-5 col-lg-2 align-self-center ">
                                    <span class="h5 font-weight-bold " >Status da Atividade</span>      
                                </div>
                                <div class="col-sm col-md col-lg">
                                    <span class="btn btn-primary  btn-block" id="modStatus">20 de Março de 2019</span>

                                </div>
                                <div class="col-sm col-md col-lg">
                                    <span class="btn btn-info  btn-block" id="modavancastatus"><i class='fas fa-plus'></i> Avançar Status</span>

                                </div>
                            </div>

                            <div class="row mb-2">
                                <div class="col-md-5 col-lg-2 align-self-center ">
                                    <span class="h5 font-weight-bold " >Data da criação</span>      
                                </div>
                                <div class="col-sm col-md col-lg">
                                    <span class="btn btn-warning  btn-block" id="modDataCriacao">20 de Março de 2019</span>

                                </div>
                            </div>

                        </div>


                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.jsp">Logout</a>
                    </div>
                </div>
            </div>
        </div>



        <!-- Bootstrap core JavaScript-->
        <script src="/vendor/jquery/jquery.min.js"></script>
        <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="/js/sb-admin-2.min.js"></script>
        <script src="/js/yomia-script.js"></script>

        <script>
            carregaModalparaErros();
            
            function validaLogin(){
                $.ajax({
                    url:'/form/usuario.login',
                    type: 'post'
                }).done(function (data){
                });
            }
            
            validaLogin();
            

            class AvancaStatus {
                constructor(atividade) {
                    this.ativ = atividade;
                }
                envia() {
                    $.ajax({
                        url: '/form/atividade.avanca.status',
                        type: "post",
                        data: {codAtividade: this.ativ}
                    });
                }

            }

            class listaItem {

                novo(cod_atividade, titulo, descricao, dataCriacao, status, tipo, botaonome) {
                    var item = "";
                    item += "<tr role='row' class='odd'>  ";
                    item += "<td>" + titulo + " </td>";
                    item += "<td>" + cod_atividade + " </td>";
                    item += "<td><a href='#' class='btn btn-block btn-success btn-icon-split'><span class='text'>" + status + "</span></a> </td>";
                    item += "<td><a href='#' class='btn  btn-primary btn-icon-split'>";
                    item += "<span class='icon text-white-50'><i class='fas fa-flag'></i></span>";
                    item += "<span class='text'>" + tipo + "</span>";
                    item += "</a></td>";
                    item += "<td><a href='#' id='" + botaonome + "' data-toggle='modal' data-target='#modalDetalhe' class='btn btn-info btn-icon-split'><span class='icon text-white-100'><i class='fas fa-plus'></i></span></a></td>";
                    item += "</tr>";

                    $("#tabls").html($("#tabls").html() + item);
                    this.i_titulo = titulo;
                    this.i_descricao = descricao;
                    this.i_dataCriacao = dataCriacao;
                    this.i_status = status;
                    this.i_tipo = tipo;
                    this.i_botaonome = botaonome;
                    this.i_cod_atividade = cod_atividade;
                }
                get nomeBotao() {
                    return this.i_botaonome;
                }

                acao() {
                    $("#modTituloAtividade").text(this.i_cod_atividade + " " + this.i_titulo);
                    $("#modDataCriacao").text(this.i_dataCriacao);
                    $("#modDescricao").text(this.i_descricao);
                    $("#modStatus").text(this._status);

                    var enviaAcao = new AvancaStatus(this.i_cod_atividade);
                    $("#modavancastatus").click(function () {
                        enviaAcao.envia();
                    });

                }

            }

            function carregaAtividadesParaTabela(){
                $.ajax({
                url: '/form/atividade.form.lista',
                type: "post"
            }).done(function (data) {
                if (verificaSeDeuErro(data)) {
                    imprimeErroNaTela(JSON.parse(data));
                    return;
                }
                var json = JSON.parse(data);


                var elementos = [];
                var listaExibe = [];
                for (var i = 1; i <= json.length; i++) {
                    elementos.push(new listaItem());
                }
                elementos.forEach(function (item, i, array) {
                    item.novo(json[i].codigoAtividade, json[i].titulo, json[i].descricao, json[i].dataCriacao, json[i].status, json[i].tipo, "item" + i);
                    listaExibe.push(item.nomeBotao);
                });

                listaExibe.forEach(function (item, i, array) {
                    $("#" + item).click(function (event) {
                        event.preventDefault();
                        elementos[i].acao(item);
                    });

                });
                $('#dataTable').DataTable();
            });
            }
            
            //carregaAtividadesParaTabela();
            $(document).ready(function () {
                $('#dataTable').DataTable(
                    { 
                        "ajax":{    
                            "url": '/form/atividade.form.lista',
                            "type": "post"
                                }
                    }
                );
                
                
            });




        </script>


        <script src="/vendor/datatables/jquery.dataTables.js"></script>
        <script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    </body>

</html>

