<?php 
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
  <title>Stock</title>
  <link href="../imagenes/icon.ico" rel="shortcut icon">
  <link rel="stylesheet" href="../../css/plantilla.css"> 
  <link rel="stylesheet" href="../../css/bootstrap.min.css" >
  <link rel="stylesheet" href="../../css/vista.css">
  <link rel="stylesheet" href="../../css/text.css">
  <link rel="stylesheet" href="../../css/btn.css">

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
      
      <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto ">
            <li class="nav-item mr-4 ">
              <p id="sucursal" class="nav-link active"><?php echo $_SESSION ["usuario"];?></p>
            </li>
          </ul>
        <div class="clearfix">
            <a class="" href="../modulos/logout.php"><button class="btn btn-primary mx-2 float-right">Cerrar sesion</button></a>
            
            <a class="" href="../menu.php"><button class="btn btn-primary mx-2 float-right">Menu</button></a>
        </div>
      </div>
    </nav>
  
<!-- CONTENIDO -->
    <main>
      <a href="../menu.php"><button type="button" class="btn btn-back "><<<</button></a>

      <div class=" container row mg-5 ">
          <a href="stockCalzado.php"><button id="calzado" class="btn btn-menu btn-calzado btn-secondary btn-lg ">Calzado</button></a>
      </div>
     <div class=" container row mg-5 ">
         <a href="stockRopa.php"><button id="ropa" type="button" class="btn btn-menu btn-ropa btn-secondary btn-lg ">Ropa</button></a>
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