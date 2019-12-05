<?php 

	function null($objUsuario, $objEmpleado){
	$usuario =		$objUsuario->getUsuario();
	$contrasena =	$objUsuario->getcontrasena();
	$rcontrasena =	$objUsuario->getrcontrasena();
	$cargo =		$objUsuario->getCargo();
	$nombre =		$objEmpleado->getNombre();
	$idSucursal =	$objEmpleado->getIdSucursal();

	if(strlen(trim($nombre)) < 1 || strlen(trim($usuario)) < 1 || strlen(trim($contrasena)) < 1 || 
	strlen(trim($rcontrasena)) < 1 || strlen(trim($idSucursal)) < 1 || strlen(trim($cargo)) < 1 ){
			
			return true;
		}else{
			return false;
		}
		
	}
	
	function verificarcontrasenas($objUsuario){
		$a = $objUsuario->getcontrasena();
		$b = $objUsuario->getrcontrasena();
		//strcmp — Comparación de string segura a nivel binario, si coinciden retirna 0
		if(strcmp($a, $b) == 0){
			return true;
		}else{
			return false;
		}
	}
	function errors($errors){
		if(count($errors) > 0)
		{
			echo "<div id='error' class='alert alert-danger' role='alert'>
			<a href='#' onclick=\"showHide('error');\"></a>
			<ul>";
			foreach($errors as $error)
			{
				echo "<li>".$error."</li>";
			}
			echo "</ul>";
			echo "</div>";
		}
	}
 ?>