# 소형 로봇 사용 방법
>Raspberry Pi OS 설치

### Rasberry Pi OS (32-bit) 설치
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

### PCA9685 제어 (PWM Driver)
1. 제어 라이브러리 설치
```
$ sudo apt-get install git build-essential python-dev
$ git clone https://github.com/adafruit/Adafruit_Python_PCA9685.git
$ cd Adafruit_Python_PCA9685
$ sudo python3 setup.py instal
```

### DHT11 제어
1. Adafruit_DHT 라이브러리 설치
```
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install python3-dev python3-pip
sudo pip3 install Adafruit_DHT
```
2. dht22 파일 실행

### 라즈베리파이 적외선 카메라 센서를 이용한 Streaming
1. streaming_final 파일 실행
2. "http://172.20.10.7:8000/streaming" 페이지로 external 접근하여 뷰 확인
3. 2번의 path와 self.path 맞춰주면 ('/streaming') 통신 가능

### 소형 로봇 실행
라즈베리파이에 소형로봇 코드 추가 후 프로그램 실행
