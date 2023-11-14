# 모체 로봇 사용 방법
>Ubuntu 20.04 사용

### OpenPose 사용 
1. opnepose.py와 openpose protofile을 라즈베리파이에 저장
2. 라즈베리파이 작동 시 Autorun

### YOLO 사용
1. yolo.py와 coco.names, sample.jpg, yolov3.cfg 파일을 라즈베리파이에 저장
2. 라즈베리파이 작동 시 Autorun

### SLAM 사용
>https://emanual.robotis.com/docs/en/platform/turtlebot3/quick-start/#pc-setup 관련 링크 첨부
#### ROS 설정
* ROS 버전은 Noetic 버전을 사용했기에 Noetic 버전으로 진행
1. microSD 카드에 Turtlebot3 SBC 이미지 설치
2. Ubuntu 20.04 기반에서 Noetic 버전 이미지를 설치
* Noetic 버전 이미지는 Ubuntu 20.04를 기반으로 생성

#### Rasberry Pi OS (32-bit) 설치
1. https://www.raspberrypi.com/software/ 에서 운영체제에 맞는 실행파일 설치
2. Raspberry Pi Imager로 SD카드에 OS 굽기
   * 운영체제: Rasberry Pi OS (32-bit)
   * 저장소 선택
   * Hostname 설정: pi
   * SSH 사용: 비밀번호 인증 사용 선택
   * 사용자 이름: pi
   * 비밀번호: 
   * 로케일 설정 지정: Asia/Seoul, kr
3. 원격제어 사용 시 설정 내용
3-1. wpa_supplicant.conf 추가
```
country=US
ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1
network={
    ssid="사용할 WIFI name"
    psk="WIFI Password"
    scan_ssid=1
    key_mgmt=WPA-PSK
}
```
3-2. ssh 파일 추가

#### OpenCR 설정
1. ROS 네트워크 구성
2. LDS-02 드라이버 설치 및 TurtleBot3 패키지 업데이트를 통해 새로운 LDS-02 구성
3. 마이크로 USB 케이블을 사용하여 OpenCR보드를 Raspberry Pi에 연결
4. OpenCR에 펌웨어 업데이트를 하여 OpenCR 설정
5. OpneCR보드의 PUSH SW 버튼을 활용하여 OpenCR 보드 테스트
6. Ubuntu PC에서 roscore를 실행하여 turtlebot3 bringup

#### 로봇 기본주행
1. 원격조작 노드를 실행하여 지도를 탐색하고 그리는 작업 실행
2. 그린 지도 저장
3. 탐색 노드 실행
4. 초기 포즈 추정
5. Rviz 메뉴에서 탐색 목표 설정

### 모체 로봇 실행
라즈베리파이에 모체로봇 코드 추가 후 프로그램 실행
