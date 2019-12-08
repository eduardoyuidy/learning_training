console.log(process.argv);
// console.log(process);

function temParam (param) {
    return process.argv.indexOf(param) !== -1;
}

if (temParam('--producao')) {
    console.log('### Ambiente de Produção ####');
} else {
    console.log('### Ambiente de Homologação ####');
}