<?php
	if(isset($_POST['eliminar'])){
		$codigo 	= 	$_SESSION["codigo"];
		$color	= 	$_SESSION["color"];
		$n1 		= 	$_POST["n1"];
		$n2 		= 	$_POST["n2"];

		include_once("../../clases/stockCdo.php");

		$objStockCdo = new stockCdo();
		
		$objStockCdo->setCodigo($codigo);
		$objStockCdo->setColor($color);
		$objStockCdo->setN1($n1);
		$objStockCdo->setN2($n2);
				
		$objDataBase = new dataBase();
		$res = $objDataBase->eliminarNionBebe($conexion, $objStockCdo);
		
		if($res == true){
			$calzadoInfo = $objDataBase->buscarNionbebe($conexion, $objStockCdo);
			$objConexion->endConexion($conexion);
		}
	}
 ?>