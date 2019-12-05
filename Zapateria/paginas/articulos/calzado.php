<?php 
	//Seguir en la sesion
  	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	} 
    include_once("../../clases/0dataBase.php");
    include_once("../../clases/almacen.php");
    $objConexion = new conexion();
    $conexion = $objConexion->getConexion();
    $_SESSION['sucursal'] = "?";


    if(isset($_POST['cambiar'])){
      $_SESSION['sucursal'] = $_POST['sucursal'];
    }
 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Calzado</title>
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
              <p id="sucursal" class="nav-link active"><?php echo $_SESSION ["usuario"];?> - <?php echo $_SESSION['sucursal'];?></p>
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

          <a href="insertarCalzado.php" target="calzado"><button type="button" class="btn btn-basico btn-insertar btn-secondary btn-lg ">Agregar calzado</button></a>


          <a href="buscarModificarCalzado.php" target="calzado"><button type="button" class="btn btn-basico btn-modificar btn-secondary btn-lg ">Buscar y modificar</button></a>
          
          <a href="eliminarCalzado.php" target="calzado"><button type="button" class="btn btn-basico btn-eliminar btn-secondary btn-lg ">Eliminar</button></a>
        </div>

        <form id="cambiarSucursal" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">

        <div class="clearfix col-xs-3 row-xs-12">
          <div class="form-group">
            <div class="row sucursal">
                <label for="sucursal" class="control-label text-white">Sucursal:</label>
            </div>
            <div class="row sucursal">
              <div class="col-xs-5 sucursalSelect">
                <select class="form-control input-sm slt-sucursal" name="sucursal">
                  <option><?=$_SESSION["sucursal"];?></option>
                  <?php
                    $i = 1;
                    $almacenes = mysqli_query($conexion, "SELECT nombre FROM almacen");
                    while($infoAlmacen = mysqli_fetch_array($almacenes)){
                      $almacen = $i.") ".$infoAlmacen["nombre"];
                      if($almacen != $_SESSION["sucursal"]){ ?>
                        <option> <?=$i.") ".$infoAlmacen["nombre"];?> </option><?php 
                      }
                      $i++;
                    }
                    $objConexion->endConexion($conexion);
                  ?>
                </select>
              </div>
            </div>
            <div class="row sucursal">

                <button id="cambiar" name="cambiar" type="submit" class="btn btn-sucursal btn-lg ">Seleccionar</button></a>
            </div>
          </div>
        </div>
        </form>
  		<div class="clearfix">
        <iframe class="frame-articulos" name="calzado">
          
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
