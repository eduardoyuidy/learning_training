import { NegociacaoController } from './controllers/NegociacaoController';

const controller = new NegociacaoController();

//Uso de JQuery para sobreescrever o submit
$('.form').submit(controller.adiciona.bind(controller));

//Realizado o .bind para manter a referência do this
/*document
    .querySelector('.form')
    .addEventListener('submit', controller.adiciona.bind(controller)); */

$('#botao-importar').click(controller.importaDados.bind(controller));

//Teste busca Tickets zendesk
//$('#botao-zendesk').click(controller.buscaZendesk).bind(controller);