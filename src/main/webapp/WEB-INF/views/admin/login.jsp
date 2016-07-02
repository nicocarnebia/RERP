<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<layout:extends name="fullwidth_form">

    <layout:put block="content">
        <div class="login-box">
            <div class="login-logo">
                <a href="#"><b>Admin</b>ERP</a>
            </div>
            <div class="login-box-body">
                <p class="login-box-msg">Iniciar sesión</p>

                <form method="POST" action="${contextPath}/login" class="form-signin">
                    <div class="form-group ${error != null ? 'has-error' : ''}">
                        <span>${message}</span>
                        <div class="form-group has-feedback">
                            <input type="text" name="username" class="form-control" placeholder="Usuario">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" name="password" class="form-control" placeholder="Contraseña">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <span>${error}</span>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="row">
                            <div class="col-xs-8">
                              <!--  <a href="${contextPath}/registration">Crear cuenta</a> -->
                            </div>
                            <!-- /.col -->
                            <div class="col-xs-4">
                                <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </div>
                </form>
            </div>       
        </div>
    </layout:put>
</layout:extends>

