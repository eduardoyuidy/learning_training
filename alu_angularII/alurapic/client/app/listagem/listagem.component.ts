import { Component } from '@angular/core';

import { FotoComponent } from '../foto/foto.component';
import { PainelComponent } from './../painel/painel.component';
import { FotoService } from '../foto/foto.service';

@Component({
    moduleId: module.id,
    selector: 'listagem',
    templateUrl: './listagem.component.html'
})
export class ListagemComponent {

    //fotos : Array<Object> = [];
    fotos: FotoComponent[] = [];
    service: FotoService;
    mensagem: string = '';

    //Quando usado a tipagem : Http o Angular automaticamente já injeta a dependência do Http
    constructor(service: FotoService) {
        
        this.service = service;
                
        //listando fotos com servico
        this.service
            .lista()
            .subscribe(fotos => {
                this.fotos = fotos;
            }, erro => {
                console.log('Erro ao executar o método lista: ', erro);
            })
    }

    remove(foto: FotoComponent, painel: PainelComponent): void {

        this.service
            .remover(foto)
            .subscribe(() => {

                painel.fadeOut(() => {
                    //O Angular só monitora a referência de this.fotos do nosso componente. Se um item for adicionado ou removido da lista o angular não saberá e por isto não atualizará a View, para que isto ocorra é necessário mudar a referência da lista. Para isto criamos uma nova lista e atribuimos para this.fotos. 
                    let novasFotos = this.fotos.slice(0);
                    let indice = novasFotos.indexOf(foto);
                    novasFotos.splice(indice, 1);
                    this.fotos = novasFotos;
                    console.log('Foto removida com sucesso!');
                    this.mensagem = 'Foto foi removida com sucesso!';
                });
            }, erro => {
                console.log('Erro ao deletar foto: ', erro);
                this.mensagem = 'Não foi possível remover a foto';
            });
    }
}