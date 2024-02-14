<div align='center'>
<img src="https://capsule-render.vercel.app/api?type=transparent&color=timeAuto&height=100&section=header&fontSize=50&descAlign=57&descSize=20&descAlignY=83&text=Linux%20Study&desc=Basic%20command"/>

</div>

## vi 명령어
> `vi` (또는 `vim`)에서 사용하는 단축키 정리

<details><summary>자세히 보기</summary>

- 모든 단축키는 `Esc 키`를 누른 `표준모드 진입 상태`에서 진행

1. `이동` 관련 단축키

    - 원하는 줄로 이동 :ㅤㅤ`: 줄 번호`ㅤㅤorㅤㅤ`줄 번호 G`

    - 파일의 맨 첫 줄로 이동 :ㅤㅤ `gg`

    - 파일의 맨 끝 줄로 이동 :ㅤㅤ`G`

    - 현재 줄의 첫 문자로 이동 :ㅤㅤ`^`ㅤㅤorㅤㅤ`Home 키`

    - 현재 줄의 마지막 문자로 이동 :ㅤㅤ`$`ㅤㅤorㅤㅤ`End 키`

<br>

2. `편집` 관련 단축키
   
    - 블록(영역) 지정:ㅤㅤ`v`

    - 멀티 커서 생성 :ㅤㅤ`Ctrl + v`ㅤㅤorㅤㅤ`Ctrl + q`

    - 복사 :ㅤㅤ`y`

    - 단어 잘라내기 :ㅤㅤ`x`

    - 블록 잘라내기 :ㅤㅤ`d`

    - 붙여넣기 :ㅤㅤ`p`

    - 되돌리기 :ㅤㅤ`u`

    - 앞으로가기 :ㅤㅤ`Ctrl + r`

<br>

3. `검색` 관련 단축키
   
    - 줄 수 표시:ㅤㅤ`:set nu`

    - 커서 위/아래로 검색어 찾기:ㅤㅤ`:/검색어`ㅤ/ㅤ`:/검색어` 

    - 다음/이전 검색어 찾기 :ㅤㅤ`n`ㅤ/ㅤ`N`


</details><br><br>








## 리눅스 내부 명령어
> `man`      ( manual )
<p>: 궁금한 명령어 또는 파일에 대한 옵션 및 사용법을 출력</p>

``` Linux
$ man [options] [section] [명령어 or 파일]
```
<details><summary>자세히 보기</summary>

``` Linux
* 사용법
  [Spacebar]: 한 페이지 밑으로 내려감
  [b]: 전 페이지로 올라감
  [화살표 위/아래]: 한 줄 단위로 이동
  [Enter]: 한 줄 밑으로 내림
  [k]: 한 줄 위로 올라감
  [h]: 도움말
  [/]+키워드: 키워드 검색 
  [q]: 나가기


* 주요 옵션
  -k : apropos(완전히 일치하지는 않아도 대략적으로 비슷한 단어)에 해당하는 메뉴얼 페이지 출력
  -f : 해당 키워드와 정확히 일치하는 메뉴얼 페이지 출력
  -w : 'man 키워드 실행 시 출력되는 메뉴얼 페이지'의 파일 경로를 출력
  -s : 특정 section을 지정할 때 사용, 보통 -s 입력안하고 '$ man 숫자 명령어'처럼 사용
```
</details>
<br><br><br>




>  `pwd` ( print working directory )
<p>: 현재 위치한 디렉토리의 절대 경로를 출력</p>

``` Linux
$ pwd [options]
```

<details><summary>접기/펼치기</summary>
  
``` Linux
* 사용 예시
  $ pwd
  >> /root/test

* 주요 옵션
  -L : 심볼릭 링크가 포함된 논리 경로 출력  (default)
  -P : 심볼릭 링크 없이 실제 물리 경로만 출력
```

</details><br><br><br>



> `cd`  ( change directory )
<p>: 현재 작업중인 디렉토리의 위치를 이동</p>

``` Linux
$ cd [이동할 경로]
```

<details><summary>접기/펼치기</summary>
  
``` Linux
* 사용법
  $ cd ..: 상위 디렉토리로 이동
  $ cd .: 현재 위치로 이동 (= 새로고침)
  $ cd -: 이전에 위치한 디렉토리로 이동 (= 뒤로가기)
  $ cd /: root 디렉토리로 이동
  $ cd ~: 홈 디렉토리로 이동
  $ cd .디렉토리: 숨겨진 디렉토리로 이동
```

</details><br><br><br>



> `ls`  ( list segments )
<p>: 현재 위치한 디렉토리의 내용(디렉토리, 파일 등)을 출력</p>

``` Linux
$ ls [options] [디렉토리 or 파일]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 사용 예시
  $ ls
  >> test_script.sh

* 주요 옵션
  -l : 각 파일의 자세한 내용(모드, 링크 수, 소유자, 그룹, 크기(바이트), 최종 수정 시간) 출력   (ll 명령어와 동일)
      ex) $ ls -l    (또는 ll)
       >> -rwxr-xr-x 1 root root 32  1월 17 09:44 test_script.sh
  -a : 디렉토리의 숨겨진 항목까지 모두 출력
      ex) $ ls -a
       >> .  ..  .hidden_dir  .hidden_file.txt  test_script.sh
  -R : 하위 디렉토리의 파일까지 모두 출력
  -s : 각 항목의 크기를 kb 단위를 포함하여 출력
  -t : 최종 수정 시간을 기준으로 출력 (new >> old)
  -r : 역알파벳순으로 출력 
```

</details><br><br><br>



> `mkdir`  ( make directory )
<p>: 디렉토리 생성</p>

``` Linux
$ mkdir [options] [생성할 디렉토리]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 주요 옵션
  -p : 상위 경로(디렉토리)도 함께 생성
      ex) $ mkdir -p test1/test2
  -v : 디렉토리를 생성하고 생성된 디렉토리에 대한 메시지 출력
      ex) $ mkdir -v test2
       >> mkdir: created directory `test2'
  -m : 디렉토리 생성 + 권한 설정 (default: 755)
```

</details><br><br><br>


> `cat`  ( concatenate )
<p>: 파일의 내용을 출력</p>

``` Linux
$ cat [options] [파일1] [파일2]...[파일n]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 주요 옵션
  -n : 줄 번호를 화면 왼쪽에 나타냄(비어있는 행도 포함 / -b는 비어있는 행 제외)
  -s : 두 줄 이상의 연속되는 빈 행을 1줄로 출력
  -A : -vET 옵션과 같은 효과
       -v : tab과 행 바꿈 문자(\r , ^M)를 제외한 제어 문자를 ^형태로 출력
       -E : 행마다 끝에 $ 출력
       -T : tab 문자를 출력
```
</details>

<details><summary>IO Redirection</summary>
    
![redirection](https://github.com/Kim-SeongSu/Self-study_and_Review/assets/104110605/8a44696d-84e2-4e00-b68c-43b33b81b29b)

``` Linux
* 리다이렉션 사용 예시

1. 파일 생성 및 덮어쓰기
  $ cat > test1.txt
    여기에 내용을 입력
    없는 파일이면 생성, 있는 파일이면 덮어쓰기
    다 입력하면 ctr + d로 종료
  $ cat > test1.txt
    >> 여기에 내용을 입력
       없는 파일이면 생성, 있는 파일이면 덮어쓰기
       다 입력하면 ctr + d로 종료


2. 파일 이어쓰기
  $ cat >> test1.txt
    한 줄 더 추가
  $ cat > test1.txt
    >> 여기에 내용을 입력
       없는 파일이면 생성, 있는 파일이면 덮어쓰기
       다 입력하면 ctr + d(EOF 키)로 종료
       한 줄 더 추가


3. 기존의 파일 여러개를 하나로 합쳐 새로운 파일 / 다른 파일 이어쓰기
  $ cat [파일1] [파일2] > [새로운 파일]
    : 새로운 파일에 두 파일 합치기      (3 = 1 2)
  $ cat [파일1] 더 추가하고싶은 내용 [파일2] > [파일3]
    : 파일3 파일1 더 추가하고싶은 내용 파일2 
  $ cat [파일1] [파일2] >> [파일3]
    : 파일3에 파일1과 파일2를 이어붙이기 (3 1 2 순)

```
<br>
+ 응용 하기
<br><br>

<p align="center" width="100%">
    <img width="40%" height="250" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FMvS0h%2FbtqUeVRgYk4%2Fx0ayD6315BcJ3flKLkGSFk%2Fimg.png">
</p>

| File | File Descriptor |
|:--:|:--:|
| **STDIN** (standard input) | **0** |
| **STDOUT** (standard output) | **1** |
| **STDERR** (standard error) | **2** |

``` Linux
# 현 디렉토리의 파일명을 리다이렉션을 사용해 저장 
  $ ll -al > dirctory_file_list.txt

# >는 사실 1> (1은 STDOUT; 즉, ll -al 명령어를 통해 터미널에 출력되는 내용)
  $ ll -al 1> dirctory_file_list.txt

# 이러한 이유로 error를 입력할 때는 2(STDERR)를 입력하면 된다.
  $ cat not_exist_file.txt 2> dirctory_file_list.txt
```
[참고 자료](https://www.opentutorials.org/course/2598/14199)



</details><br><br><br>


> `mv`  ( move )
<p>: 파일이나 디렉토리를 이동</p>

``` Linux
$ mv [options] [이동할 파일1] [이동할 파일2]...[이동할 파일n] [이동 될 위치]
  * 경로를 지정하지 않으면 현재 위치가 default
```

<details><summary>접기/펼치기</summary>

``` Linux
* 사용법
  $ mv [원래파일위치/이름] [파일위치/변경할이름] : 파일 또는 디렉토리명 변경

* 주요 옵션
  -r : 하위 디렉토리까지 전부 이동
  -n : 이동 될 위치에 같은 이름을 갖는 파일이 있을 경우, 덮어쓰기를 하지 않는다
  -b : 이동 될 위치에 같은 이름을 갖는 파일이 있을 경우, 백업 파일 생성
      ex) $ mv test1.txt /user/study/test2.txt
          $ ls
            >> ~test2.txt(원래 파일)  test2.txt(새로 이동한 파일)
  -f : 이동 될 위치에 같은 이름을 갖는 파일이 있을 경우, 강제로 덮어쓰기
  -i : 이동 될 위치에 같은 이름을 갖는 파일이 있을 경우, 덮어쓰기 여부 물어봄
```

</details><br><br><br>



> `cp`  ( copy )
<p>: 디렉토리 또는 파일 복사 </p>

``` Linux
$ cp [options] [복사 할 디렉토리/파일] [복사 될 디렉토리/파일]
  * 경로를 지정하지 않으면 현재 위치가 default
```

<details><summary>접기/펼치기</summary>

``` Linux
* 사용법
  $ cp [복사대상 1] [복사대상 2] ... [복사대상 n] [복사될 경로] : 해당 경로로 여러개 한번에 복사

* 주요 옵션
  -r : 하위 디렉토리까지 전부 복사
  -b : 복사 될 위치에 같은 이름을 갖는 파일이 있을 경우, 백업파일 생성
  -f : 복사 될 위치에 같은 이름을 갖는 파일이 있을 경우, 강제로 덮어쓰기
  -i : 복사 될 위치에 같은 이름을 갖는 파일이 있을 경우, 덮어쓰기 여부 물어봄
  -a : 원본 파일의 속성, 링크 정보까지 복사
  -p : 원본 파일의 모든 정보를 복사
```

</details><br><br><br>


> `rm`  ( remove )
<p>: 디렉토리 또는 파일 삭제 </p>

``` Linux
$ rm [options] [삭제 할 명령어 or 파일]
```

<details><summary>접기/펼치기</summary>

``` Linux
  
* 사용법
  $ rm [삭제 대상1] ... [삭제 대상 n] : n개 삭제
  $ rm *.txt : .txt로 끝나는 모든 파일 삭제
  $ rm -rf * : 현재 위치의 모든 파일 삭제

* 주요 옵션
  -f : 강제 삭제
  -r : 디렉토리 내부의 모든 파일도 삭제
  -d : 비어있는 디렉토리만 삭제
  -i : 삭제할 때 마다 삭제 여부 물어보기
  -v : 삭제되는 대상의 정보 출력


* rmdir 은 '비어있는' 디렉토리를 삭제하는 명령어로,
    rmdir -p /a/b/c 는 rmdir /a/b/c /a/b /a 와 같다.

```

</details><br><br><br>


> `clear`  ( clear )
<p>: 터미널의 내용 지우기 </p>

``` Linux
$ clear
```
<br><br><br>


> `more`  ( more )
<p>: 파일의 내용을 페이지 단위로 끊어서 보기</p>

``` Linux
$ more [options] [파일]
```

<details><summary>접기/펼치기</summary>

``` Linux
  
* 사용법
  [Spacebar] or [f]: 다음 페이지로 이동
  [b]: 이전 페이지로 이동
  [=]: 현재 줄 번호 표시
  [v]: vi 에디터로 실행
  [숫자 + z]: 숫자줄 만큼 다음으로 이동
  [q]: 나가기

  [/ + 키워드]: 키워드에 해당하는 문자열 찾기
  [n]: 다음으로 발견된 문자열 찾기
  [']: 이전에 발견된 문자열 찾기

* 주요 옵션
  -p : 페이지를 이동할 때, 화면을 이어서 출력하지 않고 새로고침으로 출력
  -숫자 : 입력한 숫자만큼 출력 줄 수 제한
  -s : 여러 줄의 공백 한 줄로 표시
```

</details><br><br><br>


> `touch`  ( touch )
<p>: 빈 파일을 생성하거나 파일의 날짜와 시간을 수정</p>

``` Linux
$ touch [options] [파일]
```

<details><summary>접기/펼치기</summary>

``` Linux
  
* 사용법
  $ touch [생성 or 수정 파일1] ... [생성 or 수정 파일n] : n개 파일 생성 or 수정
  $ touch * : 현 위치의 모든 파일 수정
  $ touch *.txt : txt로 끝나는 모든 파일 수정

* 주요 옵션
  -m : 파일의 수정 시간과 변경 시간을 현재 시간으로 수정
  -t : 파일의 수정시간과 접근 시간을 지정한 시간으로, 변경 시간을 현재 시간으로 수정

```

</details><br><br><br>



> `echo`  ( echo )
<p>: 주어진 문자열을 화면에 출력</p>

``` Linux
$ touch [options] [문자열]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 사용 예시
  $ echo apple is red.
  >> apple is red.

  $ echo "apple is (red or green)."ㅤㅤㅤㅤ* 특수문자 또는 매우 긴 문자열의 경우 큰따옴표(" ") 사용
  >> apple is (red or green).


* 사용법
  $ echo "내용" > [파일명] : 입력 내용을 해당 파일 생성 또는 덮어쓰기
  $ echo "내용" >> [파일명] : 입력 내용을 해당 파일 생성 또는 이어쓰기

```

</details><br><br><br>



> `alias`  ( 별칭 )
<p>: 사용자가 명령어를 다른 이름으로 바꿔 사용할 수 있게 이름 변경</p>

``` Linux
$ alias [입력 설정]
```

<details><summary>접기/펼치기</summary>

``` Linux
  
* 사용법
  $ alias : 명령어 별칭 확인
  $ alias [지정할 명령어 별칭]='명령어' : 명령어 별칭 등록
  $ unalias [지정했던 명령어 별칭]: 명령어 별칭 해제

```
<br>

* alias 별칭 영구 등록하는 방법 <br>
ㅤ`ls -al` 로 `./bashrc 파일`을 찾아 아래 내용 추가 후 `source ~/.bashrc`명령어로 동기화 해주기

``` Linux
# .bashrc 
alias la='ls -al' 
# Source global definitions 
if [ -f /etc/bashrc ]; then
. /etc/bashrc 
fi 

# Uncomment the following line if you don't like systemctl's auto-paging feature: 
# export SYSTEMD_PAGER= 
# User specific aliases and functions ~
```

</details><br><br><br>



> `chmod`  ( change mode )
<p>: 디렉토리나 파일의 시스템 모드를 변경</p>

``` Linux
$ chmod [options] [mode] [디렉토리 or 파일]
```
<details><summary>접기/펼치기</summary>

``` Linux
  
* 사용법
  $ chmod [숫자 표기법] [디렉토리 또는 파일] :
     ex) chmod 755 test_01.txt
  $ chmod [문자 표기법] [디렉토리 또는 파일] :
     ex) chmod g+wr test_02.txt

```

<details><summary>chmod 숫자 표기법 설명</summary>
<div align='center'>
    
![image](https://github.com/Kim-SeongSu/Self-study_and_Review/assets/104110605/5ce5fa06-de87-47e2-bccb-faeaa66dc57e)</div>

```linux
$ chmod 754 test_01.txt

파일 소유 사용자 권한: 7 = 4 + 2 + 1
파일 소유 그룹 권한 : 5 = 4 + 1
그 외 사용자 권한 : 4 = 4
```
</details>

<details><summary>chmod 문자 표기법 설명</summary>
    <div align='center'>
        
![image](https://github.com/Kim-SeongSu/Self-study_and_Review/assets/104110605/82e521ae-2c26-482d-bc57-06c6ecd0129f)</div>

```linux
$ chmod u+rwx test_01.txt
  : 파일 소유 사용자에게 읽기,쓰기,실행 권한 부여

$ chmod g-w test_01.txt
  : 파일 소유 그룹에게 쓰기 권한 박탈

$ chmod a+r test_01.txt
  : 모든 사용자에게 읽기 권한 부여

$ chmod -R a-r,a+x test_01.txt
  : 현 디렉토리의 모든 파일의 모든 사용자에게 읽기 권한 박탈 및 실행 권한 부여
```


</details>

<details><summary>파일 상세 정보 설명</summary>
<div align='center'>
    
![image](https://github.com/Kim-SeongSu/Self-study_and_Review/assets/104110605/66566c7d-1b00-488b-aa77-95ddd123e086)</div>

- `파일 권한`

    - `-` (일반 파일) : 각종 텍스트 파일, 실행 파일, 이미지 파일 등
    - `d` (디렉토리) : 폴더 같은 개념 (리눅스에서는 폴더도 파일로 취급)
    - `l` (링크 파일) : 소프트 링크(심볼릭 링크, '바로가기'같은 역할)
    - `b` (블록형 장치파일) : ex) /dev/sda (디스크 파일)       (sda1,sda2,sdb,sdc,...등의 디스크 파티션도 마찬가지) 
    - `c` (문자형 파일) : ex) /dev/console (입출력 콘솔 파일)
    - `p` (파이프 파일) : ex) /run/systemd/initctl/fifo (파이프 파일)
<br>ㅤㅤㅤㅤㅤㅤㅤㅤ* 파이프: '파일1'의 결과를 '파일2'로 바로 적용시키는 것    ('ls | grep c'에서의 |가 파이프)
    - `s` (소켓 파일) : ex) /dev/log (소켓 파일)
<br>ㅤㅤ* 하드디스크,USB 같은 장치도 파일로 취급함!    (장치 파일은 /dev 디렉토리에 들어있음)


</details><br>

</details><br><br><br>



> `crontab`  ( cron table )
<p>: job 목록 및 cron daemon에 대한 다른 명령들이 보관 (cron: 유닉스 계열 컴퓨터 운영 체제의 시간 기반 잡 스케줄러)</p>

``` Linux
$ crontab [options]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 사용 예시
# 현재 시간을 알려주는 명령어 date를 1분에 한번씩 date.log에 입력하고자 할 때,
$ crontab -e 명령어로 설정파일에 들어간다.

<crontab 설정 파일>
     # ┌───────────── min (0 - 59)
     # │ ┌────────────── hour (0 - 23)
     # │ │ ┌─────────────── day of month (1 - 31)
     # │ │ │ ┌──────────────── month (1 - 12)
     # │ │ │ │ ┌───────────────── day of week (0 - 6) (0 to 6 are Sunday to Saturday, or use names; 7 is Sunday, the same as 0)
     # │ │ │ │ │
     # │ │ │ │ │
     # * * * * *  command to execute

* * * * * date >> /root/test/date.log 2>&1          # date 명령어를 실행했을 때, 정상적인 경우는 /root/test/date.log 파일에 붙여쓰기를
                                                      오류가 발생한 경우는 표준출력으로 오류 내용을 출력


# 저장하고 나온 뒤
$ service crond start 명령어로 실행
$ tail -f /root/test/date.log로 확인




* 주요 옵션
  -e : crontab 설정할 수 있는 에디터 화면 출력
  -l : 현재 크론탭 작업 목록 확인
  -r : 현재 설정된 크론탭 작업 모두 제거
```

* cron tab 작업 예시

<div align='center'>
  
| 예제 | 설명 |
|:--:|:--:|
|* * * * * /home/test.sh| 매분 마다 /home/test.sh 실행|
|30 1 * * 0 /home/test.sh| 매주 일요일 1시 30분 마다 /home/test.sh 실행|
|0 0,12 * * * /home/test.sh| 매일 자정, 정오 마다 /home/test.sh 실행|
|* */1 * * * /home/test.sh| 1시간 마다 /home/test.sh 실행|
|0-30 0 * * * /home/test.sh| 매일 자정 0~30분 동안 /home/test.sh 실행|

</div>

</details><br><br><br>

> `scp`  ( SecureCopy )
<p>: ssh 원격 프로토콜 기반 파일 전송 프로토콜</p>

``` Linux
$ scp [options] [파일명1]..[파일명n] [받는 계정 id]@[받는 계정 ip] : [전송 될 절대위치]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 주요 옵션
  -r : 디렉토리 내 모든 파일/디렉토리 복사
  -P : 포트 번호 지정 복사
  -c : 압축 복사
  -v : 전송 과정 출력 복사
  -a : 아카이브 모드 복사
      ex) $ ls -al
       >> .  ..  .hidden_dir  .hidden_file.txt  test_script.sh
```


</details><br><br><br>















## 유용한 명령문
> `현 디렉토리의 파일 수 세기`

``` Linux
$ ls -l | grep ^- | wc -l
```
<br><br>

> `현 디렉토리의 내용 변경 실시간 확인`

``` Linux
$ watch -d ls -l
```
<br><br>

> `파일 내용 변경 실시간 확인`

``` Linux
$ tail -f [파일명]
```
<br><br>




















<!--
> ``  (  )
<p>: </p>

``` Linux
$ man [options] [section] [명령어 or 파일]
```

<details><summary>접기/펼치기</summary>

``` Linux
* 사용 예시
  $ 
  >> 
  
* 사용법
  $ :

* 주요 옵션
  -k : 
      ex) $ ls -al
       >> .  ..  .hidden_dir  .hidden_file.txt  test_script.sh
```

</details><br><br><br>
-->
