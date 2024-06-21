/**
 *  reply.js
 */

let page = 1;
svc.replyList({bno, page}, replyListFnc); // 댓글 출력

// 댓글 등록 이벤트
document.getElementById("addReply").addEventListener("click", addReplyRow);

function addReplyEnter(e){ // 엔터키 등록이벤트
    if(e.keyCode == 13) addReplyRow();
}

// 페이징 a 태그를 클릭하면 목록보여주기.
document.querySelectorAll("div.pagination > a").forEach(aTag => {
    aTag.addEventListener("click", function(e){
        e.preventDefault(); // a태그 href 이벤트 제거
        page = aTag.innerHTML;
        svc.replyList({bno, page}, replyListFnc);
    });
});

// 댓글 건수를 활용해서 페이징 계산하고 목록출력.
function makePagingFnc(){
    svc.replyTotalCnt(bno, createPagingList);
}
let pagination = document.querySelector("div.pagination");
function createPagingList(){ // 페이지버튼 만들기
    let totalCnt = this.responseText;
    let startPage, endPage;
    let prev, next;
    let realEnd = Math.ceil(totalCnt / 5);
    endPage = Math.ceil(page / 5) * 5; // 10페이지씩
    startPage = endPage - 4;
    endPage = realEnd < endPage ? realEnd : endPage;

    prev = startPage > 1 ? true : false;
    next = endPage < realEnd;

    // startPage, endPage, prev, next => a태그 생성
    pagination.innerHTML = "";
    if(prev){
        let aTag = document.createElement("a");
        aTag.setAttribute("data-page", startPage - 1);
        aTag.setAttribute("href", "#");
        aTag.innerHTML = "&laquo;";
        pagination.appendChild(aTag);
    }
    for(let p = startPage; p <= endPage; p++){
        let aTag = document.createElement("a");
        aTag.setAttribute("data-page", p);
        aTag.setAttribute("href", "#");
        aTag.innerHTML = p;
        if(page == p) aTag.className = "active";
        pagination.appendChild(aTag);
    }
    if(next){
        let aTag = document.createElement("a");
        aTag.setAttribute("data-page", endPage + 1);
        aTag.setAttribute("href", "#");
        aTag.innerHTML = "&raquo;";
        pagination.appendChild(aTag);
    }
    document.querySelectorAll("div.pagination > a").forEach(aTag => {
        aTag.addEventListener("click", function(e){
            e.preventDefault(); // a태그 href 이벤트 제거
            page = aTag.dataset.page;
            svc.replyList({bno, page}, replyListFnc);
        });
    });
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
            // let li = cloneRow(data.retVal);
            // document.querySelector("div.content > ul").appendChild(li);
            page = 1;
            svc.replyList({bno, page}, replyListFnc);
            document.querySelector("input#reply").value = "";
        }else{
            alert("댓글 등록실패!");
        }
    }
}// END addReplyFnc()

// 댓글 출력
function replyListFnc(){
    // 5개의 댓글을 지워주고 새롭게 목록 출력.
    document.querySelectorAll("div.content > ul > li").forEach((li, idx) => {
        if(idx > 2){
            li.remove();
        }
    });
    let data = JSON.parse(this.responseText);
    data.forEach(reply => {
        let li = cloneRow(reply);
        document.querySelector("div.content > ul").appendChild(li);
    });
    makePagingFnc();// 페이징 그려주기
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
            // document.querySelector(`#rno${rno}`).remove();
            svc.replyList({bno, page}, replyListFnc);
        }else{
            alert("삭제 실패!");
        }
    }
}

