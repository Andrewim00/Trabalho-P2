<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Jogos</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>Jogos</h1>
            <a href="/jogos/insert" class="btn btn-primary">Novo Jogo</a>

            <table class="table">
                <tr>
                    <th>id</th>
                    <th>Título</th>
                    <th>Gêneros</th>
                    <th>Plataformas</th>
                    <th>Modo</th>
                    <th>&nbsp;</th>
                </tr>

                <c:forEach var="j" items="${jogos}">
                    <tr>
                        <td>${j.id}</td>
                        <td>${j.titulo}</td>
                        <td>${j.modo.descricao}</td>
                        <td>
                            <c:forEach var="g" items="${j.generos}">
                                ${g.nome}
                            </c:forEach>
                        </td>
                         <td>
                            <c:forEach var="p" items="${j.plataformas}">
                                ${p.descricao}
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/jogos/update/${j.id}" class="btn btn-primary">editar</a>
                            <a href="/jogos/delete/${j.id}" class="btn btn-danger">remover</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>