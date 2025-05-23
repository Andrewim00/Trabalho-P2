<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Remover Jogo</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container">
            <h1>Remover Jogo</h1>
            <p>Deseja realmente REMOVER o jogo "${jogo.titulo}"?</p>
            <form action="/jogos/delete" method="post">
                <input type="hidden" name="id" value="${jogo.id}" />
                <button type="submit" class="btn btn-danger">Excluir</button>
            </form>
        </div>
    </body>
</html>