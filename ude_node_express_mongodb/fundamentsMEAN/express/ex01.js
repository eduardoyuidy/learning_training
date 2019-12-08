const express = require('express');
const server = express();

const PORT = 3000;

server.get('/', (req, res, next) => {
    res.send('<h1>Index!</h1>');
});

server.all('/teste', (req, res) => {
    res.send('<h1>Teste</h1>');
});

server.get(/api/, (req, res) => {
    console.log(req);
    res.send('<h1>API!</h1>');
});

server.listen(PORT, () => {
    console.log(`Listening on port ${PORT}`);
});
