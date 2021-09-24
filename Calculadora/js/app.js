console.log("Saludos desde JavaScript");
function sumar(){
    let form = document.getElementById("formulario");
    let operandoA = form["operandoA"];
    let operandoB = form["operandoB"];
    let resultado = parseInt(operandoA.value) + parseInt(operandoB.value);
    if(isNaN(resultado)){
        resultado = "No valido, solo se aceptan numeros";
    }
    document.getElementById("resultado").innerHTML = `Resultado: ${resultado}`;
}