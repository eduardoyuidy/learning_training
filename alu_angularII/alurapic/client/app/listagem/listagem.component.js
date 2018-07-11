"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var foto_service_1 = require('../foto/foto.service');
var ListagemComponent = (function () {
    //Quando usado a tipagem : Http o Angular automaticamente já injeta a dependência do Http
    function ListagemComponent(service) {
        var _this = this;
        //fotos : Array<Object> = [];
        this.fotos = [];
        this.mensagem = '';
        this.service = service;
        //listando fotos com servico
        this.service
            .lista()
            .subscribe(function (fotos) {
            _this.fotos = fotos;
        }, function (erro) {
            console.log('Erro ao executar o método lista: ', erro);
        });
    }
    ListagemComponent.prototype.remove = function (foto, painel) {
        var _this = this;
        this.service
            .remover(foto)
            .subscribe(function () {
            painel.fadeOut(function () {
                //O Angular só monitora a referência de this.fotos do nosso componente. Se um item for adicionado ou removido da lista o angular não saberá e por isto não atualizará a View, para que isto ocorra é necessário mudar a referência da lista. Para isto criamos uma nova lista e atribuimos para this.fotos. 
                var novasFotos = _this.fotos.slice(0);
                var indice = novasFotos.indexOf(foto);
                novasFotos.splice(indice, 1);
                _this.fotos = novasFotos;
                console.log('Foto removida com sucesso!');
                _this.mensagem = 'Foto foi removida com sucesso!';
            });
        }, function (erro) {
            console.log('Erro ao deletar foto: ', erro);
            _this.mensagem = 'Não foi possível remover a foto';
        });
    };
    ListagemComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'listagem',
            templateUrl: './listagem.component.html'
        }), 
        __metadata('design:paramtypes', [foto_service_1.FotoService])
    ], ListagemComponent);
    return ListagemComponent;
}());
exports.ListagemComponent = ListagemComponent;
//# sourceMappingURL=listagem.component.js.map