import { logarTempoDeExecucao } from '../helpers/decorators/logarTempoDeExecucao';

//Definido a variável $ para calar o compilador do typescript. 
//declare var $: any;

export abstract class View<T> {
    //Com o uso de abstract indicará ao desenvolvedor que a classe não pode ser instanciada, visto que existe uma lacuna na classe que deve ser implmentada através das classes que herdarem desta classe Pai.
    //Lançado mão do recurso Generics para receber das classes filhas o tipo a ser utilizado para os métodos update e template.
    
    //Controle de acesso flexibilizado com o Modificador protected indica que apenas os métodos da própria classe podem acessar as propriedades, ou os elementos filhos que herdarem da classe.
    //Após o uso do generics Types conseguimos trazer os métodos de update que utilizam a property _elemento para dentro da classe pai, desta forma não precisamos mais utilizar o modificador de acesso protected, voltamos para private.
    private _elemento: JQuery;
    private _escapar: boolean;

    //Quando na passagem de parâmetros para um método ou construtor caso algum parâmetro seja opcional colocar um '?' após o nome da propriedade. Os parâmetros opcionais devem ser sempre os últimos a serem definidos. Exemplo: constructor(seletor: string, escapar?: boolean)
    constructor(
        seletor: string,
        escapar: boolean = false) {
        // Quando definido na passagem de parâmetros um parâmetro e logo após colocado = valor, o valor é assumido este caso não seja definido um parâmetro. Exemplo: escapar: boolean = false

        this._elemento = $(seletor);
        this._escapar = escapar;
    }

    //Decorator sendo utilizado para dentro de uma função de helper facilitar a identificação de lentidão na execução dos métodos.
    @logarTempoDeExecucao(true)
    update(model: T): void {

        let template = this.template(model);

        //Código para remover tags <script> do template, evitando que código maliciosos sejam executados.
        if(this._escapar) {            
            template = template.replace(/<script>[\s\S]*?<\/script>/g,'');
        }

        this._elemento.html(template);
    }

    //Método abstrato que deve ser implementado nas classes filhas, caso contrário é apresentado erro de compilação. Isto garante que o erro de falta de implementação deste método só seja percebido durante a execução.
    abstract template(model: T): string;
}