/* Mensajes de error */
error = "¿?";
stock = "No puede eliminar mas de lo que tiene"
sinError = "";

$(document).ready(function(){
	$("#stock").click(function(){
		var numeros = /(^[0-9-]+$)/;
		var numerosF = /(^[0-9]+(\.[0-9]{1,2})+$)/;

		var n1 = $("#n1").val();
		var n2 = $("#n2").val();
		var n3 = $("#n3").val();
		var n4 = $("#n4").val();
		var n5 = $("#n5").val();
		var n6 = $("#n6").val();
		var n7 = $("#n7").val();
		var n8 = $("#n8").val();
		var n9 = $("#n9").val();
		var n10 = $("#n10").val();
		var n11 = $("#n11").val();

		var bebe1 = '<?php echo $bebe[0];?>';
		if(!numeros.test(n1)){
			document.getElementById("errorN1").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN1").innerHTML = sinError;
		}
		if(!numeros.test(n2)){
			document.getElementById("errorN2").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN2").innerHTML = sinError;
		}
		if(!numeros.test(n3)){
			document.getElementById("errorN3").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN3").innerHTML = sinError;
		}
		if(!numeros.test(n4)){
			document.getElementById("errorN4").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN4").innerHTML = sinError;
		}
		if(!numeros.test(n5)){
			document.getElementById("errorN5").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN5").innerHTML = sinError;
		}
		if(!numeros.test(n6)){
			document.getElementById("errorN6").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN6").innerHTML = sinError;
		}
		if(!numeros.test(n7)){
			document.getElementById("errorN7").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN7").innerHTML = sinError;
		}
		if(!numeros.test(n8)){
			document.getElementById("errorN8").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN8").innerHTML = sinError;
		}
		if(!numeros.test(n9)){
			document.getElementById("errorN9").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN9").innerHTML = sinError;
		}
		if(!numeros.test(n10)){
			document.getElementById("errorN10").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN10").innerHTML = sinError;
		}
		if(!numeros.test(n11)){
			document.getElementById("errorN11").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN11").innerHTML = sinError;
		}
		if(!numeros.test(n12)){
			document.getElementById("errorN12").innerHTML = error;
			return false;
		}else{
			document.getElementById("errorN12").innerHTML = sinError;
		}
		
	});
});
