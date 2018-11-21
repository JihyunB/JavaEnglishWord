# JavaEnglishWord
JavaEnglishWord는 Java를 이용한 영어단어 학습 프로그램입니다.

EnglishHelper/src
main_menu.java 에서 swing 컴포넌트를 활용하여 GUI로 메인메뉴 화면이 구현되어 있습니다.
각 버튼을 클릭하면 해당 메뉴로 연결되며 메뉴를 구현한 코드는 (메뉴이름).java에 구현 했습니다.
showTable.java는 테이블 객체를 구현하기 위해 작성하였고, getWord.java는 파일 입출력에 사용할 객체를 위해 작성되었습니다.


EnglishHelper/word
영어단어의 목록이 wordlist.txt 파일에 저장되어 있습니다. 프로그램에서 단어를 추가 할 수도 있고
직접 txt파일을 형식에 맞게 수정하여 사용 할 수도 있습니다. userRank.txt는 test메뉴에서 시험을 본
결과를 저장하여 지난 사용자들의 정답률과 비교하여 순위를 매겨줍니다. 새로운 레코드가 발생하면 userRank.txt 파일 전체가
갱신됩니다. 이는 User.java에 구현되어 있습니다.

EnglishHelper/images
GUI 구현에 사용 된 이미지들이 저장되어 있습니다.
