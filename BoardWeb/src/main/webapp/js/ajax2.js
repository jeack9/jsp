/**
 * ajax2.js
 */

let xhtp = new XMLHttpRequest();
xhtp.open("get", "membersAjax.do");
xhtp.send();
xhtp.onload = () =>{
    // console.log(xhtp);
    let data = JSON.parse(xhtp.responseText);
    data.forEach(user => {
        document.querySelector("#list").appendChild(makeRow(user));
    })
}

// 행 반환 함수
let fields = ["userId", "userName", "userPw", "responsibility", "image"];
function makeRow(obj = {id, first_name, email, gender}){
    let tr = document.createElement("tr");
    tr.setAttribute("id", obj.userId);
    tr.addEventListener("dblclick", function(e){ // 모달창 열기 이벤트
        document.querySelector("#myModal").style.display = "block";
        document.querySelector("#modify_id").value = this.children[0].innerHTML;
        document.querySelector("#modify_name").value = this.children[1].innerHTML;
        document.querySelector("#modify_pass").value = this.children[2].innerHTML;
    });
    fields.forEach(field =>{
        let td = document.createElement("td");
        if(field == "image") { // 유저 이미지 
            if(obj.image === undefined) obj.image = "test.jpg";
            let img = document.createElement("img");
            img.setAttribute("src", `images/${obj.image}`);
            img.setAttribute("width", "100");
            td.appendChild(img);  
        }else{
            td.innerHTML = obj[field];
        }
        tr.appendChild(td);
    });
    let td = document.createElement("td");
    let btn = document.createElement("button");
    btn.setAttribute("class", "btn btn-danger");
    btn.innerHTML = "삭제";
    btn.addEventListener("click", function(){ // 삭제이벤트
        let id = obj.userId;
        console.log(id);
        let removeAjax = new XMLHttpRequest();
        let url = `removeAjax.do?id=${id}`;
        removeAjax.open("get", url);
        removeAjax.send();
        removeAjax.onload = () =>{
            console.log(removeAjax.responseText);
            let result = JSON.parse(removeAjax.responseText);
            console.log(result);
            if(result.retCode == "Success"){
                tr.remove();
            }else{
                alert('삭제 실패');
            }
        }
    }); // 삭제 이벤트
    td.appendChild(btn);
    tr.appendChild(td);
    return tr;
}

// 행 삭제 함수
function removeRow(){

}

// 수정 이벤트(모달창)
document.querySelector("#modBtn").addEventListener("click", function(){
    let id = document.querySelector("#modify_id").value;
    let name = document.querySelector("#modify_name").value;
    let pass = document.querySelector("#modify_pass").value;

    // ajax 생성
    // 정상적으로 정보가 업데이트되면 화면 수정
    // 수정이 완됐으면 화면수정 x 
    let editAjax = new XMLHttpRequest();
    let url = `editAjax.do?id=${id}&name=${name}&pass=${pass}`;
    editAjax.open("get", url)
    let targetTr = document.querySelector(`#${id}`);
    targetTr.children[1].innerHTML = name;
    targetTr.children[2].innerHTML = pass;

    // 모달창 닫기
    document.querySelector("#myModal").style.display = 'none';

});

// 추가 버튼 이벤트 (행 추가)
document.querySelector("#addBtn").addEventListener("click", () =>{
    const formData = new FormData();
    const fileField = document.querySelector('input[type="file"]');
    
    formData.append("userId", document.querySelector("#uid").value);
    formData.append("userPw", document.querySelector("#upw").value);
    formData.append("userName", document.querySelector("#uname").value);
    formData.append("responsibility", document.querySelector("#duty").value);
    formData.append("myImage", fileField.files[0]);
    
    upload(formData);
});
async function upload(formData) {
    try {
      const response = await fetch("joinMember.do", {
        method: "PUT",
        body: formData,
      });
      const result = await response.json();
    //   console.log("성공:", result);
      if(result.retCode == "OK"){
        let response = await fetch("membersAjax.do");
        let result = await response.json();
        document.querySelector("#list").innerHTML = "";
        result.forEach(user => {
            document.querySelector("#list").appendChild(makeRow(user));
        });
      }
    } catch (error) {
      console.error("실패:", error);
    }
}
//(행 추가)
function addMemberFnc(){
    let id = document.querySelector("#uid").value;
    let pw = document.querySelector("#upw").value;
    let name = document.querySelector("#uname").value;
    let duty = document.querySelector("#duty").value;
    let addAjax = new XMLHttpRequest();
    let url = `addAjax.do?id=${id}&pw=${pw}&name=${name}&duty=${duty}`;
    addAjax.open("get", url);
    addAjax.send();
    addAjax.onload = () =>{
        console.log(addAjax.responseText);
        let result = JSON.parse(addAjax.responseText);
        if(result.retCode == "OK"){
            let newMem = {userId : id, userPw : pw, userName : name, responsibility : duty}
            // alert(result.retMsg);
            document.querySelector("#list").appendChild(makeRow(newMem));
        }else{
            alert("실패");
        }
    }
}

// id 체크 이벤트
document.querySelector('#uid').addEventListener("change", function(){
    let checkId = this.value;
    let checkAjax = new XMLHttpRequest();
    checkAjax.open("get", `checkIdAjax.do?id=${checkId}`);
    checkAjax.send();
    checkAjax.onload = () => {
        let result = JSON.parse(checkAjax.responseText);
        if(result.retCode == "Exist"){
            alert("이미 아이디 존재");
            document.querySelector("#addBtn").disabled = true;
        }else{
            alert("사용 가능한 아이디");
            document.querySelector("#addBtn").disabled = false;
        }
    }
});