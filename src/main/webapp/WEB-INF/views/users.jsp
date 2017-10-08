<%-- 
    Document   : index
    Created on : 16-sep-2017, 22:38:31
    Author     : ubaldino
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <%@include file="head.jsp" %>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <%@include file="navbar.jsp" %>
    <%--@include file="main_menu.jsp" --%>

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
                                <th style="width:5%" >Foto</th>
                                <th style="width:35%"  >Apellidos y Nombres</th>
                                <th style="width:10%">Estado</th>
                                <th style="width:10%">M</th>
                                <th style="width:10%">B</th>
                                <th style="width:10%">H</th>
                                <th style="width:10%">V</th>
                                <th style="width:10%">K</th>
                            </tr>
                        </thead>
                        <tbody>
                          <c:forEach items="${profiles}" var="profile">
                            <tr>
                              <!-- <th scope="row">1</th> -->

                              <td>
                                <img src="/public/uploads/${profile.foto}" alt="" style="max-width: 100%;">
                              </td>
                              <td>${profile.ap} ${profile.am} ${profile.nombre}</td>
                              <td>
                                <c:if test="${profile.estado==0}">
                                  <img src="/public/icons/inactivo.png" alt=""/>
                                </c:if>
                                <c:if test="${profile.estado==1}">
                                  <img src="/public/icons/activo.png" alt=""/>
                                </c:if>
                                
                              </td>
                              <td>
                                <button type="button" data-toggle="modal" data-target="#user_modify_${profile.codp}">
                                  <img src="/public/icons/modificar.png" alt="">
                                </button>
                                <%@include file="components/modal_user_modify.jsp" %>
                              <td>

                                <button type="button" data-profile="${profile.codp}" data-toggle="modal" data-target="#del_${profile.codp}">
                                  <img src="/public/icons/eliminar.png" alt="">
                                </button>

                                <div class="modal fade text-xs-left" id="del_${profile.codp}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                      <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                          <span aria-hidden="true">&times;</span>
                                        </button>
                                        <label class="modal-title text-text-bold-600" id="myModalLabel33">Dar de baja Usuario</label>
                                      </div>
                                      <form action="/users/${profile.codp}/delete" method="post">
                                        <div class="modal-footer text-center">
                                          <input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="Cancelar">
                                          <input type="submit" class="btn btn-outline-primary btn-lg" value="Dar Baja">
                                        </div>
                                      </form>
                                    </div>
                                  </div>
                                </div>

  

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
                                    <c:if test="${profile.user==null}">
                                      <img src="/public/icons/no_login.png" alt=""/>
                                    </c:if>
                                    <c:if test="${profile.user!=null}">
                                      <img src="/public/icons/with_login.png" alt=""/>
                                    </c:if>
                                </button>
                              </td>
                            </tr>
                          </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <br>    
        <br>    
        <br>    
    </div>
          </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <%@include file="footer.jsp" %>
  </body>
</html>































 