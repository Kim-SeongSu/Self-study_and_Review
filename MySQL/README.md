<div align='center'>
<img src="https://capsule-render.vercel.app/api?type=transparent&color=0:FF8C00,100:4682B4&height=100&section=header&fontSize=50&descSize=20&descAlign=60&descAlignY=83&text=SQL%20Study&desc=Basic%20grammar"/>
</div>
<br><br>


# SQL (Structured Query Language) 문법 정리 
- SQL은 관계형 데이터 모델을 따르는 DBMS의  표준 데이터베이스 언어
- 관계 대수를 기초로 만드러진 DB관련 명령어 형식
> [참고하면 좋은 사이트](https://tcpschool.com/mysql/intro)

<br>

## 1. SQL 명령어 

### 1) 데이터 정의어 (DDL, Data Definition Language)
-  데이터베이스나 테이블 등을 생성, 삭제하거나 그 구조를 변경하기 위한 명령어
-  데이터베이스를 정의하거나 수정
-  명령어 수행시 이전 상태로 복귀 불가
<details><summary>ㅤCREATEㅤ|ㅤALTERㅤ|ㅤDROPㅤ|ㅤTRUNCATE</summary>

<br>

> **`CREATE`**  ( DDL 명령어 - **생성** )
<p>: 데이터베이스 오브젝트 생성</p>

```MySQL
CREATE DATABASE [데이터베이스명];

CREATE TABLE [테이블명](
[필드명1] [자료형(크기)] NOT NULL AUTO_INCREMENT,
[필드명2] [자료형(크기)] NOT NULL,
[필드명3] [자료형(크기)] );
```

<details><summary>예시 보기</summary>

``` MySQL
CREATE TABLE emp_table
(   emp_id      NUMBER           NOT NULL,
    emp_name    VARCHAR2(100)    NOT NULL,
    gender      VARCHAR2(10)         NULL,
    age         NUMBER               NULL,
    hire_date   DATE                 NULL,
    etc         VARCHAR2(300)        NULL,
    PRIMARY KEY (emp_id)                  );
```

</details><br><br><br>

> **`ALTER`**  ( DDL 명령어 - **변경** )
<p>: 데이터베이스 오브젝트 변경</p>

```MySQL
ALTER TABLE [테이블명] RENAME [새 테이블명];

ALTER TABLE [테이블명] MODIFY COLUMN [필드명] [새 필드타입];

ALTER TABLE [테이블명] CHANGE COLUMN [필드명] [새 필드명] [새 필드타입];

ALTER TABLE [테이블명] ADD COLUMN [필드명] [필드타입];

ALTER TABLE [테이블명] DROP COLUMN [필드명];
```

<details><summary>예시 보기</summary>

``` MySQL
ALTER TABLE ex_table RENAME ex_table2;

ALTER TABLE ex_table MODIFY COLUMN ex_column varchar(16) NULL;

ALTER TABLE ex_table CHANGE COLUMN ex_column ex_column2 varchar(16) NULL;

ALTER TABLE ex_table ADD COLUMN ex_column varchar(32) NOT NULL;

ALTER TABLE ex_table DROP COLUMN ex_column;
```

</details><br><br><br>

> **`DROP`**  ( DDL 명령어 - **삭제** )
<p>: 데이터베이스 오브젝트 삭제</p>

```MySQL
DROP DATABASE [데이터베이스명];

DROP TABLE [테이블명];
```

<details><summary>예시 보기</summary>

``` MySQL
DROP DATABASE DB_test;

DROP TABLE test_1;

DROP TABLE if exists test_1

DROP user '사용자ID'@localhost;
```

</details><br><br><br>

> **`TRUNCATE`**  ( DDL 명령어 - **삭제** )
<p>: 데이터베이스 오브젝트의 내용 삭제</p>

```MySQL
TRUNCATE TABLE [테이블명];
```

<details><summary>예시 보기</summary>

``` MySQL
TRUNCATE TABLE test_1
```
[ 출력결과 ]
|ID|Name|ReserveDate|RoomNum|
|--|--|--|--|
|||||


<br><br><br>

</details><br><br><br>

</details><br>

### 2) 데이터 조작어 (DML, Data Manipulation Language)
   -  데이터베이스에 저장된 데이터를 처리하거나 조회, 검색하기 위한 명령어
   -  데이터를 검색, 삽입, 삭제, 갱신
  -  사용자와 데이터베이스 관리 시스템간의 인터페이스 제공
  -  트랜잭션 제어어를 활용하여 실행 전 상태로 복귀 가능

<details><summary>ㅤSELECTㅤ|ㅤINSERTㅤ|ㅤUPDATEㅤ|ㅤDELETE</summary>

<br>

> **`SELECT`**  ( DML 명령어 - **데이터 조회** )
<p>: 테이블의 내용을 조회</p>

```MySQL
SELECT [필드명] FROM [테이블명];
```

<details><summary>예시 보기</summary>

``` MySQL
SELECT * FROM []

SELECT DISTINCT [필드명] FROM [테이블명]

SELECT [필드명] AS [필드 별칭] FROM [테이블명]

SELECT [필드명1], [필드명2], ... FROM [테이블명] WHERE [필드명]=[조건값]
```

</details><br><br><br>

> **`INSERT`**  ( DML 명령어 - **데이터 삽입** )
<p>: 삽입 형태로 신규 데이터를 테이블에 저장</p>

```MySQL
INSERT INTO [테이블명]([필드명1], [필드명2], ...)
VALUES ([데이터값1], [데이터값2], ...);

INSERT INTO [테이블명]
VALUES ([데이터값1], [데이터값2], [데이터값3], ...);
```

<details><summary>예시 보기</summary>

``` MySQL
INSERT INTO Reservation VALUES(1, '이순신', '2016-02-16', 1108);

INSERT INTO Reservation(ID, Name) VALUES (3, '김유신');
```
[ 출력결과 ]
|ID|Name|ReserveDate|RoomNum|
|--|--|--|--|
|1|이순신|2016-02-16|1108|
|3|김유신|NULL|NULL|

</details><br><br><br>


> **`UPDATE`**  ( DML 명령어 - **데이터 수정** )
<p>: 데이터의 내용을 수정</p>

```MySQL
UPDATE [테이블명]
SET [업데이트 하고싶은 필드명1]=[업데이트 할 데이터값1], [업데이트 하고싶은 필드명2]=[업데이트 할 데이터값2], ...
WHERE [조건 필드명1]=[조건값1] and [조건 필드명2]=[조건값2] and ...;
```

<details><summary>예시 보기</summary>

``` MySQL
# 예제 1
UPDATE Reservation
SET RoomNum = 1592
WHERE Name = '이순신';

# 예제 2
UPDATE Reservation
SET RoomNum = 1592;

```
[ 출력결과 1]
|ID|Name|ReserveDate|RoomNum|
|--|--|--|--|
|1|이순신|2016-02-16|1592|
|2|김유신|2002-03-10|1543|
|3|이순신|2024-02-01|1592|

<br>

[ 출력결과 2]
|ID|Name|ReserveDate|RoomNum|
|--|--|--|--|
|1|이순신|2016-02-16|1592|
|2|김유신|2002-03-10|1592|
|3|이순신|2024-02-01|1592|

<br><br>

```MySQL
# leetcode 문제 예제
update Salary 
set sex = case sex when 'm' then 'f' else 'm' end
```


</details><br><br><br>

> **`DELETE`**  ( DML 명령어 - **데이터 삭제** )
<p>: 테이블의 내용을 삭제</p>

```MySQL
DELETE FROM [테이블명] WHERE [필드명]=[조건값];
```

<details><summary>예시 보기</summary>

``` MySQL
DELETE FROM Reservation WHERE Name = '홍길동';

DELETE FROM Reservation       (= TRUNCATE TABLE Reservation)
```
</details><br><br><br>

<br><br><br>

</details><br>


### 3) 데이터 제어어 (DCL, Data Control Language)
  -   무결성을 유지시키면서 내부적으로 여러가지 규정이나 제약조건 등을 기술하기 위해 사용되는 명령어
  -   사용자 별로 데이터베이스에 접근할 수 있는 권한을 부여하거나 회수 

<details><summary>ㅤGRANTㅤ|ㅤREVOKEㅤ|ㅤCOMMITㅤ|ㅤROLLBACK   </summary>

<br>

> **`GRANT`**  ( DCL 명령어 - **권한 부여** )
<p>: 데이터베이스 사용자에게 권한 부여</p>

```MySQL
GRANT [권한 범위] PRIVILEGES ON [DB명].[테이블명] TO [사용자ID@localhost];
```

<details><summary>예시 보기</summary>

``` MySQL
GRANT ALL PRIVILEGES ON test_db.* TO test_user@localhost;

GRANT SELECT,INSERT,UPDATE ON test_db.* TO test_user@localhost;

GRANT ALL PRIVILEGES ON *.* TO test_user@localhsost with grant option;
```

</details><br><br><br>

> **`REVOKE`**  ( DCL 명령어 - **권한 회수** )
<p>: 데이터베이스 사용자에게 권한 회수</p>

```MySQL
REVOKE [권한 범위] ON [DB명].[테이블명] TO [사용자ID@localhost];
```

<details><summary>예시 보기</summary>

``` MySQL
REVOKE ALL ON *.* FROM 'root'@localhost;
```

[참고 링크](https://dev-coco.tistory.com/53)  

</details><br><br><br>

> **`COMMIT`**
<p>: 트랜잭션의 작업이 정상적으로 완료되었음을 알림</p>

```MySQL
COMMIT;
```
<br><br><br>

> **`ROLLBACK`**  
<p>: 트랜잭션의 작업이 비정상적으로 종료 되었을 때 원래의 상태로 복구</p>

```MySQL
ROLLBACK;
```
<br><br>
</details><br>


### 4) 그 외의 명령어
- Database 및 Table과 관련된 명령어
<details><summary>ㅤUSEㅤ|ㅤSHOWㅤ|ㅤDESCㅤ|ㅤSQL dump & importㅤ</summary>
<br>

> **`USE`**
<p>: 사용할 데이터베이스를 선택하는 명령어</p>

```MySQL
USE [데이터베이스명];
```
<br><br>
> **`SHOW`**
<p>: 모든 DB 또는 TABLE을 보여주는 명령어</p>

```MySQL
SHOW DATABASES;

SHOW TABLES;
```
<br><br>
> **`DESC`**
<p>: TABLE의 구조를 보는 명령어</p>

```MySQL
DESC [테이블명];

DESCRIBE [테이블명];

EXPLAIN [테이블명];
```
<br><br>
> **`SQL dump & import`**
<p>: dump 파일(서버에 기억된 내용의 일부 or 전부를 저장해둔 파일)을 통해 backup 및 import 가능</p>

```MySQL
# MySQL
## DB 전체 dump
$ mysqldump -u[사용자 id] -p'[password]' [DB명] > [저장할 파일명.sql]
   * 비밀번호는 꼭 입력 안해도 나중에 입력 가능

## 특정 DB의 schema dump
$ mysqldump -u[사용자 id] -p -d [DB명] > [저장할 파일명.sql]

## 특정 테이블 dump
$ mysqldump -u[사용자 id] -p [DB명] [테이블명] > [저장할 파일명.sql]




## 전체 스키마(DB) import
$ mysql -u[사용자 id] -p [DB명] < [덤프파일명.sql]

## 특정 테이블 import
$ mysql -u[사용자 id] -p -[DB명]=[테이블명] < [덤프파일명.sql]

```
<br>

```PostgreSQL
# PostgresSQL
## 특정 DB dump
$ pg_dump [DB명] > [저장할 파일명.sql]

## 모든 DB dump
$ pg_dumpall > [저장할 파일명.sql]




## 특정 DB import
$ psql [DB명] < [덤프파일명.sql]
     * 오류 발생 시 작업 정지 옵션: ON_ERROR_STOP
     * 오류 발생 시 모든 작업 취소 옵션: single-transaction
$ psql --set ON_ERROR_STOP=1 --single-transaction [DB명] < [덤프파일명.sql]
```

<details><summary>예시 보기</summary>

``` MySQL
# MySQL
## 특정 DB dump
mysqldump -uroot -p'password' -d DB_test > DB_test_mysqldump.sql

## 특정 DB import
mysql -h ndsap -u root -p DB_test < DB_test_mysqldump.sql
```
</details><br><br><br>


<br><br><br>
</details><br>

## 2. SQL 함수

<br>

> **`ORDER BY`**
<p>: 정렬하기</p>

```MySQL
ORDER BY ASC(오름차순,기본값) 또는  DESC(내림차순)
   * 여러 조건으로 정렬할 경우, 우선 적용할 컬럼 순서로 기입
```

<details><summary>예시 보기</summary>

``` MySQL
SELECT P.PRODUCT_CODE, P.PRICE*SUM(O.SALES_AMOUNT) AS SALES
FROM PRODUCT P
    INNER JOIN OFFLINE_SALE O
    ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE
```
</details><br><br><br>


> **`Alias`**
<p>: 별칭 부여하기</p>

```MySQL
# SELECT, FROM의 필드명 또는 SubQuery 뒤에 사용
[컬럼명 / SubQuery] (AS) [별칭]

* WHERE 절에는 사용불가
* 별칭에 공백, 특수문자, 대문자를 입력하기 위해서는 큰따옴표(" ") 안에 입력해야 함! (작은 따옴표 X)
```
<br><br><br>


> **`GROUP BY`**
<p>: 그룹화 하기</p>

```MySQL
GROUP BY [필드명]  HAVING [조건]
```

<details><summary>예시 보기</summary>

``` MySQL
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) as 'count' 
FROM ANIMAL_INS
/*
# 방법1
 WHERE ANIMAL_TYPE IN ('Cat', 'Dog')
*/

# 방법 2
WHERE ANIMAL_TYPE = 'Cat' OR ANIMAL_TYPE = 'Dog'
GROUP BY ANIMAL_TYPE 
ORDER BY ANIMAL_TYPE
```
<br>

**- GROUP BY 연계 함수**

|Name|Description|Name|Description|
|:--:|:--:|:--:|:--:|
|**AVG**|Return the average value of the argument|**SUM**|Return the sum|
|**MIN**|Return the minimum value|**MAX**|Return the maximum value|
|**COUNT**|Return a count of the number of rows returend|**GROUP_CONCAT**|Return a concatenated string|
|**STD** or STDDEV or STDDEV_POP|Return the population standard deviation|STDDEV_SAMP|Return the sample standard deviation|
|BIT_AND|Return bitwise and|BIT_OR|Return bitwise or|
|**VARIANCE** or  VAR_POP|Return the population standard variance|VAR_SAMP|Return the sample variance|
|BIT_XOR|Return bitwise xor|||

</details><br><br><br>


> **`DISTINCT`**
<p>: 중복값 제외</p>

```MySQL
DISTINCT [필드명] 
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT COUNT(DISTINCT NAME) AS CNT FROM ANIMAL_INS WHERE NOT ISNULL(NAME)
```
</details><br><br><br>


> **`LIMIT`** / **`OFFSET`**
<p>: Paging (원하는 위치의 원하는 갯수의 데이터 가져오기)</p>

```MySQL
LIMIT [n] OFFSET [n]
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 3 OFFSET 5   # 5부터 3개의 데이터 가져오기
```
</details><br><br><br>


> **`AVG`**
<p>: 평균값 구하기</p>

```MySQL
AVG([필드명])
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = 'SUV'
```
</details><br><br><br>


> **`ISNULL`**
<p>: 빈값찾기</p>

```MySQL
ISNULL([필드명], [NULL일 경우 대체할 값])
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE ISNULL(NAME)
```
</details><br><br><br>


> **`IFNULL`** or **`COALESCE`**
<p>: 빈값채우기</p>

```MySQL
# MySQL 함수
IFNULL([필드명],[대체할 값])

# 표준 SQL 함수
COALESCE([필드명1],[필드명2],,...,[필드명n])   #필드명1이 NULL이면 필드명2가, 필드명2가 NULL이라면 필드명3가 반환되는 형식
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
SELECT ANIMAL_TYPE, IFNULL(NAME,'No name'), SEX_UPON_INTAKE FROM ANIMAL_INS ORDER BY ANIMAL_ID

# PostgreSQL
SELECT name FROM Customer WHERE COALESCE(referee_id, 0) != 2
```
</details><br><br><br>


> **`DATE_FORMAT`** or **`TO_CHAR`**
<p>: 날짜 출력형식 변경</p>

```MySQL
# MySQL
DATE_FORMAT([필드명],입력 형식)

# PostgreSQL
TO_CHAR([필드명],입력 형식)
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
SELECT  HISTORY_ID,
        CAR_ID,
        LEFT(START_DATE,10) AS START_DATE,
        DATE_FORMAT(END_DATE,'%Y-%m-%d') AS END_DATE,
        CASE WHEN DATEDIFF(END_DATE,START_DATE)+1 < 30 THEN '단기 대여'
            ELSE '장기 대여' END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE LEFT(START_DATE,7)='2022-09'
ORDER BY HISTORY_ID DESC

# PostgreSQL
SELECT 
    TO_CHAR(trans_date, 'yyyy-mm') AS month,
    country, 
    COUNT(state) AS trans_count,
    COUNT(state) FILTER(WHERE state='approved') AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE WHEN state='approved' THEN amount ELSE 0 END) AS approved_total_amount
FROM Transactions
GROUP BY 1, 2
```

<div align = 'center'>

|format type|MySQL|PostgreSQL|format type|MySQL|PostgreSQL|
|:--:|:--:|:--:|:--:|:--:|:--:|
|**%Y**|년도 (2021)|**YYYY**|**%y**|년도 (21)|**YY**|
|**%M**|월 (January, August)|**MON**|**%m**|월 (01, 02, 11)|-|
|**%b**|월(Jan, Aug)|-|**%c**|월 (1, 8)|**MM**|
|**%W**|요일(Wednesday, friday)|-|**%a**|요일(Wed, Fri)|**DY**|
|**%d**|일(01, 19)|-|**%e**|일(1, 19)|**DD**|
|**%T**|시간 (12:30:00)|-|**%r**|시간 (12:30:00 AM)|-|
|**%H**|24시간 시간(01, 14, 18)|**HH24**|**%l**|12시간 시간 (01, 02, 06)|**HH12**|
|**%i**|분 (00)|**MI**|**%S**|초 (00)|**SS**|

</div>
</details><br><br><br>


> **`DATEDIFF`**
<p>: 시간 차이 계산</p>

```MySQL
DATEDIFF(날짜1,날짜2)
TIMEDIFF(날짜1,날짜2)
PERIOD_DIFF(날짜1,날짜2)
TIMESTAMPDIFF(단위,시간1,시간2)
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID HAVING AVERAGE_DURATION >=7 
ORDER BY AVERAGE_DURATION DESC , CAR_ID DESC
```
[TIMESTAMPDIFF 단위]

|format type|description|format type|description|
|:--:|:--:|:--:|:--:|
|YEAR|년|QUARTER|분기|
|MONTH|월|WEEK|주|
|DAY|일|HOUR|시|
|MINUTE|분|SECOND|초|

</details><br><br><br>

> **`DATE_ADD`**  /  **`INTERVAL`**
<p>: 날짜 더하기, 빼기</p>

```MySQL
# MySQL
DATE_ADD([필드명], 숫자)

#PostgreSQL
[필드명] + 또는 - INTERVAL '숫자   날짜 형식'
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
SELECT ROUND(COUNT(*) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity
WHERE (player_id, event_date) IN   (SELECT player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY)
                                    FROM Activity
                                    GROUP BY player_id)

#PostgreSQL
SELECT ROUND(COUNT(DISTINCT player_id)::numeric / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity
WHERE (player_id, event_date - INTERVAL '1 DAY') IN (SELECT player_id, MIN(event_date) AS first_login FROM Activity GROUP BY player_id)
```
</details><br><br><br>


> **`CASE`**
<p>: 여러 조건에 맞게 값 변경하기</p>

```MySQL
CASE WHEN [필드명] [조건] THEN [대체값1]
     WHEN [필드명] [조건] THEN [대체값2]
     ...
     ELSE [대체값n] END
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
        CASE WHEN STATUS = 'SALE' THEN '판매중'
             WHEN STATUS = 'RESERVED' THEN '예약중' 
             ELSE '거래완료' 
             END
FROM USED_GOODS_BOARD
WHERE CREATED_DATE LIKE '2022-10-05%'
```
</details><br><br><br>

> **`IF`**
<p>: 조건에 맞게 값 출력하기</p>

```MySQL
# MySQL 함수
IF([조건문], [참일 때 값], [거짓일 때 값])

```
<details><summary>예시 보기</summary>

``` MySQL
SELECT S.user_id,round(avg(if(C.action = 'confirmed',1,0)),2) AS confirmation_rate 
FROM Signups S
    LEFT JOIN Confirmations C
    ON S.user_id = C.user_id
GROUP BY S.user_id
```
</details><br><br><br>



> **`CONCAT`**
<p>: 문자열 합치기</p>

```MySQL
# 단순 문자열 합치기
CONCAT(문자열1, 문자열2,...,문자열n)

# 구분자로 문자열 합치기
CONCAT_WS('구분자', 문자열1, 문자열2,...,문자열n)

# 그룹핑하여 추출한 문자열 합치기
GROUP_CONCAT( (distinct) 필드명 (order by ~) (SEPARATOR '구분자') ) 
```
<details><summary>예시 보기</summary>

``` MySQL
# CONCAT
SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH 
FROM USED_GOODS_FILE F 
    INNER JOIN USED_GOODS_BOARD B
            ON B.BOARD_ID = F.BOARD_ID
WHERE B.VIEWS = (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD)


# CONCAT_WS
SELECT U.USER_ID, U.NICKNAME, CONCAT_WS(' ',U.CITY, U.STREET_ADDRESS1, U.STREET_ADDRESS2) AS 전체주소, CONCAT_WS(' ',LEFT(U.TLNO,3),SUBSTR(U.TLNO,4,4),RIGHT(U.TLNO,4)) AS 전화번호
FROM USED_GOODS_BOARD B
    INNER JOIN USED_GOODS_USER U
    ON B.WRITER_ID = U.USER_ID 
GROUP BY B.WRITER_ID HAVING COUNT(B.BOARD_ID) > 2
ORDER BY B.WRITER_ID DESC
```
</details><br><br><br>


> **`GROUP_CONCAT`** / **`STRING_AGG`** / **`ARRAY_AGG`** 
<p>: 그룹화 된 컬럼값들을 지정자로 구분하여 합침</p>

```MySQL
# MySQL
GROUP_CONCAT((distinct) [필드명] (separator '구분자') (order by 필드명))  # default 구분자는 ','
   									   GROUP_CONCAT([필드명], '구분자' order by [필드명])으로 사용해도 됨. (구분자와 order by 사이에 콤마(,) 없음!!)

#PostgreSQL
STRING_AGG((distinct) [필드명] ,'구분자' (order by 필드명))  				# STRING_AGG는 구분자(seperator) 필수 지정
ARRAY_AGG((distinct) [필드명] (,'구분자') (order by 필드명))
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
select sell_date, count(distinct product) num_sold, group_concat(distinct product) products
# PostgreSQL
select sell_date, count(distinct product) num_sold, string_agg(distinct product, ',') products
from Activities
group by sell_date
order by 1
```
</details><br><br><br>


> **`BETWEEN`**
<p>: 특정 범위 지정 구문</p>

```MySQL
BETWEEN [범위 시작] AND [범위 끝]
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT P.product_id, IFNULL(round(sum(P.price*U.units)/sum(U.units),2),0) AS average_price
FROM Prices P
    LEFT JOIN UnitsSold U
    ON P.product_id = U.product_id
        AND U.purchase_date BETWEEN P.start_date AND P.end_date
GROUP BY P.product_id
```
</details><br><br><br>


> **`CAST`**
<p>: 타입 변경 함수</p>

```MySQL
# SQL 표준 함수
CAST([변환할 값] AS [데이터형식])

# PostgreSQL 함수
:: [데이터 형식]
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT P.product_id, COALESCE(ROUND(cast(sum(P.price * U.units) as numeric) /sum(U.units),2),0) AS average_price

/*
- PostgreSQL의 경우,
SELECT P.product_id, COALESCE(ROUND(sum(P.price * U.units :: numeric) /sum(U.units),2),0) AS average_price
로 간략하게 표현 가능
*/

FROM Prices P
    LEFT JOIN UnitsSold U
    ON P.product_id = U.product_id
    AND U.purchase_date BETWEEN P.start_date and P.end_date
GROUP BY P.product_id
```

|SQL 표준 데이터형식|설명|
|:--:|:--:|
|BINARY|이진 데이터|
|**CHAR**|**문자열 타입**|
|DATA|날짜|
|DATATIME|날짜 & 시간|
|DECIMAL|소수점 까지|
|JSON|JSON 타입 SIGEND|
|**INTEGER**|**정수형**|
|**NUMERIC**|**실수형**|
|TIME|시간 UNSIGNED INTEGER (양의 정수형)|

</details><br><br><br>


> **`JOIN`**
<p>: 여러 테이블을 하나의 테이블로 합치기</p>

```MySQL
첫번째 테이블 이름
    INNER JOIN 두번째 테이블 이름     # MySQL의 경우, INNER JOIN, JOIN, CROSS JOIN이 같은 의미로 사용
    ON 조건                          # WHERE 절에서 사용할 수 있는 모든 조건 사용 가능

    LEFT JOIN 두번째 테이블 이름
    ON 조건

    RIGHT JOIN 두번째 테이블 이름
    ON 조건
```
<details><summary>예시 보기</summary>
<br>

<div align='center'>
    <img 
        src= "https://velog.velcdn.com/images/youjung/post/2710318f-dd8a-4e37-91ee-efb4d05713e2/image.png"
        style="width:75%; height:60%;"
    />
</div><br>

``` MySQL
SELECT stu.student_id, stu.student_name, sub.subject_name, COALESCE(COUNT(ex.subject_name),0) AS attended_exams
FROM Students stu
    CROSS JOIN Subjects sub
    LEFT JOIN Examinations ex
    ON  stu.student_id = ex.student_id and sub.subject_name = ex.subject_name
GROUP BY stu.student_id, stu.student_name, sub.subject_name
```
</details><br><br><br>


> **`UNION`**
<p>: 여러 개의 SELECT 문의 결과를 하나의 테이블로 통합</p>

```MySQL
SELECT 필드이름 FROM 테이블이름
UNION       # 중복된 레코드에 대해 DISTINCT 자동 적용
UNION ALL   # 중복된 레코드까지 모두 출력
SELECT 필드이름 FROM 테이블이름
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT U.FLAVOR
FROM (SELECT * FROM FIRST_HALF UNION ALL SELECT * FROM JULY) U
GROUP BY 1
ORDER BY SUM(U.TOTAL_ORDER) DESC
LIMIT 3
```
</details><br><br><br>


> **`@사용자 정의 변수`** (사용자 변수)
<p>: 사용자가 지정하여 사용할 수 있는 변수</p>

```MySQL
SET @[변수명] := [변수 초기값]   또는   FROM (SELECT @[변수명] := [변수 초기값]) 으로 변수 지정
```
<details><summary>예시 보기</summary>

``` MySQL
# 0 ~ 10의 수가 들어간 필드를 만들고 싶다면,
## 방법 1: SET으로 변수 정의하고 초기값 할당
SET @num = 0;

SELECT (@num = @num +1) AS number
FROM USER_INFO

## 방법 2: 한번 실행되는 FROM 절의 in-line view에서 변수 정의 및 초기화
SELECT (@num = @num +1) AS number
FROM 
```
</details><br><br><br>


> **`OVER 절`**
<p>: WINDOW 함수를 적용하기 전에 행 집합의 분할과 순서를 결정</p>

```MySQL
OVER (   
       [ <PARTITION BY clause> ]   # 쿼리 결과 집합을 파티션으로 분할
       [ <ORDER BY clause> ]       # 쿼리 결과 집합의 각 파티션 내에서 행의 논리적 순서를 정의
       [ <ROW or RANGE clause> ]   # ORDER BY 꼭 필요, 파티션 내의 시작/끝 범위 지정 
      ) 
```
<details><summary>예시 보기</summary>

<div align='center'>
<기본 테이블><br>

|번호|날짜|수량|
|:--:|:--:|:--:|
|1|2024-02-23|5|
|2|2024-02-24|-3|
|3|2024-02-25|6|
</div><br>

``` MySQL
# ORDER BY
SELECT 번호, 날짜, 수량, SUM(수량) OVER(ORDER BY 날짜) AS 재고
FROM 창고


/*          OVER절 속 ORDER BY에 의해 행집합이 정의 되고,
            그 결과에 따라 각 행별로 SUM(수량) 함수에 적용된다
                1번 행: SUM(1)
                2번 행: SUM(1, 2)
                3번 행: SUM(1, 2, 3)                             */
```
<div align='center'><'ORDER BY' 적용 테이블><br>
    
|번호|날짜|수량|**재고**|
|:--:|:--:|:--:|:--:|
|1|2024-02-23|5|**5**|
|2|2024-02-24|-3|**2**|
|3|2024-02-25|6|**8**|
</div><br><br>


``` MySQL
# PARTITION BY
SELECT 번호, 날짜, 수량, SUM(수량) OVER(PARTITION BY 물품 ORDER BY 날짜) AS 재고
FROM 창고
ORDER BY 날짜


/*            PARTITION BY를 통해 특정 컬럼별로 각각의 행집합을 나눌 수 있다.
              'A'와 'B'로 이루어진 '물품'컬럼을 PARTITION으로 지정하면,
                    'A'에 해당하는 행에 대해서 SUM(수량) 계산,
                    'B'에 해당하는 행에 대해서 SUM(수량) 계산이 이뤄진다.            */
```
<div align='center'><'PARTITION BY' 적용 테이블><br>
    
|번호|날짜|물품|수량|**재고**|
|:--:|:--:|:--:|:--:|:--:|
|1|2024-02-23|**A**|5|**5**|
|2|2024-02-24|**A**|-3|**2**|
|3|2024-02-25|*B*|4|*4*|
|4|2024-02-26|**A**|6|**8**|
|5|2024-02-27|*B*|-2|*2*|
</div><br><br>

</details><br><br><br>


> **`WITH`**  (CTE; Common Table Expression)
<p>: 메모리 상에 가상의 테이블 저장</p>

```MySQL
WITH [임시테이블명] AS(
    가상 테이블 내용
)
```
<details><summary>예시 보기</summary>

``` MySQL
WITH TBL AS
(
	SELECT '철수' AS NAME, 20 AS AGE  # ('NAME':'철수', 'AGE':20)이라는 임의의 값을 가상의 테이블을 통해 출력, 결과를 UNION
	UNION ALL
	SELECT NAME, AGE
	  FROM TB1
)

SELECT NAME, AGE FROM TBL;
```
</details><br><br><br>


> **`RECURSIVE 문`**
<p>: 자신(테이블)의 값 참조 (재귀 쿼리)</p>

```MySQL
with recursive 뷰명 as (
    초기 SQL
    UNION (ALL)
    SELECT 반복할 SQL FROM 뷰명 WHERE 반복문 정지 조건 )

SELECT * FROM 뷰명
```
<details><summary>예시 보기</summary>

``` MySQL
WITH RECURSIVE HOURS AS(
    SELECT 0 as HOUR
    UNION ALL
    SELECT HOUR + 1 FROM HOURS WHERE HOUR < 23)    # 0 ~ 23 출력됨

SELECT H.*, COUNT(ANIMAL_ID) COUNT
FROM HOURS H
    LEFT JOIN ANIMAL_OUTS AO
    ON H.HOUR = HOUR(DATETIME)
GROUP BY HOUR
```
</details><br><br><br>


> **`CONV`** /  **`BIN`**
<p>: 진법 변환 함수</p>

```MySQL
# CONV
CONV([변환하고 싶은 수 또는 컬럼], [변환 전 진법], [변환 후 진법])

# BIN
BIN([변환하고 싶은 수 또는 컬럼])
```
+ 함께 알면 좋은 개념: [비트 연산자](https://gksid102.tistory.com/90)

<details><summary>예시 보기</summary>

``` MySQL
SELECT CONV(1024,2,10)

SELECT BIN(10)
```
<br>
<div align='center'>
    <img src="https://blog.kakaocdn.net/dn/QUoY2/btrpPEGsyIE/HtdQHrgG9hiZYH3k6uAOC0/img.png"/>
</div>

</details><br><br><br>


>  **`FILTER`**
<p>: 하나의 SELECT 문에서 다른 조건을 갖는 COUNT를 여러개 구하기 (PostgreSQL)</p>

```PostgreSQL
COUNT([필드명]) FILTER(WHERE 조건)
```
<details><summary>예시 보기</summary>

``` PostgreSQL
SELECT 
    TO_CHAR(trans_date, 'yyyy-mm') AS month,
    country, 
    COUNT(state) AS trans_count,
    COUNT(state) FILTER(WHERE state='approved') AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE WHEN state='approved' THEN amount ELSE 0 END) AS approved_total_amount
FROM Transactions
GROUP BY 1, 2
```
</details><br><br><br>


> **`LEFT`** / **`RIGHT`** / **`MID`** / **`SUBSTRING`**
<p>: 문자열 자르기</p>

```MySQL
LEFT([필드명],[가져올 문자 길이])   			# PostgreSQL 한정 음수(-)값 사용 가능
SUBSTRING([필드명], [가져올 문자 시작 위치], [문자 길이])  # SUBSTR과 동일, MySQL의 MID와 같음 / 문자 길이 미 입력 시, 시작 위치 ~ 끝 출력
RIGHT([필드명],[가져올 문자 길이]) 			# PostgreSQL 한정 음수(-)값 사용 가능
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
select user_id, concat(upper(left(name,1)),lower(substring(name,2))) name
from Users
order by 1

# PostgreSQL
select user_id, concat(upper(left(name,1)),lower(right(name,-1))) name
from Users
order by 1
```
</details><br><br><br>


> **`REGEXP`**
<p>: POSIX Regular Expression (Pattern Matching), 정규 표현식</p>

```MySQL
# MySQL
[필드명 / '문자열'] REGEXP '정규 표현식'

# PostgreSQL
[필드명 / '문자열'] ~    (완벽하게 일치하는 내용 포함)     '정규 표현식'
		   ~*   (어느 정도 일치하는 내용 포함)    '정규 표현식'
		   !~   (완벽하게 일치하는 내용 미 포함)  '정규 표현식'
		   !~*  (어느 정도 일치하는 내용 미 포함) '정규 표현식'
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
select *
from Users U
where mail regexp '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$'

# PostgreSQL
select *
from Users U
where mail ~ '^[A-Za-z][A-Za-z0-9.\_\-]*@leetcode.com'
```

**- 자주 사용하는 정규 표현식 문법**

|Pattern|Description|Pattern|Description|
|:--:|:--:|:--:|:--:|
|**^패턴**|해당 패턴으로 시작|**패턴$**|해당 패턴으로 끝|
|**패턴.**|해당 자리에 모든 문자 입력 가능|**문자1\|문자2**|or 역할, 앞-뒤 문자 중 하나|
|**\\문자**|\\다음으로 오는 문자를 일반 문자 취급|||
|**패턴?**|? 바로 앞의 문자가 0~1회 일치|**패턴+**|+ 바로 앞의 문자가 1회 이상 일치|
|**패턴\***|\* 바로 앞의 문자가 0회 이상 일치|**패턴{N}**|앞 문자 x N개 만큼 일치|
|**패턴{N,M}**|앞 문자 x N개 ~ 앞 문자 x M개 만큼 일치|||
|**[0-9]**|숫자, [:digit:]로 표현하기도 함|**[a-zA-Z]**|알파벳 소문자 및 대문자|
|**[특수문자]**|특수문자 입력 시, \특수문자 형태로 입력|||

[참고하면 좋은 사이트](https://ssseung.tistory.com/170)

</details><br><br><br>





## 3. SQL Window 함수

- 윈도우 함수는 테이블 내부에 `윈도우 프레임`이라고 부르는 범위를 정의하고, 해당 범위 내에 포함된 값을 자유롭게 사용하는 함수.
- 여러 행을 합쳐 1개의 행으로 만드는 'GROUP BY'와는 달리 **기존의 값은 그대로 두고 추가적인 집계 가능**
- `RANK()`, `DENSE_RANK()`, `ROW_NUMBER()`, `LEAD()`, `LAG()` 등이 있다.
> [참고하면 좋은 사이트](https://kimsyoung.tistory.com/entry/%EB%8C%80%ED%91%9C%EC%A0%81%EC%9D%B8-%EC%9C%88%EB%8F%84%EC%9A%B0-%ED%95%A8%EC%88%98-6%EA%B0%80%EC%A7%80-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)

<br><br><br>

> **`RANK`** / **`DENSE_RANK`**
<p>: 순위 구하기</p>

```MySQL
# 불연속적 공동 순위 표기  ex) 1 1 3 4 
rank() over (PARTITION BY [컬럼명] ORDER BY [컬럼명])  # PARTITION BY ORDER BY 순서 유의

# 연속적 공동 순위 표기    ex) 1 1 2 3
dense_rank() over (PARTITION BY [컬럼명] ORDER BY [컬럼명])
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, LEFT(RR.REVIEW_DATE,10) REVIEW_DATE
FROM REST_REVIEW RR
    LEFT JOIN MEMBER_PROFILE MP
    ON RR.MEMBER_ID = MP.MEMBER_ID
WHERE RR.MEMBER_ID in (
    SELECT RRRank.MEMBER_ID
    FROM (SELECT MEMBER_ID, rank() over (ORDER BY count(MEMBER_ID) DESC) ranking   # over
          FROM REST_REVIEW
          GROUP BY MEMBER_ID
         ) RRRank
    WHERE RRRank.ranking = 1)
ORDER BY 3, 2
```
</details><br><br><br>


> **`LAG`** / **`LEAD`**
<p>: 컬럼의 열을 N칸 아래로 미루기 / 컬럼의 열을 N칸 위로 올리기</p>

```MySQL
LAG([필드명], [N], [null 값 대체값])
LEAD([필드명], [N], [null 값 대체값])
```
<details><summary>예시 보기</summary>

``` MySQL
with cnt as(
    select num,
           lag(num,1) over() bef,
           lead(num,1) over() aft
    from Logs
)

select distinct num ConsecutiveNums 
from cnt 
where num=bef and num=aft
```
<br>
<div align='center'>
    <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FpfahR%2FbtrAJSHbCXn%2FOkpyoma4bbzj30wlcHdUgk%2Fimg.png"/>
</div>

</details><br><br><br>


> **`RANGE`** & **`ROWS`**
<p>: 필드값 선택 범위 설정 (WHERE 절 같은 역할!!)</p>

```MySQL
RANGE [범위] : 컬럼값 기준으로 범위 설정 
ROWS [범위]  : 행 기준으로 범위 설정
```

<br><br><br>

> **`(UNBOUNDED) PRECEDING`** / **`(UNBOUNDED) FOLLOWING`** / **`CURRENT ROW`**
<p>: 그룹별로 누적된 값 구하기 + 범위 제한</p>

```MySQL
PRECEDING : 현재 행까지
FOLLOWING : 현재 행부터
CURRENT ROW : 현재 행
UNBOUNDED PRECEDING/FOLLOWING : 처음부터 현재 행까지 / 현재 행부터 끝 까지
N PRECEDING/FOLLOWING : 현재 행으로부터 -N개 행 / 현재 행으로부터 +N개 행

```
<details><summary>예시 보기</summary>

``` MySQL
with Dist_C as(
    select visited_on, sum(amount) Amt
    from Customer
    group by visited_on
    order by 1)

select visited_on, amount, average_amount
from(
    select  visited_on, 
            sum(Amt) over (order by visited_on rows between 6 preceding and current row) amount,
            round(avg(Amt) over (order by visited_on rows between 6 preceding and current row),2) average_amount
    from Dist_C) A
where DATE_ADD(visited_on, INTERVAL -6 DAY) in (select visited_on from Dist_C)
order by 1
```
</details><br><br><br>






<!--
> **`ORDER BY`**
<p>: 정렬하기</p>

```MySQL

```
<details><summary>예시 보기</summary>

``` MySQL

```
</details><br><br><br>
-->
