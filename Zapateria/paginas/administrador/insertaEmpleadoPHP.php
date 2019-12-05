<?php 
	require '../../funciones/funciones.php';
		$errors = array();
		if(!empty($_POST)){
			
			include_once("../../clases/0dataBase.php");
			include_once("../../clases/usuario.php");
			include_once("../../clases/empleado.php");


			
			$objUsuario = new usuario();
			$objUsuario->setUsuario($_POST["usuario"]);
			$objUsuario->setcontrasena($_POST["contrasena"]);
			$objUsuario->setRcontrasena($_POST["rcontrasena"]);
			$objUsuario->setCargo($_POST["cargo"]);

			$objEmpleado = new empleado();
			
			$objEmpleado->setNombre($_POST["nombre"]);
			$objEmpleado->setTelefono($_POST["telefono"]);
			$objEmpleado->setIdSucursal($_POST["idSucursal"]);

			
				$objConexion = new conexion(); 
				$objDataBase = new dataBase();
				
				$conexion = $objConexion->getConexion();
				$registro = $objDataBase->insertaEmpleado_Usuario($conexion,$objUsuario, $objEmpleado);
				
				if($registro == true){
					$objConexion->endConexion($conexion);
					echo'<script> alert("Usuario registrado"); </script>';
					//header("location: registro.php");
				}else{
					$errors[]="Error al registrar";
				}

		}
 ?>