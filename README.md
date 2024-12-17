# 📋 TodoList
- 사용자가 일정을 정리하고 관리할 수 있도록 도움을 주는 웹 페이지 입니다.
- 사용자는 일정을 추가, 관리, 삭제할 수 있으며 완료된 일정을 관리할 수 있습니다.  

<br><br>
## ✨ 현재 구현된 주요 기능  
- CRUD 기능과 DB 연동은 완료되었고, 일부 API 연동 완료 되었습니다.
- 프론트에서는 일정 추가와 목록 조회가 가능하지만 레이아웃과 체크박스 관련 등 나머지 기능은 완성되지 않았습니다.

  ## Backend
       ✅ 일정 저장
     
       ✅ 일정 삭제
    
       ✅ 일정 조회 (기본 : 일정 상태 전체 조회)
    
       ✅ 일정 조회 (필터링 : 완료 / 미완료 / 전체)
    
       ✅ 일정 수정 (중요한 일정인지 + 일정 내용)
    
       ✅ 일정 수정 (일정 완료 ↔ 미완료)  
  
  ## Frontend
       ✅ 일정 입력시 중요 일정 체크박스 구현
     
       ✅ 일정 입력 input + 버튼 구현
    
       ✅ 일정 목록 확인 구현
  
  ## Back + Front
       ✅ API 통신
          - DB에 저장된 일정 List 확인
          - 일정 입력 후 DB 저장  
<br>

## ⚒️ 프로젝트 설정 및 실행 방법  
🛠️ 개발 환경  
  - IDE : Eclipse / VSCode
  - Build Tool : Gradle
  - 데이터베이스 : MySQL
  - 백엔드 : Spring Boot v3
  - 프론트엔드 : React + Node.js + Ant-design

🖥️ 실행 방법  
       1) React 프로젝트 파일을 백엔드 프로젝트의 src/main/front 폴더에 저장  
       2) cmd 창에서 [ cd 백엔드 프로젝트 경로/src/main/front ] 로 이동한 뒤 npm install 명령어를 실행하여 React 프로젝트 의존성 설치  
       3) [ npm run build ] 명령어 입력하여 빌드  
       4) cmd 창에서 [ cd 백엔드 프로젝트 경로] 입력하여 경로 이동  
       5) [ gradlew.bat build ] 입력하여 빌드 실행  
       6) 5)번 빌드가 완료되면 백엔드 프로젝트의 build/libs 경로에 있는 todo-0.01-SNAPSHOT.jar파일 확인  
       7) [ java -jar todo-0.01-SNAPSHOT.jar] 실행하여 서버 실행  
       8) 실행 후 http://localhost:8080 (백엔드), http://localhost:3000 (프론트) 이동 시 어플리케이션 확인    

<br>
✅ DB 스키마와 기초 데이터는 깃허브 최상단 파일에 업로드 되어 있습니다!

<br>

## 🔧 프로젝트에 사용된 기술 스택  
### 백엔드  
- **Spring Boot**: RESTful API를 구현하기 위해 사용.  
- **Mybatis**: java와 SQL문을 분리시켜 코드의 가독성을 높이고 쿼리 간 mapping을 쉽게 할 수 있어서 사용  
- **Lombok** : getter, setter, toString()을 어노테이션으로 손쉽게 처리 가능  

### 프론트엔드  
- **React** : 요소를 컴포넌트화 시켜 코드의 재사용성 증가  
  - 현재 Todo List가 나오는 부분 / Todo item이 나오는 부분 컴포넌트화 했습니다.  
- **Ant-design**: 다양한 UI 컴포넌트를 손쉽게 활용 가능  
  
<br>

## 🗒️API 명세서
  🍀 깃허브 최상단 폴더에 .html로도 업로드 해두었습니다!
<details>
    <summary>API 명세서 이미지보기</summary>
  
<!-- summary 아래 한칸 공백 두고 내용 삽입 -->
  <img width="973" alt="1" src="https://github.com/user-attachments/assets/0dbd9e50-6b06-4e39-8900-717f2458ee50" />
  <img width="976" alt="2" src="https://github.com/user-attachments/assets/a6d223f2-7438-4cda-80d0-35e4c251fda4" />
  <img width="860" alt="3" src="https://github.com/user-attachments/assets/bc5afeec-3572-4587-b720-46ba282e2eb6" />
  <img width="863" alt="4" src="https://github.com/user-attachments/assets/2d4c12da-5b1b-43b7-b294-ef4113df125c" />
  <img width="869" alt="5" src="https://github.com/user-attachments/assets/8fb513b6-759c-43d1-9b54-7f1a5d465541" />
  <img width="869" alt="6" src="https://github.com/user-attachments/assets/353d6ad0-e17e-4054-a68f-89649ad2c0ce" />  

</details>
  
<br><br>
## 💡향후 개발 과제  
  - Todo  
    - 일정 완료 ↔ 미완료 변경 체크박스 구현  
    - 일정 수정 / 삭제 버튼  
    - 일정 필터링 동작  
    - 레이아웃 / CSS 적용  
  - 로그인 + 회원가입 기능  
  - 전체 기능 API 통신 완료  
    
