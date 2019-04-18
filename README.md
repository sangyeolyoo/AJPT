# AJPT
- 개요 : 출근 시간, 바쁜 사용자를 대신해서 일기예보를 확인한 후 준비물(우산, 마스크)를 챙길 수 있도록 알려주는 알림 서비스
- 설명 : 공공데이터포털 오픈 API인 동네예보조회, 대기오염정보조회 서비스를 이용해서 출근 시간의 기상상태를 호가인하고 Telegram으로 메시지를 전달하는 프로젝트

## App.java
- Telegram, Weather, Dust 를 불러 실행 / 출력문 포맷 함수

## Weather.java, Dust.java
- 공공데이터포털에 동네예보정보조회 서비스, 대기오염정보조회 서비스를 이용하기 위한 정보

## Telegram.java
- Telegram으로 메시지 전송

## Api.java
- API 연결

# 참고
-https://www.data.go.kr/
-https://core.telegram.org/bots/api
