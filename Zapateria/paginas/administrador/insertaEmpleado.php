<?php  
	session_start();
	 
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	} 
  	include_once("insertaEmpleadoPHP.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Registro</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	
	<script src="../../js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="../../jQuery/jQuery.js"></script>
	<script type="text/javascript" src="../../jQuery/jquery-3.3.1.js"></script>
	
	<script src="../../js/empleado.js" ></script>
	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
	</style>
</head>
<body>
	<div class="container">
			
	<!--Sirve para que identifique la pagina cual es el proposito de este elemento-->
		<form id="registrar" class="form-horizontal" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" autocomplete="off" >
		
			<div class="form-group">
				<label for="nombre" class="col-md-3 control-label">Nombre:</label>
				<div class="col-md-2">
					<input id= "nombre" type="text" class="form-control" name="nombre" placeholder="Fulano" 
					>
					<p id = "errorNombre">Campo obligatorio</p>
				</div>
			</div>
			

			<div class="form-group">
				<label for="telefono" class="col-md-3 control-label">Telefono:</label>
				<div class="col-md-2">
					<input id="telefono" type="text" class="form-control" name="telefono" placeholder="000-000-0000">
					<p id="errorTelefono"></p>
				</div>
			</div>
			
			<div class="form-group">
				<label for="usuario" class="col-md-3 control-label">Usuario:</label>
				<div class="col-md-2">
					<input id="usuario" type="text" class="form-control" name="usuario" placeholder="Usuario" value="">
					<p id="errorUsuario">Campo obligatorio</p>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="idSucursal" class="col-md-3 control-label">Sucursal</label>
				<div class="col-md-2">
					<select  class="form-control" name="idSucursal">
						<option>1.- Zapateria gris</option>
						<option>2.- Zapateria gris el rosario</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="cargo" class="col-md-3 control-label">Cargo</label>
				<div class="col-md-2">
					<select class="form-control" name="cargo">
						<option>Normal</option>
						<option>Administrador</option>
					</select>
				</div>
			</div> 
			

			<div class="form-group">
				<label for="contrasena" class="col-md-3 control-label">Contraseña</label>
				<div class="col-md-7">
					<input id="contrasena" type="password" class="form-control" name="contrasena" placeholder="Prueba1@lll">
					<p id="errorContrasena">Al menos - una letra minuscula,mayuscula, un caracter y digito - Minimo 5 caracteres y maximo 18</p>
				</div>
			</div>
			
			<div class="form-group">
				<label for="rcontrasena" class="col-md-3 control-label">Confirmar contraseña</label>
				<div class="col-md-2">
					<input id="contrasenaR" type="password" class="form-control" name="rcontrasena" placeholder="Prueba1@lll" >
					<p id="errorContrasenaR"></p>
				</div>
				<div class="col-md-2"> 
					<input id="registrar" type="submit" value="Registrar" class="btn btn-info" name="registrar">
				</div>
			</div>
				</div>
			</div>

		</form>
						
	</div>
				
</body>
</html>