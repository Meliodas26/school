<?php 
	$color = "";
	//$_SESSION["pagina"] = $_SERVER['PHP_SELF'];
	session_start();
  	if (!isset($_SESSION ["usuario"])) {
  	       header("Location: ../../index.php");
  	}
	include_once("../../clases/0dataBase.php");

	$objConexion = new conexion();

	$conexion = $objConexion->getConexion();

  	for($i=0; $i <= 2; $i++)
		$calzadoInfo[$i] = "";
	for($i=0; $i <= 10; $i++)
		$bebe[$i] = "";
	for($i=0; $i <= 9; $i++)
		$joven[$i] = "";
	for($i=0; $i <= 9; $i++)
		$adulto[$i] = "";
	include_once("buscarStockCdoPHP.php");
	include_once("eliminarStockCdoPHP.php");

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Eliminar stock de Calzado</title>
	<link href="../../imagenes/icon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="../../css/bootstrap.min.css" >
	<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" >
	<link rel="stylesheet" href="../../css/text.css" >	
	<script src="../../js/bootstrap.min.js" ></script>

	<script type="text/javascript" src="../../jQuery/jQuery.js"></script>
	<script type="text/javascript" src="../../jQuery/jquery-3.3.1.js"></script>
	<script src="../../js/stock.js" ></script> 

	<style type="text/css">
		body{
			color: white;
			background-color: #0D689D; 
		}
		.frame{
			background: #0D689D;
		  	margin: "0";
		  	padding: 0px 0px 0px 0px;
		  	border: 0px;
		  	width: 100%;
		  	height: 200px;
		}
		.btn-numeracion{
			padding: 5px;
  			background: #3e2723;
  			color: white;
		}
	</style>
</head>
<body>
	<div class="clearfix col-xs-2 row-xs-9">
		
		<form id="buscar" class="form" action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
			
			<label for="codigo">Codigo:</label>
			<input type="text" class="form-control" name="codigo" placeholder="#SalTipoMrca#Mlo_Cdo#id" value="<?=$calzadoInfo[0];?>">

			<label>Color:</label>
			<select class="form-control" name="color">
				<option>Ninguno</option>
				<option>Negro</option>
				<option>Blanco</option>
				<option>Rojo</option>
			</select>
			
			
			<button class="btn btn-lg btn-success btn-block" type="submit" name="buscar_eliminar">Buscar</button>
														
		</form>
		
	</div>
	<div class=" clearfix col-xs-9">
		<table class="table">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Sucursal</th> <!-- (idAlmacen) -->
						<th>Color</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$calzadoInfo[0];?></td>
						<td><?=$calzadoInfo[1];?></td>
						<td><?=$color?></td>
					</tr>
				</tbody>
			</table>
			<table class="table">
				<thead>
					<tr>
						<th>1</th>
			    		<th>2</th>
			    		<th>3</th>
			    		<th>4</th>
			    		<th>5</th>
			    		<th>6</th>
			    		<th>7</th>
			    		<th>8</th>
			    		<th>9</th>
			    		<th>10</th>
			    		<th>11</th>
			    		<th>12</th>
			    		<th>13</th>
			    		<th>14</th>
			    		<th>15</th>
			    		<th>16</th>
			    		<th>17</th>
			    		<th>18</th>
			    		<th>19</th>
			    		<th>20</th>
			    		<th>21</th>
			    		<th>22</th>
			    		<th>23</th>
			    		<th>24</th>
			    		<th>25</th>
			    		<th>26</th>
			    		<th>27</th>
			    		<th>28</th>
			    		<th>29</th>
			    		<th>30</th>
			    		<th>31</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><?=$bebe[0];?></td>
						<td><?=$bebe[1];?></td>
						<td><?=$bebe[2];?></td>
						<td><?=$bebe[3];?></td>
						<td><?=$bebe[4];?></td>
						<td><?=$bebe[5];?></td>
						<td><?=$bebe[6];?></td>
						<td><?=$bebe[7];?></td>
						<td><?=$bebe[8];?></td>
						<td><?=$bebe[9];?></td>
						<td><?=$bebe[10];?></td>
						<td><?=$joven[0];?></td>
						<td><?=$joven[1];?></td>
						<td><?=$joven[2];?></td>
						<td><?=$joven[3];?></td>
						<td><?=$joven[4];?></td>
						<td><?=$joven[5];?></td>
						<td><?=$joven[6];?></td>
						<td><?=$joven[7];?></td>
						<td><?=$joven[8];?></td>
						<td><?=$joven[9];?></td>
						<td><?=$adulto[0];?></td>
						<td><?=$adulto[1];?></td>
						<td><?=$adulto[2];?></td>
						<td><?=$adulto[3];?></td>
						<td><?=$adulto[4];?></td>
						<td><?=$adulto[5];?></td>
						<td><?=$adulto[6];?></td>
						<td><?=$adulto[7];?></td>
						<td><?=$adulto[8];?></td>
						<td><?=$adulto[9]?></td>
					</tr>
				</tbody>
		</table>
					
		<div class="row">
			<div class=" container row mg-5 col-xs-2 ">
		          <a href="numeracion/eliminarBebe.php" target="numeracion"><button type="button" class="btn btn-basico btn-numeracion btn-secondary btn-lg ">N1-N11</button></a>
		    </div>
		    <div class=" container row mg-5 col-xs-2 ">
		          <a href="numeracion/eliminarJoven.php" target="numeracion"><button type="button" class="btn btn-basico btn-numeracion btn-secondary btn-lg ">N12-N21</button></a>
		    </div>
		    <div class=" container row mg-5 col-xs-2 ">
		          <a href="numeracion/eliminarAdulto.php" target="numeracion"><button type="button" class="btn btn-basico btn-numeracion btn-secondary btn-lg ">N22-N31</button></a>
		    </div>

	    </div>
	    <div class="row">
        	<iframe class="frame" name="numeracion">
          
        	</iframe>
  		</div>
		
	</div>

</body>
</html>
