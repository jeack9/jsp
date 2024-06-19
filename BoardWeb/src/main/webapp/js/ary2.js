/*
 * ary2.js
 */

let result2 = [23, 45, 22, 39, 56].filter((item, idx, ary) => {
    if(item % 2 == 0) return item;
});
console.log(result2);
// EMPLOYEES.forEach(console.log);

// 급여가 5000이 넘는 여자만 필터링,
let over5000 =[];
let over5000Sum = 0;
EMPLOYEES.filter((item) =>{
    return item.gender == "Female" && item.salary > 5000;
});
// console.log(over5000);

EMPLOYEES.filter(emp => emp.gender == "Female" && emp.salary > 4000).forEach(emp => over5000Sum += emp.salary);
console.log(over5000Sum);

// map
EMPLOYEES.map((ele, idx, ary) => {
    const OBJ = {};
    OBJ.name = ele.first_name + " - " + ele.last_name;
    OBJ.salary = ele.salary;
    return OBJ;
}).forEach(console.log);


// reduce
sum = [10, 20, 30, 40, 50].reduce((acc, ele, idx, ary) => {
    console.log(acc, ele);
    if(ele > 25) acc.push(ele);
    return acc;
}, []);

sum = [70, 20, 30, 40, 100].reduce((acc, ele) =>{
    if(acc < ele) return ele;
    else return acc;
}, Number.MIN_VALUE);
console.log(sum);

["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"].reduce((acc, ele) =>{
    let li = document.createElement("li");
    acc.appendChild(li);
    li.innerHTML = ele;
    return acc;
}, document.querySelector("#fruit"));


// obj1.js
let obj = {
    data: "",
    fields: ["id", "first_name", "email", "salary"],
    showList: function(ary = []){
        ary.forEach((emp, idx) => {
            if(idx < 3){
                let tr = this.makeRow(emp);
                document.querySelector("#list").appendChild(tr);
            }
        });
    },
    makeRow(emp = {id, first_name, email, salary}){
        let tr = document.createElement("tr");
        this.fields.forEach(field => {
            let td = document.createElement("td");
            td.innerText = emp[field]; // 객체.필드로 접근할 때 변수사용 불가 => 객체["필드명"] 방식으로 필드값 변수 이용
            tr.appendChild(td);
        });
        return tr;
    }
}
obj.showList(EMPLOYEES);

//등록이벤트
document.querySelector("#empAddBtn").addEventListener("click", function(){
    let id = document.querySelector("#empNo").value;
    let first_name = document.querySelector("#empName").value;
    let email = document.querySelector("#empEmail").value;
    let salary = document.querySelector("#empSalary").value;
    // employee 한명 추가
    document.querySelector("#list").appendChild(obj.makeRow({id, first_name, email, salary}));
});