<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Modos</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>Modos</h1>
            <a href="/modos/insert" class="btn btn-primary">Novo Modo</a>

            <table class="table">
                <tr>
                    <th>id</th>
                    <th>descricao</th>
                </tr>

                <c:forEach var="g" items="${modos}">
                    <tr>
                        <td>${g.id}</td>
                        <td>${g.descricao}</td>
                        <td>
                            <a href="/modos/update/${g.id}" class="btn btn-primary">Editar </a>
                            <a href="/modos/delete/${g.id}" class="btn btn-primary">Excluir </a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>