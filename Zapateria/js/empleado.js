
/* Mensajes de error */
mensaje = "Llena este campo";
caracteres = "No se aceptan caracteres especiales";
caracteresNumeros = "No se aceptan caracteres especiales ni numeros";
numeros = "Solo numeros";
sinError = "";
errorPhone = "Formato de telefono invalido";
vacio = "Llene este campo";
errorContrasena = "Al menos - una letra minuscula,mayuscula, un caracter y digito - Minimo 5 caracteres y maximo 18";

$(document).ready(function(){
	$("#registrar").click(function(){
		var text = /(^[A-Za-z\s]+$)/;
		var textnum = /(^[A-Za-z0-9\s]+$)/;
		var num = /(^[0-9-]+$)/;
		var phone = /^([0-9]{3})+(-)+([0-9]{3})+(-)+([0-9]{4})$/;
		var password = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){8,15}$/;//Sin espacios

		var nombre = $("#nombre").val();
		var telefono = $("#telefono").val();
		var usuario = $("#usuario").val();
		var contrasena = $("#contrasena").val();
		var contrasenaR = $("#contrasenaR").val();


		if(!text.test(nombre)){
			if(nombre != ""){
				document.getElementById("errorNombre").innerHTML = caracteresNumeros;
				return false;
			}
			else{
				document.getElementById("errorNombre").innerHTML = vacio;
				return false;
			}
		}else{
				document.getElementById("errorNombre").innerHTML = sinError;
		}

		if(!phone.test(telefono)){
			if(telefono != ""){
				document.getElementById("errorTelefono").innerHTML = errorPhone;
				return false;
			}else{
				document.getElementById("errorTelefono").innerHTML = sinError;
			}
		}else{
			document.getElementById("errorTelefono").innerHTML = sinError;
		}

		if(!textnum.test(usuario)){
			if(usuario != ""){
				document.getElementById("errorUsuario").innerHTML = caracteres;
				return false;
			}else{
				document.getElementById("errorUsuario").innerHTML = vacio;
			}
		}else{
			document.getElementById("errorUsuario").innerHTML = sinError;
		}

		if(!password.test(contrasena)){
				document.getElementById("errorContrasena").innerHTML = errorContrasena;
				return false;
		}else{
				document.getElementById("errorContrasena").innerHTML = sinError;
			
		}

		
		if(contrasena = contrasenaR){
			document.getElementById("errorContrasenaR").innerHTML = sinError;
		}
		else{
			document.getElementById("errorContrasenaR").innerHTML = "La contraseña no coincide ";
			return false;
		}

	});
});
