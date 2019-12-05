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
		$calzadoInfo = $objDataBase->buscarCalzado($conexion, $objCalzado);
		$_SESSION ["codigo"] = $calzadoInfo[0];
		$_SESSION ["almacen"] = $calzadoInfo[2];
		$objConexion->endConexion($conexion);

	}


 ?>