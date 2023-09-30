$(document).on("click", "#btnagregar", function(){
    $("#txtfechainicio").val("");
    $("#txtfechafinal").val("");
    $("#hddcodreserva").val("0");
    $("#txtestado").val("");
    $("#txtpreciototal").val("");
    $("#txtfechacreacion").val("");
    $("#txtcomentarios").val("");
    $("#cbocliente").empty();
    listarCboClientes(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtfechainicio").val($(this).attr("data-fechaInicio"));
    $("#hddcodreserva").val($(this).attr("data-reservaId"));
    $("#txtfechafinal").val($(this).attr("data-fechaFin"));
    $("#txtestado").val($(this).attr("data-estado"));
    $("#txtpreciototal").val($(this).attr("data-precioTotal"));
    $("#txtfechacreacion").val($(this).attr("data-fechaCreacion"));
    $("#txtcomentarios").val($(this).attr("data-comentarios"));
    $("#cbocliente").empty();
    listarCboClientes($(this).attr("data-clientenombre"))


    // Añade otros campos de reserva aquí si es necesario

    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/reserva/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            reservaId: $("#hddcodreserva").val(),
            fechaInicio: $("#txtfechainicio").val(),
            fechaFin: $("#txtfechafinal").val(),
            estado: $("#txtestado").val(),
            precioTotal: $("#txtpreciototal").val(),
            fechaCreacion: $("#txtfechacreacion").val(),
            comentarios: $("#txtcomentarios").val(),
            clienteId: $("#cbocliente").val(),
            // Añade otros campos de reserva aquí si es necesario
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarReservas();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});


function listarCboClientes(idcliente){
    $.ajax({
        type: "GET",
        url: "/cliente/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocliente").append(
                    `<option value="${value.clienteId}">${value.nombre}</option>`
                )
            });
            if (idcliente > 0){
                $("#cbocliente").val(idcliente);
            }

        }
    });
}

function listarReservas(){
    $.ajax({
        type: "GET",
        url: "/reserva/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblreserva > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblreserva > tbody").append("<tr>"+
                    "<td>"+value.reservaId+"</td>"+
                    "<td>"+value.fechaInicio+"</td>"+
                    "<td>"+value.fechaFin+"</td>"+
                    "<td>"+value.estado+"</td>"+
                    "<td>"+value.precioTotal+"</td>"+
                    "<td>"+value.fechaCreacion+"</td>"+
                    "<td>"+value.comentarios+"</td>"+
                    "<td>"+value.cliente.nombre+"</td>"+
                    "<td>"+value.reservaHabitaciones+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                "data-reservaId='" + value.reservaId + "'" +
                                "data-fechaInicio='" + value.fechaInicio + "'" +
                                "data-fechaFin='" + value.fechaFin + "'" +
                                "data-estado='" + value.estado + "'" +
                                "data-precioTotal='" + value.precioTotal + "'" +
                                "data-fechaCreacion='" + value.fechaCreacion + "'" +
                                "data-comentario='" + value.comentarios + "'" +
                                "data-clientenombre='" + value.cliente.clientId + "'" +
                                "data-reservaHabitaciones='" + JSON.stringify(value.reservaHabitaciones) + "'>" +
                    "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}