<?php 
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}
	include_once("../../clases/0dataBase.php");

  	for($i=0; $i <= 7; $i++)
	$calzadoInfo[$i] = "";
	include_once("buscarCalzadoPHP.php");
	include_once("eliminarCalzadoPHP.php")
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Eliminar calzado</title>
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
		
		<form id="buscarCalzado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
			<label for="codigo" class="">Codigo:</label>
			<input type="text" class="form-control" name="codigo" placeholder="#SalTipoMrca#Mlo_Cdo#id">
			
			<button id="buscar" type="submit" class="btn btn-lg btn-success btn-block" name="buscar"><i class="icon-hand-right"></i>Buscar</button>												

		</form>
		
	</div>
	<div class=" clearfix col-xs-9">
		
			<table class="table">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Alias</th>
						<th>Tipo</th>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Fecha</th>
						<th>Id Calzado</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$calzadoInfo[0];?></td>
						<td><?=$calzadoInfo[1];?></td>
						<td><?=$calzadoInfo[2];?></td>
						<td><?=$calzadoInfo[3];?></td>
						<td><?=$calzadoInfo[4];?></td>
						<td><?=$calzadoInfo[5];?></td>
						<td><?=$calzadoInfo[6];?></td>
					</tr>
				</tbody>
		</table>
		
		
		<form id="eliminarCalzado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			<button id="eliminar" type="submit" class="btn btn-lg btn-danger btn-block" name="eliminar">Eliminar</button>
		</form>

	</div>

</body>
</html>
