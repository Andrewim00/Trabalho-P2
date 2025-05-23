<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <title>Editar Gênero</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
     
</head>

<body>
    <h1>Edição de Gênero</h1>

    <form action="/generos/update" method="post">
        <input type="hidden" name="id" value="${generos.id}">
        <div>
            <label class="form-label">Nome do Gênero</label>
            <input class="form-control" type="text" name="nome" value="${generos.nome}">
        </div>
        <button class="btn btn-success" type="submit">Salvar</button>
    </form>
</body>
</html>
