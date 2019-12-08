const fs = require('fs');
const files = fs.readdirSync(__dirname, { withFileTypes : false});

files.forEach((item) => console.log(item));
 