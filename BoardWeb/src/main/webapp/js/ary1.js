/**
 *  ary1.js
 */

const NUMARY = [23, 17, 6, 41, 30, 12];
let result = 0;

NUMARY.forEach((ele, idx, ary) => {
    console.log(ele, idx, ary);
});


// 35보다 작은 값들의 합을 저장.
let less35 = function(ele){
    result = 0;
    if(ele < 35) result += ele;
}
console.log(NUMARY.forEach(less35));

const DUPARY = [10, 27, 32, 55, 27, 10];
const ARY = []; // indexOf()

// 중복 값 제거 후 ARY에 등록
DUPARY.forEach((ele) => {
    if(ARY.indexOf(ele) == -1) ARY.push(ele);
});