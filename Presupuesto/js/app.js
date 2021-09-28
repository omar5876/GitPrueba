const ingresos = [
  new Ingreso("salario", 1000),
  new Ingreso("Venta coche", 1500),
];

const egresos = [
    new Egreso("Renta", 900), 
    new Egreso("Ropa", 400),
    new Egreso("calzoncillos", 50)
];
    

function cargarApp() {
  cargarCabecero();
  cargarIngresos();
  cargarEgresos();
}
function totalIngresos() {
  let totalIngresos = 0;
  for (let i of ingresos) {
    totalIngresos += i.valor;
  }
  return totalIngresos;
}

function totalEgresos() {
  let totalEgresos = 0;
  for (let i of egresos) {
    totalEgresos += i.valor;
  }
  return totalEgresos;
}

function cargarCabecero() {
  let presupuesto = totalIngresos() - totalEgresos();
  let porcentajeEgresos = totalEgresos() / totalIngresos();
  document.getElementById("presupuesto").innerHTML = formatoMoneda(presupuesto);
  document.getElementById("porcentaje").innerHTML =
    formatoPorcentaje(porcentajeEgresos);
  document.getElementById("ingresos").innerHTML = formatoMoneda(
    totalIngresos()
  );
  document.getElementById("egresos").innerHTML = formatoMoneda(totalEgresos());
}

function formatoMoneda(valor) {
  return valor.toLocaleString("en-US", {
    style: "currency",
    currency: "USD",
    minumumFractionDigits: 2,
  });
}

function formatoPorcentaje(valor) {
  return valor.toLocaleString("en-US", {
    style: "percent",
    minumumFractionDigits: 2,
  });
}

function cargarIngresos() {
  let ingresosHTML = "";
  for (i of ingresos) {
    ingresosHTML += crearIngresoHTML(i);
  }
  document.getElementById("lista-ingresos").innerHTML = ingresosHTML;
}

function crearIngresoHTML(ingreso) {
  let ingresoHTML = `
    <div class="elemento limpiarEstilos">
            <div class="elemento_descripcion">${ingreso.descripcion}</div>
            <div class="derecha limpiarEstilos">
              <div class="elemento_valor">${formatoMoneda(ingreso.valor)}</div>
              <div class="elemento_eliminar">
                  <button class="elemento_eliminar--btn">
                    <ion-icon name="close-circle-outline" onclick='eliminarIngreso(${ingreso.id})'></ion-icon>
                  </button>
              </div>
            </div>
          </div>`;
  return ingresoHTML;
}

function eliminarIngreso(id){
    let indiceEliminar = ingresos.findIndex(ingreso => ingreso.id === id);
    ingresos.splice(indiceEliminar, 1);
    cargarCabecero();
    cargarIngresos();
}

function cargarEgresos() {
  let egresosHTML = "";
  for (i of egresos) {
    egresosHTML += crearEgresoHTML(i);
  }
  document.getElementById("lista-egresos").innerHTML = egresosHTML;
}

function crearEgresoHTML(egreso) {
  let egresoHTML = `
    <div class="elemento limpiarEstilos">
    <div class="elemento_descripcion">${egreso.descripcion}</div>
    <div class="derecha limpiarEstilos">
        <div class="elemento_valor">${formatoMoneda(egreso.valor)}</div>
        <div class="elemento_porcentaje">${formatoPorcentaje(egreso.valor/totalEgresos())}</div>
        <div class="elemento_eliminar">
            <button class="elemento_eliminar--btn">
                <ion-icon name="close-circle-outline" onclick='eliminarEgreso(${egreso.id})'></ion-icon>
            </button>
        </div>
    </div>
    </div>`;
    return egresoHTML;

}

function eliminarEgreso(id){
    let indiceEliminar = egresos.findIndex(egreso => egreso.id === id);
    egresos.splice(indiceEliminar, 1);
    cargarCabecero();
    cargarEgresos();
}

function agregarDato(){
    let formulario = document.forms["formulario"];
    let tipo = formulario["tipo"];
    let descripcion = formulario["descripcion"];
    let valor = formulario["valor"];
    if(descripcion.value !== "" && valor.value !== ""){
        if(tipo.value === "ingreso"){
            ingresos.push(new Ingreso(descripcion.value, +valor.value));
            cargarCabecero();
            cargarIngresos();
        }else if(tipo.value === "egreso"){
            egresos.push(new Egreso(descripcion.value, +valor.value));
            cargarCabecero();
            cargarEgresos();
        }
    }
}
