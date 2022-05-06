# Github 배운 내용 정리

'''
ls             현재 위치한 경로 안의 내용 출력
pwd            현재 어떤 디렉토리 경로에 있는지를 절대경로로 표시 

cd 위치        작업 디렉토리의 위치 변경
cd or cd~      자신의 홈 디렉토리로 이동
cd/            최상위 루트디렉토리(/)로 이동
cd .           현재 폴더
cd ..          한단계 상위 폴더

mkdir          딜렉토리(폴더) 만들기
touch          파일 만들기
mv             이동하기

mv *.md coffee        확장자가 md인 파일들을 coffee로 옮겨라
mv server.* coffee    서버라는 이름이 들어간 파일을 coffee로 옮겨라
mv                    이름변경 (mv hello.py ./holla.py)

cp         복사하기

rm         삭제하기  (디렉토리는 삭제 못함)
rm -r      삭제하고 싶은 디렉토리의 하위 파일까지 삭제
rm -rf     물어보는 것까지 스킵하여 삭제

.파일이름: 숨김파일 (보는방법 : ls -a)

노말/ shift y 그 줄 복사
노말/ shift p 붙여넣기
노말/ dd 그 줄 삭제

shift; : command mode
q!저장하지 않고 나가기

cat: 셸에서 파일 내용 확인할 때
clear : 셸 내용 지우기
'''

#커밋 메시지 제목
'''
feat: 새로운 기능을 추가할 경우
fix: 버그를 고친 경우
docs: 문서 수정한 경우
style: 코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우
refactor: 프로덕션 코드 리팩터링
test: 테스트 추가, 테스트 리팩터링 (프로덕션 코드 변경 없음)
chore: 빌드 테스크 업데이트, 패키지 매니저 설정할 경우 (프로덕션 코드 변경 없음)

'''


'''
git clone 주소
git branch 이름
git switch branch이름   commit까지 진행후 main으로 복귀
git merge branch이름

git config —list

git status      add,commit,push 하기 전마다 수시로 실행하여 체크
git add
git commit
git push origin main 

git restore 
git reset HEAD
git commit —amend
git revert —no-commit HEAD~취소할 commit갯수   잘못올린 commit 수정하는 방법
git remote / git remote -v  origin위치 확인

python ~  잘 실행되나 확인
git lg
'''
