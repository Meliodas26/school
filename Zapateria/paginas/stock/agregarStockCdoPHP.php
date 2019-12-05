<?php

	
	if(isset($_POST['agregar'])){

		$codigo 	= 	$_SESSION["codigo"];
		$almacen 	= 	$_SESSION["almacen"];
		$color 		= 	$_POST["color"];
		$n1 		= 	$_POST["n1"];
		$n2 		= 	$_POST["n2"];
		$precio 	= 	$_POST["precio"];

		include_once("../../clases/stockCdo.php");

		$objStockCdo = new stockCdo();
		
		$objStockCdo->setCodigo($codigo);
		$objStockCdo->setAlmacen($almacen);
		$objStockCdo->setColor($color);
		$objStockCdo->setN1($n1);
		$objStockCdo->setN2($n2);
		$objStockCdo->setPrecio($precio);
				
		$objDataBase = new dataBase();
		$inserto = $objDataBase->agregarNionbebe($conexion, $objStockCdo);
		
		if($inserto == true){
			$calzadoInfo = $objDataBase->buscarCalzadoStock($conexion, $objStockCdo);
			$objConexion->endConexion($conexion);
			echo'<script> alert("Stock agregado"); </script>';
		}
	}
 ?>