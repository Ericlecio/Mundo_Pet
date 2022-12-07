
$(document).ready(function () {
	$('#dataNascimento').mask('00/00/0000')
})

$(document).ready(function () {
	var $cpf = $("#cpf");
	$cpf.mask('000.000.000-00');
})

$(document).ready(function () {
	var $crmv = $("#crmv");
	$crmv.mask('000000000');
})

$("#nome").on("input", function(){
  var regexp = /[^a-zA-Z]/g;
  if(this.value.match(regexp)){
    $(this).val(this.value.replace(regexp,''));
  }
})

$(document).ready(function() {
  $(document).on('keypress', '#password', function(e){
     return !(e.keyCode == 32);
  });
});