<?php 
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	} 
    include_once("../../clases/0dataBase.php");
    include_once("../../clases/almacen.php");
    $objConexion = new conexion();
    $_SESSION['sucursal'] = "?";

    $long = 0;
   $numeracion = "";
    
    if(isset($_POST['cambiar'])){
      	$_SESSION['sucursal'] = $_POST['sucursal'];
      	$almacen = $_POST['sucursal'];
      	$numeracion = $_POST['numeracion'];

      	$conexion = $objConexion->getConexion();
      	if ($numeracion == 'Bebe') {
      		$nion = mysqli_query($conexion,"call reporteBebe('$almacen')");
      	}

      	if ($numeracion == 'Joven') {
      		$nion = mysqli_query($conexion,"call reporteJoven('$almacen')");
      	}
      	$i = 0;

      	if ($numeracion == 'Adulto') {
      		$nion = mysqli_query($conexion,"call reporteAdulto('$almacen')");
      	}
      	$i = 0;
		while($n = mysqli_fetch_array($nion)){
		  	$codigo[$i] = $n["codigo"];
		  	$color[$i]  = $n["color"];
		  	$n1[$i]  = $n["n1"];
		  	$n2[$i]  = $n["n2"];
		  	$n3[$i]  = $n["n3"];
		  	$n4[$i]  = $n["n4"];
		  	$n5[$i]  = $n["n5"];
		  	$n6[$i]  = $n["n6"];
		  	$n7[$i]  = $n["n7"];
		  	$n8[$i]  = $n["n8"];
		  	$n9[$i]  = $n["n9"];
		  	$n10[$i]  = $n["n10"];
		  	if($numeracion == 'Bebe')
		  		$n11[$i]  = $n["n11"];
		  	else
		  		$n11[$i] = " ";
		  	$i++;
			$long = sizeof($codigo);
		}
      
		$objConexion->endConexion($conexion);


    }
    $conexion = $objConexion->getConexion();

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Reportes</title>
	<link href="../imagenes/icon.ico" rel="shortcut icon">
  	<link rel="stylesheet" href="../../css/plantilla.css"> 
  	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
  	<link rel="stylesheet" href="../../css/vista.css">
  	<link rel="stylesheet" href="../../css/text.css">
  	<link rel="stylesheet" href="../../css/btn.css">    
	<script src="../../js/bootstrap.min.js" ></script>


	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
	</style>
</head>

<body>
<!--   BARRA DE NAVEGACION   -->
    <nav class="navbar navbar-expand-md navbar-dark bg-dark navi">
		<a href="../menu.php"><button type="button" class="btn btn-back "><<<</button></a>
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
	

	<div class="clearfix col-xs-6 row-xs-9">
		
		<form id="cambiarSucursal" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
		       
		       <div class="clearfix col-xs-12 row-xs-12">
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
		               <select class="form-control input-sm slt-sucursal" name="numeracion"> 
							<option>Bebe</option>
							<option>Joven</option>
							<option>Adulto</option>
		               </select>
		             </div>
		           </div>
		           
		           <div class="row sucursal">
		       
		               <button id="cambiar" name="cambiar" type="submit" class="btn btn-sucursal btn-lg ">Seleccionar</button></a>
		           </div>
		         </div>
		       </div>
		       </form>
		
	</div>
						
	<div class=" clearfix col-xs-9">
		<table class="table">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Color</th>

						<?php 
							if ($numeracion == 'Bebe') 
								for($i=1; $i<=11; $i++){
						
						?>		<th><?=$i;?></th>
						
						<?php
							}
							if ($numeracion == 'Joven') 
								for($i=12; $i<=21; $i++){
						
						?>		<th><?=$i;?></th>
						
						<?php
								}
							if ($numeracion == 'Adulto') 
								for($i=22; $i<=31; $i++){
						
						?>		<th><?=$i;?></th>
						
						<?php
								}
						?>
					</tr>
				</thead>
				<tbody>
					<?php
					 if($long != 0)
						for ($i=0; $i <$long; $i++){

					?>
					<tr>
						<td><?=$codigo[$i];?></td>
						<td><?=$color[$i];?></td>
						<td><?=$n1[$i];?></td>
						<td><?=$n2[$i];?></td>
						<td><?=$n3[$i];?></td>
						<td><?=$n4[$i];?></td>
						<td><?=$n5[$i];?></td>
						<td><?=$n6[$i];?></td>
						<td><?=$n7[$i];?></td>
						<td><?=$n8[$i];?></td>
						<td><?=$n9[$i];?></td>
						<td><?=$n10[$i];?></td>
						<td><?=$n11[$i];?></td>
						<?php
						}?>
					</tr>
				</tbody>
			</table>
			
					
		
	</div>

</body>
</html>
