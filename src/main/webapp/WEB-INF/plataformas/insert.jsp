<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Nova Plataforma</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>Nova Plataforma</h1>

            <form action="/plataformas/insert" method="post">
                <div class="mb-3">
                    <label class="form-label">Descricao</label>
                    <input type="text" class="form-control" name="descricao">
                </div>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>