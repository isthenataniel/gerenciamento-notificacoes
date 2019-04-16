<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Adicionar novo cliente</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=data]').datepicker();
        });
    </script>
    <form method="POST" action='ClienteController' name="frmAdd">
        <table class="insercao" border="0">
            <tr>
                <th>ID :</th><th><input type="text" readonly="readonly" name="id" value="<c:out value="${cliente.id}" />" /> </th> 
            </tr>
            <tr>
                <th>Nome :</th><th><input type="text" readonly="readonly" name="nome" value="<c:out value="${cliente.nome}" />" /> </th> 
            </tr>
            <tr>
                <th>E-mail :</th><th><input type="text" readonly="readonly" name="email" value="<c:out value="${cliente.email}" />" /> </th> 
            </tr>
            <tr>
                <th>Início:</th><th><input type="text" name="inicio" required="true" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cliente.inicio}" />" /> </th>
            </tr>
            <tr>
                <th>Fim:</th><th><input type="text" name="fim" required="true" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cliente.fim}" />" /> </th>
            </tr>
        </table> 
        <input type="submit" value="Salvar" />
    </form>
</body>
</html>