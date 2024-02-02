#!/bin/bash

: << 'END'
#!는 스크립트를 실행할 셸을 지정하는 선언문
/bin/bash는 bash명령의 절대 경로
 = /bin/bash의 셸로 스크립트를 작성하겠다는 선언

* 여기서 /bin은유닉스 계열의 기본적인 명령어(프로그램)들이 위치한 디렉토리


[문제 설명]
현 디렉토리(test)에'test1.log'과 'test2.log' 파일이 있을 때,
이 파일들을 'backup_test'라는 폴더(없으면 생성하여)에 자동으로 백업하는 셸 스크립트를 만들려고 한다.
END


if ! [ -d backup_test ]; then           # 만약 현재 디렉토리에 'backup_test'라는 디렉토리가 없다면
        mkdir backup_test               # 'backup_test'디렉토리를 만들어라.
fi                                      # 조건문 종료

cp *.log backup_test                    # 현 디렉토리에 있는 모든 로그파일 backup_test 디렉토리에 복사
echo 'log file backup complite.'        # 해당 구문 출력


: << 'E'
./backup_t.sh 로 실행하거나
sh일 경우 sh backup_t.sh 로 실행

실행이 안될경우, chmod 755 backup.sh 로 실행 권한 부여
E