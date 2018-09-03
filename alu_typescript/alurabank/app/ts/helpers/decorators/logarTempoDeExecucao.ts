export function logarTempoDeExecucao(emSegudos: boolean = false) {

    //Exemplo de decorator de métodos

    //O primeiro parâmetro target é aquele que possui a referência ao elemento cujo método foi decorado.
    //O segundo parâmetro propertyKey é uma string que nos retorna o nome do método decorado.
    //O terceiro parâmetro descriptor é quem dará acesso ao método que desejamos modificar em sua execução.
    return function(
        target: any, 
        propertyKey: string, 
        descriptor: PropertyDescriptor) {

        const metodoOriginal = descriptor.value; 

        // Os ... (três pontos passados no parâmetro) simboliza o REST PARAMETER que garante que todos os parâmetros enviados serão recebidos, independente se forem 1 ou mais parâmetros.
        descriptor.value = function(...args: any[]) {

            let unidade = 'ms';
            let divisor = 1;
            if (emSegudos) {
                unidade = 's';
                divisor = 1000;
            }

            console.log('--------------------');
            console.log(`Parâmetros passado para o método ${propertyKey}: ${JSON.stringify(args)}`);
            const t1 = performance.now();
            const retorno = metodoOriginal.apply(this, args);
            const t2 = performance.now();
            console.log(`O retorno do método ${propertyKey} : ${JSON.stringify(retorno)}`);
            console.log(`O método ${propertyKey} demorou ${(t2 - t1)/divisor} ${unidade}`);
            return retorno;
        }

        return descriptor;
    }
}