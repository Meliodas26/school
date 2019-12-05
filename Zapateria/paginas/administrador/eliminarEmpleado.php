<?php  
	session_start();
	 
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}

  	for($i=0; $i <= 7; $i++)
		$usuarioInfo[$i] = "";
	$_SESSION["boolean"] = "true";
	include_once("buscarEmpleadoPHP.php");
	include_once("eliminarEmpleadoPHP.php");
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Buscar empleado</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<script src="../../js/bootstrap.min.js" ></script>
	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
	</style>
</head>
<body>
	
	<div class="clearfix col-xs-3">
		
		<form id="buscarEmpleado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
			<label for="idUsuario" class="">idUsuario:</label>
			<input type="text" class="form-control" name="idUsuario" placeholder="#">

			<label for="usuario" class="">Usuario:</label>
			<input type="text" class="form-control" name="usuario" placeholder="usuario">

			<label for="nombre" class="">Nombre:</label>
			<input type="text" class="form-control" name="nombre" placeholder="Nombre">
			
			<button id="buscar" type="submit" class="btn btn-lg btn-success btn-block" name="buscar"><i class="icon-hand-right"></i>Buscar</button>												

		</form>
		
	</div>
	<div class=" clearfix col-xs-9">
		
			<table class="table">
				<thead>
					<tr>
						<th>idUsuario</th>
						<th>Cargo</th>
						<th>Nombre</th>
						<th>Usuario</th>
						<th>Contraseña</th>
						<th>Telefono</th>
						<th>Sucursal</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$usuarioInfo[0];?></td>
						<td><?=$usuarioInfo[3];?></td>
						<td><?=$usuarioInfo[4];?></td>
						<td><?=$usuarioInfo[1];?></td>
						<td><?=$usuarioInfo[2];?></td>
						<td><?=$usuarioInfo[5];?></td>
						<td><?=$usuarioInfo[6];?></td>
					</tr>
				</tbody>
			</table>
		
		<form id="eliminarEmpleado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			<button id="eliminar" type="submit" class="btn btn-lg btn-danger btn-block" name="eliminar">Eliminar</button>
		</form>

	</div>

</body>
</html>
