const express = require('express');
const server = express();

const PORT = 3000;

server.use('/api', function(req, res, next){
    console.log('Inicio...');
    next();
    console.log('Fim...');
});

server.use('/api', function(req, res) {
    console.log('Resposta...');
    res.send('<h1>API !</h1>')
});

server.listen(PORT, () => {
    console.log(`Listening on port ${PORT}`);
});
