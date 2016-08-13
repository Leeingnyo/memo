# Memo Application

안드로이드 연습용 프로젝트 (다른 사람들 연습하라고 만든)

## 어플리케이션 설명

1. 제목, 설명, 날짜 를 적을 수 있는 메모를 작성하고 저장한다.
2. 리스트에서 선택한 메모를 상세하게 볼 수 있다.

### 배울 수 있는 것

* 필요한 xml 작성하기
* 리스너
  * onClickListener
  * onCheckedChangeListener
  * onLongClickListener (준비 중)
* Intent 활용
  * 다른 액티비티로 가기
  * 다른 액티비티에 정보 전송
    * Palcelable 사용
* 액티비티 라이프 사이클
  * onCreate() 에서 할 일
  * onResume() 에서 할 일
* 리사이클러 뷰
  * gradle에 디펜던시 라이브러리 추가하기
  * 어댑터 뷰와 어댑터
  * 아이템을 위한 뷰 만들기
* 싱글톤 패턴
  * 여러 액티비티에서 쓰이는 자원 관리하기
* 파일 저장
  * Shared Preference (준비 중)
  * 클래스에 Serialiszable을 implement한 다음 bytes로 저장
* 기타
  * Spannable 사용
  * 다이알로그 (준비 중)
  * custom view

### 부족한 점

* 빈 액티비티에서 시작하지 않고 android studio가 정해주는 액티비티에서 시작해버렸다
* 깃 로그를 남기지 않아 발전 과정 등이 남아있지 않다
* 폴더를 나누지 않았다

### 고칠 점

* title input single line
* theme
* 메모 삭제
* 메모 수정
