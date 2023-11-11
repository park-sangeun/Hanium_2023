function logout() {
    $.ajax({
        url: '/member/logout',
        method: 'GET',
        success: function(response) {
            // 로그아웃 성공 시 로그인 페이지로 이동
            window.location.href = '/member/login';
        },
        error: function(xhr, status, error) {
            console.error(error);
            // 에러 처리 작업 추가 가능
        }
    });
}
