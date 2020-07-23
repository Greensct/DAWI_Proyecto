<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" type="text/css"/>

<title> Pagina Producto</title>
</head>
<body>
<table border="0" align="center" width="1000">
<tr bgcolor="skyblue">
<th><a href="">Catalogo</a></th>
<th><a href="">Registrar Producto</a></th>
<th><a href="">Consultar Ventas</a></th>
<th><a href=""></a></th>
<th width="200"></th>
</tr>
</table>
<h2 align="center">Catalogo de productos</h2>
<table border="0" align="center" width="1000">
<%
ArrayList<Producto> lista = Producto.Obtieneproducto();
int salto=0;
for (Producto p : lista){
%>
<th><img srv="img/<>" width"140" height="140"><p>
<%=nombre()%><br>
<%=precio()%><p>
<a href="">Modificar</a> ||
<a href="">Añadir</a>
</th>
<%
   salto++;
if(salto==3){
%>
<tr>
<%

%>
</table>
</body>
</html>
