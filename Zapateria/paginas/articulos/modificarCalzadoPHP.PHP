<?php 

	include_once("../../clases/0dataBase.php");
	include_once("../../clases/calzado.php");
	$objConexion = new conexion(); 
	$objDataBase = new dataBase();
	$objCalzado  = new calzado();

	
	if(isset($_POST['modificar'])){
		$codigo = $_SESSION ['calzadoBuscado'];
		$alias = $_POST["alias"];
		$tipo = $_POST["tipo"];
		$marca = $_POST["marca"];
		$modelo = $_POST["modelo"];
		$tpo = substr($tipo, 0, 1).substr($tipo, -3);
		$mca = substr($marca, 0, 1).substr($marca, -3);
		
		$newCodigo = $_SESSION ["calzadoAlmacen"].$tpo.$mca.$modelo."_"."Cdo".$_SESSION ["calzadoId"];

		$objCalzado->setCodigo($codigo);
		$objCalzado->setAlias($alias);
		$objCalzado->setTipo($tipo);
		$objCalzado->setMarca($marca);
		$objCalzado->setModelo($modelo);


		$conexion = $objConexion->getConexion();
		$objDataBase->modificarCalzado($conexion, $objCalzado, $newCodigo);

		$objCalzado->setCodigo($newCodigo);
		$calzadoInfo = $objDataBase->buscarCalzado($conexion, $objCalzado);
		if($calzadoInfo[4] == "0")
			$calzadoInfo[4] = "";

		$_SESSION["calzado"] = $calzadoInfo[0];
		$_SESSION ["calzadoBuscado"] = $calzadoInfo[0];
		$objConexion->endConexion($conexion);
	}

 ?>