
$(document).ready(function () {
	$('#data_consulta').mask('00/00/0000')
})

$(document).ready(function () {
	var $cpf = $("#cpf");
	$cpf.mask('000.000.000-00');
})

$(function() {
	$("#data_consulta").datepicker({
		changeMonth: true,
		changeYear: true, 	
		yearRange: "2023:2025",
		dateFormat:"dd/mm/yy",
		showOtherMonths:true,
		selectOherMonths:true,
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	});
});