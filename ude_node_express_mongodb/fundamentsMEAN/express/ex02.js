const express = require('express');
const server = express();

const PORT = 3000;

server.get('/', function(req, res, next) {
    console.log('Inicio...');
    next();
    console.log('Fim...');
});

server.all('/', function(req, res, next) {
    console.log('All http verbs');
    next();
});

server.get('/', function(req, res) {
    console.log('Resposta');
    res.send('<h1>Olá Express!</h1>');
})

server.listen(PORT, () => {
    console.log(`Listening on port ${PORT}`);
});
