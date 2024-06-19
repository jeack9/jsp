/**
 * calendar.js
 */
// document.querySelectorAll(".container-fluid h3").forEach(item => item.remove());
// document.querySelectorAll(".container-fluid table.table").forEach(item => item.remove());
// document.querySelectorAll("#fruit").forEach(item => item.remove());

//달력을 첫째날 계산하는 함수, 마지막날 계산 함수
function getFirstDay(month = 6){
    switch(month){
        case 5: return 4;
        case 7: return 2;
    }
    return 7;
}

function getLastDate(month){
    switch(month){
        case 5:
        case 7:
            return 31;
    }
    return 30;
}

function makeCalendar(month){
    let firstDay = getFirstDay(month);
    let lastDay = getLastDate(month);
    
    document.querySelector("#show").innerHTML = "";

    // table 생성. border="2"
    let tbl = document.createElement("table");
    tbl.setAttribute("class", "table");
    let thd = document.createElement('thead');
    let tbd = document.createElement("tbody");

    // thead 하위요소.
    let days = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    let tr = document.createElement("tr");
    days.forEach(day => {
        let th = document.createElement("th");
        th.innerHTML = day;
        tr.appendChild(th);
    });
    thd.appendChild(tr);

    // tbody 하위요소.
    tr = document.createElement("tr");
    for(let i = 1; i < firstDay; i++){
        let td = document.createElement("td");
        tr.appendChild(td);

    }
    for(let d = 1; d <= lastDay; d++){
        let td = document.createElement("td");
        td.innerHTML = d;        
        tr.appendChild(td);
        if((d + firstDay -1) % 7 == 1) td.style.color = "red";
        if((d + firstDay - 1) % 7 == 0){
            td.style.color = "blue";
            tbd.appendChild(tr);
            tr = document.createElement("tr");
        }
    }
    tbd.appendChild(tr);
    

    tbl.appendChild(thd);
    tbl.appendChild(tbd);
    document.querySelector("#show").appendChild(tbl);
}
makeCalendar(7);
makeCalendar();


// 달력선택 이벤트
let sel = document.querySelector("#selectMonth");
sel.addEventListener("change", selectMonth);
function selectMonth(){
    makeCalendar(Number(this.value));
}