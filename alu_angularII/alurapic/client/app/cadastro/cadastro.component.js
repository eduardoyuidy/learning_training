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
var forms_1 = require('@angular/forms');
var router_1 = require('@angular/router');
var foto_component_1 = require('./../foto/foto.component');
var foto_service_1 = require('./../foto/foto.service');
var CadastroComponent = (function () {
    function CadastroComponent(service, fb, route, router) {
        var _this = this;
        this.foto = new foto_component_1.FotoComponent();
        this.mensagem = '';
        this.service = service;
        //Utilizando o ActivatedRoute buscamos o parâmetro desejado dentro da URL
        this.route = route;
        this.router = router;
        this.route.params.subscribe(function (params) {
            var id = params['id'];
            if (id) {
                _this.service
                    .buscaPorId(id)
                    .subscribe(function (foto) {
                    _this.foto = foto;
                }, function (erro) {
                    console.log(erro);
                });
            }
        });
        this.meuForm = fb.group({
            titulo: ['', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(4)])],
            url: ['', forms_1.Validators.required],
            descricao: []
        });
    }
    CadastroComponent.prototype.cadastrar = function (event) {
        var _this = this;
        event.preventDefault();
        //usar servico
        this.service
            .cadastrar(this.foto)
            .subscribe(function (res) {
            console.log('Foto foi cadastrada com sucesso!');
            _this.mensagem = res.mensagem;
            _this.foto = new foto_component_1.FotoComponent();
            if (!res.inclusao) {
                //O Router é responsável por abrir novamente a página default do projeto ''
                _this.router.navigate(['']);
            }
        }, function (erro) {
            console.log('Erro ao salvar foto: ', erro);
        });
    };
    CadastroComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'cadastro',
            templateUrl: './cadastro.component.html'
        }), 
        __metadata('design:paramtypes', [foto_service_1.FotoService, forms_1.FormBuilder, router_1.ActivatedRoute, router_1.Router])
    ], CadastroComponent);
    return CadastroComponent;
}());
exports.CadastroComponent = CadastroComponent;
//# sourceMappingURL=cadastro.component.js.map