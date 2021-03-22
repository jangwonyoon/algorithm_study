
**중첩 해시로 다시 풀어보기**

```js
function solution(table, languages, preference) {
    let result = [];
    let arr = [];
    for(let el of table) {
        arr.push(el.split(' '));
    }
    let si = 0;
    let contents = 0;
    let hardware = 0;
    let portal = 0;
    let game = 0;
    
    arr[0].map((el,index)=>{
        for(let i=0; i<languages.length; i++){
            if(el === languages[i]){
                let point = 6 - index;
                si += preference[i] * point;
            }
        }
    })
    
    arr[1].map((el,index)=>{
        for(let i=0; i<languages.length; i++){
            if(el === languages[i]){
                let point = 6 - index;
                contents += preference[i] * point;
            }
        }
    })
    arr[2].map((el,index)=>{
        for(let i=0; i<languages.length; i++){
            if(el === languages[i]){
                let point = 6 - index;
                hardware += preference[i] * point;
            }
        }
    })
    arr[3].map((el,index)=>{
        for(let i=0; i<languages.length; i++){
            if(el === languages[i]){
                let point = 6 - index;
                portal += preference[i] * point;
            }
        }
    })
    arr[4].map((el,index)=>{
        for(let i=0; i<languages.length; i++){
            if(el === languages[i]){
                let point = 6 - index;
                game += preference[i] * point;
            }
        }
    })
    let tableArr =['SI','CONTENTS','HARDWARE','PORTAL','GAME'];
    let returnArr = [];
    
    result.push(si,contents,hardware,portal,game);
    
    for(let i=0; i<result.length; i++) {
        let max = Math.max(...result);
        if(max === result[i]) {
            returnArr.push(tableArr[i]);
        }
    }
    returnArr.sort();
    return returnArr[0]
}

let table = ['SI JAVA JAVASCRIPT SQL PYTHON C#','CONTENTS JAVASCRIPT JAVA PYTHON SQL C++','HARDWARE C++ PYTHON JAVA JAVASCRIPT','PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP','GAME C++ C# JAVASCRIPT C JAVA']

solution(table,["PYTHON", "C++", "SQL"],[7, 5, 5])
```