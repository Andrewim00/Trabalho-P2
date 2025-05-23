<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Editar Jogo</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container">
            <h1>Editar Jogo</h1>

            <form action="/jogos/update" method="post">
                <input type="hidden" name="id" value="${jogos.id}">
                <div>
                    <label class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" value="${jogos.titulo}"/>
                </div>

                <div>
                    <label class="form-label">Modo</label>
                    <select class="form-select" name="id_modo">
                        <c:forEach var="m" items="${modos}">
                            <option ${jogos.modo.id == m.id ? "selected" : ""} value="${m.id}">${m.descricao}</option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <label class="form-label">Gêneros</label>
                    <c:forEach var="g" items="${generos}">
                        <div class="form-check">
                            <input ${jogos.generos.contains(g) ? "checked" : ""} type="checkbox" name="generos" value="${g.id}" class="form-check-input" />
                            <label class="form-check-label">${g.nome}</label>
                        </div>
                    </c:forEach>
                </div>

                   <div>
                    <label class="form-label">Plataformas</label>
                    <c:forEach var="p" items="${plataformas}">
                        <div class="form-check">
                            <input ${jogos.plataformas.contains(p) ? "checked" : ""} type="checkbox" name="plataformas value="${p.id}" class="form-check-input" />
                            <label class="form-check-label">${p.descricao}</label>
                        </div>
                    </c:forEach>
                </div>

                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>