<?php  
	session_start();
	 
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}

  	for($i=0; $i <= 0; $i++)
		$Info[$i] = "";
	include_once("buscarPHP.php");
	//Para areglar el bug de eliminar
	$_SESSION["usuarioBuscado"] = "";
?>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Plantilla</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<script src="../../js/bootstrap.min.js" ></script>
	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
	</style>
</head>
<body>
	
	<div class="clearfix col-xs-3">
		
		<form id="buscarEmpleado" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
			<label for="id" class="">id:</label>
			<input type="text" class="form-control" name="id" placeholder="">
			
			<button id="buscar" type="submit" class="btn btn-lg btn-success btn-block" name="buscar"><i class="icon-hand-right"></i>Buscar</button>												

		</form>
		
	</div>
	<div class=" clearfix col-xs-9">
		
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$Info[0];?></td>
					</tr>
				</tbody>
			</table>

	</div>

</body>
</html>
