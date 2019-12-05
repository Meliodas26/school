<?php 
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}
	include_once("../../clases/0dataBase.php");

	$objConexion = new conexion();

	$conexion = $objConexion->getConexion();


  	for($i=0; $i <= 7; $i++)
	$calzadoInfo[$i] = "";
	include_once("buscarCalzadoPHP.php");
	include_once("modificarCalzadoPHP.php");
?>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Buscar y modificar Calzado</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<script src="../../js/bootstrap.min.js" ></script>

	<script type="text/javascript" src="../../jQuery/jQuery.js"></script>
	<script type="text/javascript" src="../../jQuery/jquery-3.3.1.js"></script>
	<script src="../../js/calzado.js" ></script>

	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
	</style>
	<link rel="stylesheet" href="../../css/text.css" >
</head>
<body>
	
	<div class="clearfix col-xs-3 row-xs-12">
		
		<form id="buscarCalzado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
			<label for="codigo" class="">Codigo:</label>
			<input type="text" class="form-control" name="codigo" placeholder="#SalTipoMrca#Mlo_Cdo#id">
			
			<button class="btn btn-lg btn-success btn-block" type="submit" name="buscar">Buscar</button>
														
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

		<form id="calzado" class="modificarCalzado" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" >
	      
		    <h1 class="h3 mb-3 font-weight-normal">Editar información</h1>
		      
		    <div class="row">
			  	<div class="col-xs-3 form-group">
					<label for="alias">Alias:</label>
			    	<input id="alias" type="text" class="form-control" name="alias" value = "<?=$calzadoInfo[1];?>" placeholder="<?=$calzadoInfo[1];?>" >
			    	<p id="errorAlias" class="text-correccion"></p>
				</div>
				<div class="col-xs-3">
					<label class="tipo">Tipo:</label>
			    	<select class="form-control" name="tipo" >
			    		<option><?=$calzadoInfo[2];?></option>
						<option>Colegial</option>
						<option>Huarache</option>
         				<option>Otro</option>
						<option>Tennis</option>
					</select>
				</div>

				<div class="col-xs-3">
					
				<input id="modificarCalzado" type="submit" value="Modificar" class="btn btn-lg btn-warning btn-block" name="modificar"/>
				</div>
			</div>


			<div class="row">
			  	<div class="col-xs-3 form-gropu">
					<label for="modelo" class="">Modelo:</label>
			    	<input id ="modelo" class="form-control" value="<?=$calzadoInfo[4];?>" placeholder="<?=$calzadoInfo[4];?>"  name="modelo" >
			    	<p class="text-correccion" id="errorModelo"></p>
				</div>
				<div class="col-xs-3">
					<label class="">Marca:</label>
			    	<select class="form-control" name="marca" >
			    		<option selected="selected"><?=$calzadoInfo[3];?></option>
						<option>Nike</option>
			    		<option>Ninguna</option>
						<option>Pirma</option>
						<option>Vans</option>
					</select>
				</div>
			</div>			

	    </form>
	</div>

</body>
</html>
