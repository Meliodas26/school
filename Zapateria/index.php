<?php 
	if(!empty($_POST)){
		require 'funciones/funciones.php';

		include_once("clases/0dataBase.php");
		include_once("clases/usuario.php");
		$objConexion = new conexion();
		$objDataBase = new dataBase();
		$objUsuario = new usuario();

		$objUsuario->setUsuario($_POST["usuario"]);
		$objUsuario->setcontrasena($_POST["contrasena"]);
		

		$conexion = $objConexion->getConexion();
		$boolean = $objDataBase->logIng($conexion,$objUsuario);

		if($boolean == true){ 
			session_start();
			$usuario = $_POST["usuario"];
			$_SESSION["usuario"] = $usuario;
			header("location: paginas/menu.php");

		}else{
			echo '<script> alert("Usuario no encontrado"); </script>';
		}
		
		$objConexion->endConexion($conexion);
	}
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
	<link href="imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="css/bootstrap.min.css" >
	<script src="js/bootstrap.min.js" ></script>	
</head>
<body>
	<div class="container">    
			<div id="login" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
				<div class="window panel-info" >     
					<div style="padding-top:30px" class="panel-body" >

						<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
						
						<form id="loginform" class="form-horizontal" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" autocomplete="off"><!--Buscar autocomplete-->
							
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
								<input id="usuario" type="text" class="form-control" name="usuario" value="" placeholder="Usuario" required>                                        
							</div>
							
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input id="password" type="password" class="form-control" name="contrasena" placeholder="contrasena" required>
							</div>
							
							<div style="margin-top:10px" class="form-group">
								<div class="col-sm-12 controls">
									<button id="button" type="submit" class="btn btn-success">Acceder</a>
								</div>
							</div>
							
						</form>
					</div>                     
				</div>  
			</div>
		</div>
</body>
</html>