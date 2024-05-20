/**
 * 
 */

// 아이디가 result인 HTML 요소를 찾음:
 const result = document.getElementById('result');
 
// result 요소에 추가할 html 코드를 저장하기 우한 문자열 변수:
 let html = ''; //
 
 for(let x = 0;x < 10; x++) {
    html += `2 x ${x} = ${2 * x} <br/>`; 
 }
 
 result.innerHTML += html;
 
 result.innerHTML += '<hr/>';
 
 //연습문제: result에 구구단 3단 ~ 9단까지 덧붙임(append).
 for (let x = 3; x <10; x++) {
    for (let y = 1; y <10; y++) {
          html +=`${x} x ${y} = ${x * y} <br/>`;

    }
    html += '------------ <br/>';
 }
 
 result.innerHTML += html;
 
 result.innerHTML += '<hr/>';
 
 // 연습문제: break를 사용해서 2단은 2*2까지. 3단은 3*3까지
for (let x = 1; x <10; x++) {
    for (let y = 1; y <10; y++) {
          html +=`${x} x ${y} = ${x * y} <br/>`;
          if(x == y) {
            break;
          }

    }
    html += '------------ <br/>';
 }
 
 result.innerHTML += html;
 
 result.innerHTML += '<hr/>';