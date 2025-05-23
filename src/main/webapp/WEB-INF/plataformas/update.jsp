<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <title>Editar Plataforma</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
     
</head>

<body>
    <h1>Edição de Plataforma</h1>

    <form action="/plataformas/update" method="post">
        <input type="hidden" name="id" value="${plataformas.id}">
        <div>
            <label class="form-label">Descrição da Plataforma</label>
            <input class="form-control" type="text" name="descricao" value="${plataformas.descricao}">
        </div>
        <button class="btn btn-success" type="submit">Salvar</button>
    </form>
</body>
</html>
