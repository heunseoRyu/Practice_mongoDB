MongoDB 사용법

https://velog.io/@joonghyun/Springboot-MongoDB-Springboot%EC%99%80-MongoDB-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0

https://jsonobject.tistory.com/484

⭐️ - https://velog.io/@tekies09/SpringBoot-%EC%97%90%EC%84%9C-mongoDB-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0


발생했던 문제 

1. import가 안됨.. 분영 import문은 잘 썼는데 막 다 빨간글씨로 되어 있음.

-> dependencies 다 지우고 중복된 구문 없는지 정리한 다음에 다시 실행

2. Exception authenticating MongoCredential{mechanism=SCRAM-SHA-256, userName='root', source='admin', password=<hidden>, mechanismProperties=<hidden>}] with root cause

-> (1) https://greedydeveloper.tistory.com/337

-> (2) https://note-jm.tistory.com/12

-> (3) uri는 계정이 저장된 admin db의 경로로 설정하고 database는 실제 데이터를 저장할 db로 설정
