<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" type="text/css"/>

<meta charset="ISO-8859-1">
<title>GStore</title>
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
<h2>Bienvenido a GStore!</h2>
<s:if test="${sessionScope.MENSAJE !=null}">
<div class="alert alert-warning alert-dismissible fade show" role="alert" id="success-alert">
  <strong>Sistema:</strong> ${sessionScope.MENSAJE}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</s:if>
<s:remove var="MENSAJE"/>

<!-- The Modal -->
  <div class="modal fade" id="myEliminar" data-backdrop="static">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Sistema</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        	Seguro de eliminar medicamento? 
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <form action="deleteMedicamento" method="post" name="myForm">	
		  	  <input type="hidden" id="idEliminar" name="codigoMedicamento">
	          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
	          <button type="submit" class="btn btn-primary">Eliminar</button>
          </form>
        </div>
        
      </div>
    </div>
  </div>

	<div class="container">
	<br>&nbsp;<br>		
				
		<div id="divEmpleado">
		 								<table id="idTable" class="table table-striped table-bordered" style="width:100%">
												<thead>
														<tr>
															<th>Imagen</th>
															<th>Nombre</th>
															<th>Descripción</th>
															<th>Precio</th>
															<th>Categoria</th>
															<th>Stock</th>
															<th>Comprar</th>
														</tr>
												</thead>
												<tbody>
												</tbody>
											</table>	

			</div>	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script   src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>		
<script>
var idTipo=0;

$(document).ready(function() {
	cargarTabla();
});
</script>
<script>
	function cargarTabla(){
		$.getJSON("listAllPrincipal",{},function(data){
			//Bucle
			$.each(data.listaProductos,function(index,item){
				var editar="<p>ctmre</p>";
				var comprar="<button type='button' class='btn btn-primary' "+
							"data-toggle='modal' data-target='#idModalFoto' "+
							"onclick='foto("+item.idMedicamento+")'>Comprar</button>";			
				$("#idTable").append("<tr><td>"+item.idproducto+"</td><td>"+item.nomprod+"</td><td>"+
												item.descripcion+"</td><td>"+item.precio+"</td><td>"+
												item.nombrcategoria+"</td><td>"+item.stock+"</td><td>"
												+comprar+"</td></tr>");
			})
			//Formato para la tabla
			$("#idTable").DataTable();
		})
	}
	</script>
</body>
</html>