<%-- 
    Document   : index
    Created on : 16-sep-2017, 22:38:31
    Author     : ubaldino
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Usuarios</title>
    <link rel="apple-touch-icon" sizes="60x60" href="/public/app-assets/images/ico/apple-icon-60.png">
    <link rel="apple-touch-icon" sizes="76x76" href="/public/app-assets/images/ico/apple-icon-76.png">
    <link rel="apple-touch-icon" sizes="120x120" href="/public/app-assets/images/ico/apple-icon-120.png">
    <link rel="apple-touch-icon" sizes="152x152" href="/public/app-assets/images/ico/apple-icon-152.png">
    <link rel="shortcut icon" type="image/x-icon" href="/public/app-assets/images/ico/favicon.ico">
    <link rel="shortcut icon" type="image/png" href="/public/app-assets/images/ico/favicon-32.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="/public/app-assets/css/bootstrap.css">
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="/public/app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="/public/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="/public/app-assets/vendors/css/extensions/pace.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN ROBUST CSS-->
    <link rel="stylesheet" type="text/css" href="/public/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="/public/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="/public/app-assets/css/colors.css">
    <!-- END ROBUST CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="/public/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="/public/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="/public/assets/css/style.css">
    <!-- END Custom CSS-->
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

        <!-- navbar-fixed-top-->
    <%@include file="navbar.jsp" %>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <!-- main menu-->
    <%@include file="main_menu.jsp" %>
    <!-- / main menu-->


    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-1">
            <h2 class="content-header-title">Usuarios</h2>
          </div>
          <div class="content-header-right breadcrumbs-right breadcrumbs-top col-md-6 col-xs-12">
            <div class="breadcrumb-wrapper col-xs-12">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Inicio</a></li>
                <li class="breadcrumb-item"><a href="/users">Usuarios</a></li>
              </ol>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Basic form layout section start -->
          <section id="basic-form-layouts">
              

            <%@include file="components/modal_user_create.jsp" %>



              <!-- Bordered striped start -->
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-4" align="center">
            <input type="text" name="filter" class="form-control" placeholder="Filtro">
        </div>
        <div class="col-md-3" align="center">
            <select name="tipo_personal" id="" class="form-control">
              <option value="">Elegir Tipo personal</option>
              <option value="P" checked> Público</option>
              <option value="A"> Administrativo</option>
            </select>
        </div>
        <div class="col-md-4" align="center">
            <input type="radio" name="gender" value="male" style="margin-left: 5%"> activos
            <input type="radio" name="gender" value="female" style="margin-left: 5%"> Bajas
            <input type="radio" name="gender" value="other" checked style="margin-left: 5%">  Todos
        </div>
        <div class="col-md-1" align="center">
            <button type="button" data-toggle="modal" data-target="#user_add">
              <img src="/public/icons/agregar.png" alt="">
            </button>
        </div>
        
      </div>
    </div>
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">Usuarios Registrados</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
            </div>
            <div class="card-body collapse in">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <!-- <th>#</th> -->
                                <th>Foto</th>
                                <th>Apellidos y Nombres</th>
                                <th>Estado</th>
                                <th>M</th>
                                <th>B</th>
                                <th>H</th>
                                <th>V</th>
                                <th>K</th>
                            </tr>
                        </thead>
                        <tbody>
                          <c:forEach items="${profiles}" var="profile">
                            <tr>
                              <!-- <th scope="row">1</th> -->
                              <td><img src="/public/uploads/${profile.foto}" alt="" style="max-width: 40%;"></td>
                              <td>${profile.ap} ${profile.am} ${profile.nombre}</td>
                              <td>${profile.estado}</td>
                              <td>
                                <button type="button" data-toggle="modal" data-target="#user_modify_${profile.codp}">
                                  <img src="/public/icons/modificar.png" alt="">
                                </button>
                                <%@include file="components/modal_user_modify.jsp" %>
                              <td>
                                <button type="button" data-profile="${profile.codp}">
                                  <img src="/public/icons/eliminar.png" alt="">
                                </button>
                              </td>
                              <td>
                                <button type="button" data-profile="${profile.codp}">
                                  <img src="/public/icons/habilitar.png" alt="">
                                </button>
                              </td>
                              <td>
                                <button type="button" data-profile="${profile.codp}">
                                  <img src="/public/icons/imprimir.png" alt="">
                                </button>
                              </td>
                              <td>
                                <button type="button" data-profile="${profile.codp}">
                                  <img src="/public/icons/with_login.png" alt="">
                                </button>
                              </td>
                            </tr>
                          </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
<!-- Bordered striped end -->
          </section>
          <!-- // Basic form layout section end -->
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <%@include file="footer.jsp" %>
  </body>
</html>































 