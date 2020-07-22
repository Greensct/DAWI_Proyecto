<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" type="text/css"/>

<title>Producto</title>
<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 20px;
	}
	.help-block{
	 background-color: red;
	 display: none;
	}
	.dataTables_length{
	 display: none;
	}
	.dataTables_filter{
		text-align: right;
	}
	.dataTables_info{
	 display: none;
	}
	.dataTables_paginate{
		cursor: pointer;
	}
	.ocultar{
		display:none;
	}
	
</style> 
</head>
<body>


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
        	Seguro de eliminar Producto? 
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <form action="deleteProducto" method="post" name="myForm">	
		  	  <input type="hidden" id="idEliminar" name="codigoProducto">
	          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
	          <button type="submit" class="btn btn-primary">Eliminar</button>
          </form>
        </div>
        
      </div>
    </div>
  </div>

	<div class="container">
		<h3 align="center">Lista de Productos</h3>
		<button type="button" data-toggle='modal'  data-target="#idModalRegistra"
				class='btn btn-primary' >Nuevo Producto</button><br>&nbsp;<br>
				
				
				
		<div id="divEmpleado">
		 								<table id="idTable" class="table table-striped table-bordered" style="width:100%">
												<thead>
														<tr>
															<th>Codigo</th>
															<th>Nombre</th>
															<th>Descripción</th>
															<th>Stock</th>
															<th>Precio</th>
															
															<th class="ocultar">Categoria</th>
															
															<th></th>
															<th></th>
															<th></th>
														</tr>
												</thead>
												<tbody>
												</tbody>
											</table>	

			</div>	
	
	
<!-- INICIO DIV NUEVO -->
<div class="modal fade bd-example-modal-lg" id="idModalRegistra" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 5px 20px">
					Registro de Producto<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
       				   </button>
				</div>
				<div class="modal-body" style="padding: 20px 20px;">
					<form id="idRegistra" accept-charset="UTF-8" action="addProducto" enctype="multipart/form-data"
													class="form-horizontal" method="post" data-toggle="validator" role="form">						
		                   
		                                	<div class="form-group">
			                                   	<label for="staticEmail">Nombre</label>
												<input class="form-control" id="idNombre" name="producto.nomprod" placeholder="Ingrese el Nombre"/>
			                                </div>    
		                                    <div class="form-group">
		                                       <label for="staticEmail">Descripción</label>
											   <textarea class="form-control" id="idDescripcion" name="producto.descripcion" rows="3" cols="10" placeholder="Ingrese Descripción"></textarea>
		                                    </div>
		                                    <div class="form-row">
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Stock</label>
														<input class="form-control" id="idStock" name="producto.stock" placeholder="Ingrese Stock"/>
			                                    </div>
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Precio</label>
														<input class="form-control" id="idPrecio" name="producto.precio" placeholder="Ingrese Precio"/>
			                                    </div>
			                                </div>    
		                                    
		                                    <div class="form-group">
		                                        <label for="staticEmail">Categoria</label>
													<select id="idCategoria" name="producto.idCategoria" class='form-control'>
							                                 <option value=" " >[SELECCIONE]</option>
							                         </select>
		                                    </div>
		                                    
		                                    <div class="form-group">
		                                        <label for="staticEmail">Foto</label>
													<input class="form-control" id="idFecha" type="file" name="producto.foto"/>
		                                    </div>
		                                    
		                                    	                                    
                        				<div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
									        <button type="submit" class="btn btn-primary">Guardar</button>
									    </div>

		            </form>      
				</div>
			</div>
		</div>
  </div>
  <!-- FIN DIV NUEVO -->
  
  <!-- INICIO DIV EDITAR -->
<div class="modal fade bd-example-modal-lg" id="idModalEditar" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 5px 20px">
					Actualizar Producto<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
       				   </button>
				</div>
				<div class="modal-body" style="padding: 20px 20px;">
					<form id="idRegistra" accept-charset="UTF-8" action="updateProducto" 
													class="form-horizontal" method="post" data-toggle="validator" role="form">						
		                   
		                   					<input type="text" id="idCodigoM" name="producto.idProducto"/>
		                                	<div class="form-group">
			                                   	<label for="staticEmail">Nombre</label>
												<input class="form-control" id="idNombreM" name="producto.nombprod" placeholder="Ingrese el Nombre"/>
			                                </div>    
		                                    <div class="form-group">
		                                       <label for="staticEmail">Descripción</label>
											   <textarea class="form-control" id="idDescripcionM" name="producto.descripcion" rows="3" cols="10" placeholder="Ingrese Descripción"></textarea>
		                                    </div>
		                                    <div class="form-row">
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Stock</label>
														<input class="form-control" id="idStockM" name="producto.stock" placeholder="Ingrese Stock"/>
			                                    </div>
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Precio</label>
														<input class="form-control" id="idPrecioM" name="producto.precio" placeholder="Ingrese Precio"/>
			                                    </div>
			                                </div>    
		                                    
		                                    <div class="form-group">
		                                        <label for="staticEmail">Categoria</label>
													<select id="idCategoriaM" name="producto.idCategoria" class='form-control'>
							                                 <option value=" " >[SELECCIONE]</option>
							                         </select>
		                                    </div>
		                                    
		                                    </div>		                                    
                        				<div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
									        <button type="submit" class="btn btn-primary">Actualizar</button>
									    </div>

		            </form>      
				</div>
			</div>
		</div>
  </div>
  <!-- FIN DIV EDITAR -->
  
  <!-- INICIO DIV FOTO -->
<div class="modal fade bd-example-modal-lg" id="idModalFoto" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 5px 20px">
					Actualizar Foto<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
       				   </button>
				</div>
				<div class="modal-body" style="padding: 20px 20px;">
					<form id="idRegistra" accept-charset="UTF-8" action="updateFotoProducto" enctype="multipart/form-data"
													class="form-horizontal" method="post" data-toggle="validator" role="form">						
		                   
		                   				<input type="text" id="idCodigoProducto" name="producto.idProducto"/>
			                            <div>
												<img id="imgFoto" width="120px" height="120px">			                            
			                            
			                            </div>
			                            <div class="form-group">
		                                        <label for="staticEmail">Foto</label>
													<input class="form-control" id="idFecha" type="file" name="producto.foto"/>
		                                </div>       
                        				<div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
									        <button type="submit" class="btn btn-primary">Actualizar</button>
									    </div>

		            </form>      
				</div>
			</div>
		</div>
  </div>
  <!-- FIN DIV FOTO -->
    
  
  
  
  
  
  
  
  
  
</div>
  


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script   src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>

<script>

</script>
<script>
	function cargarTabla(){
		$.getJSON("listAllProductos",{},function(data){
			//bucle
			$.each(data.listaProductos,function(index,item){
				var editar="<button type='button' class='btn btn-warning' "+
							"data-toggle='modal' data-target='#idModalEditar' id='idEditar'>Editar</button>";
				var eliminar="<button type='button' class='btn btn-danger' data-toggle='modal' "+
							"data-target='#myEliminar' onclick='eliminar("+item.idProducto+")'>Eliminar</button>";
				var foto="<button type='button' class='btn btn-warning' "+
							"data-toggle='modal' data-target='#idModalFoto' "+
							"onclick='foto("+item.idProducto+")'>Foto</button>";			
				$("#idTable").append("<tr><td>"+item.idProducto+"</td><td>"+item.nombre+"</td><td>"+
												item.descripcion+"</td><td>"+item.stock+"</td><td>"+
												item.precio+"</td><td class='ocultar'>"+
												item.idCategoria+"</td><td>"+editar+"</td><td>"+eliminar+"</td><td>"+
												foto+"</td></tr>");
			})
			//formato para la tabla
			$("#idTable").DataTable();
		})
	}
	function cargarComboCategoria(){
		$.getJSON("listAllCategorias",{},function(data){
			//bucle
			$.each(data.listaCategorias,function(index,item){
				$("#idCategoria").append("<option value='"+item.idCategoria+"'>"+item.nombre+"</option>");
				$("#idCategoriaM").append("<option value='"+item.idCategoria+"'>"+item.nombre+"</option>");
			})
		})
	}
	function eliminar(id){
		//alert(id);
		$("#idEliminar").val(id);
	}
	function foto(id){
		//alert(id);
		$("#idCodigoProducto").val(id);
		$.getJSON("findFotoAtProducto",{codigoProducto:id},function(data){
			if(data.baseFoto!=null)
				$("#imgFoto").attr("src","data:image/jpg;base64,"+data.baseFoto);
			else
				$("#imgFoto").attr("src","img/image-not-found.png");
			
		})
	}
	
	
	//asignar el evento clic al botón cuyo identificador ed idEditar
	$(document).on("click","#idEditar",function(){
		var cod=$(this).parents("tr").find("td")[0].innerHTML;
		var nom=$(this).parents("tr").find("td")[1].innerHTML;
		var des=$(this).parents("tr").find("td")[2].innerHTML;
		var stock=$(this).parents("tr").find("td")[3].innerHTML;
		var pre=$(this).parents("tr").find("td")[4].innerHTML;
		
		var idCat=$(this).parents("tr").find("td.ocultar")[0].innerHTML;
		
		
		$("#idCodigoM").val(cod);
		$("#idNombreM").val(nom);
		$("#idDescripcionM").val(des);
		$("#idStockM").val(stock);
		$("#idPrecioM").val(pre);
		
		$("#idCategoriaM").val(idCat);
		$("#idCategoriaM").trigger("change");
		
	})


<script type="text/javascript">    
    $(document).ready(function(){     
        $('#idRegistra').bootstrapValidator({      
        	 fields:{
        		 
        		 Nombre: {
     	    		selector:'#idNombre',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese nombre'    
                        },      
                        regexp: {    
                            regexp: /^[a-zA-Z\s]+$/,    
                            message: 'The username can only consist of alphabetical, number, dot and underscore'    
                        },    
                    }    
                },   
                Descripcion: {
     	    		selector:'#idDescripcion',       
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Descrpción'    
                        }   
                    }    
                },    
                Stock: {
     	    		selector:'#idStock',      
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Stock'    
                        },       
                    }    
                },    
                Precio: {
     	    		selector:'#idPrecio',     
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Precio'    
                        },       
                    }    
                }, 
                Fecha: {
     	    		selector:'#idFecha',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Fecha'    
                        },					
                    }    
                },   				
                Categoria: {
     	    		selector:'#idCategoria',   
                    validators: {    
                        notEmpty: {    
                            message: 'Seleccione Categoria'    
                        },					
                    }    
                } 
        	 }
        });   
			
    });   
</script>   


</body>
</html>












