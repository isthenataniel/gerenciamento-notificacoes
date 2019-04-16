<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Sistema de gerenciamento de notificações</title>
        <!--<link rel="stylesheet" type="text/css" href="css/style.css" />-->
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="bootstrap/js/bootstrap.min.js" />
    </head>
    <body>
        <fieldset>
            <legend align="center">Sistema de gerenciamento de notificações</legend>
            <nav id="menu">
                <div><a class="btn btn-primary" href="ExameController?action=list">Sistema/Cliente</a>
                <a class="btn btn-primary" href="MedicamentoController?action=list">Conexões</a>
                <a class="btn btn-primary" href="PacienteController?action=list">Alertas/Notificações</a>
                </div>
            </nav>            
        </fieldset>
    </body>
</html>