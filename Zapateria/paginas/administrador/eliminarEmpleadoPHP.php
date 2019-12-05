<?php 
	
	if(isset($_POST['eliminar'])){

		$usuario = $_SESSION ["usuarioBuscado"];
		$idUsuario = $_SESSION ["idUsuarioBuscado"];
		if(strlen($usuario) > 0){
			if($usuario != "root"){
				if($usuario != $_SESSION["usuario"]){
					include_once("../../clases/0dataBase.php");
					include_once("../../clases/usuario.php");
					$objConexion = new conexion(); 
					$objDataBase = new dataBase();
					$objUsuario = new usuario();

					$objUsuario->setIdUsuario($idUsuario);

					$conexion = $objConexion->getConexion();
					$res = $objDataBase->eliminarEmpleado_Usuario($conexion, $objUsuario);
					$objConexion->endConexion($conexion);
					if($res){
						echo '<script>alert("El usuario ha sido eliminado");</script>';
					}else{
						echo '<script>alert("Ocurrio un error inesperado");</script>';
					}
				}else{
					echo '<script>alert("No se puede eliminar el usuario con el que esta logueado");</script>';
				}
			}else{
				echo '<script>alert("No se puede eliminar el usuario root");</script>';
			}
		}else{
			echo '<script>alert("Inserte un empleado");</script>';
		}

		$_SESSION["usuarioBuscado"] = "";
	}
		
 ?>