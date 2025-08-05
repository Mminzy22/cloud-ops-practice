### 📁 `project07/` - EC2 인스턴스 및 S3, ALB, Auto Scaling 템플릿

이 디렉토리는 AWS CloudFormation을 이용하여 \*\*EC2 인스턴스, S3 버킷, Application Load Balancer(ALB), Auto Scaling Group(ASG)\*\*을 구성하는 실습용 템플릿들을 포함하고 있습니다.

---

### 📄 `ec2.yml`

> EC2 인스턴스 생성 및 SSH 허용 보안 그룹 구성 템플릿

#### ✅ 주요 리소스

* `AWS::EC2::SecurityGroup`

    * 포트 **22번(SSH)** 허용
    * **모든 IP(0.0.0.0/0)** 에 대해 개방됨 *(테스트 목적이므로 실서비스에서는 제한 필요)*

* `AWS::EC2::Instance`

    * AMI: `ami-008e20914908f5345` (Amazon Linux 2 기준, 서울 리전)
    * 인스턴스 타입: `t2.micro` (프리 티어)
    * KeyPair 이름: `next-dev-key` *(사전에 AWS 콘솔 또는 CLI에서 생성 필요)*
    * 태그: `Name=my-minji-server`

#### 🚀 배포 명령어

```bash
aws cloudformation create-stack \
  --stack-name ec2-stack \
  --template-body file://ec2.yml
```

---

#### ⚠️ 유의사항

* `next-dev-key` KeyPair는 미리 생성되어 있어야 하며, 로컬에 `.pem` 파일이 있어야 SSH 접속이 가능합니다.
* SSH 포트를 0.0.0.0/0으로 허용하는 것은 보안상 위험하므로, 테스트 이후에는 특정 IP로 제한하거나 제거해야 합니다.

---

### 📄 `s3-ec2.yml`

> S3 버킷과 EC2 인스턴스를 동시에 생성하는 템플릿

#### ✅ 주요 리소스

* `AWS::S3::Bucket`

    * 기본 설정의 S3 버킷 생성

* `AWS::EC2::Instance`

    * AMI: `ami-008e20914908f5345`
    * 인스턴스 타입: `t2.micro`
    * KeyPair는 설정되지 않음 (접속 불가 테스트용)
    * 보안 그룹 미지정 (기본 보안 그룹 사용)
    * 태그: `Name=${스택이름}-Instance`

#### 🚀 배포 명령어

```bash
aws cloudformation create-stack \
  --stack-name s3-ec2-stack \
  --template-body file://s3-ec2.yml
```

---

#### ⚠️ 유의사항

* EC2 인스턴스는 KeyPair가 지정되어 있지 않으므로 SSH 접속이 불가능합니다.
* S3 버킷 이름은 자동 생성되며, 중복되지 않도록 CloudFormation에서 랜덤 이름이 붙습니다.
* 보안 그룹이 명시되지 않으므로, 기본 VPC와 기본 보안 그룹이 계정에 존재해야 정상적으로 실행됩니다.

---

### 📄 `ec2-alb-autoscaling.yml`

> EC2 인스턴스와 ALB, Auto Scaling Group을 포함한 고가용성 웹 서버 템플릿

#### ✅ 주요 리소스

* **VPC/Subnet/IGW/RouteTable**

    * `10.15.0.0/16` CIDR의 사용자 정의 VPC
    * 2개의 Public Subnet(AZ 분산), 인터넷 게이트웨이 및 라우팅 설정

* **보안 그룹**

    * EC2 인스턴스용 SG: SSH(22), HTTP(80) 허용
    * ALB용 SG: HTTP(80) 허용

* **Launch Template**

    * Amazon Linux 2 기반 EC2 인스턴스 자동 시작 구성
    * Apache 설치 및 기본 HTML 응답 포함

* **Application Load Balancer (ALB)**

    * 퍼블릭 ALB 생성 + 리스너 구성
    * 대상 그룹과 연동, 헬스체크 경로 `/`

* **Auto Scaling Group (ASG)**

    * 최소 2개, 최대 4개의 EC2 인스턴스 자동 확장
    * ALB 대상 그룹 연동 및 헬스체크 적용

#### 🚀 배포 명령어

```bash
aws cloudformation create-stack \
  --stack-name ec2-alb-autoscaling-stack \
  --template-body file://ec2-alb-autoscaling.yml \
  --parameters ParameterKey=KeyName,ParameterValue=next-dev-key
```

---

#### ⚠️ 유의사항

* `KeyName` 파라미터에 지정한 KeyPair가 AWS에 존재해야 하며, 이를 통해 EC2에 SSH 접속할 수 있습니다.
* 생성된 ALB의 DNS 주소는 `Outputs`에 포함되어 있으며, 이를 통해 웹 페이지 확인 가능
* 퍼블릭 서브넷과 ALB가 포함되므로 외부 접속이 가능하지만, 보안적으로는 추가 설정이 필요할 수 있습니다.

---

### 📄 `deploy.sh`

> `ec2-alb-autoscaling.yml`을 자동으로 배포하는 Shell 스크립트

이 스크립트는 다음 작업을 자동으로 처리합니다:

1. `ec2-alb-autoscaling-stack`이라는 이름으로 CloudFormation 스택 생성
2. 지정한 EC2 키페어(`next-dev-key`)를 파라미터로 전달
3. 스택 생성이 완료될 때까지 대기
4. 생성된 ALB의 DNS 주소를 자동으로 추출하여 콘솔에 출력

#### ✅ 실행 명령어

```bash
chmod +x deploy.sh
./deploy.sh
```

실행 완료 후, 다음과 같은 메시지가 출력됩니다:

```bash
🌐 Access your web app at: http://<ALB_DNS>
```

---

#### ⚠️ 유의사항

* `KEY_NAME` 변수에 설정한 키페어(`next-dev-key`)는 미리 AWS에 생성되어 있어야 합니다.
* `CAPABILITY_NAMED_IAM` 권한이 포함되어 있으므로 IAM 리소스를 정의하지 않더라도 해당 플래그를 포함해야 스택 생성이 실패하지 않습니다.
* AWS CLI가 설치되어 있고, `~/.aws/credentials`에 인증 정보가 설정되어 있어야 합니다.

---

### 📄 `destroy.sh`

> `ec2-alb-autoscaling-stack` 스택을 자동으로 삭제하는 Shell 스크립트

이 스크립트는 다음 작업을 자동으로 수행합니다:

1. 지정한 스택 이름(`ec2-alb-autoscaling-stack`)을 삭제 요청
2. 스택 삭제가 완료될 때까지 대기
3. 완료 메시지 출력

#### ✅ 실행 명령어

```bash
chmod +x destroy.sh
./destroy.sh
```

실행 완료 후, 다음과 같은 메시지가 출력됩니다:

```bash
🗑️ Stack deleted.
```

---

#### ⚠️ 유의사항

* 삭제 대상 스택 이름은 `STACK_NAME` 변수로 관리되며, 필요 시 스크립트 내에서 변경해야 합니다.
* 삭제 후에는 해당 스택 내 모든 리소스(EC2, ALB, VPC, 서브넷 등)가 제거됩니다.
* 삭제 완료까지 수 분이 소요될 수 있습니다.