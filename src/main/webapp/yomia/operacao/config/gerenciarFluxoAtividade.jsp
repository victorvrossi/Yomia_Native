<%-- 
    Document   : gerenciarStatus
    Created on : 23 de nov de 2019, 09:52:12
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <%@include file="/yomia/operacao/part/head.jsp" %>

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">


            <%@include file="/yomia/operacao/part/SideBar.jsp" %>


            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <%@include file="/yomia/operacao/part/top.jsp" %>        

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Configurações de Status de Atividade</h1>
                            <a href="../configuracao.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-arrow-left fa-sm text-white-50"></i> Voltar</a>
                        </div>
                        <!-- Form -->
                        <div class="row">

                            <div class="col-lg-6">
                                <form class="form-horizontal" id="formStatus">




                                    <div class="card shadow mb-4"><!-- Card -->
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Criar novo Fluxo de Atividade</h6>
                                        </div>
                                        <div class="card-body">


                                            <fieldset>
                                                <!-- Text input-->
                                                <div class="form-group">

                                                    <div class="row mb-1">
                                                        <label class="col-md control-label" for="lb_titulo">Titulo para o Fluxo</label>  
                                                        <div class="col-md-12">
                                                            <input id="lb_titulo" name="lb_titulo" type="text" placeholder="" class="form-control input-md" required="">
                                                        </div>
                                                    </div>
                                                    <div class="row mb-1">
                                                        <label class="col-md control-label" for="lb_titulo">Associar a tipo de atividade</label>  
                                                        <div class="col-md-12">
                                                            <input id="lb_titulo" name="lb_titulo" type="text" placeholder="" class="form-control input-md" required="">
                                                        </div>
                                                    </div>
                                                    <div class="row mb-1">
                                                        <div class="col-md-12 p-3">
                                                            <div class="row">

                                                                <div class="col-md-6">
                                                                    <button class="btn btn-block btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                        Dropdown
                                                                    </button>
                                                                    <p class="text-break">Another actionsdf sdf sd fsdf sdf sdf sdf sd fsd f GATINHO aosij daosi das od teste</p>
                                                                    <div class="text-break dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                                                                        <a class="dropdown-item" href="#">Action</a>
                                                                        <p class="text-break">Another actionsdf sdf sd fsdf sdf sdf sdf sd fsd f GATINHO aosij daosi das od teste</p>
                                                                        <a class="dropdown-item text-break" href="#">Another actionsdf sdf sd fsdf sdf sdf sdf sd fsd f GATINHO aosij daosi das od teste</a>
                                                                        <a class="dropdown-item" href="#">Something else here</a>
                                                                    </div>
                                                                </div>

                                                            </div>


                                                        </div>
                                                    </div>
                                                    <div class="row mb-1">
                                                        <div class="col-md-12 p-3">
                                                            <div class="row">

                                                                <div class="col-md-6">
                                                                    <div class="btn btn-primary btn-block" id="btn_salvar_status">Adicionar</div>
                                                                </div>

                                                            </div>


                                                        </div>
                                                    </div>
                                                </div>
                                            </fieldset>


                                        </div>
                                    </div><!-- End Card -->


                                </form>
                            </div>

                            <div class="col-lg-6">
                                <form class="form-horizontal" id="formStatus">




                                    <div class="card shadow mb-4"><!-- Card -->
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Fluxo de Atividade já configurado</h6>
                                        </div>
                                        <div class="card-body">


                                            <fieldset>
                                                <!-- Text input-->
                                                <div class="collapse show" id="cardEstBackLog">
                                                    <div class="card-body overflow-auto"  style="max-height: 19rem" >
                                                        <table class="table table-striped">
                                                            <tbody id="listatipoatividade">

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </fieldset>


                                        </div>
                                    </div><!-- End Card -->


                                </form>
                            </div>
                        </div>





                    </div>
                    <!-- /.container-fluid -->

                </div>
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

        <!-- Bootstrap core JavaScript-->
        <script src="/vendor/jquery/jquery.min.js"></script>
        <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="/js/sb-admin-2.min.js"></script>
        <script>

            $(document).ready(function () {

                function linha(css, valor) {
                    if (valor) {
                        return "<td class='center'><a href='#' class=' " + css + "  '>" + valor.titulo + "</a></td>";
                    }
                    return '<td></td>';

                }
                function listaTipos() {
                    $.ajax({
                        url: '/form/status.lista',
                        type: "post"
                    }).done(function (data) {
                        $("#listatipoatividade").html("");
                        var json = JSON.parse(data);
                        var tiposBotoes = ["btn-primary", "btn-info"];
                        var botaoClasse = tiposBotoes[0];
                        for (var i = 0; i < json.length; i++) {
                            if (json[i]) {
                                botaoClasse = tiposBotoes[(i % 2 == 0 ? 0 : 1)];
                                var add = "<tr>";
                                add += linha("btn " + botaoClasse + "  btn-block", json[i]);
                                i = i + 1;
                                botaoClasse = tiposBotoes[(i % 2 == 0 ? 0 : 1)];
                                add += linha("btn " + botaoClasse + "  btn-block", json[i]);
                                add += "</tr>";
                                $("#listatipoatividade").html($("#listatipoatividade").html() + add);
                            }
                        }
                    });
                }
                listaTipos();
                $("#btn_salvar_status").click(
                        function () {

                            var $form = $("#formStatus");

                            var $inputs = $form.find("input");
                            var serializedData = $form.serialize();
                            $inputs.prop("disabled", true);
                            $.ajax({
                                url: '/form/status_atividade.form.cad',
                                type: "post",
                                data: serializedData
                            }).done(function (data) {
                                listaTipos();
                            });
                        }
                );



            });
        </script>


    </body>

</html>
