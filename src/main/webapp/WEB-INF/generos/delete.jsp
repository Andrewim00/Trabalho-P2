<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Remover Gênero</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />

    </head>

    <body>
        <div class="container">
            <h1>Remover Gênero</h1>

            <p>Deseja mesmo EXCLUIR o gênero: ${generos.nome} ?</p>
            <form action="/generos/delete" method="post">
                <input type="hidden" name="id" value="${generos.id}">
                <button class="btn btn-danger" type="submit">Excluir</button>
            </form>
        </div>
    </body>
</html>