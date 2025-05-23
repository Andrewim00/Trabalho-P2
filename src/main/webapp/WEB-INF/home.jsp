<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <title>Home</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container">
            <h1>Plataforma de Cadastro de Gerenciamento de Jogos</h1>
            <a href="/jogos/list" class="btn btn-primary">Jogos</a>

            <div class="row row-cols-auto">
                <div class="col">
                    <a href="/generos/list" class="btn btn-secondary">Gêneros</a>
                </div>
                <div class="col">
                    <a href="/plataformas/list" class="btn btn-secondary">Plataformas</a>
                </div>
                <div class="col">
                    <a href="/modos/list" class="btn btn-secondary">Modos</a>
                </div>
            </div>
        </div>
    </body>
</html>