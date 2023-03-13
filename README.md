# kp-server

## 실행 방법

### 1. spring profiles

`local`, `dev` 중 실행하고 싶은 환경을 JVM 환경변수로 넣어준 후 실행.

- example
```bash
-Dspring.profiles.active=local
```

### 2. local mysql

로컬에서 `dev` 환경으로 테스트하고 싶은 경우, docker-compose 이용하여 local mysql 띄운 후 서버 실행

```bash
$ docker compose up -d
```

## 배포 방법

- TODO


## 커밋 메시지 규칙

1. 형식

   > `[타입]`: `[내용]`

2. 예시

   > docs: OO메소드 관련 설명 주석
   >
   > feature: 예약 시스템의 add()

3. 타입 종류

   > \- chore : 간단한 수정
   >
   > \- feature : 새로운 기능
   >
   > \- fix : 버그 대처
   >
   > \- refactor : 코드 수정 / 리팩터링
   >
   > \- test : 테스트 추가
   >
   > \- docs : 문서 작성

## 컨벤션

git-flow 를 따르되, 가장 기본적인 feature, develop, main 브랜치만 사용

- feature: 각각 기능에 대한 개발 브랜치
- develop: 개발용 서버 배포용 브랜치
- main: 개발 & 테스트 완료 후 최종 브랜치

1. 새로운 작업을 하기 위해 develop 브랜치에서 새로운 feature 브랜치를 생성한다.
2. 작업이 완료되어 테스트하고 싶은 경우 develop 브랜치로 머지 하여 개발용 서버에 배포
3. 개발 및 테스트 최종 완료 시 main 브랜치로 머지
