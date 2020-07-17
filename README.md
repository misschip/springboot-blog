# Spring Boot 프로젝트에 사용할 라이브러리

### Spring Starter Project 시작시 선택할 라이브러리
Spring Web
Spring Devtool
Lombok
MySql
MyBatis

### MVNRepository에서 가져올 라이브러리
---------------------
JSTL
Tomcat-Embed-Jasper
(둘다 xml에서 버전 부분은 삭제!!)

---------------------
# Table 생성

````sql
create user 'spring'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
create database spring;
use spring;
````

````sql
CREATE TABLE user(
	id int auto_increment primary key,
    username varchar(100) unique not null,
    password varchar(100) not null,
    email varchar(100),
    profile varchar(200),
    createDate timestamp
) engine=InnoDB default charset=utf8;
````

````sql
CREATE TABLE post(
	id int auto_increment primary key,
    title varchar(100) not null,
    content longtext,
    userId int,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null
) engine=InnoDB default charset=utf8;
````

````sql
CREATE TABLE comment(
	id int auto_increment primary key,
    userId int,
    postId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null,
    foreign key (postId) references post (id) on delete cascade
) engine=InnoDB default charset=utf8;
````



# 이후 단계

### (1) yml 확장자 변경
 - port와 context-path 잡기
 - DB 연결 정보 넣기
 - JSP View 경로 설정 (ViewResolver)

### (2) config 폴더 생성
 - DataSourceConfig.java (참고: yml 설정을 참고)
 - DataAccessConfig.java (참고: DataSource와 Mapper)

### (3) Mapper 경로에 user.xml 생성 및 파일 세팅

### (4) UserRepository.java 생성

### (5) TestController 생성 및 테스트
/src/main/webapp/WEB-INF/views/
	/src/main/webapp/ - tomcat embedded jasper가 인식하는 부분
	/WEB-INF/views/ 는 prefix 부분