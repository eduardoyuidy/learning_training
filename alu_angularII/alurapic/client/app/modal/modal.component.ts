import { Component, ElementRef, Input, Output, EventEmitter, AfterViewInit } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'modal',
    templateUrl: './modal.component.html'
})
export class ModalComponent implements AfterViewInit { 

    private _element: ElementRef;

    @Input() private titulo: string = 'Tem certeza?';
    @Input() private frase: string;
    @Output() confirma = new EventEmitter();

    constructor(elemento: ElementRef){

        this._element = elemento;
    }

    ngAfterViewInit() {

        $(this._element.nativeElement).dialog({
            title: this.titulo,
            autoOpen: false,
            resizable: false,
            modal: true,
            buttons: {
                Cancelar: ()=> {
                    $(this._element.nativeElement).dialog( "close" );
                },
                Confirmar: ()=> {
                    $(this._element.nativeElement).dialog( "close" );
                    this.confirma.emit(null);
                }
            }
        });
    }

    show() {

        //quando chamado, exibirá o modal!
        $(this._element.nativeElement).dialog("open");
    }
}