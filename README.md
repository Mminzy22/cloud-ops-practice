# ☁️ cloud-ops-practice

이 레포지토리는 **클라우드 운영자 과정의 실습 과제**를 정리한 공간입니다.

---

## 📂 Repository 구조

```bash
. 
├── project01/    # 과제 1: 변수, 연산자, 조건문, 반복문 등 Java 문법 예제 작성
├── project02/    # 과제 2: Java 문법 복습 및 단원별 실습 정리 프로젝트
├── project03/    # 과제 3: AWS KMS 암호화/복호화 예제 등 클라우드 관련 실습 프로젝트
├── project04/    # 과제 4: CI/CD 자동화 및 스프링 부트 기반 클라우드 배포 실습
├── project05/    # 과제 5: 도커 기반 API 서버 컨테이너화 및 실행 실습
├── project06/    # 과제 6: 상품 테이블(products) 기반 REST API 서버 구현 실습
├── project07/    # 과제 7: EC2, S3, ALB, Auto Scaling 구성 CloudFormation 실습
│
└── README.md     # 리포지토리 설명 파일
```

---

## 📁 과제 목록

1. **[project01](project01/)**
   - **주제**: Java 기초 문법 연습
   - **기술**: 변수 선언, 산술/대입/비교/논리/증감/조건(삼항) 연산자, 제어문(if, switch), 반복문(for, while, do-while)
   - **목표**: Java의 기본 문법을 이해하고 콘솔 출력으로 동작을 확인

2. **[project02](project02/)**
   - **주제**: Java 문법 복습 및 단원별 실습 정리
   - **기술**: 클래스 분리, 패키지 구조화, 단위별 테스트 실행
   - **목표**: 기존에 학습한 Java 문법을 단원별로 분리하고 모듈화된 코드로 체계적으로 정리
   - 📂 해당 프로젝트의 단원별 과제 정리 및 코드 설명은 [`project02/README.md`](project02/README.md) 파일 참고

3. **[project03](project03/)**
   - **주제**: AWS KMS 암호화/복호화 실습
   - **기술**: Spring Boot, Java, KMS SDK, Gradle 기반 프로젝트 구조
   - **목표**: AWS Key Management Service를 활용한 보안 기능 실습

4. **[project04](project04/)**
   - **주제**: CI/CD 자동화 및 클라우드 배포 실습
   - **기술**: Spring Boot, GitHub Actions, Gradle, Shell Script
   - **목표**: GitHub Actions를 활용한 자동 빌드 및 배포 파이프라인 구현

5. **[project05](project05/)**
   - **주제**: Spring Boot API 서버 도커라이징
   - **기술**: Docker, Spring Boot, Gradle, REST API, Draw.io 아키텍처 설계
   - **목표**: REST API 서버를 Docker 기반으로 패키징하고 실행 환경 구축까지 실습

6. **[project06](project06/)**
   - **주제**: 상품 테이블(products) 기반 REST API 서버 구현
   - **기술**: Spring Boot, JPA, Gradle, REST API, Swagger(OpenAPI), Docker
   - **목표**: 실제 업무 데이터베이스 테이블 설계를 기반으로 상품 정보 API를 개발하고, 이를 컨테이너화하여 실행 가능한 환경 구성
   - 📂 상세 테이블 구성 및 과제 설명은 [`project06/README.md`](project06/README.md) 파일 참고

7. **[project07](project07/)**
   - **주제**: EC2 인스턴스, S3, ALB, Auto Scaling 구성 템플릿 실습
   - **기술**: AWS CloudFormation, EC2, S3, ALB, Auto Scaling Group, Bash Script
   - **목표**: CloudFormation을 통해 AWS 인프라를 코드로 배포하고, 웹 서버의 고가용성 및 확장성을 실습
   - 📂 주요 템플릿 및 스크립트 구성은 [`project07/README.md`](project07/README.md) 파일 참고

---

## 📈 학습 목표

1. **클라우드 환경 이해**:
   - AWS 핵심 서비스의 생성, 설정, 관리.
2. **운영체제 관리 역량 강화**:
   - 리눅스 서버의 계정, 프로세스, 서비스 관리.
3. **IaC 활용 능력**:
   - Terraform을 통한 인프라 코드화.
4. **CI/CD 구현 능력**:
   - 배포 자동화 파이프라인 설계 및 운영.
5. **보안 및 비용 최적화 고려**:
   - IAM 권한 설계, 리소스 관리 비용 분석.
6. **협업 및 코드 관리 역량**:
   - Git/GitHub을 통한 협업 워크플로우 경험.

---

## 💡 기여 방법

- 새로운 프로젝트 과제를 추가하거나 수정하려면 Pull Request를 통해 기여해주세요.

---

## 📜 라이센스

이 레포지토리는 개인 학습을 목적으로 작성되었습니다. 코드는 자유롭게 활용할 수 있으나, 상업적 사용은 제한됩니다.
