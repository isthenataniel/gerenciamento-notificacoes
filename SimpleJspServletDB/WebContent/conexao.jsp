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
<title>Adicionar novo exame</title>
</head>
<body>
    <form method="POST" action='ExameController' name="frmAdd">
        ID : <input type="text" readonly="readonly" name="id"
            value="<c:out value="${exame.id}" />" /> <br /> 
        Nome : <input
            type="text" name="nome" required="true"
            value="<c:out value="${exame.nome}" />" /> <br /> 
        Código : <input
            type="text" name="codigo" required="true"
            value="<c:out value="${exame.codigo}" />" /> <br /> 
         <input type="submit" value="Salvar" />
    </form>
</body>
</html>