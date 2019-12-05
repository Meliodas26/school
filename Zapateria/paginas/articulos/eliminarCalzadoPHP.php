<?php 
	
	if(isset($_POST['eliminar'])){
		$codigo = $_SESSION ["calzadoBuscado"];
		
		include_once("../../clases/0dataBase.php");
		include_once("../../clases/calzado.php");
		$objConexion = new conexion(); 
		$objDataBase = new dataBase();
		$objCalzado = new calzado();

		$objCalzado->setCodigo($codigo);

		$conexion = $objConexion->getConexion();
		$res = $objDataBase->eliminarCalzado($conexion, $objCalzado);
		$objConexion->endConexion($conexion);
		if($res){
			echo '<script>alert("El calzado se ha eliminado");</script>';
		}else{
			echo '<script>alert("Ocurrio un error inesperado");</script>';
		}
		$_SESSION["calzadoBuscado"] = "";
	}
		
 ?>