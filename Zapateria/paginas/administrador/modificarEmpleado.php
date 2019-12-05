<?php  
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}
	 
  	for($i=0; $i <= 7; $i++)
		$usuarioInfo[$i] = "";
	include_once("buscarEmpleadoPHP.php");
	include_once("modificarEmpleadoPHP.php");

	
?>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Modificar empleado</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<script src="../../js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="../../jQuery/jQuery.js"></script>
	<script type="text/javascript" src="../../jQuery/jquery-3.3.1.js"></script>
	
	<script src="../../js/empleadoModificar.js" ></script>
	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
	</style>
</head>
<body>
	
	<div class="clearfix col-xs-3 row-xs-12">
		
		<form id="buscarEmpleado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
			<label for="idUsuario" class="">idUsuario:</label>
			<input type="text" class="form-control" name="idUsuario" placeholder="#">

			<label for="usuario" class="">Usuario:</label>
			<input type="text" class="form-control" name="usuario" placeholder="usuario">

			<label for="nombre" class="">Nombre:</label>
			<input type="text" class="form-control" name="nombre" placeholder="Nombre">
			
			<button class="btn btn-lg btn-success btn-block" type="submit" name="buscar">Buscar</button>
														

		</form>
		
	</div>
	<div class=" clearfix col-xs-9">
		<table class="table">
				<thead>
					<tr>
						<th>idUsuario</th>
						<th>Cargo</th>
						<th>Nombre</th>
						<th>Usuario</th>
						<th>Contraseña</th>
						<th>Telefono</th>
						<th>Sucursal</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$usuarioInfo[0];?></td>
						<td><?=$usuarioInfo[3];?></td>
						<td><?=$usuarioInfo[4];?></td>
						<td><?=$usuarioInfo[1];?></td>
						<td><?=$usuarioInfo[2];?></td>
						<td><?=$usuarioInfo[5];?></td>
						<td><?=$usuarioInfo[6];?></td>
					</tr>
				</tbody>
			</table>
	
		<form id="modificar" class="form-horizontal" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" autocomplete="off" >
	      
		    <h1 class="h3 mb-3 font-weight-normal">Editar información</h1>
		      
		    <div class="row">
			  	<div class="col-xs-3">
					<label class="">Usuario:</label>
			    	<input id = "usuario" type="text" class="form-control" placeholder="<?=$usuarioInfo[1];?>" name="mUsuario" >
			    	<p id = "errorUsuario"></p>
				</div>
				<div class="col-xs-3">
					<label class="">Cargo:</label>
			    	<select class="form-control" name="mCargo" >
			    		<option selected="selected"><?=$usuarioInfo[3];?></option>
						<option>Normal</option>
						<option>Administrador</option>
					</select>
				</div>

				<div class="col-xs-3">
				<input id="modificar" type="submit" value="modificar" class="btn btn-lg btn-warning btn-block" name="modificar">
				</div>
			</div>


			<div class="row">
				<div class="col-xs-3">
			    	<label class="">Sucursal:</label>
		    		<select class="form-control" name="mSucursal" >
			    		<option selected="selected"><?=$usuarioInfo[6];?></option>
						<option>1.- Zapateria Gris</option>
						<option>2.- Zapateria Gris el Rosario</option>
					</select>
			 	</div>
				<div class="col-xs-3">
					<label class="">Telefono:</label>
			    	<input id="telefono" type="text" class="form-control" placeholder="<?=$usuarioInfo[5];?>"  name="mTelefono" >
			    	<p id="errorTelefono"></p>
				</div>
			</div>


			<div class="row">
			  	<div class="col-xs-3">
			    	<label class="">Nombre completo:</label>
		    		<input id = "nombre" type="text" class="form-control input-sm" placeholder="<?=$usuarioInfo[4];?>" name="mNombre" >
		    		<p id = "errorNombre"></p>
			 	</div>
			 	<div class="col-xs-5">
					<label class="">Password:</label>
			    	<input id="contrasena"  type="password" class="form-control" placeholder="Prueba1@lll  "  name="mContrasena" >
			    	<p id="errorContrasena">Al menos - una letra minuscula,mayuscula, un caracter y digito - Minimo 5 caracteres y maximo 18</p>
				</div>
			</div>			

	    </form>
	</div>

</body>
</html>
