<?php 

	class usuario{
		protected $idUsuario;
		protected $usuario;
		protected $contrasena;
		protected $rcontrasena;
		protected $cargo;

		function setIdUsuario($idUsuario){
			$this->idUsuario=$idUsuario;
		}
		function setUsuario($usuario){
			$this->usuario=$usuario;
		}
		function setcontrasena($contrasena){
			$this->contrasena=$contrasena;
		}
		function setRcontrasena($rcontrasena){
			$this->rcontrasena=$rcontrasena;
		}
		function setCargo($cargo){
			$this->cargo=$cargo;
		}


		function getIdUsuario(){
			return $this->idUsuario;
		}
		function getUsuario(){
			return $this->usuario;
		}
		function getcontrasena(){
			return $this->contrasena;
		}
		function getRcontrasena(){
			return $this->rcontrasena;
		}
		function getCargo(){
			return $this->cargo;
		}
	}

 ?>