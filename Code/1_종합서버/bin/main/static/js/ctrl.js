// WebSocket 연결 설정
var socket = new SockJS('/controller');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
   console.log('WebSocket 연결 성공');
});

var motorDirection = ''; // 모터 동작 방향을 저장할 변수

// 방향키 이벤트 감지
document.addEventListener('keydown', function (event) {
   var key = event.key;

   if (key === 'ArrowUp') {
       motorDirection = 'w';
   } else if (key === 'ArrowLeft') {
       motorDirection = 'a';
   } else if (key === 'ArrowDown') {
       motorDirection = 's';
   } else if (key === 'ArrowRight') {
       motorDirection = 'd';
   }

   if (motorDirection !== '') {
       // 방향키가 눌린 상태에서만 메시지를 서버로 전송
       stompClient.send("/app/controlMotor", {}, motorDirection);
   }
});

// 방향키 떼는 이벤트 감지
document.addEventListener('keyup', function (event) {
   motorDirection = ''; // 방향키에서 손을 뗄 때 모터 동작을 멈춤
   stompClient.send("/app/controlMotor", {}, 'stop'); // 서버에 'stop' 메시지 전송
});
