$(function(){
	$('tr #deleteitem').click(function(e){
		
		var elemento = $(this);
		var idproducto = elemento.parent().find('#idarticulo').text();
		$.ajax({
			url: 'EliminarCarro',
			type: 'post',
			data: {idproducto : idproducto},
			success: function(r) {
				elemento.parent().parent().remove();
				var elementostabla = $('#shop-table tr');
				if(elementostabla <= 1){
					$('#contenedor').append("<h4> No hay articulos en el carro</h4>");
				}
				$('#total').text(r);
			}			
			
		})
	});	
	
});