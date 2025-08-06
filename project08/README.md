# 📦 Project08 - Terraform 기반 AWS 인프라 구성 실습

이 프로젝트는 Terraform을 활용하여 다양한 AWS 인프라 리소스를 코드로 관리하는 실습입니다.  
단일 EC2 인스턴스 구성부터 시작하여, 모듈화를 통한 VPC, ECS, ALB 구성까지 점진적으로 확장합니다.

---

## 📁 디렉토리 구성

| 디렉토리 | 설명 |
|----------|------|
| `ec2/` | 단일 EC2 인스턴스를 프로비저닝하는 Terraform 코드 |
| `method/` | `can()`, `try()`, `lookup()` 등 Terraform 내장 함수 실습 |
| `terraform-project/` | VPC + EC2 구성의 단일 프로젝트 형태 실습 |
| `terraform-ecs-module/` | 모듈화된 형태로 VPC, ALB, ECS 구성 |

---

## 🎯 실습 목표

1. Terraform의 기본 사용법 및 파일 구조 이해
2. AWS 리소스를 코드 기반으로 선언하고 자동화하는 경험 습득
3. `terraform apply`, `destroy`, `plan`, `output` 등의 명령어 숙련
4. 반복 가능한 인프라 구성을 모듈화하여 유지보수 용이한 구조 설계
5. 조건 처리 및 오류 방지 함수(`can`, `try`, `lookup`, `length`, `contains`) 적용법 학습

---

## 🛠️ 사용 기술 및 서비스

- **Terraform CLI**
- **AWS EC2, VPC, ALB, ECS(Fargate)**
- **Terraform Modules**
- **Terraform Expressions & Functions**

---

## 🧪 실행 방법

```bash
# 예시: EC2 프로젝트 실행
cd ec2/
terraform init
terraform apply -var="ami_id=ami-xxx" -var="key_name=your-key"

# 예시: 모듈 기반 ECS 프로젝트 실행
cd terraform-ecs-module/
terraform init
terraform apply
```

> 필요한 변수들은 각 `variables.tf` 파일을 참고하여 `-var` 인자로 전달하거나, `terraform.tfvars` 파일로 구성할 수 있습니다.

---

## ✅ 실습 순서 추천

1. `ec2/` → EC2 단일 인스턴스 생성 실습
2. `method/` → 표현식 함수 실습
3. `terraform-project/` → VPC + EC2 구성 단일화 실습
4. `terraform-ecs-module/` → 모듈화 및 통합 구성

---

## 📜 참고

- [Terraform 공식 문서](https://developer.hashicorp.com/terraform/docs)
- [AWS Provider 문서](https://registry.terraform.io/providers/hashicorp/aws/latest/docs)
