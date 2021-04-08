# BFS,DFS

## leetcode 872. Leaf-Similar Trees (Easy)

### https://leetcode.com/problems/leaf-similar-trees/

* 문제 풀이 

1. leaf를 구하는 함수를 작성
2. leaf를 배열에 담아 서로 비교 
3. 이때 배열이 완전히 같아야하 하므로 길이를 확인하고 , 배열의 요소를 반복문 하나로 순회화며 확인 
4. 불린 값을 리턴 

```js
var leafSimilar = function(root1, root2) {
    let result = true;
    let r1 = [];
    let r2 = [];
    getLeaf(root1,r1);
    getLeaf(root2,r2);
    
    if(r1.length !== r2.length) return false;
    for(let i=0; i<r1.length; i++) {
        if(r1[i] !== r2[i]) return false;
    }
    
    return result;
};

const getLeaf = (node,leaf) => {
    if(!node.left && !node.right)  {
        leaf.push(node.val);
    }else{
        if(node.left){
            getLeaf(node.left,leaf);
        }
        if(node.right){
            getLeaf(node.right,leaf);
        }
    }
}
```