# Dutch-pay-it-server
2023 GDSC SCH 연합 토이 프로젝트 C팀 - [더치페it]
# GDSC-SCH 연합 토이 프로젝트 C팀

---

# Team Member

<aside>
<img src="/icons/phone_blue.svg" alt="/icons/phone_blue.svg" width="40px" /> **APP**

</aside>

<aside>
🙍🏻‍♂️ 한윤섭

</aside>

<aside>
🙎🏻‍♀️ 임채민

</aside>

<aside>
<img src="/icons/brain_blue.svg" alt="/icons/brain_blue.svg" width="40px" /> **ML**

</aside>

<aside>
🤵🏻‍♂️ 문하늘

</aside>

<aside>
👨🏻‍💻 박민혁

</aside>

<aside>
<img src="/icons/server_blue.svg" alt="/icons/server_blue.svg" width="40px" /> **BE**

</aside>

<aside>
👩🏻‍🎓 송지영

</aside>

<aside>
🧑🏻‍💻 이현수 / 최재원

</aside>

# Project

$$
|
$$

$$
Dutch Pay It
$$

$$
|
$$

- 카메라로 영수증 사진을 찍어서 메뉴/수량별 더치페이 기능
- 영수증의 메뉴/항목을 구별하기 위해 ML 오픈소스 활용
- 더치페이를 하기 전에 정산내역서를 사용자에게 보여주는 기능
- 홈화면, 식당명 및 구성원 입력창 & 사진 인식 확인, 정산내역서 화면

### 1. API 명세서

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fe660e1b-db1f-4336-9aa8-cb816151d303/Untitled.png)

---

---

![KakaoTalk_20230122_234722240.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0f2523bb-9986-43aa-8137-2d3dc43bc402/KakaoTalk_20230122_234722240.jpg)

### 2. API 명세서

[](https://www.notion.so/cc0e3f0e179a4e30892b421d206f3670) 

### 3. ERD

[gdscToy.png](https://drive.google.com/file/d/1GZxJka9MoumsKC-_lhIHd26Ekr7UH8-S/view?usp=drivesdk)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0c6ba6a0-9d0f-4330-a83e-dab34eb34906/Untitled.png)

# Technical Stack

- APP

![https://origogi.github.io/assets/images/flutter_dart.png](https://origogi.github.io/assets/images/flutter_dart.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/622ae06c-c110-4c9a-8802-0e69c0bc2304/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e4c47ca5-7e7e-4319-a2e4-9e822ff3c010/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/38cda9f8-40d4-450c-9c4d-bca5c0698972/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cf3f9a33-4249-497a-9729-2a248f4612c3/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e29f1c9b-6d66-43ca-ae4c-d31ba6a77759/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f242ce67-c0c7-4dc2-8778-f2e622deef82/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ea80fe80-bad7-4b80-a10b-86ffad54a8e9/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/22ce6cfb-ac4a-44c2-b6fc-be36a26efeef/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c2f884cd-350c-422d-830e-a176e71f55f7/Untitled.png)

- BE

→ 서버 구조

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/da6ed616-c7de-4e2f-a662-c2322c7c7a0e/Untitled.png)

- ML
1. 영역 추출

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/326918fd-2dab-49c4-b542-2b2dd05f5616/Untitled.png)

1. OCR 모델 성능향상을 위해 위미지 위치 변환 

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cf83ca5b-d87c-4a15-9016-ce847a6bea95/Untitled.png)

1. 영역 추출을 위해 종횡비를 정하여 특정부분 영역 추출 & OCR 테스트

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f978f0a8-8532-44a2-86e4-f27678c80ab4/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2ddee2c6-9ed2-4e8d-a976-8717bf7ffd1f/Untitled.png)

1. 서버에 query문을 활용하여 DB에 정상적으로 업로드

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1230f472-6575-4604-923c-c8d9c24fd82f/Untitled.png)

# Simulation

[녹화_2023_02_06_18_20_59_95.mp4](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a01e2e80-187c-41f9-a7eb-c6e656d93c6d/%EB%85%B9%ED%99%94_2023_02_06_18_20_59_95.mp4)

# Trouble Shooting

- APP
    - Flutter 와 ML을 연동하기 위해 tflite_flutter를 사용하려고 했지만, 한국어 인식이 어려워 ML을 서버와 연동하였다.
    - Navigator로 앱 내에서 데이터를 주고 받으려고 라이브러리를 사용했지만, 생각보다 오류가 많이 나타나서 GetX로 페이지 이동 및 데이터 처리를 하였다.
    - 메뉴 정보 목록에 구성원을 추가했지만 화면을 이동할때마다 기존의 api 데이터 값으로 모두 초기화되는 현상이 발생하였다. 코드 분석 결과 futurebuilder의 future값에 비동기 함수를 넣어서 발생한 문제였다. 화면이 초기에 렌더링될때만 api 데이터를 받아오고 그 이후에는 구성원 리스트를 수정할 수 있도록 initState() 내부에 비동기 함수를 분리하여 작성하였다.
- BE
    - Database를 스터디 때 배웠던 h2를 사용했는데, 배포할 때 찾아보다가 h2는 실습용으로 많이 사용하고 다른 Database를 사용한다고 해서 MariaDB로 바꾸는 작업을 수행하였다.
    - 쿼리에서 가게명과 메뉴명이 일치하는 항목을 찾으려고 하는데 path설정을 잘못해서 500error가 떴다.  PathVariable 어노테이션을 썼기 때문에 get/all/shop/menu로 수정하였다.
    - EC2로만 DB를 구축하려고 했으나, AWS에서 지원하는 RDB 서비스가 있어 그것을 이용해 서버 내 데이터베이스를 구축하였다.
    - 흔히알고 있는 DB의 SQL문과 다르게 자바 스프링에서는 JPQL이라는 객체DB 문법이 따로있어 쉬운 SQL을 구현하기도 어려웠다. 제대로 객체를 이해하고 공식 문서를 참고하여 해결하였다.
    - ML 모델을 적용하기 위해서 파이썬 서버와 통신하는 과정에서 소켓 통신으로 구현하려 하였지만 언어 차이로 인해 통신이 쉽지 않았다. 많은 시간을 할애하여 고민한 끝에 바이트로 이미지만 전송하고 파이썬 서버에서는 디비에 직접 접근하는 법으로 스프링 서버로 받아올 수 있었다.
- ML
    - 영수증의 영역 추출 부분에서 영수증의 내용 배치가 모두 다르기 때문에 정확한 정보만을 추출하기 어려웠다. 이를 고려하여 영수증의 규격을 정하고 추출하기로 함 이후 Tensorflow Lite딥러닝 모델을 사용하여 영역 추출을 하기로 했다.
    - 모바일에 올릴 가벼운 OCR 모델을 선정하는 과정에서 Tensorlite OCR 모델 고려하였지만 한국어를 지원하지 않아 비교적 정확한 한국어를 인식하는 Tesseract를 사용하기로 결정했다.
    - 사진의 빛, 선명도, 구도가 모두 다르기 때문에 적절한 OCR 결과를 얻을 수 없어 이미지의 테두리를 인식하여 위치를 변환하고 OCR를 수행하여 정확도를 높였다.

# Feedback

<aside>
🙍🏻‍♂️ 한윤섭

</aside>

- APP
    
    Flutter 프레임워크로 앱을 만들어 프로젝트하는 경험은 처음이었습니다. 앱 개발에 관심이 있다고하지만, 직접 UI / UX를 디자인하고 앱의 전반적인 것들을 개발해보니 막상 어려운 부분이 꽤 있었습니다. 하지만 어려운 부분들을 팀원들과 함께 공유하며 직접 해결방안을 찾는 과정이 도움이 많이 되었고  다양한 라이브러리를 활용하면서 Flutter에 대한 프레임워크 이해와 Dart 지식 또한 얻을 수 있었던 프로젝트였습니다.
    

<aside>
🙎🏻‍♀️ 임채민

</aside>

- APP
    
    이번 프로젝트는 앱 뿐만 아니라 다른 직군과 협업한 첫 프로젝트였습니다. 프로젝트를 진행하기 전에는 매주 진행되는 수업의 간단한 예제를 만들 수 있는 정도였기에 팀에 민폐가 되지 않으려고 열심히 공부했던 것 같습니다. 앱을 개발하며 수많은 오류가 발생하였는데 그럴때마다 stackoverflow를 뒤져가며 코드를 수정하고 개선하면서 단기간에 급성장할 수 있었습니다. 밤낮으로 삽질하면서 오류를 수정하고 어려운 기능을 구현하는 과정에서 자연스럽게 이론적인 개념도 체득되는 것을 느꼈습니다. 다만 아직 기본기가 부족해서 비동기 처리나 HTTP 통신 기능을 구현할 때 오랜 시간이 걸렸다는 것, 세부적인 기능 구현에 집중하느라 전체적인 흐름을 놓칠 뻔한 점이 아쉽습니다. 더 체계적이고 좋은 앱을 만들기 위해서는 Dart언어와 CS 이론을 더 공부해야겠다고 느꼈습니다. 
    

<aside>
👩🏻‍🎓 송지영

</aside>

- BE
    
    ERD를 작성할 때 연관관계 매핑하는게 어려웠는데, 개발 시작하고나서 ERD 작성을 또 수정해야 되는 번거로움이 있었습니다. 이 과정에서 설계의 중요성을 배웠습니다. 새로운 프레임워크를 배운지 얼마 안되서 해본 첫 프로젝트라서 어설프지만 이렇게 직접 해보면서 배운거라 더 공부가 되고 기억에 남을 것 같습니다. 부족한 실력이지만 모르는 부분 물어볼때 마다 도움주신 분들께 감사드립니다.
    

<aside>
🧑🏻‍💻 이현수

</aside>

- BE
    
    ERD, 즉 테이블을 구성하는것에서 많이 부족하다고 느꼈습니다. 코드의 경우 열심히 구글링을 하면 늘거나 해결이 가능한 부분이 많지만, 테이블을 구성하고 테이블간 연관관계를 만드는 등의 작업에서는 경험 부족으로 인해 생겨나는 한계가 많았다고 생각합니다. 앞으로 더 다양한 프로젝트를 진행하며 기초적인 테이블을 더 실용적으로 구성할 수 있는 능력이 생길 수 있도록 보완해야 할 것 같습니다.
    

<aside>
🧚🏻‍♂️ 최재원

</aside>

- BE
    
    컴퓨터전공 수업을 들으며 ERD설계, 소켓통신 등을 배웠지만 프로젝트에 막상 구현을 못하니 너무 답답했고 부족함을 느꼈다. 구글링만으로 여러 언어를 연결하거나 서비스를 지원하는건 벅찼고 확실히 언어와 구조의 전반적인 이해가 필요하다 생각했다. 많은 시간을 할애한것에 비해 결과물은 너무 초라해서 박탈감을 느꼈지만 짧은시간내에 많은 성장을 했다고 생각한다.
    

<aside>
🤵🏻‍♂️ 문하늘

</aside>

- ML
    
     여러분야가 모두 모여 하나의 프로젝트를 하다보니 정보를 주고 받는 통신 부분에서 많은 어려움과 부족한 점을 느낀 것 같습니다. 어떤 부분을 보완해야할지 알 수 있었던 아주 유익한 시간이었습니다. 감사합니다. 
    

<aside>
👨🏻‍💻 박민혁

</aside>

- ML
    
    처음 프로젝트를 접했을 때는 할만하겠다고 생각했다. 하지만 그때도 우려했던 부분이 프론트, 백엔드, 머신러닝 파트를 각각 어떻게 연결할 것인가 이게 고민이었다. 우선 내가 해야 될 부분을 끝내 놓고 생각하자는 생각이 들었고, ML 파트는 생각보다 순조롭게 진행되었다. 문제는 역시 3파트를 어떻게 통신할 것인가였다. 소켓, POST, GET, 앱 탑재 등 여러 가지 방법을 다 해봤지만 쉽지 않았다. 통신하는 양쪽이 프로토콜을 정하고 그에 따라 통신을 하면 된다는 간단한 이론이지만 언어도 다르고 그에 따른 규격도 조금씩 달라서 더 애를 먹었던 것 같다. 시간이 더 있다면 지금보다 좋은 결과가 있을 것 같아 아쉽다.
    

# Schedule

[일정](https://www.notion.so/5bd50b16d18146118ff439ebde015db4)

# Tasks

<aside>
🙍🏻‍♂️ 한윤섭

</aside>

- 와이어프레임 작성
- UI 구성 및 디자인
- HTTP 통신
- FlashScreen 구현
- GetX
- Textfield 추가 구현
- 정산서 UI 추가 구현
- Camera 구현

<aside>
🙎🏻‍♀️ 임채민

</aside>

- 와이어프레임 작성
- UI 구성 및 디자인
- HTTP 통신
- Navigator
- GET 데이터 메뉴별 목록 생성
- 구성원 추가 및 선택 기능 구현
- 정산서 초기 UI 구현

---

<aside>
🤵🏻‍♂️ 문하늘

</aside>

- OCR Model 테스트
- TCP socket 통신 구현
- 이미지 outline 영역추출

<aside>
👨🏻‍💻 박민혁

</aside>

- OCR Model 전처리
- TCP socket 통신 구현
- 텍스트 추출

---

<aside>
👩🏻‍🎓 송지영

</aside>

- ERD 작성
- API 명세서 작성
- Spring 프로젝트 세팅
- [People] 테이블 생성
- CRUD 작성
- MariaDB
- 배포 및 서버 테스트

<aside>
🧑🏻‍💻 이현수

</aside>

- ERD 작성
- API 명세서 작성
- [User, Menu, People] 
테이블 생성
- CRUD 작성
- AWS EC2
- 배포 및 서버 테스트

<aside>
🧚🏻‍♂️ 최재원

</aside>

- ERD 작성
- API 명세서 작성
- 쿼리문 작성
- [People] 테이블 생성
- CRUD 작성
- User_key response 구현
- Image POST API 구현
- ML 파이썬과 JAVA 소켓통신 구현

---
