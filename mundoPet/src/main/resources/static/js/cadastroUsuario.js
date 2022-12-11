$(document).ready(function() {
	$('#dataNascimento').mask('00/00/0000')
})

$(document).ready(function() {
	var $cpf = $("#cpf");
	$cpf.mask('000.000.000-00');
})

$(document).ready(function() {
	$(document).on('keypress', '#senha', function(e) {
		return !(e.keyCode == 32);
	});
});


function mostrarsenha() {
	var tipo = document.getElementById("senha");
	if (tipo.type == "password") {
		tipo.type = "text";
	} else {
		tipo.type = "password"
	}
}

$(function() {
	$("#dataNascimento").datepicker({
		changeMonth: true,
		changeYear: true, 	
		yearRange: "1950:2022",
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




