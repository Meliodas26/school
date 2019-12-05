<?php 
	class conexion{
		public function getConexion(){
			
			$conexion = new mysqli("localhost", "root", "", "Zapateria");
			if(mysqli_connect_errno()){
				echo 'Conexion fallida: ', mysqli_connect_error();
				exit();
			}
			return $conexion;
		}

		public function endConexion($conexion){
			mysqli_close($conexion);
		}

	}
	class dataBase{
		public function logIng($conexion,$objUsuario){
			$usuario =		$objUsuario->getUsuario();
			$contrasena =	$objUsuario->getcontrasena();
			$rows =  mysqli_query($conexion,"SELECT idUsuario FROM usuarios WHERE usuario='$usuario' AND contrasena='$contrasena'");

			/*Prueba*/
			while ($mostrar = mysqli_fetch_array($rows)) {
				echo "$mostrar[0]";
			}

			$respuesta = $rows->num_rows;
			if($respuesta == 1){
				return true;
			}else{
				return false;
			}
		}

		//Clase, Empleado_Usuario
		public function insertaEmpleado_Usuario($conexion, $objUsuario, $objEmpleado){
			$usuario =		$conexion->real_escape_string( $objUsuario->getUsuario() );
			$contrasena =	$conexion->real_escape_string( $objUsuario->getcontrasena() );
			$rcontrasena =	$conexion->real_escape_string( $objUsuario->getrcontrasena() );
			$cargo =		$conexion->real_escape_string( $objUsuario->getCargo() );
			$nombre =		$conexion->real_escape_string( $objEmpleado->getNombre() );
			$telefono =		$conexion->real_escape_string( $objEmpleado->getTelefono() );
			$idSucursal =	$conexion->real_escape_string( $objEmpleado->getIdSucursal() );
			mysqli_query($conexion,"call insertarEmpleado_Usuario('$usuario','$contrasena', '$cargo', '$nombre','$telefono','$idSucursal')" );
			return true;
		}
		public function buscarEmpleado_Usuario($conexion, $objUsuario, $objEmpleado){
			$idUsuario =	$conexion->real_escape_string( $objUsuario->getIdUsuario() );
			$usuario =		$conexion->real_escape_string( $objUsuario->getUsuario() );
			$nombre =		$conexion->real_escape_string( $objEmpleado->getNombre() );
			$usuarioInfo = mysqli_query($conexion, "call buscarEmpleado_Usuario('$idUsuario','$usuario','$nombre')");
			$usuarioInfo = mysqli_fetch_array($usuarioInfo);
			return $usuarioInfo;
		}
		public function modificarEmpleado_Usuario($conexion, $objUsuario, $objEmpleado){
			$idUsuario =	$conexion->real_escape_string( $objUsuario->getIdUsuario() );
			$usuario =		$conexion->real_escape_string( $objUsuario->getUsuario() );
			$contrasena =	$conexion->real_escape_string( $objUsuario->getcontrasena() );
			$cargo =		$conexion->real_escape_string( $objUsuario->getCargo() );
			$nombre =		$conexion->real_escape_string( $objEmpleado->getNombre() );
			$telefono =		$conexion->real_escape_string( $objEmpleado->getTelefono() );
			$idSucursal =	$conexion->real_escape_string( $objEmpleado->getIdSucursal() );
			mysqli_query($conexion,"call modificarEmpleado_Usuario('$idUsuario','$usuario', '$contrasena', '$cargo', '$nombre', '$telefono', '$idSucursal')");
		}
		public function eliminarEmpleado_Usuario($conexion, $objUsuario){
			$idUsuario =	$conexion->real_escape_string( $objUsuario->getIdUsuario() );
			mysqli_query($conexion, "call eliminarEmpleado_Usuario('$idUsuario')");
			return true;
		}

		public function insertarCalzado($conexion, $objCalzado, $almacen){
			$codigo 	= $conexion -> real_escape_string($objCalzado->getCodigo() );
			$alias 		= $conexion -> real_escape_string($objCalzado->getAlias() );
			$tipo 		= $conexion -> real_escape_string($objCalzado->getTipo() );
			$marca 		= $conexion -> real_escape_string($objCalzado->getMarca() );
			$modelo 	= $conexion -> real_escape_string($objCalzado->getModelo() );
			$idCalzado = $_SESSION["idCalzado"]+1;
			mysqli_query ($conexion, "call insertarCalzado('$codigo', '$alias', '$tipo', '$marca', '$modelo', '$idCalzado', $almacen)");
			return true;
		}

		public function buscarCalzado($conexion, $objCalzado){
			$codigo =	$conexion->real_escape_string( $objCalzado->getCodigo() );
			$calzadoInfo = mysqli_query($conexion, "call buscarCalzado('$codigo')");
			$long = sizeof($calzadoInfo);
			$calzadoInfo = mysqli_fetch_array($calzadoInfo);
			return $calzadoInfo;
		}

		public function modificarCalzado($conexion, $objCalzado, $newCodigo){
			$idAlmacen = $_SESSION["calzadoAlmacen"];
			$codigo 	= $conexion -> real_escape_string($objCalzado->getCodigo() );
			$alias 		= $conexion -> real_escape_string($objCalzado->getAlias() );
			$tipo 		= $conexion -> real_escape_string($objCalzado->getTipo() );
			$marca 		= $conexion -> real_escape_string($objCalzado->getMarca() );
			$modelo 	= $conexion -> real_escape_string($objCalzado->getModelo() );
			mysqli_query($conexion, "call modificarCalzado('$newCodigo', '$codigo', '$alias', '$tipo', '$marca', '$modelo', '$idAlmacen')");
			$_SESSION["calzado"] = $newCodigo;
		}

  		public function eliminarCalzado ($conexion, $objCalzado){
			$codigo = $conexion -> real_escape_string($objCalzado->getCodigo());
			mysqli_query ($conexion, "call eliminarCalzado('$codigo')");
			return true; 	
		}

		public function buscarCalzadoStock($conexion, $objCalzado){
			$auxConexion = $conexion;
			$codigo =	$conexion->real_escape_string( $objCalzado->getCodigo() );
			//$color  =   $conexion->real_escape_string( $objCalzado->getColor() );
			$calzadoInfo 	= mysqli_query($conexion, "call buscarCalzadoStock('$codigo')");
			$calzadoInfo 	= mysqli_fetch_array($calzadoInfo);			
			return $calzadoInfo;
		}

		public function buscar_nionBebe($conexion, $objCalzado){
			$codigo =	$conexion->real_escape_string( $objCalzado->getCodigo() );
			$color  =   $conexion->real_escape_string( $objCalzado->getColor() );
			$bebe = mysqli_query($conexion, "call buscar_nionBebe('$codigo', '$color')");
			$long = sizeof($bebe);
			if($long != 0)
				$bebe = mysqli_fetch_array($bebe);
			else
				for ($i=0; $i <= 11	; $i++) { 
					$bebe[$i] = 0;
				}
			return $bebe;
		}

		public function buscar_nionJoven($conexion, $objCalzado){
			$codigo =	$conexion->real_escape_string( $objCalzado->getCodigo() );
			$color  =   $conexion->real_escape_string( $objCalzado->getColor() );
			$joven = mysqli_query($conexion, "call buscar_nionJoven('$codigo', '$color')");
			$long  	= sizeof($joven);
			if ($long != 0)
				$joven = mysqli_fetch_array($joven);
			else
				for ($i=0; $i <= 10; $i++) { 
					$joven[$i] = 0;
				}
			return $joven;
		}

		public function buscar_nionAdulto($conexion, $objCalzado){
			$codigo =	$conexion->real_escape_string( $objCalzado->getCodigo() );
			$color  =   $conexion->real_escape_string( $objCalzado->getColor() );
			$adulto = mysqli_query($conexion, "call buscar_nionAdulto('$codigo', '$color')");
			$long 	=  sizeof($adulto);
			if ($long != 0)
				$adulto = mysqli_fetch_array($adulto);
			else
				for($i=0; $i <= 10; $i++)
					$adulto[$i] = 0;
			return $adulto;
		}

		public function agregarNumeracion($conexion, $objStockCdo, $numeracion){
			$codigo 	= $conexion -> real_escape_string($objStockCdo->getCodigo() );
			$almacen  	= $conexion -> real_escape_string($objStockCdo->getAlmacen());
			$precio  	= $conexion -> real_escape_string($objStockCdo->getPrecio());
			$color  	= $conexion -> real_escape_string($objStockCdo->getColor());
			$n1  		= $conexion -> real_escape_string($objStockCdo->getN1());
			$n2  		= $conexion -> real_escape_string($objStockCdo->getN2());
			$n3  		= $conexion -> real_escape_string($objStockCdo->getN3());
			$n4  		= $conexion -> real_escape_string($objStockCdo->getN4());
			$n5  		= $conexion -> real_escape_string($objStockCdo->getN5());
			$n6  		= $conexion -> real_escape_string($objStockCdo->getN6());
			$n7  		= $conexion -> real_escape_string($objStockCdo->getN7());
			$n8  		= $conexion -> real_escape_string($objStockCdo->getN8());
			$n9  		= $conexion -> real_escape_string($objStockCdo->getN9());
			$n10  		= $conexion -> real_escape_string($objStockCdo->getN10());
			$n11  		= $conexion -> real_escape_string($objStockCdo->getN11());
			$numeracion = $conexion -> real_escape_string($numeracion);
			
			mysqli_query ($conexion, "call agregarNumeracion('$codigo', '$almacen', '$color', '$precio', '$n1', '$n2', '$n3', '$n4', '$n5', '$n6', '$n7', '$n8', '$n9', '$n10', '$n11', '$numeracion')");
			return true;
		}

		public function eliminarNumeracion($conexion, $objStockCdo, $numeracion){
			$codigo 	= $conexion -> real_escape_string($objStockCdo->getCodigo() );
			$color  	= $conexion -> real_escape_string($objStockCdo->getColor());
			$n1  		= $conexion -> real_escape_string($objStockCdo->getN1());
			$n2  		= $conexion -> real_escape_string($objStockCdo->getN2());
			$n3  		= $conexion -> real_escape_string($objStockCdo->getN3());
			$n4  		= $conexion -> real_escape_string($objStockCdo->getN4());
			$n5  		= $conexion -> real_escape_string($objStockCdo->getN5());
			$n6  		= $conexion -> real_escape_string($objStockCdo->getN6());
			$n7  		= $conexion -> real_escape_string($objStockCdo->getN7());
			$n8  		= $conexion -> real_escape_string($objStockCdo->getN8());
			$n9  		= $conexion -> real_escape_string($objStockCdo->getN9());
			$n10  		= $conexion -> real_escape_string($objStockCdo->getN10());
			$n11  		= $conexion -> real_escape_string($objStockCdo->getN11());
			$numeracion = $conexion -> real_escape_string($numeracion);
			$procedure = "call eliminarNumeracion('$codigo', '$color', '$n1', '$n2', '$n3', '$n4', '$n5', '$n6', '$n7', '$n8', '$n9', '$n10', '$n11', '$numeracion')";
			mysqli_query ($conexion, $procedure);
			return true;
		}
		
	}

 ?>