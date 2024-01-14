# 새로 배운 MySQL 문법 정리 

- <span style="color:gold"> 정렬하기 </span><br>
ORDER BY ASC(오름차순,기본값) 또는  DESC(내림차순) <br>
<span style="color:green"> *여러 조건으로 정렬할 경우, 우선 적용할 컬럼 순서로 기입 </span><br>

- <span style="color:gold"> 빈값찾기 </span><br>
ISNULL(컬럼)<br>

- <span style="color:gold">  빈값채우기 </span><br>
IFNULL(컬럼,넣을값) <br>

- <span style="color:gold">  조건에 맞게 값 변경하기 </span><br>
CASE WHEN 컬럼 조건 THEN 대체값1 ELSE 대체값2 END<br> 

- <span style="color:gold">  상위 n개 값 추출 </span><br>
LIMIT n <br>

- <span style="color:gold">  중복값 제외 </span><br>
DISTINCT 컬럼 <br>

- <span style="color:gold">  GROUP BY 추가 조건 </span><br>
GROUP BY 컬럼 HAVING 조건<br>

- <span style="color:gold">  평균값 구하기 - GROUP BY 사용안해도 됨 </span><br>
AVG 컬럼 <br>

- <span style="color:gold">  날짜 출력형식 변경 </span><br>
DATE_FORMAT(컬럼,'%Y-%m-%d') <br>

- <span style="color:gold">  시간 차이 계산 </span><br>
DATEDIFF(날짜1,날짜2) <br>
TIMEDIFF(), PERIOD_DIFF(), DATEDIFF 등 다양하게 존재
