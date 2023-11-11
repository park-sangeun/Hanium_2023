# 관제 서버 사용 방법
>intelliJ idea community 환경에서 gradle 사용

### 기본 사항
* open jdk 11 (java 11)
* mysql server 8.0.
* springboot 2.7.14

### springboot 환경 설정
https://start.spring.io/ 접속 
* Project: Gradle - Groovy
* Language: Java
* Spring Boot: 2.7.14 (변경 가능)
* Project metadata: 사용자 기호에 맞게 변경
* Packaging: jar
* Java: 11
* Dependencies: Spring Data JPA, Tyhmeleaf, lombok, gradle
로 설정한 후 생성

### IntelliJ 설정
1. IntelliJ를 열어 다운받은 springboot를 연다.
2. File-Settings-Build, Execution, Deployment-Build Tools-Gradle 에서 Gradle JVM을 JAVA_HOME 또는 11로 변경한다.
3. File-Settings-Build, Execution, Deployment-Compiler-Java Compiler에서 모든 버전을 11로 변경한다.
4. File-Project Structure-SDK에서 11로 설정한다.

### application.yml 설정
1. server port를 작성한다 (현재 8080으로 설정)
2. mysql에 생성한 사용자 정보, 비밀번호를 입력한다 (현재 username: babyssu, password:'0000'으로 설정)
3. database의 이름을 작성한다 (현재 examples 데이터베이스를 기본주소인 localhost:3306에서 제작되어있음)
```
server:
  port: 8080
# database 연동 설정
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    #    각자 PC에 만들어놓은 Database이름을 써야 합니다.
    url: jdbc:mysql://localhost:3306/[Database name]?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
    #    mysql에 생성한 사용자 계정 정보를 써야 합니다.
    username: [외부 접근 허용한 사용자 계정]
    password: '[비밀번호는 따옴표 안에 작성]'
...
```

### Mysql 사용자 생성
cmd 접속
```
mysql -u root -p #root로 접속 
use mysql;	# mysql 기본 스키마 선택
select user, host from user;	# 사용자 목록 조회, 외부 접근을 허용하는 사용자 아이디가 있는지 확인
create user 'babyssu'@'%' identified by'0000'; #외부 접근 가능한 사용자 생성 (현재 user: babyssu password: 0000)
```

### DB 및 Table 생성
```
create database examples; (현재 DB name: examples) 
GRANT ALL PRIVILEGES ON `examples`.* TO 'babyssu'@'%' WITH GRANT OPTION; #사용자에 권한 부여
show grants for 'babyssu'@'%'; #권한 부여되었는지 확인
```

Mysql workbench에서 MySQL Connection 추가
* Connection name: 원하는 것으로 사용 가능
* username: 생성한 user (현재 babyssu)
* test connection에 비밀번호 입력 시 successfully이면 계정 생성

### 서버 실행
1. idLogin2.zip을 풀어 intelliJ에 열기
2. intelliJ에서 run 눌러 서버 실행
