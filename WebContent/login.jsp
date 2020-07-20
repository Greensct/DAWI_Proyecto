<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<html lang="esS">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GStore - Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body>
  <!--  Caabecera Menu -->
<div class="pos-f-t">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="navbar-header">
               <div class="navbar-header">
                  <a class="navbar-brand" href="principal.jsp">GStore</a>
                  </div>
          </div>

      <div class="collapse navbar-collapse">
          <ul class="navbar-nav">

          </ul>

          <div class="navbar-nav ml-auto">
				<a href="login.jsp" class="nav-item nav-link">Iniciar Sesion</a>
                <a href="registro.jsp" class="nav-item nav-link">Registrarse</a>
          </div>
    </div>
    </nav>
</div>
<!-- Cuerpo -->
	  <s:if test="${sessionScope.MENSAJE !=null}">
		<div class="alert alert-warning alert-dismissible fade show" role="alert" id="success-alert">
		  <strong>Sistema:</strong> ${sessionScope.MENSAJE}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		</s:if>
	  <s:remove var="MENSAJE"/>

    <div class="container">
      <form class="form-signin" action="iniciarSesion">
        <h2 class="form-signin-heading">Login</h2>
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input type="text" name="login" id="inputEmail" class="form-control" placeholder="Ingrese el usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="clave" id="inputPassword" class="form-control" placeholder="Ingrese el password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      </form>
    </div>
    <p>No tienes una cuenta? Registrate <a href="registro.jsp">aqui</a></p>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script   src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	    
  </body>
</html>
