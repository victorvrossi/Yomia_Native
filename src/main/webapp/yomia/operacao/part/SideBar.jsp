<%-- 
    Document   : SideBar
    Created on : 23 de nov de 2019, 09:40:07
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion toggled" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index.jsp" />
    <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
    </div>
    <div class="sidebar-brand-text mx-3">Yomia JSP</div>
</a>

<!-- Divider -->
<hr class="sidebar-divider my-0" />

<!-- Nav Item - Dashboard -->
<li class="nav-item">
    <a class="nav-link" href="/yomia/operacao/index.jsp">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Dashboard</span></a>
</li>

<!-- Divider -->
<hr class="sidebar-divider">

<!-- Heading -->
<div class="sidebar-heading">
    Operação
</div>

<!-- Nav Item - Tables -->
<li class="nav-item">
    <a class="nav-link" href="/yomia/operacao/novaAtividade.jsp">
        <i class="fas fa-fw fa-table"></i>
        <span>Nova Atividade</span></a>
</li>
<li class="nav-item">
    <a class="nav-link" href="/yomia/operacao/configuracao.jsp">
        <i class="fas fa-fw fa-table"></i>
        <span>Configurações</span></a>
</li>

<!-- Divider -->
<hr class="sidebar-divider d-none d-md-block">

<!-- Nav Item - Tables -->
<li class="nav-item">
    <a class="nav-link" href="/yomia/visualizar/painelGeral.jsp">
        <i class="fas fa-fw fa-table"></i>
        <span>Painel Geral</span></a>
</li>
<!-- Nav Item - Tables -->
<li class="nav-item">
    <a class="nav-link" href="/yomia/visualizar/painelChamados.jsp">
        <i class="fas fa-fw fa-table"></i>
        <span>Painel Chamados</span></a>
</li>

<!-- Sidebar Toggler (Sidebar) -->
<div class="text-center d-none d-md-inline">
    <button class="rounded-circle border-0" id="sidebarToggle"></button>
</div>

</ul>
<!-- End of Sidebar -->
