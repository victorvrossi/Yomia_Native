<%-- 
    Document   : novaAtividade
    Created on : 23 de nov de 2019, 09:36:20
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <%@include file="part/head.jsp" %>

    </head>

    <body id="page-top">

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
                        <h1 class="h3 mb-4 text-gray-800">Nova atividade</h1>
                        <!-- Form -->
                        <form class="form-horizontal" id="formid">
                            <div class="row">
                                <div class="col-lg-6">


                                    <div class="card shadow mb-4"><!-- Card -->
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Configuração inicial</h6>
                                        </div>
                                        <div class="card-body">


                                            <fieldset>
                                                <!-- Text input-->
                                                <div class="form-group">
                                                    <label class="col-md control-label" for="lb_titulo">Titulo da Atividade</label>  
                                                    <div class="col-md">
                                                        <input id="lb_titulo" name="lb_titulo" type="text" placeholder="" class="form-control input-md" required="">
                                                        <span class="help-block">Ajuda</span>  
                                                    </div>
                                                </div>

                                                <!-- Textarea -->
                                                <div class="form-group">
                                                    <label class="col-md control-label" for="textarea">Descrição</label>
                                                    <div class="col-md">                     
                                                        <textarea class="form-control" id="lb_descricao" name="lb_descricao">default text</textarea>
                                                    </div>
                                                </div>


                                                <!-- Select Basic -->
                                                <div class="form-group">
                                                    <label class="col-md control-label" for="selecttipoativi">Tipo de atividade</label>
                                                    <div class="col-md">
                                                        <select id="selecttipoativi" name="selecttipoativi" class="form-control">
                                                            <option value="1">Bug</option>
                                                            <option value="2">Tarefa de fábrica</option>
                                                        </select>
                                                    </div>
                                                </div>


                                            </fieldset>


                                        </div>
                                    </div><!-- End Card -->
                                    <!--                                </form>-->
                                </div>

                               
                                <div class="col-lg-6">
                                    
                                </div>
                                <div class="col-lg-6">
                                    <div class="btn btn-primary btn-block" id="btn_salvar">Confirmar e Salvar</div>
                                    <div class="btn btn-danger btn-block">Cancelar</div>
                                </div>
                            </div>
                        </form>




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
                        <a class="btn btn-primary" href="login.html">Logout</a>
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
            
            var ajax = $.ajax({
                url: '/form/tipo_atividade.lista',
                type: "post"
            }).done(function (data) {
                
                 $("#selecttipoativi").html("");
                 var json = JSON.parse(data);
                for (var i = 0; i <= json.length; i++) {
                   $("#selecttipoativi").html( $("#selecttipoativi").html()+"<option value='"+json[i].titulo+"'>"+json[i].titulo+"</option>");
                }
            });
            
            
            $(document).ready(function () {

                $("#btn_salvar").click(
                        function () {

                            var $form = $("#formid");

                            var $inputs = $form.find("input, select, button, textarea");
                            var serializedData = $form.serialize();
                            $inputs.prop("disabled", true);
                            $.ajax({
                                url: '/form/atividade.form.cad',
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
