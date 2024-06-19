/**
 * func1.js
 */

function sum(a = 0, b = 0){
    return a + b;
}

//함수표현식
sum = function sum(a = 0, b = 0){
    return a + b;
}

let result = sum(10, 20);
result = sum(10);
console.log("결과: ", result);

let name = "홍길동";
let age = 20;
const OBJ =  {
    name,
    age
}

function showObj(obj = {name : "홍길", age: 25}){
    return obj.name + " - " + obj.age;
}
console.log(showObj(OBJ));

function sumAry(ary = []){
    let sum = 0;
    for(let i = 0; i < ary.length; i++){
        sum += ary[i];
    }
    return sum;
}

result = sumAry([1, 2, 3, 4, 5]);
console.log("결과: ", result);

function showItem(item){
    let days = ["Sun", "Mon", "Tue", "Wed", "Fri", "Sat"];
    days.forEach(function(val){
        let span = document.createElement("span");
        span.innerHTML = val + " ";
        item.appendChild(span);
    });
}

showItem(document.querySelector("#show"));