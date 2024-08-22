## application/port/out
- 네이밍: ~OutPort
- 인터페이스로 adapter와 통신하는 영역
- 영속성 처리, rest 외부통신, 다른 도메인 요청 등
- 메서드 시그니쳐
    - 입력: 도메인 모델, 도메인 모델 id
    - 출력: 영속성 객체(entity)