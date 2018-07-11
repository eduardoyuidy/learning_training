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
//Caso queira que o angular procure primeiro no diretorio onde está salvo o component utilizar o moduleId: module.id, desta forma não é preciso informar o caminho completo ./app/foto/foto.component.html
//O ViewEncapsulatioin define de que forma se deseja encapsular o style, se None ele não irá encapsular o style no componente, se Emulated (Padrão) irá encapsular o style para o componente apenas. O Native ainda não está bem implementado para todos os navegadores e pode apresentar problemas no projeto.
var FotoComponent = (function () {
    function FotoComponent() {
        //O decorator @Input é responsável por sinalizar quais atributos serão recebidos a partir do elemento <foto url="..." titulo="..."></foto>
        this.titulo = '';
        this.url = '';
        this.descricao = '';
    }
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], FotoComponent.prototype, "titulo", void 0);
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], FotoComponent.prototype, "url", void 0);
    FotoComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'foto',
            templateUrl: './foto.component.html',
            styleUrls: ['./foto.component.css'],
            encapsulation: core_1.ViewEncapsulation.Emulated
        }), 
        __metadata('design:paramtypes', [])
    ], FotoComponent);
    return FotoComponent;
}());
exports.FotoComponent = FotoComponent;
//# sourceMappingURL=foto.component.js.map