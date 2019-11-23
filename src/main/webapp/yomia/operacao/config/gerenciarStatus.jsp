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
                                            <h6 class="m-0 font-weight-bold text-primary">Status da Atividade</h6>
                                        </div>
                                        <div class="card-body">


                                            <fieldset>
                                                <!-- Text input-->
                                                <div class="form-group">
                                                    <label class="col-md control-label" for="lb_titulo">Titulo</label>  
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <input id="lb_titulo" name="lb_titulo" type="text" placeholder="" class="form-control input-md" required="">
                                                        </div>

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
                                            <h6 class="m-0 font-weight-bold text-primary">Status da Atividade</h6>
                                        </div>
                                        <div class="card-body">


                                            <fieldset>
                                                <!-- Text input-->
                                                <div class="form-group">
                                                    <label class="col-md control-label" for="lb_titulo">Titulo</label>  
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <input id="lb_titulo" name="lb_titulo" type="text" placeholder="" class="form-control input-md" required="">
                                                        </div>

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
        <script src="/js/sb-admin-2.min.js"></script>atividade.form.cad
        <script>

            $(document).ready(function () {

                $("#btn_salvar_tipo").click(
                        function () {

                            var $form = $("#formid");

                            var $inputs = $form.find("input");
                            var serializedData = $form.serialize();
                            $inputs.prop("disabled", true);
                            $.ajax({
                                url: '/form/tipo_atividade.form.cad',
                                type: "post",
                                data: serializedData
                            }).done(function (data) {
                                alert(data);
                            });
                        }
                );

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
                                alert(data);
                            });
                        }
                );



            });
        </script>

    </body>

</html>
