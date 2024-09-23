# open jdk 17 버전의 환경을 구성
FROM openjdk:17

# tzdata 패키지 설치 및 타임존 설정
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo Asia/Seoul > /etc/timezone

# build가 되는 시점에 JAR_FILE이라는 변수 명에 build/libs/*.jar 선언
# build/libs - gradle로 빌드했을 때 jar 파일이 생성되는 경로
ARG JAR_FILE=build/libs/traveltracker-0.0.1-SNAPSHOT.jar

# JAR_FILE을 agaproject.jar로 복사
COPY ${JAR_FILE} traveltracker.jar

# 운영 및 개발에서 사용되는 환경 설정을 분리
# -Duser.timezone=Asia/Seoul JVM 옵션을 사용하여 애플리케이션 수준에서도 타임존을 설정
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=deploy", "-Dserver.port=8080", "-Duser.timezone=Asia/Seoul", "/traveltracker.jar"]