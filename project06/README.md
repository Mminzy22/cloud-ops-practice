# 📘 데이터베이스 테이블 기반 API 구현 과제


## ✅ 과제 개요

**목표:**
주어진 데이터베이스 테이블 중 본인이 담당한 테이블에 대해 Spring Boot + Gradle 기반 Java 프로젝트에서 **API를 구현**

---

## ✅ 구현 범위

자신이 담당한 테이블에 대해 다음 항목을 구현해야 합니다:

| 구성 요소 | 설명 |
| --- | --- |
| **Entity** | 테이블 구조에 맞춘 자바 클래스 (JPA 기반) |
| **Repository** | JpaRepository 인터페이스 활용한 DB 접근 |
| **Service** | 비즈니스 로직 구현 (CRUD 등) |
| **Controller** | REST API 엔드포인트 구현 (GET/POST/PUT/DELETE 등) |

---

### ✅ 1. users (사용자 정보) - 구태연

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| user_id | INT PK AUTO_INCREMENT | 사용자 ID |
| username | VARCHAR(50) | 로그인 ID |
| email | VARCHAR(100) | 이메일 |
| name | VARCHAR(100) | 이름 |
| role | VARCHAR(20) | 사용자 역할 |
| status | ENUM('active', 'inactive') | 계정 상태 |
| created_at | DATETIME | 생성일 |

> 요구사항: 이메일 주소는 고유해야 하며, 중복된 계정 생성을 방지해야 한다.
> 

---

### ✅ 2. departments (부서 정보) - 김동현

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| department_id | INT PK AUTO_INCREMENT | 부서 ID |
| name | VARCHAR(100) | 부서명 |
| manager_id | INT FK → users(user_id) | 부서장 |

> 요구사항: 하나의 부서에는 반드시 한 명의 부서장이 지정되어야 한다.
> 

---

### ✅ 3. projects (프로젝트 관리) - 김아람

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| project_id | INT PK AUTO_INCREMENT | 프로젝트 ID |
| name | VARCHAR(100) | 프로젝트명 |
| description | TEXT | 설명 |
| start_date | DATE | 시작일 |
| end_date | DATE | 종료일 |
| status | ENUM('planned','ongoing','completed') | 상태 |

> 요구사항: 종료일은 시작일보다 이후여야 한다.
> 

---

### ✅ 4. project_tasks (프로젝트 작업) - 김영지

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| task_id | INT PK AUTO_INCREMENT | 작업 ID |
| project_id | INT FK -> projects(project_id) | 프로젝트 |
| title | VARCHAR(200) | 작업 제목 |
| assigned_to | INT FK -> users(user_id) | 담당자 |
| due_date | DATE | 마감일 |
| status | ENUM('open', 'in_progress', 'done') | 상태 |

> 요구사항: 완료된 작업은 반드시 담당자가 지정되어 있어야 한다.
> 

---

### ✅ 5. clients (고객 정보) - 민동일

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| client_id | INT PK AUTO_INCREMENT | 고객 ID |
| name | VARCHAR(100) | 고객명 |
| industry | VARCHAR(50) | 산업군 |
| contact_name | VARCHAR(100) | 담당자 이름 |
| contact_email | VARCHAR(100) | 담당자 이메일 |
| created_at | DATETIME | 등록일 |

> 요구사항: 동일 이메일 주소로 두 개의 고객을 등록할 수 없다.
> 

---

### ✅ 6. sales (판매 내역) - 박광훈

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| sale_id | INT PK AUTO_INCREMENT | 판매 ID |
| client_id | INT FK -> clients(client_id) | 고객 |
| product_id | INT FK -> products(product_id) | 상품 |
| quantity | INT | 수량 |
| unit_price | DECIMAL(10,2) | 단가 |
| sale_date | DATE | 판매일 |

> 요구사항: 수량과 단가는 모두 0보다 커야 한다.
> 

---

### ✅ 7. products (상품 목록) - 박민지

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| product_id | INT PK AUTO_INCREMENT | 상품 ID |
| name | VARCHAR(100) | 상품명 |
| description | TEXT | 설명 |
| category | VARCHAR(50) | 카테고리 |
| price | DECIMAL(10,2) | 기준 가격 |
| stock_qty | INT | 재고 수량 |

> 요구사항: 상품 재고가 0보다 작을 수 없다.
> 

---

### ✅ 8. inventory_movements (재고 이동) - 방지현

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| movement_id | INT PK AUTO_INCREMENT | 이동 ID |
| product_id | INT FK -> products(product_id) | 상품 |
| movement_type | ENUM('in', 'out') | 이동 유형 |
| quantity | INT | 수량 |
| movement_date | DATE | 이동일 |

> 요구사항: 출고(out)의 경우 재고보다 많은 수량은 이동할 수 없다.
> 

---

### ✅ 9. employees (사원 정보) - 안희빈

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| employee_id | INT PK AUTO_INCREMENT | 사원 ID |
| name | VARCHAR(100) | 이름 |
| department_id | INT FK -> departments(department_id) | 부서 |
| position | VARCHAR(50) | 직급 |
| hire_date | DATE | 입사일 |

> 요구사항: 퇴사일 컬럼 없이, 입사일만으로 근속 여부를 판단한다.
> 

---

### ✅ 10. leaves (휴가 기록) - 이승연

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| leave_id | INT PK AUTO_INCREMENT | 휴가 ID |
| employee_id | INT FK -> employees(employee_id) | 사원 |
| leave_type | ENUM('annual', 'sick', 'etc') | 유형 |
| start_date | DATE | 시작일 |
| end_date | DATE | 종료일 |
| status | ENUM('requested','approved','rejected') | 승인 상태 |

> 요구사항: 연속된 휴가는 최대 15일까지 가능하다.
> 

---

### ✅ 11. timesheets (근무시간 기록) - 이진우

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| timesheet_id | INT PK AUTO_INCREMENT | 타임시트 ID |
| employee_id | INT FK -> employees(employee_id) | 사원 |
| work_date | DATE | 근무일 |
| hours_worked | DECIMAL(4,2) | 근무 시간 |

> 요구사항: 하루 근무 시간은 최대 24시간을 초과할 수 없다.
> 

---

### ✅ 12. meetings (회의 일정) - 이태빈

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| meeting_id | INT PK AUTO_INCREMENT | 회의 ID |
| title | VARCHAR(200) | 제목 |
| scheduled_at | DATETIME | 회의 일정 |
| organizer_id | INT FK -> users(user_id) | 주최자 |
| location | VARCHAR(200) | 장소 또는 링크 |

> 요구사항: 같은 시간에 같은 장소에서 중복된 회의는 불가하다.
> 

---

### ✅ 13. tickets (이슈 티켓) - 이혜민

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| ticket_id | INT PK AUTO_INCREMENT | 티켓 ID |
| title | VARCHAR(200) | 제목 |
| description | TEXT | 내용 |
| status | ENUM('open', 'in_progress', 'closed') | 상태 |
| priority | ENUM('low','medium','high') | 우선순위 |
| created_by | INT FK -> users(user_id) | 작성자 |

> 요구사항: 상태가 closed인 경우 수정할 수 없다.
> 

---

### ✅ 14. notifications (알림) - 임정우

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| notification_id | INT PK AUTO_INCREMENT | 알림 ID |
| user_id | INT FK -> users(user_id) | 사용자 |
| message | TEXT | 메시지 |
| read_flag | BOOLEAN DEFAULT false | 읽음 여부 |
| created_at | DATETIME | 생성 시각 |

> 요구사항: 읽지 않은 알림은 대시보드에 표시된다.
> 

---

### ✅ 15. logs (로그 기록) - 장성현

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| log_id | INT PK AUTO_INCREMENT | 로그 ID |
| user_id | INT FK -> users(user_id) | 사용자 |
| action | VARCHAR(100) | 작업명 |
| ip_address | VARCHAR(45) | IP 주소 |
| created_at | DATETIME | 시간 |

> 요구사항: 로그는 1년 이상 보관된다.
> 

---

### ✅ 16. api_keys (API 키) - 정용훈

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| key_id | INT PK AUTO_INCREMENT | 키 ID |
| user_id | INT FK -> users(user_id) | 사용자 |
| api_key | CHAR(64) | API 키 |
| expires_at | DATETIME | 만료일 |

> 요구사항: 만료된 키는 인증에 사용될 수 없다.
> 

---

### ✅ 17. audit_trails (감사 로그) - 하영현

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| audit_id | INT PK AUTO_INCREMENT | 감사 ID |
| entity | VARCHAR(50) | 대상 테이블명 |
| entity_id | INT | 변경된 ID |
| action | VARCHAR(20) | 삽입/수정/삭제 |
| changed_by | INT FK -> users(user_id) | 변경자 |
| changed_at | DATETIME | 변경 시각 |

> 요구사항: 모든 데이터 변경은 감사 로그에 기록되어야 한다.
> 

---

### ✅ 18. payments (지불 정보) - 윤병창

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| payment_id | INT PK AUTO_INCREMENT | 지불 ID |
| client_id | INT FK -> clients(client_id) | 고객 |
| amount | DECIMAL(12,2) | 금액 |
| method | VARCHAR(20) | 방법 |
| paid_at | DATETIME | 결제 시각 |

> 요구사항: 지불 금액은 음수일 수 없다.
> 

---

### ✅ 19. documents (문서 저장소) - 이상윤

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| doc_id | INT PK AUTO_INCREMENT | 문서 ID |
| title | VARCHAR(200) | 제목 |
| owner_id | INT FK -> users(user_id) | 소유자 |
| file_path | VARCHAR(255) | 경로 |
| created_at | DATETIME | 업로드 시점 |

> 요구사항: 파일 경로는 시스템 내에서 유일해야 한다.
> 

---

### ✅ 20. announcements (공지사항) - 고준호

| 컬럼명 | 타입 | 설명 |
| --- | --- | --- |
| announcement_id | INT PK AUTO_INCREMENT | 공지 ID |
| title | VARCHAR(200) | 제목 |
| content | TEXT | 본문 |
| created_by | INT FK -> users(user_id) | 작성자 |
| published_at | DATETIME | 게시 시각 |

> 요구사항: 공지사항은 게시 후 수정 불가 옵션을 가질 수 있다.
>
