const fs = require('fs');
const [N, M] = (process.platform === 'linux' ? fs.readFileSync('/dev/stdin').toString().trim() : `3 3`)
  .split(' ')
  .map(BigInt);

console.log(BigInt((N * M) / BigInt(2)).toString());
