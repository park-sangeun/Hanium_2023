/*!
    * Start Bootstrap - SB Admin v7.0.7 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2023 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    //
// Scripts
//

window.addEventListener('DOMContentLoaded', event => {

  // Toggle the side navigation
  const sidebarToggle = document.body.querySelector('#sidebarToggle');
  if (sidebarToggle) {
      // Uncomment Below to persist sidebar toggle between refreshes
      // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
      //     document.body.classList.toggle('sb-sidenav-toggled');
      // }
      sidebarToggle.addEventListener('click', event => {
          event.preventDefault();
          document.body.classList.toggle('sb-sidenav-toggled');
          localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
      });
  }

});

// 실시간 스트리밍 js코드

var modelRobotBtn = document.getElementById('modelRobotBtn');
var smallRobotBtn = document.getElementById('smallRobotBtn');
var videoPlayer = document.getElementById('videoPlayer');
    
// 모체로봇 버튼 클릭 시 모체로봇 영상을 보여줍니다.
//modelRobotBtn.addEventListener('click', function() {
  //videoPlayer.src = 'https://www.youtube.com/watch?v=PrqwxkBB0DA';
//});
    
// 소형로봇 버튼 클릭 시 소형로봇 영상을 보여줍니다.
//smallRobotBtn.addEventListener('click', function() {
  //videoPlayer.src = 'https://www.youtube.com/embed/VIDEO_ID?rel=0';
//});

// 실시간 스트리밍 js코드 끝



// 컨트롤러 js코드
var activeButton = null;
var directionText = document.getElementById('direction-text');

function sendCommand(direction) {
  var url = 'http://172.20.10.7:5000/control?direction=' + direction;
  var request = new XMLHttpRequest();
  request.open('GET', url, true);
  request.send();
}

function displayWaitingState() {
  var direction = '로봇의 상태 : 대기중';
  updateDirectionText(direction);
}

function activateButton(button) {
  if (activeButton && activeButton !== button) {
    activeButton.classList.remove('active');
  }
  activeButton = button;
  activeButton.classList.add('active');
}

function updateDirectionText(direction) {
  directionText.innerText = direction;
}

function handleKeydown(event) {
  var key = event.key;
  var direction = '';
  var button = null;

  if (key === 'ArrowUp') {
    direction = '로봇의 상태 : 직진';
    button = document.querySelector('.button[data-direction="forward"]');
  } else if (key === 'ArrowDown') {
    direction = '로봇의 상태 : 후진';
    button = document.querySelector('.button[data-direction="backward"]');
  } else if (key === 'ArrowLeft') {
    direction = '로봇의 상태 : 좌로 회전';
    button = document.querySelector('.button[data-direction="left"]');
  } else if (key === 'ArrowRight') {
    direction = '로봇의 상태 : 우로 회전';
    button = document.querySelector('.button[data-direction="right"]');
  }

  if (direction !== '') {
    sendCommand(direction);
    activateButton(button);
    updateDirectionText(direction);
  }
}

function handleKeyup(event) {
  var key = event.key;

  if (key === 'ArrowUp' || key === 'ArrowDown' || key === 'ArrowLeft' || key === 'ArrowRight') {
    sendCommand('stop');
    activeButton.classList.remove('active');
    activeButton = null;
    updateDirectionText('');
    displayWaitingState();
  }
}

//window.onload = function() {
  //document.querySelector('.button[onclick="sendCommand(\'forward\')"]').focus();
//};

// 컨트롤러 js코드 끝


// 로그인 실패 알림 js코드

// 로그인 자격 증명을 확인하는 JavaScript 함수
function checkLogin() {
  const 저장된사용자ID = "1234"; // 미리 저장한 사용자 ID로 대체하세요.
  const 저장된패스워드 = "1234"; // 미리 저장한 패스워드로 대체하세요.

  const 입력된사용자ID = document.getElementById("userId").value;
  const 입력된패스워드 = document.getElementById("user_password").value;

  if (입력된사용자ID === 저장된사용자ID && 입력된패스워드 === 저장된패스워드) {
      // 자격 증명이 올바르면, 원하는 페이지로 리다이렉션합니다 (예: 대시보드)
      window.location.href = "main.html"; // 원하는 로그인 성공 페이지로 대체하세요.
  } else {
      // 오류 메시지 표시
      alert("아이디 또는 패스워드가 잘못되었습니다. 다시 시도해주세요.");
  }
}

// 로그인 버튼에 로그인 확인 함수를 연결합니다.
//document.querySelector(".btn-primary").addEventListener("click", function (event) {
  //event.preventDefault(); // 폼 제출 방지
  //checkLogin();
//});

// 로그인 실패 알림 js코드 끝

