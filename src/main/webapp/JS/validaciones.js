function validarFormulario() {
	
	const nombre = document.getElementById("userName").value.trim();
	const edad = document.getElementById("edad").value.trim();
	const genero = document.getElementById("genero").value;
	const ciudad = document.getElementById("ciudad").value.trim();
		
	document.getElementById("mensaje").innerHTML = "";
	
	//validar nombre
	if (nombre === "") { 
		document.getElementById("mensaje").innerHTML = "Debe ingresar un nombre.";
		return false;	
	}
			
	// Validar edad 
	if (edad === "") { 
		document.getElementById("mensaje").innerHTML = "Debe ingresar la edad.";
		return false; 
	} 
		
	if (isNaN(edad)) {
		document.getElementById("mensaje").innerHTML = "La edad debe ser un número.";
		return false;
	} 
	if (edad < 1 || edad > 110) {
		document.getElementById("mensaje").innerHTML = "La edad debe estar entre 1 y 110 años.";
		return false;
	} 
		
	// Validar género 
	if (genero === "") {
		document.getElementById("mensaje").innerHTML = "Debe seleccionar un género.";
		return false;
	} 
		 
	// Validar ciudad 
	
	if (ciudad === "") {
	    document.getElementById("mensaje").innerHTML = "Debe ingresar una ciudad.";
	    return false;
	}
	
	//Validar que en ciudad no se ingresen numeros
	if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(ciudad)) {
	    document.getElementById("mensaje").innerHTML = "La ciudad solo debe contener letras.";
	    return false;
	}

	return true;
}
