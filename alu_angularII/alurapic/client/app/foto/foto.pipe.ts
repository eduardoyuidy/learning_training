import { Pipe, PipeTransform }  from '@angular/core';

import { FotoComponent } from './foto.component';

@Pipe({
    name: 'filtroPorTitulo'
})
export class filtroPorTitulo implements PipeTransform {

    //1-O nome deste método tem que ser 'transform' caso não for é apresentado erro, quando utilizado uma interface
    //  a interface é uma espécie de contrato que assinamos onde devemos manter um padrão para a interface
    //2-O ': any' após os parâmetros do método indicam qual o tipo do retorno do método.
    transform(fotos: FotoComponent[], digitado: string): FotoComponent[] {

        digitado = digitado.toLowerCase();

        return fotos.filter(foto => {
            return foto.titulo.toLowerCase().includes(digitado)
        });
    }
}
