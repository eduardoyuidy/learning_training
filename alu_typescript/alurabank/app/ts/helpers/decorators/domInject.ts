export function domInject(seletor: string) {

    //Exemplo de decorator de injeção de dependência

    //Decorator criado para realizar lazy loading, desta forma o elemento só será buscado do DOM em seu primeiro uso e não será carregado sem necessidade.

    return function(target: any, key: string) {

        let elemento: JQuery;

        const getter = function() {

            if (!elemento){
                console.log(`Buscando ${seletor} para injetar em ${key}`);
                
                elemento = $(seletor);
            }

            return elemento;
        }

        Object.defineProperty(target, key, {
            get: getter
        })
    }
}