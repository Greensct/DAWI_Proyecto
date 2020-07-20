<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GStore - Registro</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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
    <div class="container">
     <form id="idRegistra" accept-charset="UTF-8" action="addUsuario" 
													class="form-horizontal" method="post" data-toggle="validator" role="form">						
		                   
		                                	<div class="form-group">
			                                   	<label for="staticEmail">Nombre</label>
												<input class="form-control" id="idNombre" name="nombres" placeholder="Ingrese el Nombre"/>
			                                </div>    
		                                    <div class="form-group">
		                                       <label for="staticEmail">Apellido</label>
											   <input class="form-control" id="idDescripcion" name="apellidos" placeholder="Ingrese Apellido">
		                                    </div>
		                                    <div class="form-row">
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Edad</label>
														<input class="form-control" id="idStock" name="email" placeholder="Ingrese Edad"/>
			                                    </div>
			                                 </div>
			                                 <div class="form-row">
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Contraseña</label>
														<input class="form-control" type="password" id="idStock" name="contra" placeholder="Ingrese Contraseña"/>
			                                    </div>
			                                 </div> 
                             	                                    
                        				<div class="modal-footer">
									        <button type="submit" class="btn btn-primary">Guardar</button>
									    </div>

		            </form>      

    </div>
   
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script   src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	    





</body>
</html>