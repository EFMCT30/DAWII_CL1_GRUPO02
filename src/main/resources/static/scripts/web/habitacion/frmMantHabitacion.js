$(document).on("click", "#btnagregar", function(){
    $("#txtnumeroHabitacion").val("");
    $("#txttipo").val("");
    $("#txtcapacidad").val("");
    $("#txtprecioNoche").val("");
    $("#txtfecha_ultima_mantenimiento").val("");
    //$("#txtdisponible").val("");
    $("#hddcodhab").val("0");
    $("#cbonombre").empty();
    //$("#switchhabitacion" ).hide();
    $("#switchhabitacion" ).show();
    $("#chkdisponible").prop("checked", false);
    listarCboHoteles(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnumeroHabitacion").val($(this).attr("data-numeroHabitacion"));
    $("#txttipo").val($(this).attr("data-tipo"));
    $("#txtcapacidad").val($(this).attr("data-capacidad"));
    $("#txtprecioNoche").val($(this).attr("data-precioNoche"));
    $("#txtdisponible").val($(this).attr("data-disponible"));
    $("#txtfecha_ultima_mantenimiento").val($(this).attr("data-fecha_ultima_mantenimiento"));
    $("#hddcodhab").val($(this).attr("data-habitacionId"));
    $("#cbonombre").empty();
    listarCboHoteles($(this).attr("data-nombre"));
    $("#modalNuevo").modal("show");
    $("#switchhabitacion" ).show();
        if($(this).attr("data-disponible") === "true"){
            $("#chkdisponible").prop("checked", true);
        }else
            $("#chkdisponible").prop("checked", false);
        $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/habitacion/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            habitacion_Id: $("#hddcodhab").val(),
            numeroHabitacion: $("#txtnumeroHabitacion").val(),
            tipo: $("#txttipo").val(),
            capacidad: $("#txtcapacidad").val(),
            precioNoche: $("#txtprecioNoche").val(),
            disponible: $('#chkdisponible').prop('checked'),
            fecha_ultima_mantenimiento: $("#txtfecha_ultima_mantenimiento").val(),
            hotelId: $("#cbonombre").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarHabitaciones();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboHoteles(idhotel){
    $.ajax({
        type: "GET",
        url: "/hotel/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbonombre").append(
                    `<option value="${value.hotelId}">${value.nombre}</option>`
                )
            });
            if(idhotel > 0){
                $("#cbonombre").val(idhotel);
            }
        }
    });
}

function listarHabitaciones(){
    $.ajax({
        type: "GET",
        url: "/habitacion/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblhabitaciones > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblhabitaciones > tbody").append("<tr>"+
                    "<td>"+value.habitacion_Id+"</td>"+
                    "<td>"+value.numeroHabitacion+"</td>"+
                    "<td>"+value.tipo+"</td>"+
                    "<td>"+value.capacidad+"</td>"+
                    "<td>"+value.precioNoche+"</td>"+
                    "<td>"+value.disponible+"</td>"+
                    "<td>"+value.fecha_ultima_mantenimiento+"</td>"+
                    "<td>"+value.hotel.nombre+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-habitacionId='"+value.habitacion_Id+"'"+
                                     "data-numeroHabitacion='"+value.numeroHabitacion+"'"+
                                     "data-tipo='"+value.tipo+"'"+
                                     "data-capacidad='"+value.capacidad+"'"+
                                     "data-precioNoche='"+value.precioNoche+"'"+
                                     "data-disponible='"+value.disponible+"'"+
                                     "data-fecha_ultima_mantenimiento='"+value.fecha_ultima_mantenimiento+"'"+
                                     "data-nombre='"+value.hotel.hotelId+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}