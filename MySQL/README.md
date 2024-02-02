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



<!--
- 정렬하기<br>
``` MySQL
ORDER BY ASC(오름차순,기본값) 또는  DESC(내림차순)
   * 여러 조건으로 정렬할 경우, 우선 적용할 컬럼 순서로 기입
```


-  빈값찾기<br>
``` MySQL
ISNULL(컬럼,NULL일 경우 대체할 값)
```

- 빈값채우기 <br>
``` MySQL
IFNULL(컬럼,넣을값)
```

- 조건에 맞게 값 변경하기 <br>
``` MySQL
CASE WHEN 컬럼 조건 THEN 대체값1 ELSE 대체값2 END
```

- 상위 n개 값 추출<br>
``` MySQL
LIMIT n
```

-  중복값 제외<br>
``` MySQL
DISTINCT 컬럼 
```

-  GROUP BY 추가 조건 <br>
``` MySQL
GROUP BY 컬럼 HAVING 조건
```

-  평균값 구하기 - GROUP BY 사용안해도 됨<br>
``` MySQL
AVG(컬럼)
```

-  날짜 출력형식 변경 <br>
``` MySQL
DATE_FORMAT(컬럼,'%Y-%m-%d')
```

-  시간 차이 계산 <br>
``` MySQL
DATEDIFF(날짜1,날짜2)
   * TIMEDIFF(), PERIOD_DIFF(), TIMESTAMPDIFF(단위,시간1,시간2) 등 다양하게 존재
```
-->
