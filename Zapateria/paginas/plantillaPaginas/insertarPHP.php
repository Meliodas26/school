<?php 
	require '../../funciones/funciones.php';
		$errors = array();
		if(isset($_POST[''])){
			
			include_once("../../clases/0dataBase.php");
			//include_once("../../clases/.php");


			
			//$objUsuario = new ();
			//$objUsuario->set($_POST[""]);

			if(null($obj)){
				$errors[] = "Debe llenar los campos, excepto telefono";
			}
			if(count($errors) == 0){
				
				$objConexion = new conexion(); 
				$objDataBase = new dataBase();
				
				$conexion = $objConexion->getConexion();
				//$inserto = $objDataBase->inserta($conexion);
				
				if($inserto == true){
					$objConexion->endConexion($conexion);
					echo'<script> alert("Usuario registrado"); </script>';
				}else{
					$errors[]="Error al registrar";
				}

			}	
		}
 ?>