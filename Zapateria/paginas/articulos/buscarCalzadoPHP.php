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
		if($calzadoInfo[4] == "0")
			$calzadoInfo[4] = "";
		$_SESSION ["calzadoBuscado"] = $calzadoInfo[0];
		$_SESSION ["calzadoId"] = $calzadoInfo[6];
		$_SESSION ["calzadoAlmacen"] = $calzadoInfo[7];
		$objConexion->endConexion($conexion);

	}

 ?>