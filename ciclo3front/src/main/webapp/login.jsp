<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script src="jquery.js" type="text/javascript"></script>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Login_style.css">
	<script src="https://kit.fontawesome.com/821bc30c51.js" crossorigin="anonymous"></script>
	<title>
		Login
	</title>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		    <a class="navbar-brand" href="#">
		    	<img class="logo" src="img/logo.png">
		    </a>
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item">
		        <a class="nav-link" href="#">Mujer</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Hombre</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Ni�os</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Ofertas</a>
		      </li>
		    </ul>
		    <form class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
		  </div>
		</nav>
	</header>
	<section class="login">
		<h1>Iniciar sesi�n</h1>
		<form method="get" action="./DemoServlet" >
			<label for="user">Usuario:</label><br>
			<input class="controles" type="text" name="user" id="user" value=""><br>
			<label for="password">Contrase�a:</label><br>
			<input class= "controles" type="password" name="password" id="password" value=""><br>
			<div class="check">
				<input style="margin-right: 7px;" type="checkbox" name="mostrar" id="mostrar_contrase�a">Mostrar contrase�a<br>
			</div>
			<button type="submit" class="btn btn-primary btn-grad mb-2">Continuar</button>
			<p>
				�No estas registrado? 
				<a href=""> Registrarse</a><br>
				<a href="">�Olvidaste tu contrase�a?</a>
			</p>
			
			<script>
			$(document).ready(function () {
			  $('#mostrar_contrase�a').click(function () {
			    if ($('#mostrar_contrase�a').is(':checked')) {
			      $('#contrase�a').attr('type', 'text');
			    } else {
			      $('#contrase�a').attr('type', 'password');
			    }
			  });
			});
			</script>

			<?php
				include("log.php");
			?>
		</form> 
	</section>
	<footer>
		<div class="barra-footer">
			&copy; Derechos Reservados
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>