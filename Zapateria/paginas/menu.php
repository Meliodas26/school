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
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> 
	<title>Menu</title>
	<link href="../imagenes/icon.ico" rel="shortcut icon">
  <link rel="stylesheet" href="../css/plantilla.css"> 
	<link rel="stylesheet" href="../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../css/vista.css">
  <link rel="stylesheet" href="../css/text.css">
  <link rel="stylesheet" href="../css/btn.css">
	
	<script src="js/bootstrap.min.js" ></script>

	<script src="../jQuery/jQuery.js"></script>  
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>  -->
  
	<!--Mias-->
	<link rel="stylesheet" href="../css/boots.css">
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
            <a class="" href="../modulos/logout.php"><button class="btn btn-primary mx-2 float-right">Cerrar sesion</button></a>
            
        </div>
      </div>
    </nav>
	
<!-- CONTENIDO -->
  	<main>
    	<div class=" container row mg-5 ">
  				<a href="administrador/administrador.php"><button id="administrador" class="btn btn-menu btn-administrador btn-secondary btn-lg ">Administrador</button></a>
    	</div>
		<div class=" container row mg-5 ">
  				<a href="articulos/calzado.php"><button id="altaDeArticulos" type="button" class="btn btn-menu btn-altaDeArticulos btn-secondary btn-lg ">+ Calzado +</button></a>
    	</div>
    	<div class=" container row mg-5 ">
  				<a href="stock/stockCalzado.php"><button id="stock" type="button" class="btn btn-menu btn-stock btn-secondary btn-lg ">Stock</button></a>
        <div class="col-xs-3">
          <a href="reporte/reporte.php"><button id="reportes" type="button" class="btn btn-success btn-menu btn-reportes btn-secondary btn-lg ">Reportes</button></a>
        </div>

    	</div>

  		<div class="container">
  			
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