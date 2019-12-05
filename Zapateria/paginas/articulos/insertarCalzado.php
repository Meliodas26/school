<?php  
	session_start();
	
	include_once("../../clases/0dataBase.php");
	$objConexion = new conexion(); 
	$conexion = $objConexion->getConexion();

	$res = mysqli_query($conexion, "SELECT max(idCalzado) FROM calzado");
	$res = mysqli_fetch_array($res);
	$_SESSION["idCalzado"] = $res[0];

  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	} 
  	include_once("insertarCalzadoPHP.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Insertar Calzado</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<link rel="stylesheet" href="../../css/text.css" >
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
</head>
<body>
	<div class="clearfix col-xs-3 row-xs-12">
		<form id="calzado" class="form-horizontal" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" autocomplete="off">
			
			<div class="form-group">
				<label for="alias" class="col-md-2 control-label">Alias:</label>
				<div class="col-md-6">
					<input id="alias" type="text" class="form-control" maxlength="10" name="alias" placeholder="Alias">
				</div>
				<div class="col-md-4">
					<p id="errorAlias" class="text-correccion"></p>
				</div>
			</div>

			<div class="form-group">
				<label for="tipo" class="col-md-2 control-label">Tipo:</label>
				<div class="col-md-6">
					<select  class="form-control" name="tipo">
						<option>Otro</option>
						<option>Colegial</option>
						<option>Huarache</option>
						<option>Tennis</option>
					</select>
				</div>
			</div>
					
			<div class="form-group">
				<label for="marca" class="col-md-2 control-label">Marca:</label>
				<div class="col-md-6">
					<select  class="form-control" name="marca">
						<option>Ninguna</option>
						<option>Nike</option>
						<option>Pirma</option>
						<option>Vans</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="modelo" class="col-md-2 control-label">Modelo:</label>
				<div class="col-md-6">
					<input id="modelo" type="int" class="form-control" name="modelo" placeholder="#">
				</div>
				<p id="errorModelo" class="text-correccion"></p>
			</div>			


			<div class="form-group">                                      
				<div class="col-md-4">
					<input id="insertarCalzado" type="submit" value="Insertar calzado" class="btn btn-success btn-lg" name="insertar" /> 
				</div>
			</div>

		</form>
	</div>
				
</body>
</html>