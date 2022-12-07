$(document).ready(function() {
	$('#dataNascimento').mask('00/00/0000')
})

$(document).ready(function() {
	var $cpf = $("#cpf");
	$cpf.mask('000.000.000-00');
})
$("#nome").on("input", function(){
  var regexp = /[^a-zA-Z]/g;
  if(this.value.match(regexp)){
    $(this).val(this.value.replace(regexp,''));
  }
})

$(document).ready(function() {
  $(document).on('keypress', '#senha', function(e){
     return !(e.keyCode == 32);
  });
});


function mostrarsenha(){
		var tipo = document.getElementById("senha");
		if(tipo.type =="password"){
			tipo.type = "text";
		}else{
			tipo.type = "password"
		}
	}