window.onload = function(){
	var form = document.getElementById("form_cadastro_carro");
	form.addEventListener("submit", validar);
}

function validar(ev){
	
	var marca = document.getElementById("marca");
	var modelo = document.getElementById("modelo");
	var placa = document.getElementById("placa");
	var ano = document.getElementById("ano");
	var preco_dia = document.getElementById("preco");
	var descricao = document.getElementById("descricao");
	

	var span_marca = document.getElementById("span_marca");
	var span_modelo = document.getElementById("span_modelo");
	var span_placa = document.getElementById("span_placa");
	var span_ano = document.getElementById("span_ano");
	var span_preco_dia = document.getElementById("span_preco");
	var span_descricao = document.getElementById("span_descricao");
	

	var vetor_inputs = [marca, modelo, placa, ano, preco_dia, descricao];
	var vetor_spans = [span_marca, span_modelo, span_placa, span_ano, span_preco_dia, span_descricao];


	for(i = 0; i < vetor_inputs.length; i++){

		if(vetor_inputs[i].value.length == 0){
			vetor_spans[i].innerHTML = "Campo obrigatório";
			vetor_spans[i].style.display = "block";
			ev.preventDefault();
		}else{		

			vetor_spans[i].innerHTML = "";
			ev.preventDefault();
		}

	}


	//validação da marca
	if(marca.value.length < 4){
		
		span_marca.innerHTML = "A marca deve ter no mínimo 4 caracteres. Ex : Fiat";
		span_marca.style.display = "block";

		ev.preventDefault();
	}

	//validação do modelo
	if(modelo.value.length < 3){
		
		span_modelo.innerHTML = "O modelo deve ter no mínimo 3 caracteres. Ex : Uno";
		span_modelo.style.display = "block";

		ev.preventDefault();
	}

	//validação da placa (mascara)
	if(placa.value.length != 8){

		span_placa.innerHTML = "O placa deve ter 8 caracteres. Ex : ABC-1234";
		span_placa.style.display = "block";

		ev.preventDefault();
	}

	//validação do ano
	if(ano.value.length != 4){
		
		span_ano.innerHTML = "O ano deve ter 4 caracteres. Ex: 2008";
		span_ano.style.display = "block";

		ev.preventDefault();
	}

	//validação do preco diario (mascara)
	if(preco.length != 10){
		
		span_ano.innerHTML = "O preço está em um formato incorreto. Ex: R$ 1099.99";
		span_ano.style.display = "block";

		ev.preventDefault();
	}
	
	//validação da descricao
	if(descricao.length < 10){
		
		span_descricao.innerHTML = "Descrição está muito curta.";
		span_descricao.style.display = "block";

		ev.preventDefault();
	}
	

}