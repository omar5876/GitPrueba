function mostrarReloj(){
    let fecha = new Date();
    let hora = formatoHora(fecha.getHours());
    let minutos = formatoHora(fecha.getMinutes());
    let segundos = formatoHora(fecha.getSeconds());
    document.getElementById("hora").innerHTML = `${hora} : ${minutos} : ${segundos}`;
    
    const meses = ["january", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    const dias = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursady", "Friday", "Saturday"];
    let diaSemana = dias[fecha.getDay()];
    let dia = fecha.getDate();
    let mes = meses[fecha.getMonth()];
    let fechaTexto = `${diaSemana}, ${dia} ${mes}`;
    document.getElementById("fecha").innerHTML = fechaTexto;

    document.getElementById("contenedor").classList.toggle("animar");
}
function formatoHora(hora){//para que aparezca eñ cero
    if(hora < 10){
        hora = "0" + hora;
    }
    return hora;
}
setInterval(mostrarReloj, 1000)
