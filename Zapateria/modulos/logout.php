<?php
    //Reanudamos la sesión
	session_start ();	
    //cerrar la sesión
    session_destroy (); 
	header("location: ../index.php");
?>

