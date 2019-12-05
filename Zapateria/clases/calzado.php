<?php 

	class calzado{

		protected $codigo;
		protected $alias;
		protected $tipo;
		protected $marca;
		protected $modelo;
		protected $color;	//***

		function setCodigo($codigo){
			$this->codigo = $codigo;
		}
		
		function setAlias($alias){
			$this->alias = $alias;
		}
		
		function setTipo($tipo){
			$this->tipo = $tipo;
		}

		function setMarca($marca){
			$this->marca = $marca;
		}

		function setModelo($modelo){
			$this->modelo = $modelo;
		}

		function setColor($color){		//***
			$this->color = $color;  	//***
		}								//***

		function getCodigo(){
			return $this->codigo;
		}

		function getAlias(){
			return $this->alias;
		}

		function getTipo(){
			return $this->tipo;
		}

		function getMarca(){
			return $this->marca;
		}

		function getModelo(){
			return $this->modelo;
		}

		function getColor(){			//***
			return $this->color;		//***
		}

	}


 ?>