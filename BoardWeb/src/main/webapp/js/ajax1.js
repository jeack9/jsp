/**
 * ajax1.js
 */

let xhtp = new XMLHttpRequest();
xhtp.open("get", "data/MOCK_DATA.json");
xhtp.send();
xhtp.onload = () => {
    let data = JSON.parse(xhtp.responseText);
    console.log(data);
    data.forEach(empObj => {
        document.querySelector("#list").appendChild(makeRow(empObj));
    });
}
let fields = ["id", "first_name", "email", "gender"];
function makeRow(obj = {id, first_name, email, gender}){
    let tr = document.createElement("tr");
    fields.forEach(field =>{
        let td = document.createElement("td");
        td.innerHTML = obj[field];
        tr.appendChild(td);
    });
    return tr;
}

let xhtm = new XMLHttpRequest();
xhtm.open("get", "loginForm.do");
xhtm.send();
xhtm.onload = () => {
    // console.log(xhtm);
    // document.querySelector("#show").innerHTML = xhtm.responseText;
}

console.log("end");