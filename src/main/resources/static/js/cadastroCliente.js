window.onload = function(){

	var form = document.getElementById("form_cadastro_cliente");
	form.addEventListener("submit", validar);
	
}

function validar(ev){
	
	var nome = document.getElementById("nome");
	var email = document.getElementById("email");
	var senha = document.getElementById("senha");
	var senha_repetida = document.getElementById("senha_repetida");
	var endereco = document.getElementById("endereco");
	

	var span_nome = document.getElementById("span_nome");
	var span_email = document.getElementById("span_email");
	var span_senha = document.getElementById("span_senha");
	var span_senha_repetida = document.getElementById("span_senha_repetida");
	var span_endereco = document.getElementById("span_endereco");
	

	var vetor_inputs = [nome, email, senha, senha_repetida, endereco];
	var vetor_spans = [span_nome, span_email, span_senha, span_senha_repetida, span_endereco];


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

	//confirmação de senha
	if(senha.value != senha_repetida.value){
		
		span_senha.innerHTML = "Senhas diferentes."
		span_senha_repetida.innerHTML = "Senhas diferentes."
		span_senha.style.display = "block";

		ev.preventDefault();
	}

	//tamanho dos campos

	if(nome.value.length < 6){
		span_nome.innerHTML = "O nome deve ter no mínimo 6 caracteres. Ex : Marcos";
		span_nome.style.display = "block";

		ev.preventDefault();	
	}

	if(senha.value.length < 6){
		span_senha.innerHTML = "A senha deve ter no mínimo 6 caracteres.";
		span_senha.style.display = "block";

		ev.preventDefault();	
	}

	if(senha_repetida.value.length < 6){
		span_senha_repetida.innerHTML = "A confirmação da senha deve ter no mínimo 6 caracteres.";
		span_senha_repetida.style.display = "block";

		ev.preventDefault();	
	}

	// "@" e "." no email
	if(email.value.indexOf(".") == -1){

		span_email.innerHTML = "O formato do email informado está incorreto. Ex: meuemail@dominio.com.br";
		span_email.style.display = "block";
		ev.preventDefault();
	}

	if(email.value.indexOf("@") == -1){

		span_email.innerHTML = "O formato do email informado está incorreto. Ex: meuemail@dominio.com.br";
		span_email.style.display = "block";
		ev.preventDefault();
	}
	
	if(endereco.value.length < 6){
		
		span_endereco.innerHTML = "Endereço muito curto..";
		span_endereco.style.display = "block";

		ev.preventDefault();	
	}
	

}