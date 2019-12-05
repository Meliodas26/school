<?php 

	class empleado{
		protected $nombre;
		protected $telefono;
		protected $idSucursal;

		function setNombre($nombre){
			$this->nombre = $nombre; 
		}

		function setTelefono($telefono){
			$this->telefono = $telefono;
		}
		function setIdSucursal($idSucursal){
			$idSucursal = substr($idSucursal, 0, 1);
			$this->idSucursal = $idSucursal;
		}
		function getNombre(){
			return $this->nombre;
		}
		function getTelefono(){
			return $this->telefono;
		}
		function getIdSucursal(){
			return $this->idSucursal;
		}
	}
	
 ?>