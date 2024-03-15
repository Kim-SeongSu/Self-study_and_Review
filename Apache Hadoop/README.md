<div align='center'>
<img width="55%" higth="10%" src="https://blog.kakaocdn.net/dn/582XZ/btq9NRAUG9f/PmyNdiMq4Yj1kR6JyAfQR1/img.png"><br>
<!--
  <img src="https://capsule-render.vercel.app/api?type=transparent&color=yellow&height=100&section=header&fontSize=50&descAlign=70&descSize=20&descAlignY=86&text=Apache%20Hadoop&desc=Study%20Note"/>
-->
</div><br><br>

 
 # What is a Hadoop?
> [!IMPORTANT]
> **Apache Hadoop**[^1]이란 **대량의 자료를 처리**할 수 있는 **컴퓨터 클러스터**에서 동작하는 **분산 응용 프로그램**을 지원하는**프리웨어 자바 소프트웨어 프레임워크**이다.

[^1]:Apache High-Availability Distributed Object-Oriented Platform

<br>

[`*Apache Hadoop`](https://ko.wikipedia.org/wiki/%EC%95%84%ED%8C%8C%EC%B9%98_%ED%95%98%EB%91%A1)은 구글 파일 시스템을 대체할 수 있는 **하둡 분산 파일 시스템**(HDFS[^2])과 **맵리듀스**(MapReduce[^3])로 구현한 것이다.
Base Apache Hadoop framework로는 하둡 커먼(Hadoop Common), **하둡 분산 파일 시스템(HDFS)**, **하둡 YARN**, **하둡 맵리듀스**가 있다.<br><br>

[^2]: Hadoop Distributed File System, 여러 기계에 대용량 파일들을 나눠서 (중복하여) 저장하는 분산 확장 파일 시스템
[^3]: Map+Reduce, 구글에서 **대용량 데이터 처리를 분산 병렬 컴퓨팅에서 처리**하기 위한 목적으로 제작한 소프트웨어 프레임워크



## 1. 하둡 분산 파일 시스템(HDFS)
<br>
<div align="center">
  <img width="55%" src="https://velog.velcdn.com/images/jochedda/post/ae3e8a2c-de7f-4ab6-b64c-4e001887b5f7/image.png">
</div><br>

### 1) 특징
- **데이터를 블록 단위로 나눠서 저장** <br>
ㅤㅤ*블록보다 작은 크기의 파일은 나누지 않고 저장 
- **블록을 복제하여 중복 저장** <br>
ㅤㅤ* 데이터 손실을 방지하기 위해 3개의 블록으로 복제하여 저장
- **입력한 데이터는 수정 불가** <br>
ㅤㅤ* 읽기 중심의 목적으로 만들어져 파일 수정은 지원하지 않음
- **데이터의 지역성을 이용하여 데이터 처리 속도 증가** <br><br><br><br>

### 2) 구조

<div align="center">
  <img width="60%" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcnSohV%2FbtqFQ8qQZbD%2FgYobbjO4Jk7JKuuhSItbdk%2Fimg.png">
</div><br><br>

기본적으로 `마스터-슬레이브 구조`로 **1개의 Master**와 **1개 이상의 Slave**로 구성된다. <br>
**메타 데이터**(분산된 파일의 위치 정보)를 가지고 있는 **NameNode**와 **실질적인 데이터**를 저장하고 있는 **DataNode**가 있다. <br><br>

- **NameNode** (네임노드)

네임노드에 장애가 생겨 가지고 있던 메타 데이터를 잃게 된다면, 데이터 노드에 데이터가 온전히 저장되어 있어도 데이터를 불러올 수 없다. 
이를 `SPOF(Single Point Of Failure)`라고 하며 이를 방지하고자 `HA(High Availability)`를 적용한다. <br>

  - **역할 1. 메타 데이터 관리** <br>
  ```md
  1) fsimage 파일을 메모리에 로딩
      - dfs.namenode.name.dir 경로와 디스크에 저장됨.
      - 파일 권한(Permission), 파일 접근 시간 (atime; access time), HDFS 파일 위치, HDFS 블록 메타정보를 기록함.
    * fsimage : 특정 시점의 HDFS 메타 데이터에 대한 스냅샷(SnapShot) 파일 (= 가장 최근의 체크포인트가 적용된 메타 데이터)

  2) edits log를 fsimage에 적용 (=체크포인팅)
      - dfs.journalnode.edits.dir 경로와 디스크에 저장
    * edits log: 마지막 체크포인팅 이후의 변경 사항을 기록하는 로그
        | active namenode  : 저널 노드에 edits로그 입력 가능
        | standby namenode : 저널 노드에서 edits로그를 읽어 주기적으로 체크포인팅 수행 >> 결과 fsimage active namenode에 전달

  3) DataNode로 부터 블록 위치를 받고, 갖고 있는 블록 메타 정보와 매핑
      - 주기적으로 데이터 노드로 부터 블록 리포트(블록 위치 정보) 제공 받음
      - 따로 디스크에 저장하지 않고 메모리에만 저장
  ```


<!--
      *체크포인트(checkpoint)
      : edits 파일은 별도의 크기 제한이 없기 때문에 너무 크기가 커질 경우, 
        메모리에 edits 로그에 기록된 변경 이력을 적용할 때 너무 긴 시간이 소요된다. 
        이를 방지하고자 Standby NameNode에서 주기적으로 변경된 edits 로그 파일을 fsimage에 갱신하는 작업을 말한다.
-->


  - **역할 2. 데이터 노드 및 블록 관리** <br>
  ```md
  
  ```
  - **역할 3. 클라이언트 요청 받기** <br>
  ```md
  
  ```
  - **역할 4. edits log 쓰기** <br>
  ```md
  
  ```
  
- **DataNode** (데이터 노드)

- **JournalNode** (저널노드)

- **Zookeeper (QPM; QuorumPeerMain)** (주키퍼)

- **ZKFC (ZookeeperFailoverController)** (주키퍼 장애 복구 컨트롤러)
  
<!--
https://velog.io/@jochedda/%ED%95%98%EB%91%A1Hadoop%EC%9D%B4%EB%9E%80 <br>
https://it-sunny-333.tistory.com/42 <br>
https://eyeballs.tistory.com/251 <br>
https://dabingk.tistory.com/6?category=753767 <br>
-->

<br><br><br>

## 2. Hadoop YARN 

<div align="center">
  <img width="55%" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcbOTbB%2FbtqCy5j5qwr%2F6LMZDlTK5pe6aKD3XdEhYK%2Fimg.png">
</div>


- **ResourceManager** (리소스매니저)
  - Scheduler
  - Applications Manager  

- **NodeManager** (노드매니저)

- **Application Master** (애플리케이션 마스터)

- **Container** (컨테이너)


<!--
https://mangkyu.tistory.com/127
-->

<br><br><br>

## 3. Hadoop MapReduce


<!--

https://data-wiki.tistory.com/17 <br>


<br><div align="center">
  
|ㅤㅤRelational DBㅤㅤ|ㅤㅤElasticsearchㅤㅤ|
|:--:|:--:|
|**Database**|**Index**|

</div><br><br>


> [!TIP]
> 해당 명령어는 **Curl**(Client url)을 통해 실행되므로 자주 사용하는 [Curl 옵션](https://inpa.tistory.com/entry/LINUX-%F0%9F%93%9A-CURL-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%8B%A4%EC%96%91%ED%95%9C-%EC%98%88%EC%A0%9C%EB%A1%9C-%EC%A0%95%EB%A6%AC)을 알아두면 좋다
>
> **-X** (--request) : 요청시 사용할 메소드의 종류(GET, POST, PUT, PATCH, DELETE)를 지정한다.<br>
> **-d** (--data) : HTTP POST 요청 데이터 입력<br>
> **-H** : 전송할 헤더를 지정




<details><summary>예시 보기</summary>

``` Linux

```
<p> 
ㅤㅤ* 기존에 존재하지 않는 _index명, _type명을 입력해도 자동으로 생성됨.<br>
ㅤㅤ* _id명 또한 미입력 시 자동 생성<br>
ㅤㅤ* -H 옵션으로 Request에 대한 Content-Type을 application/json 타입으로 지정 후, -d 옵션으로 {}안의 값 입력
</p>

ㅤ \- health 확인 결과 **Green**이 아닌 경우, `/var/log/elasticsearch/클러스터명.log`파일을 확인하여 에러를 수정하여야 한다. <br>
ㅤ \- `?pretty` 는 결과(response)를 예쁘게 출력하는 명령어

</details><br><br>
-->
