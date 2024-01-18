# 기본 명령어

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




>  `pwd` ( print name of current/working directory )
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
  [$ cd ..]: 상위 디렉토리로 이동
  [$ cd .]: 현재 위치로 이동 (= 새로고침)
  [$ cd -]: 이전에 위치한 디렉토리로 이동 (= 뒤로가기)
  [$ cd /]: root 디렉토리로 이동
  [$ cd ~]: 홈 디렉토리로 이동
  [$ cd .디렉토리]: 숨겨진 디렉토리로 이동
```

</details><br><br><br>



> `ls`  ( list )
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
$ cat [options] [파일1] [파일2]...[파일ㅜ]
```

<details><summary>접기/펼치기</summary>

- 리다이렉션
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

---------------------------------------------------------------------------------------------------

* 주요 옵션
  -n : 줄 번호를 화면 왼쪽에 나타냄(비어있는 행도 포함 / -b는 비어있는 행 제외)
  -s : 두 줄 이상의 연속되는 빈 행을 1줄로 출력
  -A : -vET 옵션과 같은 효과
       -v : tab과 행 바꿈 문자(\r , ^M)를 제외한 제어 문자를 ^형태로 출력
       -E : 행마다 끝에 $ 출력
       -T : tab 문자를 출력
```

</details><br><br><br>











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
  []:

* 주요 옵션
  -k : 
      ex) $ ls -al
       >> .  ..  .hidden_dir  .hidden_file.txt  test_script.sh
```

</details><br><br><br>
-->
