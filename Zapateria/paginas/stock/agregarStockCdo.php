<?php 
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}
	include_once("../../clases/0dataBase.php");

	$objConexion = new conexion();

	$conexion = $objConexion->getConexion();

	
  	for($i=0; $i <= 2; $i++)
	$calzadoInfo[$i] = "";
	include_once("buscarStockCdoPHP.php");
	include_once("agregarStockCdoPHP.php");
?>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Agregar stock de Calzado</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<link rel="stylesheet" href="../../css/text.css" >

	<script src="../../js/bootstrap.min.js" ></script>

	<script type="text/javascript" src="../../jQuery/jQuery.js"></script>
	<script type="text/javascript" src="../../jQuery/jquery-3.3.1.js"></script>
	<script src="../../js/stock.js" ></script>

	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 

		}
		.text-nota {
			color: black;
			font-size: 16px;
		}
		.frame{
			background: #0D689D;
		  	margin: "0";
		  	padding: 15px 0px 0px 0px;
		  	border: 0px;
		  	width: 100%;
		  	height: 325px;
		}
		.btn-numeracion{
  			background: #3e2723;
  			color: white;
		}
	</style>
</head>
<body>
	<div class="clearfix col-xs-2 row-xs-9">
		
		<form id="buscar" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
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
						<th>Sucursal</th> <!-- (idAlmacen) -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$calzadoInfo[0];?></td>
						<td><?=$calzadoInfo[1];?></td>
					</tr>
				</tbody>
		</table>
		<div class="row">
			<div class=" container row mg-5 col-xs-2 ">
		          <a href="numeracion/agregarBebe.php" target="numeracion"><button type="button" class="btn btn-basico btn-numeracion btn-secondary btn-lg ">N1-N11</button></a>
		    </div>
		    <div class=" container row mg-5 col-xs-2 ">
		          <a href="numeracion/agregarJoven.php" target="numeracion"><button type="button" class="btn btn-basico btn-numeracion btn-secondary btn-lg ">N12-N21</button></a>
		    </div>
		    <div class=" container row mg-5 col-xs-2 ">
		          <a href="numeracion/agregarAdulto.php" target="numeracion"><button type="button" class="btn btn-basico btn-numeracion btn-secondary btn-lg ">N22-N31</button></a>
		    </div>
	    </div>
	    <div class="row">
        <iframe class="frame" name="numeracion">
          
        </iframe>
  		</div>
	
	</div>

</body>
</html>
