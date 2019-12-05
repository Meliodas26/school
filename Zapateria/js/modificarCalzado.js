mensaje = "Llena este campo";
caracteres = "No se aceptan caracteres especiales";
numeros = "Solo numeros";
sinError = "Aaa";


$(document).ready(function(){
	$("#modificarCalzado").click(function(){
		var text = /(^[A-Za-z\s]+$)/;
		var textnum = /(^[A-Za-z0-9\s]+$)/;
		var num = /(^[0-9-]+$)/;

		var alias = $("#alias").val();
		var modelo = $("#modelo").val();

		if(!textnum.test(alias)){
			if(alias != ""){
				document.getElementById("errorAlias").innerHTML = caracteres;
				return false;
			}else{
				document.getElementById("errorAlias").innerHTML = sinError;
			}
		}else{
			document.getElementById("errorAlias").innerHTML = sinError;
		}

		if(modelo != ""){
			if(!num.test(modelo)){
				document.getElementById("errorModelo").innerHTML = numeros;
				return false;
			}else{
				document.getElementById("errorModelo").innerHTML = sinError;
			}
		}else{
			document.getElementById("errorModelo").innerHTML = sinError;
		}
	});
});

