export function throttle(milissegundos = 500) {

    return function(target: any, propertyKey: string, descriptor: PropertyDescriptor) {

        const metodoOriginal = descriptor.value;

        let timer = 0;

        descriptor.value = function(...args: any[]) {

            if (event) event.preventDefault();

            //Caso seja efetuado muitos cliques o clearInterval limpará o timer anterior e dessa forma cancelará o pedido anterior.
            clearInterval(timer);
            timer = <any>setTimeout(() => metodoOriginal.apply(this, args), milissegundos);
        }

        return descriptor;
    }
}