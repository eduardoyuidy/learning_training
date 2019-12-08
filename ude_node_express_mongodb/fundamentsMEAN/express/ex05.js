const express = require('express');
const server = express();
const router = require('./ex05_routes');

const PORT = 3000;

server.use('/api', router);

server.listen(PORT, () => {
    console.log(`Listening on port ${PORT}`);
});
