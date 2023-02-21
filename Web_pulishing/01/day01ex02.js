var clickBtn = document.getElementById("clickBtn");
var haeding = document.getElementById("heading");
var aa = document.getElementsByClassName("aa"); // 리스트 형태로 가져온다.
// DOM의 선택 여부 확인 가능
console.log(clickBtn);
console.dir(clickBtn);
// 선택된 DOM 요소에 이벤트 핸들러 걸기
clickBtn.onclick = function(event) {
  // 클릭 이벤트가 발생하면 이벤트를 console에 출력
  // console.dir(event)
  console.dir(document);
  // document.bgColor = "yellow";
  document.body.style.background = "yellow" // 배경색 변경
  document.title = "Hello"; // 타이틀 변경
  console.log("heading");
  haeding.style.backgroundColor = "red" // id가 heading인 객체 배경 변경
}
// 문서의 거의 모든 요소가 객체가 될 수 있다. (함수, 넘버도 객체가 될 수 있다.)
// 함수를 변수에 참조시킨다.
// 함수를 배열에도 담을 수 있다.
// 함수를 다른 함수의 인자로 사용 (callback 함수)