document.addEventListener('DOMContentLoaded', function () {
    const homeLink = document.querySelector('.nav-link[href="/main"]');
    const streamingLink = document.querySelector('.nav-link[href="/streaming"]');
    const locationLink = document.querySelector('.nav-link[href="/location"]');
    const disasterLink = document.querySelector('.nav-link[href="/disaster"]');
    const controllerLink = document.querySelector('.nav-link[href="/controller"]');
    const robotLink = document.querySelector('.nav-link[href="/data/mrobot"]');
    const smallRobotLink = document.querySelector('.nav-link[href="/data/srobot"]');
    const videoDataLink = document.querySelector('.nav-link[href="/video/list"]');
    const logoLink = document.querySelector('.navbar-brand');

    homeLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/main';
    });

    streamingLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/streaming';
    });

    locationLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/location';
    });

    disasterLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/disaster';
    });

    controllerLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/controller';
    });

    robotLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/data/mrobot';
    });

    smallRobotLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/data/srobot';
    });

    videoDataLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/video/list';
    });

    logoLink.addEventListener('click', function (event) {
            event.preventDefault();
            window.location.href = '/main'; // 홈 페이지의 경로로 변경해야 합니다.
        });
});
