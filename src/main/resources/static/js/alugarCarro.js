window.onload = function(){
	
	var form = document.getElementById("form_alugar_carro");
	form.addEventListener("submit", validar);
}

function validar(ev){
	
	var data_inicio = document.getElementById("data_inicio");
	var data_fim = document.getElementById("data_fim");
	var carro = document.getElementById("carro");

	var span_marca = document.getElementById("span_data_inicio");
	var span_modelo = document.getElementById("span_data_fim");
	var span_carro_selecionado = document.getElementById("span_carro_selecionado");
	
	var vetor_inputs = [data_inicio, data_fim];
	var vetor_spans = [span_data_inicio, span_data_fim];

	var carro_selecionado = carro.value;
	
	for(i = 0; i < vetor_inputs.length; i++){

		if(vetor_inputs[i].value.length == 0){
			vetor_spans[i].innerHTML = "Campo obrigatório";
			vetor_spans[i].style.display = "block";
			ev.preventDefault();
		}else{		

			vetor_spans[i].innerHTML = "";
			//ev.preventDefault();
		}

	}
	
	if(carro_selecionado == "" || carro_selecionado == "Selecione"){		
		
		span_carro_selecionado.innerHTML = "Selecione um dos carros disponíveis na lista.";
		span_carro_selecionado.style.display = "block";

		ev.preventDefault();
	}


	//validação da data de inicio
	if(data_inicio.value.length != 10){
		
		span_data_inicio.innerHTML = "A data está em um formato inválido. Ex : 10/07/2017";
		span_data_inicio.style.display = "block";

		ev.preventDefault();
	}

	//validação da data de término
	if(data_fim.value.length < 3){
		
		span_data_fim.innerHTML = "A data está em um formato inválido. Ex : 20/07/2017";
		span_data_fim.style.display = "block";

		ev.preventDefault();
	}
	
	// outras validações 
	
	var data_1 = new Date(data_inicio.value);
    var data_2 = new Date(data_fim.value);
	
    if (data_1 > data_2) {
       span_data_fim.innerHTML = "A data de entrega não pode ser maior do que a data de aluguel";
	   span_data_fim.style.display = "block";

		ev.preventDefault();
    }
	

	
}