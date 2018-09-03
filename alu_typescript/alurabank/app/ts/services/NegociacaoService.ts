import { Negociacao, NegociacaoParcial } from '../models/index';

export class NegociacaoService {

    obterNegociacoes(handler: HandlerFunction): Promise<Negociacao[]> {

        //fetch api para realizar requisições http, forma mais atual que o xhr
        return fetch('http://localhost:8080/dados')
            .then(res => handler(res))
            .then(res => res.json())
            .then((dados: NegociacaoParcial[]) => 
                dados
                    .map(dado => new Negociacao(new Date(), dado.vezes, dado.montante))
            )
            .catch(err => {
                console.log(err);
                throw new Error ("Não foi possível importar as negociações.");
            });
    }
}

export interface HandlerFunction{

    //Esta implementação indica que a função passada deve enviar um parâmetro do tipo Response e devolver um Response
    (res: Response): Response
}