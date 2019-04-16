<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Medicamentos</title>
</head>
<body>
    <table class="listagem" border="1" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Medicamento</th>
                <th>Descrição</th>
                <th colspan=2>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${medicamentos}" var="medicamento">
                <tr>
                    <td><c:out value="${medicamento.id}" /></td>
                    <td><c:out value="${medicamento.nome}" /></td>
                    <td><c:out value="${medicamento.descricao}" /></td>
                    <td><a href="MedicamentoController?action=edit&id=<c:out value="${medicamento.id}"/>">Editar</a></td>
                    <td><a href="MedicamentoController?action=delete&id=<c:out value="${medicamento.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div style="margin-top: 5px;"><a class="btn-incluir" href="MedicamentoController?action=insert">Adicionar medicamento</a>
         <a class="btn-cancelar" href="http://localhost:8080/GerenciamentoNotificacoes/">Voltar menu</a></div>
</body>
</html>