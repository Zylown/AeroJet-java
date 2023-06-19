document.getElementById("myForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma predeterminada

    // Mostrar el modal
    var modal = document.getElementById("myModal");
    modal.style.display = "block";

    // Agregar evento de cierre al hacer clic en la "x" del modal
    var closeButton = document.getElementsByClassName("close")[0];
    closeButton.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Puedes agregar aquí cualquier otra lógica que desees ejecutar después de enviar el formulario

    // Reiniciar el formulario (opcional)
    this.reset();
});