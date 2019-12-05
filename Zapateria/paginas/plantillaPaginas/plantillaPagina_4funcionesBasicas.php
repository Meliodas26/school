<?php 
	//Seguir en la sesion
  	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	} 

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Plantilla</title>
	<link href="../imagenes/icon.ico" rel="shortcut icon">
  <link rel="stylesheet" href="../../css/plantilla.css"> 
  <link rel="stylesheet" href="../../css/bootstrap.min.css" >
  <link rel="stylesheet" href="../../css/vista.css">
  <link rel="stylesheet" href="../../css/text.css">
  <link rel="stylesheet" href="../../css/btn.css">    
	<script src="../../js/bootstrap.min.js" ></script> 
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
    <nav class="navbar navbar-expand-md navbar-dark bg-dark navi">

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
            <a class="" href="../../modulos/logout.php"><button class="btn btn-primary mx-2 float-right">Cerrar sesion</button></a>
            
            <a class="" href="../menu.php"><button class="btn btn-primary mx-2 float-right">Menu</button></a>
        </div>
      </div>
    </nav>
	
<!-- CONTENIDO -->
  	<main>
      <div class="clearfix">

          <a href="../menu.php"><button type="button" class="btn btn-back "><<<</button></a>

          <a href="insertar.php" target="#"><button type="button" class="btn btn-basico btn-insertar btn-secondary btn-lg ">Agregar</button></a>

          <a href="buscar.php" target="#"><button type="button" class="btn btn-basico btn-buscar btn-secondary btn-lg ">Buscar</button></a>

          <a href="modificar.php" target="#"><button type="button" class="btn btn-basico btn-modificar btn-secondary btn-lg ">Modificar</button></a>
          
          <a href="eliminar.php" target="#"><button type="button" class="btn btn-basico btn-eliminar btn-secondary btn-lg ">Eliminar</button></a>
        </div>

  		<div class="clearfix">
        <iframe class="frame" name="#">
          
        </iframe>
  		</div>

  	</main>
<!-- PIE DE PAGINA -->
  <footer class="foot">
	<hr>
      <div class="clearfix">
        <p class="text-white">ZAPATERIAGRIS 2018 &copy Todos los derechos reservados </p>
      </div>
  </footer>

</body>
</html>