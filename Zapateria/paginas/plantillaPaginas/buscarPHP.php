<?php 

	if(isset($_POST['buscar'])){
		
		$id = $_POST['id'];
		
		include_once("../../clases/0dataBase.php");
		//include_once("../../clases/.php");
		$objConexion = new conexion(); 
		$objDataBase = new dataBase();
		//$obj = new ();

		//$obj->setId($id);

		$conexion = $objConexion->getConexion();
		//$usuarioInfo = $objDataBase->buscar($conexion, $obj);
		//$_SESSION ["idBuscado"] = $Info[0];
		mysqli_close($conexion);

	}

 ?>