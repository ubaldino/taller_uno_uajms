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
              <!--
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header">
                    <h4 class="card-title" id="basic-layout-colored-form-control">Registrar Usuario</h4>
                    <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                  </div>
                  <div class="card-body collapse in">
                    <div class="card-block">
                      <form:form action="/users" method="post" modelAttribute="user" class="form">
                        <div class="form-body">
                          <div class="row">
                            <div class="col-md-4">
                              <div class="form-group">
                                <form:input path="login" cssClass="form-control border-primary" placeholder="Login" /> 
                                <form:errors path="login" cssClass="text-danger" />

                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <form:input path="password" cssClass="form-control border-primary" placeholder="Password"/> 
                                <form:errors path="password" cssClass="text-danger" />
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <button type="submit" class="btn btn-primary"><i class="icon-check2"></i>Registrar</button>
                              </div>
                            </div>
                          </div>
                        </div>
                      </form:form>
                    </div>
                  </div>
                </div>
              </div>
              -->
<button type="button" class="btn btn-warning btn-md" data-toggle="modal" data-target="#user_add">
  Agregar Usuario
</button>
<div class="modal fade text-xs-left" id="user_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel33">Inline Login Form</label>
      </div>
<form:form action="/users" method="post" modelAttribute="user" class="form">
  <div class="form-body">
    <div class="row" align="center">
      <div class="col-md-12">
        <div class="form-group">
          <table>
            <tr>
              <td>
                <label for="codp" class="form-label">Cedula</label>
              </td>
              <td>
                <input type="text" name="codp" placeholder="Cedula" class="form-control border-primary">
              </td>
            </tr>
            <tr>
              <td>
                <label for="nombre" class="form-label">Nombre</label>
              </td>
              <td>
                <input type="text" name="nombre" placeholder="Nombre" class="form-control border-primary">
              </td>
            </tr>
            <tr>
              <td>
                <label for="ap" class="form-label">AP. Paterno</label>
              </td>
              <td>
                <input type="text" name="ap" placeholder="AP. Paterno" class="form-control border-primary">
              </td>
            </tr>
            <tr>
              <td>
                <label for="am" class="form-label">AP. Materno</label>
              </td>
              <td>
                <input type="text" name="am" placeholder="AP. Materno" class="form-control border-primary">
              </td>
            </tr>
            <tr>
              <td>
                <label for="codp" class="form-label">Género</label>
              </td>
              <td>
                <input type="radio" name="genero" value="1" >Masculino
                <input type="radio" name="genero" value="0" >Femenino
              </td>
            </tr>
            <tr>
              <td>
                <label for="fnac" class="form-label">F. Nacimiento</label>
              </td>
              <td>
                <input type="date" name="fnac" placeholder="Fecha de Nacimiento" class="form-control border-primary">
              </td>
            </tr>
            <tr>
              <td>
                <label for="codp" class="form-label">E. Civil</label>
              </td>
              <td>
                <input type="radio" name="genero" value="1" >Soltero
                <input type="radio" name="genero" value="0" >Casado
                <input type="radio" name="genero" value="0" >Divorciado
              </td>
            </tr>
            <tr>
              <td>
                <label for="codp" class="form-label">Tipo Personal</label>
              </td>
              <td>
                <select name="tipo_personal" id="" >
                  <option value="volvo">Elegir Tipo personal</option>
                  <option value="público">Público</option>
                  <option value="administrativo">Administrativo</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>
                <label for="codp" class="form-label">Foto</label>
              </td>
              <td>
                <input type="file" name="foto" accept="image/*"/>
              </td>
            </tr>
            
          </table>
          <form:input path="login" cssClass="form-control border-primary" placeholder="Login" /> 
          <form:errors path="login" cssClass="text-danger" />
        </div>
      </div>
      <div class="col-md-4">
        <div class="form-group">
          <form:input path="password" cssClass="form-control border-primary" placeholder="Password"/> 
          <form:errors path="password" cssClass="text-danger" />
        </div>
      </div>
      
    </div>
    
    <div class="row" align="center">
      <div class="col-md-6">
        <div class="form-group">
          <button type="submit" class="btn btn-primary btn-md">Guardar</button>
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-group">
          <button type="reset" class="btn btn-outline-secondary btn-md" data-dismiss="modal">Cancelar</button>
        </div>
      </div>
    </div>
  </div>
</form:form>
   </div>
  </div>
</div>




              <!-- Bordered striped start -->
    <div class="col-md-12">
      <table>
        <tr>
          <td>
            <input type="text" name="filter" placeholder="Filtro">
          </td>
          <td>
            <select name="tipo_personal" id="" >
              <option value="volvo">Elegir Tipo personal</option>
              <option value="volvo">Volvo</option>
              <option value="saab">Saab</option>
              <option value="mercedes">Mercedes</option>
              <option value="audi">Audi</option>
            </select>
          </td>
          <td>
            <input type="radio" name="gender" value="male" >activos
          </td>
          <td>
            <input type="radio" name="gender" value="female">Bajas
          </td>
          <td>
            <input type="radio" name="gender" value="other" checked>Todos
          </td>
        </tr>
      </table>
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
     <!--                            <th>Login</th>
                                <th>Estado</th> -->
                                <th>acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                          <c:forEach items="${users}" var="user">
                            <tr>
                              <!-- <th scope="row">1</th> -->
                              <td>Foto</td>
                              <td>Apellidos y Nombres</td>
                              <td>Estado</td>
                              <td>M</td>
                              <td>B</td>
                              <td>H</td>
                              <td>V</td>
                              <td>K</td>
<!--                               <td>${user.login}</td>
                              <td>${user.estado}</td> -->
                              <td>
                                <!-- <button type="button" class="btn btn-warning btn-md">Modificar</button> -->
                                <!-- <button type="button" class="btn btn-warning btn-md" data-toggle="modal" data-target="#form_${user.login}">
                                  Modificar
                                </button>
                                 -->
                                <!-- Modal -->
                  <div class="modal fade text-xs-left" id="form_${user.login}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                          <label class="modal-title text-text-bold-600" id="myModalLabel33">Inline Login Form</label>
                        </div>
                      <form:form action="/users" method="post" modelAttribute="user" class="form">
                        <div class="form-body">
                          <div class="row">
                            <div class="col-md-4">
                              <div class="form-group">
                                <form:input path="login" cssClass="form-control border-primary" placeholder="Login" /> 
                                <form:errors path="login" cssClass="text-danger" />
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <form:input path="password" cssClass="form-control border-primary" placeholder="Password"/> 
                                <form:errors path="password" cssClass="text-danger" />
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <button type="submit" class="btn btn-primary"><i class="icon-check2"></i>Registrar</button>
                              </div>
                            </div>
                          </div>
                        </div>
                      </form:form>
                        <!-- <form action="/users/update">
                            <div class="modal-body">
                          <label>Email: </label>
                          <div class="form-group">
                            <input type="text" placeholder="Email Address" class="form-control">
                          </div>

                          <label>Password: </label>
                          <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control">
                          </div>
                          </div>
                          <div class="modal-footer">
                          <input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="close">
                          <input type="submit" class="btn btn-outline-primary btn-lg" value="Login">
                          </div>
                        </form> -->
                      </div>
                    </div>
                  </div>
<!-- 
                                <button type="button" class="btn btn-danger btn-md" data-toggle="modal" data-target="#del_${user.login}">
                                  Eliminar
                                </button> -->

                                               <!-- Modal -->
                  <div class="modal fade text-xs-left" id="del_${user.login}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                          <label class="modal-title text-text-bold-600" id="myModalLabel33">Eliminar Usuario</label>
                        </div>
                        <form action="/users/${user.login}/delete" method="post">
                          <div class="modal-footer text-center">
                            <input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-outline-primary btn-lg" value="Eliminar">
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
  


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































 