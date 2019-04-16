<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Clientes</title>
</head>
<body>
    <table class="listagem" border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Inicio</th>
                <th>Fim</th>
                <th>Hash</th>
                <th colspan=2>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.clienteId}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.email}" /></td>
                    <td><c:out value="${cliente.inicio}" /></td>
                    <td><c:out value="${cliente.fim}" /></td>
                    <td><c:out value="${cliente.hash}" /></td>
                    <td><a href="ClienteController?action=edit&id=<c:out value="${cliente.id}"/>">Editar</a></td>
                    <td><a href="ClienteController?action=delete&id=<c:out value="${cliente.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div style="margin-top: 5px;"><a class="btn-incluir" href="ClienteController?action=insert">Adicionar cliente</a>
    <a class="btn-cancelar" href="http://localhost:8080/GerenciamentoNotificacoescacoes/">Voltar menu</a></div>
</body>
</html>