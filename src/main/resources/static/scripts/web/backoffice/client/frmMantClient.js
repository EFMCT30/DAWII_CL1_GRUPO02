$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtemail").val("");
    $("#txttelefono").val("");
    $("#txtdireccion").val("");
    $("#hddcodli").val("0");
    $("#cbopais").empty();
     listarCboPaises(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtemail").val($(this).attr("data-email"));
    $("#txttelefono").val($(this).attr("data-telefono"));
    $("#txtdireccion").val($(this).attr("data-direccion"));
    $("#hddcodli").val($(this).attr("data-cliente_id"));
    $("#cbopais").empty();
    listarCboPaises($(this).attr("data-pais"));
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/client/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            cliente_id: $("#hddcodli").val(),
            nombre: $("#txtnombre").val(),
            email: $("#txtemail").val(),
            telefono: $("#txttelefono").val(),
            direccion: $("#txtdireccion").val(),
            IdPais: $('#cbopais').val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listaClientes();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboPaises(idpais){
    $.ajax({
        type: "GET",
        url: "/pais/listar",
        dataType: "json",
        success: function(resultado){
        console.log(resultado);
            $.each(resultado, function(index, value){
                $("#cbopais").append(
                    `<option value="${value.IdPais}">${value.Nompais}</option>`

                )
            });
            if(idpais > 0){
                $("#cbopais").val(idpais);
            }
        }
    });
}

function listaClientes(){
    $.ajax({
        type: "GET",
        url: "/client/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblcliente > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcliente > tbody").append("<tr>"+
                    "<td>"+value.cliente_id+"</td>"+
                    "<td>"+value.nombre+"</td>"+
                    "<td>"+value.email+"</td>"+
                     "<td>"+value.telefono+"</td>"+
                      "<td>"+value.direccion+"</td>"+
                    "<td>"+value.pais.Nompais+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-prodcod='"+value.cliente_id+"'"+
                                     "data-prodname='"+value.nombre+"'"+
                                     "data-produnit='"+value.email+"'"+
                                     "data-prodcateg='"+value.telefono+"'"+
                                     "data-prodprov='"+value.direccion+"'"+
                                     "data-descontinuado='"+value.pais.IdPais+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}