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
var filtroPorTitulo = (function () {
    function filtroPorTitulo() {
    }
    //1-O nome deste método tem que ser 'transform' caso não for é apresentado erro, quando utilizado uma interface
    //  a interface é uma espécie de contrato que assinamos onde devemos manter um padrão para a interface
    //2-O ': any' após os parâmetros do método indicam qual o tipo do retorno do método.
    filtroPorTitulo.prototype.transform = function (fotos, digitado) {
        digitado = digitado.toLowerCase();
        return fotos.filter(function (foto) {
            return foto.titulo.toLowerCase().includes(digitado);
        });
    };
    filtroPorTitulo = __decorate([
        core_1.Pipe({
            name: 'filtroPorTitulo'
        }), 
        __metadata('design:paramtypes', [])
    ], filtroPorTitulo);
    return filtroPorTitulo;
}());
exports.filtroPorTitulo = filtroPorTitulo;
//# sourceMappingURL=foto.pipe.js.map