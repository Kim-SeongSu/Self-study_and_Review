<div align='center'>
<img src="https://capsule-render.vercel.app/api?type=transparent&color=timeAuto&height=100&section=header&fontSize=50&descSize=20&descAlign=60&descAlignY=83&text=SQL%20Study&desc=Basic%20grammar"/>
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
<details><summary>ㅤ</summary>

<br>

> **`CREATE`**  ( DDL 명령어 - **생성** )
<p>: 데이터베이스 오브젝트 생성</p>

```MySQL
# CREATE DATABASE [데이터베이스명];

# CREATE TABLE [테이블명](
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
# ALTER TABLE [테이블명] RENAME [새 테이블명];

# ALTER TABLE [테이블명] MODIFY COLUMN [필드명] [새 필드타입];

# ALTER TABLE [테이블명] CHANGE COLUMN [필드명] [새 필드명] [새 필드타입];

# ALTER TABLE [테이블명] ADD COLUMN [필드명] [필드타입];

# ALTER TABLE [테이블명] DROP COLUMN [필드명];
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
# DROP DATABASE [데이터베이스명];

# DROP TABLE [테이블명];
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
# TRUNCATE TABLE [테이블명];
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

<details><summary>ㅤ</summary>

<br>

> **`SELECT`**  ( DML 명령어 - **데이터 조회** )
<p>: 테이블의 내용을 조회</p>

```MySQL
# SELECTE [필드명] FROM [테이블명];
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
# INSERT INTO [테이블명]([필드명1], [필드명2], ...)
   VALUES ([데이터값1], [데이터값2], ...);

# INSERT INTO [테이블명]
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
# UPDATE [테이블명]
SET [조건 필드명1]=[조건값1], [조건 필드명2]=[조건값2], ...
WHERE [업데이트 하고싶은 필드명]=[업데이트 할 데이터값];
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

</details><br><br><br>

> **`DELETE`**  ( DML 명령어 - **데이터 삭제** )
<p>: 테이블의 내용을 삭제</p>

```MySQL
# DELETE FROM [테이블명] WHERE [필드명]=[조건값];
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

<details><summary>ㅤ</summary>

<br>

> **`GRANT`**  ( DCL 명령어 - **권한 부여** )
<p>: 데이터베이스 사용자에게 권한 부여</p>

```MySQL
# GRANT [권한 범위] PRIVILEGES ON [DB명].[테이블명] TO [사용자ID@localhost];
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
# REVOKE [권한 범위] ON [DB명].[테이블명] TO [사용자ID@localhost];
```

<details><summary>예시 보기</summary>

``` MySQL
REVOKE ALL ON *.* FROM 'root'@localhost;
```

[참고 링크](https://dev-coco.tistory.com/53)  

</details><br><br><br>


<br><br><br>
</details><br>


### 4) 그 외의 명령어
- Database 및 Table과 관련된 명령어
<details><summary>ㅤ</summary>
<br>

> **`USE`**
<p>: 사용할 데이터베이스를 선택하는 명령어</p>

```MySQL
# USE [데이터베이스명];
```
<br><br>
> **`SHOW`**
<p>: 모든 DB 또는 TABLE을 보여주는 명령어</p>

```MySQL
# SHOW DATABASES;

# SHOW TABLES;
```
<br><br>
> **`DESC`**
<p>: TABLE의 구조를 보는 명령어</p>

```MySQL
# DESC [테이블명];

# DESCRIBE [테이블명];

# EXPLAIN [테이블명];
```

<br><br><br>
</details><br>





## 2. SQL 타입
<details><summary>ㅤ</summary>
<br>




<!--
> **``**  (  **데이터 삽입** )
<p>: </p>

```MySQL
#    [테이블명][DB명][필드명]

```

<details><summary>예시 보기</summary>

``` MySQL

```
[ 출력결과 ]
|ID|Name|ReserveDate|RoomNum|
|--|--|--|--|
|1|이순신|2016-02-16|1108|
|3|김유신|NULL|NULL|

[참고 링크]()

</details><br><br><br>
-->






</details><br>




## 3. SQL 함수

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


> **`LIMIT`**
<p>: 상위 n개 값 추출</p>

```MySQL
LIMIT [n]
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME LIMIT 1
```
</details><br><br><br>


> **`AVG`**
<p>: 평균값 구하기</p>

```MySQL
AVG([필드값])
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = 'SUV'
```
</details><br><br><br>


> **`ISNULL`**
<p>: 빈값찾기</p>

```MySQL
ISNULL([필드값], [NULL일 경우 대체할 값])
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE ISNULL(NAME)
```
</details><br><br><br>


> **`IFNULL`** or **`COALESCE`**
<p>: 빈값채우기</p>

```MySQL
# MySQL 전용 함수
IFNULL([필드값],[대체할 값])

# 표준 SQL 함수
COALESCE([필드값1],[필드값2],,...,[필드값n])   #필드값1이 NULL이면 필드값2가, 필드값2가 NULL이라면 필드값3가 반환되는 형식
```
<details><summary>예시 보기</summary>

``` MySQL
# MySQL
SELECT ANIMAL_TYPE, IFNULL(NAME,'No name'), SEX_UPON_INTAKE FROM ANIMAL_INS ORDER BY ANIMAL_ID

# PostgreSQL
SELECT name FROM Customer WHERE COALESCE(referee_id, 0) != 2
```
</details><br><br><br>


> **`DATE_FORMAT`**
<p>: 날짜 출력형식 변경</p>

```MySQL
DATE_FORMAT([필드값],입력 형식)
```
<details><summary>예시 보기</summary>

``` MySQL
SELECT  HISTORY_ID,
        CAR_ID,
        LEFT(START_DATE,10) AS START_DATE,
        DATE_FORMAT(END_DATE,'%Y-%m-%d') AS END_DATE,
        CASE WHEN DATEDIFF(END_DATE,START_DATE)+1 < 30 THEN '단기 대여'
            ELSE '장기 대여' END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE LEFT(START_DATE,7)='2022-09'
ORDER BY HISTORY_ID DESC
```

<div align = 'center'>

|format type|description|format type|description|
|:--:|:--:|:--:|:--:|
|%Y|년도 (2021)|%y|년도 (21)|
|%M|월 (January, August)|%m|월 (01, 02, 11)|
|%b|월(Jan, Aug)|%c|월 (1, 8)|
|%W|요일(Wednesday, friday)|%a|요일(Wed, Fri)|
|%d|일(01, 19)|%e|일(1, 19)|
|%T|시간 (12:30:00)|%r|시간 (12:30:00 AM)|
|%H|24시간 시간(01, 14, 18)|%l|12시간 시간 (01, 02, 06)|
|%i|분 (00)|%S|초 (00)|

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


> **`CASE`**
<p>: 여러 조건에 맞게 값 변경하기</p>

```MySQL
CASE WHEN [필드값] [조건] THEN [대체값1]
     WHEN [필드값] [조건] THEN [대체값2]
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


> **`CONCAT`**
<p>: 문자열 합치기</p>

```MySQL
# 단순 문자열 합치기
CONCAT(문자열1, 문자열2,...,문자열n)

# 구분자로 문자열 합치기
CONCAT_WS('구분자', 문자열1, 문자열2,...,문자열n)

# 그룹핑하여 추출한 문자열 합치기
GROUP_CONCAT( (distinct) 필드값 (order by ~) (SEPARATOR '구분자') ) 
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
