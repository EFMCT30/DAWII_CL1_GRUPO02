$(document).on("click", "#btnagregar", function(){
    $("#txtIdfacturacion").val("");
    $("#txtFechafacturacion").val("");
    $("#txtMontofacturacion").val("");
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtIdfacturacion").val($(this).attr("data-facturacionId"));
    $("#txtFechafacturacion").val($(this).attr("data-fechaFacturacion"));
    $("#txtMontofacturacion").val($(this).attr("data-montoTotal"));
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/facturacion/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            facturacionId: $("#txtIdfacturacion").val(),
            fechaFacturacion: $("#txtFechafacturacion").val(),
            montoTotal: $("#txtMontofacturacion").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarFacturacion();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});


function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/facturacion/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append("<tr>"+
                    "<td>"+value.facturacionId+"</td>"+
                    "<td>"+value.fechaFacturacion+"</td>"+
                    "<td>"+value.montoTotal+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-facturacionId='"+value.facturacionId+"'"+
                                     "data-fechaFacturacion='"+value.fechaFacturacion+"'"+
                                     "data-montoTotal='"+value.montoTotal+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}