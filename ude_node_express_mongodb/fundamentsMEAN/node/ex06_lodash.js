const _ = require('lodash');

const alunos = [{
    name: 'João',
    nota: 7.6
}, {
    name: 'Maria', 
    nota: 8.6
}, {
    name: 'Pedro', 
    nota: 8.1
}];

const media = _.sumBy(alunos, 'nota') / alunos.length;
console.log('Média:',media);
