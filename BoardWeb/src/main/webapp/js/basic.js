// Dom 연습
document.querySelector("ul#fruit > li").innerHTML = "사과";
let li = document.createElement("li");
li.innerHTML = "<b>오렌지</b>"
document.querySelector("#fruit").appendChild(li);
document.querySelector("#fruit>li").remove();
document.querySelector("#fruit>li").style.backgroundColor = "yellow";

// 버튼생성

let liList = document.querySelectorAll("#fruit>li");

for (let i = 0; i < liList.length; i++) {
	let btn = document.createElement("button");
	btn.innerText = "삭제";
	btn.setAttribute("class", "btn btn-primary");
	btn.addEventListener("click", () => {
		btn.parentNode.remove();
	});
	liList[i].appendChild(btn);
}