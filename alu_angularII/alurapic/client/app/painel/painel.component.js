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
//O ViewEncapsulatioin define de que forma se deseja encapsular o style, se None ele não irá encapsular o style no componente, se Emulated (Padrão) irá encapsular o style para o componente apenas. O Native ainda não está bem implementado para todos os navegadores e pode apresentar problemas no projeto.
var PainelComponent = (function () {
    function PainelComponent(elemento) {
        this.elemento = elemento;
    }
    //Este método é executado após o componente ter sido renderizado em tela e também após a execução do construtor. 
    PainelComponent.prototype.ngOnInit = function () {
        this.titulo =
            this.titulo.length > 7
                ? this.titulo.substr(0, 7) + "..."
                : this.titulo;
    };
    //Para que o Typescript reconheça o jQuery para compilação é necessário utilizar o Typings e instalar o jquery. (para instalação foi usado: node ./node_modules/typings/dist/bin install dt~jquery --global --save)
    //cb = Call Back
    PainelComponent.prototype.fadeOut = function (cb) {
        $(this.elemento.nativeElement).fadeOut(cb);
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], PainelComponent.prototype, "titulo", void 0);
    PainelComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'painel',
            templateUrl: './painel.component.html',
            styleUrls: ['./painel.component.css'],
            encapsulation: core_1.ViewEncapsulation.Emulated
        }), 
        __metadata('design:paramtypes', [core_1.ElementRef])
    ], PainelComponent);
    return PainelComponent;
}());
exports.PainelComponent = PainelComponent;
//# sourceMappingURL=painel.component.js.map