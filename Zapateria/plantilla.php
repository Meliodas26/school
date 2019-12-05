<?php 
	//Seguir en la sesion
  	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../index.php");
  	} 

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Plantilla</title>
	<link href="../imagenes/icon.ico" rel="shortcut icon">
  <link rel="stylesheet" href="css/otro.css"> 
	<link rel="stylesheet" href="css/bootstrap.min.css" >
  <link rel="stylesheet" href="css/plantilla.css">
	<!-- <link rel="stylesheet" href="css/bootstrap-theme.min.css" > -->
	<script src="js/bootstrap.min.js" ></script> 
</head>
<body>
	<div class="container-fluid head">
    	<div class="row">
      		<div class="col-xs-12">
		        <header>
		        </header>
      		</div>
    	</div>
  	</div>

<!--   BARRA DE NAVEGACION   -->
    <nav class="navbar navbar-expand-md navbar-dark bg-success navi">

      <!--Este boton es para hacer que se colapse el menú-->
      	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        		<span class="navbar-toggler-icon"></span>
      	</button>
      
    	<div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto ">
            <li class="nav-item mr-4 ">
              <p id="sucursal" class="nav-link active"><?php echo $_SESSION ["usuario"];?></p>
            </li>
        </ul>	
        <div class="clearfix">
            <a class="" href="../modulos/logout.php"><button class="btn btn-primary mx-2 float-right">Cerrar sesion</button></a>
            
        </div>
      </div>
    </nav>
	
<!-- CONTENIDO -->
  	<main>
    	<div class=" container row mg-5 ">
  				<a href="administrador/registro.php"><button id="#" class="btn btn-secondary btn-lg "></button></a>
    	</div>
		<div class=" container row mg-5 ">
  				<a href="#"><button id="#" type="button" class="btn btn-secondary btn-lg "></button></a>
    	</div>
    	<div class=" container row mg-5 ">
  				<a href="#"><button id="#" type="button" class="btn btn-secondary btn-lg "></button></a>
    	</div>

  		<div class="container">
  			
  		</div>

  	</main>
<!-- PIE DE PAGINA -->
  <footer class="foot">
	<hr>
      <div class="container ">
        <p>ZAPATERIAGRIS 2018 &copy Todos los derechos reservados </p>
      </div>
  </footer>

</body>
</html>