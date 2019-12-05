<?php
	if($_SESSION["sucursal"] != "?"){ 
		if(isset($_POST['insertar'])){
			$sucursal = substr($_SESSION["sucursal"], 0, 1);
			
			$alias = $_POST["alias"];
			$tipo = $_POST["tipo"];
			$marca = $_POST["marca"];
			$modelo = $_POST["modelo"];

			$tpo = substr($tipo, 0, 1).substr($tipo, -3);
			$mca = substr($marca, 0, 1).substr($marca, -3);
			
			$codigo = $sucursal.$tpo.$mca.$modelo."_"."Cdo";
			
			include_once("../../clases/calzado.php");

			$objCalzado = new calzado();
			
			$objCalzado->setCodigo($codigo);
			$objCalzado->setAlias($alias);
			$objCalzado->setTipo($tipo);
			$objCalzado->setMarca($marca);
			$objCalzado->setModelo($modelo);
					
			
			$objDataBase = new dataBase();

			$inserto = $objDataBase->insertarCalzado($conexion, $objCalzado, $sucursal);
			
			if($inserto == true){
				$objConexion->endConexion($conexion);
				echo'<script> alert("Ya puede generar stock a este articulo"); </script>';
			}
		}
	}else{
		echo'<script> alert("Seleccione una sucursal"); </script>';
	}
 ?>