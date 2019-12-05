<?php 

	if(isset($_POST['buscar'])){
		
		$codigo = $_POST['codigo'];
		
		include_once("../../clases/0dataBase.php");
		include_once("../../clases/calzado.php");
		$objConexion = new conexion(); 
		$objDataBase = new dataBase();
		$objCalzado = new calzado();

		$objCalzado->setCodigo($codigo);

		$conexion = $objConexion->getConexion();
		$calzadoInfo = $objDataBase->buscarCalzadoStock($conexion, $objCalzado);
		$_SESSION ["codigo"] = $calzadoInfo[0];
		$_SESSION ["almacen"] = $calzadoInfo[2];
		$objConexion->endConexion($conexion);

	}

	if(isset($_POST['buscar_eliminar'])){
		$codigo = $_POST['codigo'];
		$color  = $_POST['color'];
		
		include_once("../../clases/0dataBase.php");
		include_once("../../clases/calzado.php");
		$objConexion = new conexion(); 
		$objDataBase = new dataBase();
		$objCalzado = new calzado();

		$objCalzado->setCodigo($codigo);
		$objCalzado->setColor($color);

		$conexion = $objConexion->getConexion();
		$calzadoInfo = $objDataBase->buscarCalzadoStock($conexion, $objCalzado);
		$conexion = $objConexion->getConexion();
		$bebe		 = $objDataBase->buscar_nionBebe($conexion, $objCalzado);
		$conexion = $objConexion->getConexion();
		$joven		 = $objDataBase->buscar_nionJoven($conexion, $objCalzado);
		$conexion = $objConexion->getConexion();
		$adulto		 = $objDataBase->buscar_nionAdulto($conexion, $objCalzado);
		$_SESSION ["codigo"] = $codigo;
		$_SESSION ["color"] = $color;
		$objConexion->endConexion($conexion);

	}

 ?>