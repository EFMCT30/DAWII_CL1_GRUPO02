$(document).on("click", "#btnagregar", function(){
    $("#txtnumeroHabitacion").val("");
    $("#txttipo").val("");
    $("#txtcapacidad").val("");
    $("#txtprecioNoche").val("");
    $("#txtfecha_ultima_mantenimiento").val("");
    $("#hddcodhab").val("0");
    $("#cbonombre").empty();
    $("#switchhabitacion" ).show();
    $("#chkdisponible").prop("checked", false);
    listarCboHoteles(0);
    $("#modalNuevo").modal("show");
});


$(document).on("click", ".btnactualizar", function () {
    $("#txtnumeroHabitacion").val($(this).attr("data-numeroHabitacion"));
    $("#txttipo").val($(this).attr("data-tipo"));
    $("#txtcapacidad").val($(this).attr("data-capacidad"));
    $("#txtprecioNoche").val($(this).attr("data-precioNoche"));
    var fechaInput = $(this).attr("data-fecha_ultima_mantenimiento");
    var partesFecha = fechaInput.split("-");
    var fechaFormateada = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0];
    $("#txtfecha_ultima_mantenimiento").val(fechaFormateada);
    $("#hddcodhab").val($(this).attr("data-habitacion_Id"));
    $("#cbonombre").empty();
    listarCboHoteles($(this).attr("data-nombre"));
    $("#modalNuevo").modal("show");
    $("#switchhabitacion").show();

    if ($(this).attr("data-disponible") === "true") {
        $("#chkdisponible").prop("checked", true);
    } else {
        $("#chkdisponible").prop("checked", false);
    }
});


$(document).on("click", "#btnguardar", function(){
    var fechaInput = $("#txtfecha_ultima_mantenimiento").val();
    var partesFecha = fechaInput.split("/");
    var fechaFormateada = partesFecha[2] + "-" + partesFecha[1] + "-" + partesFecha[0];
    $("#txtfecha_ultima_mantenimiento").val(fechaFormateada);
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
            fecha_ultima_mantenimiento: fechaFormateada,
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

function formatDate(dateString) {
    const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
    return new Date(dateString).toLocaleDateString(undefined, options);
}

function listarHabitaciones() {
    $.ajax({
        type: "GET",
        url: "/habitacion/listar",
        dataType: "json",
        success: function (resultado) {
            $("#tblhabitaciones > tbody").html("");
            $.each(resultado, function (index, value) {
                const fechaFormateada = formatDate(value.fecha_ultima_mantenimiento);
                $("#tblhabitaciones > tbody").append("<tr>"+
                    "<td>"+value.habitacion_Id+"</td>"+
                    "<td>"+value.numeroHabitacion+"</td>"+
                    "<td>"+value.tipo+"</td>"+
                    "<td>"+value.capacidad+"</td>"+
                    "<td>"+value.precioNoche+"</td>"+
                    "<td>"+value.disponible+"</td>"+
                    "<td>"+fechaFormateada+"</td>"+ // Utiliza la fecha formateada
                    "<td>"+value.hotel.nombre+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-habitacion_Id='"+value.habitacion_Id+"'"+
                                     "data-numeroHabitacion='"+value.numeroHabitacion+"'"+
                                     "data-tipo='"+value.tipo+"'"+
                                     "data-capacidad='"+value.capacidad+"'"+
                                     "data-precioNoche='"+value.precioNoche+"'"+
                                     "data-disponible='"+value.disponible+"'"+
                                     "data-fecha_ultima_mantenimiento='"+value.fecha_ultima_mantenimiento+"'"+
                                     "data-nombre='"+value.hotel.hotelId+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            });
        }
    })
}