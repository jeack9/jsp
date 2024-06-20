/**
 * reply.js
 */

// 댓글 -> li 생성.
function makeRow(reply = {}){
    let fields = ["replyNo", "reply", "replier", "replyDate"];
    let li = document.createElement("li");
    fields.forEach(field => {
        let span = document.createElement("span");
        span.innerHTML = reply[field];
        let width = "2";
        if(field == "reply") width = "4";
        else if(field == "replyDate") width = "3"
        span.setAttribute("class", `col-sm-${width}`)
        li.appendChild(span);

    });
    return li;
}

// 댓글 행 생성
function cloneRow(reply = {}){
    let template = document.querySelector("div.content > ul > li:nth-child(3)").cloneNode(true);
    // console.dir(template);
    template.style.display = "block";
    template.querySelector("span:nth-of-type(1)").innerHTML = reply.replyNo;
    template.querySelector("span:nth-of-type(2)").innerHTML = reply.reply;
    template.querySelector("span:nth-of-type(3)").innerHTML = reply.replier;
    template.querySelector("span:nth-of-type(4)").innerHTML = reply.replyDate;
    template.querySelector("button").setAttribute("data-rno", reply.replyNo);
    template.setAttribute("id",  `rno${reply.replyNo}`);
    return template;
}

// 댓글 삭제
function deleteRow(e){
    // console.log(e, "dfd");
    // console.log(rno);
    let rno = e.target.dataset.rno;
    let removeAjax = new XMLHttpRequest();
    removeAjax.open("get", `removeReply.do?rno=${rno}`)
    removeAjax.send();
    removeAjax.onload = () => {
        let data = JSON.parse(removeAjax.responseText);
        if(data.retCode === "OK"){
            document.querySelector(`#rno${rno}`).remove();
        }else{
            alert("삭제 실패!");
        }
    }
}

// 현재 글 댓글 가져오기
let listAjax = new XMLHttpRequest();
listAjax.open("get", `replyListJson.do?bno=${bno}`);
listAjax.send();
listAjax.onload = () =>{
    let data = JSON.parse(listAjax.responseText);
    console.log(data);
    data.forEach(reply =>{
        // document.querySelector("div.content > ul").appendChild(makeRow(reply));
        document.querySelector("div.content > ul").appendChild(cloneRow(reply));
    });
}