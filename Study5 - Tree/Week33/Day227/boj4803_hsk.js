const fs = require('fs');
const stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString().trim()
    : `6 3
1 2
2 3
3 4
6 5
1 2
2 3
3 4
4 5
5 6
6 6
1 2
2 3
1 3
4 5
5 6
6 4
0 0`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const getIsTreeOrNot = (node, tree, visitedNodeList) => {
  let isTree = true;
  const stackNodeList = [node];

  while (stackNodeList.length) {
    const node = stackNodeList.pop();

    if (visitedNodeList[node]) isTree = false;
    visitedNodeList[node] = true;

    for (let nextNode of tree[node]) {
      if (visitedNodeList[nextNode]) continue;

      stackNodeList.push(nextNode);
    }
  }

  return isTree;
};

let caseCnt = 0;
while (true) {
  caseCnt += 1;

  const [N, M] = input().split(' ').map(Number);
  const tree = Array.from(new Array(N + 1), () => new Array());
  const visitedNodeList = new Array(N + 1).fill(false);

  if (N === 0 && M === 0) break;

  for (let i = 0; i < M; i++) {
    const [nodeA, nodeB] = input().split(' ').map(Number);

    tree[nodeA].push(nodeB);
    tree[nodeB].push(nodeA);
  }

  let treeCnt = 0;
  for (let i = 1; i <= N; i++) {
    if (visitedNodeList[i]) continue;
    if (getIsTreeOrNot(i, tree, visitedNodeList)) treeCnt += 1;
  }

  if (treeCnt === 0) console.log(`Case ${caseCnt}: No trees.`);
  else if (treeCnt === 1) console.log(`Case ${caseCnt}: There is one tree.`);
  else console.log(`Case ${caseCnt}: A forest of ${treeCnt} trees.`);
}
