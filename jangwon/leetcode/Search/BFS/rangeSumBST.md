```js
var rangeSumBST = function(root, L, R) {
    let sum =0;
    if(!root) return sum;
    if(root.val > L) {
        sum += rangeSumBST(root.left,L,R);
    }
    if(root.val >= L && root.val <= R){
        sum += root.val;
    }
    if(root.val < R){
        sum += rangeSumBST(root.right,L,R);
    }
    
    return sum;
};
```