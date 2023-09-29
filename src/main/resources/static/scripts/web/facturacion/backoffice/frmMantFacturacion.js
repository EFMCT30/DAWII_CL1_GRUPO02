$(document).on("click", "#btnagregar", function(){
    $("#txtIdfacturacion").val("");
    $("#txtFechafacturacion").val("");
    $("#txtMontofacturacion").val("");
    $("#txtIdCliente").val("");
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function () {
    $("#txtIdfacturacion").val($(this).attr("data-facturacionId"));
    $("#txtFechafacturacion").val($(this).attr("data-fechaFacturacion"));
    $("#txtMontofacturacion").val($(this).attr("data-montoTotal"));
    $("#txtMontofacturacion").val($(this).attr("data-idCliente"));
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function () {
    $.ajax({
        type: "POST",
        url: "/facturacion/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            facturacionId: $("#txtIdfacturacion").val(),
            fechaFacturacion: $("#txtFechafacturacion").val(),
            montoTotal: $("#txtMontofacturacion").val(),
            idcliente: $("#txtIdCliente").val(),
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                listarProductos();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarProductos() {
    $.ajax({
        type: "GET",
        url: "/facturacion/listar",
        dataType: "json",
        success: function (resultado) {
            $("#tblfacturacion > tbody").html("");
            $.each(resultado, function (index, value) {
                $("#tblfacturacion > tbody").append("<tr>" +
                    "<td>" + value.facturacionId + "</td>" +
                    "<td>" + value.fechaFacturacion + "</td>" +
                    "<td>" + value.montoTotal + "</td>" +
                    "<td>" + value.idcliente + "</td>" +
                    "<td>" +
                    "<button type='button' class='btn btn-info btnactualizar'" +
                    "data-facturacionId='" + value.facturacionId + "'" +
                    "data-fechaFacturacion='" + value.fechaFacturacion + "'" +
                    "data-montoTotal='" + value.montoTotal + "'>" +
                    "data-idCliente='" + value.idcliente + "'>" +
                    "<i class='fas fa-edit'></i></button>" +
                    "</td></tr>");
            });
        }
    });
}