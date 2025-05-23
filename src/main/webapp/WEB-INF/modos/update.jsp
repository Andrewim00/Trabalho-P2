<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <title>Editar Modo</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
     
</head>

<body>
    <h1>Edição de Modo</h1>

    <form action="/modos/update" method="post">
        <input type="hidden" name="id" value="${modos.id}">
        <div>
            <label class="form-label">Descrição do Modo</label>
            <input class="form-control" type="text" name="descricao" value="${modos.descricao}">
        </div>
        <button class="btn btn-success" type="submit">Salvar</button>
    </form>
</body>
</html>
