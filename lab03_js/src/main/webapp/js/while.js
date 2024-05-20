/**
 * while.html에 포함
 */

 const list = document.querySelector('#list');
 //document.getElementById('list')
 
 const tableBody = document.querySelector('#tableBody');
 
 // 상수 선언
 let html = ''; // <ul></ul> 태그의 컨텐트로 작성할 HTML 코드.
 
 let n = 1;
 while (n <=5) {
    html += `<li> 아이템 ${n} </li>`;
    n++;
 }
 
 list.innerHTML = html;
 
 // 테이블을 자동으로 만들어주는 자바스크립트 만들어보기 (제목1, 제목2 ..)
let x = 1;
html = '';
while (x <=5) {
    html += `<tr>
                <td> ${x} </td>
                <td>제목 ${x}</td>
            </tr>`;
    x++;
}
tableBody.innerHTML = html;