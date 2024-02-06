#!/bin/bash

# while 문 사용
:<<'END'
echo "값을 입력하세요. :"

i=1
read number

echo " "
echo "[ $number 단출력] "
echo " "

while [ $i -lt 10 ]
do
        value=`expr $number \* $i`      	# 변수 입력할 때 띄어쓰기 하면 인식 못함   ex) value = `expr ~~~` 인식 못함
        echo "$number * $i =  $value"   	# `expr 연산자` 형태가 산술 계산하는 방법
        i=`expr $i + 1`                 		# *(곱셈부호)는 특수문자로 분류되어 '*' 또는 "*" 또는 \* 로 사용하여야 한다.
done

END



# for 문 사용
echo "값을 입력하세요. :"
read number

echo -e "  \n[ $number 단출력] \n"            # 한 줄에 줄 바꾸고 싶다면 -e 옵션을 사용해서 \n 사용하기

for((i=1; i<10; i++))
do
        value=`expr $number \* $i`
        echo "$number * $i = $value"
done