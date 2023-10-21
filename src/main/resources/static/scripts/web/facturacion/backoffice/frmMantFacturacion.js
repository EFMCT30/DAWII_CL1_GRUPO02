$(document).on("click", "#btnagregar", function(){
    $("#txtFechafacturacion").val("");
    $("#txtMontofacturacion").val("");
     $("#cbonombre").empty();
    $("#hddcodhab").val("0");
    listarCboClientes(0);
    $("#modalNuevo").modal("show");
});

function listarCboClientes(idCliente){
    $.ajax({
        type: "GET",
        url: "/cliente/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbonombre").append(
                    `<option value="${value.cliente_id}">${value.nombre}</option>`
                )
            });
            if(idCliente > 0){
                $("#cbonombre").val(idCliente);
            }
        }
    });
}

$(document).on("click", "#btnguardar", function () {
    $.ajax({
        type: "POST",
        url: "/facturacion/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            facturacion_id: $("#hddcodhab").val(),
            fecha_facturacion: $("#txtFechafacturacion").val(),
            monto_total: $("#txtMontofacturacion").val(),
            cliente_id: $("#cbonombre").val(),
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                listarFacturaciones();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});


function listarFacturaciones() {
    $.ajax({
        type: "GET",
        url: "/facturacion/listar",
        dataType: "json",
        success: function (resultado) {
            $("#tblfacturacion > tbody").html("");
            $.each(resultado, function (index, value) {
                $("#tblfacturacion > tbody").append("<tr>" +
                    "<td>"+value.facturacion_id+"</td>"+
                                        "<td>"+value.fecha_facturacion+"</td>"+
                                        "<td>"+value.monto_total+"</td>"+
                                        "<td>"+value.cliente.nombre+"</td>"+
                                        "<td>"+
                                            "<button type='button' class='btn btn-info btnactualizar'"+
                                                         "data-facturacion_id='"+value.facturacion_id+"'"+
                                                         "data-fecha_facturacion='"+value.fecha_facturacion+"'"+
                                                         "data-monto_total='"+value.monto_total+"'"+
                                                         "data-idCliente='"+value.cliente.cliente_id+"'"+
                                                         "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            });
        }
    });
}

$(document).on("click", ".btnactualizar", function () {
    $("#txtFechafacturacion").val($(this).attr("data-fecha_facturacion"));
    $("#txtMontofacturacion").val($(this).attr("data-monto_total"));
    $("#cbonombre").empty();
    listarCboClientes($(this).attr("data-idCliente"));
    $("#hddcodhab").val($(this).attr("data-facturacion_id"));
    $("#modalNuevo").modal("show");
});
