import { Negociacao } from './Negociacao';
import { MeuObjeto } from './MeuObjeto';
import { logarTempoDeExecucao } from '../helpers/decorators/index';

export class Negociacoes implements MeuObjeto<Negociacoes> {

    //private _negociacoes: Array<Negociacao> = [];
    private _negociacoes: Negociacao[] = []; // 2 formas de definição de Array de Negociacoes
    
    adiciona (negociacao: Negociacao): void {

        this._negociacoes.push(negociacao);
    }

    //Tipagem do retorno do método paraArray
    paraArray(): Negociacao[] {

        //Programação defensiva para impedir a mudança fora da classe
        return ([] as Negociacao[]).concat(this._negociacoes);
        //return this._negociacoes;
    }

    paraTexto(): void {
        console.log(JSON.stringify(this._negociacoes));
    }

    ehIgual(negociacoes: Negociacoes): boolean {

        return JSON.stringify(this._negociacoes) == JSON.stringify(negociacoes.paraTexto());
    }
} 