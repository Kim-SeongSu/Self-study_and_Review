# 새로 배운 MySQL 문법 정리 

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
