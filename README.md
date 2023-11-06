## spring-board 개인 과제

### 학습목표
1. 구현하고자 하는 서비스의 전체적인 흐름을 파악하고 필요한 기능을 설계할 수 있습니다.(Use Case Diagram, API 명세서, ERD를 작성할 수 있습니다.)
2. Spring Boot를 기반으로 CRUD(Create, Read, Update, Delete) 기능이 포함된 REST API를 만들 수 있습니다.

### 필수 요구 사항
- [x]  게시글 작성 기능
    - `제목`, `작성자명`, `비밀번호`, `작성 내용`, `작성일`을 저장할 수 있습니다.
    - 저장된 게시글의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [x]  선택한 게시글 조회 기능
    - 선택한 게시글의 정보를 조회할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [x]  게시글 목록 조회 기능
    - 등록된 게시글 전체를 조회할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
    - 조회된 게시글 목록은 작성일 기준 내림차순으로 정렬 되어있습니다.
- [x]  선택한 게시글 수정 기능
    - 선택한 게시글의 `제목`, `작성자명`, `작성 내용`을 수정할 수 있습니다.
        - 서버에 게시글 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 게시글의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 수정이 가능합니다.
    - 수정된 게시글의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [x]  선택한 게시글 삭제 기능
    - 선택한 게시글을 삭제할 수 있습니다.
        - 서버에 게시글 삭제를 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 게시글의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 삭제가 가능합니다.
        - 
### 추가 요구 사항
- [x]  선택한 게시글 수정 및 삭제 요청 시 비밀번호가 일치하지 않을 경우 API 요청 실패(예외상황)에 대해 판단할 수 있는 Status Code, Error 메시지등의 정보를 반환합니다.

### 1. Use Case Diagram
링크 : https://app.diagrams.net/#G184is9FzfZg01rvKNC-hzMSh6N2J7RIL1
![image](https://github.com/Binsreoun/spring-board/assets/69248377/2811ac72-b978-4b9d-b7d3-6d2fe997f72f)

### 2. ERD
링크 : https://www.erdcloud.com/d/gTEftvyRw8TESBFqx
![image](https://github.com/Binsreoun/spring-board/assets/69248377/4cb87b16-e54a-4e51-8a67-c8b2ded666df)

### 3. API 명세서
링크 : https://documenter.getpostman.com/view/30872998/2s9YXfb3Wf#9670828e-196c-4bd9-9945-e29e46eca95b
![image](https://github.com/Binsreoun/spring-board/assets/69248377/f5ae4cea-6ad2-421d-be89-aba13f85b067)




