<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Remover Plataforma</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />

    </head>

    <body>
        <div class="container">
            <h1>Remover Plataforma</h1>

            <p>Deseja mesmo EXCLUIR a Plataforma: ${plataformas.descricao} ?</p>
            <form action="/plataformas/delete" method="post">
                <input type="hidden" name="id" value="${plataformas.id}">
                <button class="btn btn-danger" type="submit">Excluir</button>
            </form>
        </div>
    </body>
</html>