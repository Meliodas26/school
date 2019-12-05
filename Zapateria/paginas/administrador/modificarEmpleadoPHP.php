<?php 

	include_once("../../clases/0dataBase.php");
	include_once("../../clases/usuario.php");
	include_once("../../clases/empleado.php");
	$objConexion = new conexion(); 
	$objDataBase = new dataBase();
	$objUsuario  = new usuario();
	$objEmpleado = new empleado();

	
	if(isset($_POST['modificar'])){
		
		$idUsuario = $_SESSION['idUsuarioBuscado'];

		$objUsuario->setIdUsuario($idUsuario);

		$objUsuario->setUsuario($_POST["mUsuario"]);
		$objUsuario->setcontrasena($_POST["mContrasena"]);
		$objUsuario->setCargo($_POST["mCargo"]);
		
		$objEmpleado->setNombre($_POST["mNombre"]);
		$objEmpleado->setTelefono($_POST["mTelefono"]);

		$objEmpleado->setIdSucursal($_POST["mSucursal"]);

		$conexion = $objConexion->getConexion();
		$objDataBase->modificarEmpleado_Usuario($conexion, $objUsuario, $objEmpleado);
		$usuarioInfo = $objDataBase->buscarEmpleado_Usuario($conexion, $objUsuario, $objEmpleado);
		
		$_SESSION["usuario"] = $usuarioInfo[1];
		$objConexion->endConexion($conexion);
	}

 ?>