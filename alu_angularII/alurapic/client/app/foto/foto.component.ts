import { Component, Input, ViewEncapsulation } from '@angular/core';

//Caso queira que o angular procure primeiro no diretorio onde está salvo o component utilizar o moduleId: module.id, desta forma não é preciso informar o caminho completo ./app/foto/foto.component.html
//O ViewEncapsulatioin define de que forma se deseja encapsular o style, se None ele não irá encapsular o style no componente, se Emulated (Padrão) irá encapsular o style para o componente apenas. O Native ainda não está bem implementado para todos os navegadores e pode apresentar problemas no projeto.
@Component({
    moduleId: module.id,
    selector: 'foto',
    templateUrl: './foto.component.html',
    styleUrls: ['./foto.component.css'],
    encapsulation: ViewEncapsulation.Emulated
})
export class FotoComponent {

    //O decorator @Input é responsável por sinalizar quais atributos serão recebidos a partir do elemento <foto url="..." titulo="..."></foto>
    @Input() titulo: string = '';
    @Input() url: string = '';
    descricao: string = '';
    _id: string;
}