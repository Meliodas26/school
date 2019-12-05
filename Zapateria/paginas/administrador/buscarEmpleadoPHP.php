<?php 

	if(isset($_POST['buscar'])){
		
		$idUsuario = $_POST['idUsuario'];
		$usuario = $_POST['usuario'];
		$nombre = $_POST['nombre'];
		
		if(!(strlen($usuario)>0 && strlen($nombre)>0 && strlen($idUsuario)>0)){

			if((strlen($usuario)>0 && strlen($nombre)>0) || (strlen($idUsuario)>0 && strlen($nombre)>0) || (strlen($idUsuario)>0 && strlen($usuario)>0)){
				for($i=0; $i <= 7; $i++)
		  			$usuarioInfo[$i] = "";
				echo '<script> alert("Solo llene un campo") </script>';

			}else{
				
				include_once("../../clases/0dataBase.php");
				include_once("../../clases/usuario.php");
				include_once("../../clases/empleado.php");
				$objConexion = new conexion(); 
				$objDataBase = new dataBase();
				$objUsuario = new usuario();
				$objEmpleado = new empleado();

				$objUsuario->setIdUsuario($idUsuario);
				$objUsuario->setUsuario($usuario);

				$objEmpleado->setNombre($nombre);

					
				$conexion = $objConexion->getConexion();
				$usuarioInfo = $objDataBase->buscarEmpleado_Usuario($conexion, $objUsuario, $objEmpleado);
				$_SESSION ["idUsuarioBuscado"] = $usuarioInfo[0];
				$_SESSION ["usuarioBuscado"] = $usuarioInfo[1];
				$objConexion->endConexion($conexion);
			}

		}else{
				for($i=0; $i <= 7; $i++)
	  			$usuarioInfo[$i] = "";
				echo '<script> alert("Solo llene un campo") </script>';
		}

	}else{
		for($i=0; $i <= 7; $i++)
  		$usuarioInfo[$i] = "";
	}

 ?>