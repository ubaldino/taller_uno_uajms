<%-- 
    Document   : login
    Created on : 17-sep-2017, 11:16:06
    Author     : ubaldino
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <%@include file="head.jsp" %>
  <body data-open="click" data-menu="vertical-menu" data-col="1-column" class="vertical-layout vertical-menu 1-column  blank-page blank-page">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body">
            <section class="flexbox-container">
                <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1  box-shadow-2 p-0">
                    <div class="card border-grey border-lighten-3 m-0">
                        <div class="card-header no-border">
                            <div class="card-title text-xs-center">
                                <div class="p-1">
                                    <img src="/public/app-assets/images/logo/logo_csma.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                            <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2">
                            <span>Ingrese al sistema</span></h6>
                        </div>
                        <div class="card-body collapse in">
                            <div class="card-block">
                                <form:form id="loginForm" method="post" action="/login" modelAttribute="loginBean" class="form-horizontal form-simple">
                                    <fieldset class="form-group position-relative has-icon-left mb-0">
                                        <form:input id="login" name="login" path="login" class="form-control form-control-lg input-lg" placeholder="Usuario" required=true/>
                                        <div class="form-control-position"><i class="icon-head"></i></div>
                                    </fieldset>
                                    <fieldset class="form-group position-relative has-icon-left">
                                        <form:password id="password" name="password" path="password" class="form-control form-control-lg input-lg" placeholder="Contraseña" required=true/>
                                        <div class="form-control-position"><i class="icon-key3"></i></div>
                                    </fieldset>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">
                                        <i class="icon-unlock2"></i> Ingresar
                                    </button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <%--@include file="footer.jsp"--%>
  </body>
</html>





