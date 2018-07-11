import { Component, Input, OnInit, ViewEncapsulation, ElementRef } from '@angular/core';

//O ViewEncapsulatioin define de que forma se deseja encapsular o style, se None ele não irá encapsular o style no componente, se Emulated (Padrão) irá encapsular o style para o componente apenas. O Native ainda não está bem implementado para todos os navegadores e pode apresentar problemas no projeto.
@Component({
    moduleId: module.id,
    selector: 'painel',
    templateUrl: './painel.component.html',
    styleUrls: ['./painel.component.css'],
    encapsulation: ViewEncapsulation.Emulated
})
export class PainelComponent implements OnInit {

    //Inbound property
    @Input() titulo: string;
    //Um elemento do tipo ElementRef encapsula o elemento do DOM do nosso componente na propriedade nativeElement.
    private elemento: ElementRef;

    constructor(elemento: ElementRef) {
        this.elemento = elemento;
    }
    
    //Este método é executado após o componente ter sido renderizado em tela e também após a execução do construtor. 
    ngOnInit() {        
        this.titulo = 
            this.titulo.length > 7 
            ? `${this.titulo.substr(0,7)}...` 
            : this.titulo;
    }

    //Para que o Typescript reconheça o jQuery para compilação é necessário utilizar o Typings e instalar o jquery. (para instalação foi usado: node ./node_modules/typings/dist/bin install dt~jquery --global --save)
    //cb = Call Back
    fadeOut(cb) {
        $(this.elemento.nativeElement).fadeOut(cb);
    }
}