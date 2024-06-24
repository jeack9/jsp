/**
 *  public.js
 */

let url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=dlBC9MdFCFhRf51KceO1U%2B%2B%2BUq2qVCr0PLm28JGTGYcx5rj1hgYgFLD8MMr9mOfJzIr7fUVzsgguS%2B54SX0dUQ%3D%3D";

// 센터정보생성.
document.getElementById("centerDB").addEventListener("click", createCenterInfo);
function createCenterInfo(){
    // 1. open API 호출.
    // 2. 컨트롤 호출 DB입력.
    fetch(url)
        .then(response => response.json())
        .then(result => {
            let centers = result.data; // [{}, {}]
            return fetch("centerInfo.do", {
                method: "post", // 전달값 body에 저장
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(centers) // 객체 -> json
                })
                .then(result => result.json())
                .then(result => {
                    if(result.txnCnt > 0) alert(result.txnCnt + "건 등록");
                    else alert("실패");
                })
                .catch(err => console.log(err));
        })
        .catch(err => console.log(err));
}

const target = document.querySelector("#centerList"); // 하위목록.
let searchList = document.querySelector("#searchList");
// 페이지 로딩 => 목록 생성
fetch(url)
    .then(respone => respone.json())
    .then(result => {
        // result.data.forEach(center => console.log(center));
        makeOption(result.data);
        result.data.forEach(center => {
            target.appendChild(makeRow(center));
        });
    })
    .catch(err => console.log(err));

// 3) 셀렉트 옵션 생성
function makeOption(data){
    // 3)셀렉트리스트 생성
    let sidoArr = [];
    data.forEach(center => {
        if(sidoArr.indexOf(center.sido) == -1) sidoArr.push(center.sido);
    });
    sidoArr.forEach(sido =>{
        let option = document.createElement("option");
        option.innerHTML = sido;
        option.setAttribute("value", sido);
        searchList.appendChild(option);
    });
    // end 3)셀렉트 리스트 생성 
}

// 셀렉트리스트 이벤트
searchList.addEventListener("change", searchListFnc);
function searchListFnc(){
    let searchKw = this.value;
    fetch(url)
    .then(respone => respone.json())
    .then(result => {
        target.innerHTML = "";
        result.data.forEach(center => {
            if(center.sido.indexOf(searchKw) != -1){
                center.centerName = center.centerName.replace(searchKw, `<b>${searchKw}</b>`);
                target.appendChild(makeRow(center));
            }
        });
    });
}

// 2) 주소검색 기능
document.querySelector("#findBtn").addEventListener("click", searchKwFnc); // 주소검색 버튼 이벤트
function searchKwEnter(e){
    if(e.keyCode == 13) searchKwFnc();
}
function searchKwFnc(){
    let searchKw = document.querySelector("#search").value;
    fetch(url)
    .then(respone => respone.json())
    .then(result => {
        target.innerHTML = "";
        result.data.forEach(center => {
            if(center.address.indexOf(searchKw) != -1){
                center.address = center.address.replace(searchKw, `<b>${searchKw}</b>`);
                target.appendChild(makeRow(center));
            }
        });
    });
}

// 1) 목록을 출력하기
function makeRow(center = {id, centerName, phoneNumber, address}){
    let cloneTr = document.querySelector("thead > tr:nth-of-type(2)").cloneNode(true);
    cloneTr.addEventListener("click", () =>{
        window.open(`map.do?x=${center.lat}&y=${center.lng}&name=${center.centerName}`);
    });
    cloneTr.style.display = "";
    cloneTr.querySelector("td:nth-child(1)").innerHTML = center.id;
    cloneTr.querySelector("td:nth-child(2)").innerHTML = center.centerName;
    cloneTr.querySelector("td:nth-child(3)").innerHTML = center.phoneNumber;
    cloneTr.querySelector("td:nth-child(4)").innerHTML = center.address;
    return cloneTr;
}// end makeRow()
//centerName, address, id, phoneNumber