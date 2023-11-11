var modelRobotBtn = document.getElementById('modelRobotBtn');
var smallRobotBtn = document.getElementById('smallRobotBtn');
var videoPlayer = document.getElementById('videoPlayer');
    
// 모체로봇 버튼 클릭 시 모체로봇 영상을 보여줍니다.
modelRobotBtn.addEventListener('click', function() {
  videoPlayer.src = 'http://192.168.216.203:8000/stream.mjpe';
});
    
// 소형로봇 버튼 클릭 시 소형로봇 영상을 보여줍니다.
smallRobotBtn.addEventListener('click', function() {
  videoPlayer.src = 'https://www.youtube.com/embed/VIDEO_ID?rel=0';
});

var streamingImage = document.getElementById('streaming-image');

    // 스트리밍 이미지 업데이트를 위한 함수
    function updateStreamingImage() {
        // 적외선 카메라 스트리밍 URL을 설정합니다.
        var streamingURL = 'http://192.168.216.203:8000/stream.mjpeg';

        // 이미지 요소의 src 속성을 스트리밍 URL로 설정합니다.
        streamingImage.src = streamingURL + '?' + new Date().getTime();

        // 일정한 간격으로 스트리밍 이미지 업데이트 함수를 호출합니다.
        setTimeout(updateStreamingImage, 1000); // 1초마다 업데이트
    }

    // 페이지 로드 후 스트리밍 이미지 업데이트를 시작합니다.
    updateStreamingImage();
