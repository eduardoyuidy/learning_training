import { Component } from '@angular/core';
import { Http } from '@angular/http';

//Caso queira que o angular procure primeiro no diretorio onde está salvo o component utilizar o moduleId: module.id, desta forma não é preciso informar o caminho completo ./app/app.component.html
@Component({
    moduleId: module.id,
    selector: 'app',
    templateUrl: './app.component.html'
})
export class AppComponent { } 