<?php 
		$usuarioInfo = mysqli_query($conexion,"SELECT * FROM usuarios WHERE usuario='$usuario'");
  $mostrar = mysqli_fetch_array($usuarioInfo);
/*Prueba*/
      for ($i=1; $i <= 6; $i++) {
          echo "$mostrar[$i]";
      }
 ?>