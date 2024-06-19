/**
 * dom1.js 
 */
// document.getElementById("fruit").style.display = "none";

document.querySelector(".table tr:nth-child(5)").setAttribute("align", "center");

// 페이지 로딩시 회원 3명 출력
window.onload = init;
function init(){
    for(let ele of myMembers){        
        document.querySelector("#member_list")//
        .appendChild(addRow(ele));
    }
}

// 추가버튼에 클릭이벤트 등록
let addBtn = document.querySelector("#addBtn");
addBtn.addEventListener("click", addMemberFnc);

// 멤버 행 추가 함수 선언
function addMemberFnc(){
    const ID = document.querySelector("#mid").value;
    const NAME = document.querySelector("#mname").value;
    const PHONE = document.querySelector("#mphone").value;
    const POINT = document.querySelector("#mpoint").value;

    if(!ID || !NAME || !PHONE || !POINT){
        alert("필수값 입력.")
        return;
    }

    const TR = addRow({ID, NAME, PHONE, POINT});
    document.querySelector("#member_list").appendChild(TR);
    document.querySelector("#mid").value = "";
    document.querySelector("#mname").value = "";
    document.querySelector("#mphone").value = "";
    document.querySelector("#mpoint").value = "";
}

function addRow(member = {ID, NAME, PHONE, POINT}){
    // tr > td * 4
    const TR = document.createElement("tr");
    TR.style.cursor = "pointer";
    TR.addEventListener("click", showDetailFnc);
    for(let prop in member){
        const TD = document.createElement("td");
        TD.innerHTML = member[prop];
        TR.appendChild(TD);
    }
    // 삭제버튼 생성
    let td = document.createElement("td");
    let btn = document.createElement("button");
    btn.setAttribute("class", "btn btn-danger");
    btn.innerHTML = "삭제";
    btn.addEventListener("click", removeTrElementFnc);
    td.appendChild(btn);
    TR.appendChild(td);

    // 체크박스(선택) 생성
    td = document.createElement("td");
    btn = document.createElement("input");
    btn.setAttribute("type", "checkbox");
    btn.addEventListener("click", stopPropFnc);
    td.appendChild(btn);
    TR.appendChild(td);

    return TR;
} // end of addRow()

// 이벤트 핸들러
function stopPropFnc(e){
    e.stopPropagation();
    let trs = document.querySelectorAll("#member_list > tr"); //전체 행 배열
    for(let tr of trs){
        document.querySelector("thead input[type='checkbox']").checked = tr.children[5].children[0].checked;
        if(tr.children[5].children[0].checked == false) break;
    }
}

// 행 삭제
function removeTrElementFnc(e){    
    e.stopPropagation(); // 상위요소로 이벤트전파 차단 (showDetailFnc)
    this.parentElement.parentElement.remove();
}
// () =>{
//     td.parentElement.remove(); // 행 삭제
// }

// 행 클릭시 정보 보기
function showDetailFnc(){
    document.querySelector("#mid").value = this.children[0].innerText;
    document.querySelector("#mname").value = this.children[1].innerText;
    document.querySelector("#mphone").value = this.children[2].innerText;
    document.querySelector("#mpoint").value = this.children[3].innerText;
    document.querySelector("#mid").readOnly = true;
}

// 수정버튼 이벤트 연결
document.querySelector("#modBtn").addEventListener("click", modMemberFnc);
function modMemberFnc(){
    document.querySelector("#mid").readOnly = false;
    const ID = document.querySelector("#mid").value;
    const NAME = document.querySelector("#mname").value;
    const PHONE = document.querySelector("#mphone").value;
    const POINT = document.querySelector("#mpoint").value;    

    if(!ID || !NAME || !PHONE || !POINT){
        alert("필수값 입력.")
        return;
    }
    let trs = document.querySelectorAll("#member_list > tr"); //전체 행 배열    
    for(let modTr of trs){ // 수정할 행 찾기
        if(modTr.children[0].innerText === ID){            
            modTr.children[1].innerText = NAME;
            modTr.children[2].innerText = PHONE;
            modTr.children[3].innerText = POINT;
            break;
        }
    }

    document.querySelector("#mid").value = "";
    document.querySelector("#mname").value = "";
    document.querySelector("#mphone").value = "";
    document.querySelector("#mpoint").value = "";
}

// 선택삭제 버튼 이벤트 연결
let delBtn = document.querySelector("#delBtn");
delBtn.addEventListener("click", selDelBtnFnc);
function selDelBtnFnc(){
    // e.stopPropagation();
    let trs = document.querySelectorAll("#member_list > tr");
    for(let tr of trs){
        if(tr.children[5].children[0].checked === true){
            tr.remove();
        }
    }
}
// 선택삭제 모두선택, 모두해제
let checkAll = document.querySelector("thead input[type='checkbox']");
document.querySelector("thead input[type='checkbox']").addEventListener("change", checkAllFnc);

function checkAllFnc(){
    let trs = document.querySelectorAll("#member_list > tr");   
    trs.forEach(item => item.children[5].children[0].checked = this.checked);
}

// 