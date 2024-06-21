/**
 * replyService.js
 * 목록, 단건, 등록, 삭제
 */

const svc = {
    // 목록
    replyList(param = {bno: 1, page: 1}, successCall = function(){}){
        const xhtp = new XMLHttpRequest();
        xhtp.open("get", `replyListJson.do?bno=${param.bno}&page=${param.page}`);
        xhtp.send();
        xhtp.onload = successCall;
    },
    // 단건
    getReply(rno = 1, successCall){
        const xhtp = new XMLHttpRequest();
        // xhtp.open("get", `replyListJson.do?bno=${bno}`);
        // xhtp.send();
        // xhtp.onload = successCall;
    },
    // 등록 bno, replier, reply
    addReply(rvo = {replier, reply, bno}, successCall){
        const xhtp = new XMLHttpRequest();
        xhtp.open("post", `addReply.do`);
        xhtp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        let parameter = `bno=${rvo.bno}&replier=${rvo.replier}&reply=${rvo.reply}`;
        xhtp.send(parameter); // get -> header 저장, post -> body(send) 저장
        xhtp.onload = successCall;
    },
    // 삭제
    removeReply(rno = 1, successCall){
        const xhtp = new XMLHttpRequest();
        xhtp.open("get", `removeReply.do?rno=${rno}`);
        xhtp.send();
        xhtp.onload = successCall;
    },
    replyTotalCnt(bno = 1, successCall){
        const xhtp = new XMLHttpRequest();
        xhtp.open("get", `replyTotalCnt.do?bno=${bno}`);
        xhtp.send();
        xhtp.onload = successCall;
    }
}