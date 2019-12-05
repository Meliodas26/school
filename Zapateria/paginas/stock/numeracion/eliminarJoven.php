
<?php 
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../../index.php");
  	}
	include_once("../buscarStockCdoPHP.php");
	include_once("../../../clases/0dataBase.php");

	if(isset($_POST['eliminar'])){
		$codigo 	= 	$_SESSION["codigo"];
		$color		= 	$_SESSION["color"];
		$n1 		= 	$_POST["n1"];
		$n2 		= 	$_POST["n2"];
		$n3 		= 	$_POST["n3"];
		$n4 		= 	$_POST["n4"];
		$n5 		= 	$_POST["n5"];
		$n6 		= 	$_POST["n6"];
		$n7 		= 	$_POST["n7"];
		$n8 		= 	$_POST["n8"];
		$n9 		= 	$_POST["n9"];
		$n10 		= 	$_POST["n10"];
		$n11 		= 	"0";

		include_once("../../../clases/stockCdo.php");

		$objStockCdo = new stockCdo();
		
		$objStockCdo->setCodigo($codigo);
		$objStockCdo->setColor($color);
		$objStockCdo->setN1($n1);
		$objStockCdo->setN2($n2);
		$objStockCdo->setN3($n3);
		$objStockCdo->setN4($n4);
		$objStockCdo->setN5($n5);
		$objStockCdo->setN6($n6);
		$objStockCdo->setN7($n7);
		$objStockCdo->setN8($n8);
		$objStockCdo->setN9($n9);
		$objStockCdo->setN10($n10);
		$objStockCdo->setN11($n11);
				
		$objConexion = new conexion();
		$conexion = $objConexion->getConexion();
		
		$objDataBase = new dataBase();
		$numeracion = 'joven';
		$res = $objDataBase->eliminarNumeracion($conexion, $objStockCdo, $numeracion);
		
		if($res = true){
			echo "Se ha eliminado el stock, pulse buscar para ver los cambios";
			//$calzadoInfo 	= $objDataBase->buscarCalzadoStock($conexion, $objStockCdo);
			//$conexion = $objConexion->getConexion();
			//$bebe 			= $objDataBase->buscar_nionBebe($conexion, $objStockCdo);
			//$conexion = $objConexion->getConexion();
			$joven 			= $objDataBase->buscar_nionJoven($conexion, $objStockCdo);
			//$conexion = $objConexion->getConexion();
			//$adulto 		= $objDataBase->buscar_nionAdulto($conexion, $objStockCdo);
			$objConexion->endConexion($conexion);
			
		}
	}

 ?>
<head>
	<meta charset="UTF-8">
	<title>Eliminar stock de Calzado</title>
	<link rel="stylesheet" href="../../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../../css/bootstrap-theme.min.css" >
	<link rel="stylesheet" href="../../../css/text.css" >	
	<script src="../../../js/bootstrap.min.js" ></script>

	<script type="text/javascript" src="../../../jQuery/jQuery.js"></script>
	<script type="text/javascript" src="../../../jQuery/jquery-3.3.1.js"></script>
	<script src="../../../js/stockEnar.js" ></script> 

	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
		.btn-numeracion{
  			background: #3e2723;
  			color: white;
		}
	</style>
</head>
<div class="clearfix col-xs-12">
	<form id="stock" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" >
	  
	    <h1 class="h3 mb-3 font-weight-normal">Numeracion de jovenes:</h1>
   
		<div class="row">

		  	<div class="col-xs-1 form-group">
				<label>N12:</label>
		    	<input id="n1" class="form-control" name="n1" value = "0">
		    	<p id="errorN1" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N13:</label>
		    	<input id="n2" class="form-control" name="n2" value = "0">
		    	<p id="errorN2" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N14:</label>
		    	<input id="n3" class="form-control" name="n3" value = "0">
		    	<p id="errorN3" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N15:</label>
		    	<input id="n4" class="form-control" name="n4" value = "0">
		    	<p id="errorN4" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N16:</label>
		    	<input id="n5" class="form-control" name="n5" value = "0">
		    	<p id="errorN5" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N17:</label>
		    	<input id="n6" class="form-control" name="n6" value = "0">
		    	<p id="errorN6" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N18:</label>
		    	<input id="n7" class="form-control" name="n7" value = "0">
		    	<p id="errorN7" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N19:</label>
		    	<input id="n8" class="form-control" name="n8" value = "0">
		    	<p id="errorN8" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N20:</label>
		    	<input id="n9" class="form-control" name="n9" value = "0">
		    	<p id="errorN9" class="text-correccion"></p>
			</div>
			<div class="col-xs-1 form-group">
				<label>N21:</label>
		    	<input id="n10" class="form-control" name="n10" value = "0">
		    	<p id="errorN10" class="text-correccion"></p>
			</div>

			
			<div class="col-xs-1">
				
			<input type="submit" value="-" class="btn btn-lg btn-danger btn-block" name="eliminar"/>
			</div>
		</div>			

	</form>
</div>