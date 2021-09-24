const personas = [
  new Persona("Juan", "Perez"),
  new Persona("Karla", "Lara"),
  new Persona("Omar", "Ramirez"),
];

function mostrarPersonas() {
  console.log("Ejecutando metodo mostrarPersonas");
  let text = "";
  for (let persona of personas) {
    text += `<li>${persona.nombre} ${persona.apellido}</li>`;
  }
  document.getElementById("personas").innerHTML = text;
}

function agregarPersona() {
  const formulario = document.forms["formulario"];
  const nombre = formulario["nombre"];
  const apellido = formulario["apellido"];
  if (apellido.value != "" && nombre.value != "") {
    const persona = new Persona(nombre.value, apellido.value);
    personas.push(persona);
    console.log(persona);
    mostrarPersonas();
  }else{
      console.log("No hay informacion");
  }
}
