<?php  
	session_start();
	 
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	} 
  	include_once("insertarPHP.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Insertar</title>
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
	<div class="container">
			
		<!--Sirve para que identifique la pagina cual es el proposito de este elemento-->
		<form id="#" class="form-horizontal" role="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" autocomplete="off">
			
			<div id="signupalert" style="display:none" class="alert alert-danger">
				<p>Error:</p>
				<span></span>
			</div>
		
			
			<!-- <div class="form-group">
				<label for="#" class="col-md-3 control-label">:</label>
				<div class="col-md-3">
					<input type="text" class="form-control" name="#" placeholder="" 
					value="<?php /*if(isset($)) echo $; */?>" required >
					Sirve para validar si no esta null
				</div>
			</div> -->
			
			<div class="form-group">
				<label for="#" class="col-md-3 control-label">:</label>
				<div class="col-md-3">
					<input type="text" class="form-control" name="" placeholder="">
				</div>
			</div>
			
			<!-- Barra -->
			<div class="form-group">
				<label for="" class="col-md-3 control-label">:</label>
				<div class="col-md-3">
					<select  class="form-control" name="#">
						<option></option>
					</select>
				</div>
			</div>


			<div class="form-group">                                      
				<div class="col-md-offset-3 col-md-9">
					<button id="#" type="submit" class="btn btn-success btn-lg"><i class="icon-hand-right"></i>Insertar</button> 
				</div>
			</div>

		</form>
		<?php echo errors($errors); ?>
	</div>
				
</body>
</html>