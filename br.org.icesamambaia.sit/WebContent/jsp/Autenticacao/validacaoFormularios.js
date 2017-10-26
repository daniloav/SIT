
function formatar_mascara(src, mascara) {
	var campo = src.value.length;
	var saida = mascara.substring(0,1);
	var texto = mascara.substring(campo);
	if(texto.substring(0,1) != saida) {
		src.value += texto.substring(0,1);
	}
}

 function mascara_data(data){
                var mydata = '';
                mydata = mydata + data;
                if (mydata.length == 2){
                    mydata = mydata + '/';
                    document.forms[0].data.value = mydata;
                }
                if (mydata.length == 5){
                    mydata = mydata + '/';
                    document.forms[0].data.value = mydata;
                }
                if (mydata.length == 10){
                    verifica_data();
                }
            }

            function verifica_data () {

                dia = (document.forms[0].data.value.substring(0,2));
                mes = (document.forms[0].data.value.substring(3,5));
                ano = (document.forms[0].data.value.substring(6,10));

                situacao = "";
                // verifica o dia valido para cada mes
                if ((dia < 01)||(dia < 01 || dia > 30) && (  mes == 04 || mes == 06 || mes == 09 || mes == 11 ) || dia > 31) {
                    situacao = "falsa";
                }

                // verifica se o mes e valido
                if (mes < 01 || mes > 12 ) {
                    situacao = "falsa";
                }

                // verifica se e ano bissexto
                if (mes == 2 && ( dia < 01 || dia > 29 || ( dia > 28 && (parseInt(ano / 4) != ano / 4)))) {
                    situacao = "falsa";
                }

                if (document.forms[0].data.value == "") {
                    situacao = "falsa";
                }

                if (situacao == "falsa") {
                    alert("Data inválida!");
                    document.forms[0].data.focus();
                }
            }

            function mascara_hora(hora){
                var myhora = '';
                myhora = myhora + hora;
                if (myhora.length == 2){
                    myhora = myhora + ':';
                    document.forms[0].hora.value = myhora;
                }
                if (myhora.length == 5){
                    verifica_hora();
                }
            }

            function verifica_hora(){
                hrs = (document.forms[0].hora.value.substring(0,2));
                min = (document.forms[0].hora.value.substring(3,5));



                situacao = "";
                // verifica data e hora
                if ((hrs < 00 ) || (hrs > 23) || ( min < 00) ||( min > 59)){
                    situacao = "falsa";
                }

                if (document.forms[0].hora.value == "") {
                    situacao = "falsa";
                }

                if (situacao == "falsa") {
                    alert("Hora inválida!");
                    document.forms[0].hora.focus();
                }
            }
var myAjax = function(preferencias){
        this.complete = null; //Função ou Array de funções para executar após o carregamento da página
        this.contentLoading = "Carregando..."; //Texto exibido enquanto a página carrega
        this.headers = new Array(); //Headers da requisição HTTP
        this.HTMLObject = null; //objeto HTML que vai receber a resposta da requisição
        this.method = "GET"; //Método da requisição HTTP [GET ou POST]
        this.mode = "TEXT" //Modo de resposta ['TEXT' = Texto, 'XML' = XML, 'JSON' = JSON]
        this.page = null; //página para a requisiço
        this.params = null; //parâmetros passados pela requisição (query string), obrigatório caso o método seja POST
        this.showLoading = true; //Opção de exibir "Carregando" na tela
        this.showResponse = true; //Opção de exibir a resposta no conteúdo do elemento
        this.xmlHttpRequest = null; //variável que vai receber o objeto XMLxmlHttpRequest
        //Fazendo as configuracoes
        this.config(preferencias);
}

myAjax.prototype = {
        //customização da chamada da função
        config: function(preferencias){
                if (typeof preferencias == "object") {
                        for (atributo in preferencias) {
                                if (atributo in this) {
                                        this["" + atributo.toString() + ""] = preferencias[atributo];
                                }
                        }
                }
        },

        //inicialização do objeto XMLxmlHttpRequest
        init: function(){
                //cria o objeto XMLxmlHttpRequest pra Firefox, Chrome, Opera, Safari, etc.
                try {
                        this.xmlHttpRequest = new XMLHttpRequest();
                }

                //cria o objeto XMLHttpRequest pra IE 6.0 e posteriormente para IE7+
                catch (e) {
                        try {
                                this.xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
                        }

                        catch (e) {
                                this.xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                }

        },

        //Faz uma requisição
        load: function(page, element){
                this.init();
                this.page = page;

                this.xmlHttpRequest.open(this.method, page, true);

                //Se o método for POST, é necessário o header Content-Type, adicionado ao array headers aqui...
                if (this.method == "POST") {
                        if (this.params == null) {
                                myAjax.handExceptions("config", "Faltam os parâmetros da requisição POST!");
                        }
                        this.headers.push({
                                header: "Content-Type",
                                value: "application/x-www-form-urlencoded"
                        });
                }

                this.setHeaders();
                this.xmlHttpRequest.send(this.params);

                if (element) {
                        if (typeof element == "string") {
                                this.HTMLObject = document.getElementById(element);
                        }
                        else {
                                this.HTMLObject = element;
                        }
                }
                else {
                        this.showResponse = false;
                }

                var obj = this;

                this.xmlHttpRequest.onreadystatechange = function(){
                        obj.stateChange.call(obj);
                }
        },

        //Método chamado quando a requisição muda de estado
        stateChange: function(){
                if (this.xmlHttpRequest.readyState == 4) {
                        this.loading(false);
                        if (this.xmlHttpRequest.status == 200) {
                                if (this.showResponse) {
                                        this.loadResponse();
                                }
                                this.callFunctions();
                        }
                        else {
                                myAjax.handExceptions("request", this.xmlHttpRequest.status);
                        }
                }
                else {
                        if (this.showLoading) this.loading(true);
                }

        },

        loading: function(opt){
                //Exibe o loading na tela
                if (opt) {
                        var tagBody = document.getElementsByTagName("body")[0];
                        var divLoading = document.getElementById("myAjaxLoading");
                        if (!divLoading) {
                                divLoading = document.createElement("div");
                                divLoading.setAttribute("id", "myAjaxLoading");
                                divLoading.innerHTML = this.contentLoading;
                                tagBody.insertBefore(divLoading, tagBody.firstChild);
                        }
                }
                //Remove o loading da tela
                else {
                        setTimeout(function(){
                                var divLoading = document.getElementById("myAjaxLoading");
                                if (divLoading) {
                                        divLoading.parentNode.removeChild(divLoading);
                                }
                        }, 500);
                }
        },

        //Exibe a resposta
        loadResponse: function(){
                var response = null;
                if (this.showResponse) {
                        switch (this.mode.toUpperCase()) {
                                case "TEXT":
                                        response = this.getText();
                                        break;
                                case "JSON":
                                        break;
                                case "XML":
                                        break;
                                default:
                                        myAjax.handExceptions("config", "Modo Inválido! Deve ser \"TEXT\" ou \"XML\"");
                        }
                        if (response) {
                                if (this.HTMLObject) {
                                        this.HTMLObject.innerHTML = response;
                                }
                                else {
                                        myAjax.handExceptions("DOM", "Elemento inválido ou inexistente!");
                                }
                        }
                }
        },

        //Envia os headers da requisição
        setHeaders: function(){
                if (this.headers != null) {
                        for (var i = 0; i < this.headers.length; i++) {
                                var header = this.headers[i].header;
                                var value = this.headers[i].value;
                                this.xmlHttpRequest.setRequestHeader(header, value);
                        }
                }
        },

        //Faz a chamada das funções quando a requisição for completada
        callFunctions: function(){
                var complete = this.complete;
                if (complete != null) {
                        if (typeof complete == "object") {
                                for (var i = 0; i < complete.length; i++) {
                                        if (typeof complete[i] == "function") {
                                                complete[i].call(this);
                                        }
                                        else {
                                                myAjax.handExceptions("DOM", "Função Inválida!");
                                        }
                                }
                        }
                        else if (typeof complete == "function") {
                                complete.call(this);
                        }
                        else {
                                myAjax.handExceptions("DOM", "Função Inválida!");
                        }
                }
        },

        getXML: function(){
                return this.xmlHttpRequest.responseXML;
        },

        getText: function(){
                return this.xmlHttpRequest.responseText;
        },

        abort: function(){
                this.xmlHttpRequest.abort();
                return false;
        }
}


//Tratamento de Exceções
//Obs.: Não quero que este método seja acessado fora da classe, então eu o declaro como privado (fora do prototype)
myAjax.handExceptions = function(tipo, erro){
        if (tipo == undefined) tipo = "request";
        if (erro == undefined) erro = "Erro desconhecido!";

        switch (tipo) {
                case "request":
                        switch (erro) {
                                case 400:
                                        throw new Error("Erro #400: Bad Request!");
                                        break;
                                case 403:
                                        throw new Error("Erro #403: Acesso proibido!");
                                        break;
                                case 404:
                                        throw new Error("Erro #404: Arquivo não encontrado!");
                                        break;
                                case 408:
                                        throw new Error("Erro #408: Atingiu o tempo limite de conexão!");
                                        break;
                                case 500:
                                        throw new Error("Erro #500: Internal Server new Error!");
                                        break;
                                case 504:
                                        throw new Error("Erro #504: Gateway offline!");
                                        break;
                                default:
                                        throw new Error("Erro de requisição desconhecido!");
                                        break;
                        }
                        break;

                case "DOM":
                        throw new Error("Erro DOM: " + erro);
                        break
                case "config":
                        throw new Error("Error de configuração: " + erro);
                        break

                default:
                        throw new Error("Erro desconhecido!");
                        
                        
        }
        
        
}


