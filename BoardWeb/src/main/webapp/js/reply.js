/**
 *  reply.js
 */

svc.replyList(bno, replyListFnc);

// 댓글 등록 이벤트
document.getElementById("addReply").addEventListener("click", addReplyRow);

function addReplyEnter(e){ // 엔터키 등록이벤트
    if(e.keyCode == 13) addReplyRow();
}

// 댓글등록 함수 bno, writer, reply
function addReplyRow(){
    if(!replier){
        alert("로그인하세요!!");
        return;
    }
    let reply = document.querySelector("#reply").value;
    if(!reply){
        alert("댓글을 입력하세요!!");
        return;
    }
    
    svc.addReply({replier, reply, bno}, addReplyFnc)

    function addReplyFnc(){
        let data = JSON.parse(this.responseText);
        console.log(data.retVal);
        if(data.retCode == "OK"){
            let li = cloneRow(data.retVal);
            document.querySelector("div.content > ul").appendChild(li);
            document.querySelector("input#reply").value = "";
        }else{
            alert("댓글 등록실패!");
        }
    }
}// END addReplyFnc()

// 댓글 출력
function replyListFnc(){
    console.log(this);
    let data = JSON.parse(this.responseText);
    data.forEach(reply => {
        let li = cloneRow(reply);
        document.querySelector("div.content > ul").appendChild(li);
    });
}

// 댓글정보 -> li 생성.
function cloneRow(reply = {}){
    let cloneLi = document.querySelector("div.content > ul > li:nth-child(3)").cloneNode(true);
    // console.dir(template);
    cloneLi.style.display = "block";
    cloneLi.querySelector("span:nth-of-type(1)").innerHTML = reply.replyNo;
    cloneLi.querySelector("span:nth-of-type(2)").innerHTML = reply.reply;
    cloneLi.querySelector("span:nth-of-type(3)").innerHTML = reply.replier;
    cloneLi.querySelector("span:nth-of-type(4)").innerHTML = reply.replyDate;
    cloneLi.querySelector("button").setAttribute("data-rno", reply.replyNo);
    cloneLi.setAttribute("id",  `rno${reply.replyNo}`);
    return cloneLi;
}

// 댓글 삭제
function deleteRow(e){
    // console.log(e, "dfd");
    // console.log(rno);
    let rno = e.target.dataset.rno;
    svc.removeReply(rno, removeReplyFnc)
    function removeReplyFnc(){
        console.log(this.responseText);
        let data = JSON.parse(this.responseText);
        if(data.retCode === "OK"){
            document.querySelector(`#rno${rno}`).remove();
        }else{
            alert("삭제 실패!");
        }
    }
}

