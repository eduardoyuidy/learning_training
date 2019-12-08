console.log('Global? ',global === this);
console.log('Module?', module === this);
console.log('Module-Exports?',module.exports === this);

this.digaOi = () => {
    console.log('Oi !!!');
}
