// URL base de la API
const API_URL = "http://localhost:8080/clientes";

// Cargar todos los clientes al cargar la página
async function cargarClientes() {
  try {
    const res = await fetch(API_URL);
    const clientes = await res.json();

    const tabla = document.getElementById("tablaClientes");
    tabla.innerHTML = clientes.map(c => `
      <tr>
        <td>${c.idCliente}</td>
        <td>${c.nombre}</td>
        <td>${c.apellido}</td>
        <td>${c.direccion || ''}</td>
        <td>${c.telefono}</td>
        <td>${c.correo}</td>
        <td>
          <button onclick="eliminarCliente(${c.idCliente})">🗑️</button>
        </td>
      </tr>
    `).join("");
  } catch (error) {
    console.error("❌ Error al cargar clientes:", error);
  }
}

// Agregar un nuevo cliente
async function agregarCliente() {
  // Obtener los valores del formulario
  const nombre = document.getElementById("nombre").value.trim();
  const apellido = document.getElementById("apellido").value.trim();
  const direccion = document.getElementById("direccion").value.trim();
  const telefono = document.getElementById("telefono").value.trim();
  const correo = document.getElementById("correo").value.trim();

  // Validar campos
  if (!nombre || !apellido || !telefono || !correo) {
    alert("Por favor completa los campos obligatorios (nombre, apellido, teléfono y correo).");
    return;
  }

  // Enviar datos al backend
  try {
    const res = await fetch(API_URL, {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({ nombre, apellido, direccion, telefono, correo })
    });

    if (!res.ok) throw new Error("Error al agregar cliente");

    // Limpiar formulario
    document.getElementById("nombre").value = "";
    document.getElementById("apellido").value = "";
    document.getElementById("direccion").value = "";
    document.getElementById("telefono").value = "";
    document.getElementById("correo").value = "";

    // Recargar la tabla
    await cargarClientes();

  } catch (error) {
    console.error("❌ Error al agregar cliente:", error);
  }
}

// Eliminar un cliente por ID
async function eliminarCliente(idCliente) {
  if (!confirm("¿Seguro que deseas eliminar este cliente?")) return;

  try {
    const res = await fetch(`${API_URL}/${idCliente}`, {
      method: "DELETE"
    });

    if (!res.ok) throw new Error("Error al eliminar cliente");

    await cargarClientes();
  } catch (error) {
    console.error("❌ Error al eliminar cliente:", error);
  }
}

// Cargar clientes al iniciar la página
window.addEventListener("DOMContentLoaded", cargarClientes);
