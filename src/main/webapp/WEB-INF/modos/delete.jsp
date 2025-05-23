<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Remover Modo</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />

    </head>

    <body>
        <h1>Remover Modo</h1>

        <p>Deseja mesmo EXCLUIR o Modo: ${modos.descricao} ?</p>
        <form action="/modos/delete" method="post">
            <input type="hidden" name="id" value="${modos.id}">
            <button class="btn btn-danger" type="submit">Excluir</button>
        </form>
    </body>
</html>