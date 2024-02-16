# What is a Elasticsearch?
> [!IMPORTANT]
> **Elasticsearch**란 **Apache Lucene 기반의 Java 오픈소스 분산 검색 엔진**으로, HTTP 웹 인터페이스와 스키마에서 자유로운 JSON 문서와 함께 분산 멀티테넌스[^1] 지원 전문 검색엔진을 제공한다. 

[^1]:software multitenancy는 여러 테넌스(**사용자**)를 가진 소프트웨어 아키텍처라는 의미로 클라우드 서비스처럼 여러 사용자가 동시에 같은 작업을 진행할 수 있게하는 역할을 한다.

> [!TIP]
> 참고하면 좋은 [블로그](https://victorydntmd.tistory.com/category/OpenSource/Elasticsearch)


<br>

[`Elasticsearch`](https://ko.wikipedia.org/wiki/%EC%9D%BC%EB%9E%98%EC%8A%A4%ED%8B%B1%EC%84%9C%EC%B9%98)는 하둡(hadoop)처럼 여러 대의 서버를 묶어 하나의 클러스터를 구성한다. <br> 차이가 있다면, 하둡에서는 **Master-Slave 구조**를 사용자가 직접 지정했지만, Elasticsearch는 클러스터를 이루는 **각각의 서버가 유동적으로 Master 또는 Slave**가 될 수도 있다. <br>
이러한 이유로 `jvm.options`파일에서 Heap Size[^2]를 Master Node에 적합하도록 설정해두고 `elasticsearch.yml`파일에서 해당 서버를 Masternode로 설정하기도 한다.<br>

[^2]: 프로그램에서 동적으로 할당된 메모리를 관리하는데 사용되는 영역인 **힙 메모리**(Heap Memory)의 크기를 설정하는 것으로, 너무 크지도 너무 작지도 않게 적절히 설정해야한다.

Elasticsearch는 검색의 용도로 단독으로 사용하기도 하고, **ELK**( Elasticsearch / Logstatsh / Kibana )**스택**으로 묶어 데이터 수집, 검색, 시각화 등의 과정을 일련에 진행하기도 한다.<br><br>

## 1. 구조 및 용어

<br>
<div align="center">
  <img width="55%" src="https://raw.githubusercontent.com/exo-addons/exo-es-search/master/doc/images/image_05.png">
</div>

### 1) Cluster (클러스터)

**가장 큰 시스템 단위**로 `최소 하나 이상의 노드로 이루어진 노드들의 집합`이다. 같은 클러스터 내에서만 **데이터의 접근 및 교환**이 이뤄지는 독립적인 시스템이다. 여러 대의 서버가 하나의 클러스터를 구성할 수 있고, 한 서버에 포트번호를 다르게 연결하여 독자적인 클러스터를 구성할 수도 있다.<br>
<br>

### 2) Node (노드)

Elasticsearch를 `구성하는 하나의 단위 프로세스`를 의미한다. 역할에 따라 **Master-eligible, Data, Ingest, Coordinate 노드**로 나눌 수 있다.<br><br>

- **Master-eligible Node** (마스터 노드)
  - `클러스터를 제어하는 마스터 노드`로 선택 가능한 노드
  - **인덱스 생성 및 삭제**
  - 클러스터 노드 추적 및 관리
  - 데이터 입력 시 **샤드 할당 결정**
<br>

- **Data Node** (데이터 노드)
  - 데이터를 다루는 **CRUD 작업** 진행
<br>

- Ingest Node
  - 데이터 변환 등 사전 처리 파이프라인 실행 역할
<br>

- Coordinate Node
  - **Load Balancer**[^3] 역할
  - 없을 경우, 해당 역할을 Data Node가 수행
  - 클러스터의 크기가 커질수록 필요

[^3]: **Load(서버에 가해지는 부하)를 Balancing(분산)해주는 장치 또는 기술**을 의미한다. 크게 `서버 자체의 성능을 높이는` **Scale-Up** 방법과 여러 개의 낮은 성능을 갖는 서버를 증설하여 높이는 **Scale-Out** 방법이 있다.

<br>

### 3) Shard, Replica

`Shard(샤드)`는 Elasticsearch가 클러스터에서 데이터를 배포하는 단위이다. <br>
ㅤ**Primary Shard**는 `각 인덱스별 최소 1개 이상`, `각 샤드에 골고루 분산되어 저장`되고, <br>
ㅤ**Replica Shard**는 `Primary Shard의 복제본`으로 동일한 데이터를 갖는 Primary Shard와는 같은 노드에 존재할 수 없다. <br>
ㅤㅤㅤex) replica 3 : 'primary shard의 복제본이 3개'라는 의미

<br>

### 4) vs. 관계형 DB 용어

<br><div align="center">
  
|ㅤㅤRelational DBㅤㅤ|ㅤㅤElasticsearchㅤㅤ|
|:--:|:--:|
|**Database**|**Index**|
|**Table**|**Type**|
|**Row**|**Document**|
|**Column**|**Field**|
|Index|Analyze|
|Primary key|_id|
|**Schema**|**Mapping**|
|**Physical partition**|**Shard**|
|Logical partition|Route|
|Relational|Parent/Child, Nested|
|SQL|Query DSL(Domain-Specific Languages)|
</div><br><br>

## 2. CRUD 명령어 

> [!TIP]
> 해당 명령어는 **Curl**(Client url)을 통해 실행되므로 자주 사용하는 [Curl 옵션](https://inpa.tistory.com/entry/LINUX-%F0%9F%93%9A-CURL-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%8B%A4%EC%96%91%ED%95%9C-%EC%98%88%EC%A0%9C%EB%A1%9C-%EC%A0%95%EB%A6%AC)을 알아두면 좋다
>
> **-X** (--request) : 요청시 사용할 메소드의 종류(GET, POST, PUT, PATCH, DELETE)를 지정한다.<br>
> **-d** (--data) : HTTP POST 요청 데이터 입력<br>
> **-H** : 전송할 헤더를 지정

<br>

> Elasticsearch **`Cluster 정상 작동 확인`**

```Linux
# curl -X GET 'localhost:9200'
# curl -s "localhost:9200/_cat/health?v"           * Green / Yellow / Red 
# curl -s "localhost:9200/_cat/nodes?v"
# curl -s "localhost:9200/_cat/shards?v"
# curl -s "localhost:9200/_cluster/allocation/explain?pretty"
```
ㅤ \- health 확인 결과 **Green**이 아닌 경우, `/var/log/elasticsearch/클러스터명.log`파일을 확인하여 에러를 수정하여야 한다. <br>
ㅤ \- `?pretty` 는 결과(response)를 예쁘게 출력하는 명령어

<br><br>


> 클러스터에 존재하는 모든 **`index 조회`**

```Linux
# curl -XGET 'localhost:9200/_cat/indices?v'
```
<br><br>


> **`index 추가`**

```Linux
# curl -XPUT 'localhost:9200/index명?pretty'
```
<p> 
ㅤㅤ* index명을 설정할 때는 소문자로만 작성해야 한다.
</p>

<details><summary>예시 보기</summary>

``` Linux
# curl -XPUT 'localhost:9200/soccer_player?pretty'
```
</details><br><br>


> **`document 추가`**

```Linux
- 직접 입력하여 데이터 추가
# curl -XPOST 'localhost:9200/index명/type명/id명?pretty' -H 'Content-Type: application/json' -d '{
"추가하려는 field명": "field값",
	     …
"추가하려는 field명": "field값"
}'

- 데이터를 json 형식의 파일로 만들어 API 호출
# vim 파일명.json
{
"추가하려는 field명": "field값"   같은 형식으로 내용 입력
}
# curl -XPOST 'localhost:9200/index명/type명/id명?pretty' -H 'Content-Type: application/js
on' -d @파일명.json
```
<p> 
ㅤㅤ* 기존에 존재하지 않는 _index명, _type명을 입력해도 자동으로 생성됨.<br>
ㅤㅤ* _id명 또한 미입력 시 자동 생성<br>
ㅤㅤ* -H 옵션으로 Request에 대한 Content-Type을 application/json 타입으로 지정 후, -d 옵션으로 {}안의 값 입력
</p>

<details><summary>예시 보기</summary>

``` Linux
- 직접 입력하여 데이터 추가
# curl -XPOST 'localhost:9200/soccer_player/info/1?pretty' -H 'Content-Type: application/json' -d '{
"Name": "손흥민",
"Nationality": "Korea",
"Team": "Tottenham Hotspur F.C.",
"Age": "31",
"Position": "Forward"
}'

- 데이터를 json 형식의 파일로 만들어 API 호출
# vim player_info.json
{
"Name": "김민재",
"Nationalityality": "Korea",
"Team": "Tottenham Hotspur F.C.",
"Age": "27",
"Position": "Defender"
}

# curl -XPOST 'localhost:9200/soccer_player/info/2?pretty' -H 'Content-Type: application/json' -d @player_info.json
```
</details><br><br>



> **`document 조회`**

```Linux
- 모든 index의 모든 document 조회
# curl -XGET 'localhost:9200/_all/_search?pretty'

- 특정 index의 모든 document 조회
# curl -XGET 'localhost:9200/index명/_search?pretty'

- 특정 index의 특정 id값의 document 조회
# curl -XGET 'localhost:9200/index명/type명/id명?pretty'

- 실제 데이터인 _source만 조회 & 특정 field의 _source만 조회
# curl -XGET 'localhost:9200/index명/type명/id명?pretty&filter_path=_source'
# curl -XGET 'localhost:9200/index명/type명/id명?pretty&filter_path=_source.field값'
```
<details><summary>예시 보기</summary>

``` Linux
- 특정 index의 모든 document 조회
# curl -XGET 'localhost:9200/soccer_player/_search?pretty'

- 특정 index의 특정 id값의 document 조회
# curl -XGET 'localhost:9200/soccer_player/info/1?pretty'

- 실제 데이터인 _source만 조회 & 특정 field의 _source만 조회
# curl -XGET 'localhost:9200/soccer_player/info/1?pretty&filter_path=_source'
# curl -XGET 'localhost:9200/soccer_player/info/1?pretty&filter_path=_source.Nationality'
```
</details><br><br>


> **`document 수정`**

```Linux
- 덮어쓰기
# curl -XPUT 'localhost:9200/index명/type명/id명?pretty' -H 'Content-Type: application/js
  on' -d '{
  "수정하려는 field명": "field값"
  }'


- 특정값만 변경
# curl -XPOST "localhost:9200/index명/type명/id명/_update?pretty" -H "Content-Type: application/json" -d '{
  "doc": {"수정하려는 field명": "field값"}
  }'
```
<p> 
ㅤㅤ* 단, 기존에 존재하는 내용만 수정가능 ( 수정 & 추가 동시에 불가 )<br>
</p>

<details><summary>예시 보기</summary>

``` Linux
- 덮어쓰기
# curl -XPUT 'localhost:9200/soccer_player/info/2?pretty' -H 'Content-Type: application/json' -d '{
  "Name": "김민재",
  "Nationality": "Korea",
  "Team":"FC BAYERN MÜNCHEN",
  "Age": "27",
  "Position": "Defender"
  }'

- 특정값만 변경
# curl -XPOST "localhost:9200/soccer_player/info/3/_update?pretty" -H "Content-Type: application/json" -d '{
  "doc": {"Team":"FC BAYERN MÜNCHEN"}
  }'
```
</details><br><br>


> **`index or document 삭제`**

```Linux
- 특정 id의 document 삭제
# curl -XDELETE 'localhost:9200/index명/type명/id명?pretty'

- index 삭제
# curl -XDELETE 'localhost:9200/index명?pretty'
```
<details><summary>예시 보기</summary>

``` Linux
- 특정 id의 document 삭제
# curl -XDELETE 'localhost:9200/soccer_player/info/2?pretty'

- index 삭제
# curl -XDELETE 'localhost:9200/soccer_player?pretty'
```
</details><br><br>
