"use strict";
var router_1 = require('@angular/router');
var cadastro_component_1 = require('./cadastro/cadastro.component');
var listagem_component_1 = require('./listagem/listagem.component');
//Nas Rotas, quando definido ** significa que irá executar quando nenhuma outra rota foi informada (no caso '/' ou '/cadastro')
//Criada rota para cadastro/:id para receber um parâmetro pela url para edição de uma foto já existente.
var appRoutes = [
    { path: '', component: listagem_component_1.ListagemComponent },
    { path: 'cadastro', component: cadastro_component_1.CadastroComponent },
    { path: 'cadastro/:id', component: cadastro_component_1.CadastroComponent },
    { path: '**', component: listagem_component_1.ListagemComponent }
];
//Aqui é exportado as configurações de rotas definidas.
exports.routing = router_1.RouterModule.forRoot(appRoutes);
//# sourceMappingURL=app.routes.js.map