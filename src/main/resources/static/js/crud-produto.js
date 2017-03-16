$(function(){
	
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({thousands: '.', decimal: ','});
	$('.js-currency-quant').maskMoney({precision: 0});
	
});

$('#excluirProdutoDialogo').on('show.bs.modal', function(event){

	var button = $(event.relatedTarget);
	
	var codigoProduto = button.data('codigo');
	var nomeProduto = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + codigoProduto);
	form.find('.modal-body span strong').html('<strong>' + nomeProduto + '</strong>');
	
});