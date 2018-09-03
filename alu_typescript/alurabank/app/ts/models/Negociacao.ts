import { MeuObjeto } from '../models/MeuObjeto';

export class Negociacao implements MeuObjeto<Negociacao> {

    //Utilizando o modificador de acesso readonly torna as variáveis acessíveis apenas para leitura e não existe mais a necessidade de definição dos getters.
    constructor(
        readonly data: Date, 
        readonly quantidade: number, 
        readonly valor: number) { }

    /****
    get data() {
        return this._data;
    }
    get quantidade() {
        return this._quantidade;
    }
    get valor() {
        return this._valor;
    }****/

    get volume() {

        return this.quantidade * this.valor;
    }

    paraTexto(): void {

        console.log(
            `Data: ${this.data}
            Quantidade: ${this.quantidade}
            Valor: ${this.valor}
            Volume: ${this.volume}
            `
        );
    }

    ehIgual(negociacao: Negociacao): boolean {

        return this.data.getDate() == negociacao.data.getDate()
            && this.data.getMonth() == negociacao.data.getMonth()
            && this.data.getFullYear() == negociacao.data.getFullYear();
    }
}
