# 📘 Java 학습 과제 정리 (Basic & Advanced)

Java의 기초 문법부터 디자인 패턴까지 실습 중심으로 정리한 학습 과제 모음입니다.  
각 과제는 `Basic Unit`과 `Advanced Unit`으로 나뉘며, 토글 형식(`<details>`)을 통해 세부 내용을 확인할 수 있습니다.

---

<details>
<summary><strong>📘 Basic unit 01 – 클래스와 객체</strong></summary>

<br>

## 1. 클래스 와 객체

## 🧑‍💻 **과제 개요**

- **주제**: "간단한 도서 관리 시스템(Book Management System)" 만들기

---

## 📚 **과제 상세 내용**

### 1️⃣ 기본 클래스 설계

아래 클래스들을 설계하고 구현합니다.

### ✅ `Book` 클래스

- **필드**
    - `String title`
    - `String author`
    - `String isbn`
    - `boolean isBorrowed`
- **메서드**
    - 생성자
    - `borrowBook()` — 대여 처리
    - `returnBook()` — 반납 처리
    - `toString()` — 책 정보 문자열 반환

---

### ✅ `Member` 클래스

- **필드**
    - `String name`
    - `String memberId`
    - `ArrayList<Book> borrowedBooks`
- **메서드**
    - 생성자
    - `borrow(Book book)` — 책 대여
    - `returnBook(Book book)` — 책 반납
    - `listBorrowedBooks()` — 대여 중인 책 목록 출력

---

### ✅ `Library` 클래스

- **필드**
    - `ArrayList<Book> books`
    - `ArrayList<Member> members`
- **메서드**
    - `addBook(Book book)`
    - `addMember(Member member)`
    - `findBookByTitle(String title)`
    - `listAllBooks()`
    - `listAvailableBooks()`

</details>

---

<details>
<summary><strong>📘 Basic unit 02 – 캡슐화</strong></summary>

<br>

## 🟢 문제 1: 기본 캡슐화 연습

### 💬 문제

`Account` 클래스를 작성하세요.

- **필드** *(모두 private)*
  - `String accountNumber`
  - `String ownerName`
  - `double balance`
- **메서드**
  - `deposit(double amount)` — 입금
  - `withdraw(double amount)` — 출금
  - `printAccountInfo()` — 계좌 정보 출력

### ✅ 요구사항

- 외부에서 `balance` 값을 직접 변경할 수 없도록 하고, 반드시 `deposit()`과 `withdraw()`를 통해서만 변경하도록 설계하세요.
- 잔액이 부족할 때 출금이 불가능하도록 처리하세요.
- 실행해볼 수 있는 `Main` 메소드 (`AccountProcessor` 클래스)를 만드세요.

---

## 🟠 문제 2: 캡슐화 심화

### 💬 문제

`Employee` 클래스를 작성하세요.

- **필드** *(모두 private)*
  - `String name`
  - `double salary`
  - `String department`
- **메서드**
  - 생성자
  - Getter (모든 필드)
  - Setter (`salary`는 Setter 제공하지 않음)
  - `changeDepartment(String newDepartment)` — 부서 변경

### ✅ 요구사항

- `salary`는 외부에서 수정할 수 없도록 하고, 읽기만 가능하게 하세요.
- 부서는 `changeDepartment()` 메서드를 통해서만 변경할 수 있도록 설계하세요.
- 실행해볼 수 있는 `Main` 메소드 (`EmployeeProcessor` 클래스)를 만드세요.

</details>

---

<details>
<summary><strong>📙 advanced unit 01 – SRP(단일 책임 원칙)</strong></summary>

<br>

## 📌 과제 개요

- **목적**: 단일 책임 원칙(Single Responsibility Principle, SRP)을 이해하고 코드에 적용
- **언어**: Java (다른 OOP 언어도 가능)
- **주제**: "리포트 생성 및 출력 프로그램" 개선

---

## 🎯 과제 시나리오

한 회사에서 간단한 보고서(Report)를 작성하고 출력하는 프로그램을 개발했습니다.  
그러나 처음 작성된 코드는 **단일 클래스가 여러 가지 역할**을 동시에 하고 있어 유지보수와 확장에 어려움이 있습니다.

---

## ⚠️ 초기 코드

```java
public class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void printReport() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }

    public void saveToFile(String fileName) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(fileName);
            writer.write("Title: " + title + "\n");
            writer.write("Content: " + content + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 🔍 문제점

* `Report` 클래스가 다음 역할을 **모두** 수행하고 있음:

  * 데이터 관리 (제목, 내용)
  * 보고서 출력
  * 파일 저장
* 이로 인해 **단일 책임 원칙 위배**:

  * 변경 사항이 생길 때마다 **한 클래스에 여러 이유로 수정**이 필요함
  * 출력 방식이 바뀌거나, 저장 방식이 바뀌면 Report 자체를 수정해야 함

</details>

---

<details>
<summary><strong>📘 Basic unit 03 – 조건문과 OOP 실습</strong></summary>

<br>

## 🟢 과제 개요

이 과제에서는 **객체 지향 프로그래밍(OOP)의 기본 개념**과 **조건문**을 함께 연습합니다.  
학생들은 실제 객체를 설계하고, 객체의 속성과 메서드를 작성하며, 조건문을 통해 로직을 제어하는 코드를 작성하게 됩니다.

---

## 🟢 과제 시나리오

여러분은 **온라인 쇼핑몰**의 시스템을 개발하는 개발자입니다.  
쇼핑몰에는 여러 고객(`Customer`)이 있으며, 고객은 **회원 등급에 따라 할인 혜택**을 받습니다.

회원 등급은 다음과 같습니다:

- **BASIC**: 할인 없음
- **SILVER**: 5% 할인
- **GOLD**: 10% 할인

---

## 🟢 요구사항

### 1️⃣ `Customer` 클래스 작성

- **필드(속성)**:
  - `String name`
  - `String grade`
  - `int point`

- **메서드**:
  - `int calculateDiscountPrice(int price)`  
    → 입력받은 상품 가격에서 **회원 등급에 따라 할인된 가격을 반환**합니다.
  - `void showCustomerInfo()`  
    → **고객 이름, 등급, 적립 포인트를 출력**합니다.

---

### 2️⃣ 조건문 사용

- `calculateDiscountPrice()` 메서드 내부에서  
  `if-else` 조건문을 사용하여 등급에 따른 할인률을 계산합니다.

---

## 🟢 추가 과제 (선택)

- `earnPoints(int price)` 메서드를 만들어서  
  → **구매 금액의 1%를 적립 포인트로 추가**하는 기능을 구현하세요.

- 고객 등급에 따라 **추가 포인트를 더 주는 방식으로 확장**해보세요.

예:
- GOLD 등급: 기본 1% + 추가 2% → 총 3% 포인트 적립
- SILVER 등급: 기본 1% + 추가 1% → 총 2% 포인트 적립

</details>

---

<details>
<summary><strong>📙 Advanced unit 02 – OCP & 전략 패턴 기반 알림 시스템</strong></summary>

<br>

## 🧑‍💻 과제 시나리오: 알림(Notification) 시스템 설계

---

### 💡 배경

당신은 한 스타트업의 개발자입니다.  
회사에서는 다양한 방식(이메일, SMS, 앱 푸시 등)으로 사용자에게 알림을 보냅니다.  
기존에는 **이메일 알림만 존재**했지만, 앞으로는 **다양한 알림 방식이 추가될 예정**입니다.

---

## ✅ 단계별 구현

### ✅ 단계 1: 기본 구현

- `Notification` 클래스 작성
  - `send()` 메서드 구현 → `"이메일 전송 완료"` 출력
- `main()` 메서드에서 `Notification` 객체를 생성하고 `send()` 호출
  - 단일 이메일 알림 전송 기능만 포함

---

### ✅ 단계 2: 새로운 요구사항 추가

- 마케팅 팀 요청으로 **SMS 알림 기능을 추가**
- 기존 코드를 **최대한 수정하지 않고** 기능 확장
- 🔑 **힌트**: OCP(Open-Closed Principle) 원칙 적용 → 기존 클래스는 그대로 두고 새로운 클래스를 추가하여 확장

---

### ✅ 단계 3: 인터페이스/추상 클래스 도입

- `Notification` 인터페이스(또는 추상 클래스)를 정의
  - `send()` 메서드 선언
- 하위 구현 클래스 작성:
  - `EmailNotification`
  - `SMSNotification`
- `main()` 메서드에서 `Notification` 타입으로 객체를 생성해 호출
  - → **알림 방식이 유연하게 교체 가능**

---

### ✅ 단계 4: 추가 확장

- `PushNotification` 클래스 추가
- 클라이언트 코드에서 **알림 방식을 조합**하여 여러 방식으로 전송 가능하도록 구현

예:
```java
List<Notification> notifications = List.of(
    new EmailNotification(),
    new SMSNotification(),
    new PushNotification()
);

for (Notification n : notifications) {
    n.send();
}
```

---

### ✅ ✨ 보너스 미션: 전략 패턴(Strategy Pattern) 적용

* 알림 전송 방식을 **전략 패턴으로 설계**
* `NotificationSender` 클래스가 전략(`Notification` 인터페이스 구현체)을 받아서 실행

예:

```java
public class NotificationSender {
    private Notification strategy;

    public NotificationSender(Notification strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.send();
    }
}
```

* 이렇게 하면 실행 시점에 전략을 바꾸는 유연한 알림 시스템을 만들 수 있습니다.

</details>

---

<details>
<summary><strong>📘 Basic unit 04 – 학생 관리 프로그램</strong></summary>

<br>

## 📝 과제: 학생 관리 프로그램 만들기

---

### 📄 과제 내용

1. `Student` 클래스를 작성하세요.

- **속성**:
  - `String name`
  - `int score`

- **메서드**:
  - `void printInfo()` — 학생의 점수를 출력
  - `boolean getHighScore()` — 점수가 90점 이상이면 true 반환

---

2. `Main` 클래스에서 다음 작업을 수행하세요.

- `Student` 객체 5개 이상 생성
- `ArrayList<Student>`에 추가
- `for` 반복문으로 모든 학생의 정보를 출력

---

3. 평균 점수 구하기

- 모든 학생의 평균 점수를 구하고 출력하세요.

---

4. 🔁 선택 과제 (optional)

- `getHighScore()`를 활용해 90점 이상 학생만 출력하기
- 학생을 **점수 순서대로 정렬**하여 출력하기
- `Scanner`를 사용하여 **사용자로부터 학생 정보 입력받기** 기능 추가

</details>

---

<details>
<summary><strong>📙 Advanced unit 03 – ISP(인터페이스 분리 원칙)</strong></summary>

<br>

## 💡 과제 시나리오

### 🔌 배경

당신은 **스마트 홈 시스템**을 개발 중입니다.  
여러 기기(에어컨, 세탁기, 냉장고, 조명 등)가 하나의 공통 인터페이스를 구현하도록 설계되어 있습니다.

```java
public interface SmartDevice {
    void turnOn();
    void turnOff();
    void setTemperature(int temp);
    void setTimer(int seconds);
    void playMusic(String song);
}
````

---

### ⚠️ 문제점

* 모든 기기에 `setTemperature()`와 `playMusic()` 기능이 필요하지 않음
* 예: **조명은 온도 조절/음악 재생 불필요**
* 따라서 이 인터페이스는 **ISP(Interface Segregation Principle)** 를 위반하고 있음

---

## 🛠️ 과제 내용

### 1️⃣ 기존 인터페이스 분석

* 위 인터페이스가 **왜 ISP를 위반하는지** 이유를 문서화하세요.
* 필요하지 않은 기능을 강제로 구현하게 만드는 것이 왜 문제가 되는지 정리

---

### 2️⃣ 인터페이스 재설계

* 기능별로 **작은 인터페이스**로 분리

예시:

```java
public interface PowerControllable {
    void turnOn();
    void turnOff();
}

public interface TemperatureControllable {
    void setTemperature(int temp);
}

public interface MusicPlayable {
    void playMusic(String song);
}

public interface TimerControllable {
    void setTimer(int seconds);
}
```

---

### 3️⃣ 구체 클래스 구현

아래 세 기기를 구현하고, **필요한 인터페이스만 구현**하도록 작성하세요:

* `Light` 클래스 → `PowerControllable`만 구현
* `AirConditioner` 클래스 → `PowerControllable`, `TemperatureControllable`
* `SmartSpeaker` 클래스 → `PowerControllable`, `MusicPlayable`

> 각 클래스에서 필요 없는 기능을 포함하지 않도록 인터페이스를 분리하여 설계하세요.

</details>

---

<details>
<summary><strong>📘 Basic unit 05 – Book 클래스 생성자 오버로딩 실습</strong></summary>

<br>

## 📘 과제 제목: Book 클래스 만들기

---

### 📌 목적

- 클래스 설계
- 생성자 오버로딩 연습
- 필드 초기화 확인

---

### 🧩 요구 사항

#### ✅ 1. `Book` 클래스 정의

다음과 같은 **필드**를 갖는 `Book` 클래스를 생성하세요:

- `String title` : 책 제목
- `String author` : 저자
- `int price` : 가격

---

#### ✅ 2. 생성자 오버로딩

- **기본 생성자**  
  → 제목, 저자, 가격을 `"제목 없음"`, `"저자 미상"`, `0`으로 초기화

- **매개변수 2개 생성자**  
  → 제목과 저자를 받아 초기화하고 가격은 `0`으로 설정

- **매개변수 3개 생성자**  
  → 모든 필드를 전달받아 초기화

---

#### ✅ 3. 출력용 메서드

- `void printInfo()` 메서드를 작성하세요.  
  → 다음 형식으로 출력되도록 구현:
```

제목: OOO / 저자: OOO / 가격: OOO원

````

</details>

---

<details>
<summary><strong>📙 Advanced unit 04 – LSP(리스코프 치환 원칙) 실습 과제</strong></summary>

<br>

## ✨ 실습 과제

---

### ✅ 문제 1: `Rectangle`과 `Square` 설계하기

1. `Shape`라는 추상 클래스를 작성하세요.

- 추상 메서드: `int getArea()`

2. `Rectangle` 클래스를 작성하세요.

- 속성: `width`, `height`
- 메서드:
  - `setWidth(int width)`
  - `setHeight(int height)`
  - `getArea()`

3. `Square` 클래스를 작성하세요.

- `Rectangle` 클래스를 **상속**
- `setWidth()`와 `setHeight()`를 **재정의**
  - 항상 **가로 = 세로**가 되도록 설정

4. `Main` 클래스에서 실험 코드 작성:

```java
Rectangle rect = new Square();
rect.setWidth(5);
rect.setHeight(10);
System.out.println(rect.getArea());
````

* ❓ 예상한 넓이와 실제 출력된 넓이가 왜 다른지 설명하세요.

---

### ✅ 문제 2: LSP 위반 분석하기

* 위 코드에서 발생한 문제를 **분석**하세요.
* ❓ `Square`가 `Rectangle`을 상속받으면 안 되는 이유는?
* ❓ 리스코프 치환 원칙(LSP)의 관점에서 **위반된 부분은 무엇인가요?**

---

### ✅ 문제 3: 설계를 개선하기

* `Square`가 `Rectangle`을 **상속받지 않도록 변경**

* `Rectangle`, `Square` 모두 **`Shape`를 직접 상속**하도록 변경

* 각각의 클래스에서 `getArea()`를 올바르게 구현

* `Main` 클래스에서 `Shape[]` 또는 `List<Shape>`에
  `Rectangle`, `Square` 객체를 담고 **반복문으로 넓이 출력**

* ❓ 개선된 설계가 어떻게 **LSP를 만족**하게 되었는지 설명하세요.

</details>

---

<details>
<summary><strong>📘 Basic unit 06 – Java Lambda 기본 개념 및 실습</strong></summary>

<br>

## 💡 Java Lambda란?

**람다(Lambda Expression)**는 간단한 "익명 함수"를 표현하는 문법입니다.  
Java 8부터 도입되었으며, 주로 아래의 목적을 위해 사용됩니다:

- 불필요한 익명 클래스 제거
- 코드 간결화
- 컬렉션/스트림 처리 간편화

---

## ✍️ 기본 문법

```java
(매개변수) -> { 실행문 }
````

### ✅ 예제 1: 간단한 함수

```java
(x, y) -> x + y
```

### ✅ 예제 2: 매개변수 하나

```java
n -> n * n
```

(괄호 생략 가능)

### ✅ 예제 3: 블록 형태

```java
(x, y) -> {
    int sum = x + y;
    return sum;
}
```

---

## 🧩 클래스 vs Lambda 비교

### <클래스 방식>

```java
public class Calculator {
    public static int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println("5 + 3 = " + result);
    }
}
```

### \<Lambda 방식>

```java
import java.util.function.BiFunction;

public class Calculator {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

        int result = add.apply(5, 3);
        System.out.println("5 + 3 = " + result);
    }
}
```

---

## ✅ 함수형 인터페이스

람다는 반드시 **함수형 인터페이스**와 함께 사용됩니다.

> 함수형 인터페이스: 추상 메서드가 **하나만 있는** 인터페이스
> 예: `Runnable`, `Comparator<T>`, `Function<T, R>`, `Predicate<T>`, ...

### Runnable 예제

```java
Runnable run = () -> System.out.println("Hello Lambda!");
run.run();
```

### Comparator 예제

```java
Comparator<Integer> comp = (a, b) -> a - b;
int result = comp.compare(5, 3);  // 출력: 2
```

---

## 💬 Stream과 함께 사용

```java
List<String> list = List.of("apple", "banana", "orange");

list.stream()
    .filter(s -> s.contains("a"))
    .forEach(s -> System.out.println(s));
```

---

## ✅ 문법 축약 규칙

* 매개변수 하나면 괄호 생략 가능
* 실행문 하나면 중괄호 `{}` 생략 가능
* `return`도 생략 가능

### 예시 (비교):

```java
// 익명 클래스 방식
Comparator<String> comp = new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
};

// 람다식
Comparator<String> comp = (a, b) -> a.compareTo(b);
```

---

## 🧩 함수형 인터페이스 예시

```java
@FunctionalInterface
interface MyFunction {
    int doSomething(int x, int y);
}

// 사용 예
MyFunction add = (a, b) -> a + b;
System.out.println(add.doSomething(3, 4));  // 출력: 7
```

---

## 🧰 주요 함수형 인터페이스 (java.util.function)

| 인터페이스             | 메서드 시그니처              | 설명                      |
| ----------------- | --------------------- | ----------------------- |
| Function\<T, R>   | `R apply(T t)`        | 입력 T → 출력 R             |
| Consumer<T>       | `void accept(T t)`    | 입력만 있고 출력 없음            |
| Supplier<T>       | `T get()`             | 입력 없이 T를 반환             |
| Predicate<T>      | `boolean test(T t)`   | 조건 판별                   |
| UnaryOperator<T>  | `T apply(T t)`        | T → T (Function 특수화)    |
| BinaryOperator<T> | `T apply(T t1, T t2)` | T, T → T (Function 특수화) |

---

## 🧪 실습 예제

### ✅ 1. Runnable - 쓰레드 실행 간단화

```java
public class LambdaExample1 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Thread 1 실행");
            }
        };

        Runnable r2 = () -> System.out.println("Thread 2 실행");

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
```

---

### ✅ 2. Comparator - 리스트 정렬

```java
import java.util.*;

public class LambdaExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kim", "Lee", "Park", "Choi");

        names.sort((a, b) -> a.length() - b.length());

        names.forEach(System.out::println);
    }
}
```

---

### ✅ 3. Consumer - forEach로 출력

```java
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

public class LambdaExample3 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30);

        Consumer<Integer> printNum = n -> System.out.println("값: " + n);

        nums.forEach(printNum);
    }
}
```

---

### ✅ 4. Predicate - 조건 필터링

```java
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.List;

public class LambdaExample4 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("apple", "banana", "avocado", "grape");

        Predicate<String> startsWithA = s -> s.startsWith("a");

        names.stream()
            .filter(startsWithA)
            .forEach(System.out::println); // 출력: apple, avocado
    }
}
```

---

### ✅ 5. Function - 변환 후 출력

```java
import java.util.function.Function;
import java.util.Arrays;
import java.util.List;

public class LambdaExample5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");

        Function<String, Integer> lengthFunction = s -> s.length();

        list.stream()
            .map(lengthFunction)
            .forEach(System.out::println); // 출력: 3, 3, 5
    }
}
```

---

## ⚠️ 주의사항

* 람다는 반드시 추상 메서드가 **1개뿐인 인터페이스(@FunctionalInterface)** 에서만 사용 가능
* 상태 없는(stateless) 방식으로 사용하는 것이 바람직
* Checked Exception은 람다 내부에서 반드시 **try-catch 처리하거나 throws** 해야 함

</details>

---

<details>
<summary><strong>📘 Basic unit 07 – 상속과 super()</strong></summary>

<br>

## 📁 예제 구조 요약

- **부모 클래스**: `Person`
- **자식 클래스 1**: `Student`
- **자식 클래스 2**: `Worker`
- 메인 클래스에서 각 객체를 생성하고, 상속된 메서드와 고유 메서드를 호출

---

## 💡 클래스 설계

### 1. `Person` 클래스 (부모)

```java
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("안녕하세요, 저는 " + name + "이고 나이는 " + age + "살입니다.");
    }
}
```

---

### 2. `Student` 클래스 (자식)

```java
public class Student extends Person {
    String school;

    public Student(String name, int age, String school) {
        super(name, age); // 부모 생성자 호출
        this.school = school;
    }

    public void study() {
        System.out.println(name + "은(는) " + school + "에서 공부하고 있습니다.");
    }
}
```

---

### 3. `Worker` 클래스 (자식)

```java
public class Worker extends Person {
    String company;

    public Worker(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }

    public void work() {
        System.out.println(name + "은(는) " + company + "에서 일하고 있습니다.");
    }
}
```

---

### 4. `Main` 클래스에서 객체 생성 및 실행

```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("지민", 20, "서울대학교");
        Worker w = new Worker("민수", 30, "카카오");

        s.introduce(); // Person 클래스 메서드
        s.study();     // Student 클래스 메서드

        System.out.println();

        w.introduce(); // Person 클래스 메서드
        w.work();      // Worker 클래스 메서드
    }
}
```

---

## 🖥️ 실행 결과

```bash
안녕하세요, 저는 지민이고 나이는 20살입니다.
지민은(는) 서울대학교에서 공부하고 있습니다.

안녕하세요, 저는 민수이고 나이는 30살입니다.
민수은(는) 카카오에서 일하고 있습니다.
```

---

## 🎯 연습 포인트

* `super()`를 통한 생성자 호출
* 상속된 메서드(`introduce`) 사용
* 자식 클래스 고유 메서드 호출
* 객체 다형성 연습 (업캐스팅/다운캐스팅 추가 가능)

</details>

---


<details>
<summary><strong>📙 Advanced unit 05 – DIP(의존 역전 원칙)</strong></summary>

<br>

# 📘 DIP 과제 : 결제 시스템 설계

---

## 🎯 과제 목표

- DIP(Dependency Inversion Principle)를 통해 결제 시스템의 유연성과 확장성을 확보한다.
- 추상화된 인터페이스를 중심으로 고수준 모듈이 저수준 모듈에 의존하지 않도록 설계한다.
- DIP를 통해 **“카드 → 계좌 → 포인트” 등 다양한 결제 수단을 플러그인처럼 교체 가능하게** 설계해본다.

---

## 🧾 과제 시나리오

당신은 쇼핑몰의 **결제 시스템**을 개발하고 있습니다. 기본적으로 **신용카드 결제**를 지원하며, 추후에 **계좌이체, 포인트 결제, 가상화폐 결제** 등을 추가할 수 있어야 합니다.

---

## ❌ Step 1: DIP를 위반한 결제 시스템 작성

```java
public class CardPayment {
    public void pay(int amount) {
        System.out.println("카드로 " + amount + "원 결제합니다.");
    }
}

public class OrderService {
    private CardPayment cardPayment = new CardPayment();

    public void checkout(int amount) {
        cardPayment.pay(amount);
    }
}
```

### 🔍 문제점

* `OrderService`는 `CardPayment`에 직접 의존하므로 다른 결제수단으로 확장하거나 교체하기 어려움
* DIP 위반 구조

---

## ✅ Step 2: DIP 적용하여 리팩토링

### 리팩토링 요구사항

1. **`Payment` 인터페이스**를 생성하세요.
2. `CardPayment`, `BankTransfer`, `PointPayment` 클래스는 `Payment` 인터페이스를 구현하도록 하세요.
3. `OrderService`는 `Payment` 인터페이스에만 의존하도록 변경하고, 생성자 주입을 통해 의존성을 주입받도록 하세요.

### 기대 예시

```java
public interface Payment {
    void pay(int amount);
}

public class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("카드로 " + amount + "원 결제합니다.");
    }
}

public class PointPayment implements Payment {
    public void pay(int amount) {
        System.out.println("포인트로 " + amount + "원 결제합니다.");
    }
}

public class OrderService {
    private final Payment payment;

    public OrderService(Payment payment) {
        this.payment = payment;
    }

    public void checkout(int amount) {
        payment.pay(amount);
    }
}
```

---

## 🧪 Step 3: 테스트 코드

```java
public class Main {
    public static void main(String[] args) {
        Payment card = new CardPayment();
        Payment point = new PointPayment();

        OrderService order1 = new OrderService(card);
        order1.checkout(10000);

        OrderService order2 = new OrderService(point);
        order2.checkout(5000);
    }
}
```

</details>

---

<details>
<summary><strong>📘 Basic unit 08 – 추상화(Abstraction)</strong></summary>

<br>

## 🧠 추상화(Abstraction)란?

### 📌 개념

**추상화란** 복잡한 내부 구현을 숨기고, **중요한 기능만을 외부에 드러내는 객체지향 설계 원칙**입니다.  
사용자는 *어떻게 동작하는지*보다는 *무엇을 할 수 있는지*에 집중할 수 있게 됩니다.

> "무엇을 할 수 있는지 정의하고, 어떻게 동작하는지는 숨긴다."

### 📎 Java에서 추상화 구현 방법

1. **추상 클래스 (`abstract class`)** – 일부 구현 가능, 상속 후 확장
2. **인터페이스 (`interface`)** – 구현 없이 계약(기능 정의)만, 다중 구현 가능

---

## ✅ 추상 클래스 예시

```java
abstract class Animal {
    abstract void makeSound();

    void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}
````

---

## ✅ 인터페이스 예시

```java
interface Flyable {
    void fly();
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane is flying!");
    }
}
```

---

## 🧪 추상화의 장점

| 장점      | 설명                        |
| ------- | ------------------------- |
| 코드 구조화  | 인터페이스를 통한 일관된 규약 제공       |
| 유지보수성   | 구현체만 교체하면 기능 확장 가능        |
| 다형성과 결합 | 다양한 구현체를 동일한 방식으로 다룰 수 있음 |

---

## 💻 코딩 과제

### 🎯 과제 1: `Shape` 추상 클래스

```java
abstract class Shape {
    abstract double area();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    double area() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double r) {
        this.radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(4, 5);
        Shape s2 = new Circle(3);

        System.out.println(s1.area());
        System.out.println(s2.area());
    }
}
```

---

### 🎯 과제 2: `Payment` 인터페이스

```java
interface Payment {
    void pay(int amount);
}

class CreditCardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Credit card paid: " + amount);
    }
}

class KakaoPay implements Payment {
    public void pay(int amount) {
        System.out.println("KakaoPay paid: " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Payment method;

        method = new CreditCardPayment();
        method.pay(5000);

        method = new KakaoPay();
        method.pay(7000);
    }
}
```

---

## 🔚 정리

* **추상화는 중요한 것만 외부에 보여줌**
* **추상 클래스는 공통 로직 + 템플릿 제공**
* **인터페이스는 동작 계약을 정의하고 구현은 다양한 방식으로 가능**

</details>

---

<details>
<summary><strong>📙 Advanced unit 06 – GoF 디자인 패턴: Singleton</strong></summary>

<br>

## 📖 GoF 디자인 패턴이란?

GoF(Gang of Four) 디자인 패턴은 소프트웨어 설계에서 자주 반복되는 문제를 해결하기 위한 **23가지 설계 패턴**을 체계화한 것입니다.

> 출처: 『Design Patterns: Elements of Reusable Object-Oriented Software (1994)』

---

## 🧱 패턴 분류

### 1. 생성(Creational) 패턴
- Singleton, Factory Method, Abstract Factory, Builder, Prototype

### 2. 구조(Structural) 패턴
- Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy

### 3. 행위(Behavioral) 패턴
- Observer, Strategy, Command, Iterator, Mediator, Memento, State, Template Method, Chain of Responsibility, Visitor, Interpreter

---

## 🧭 Singleton 패턴이란?

### 🔹 정의
- 하나의 인스턴스만 생성하고, 어디서든 동일한 객체를 사용할 수 있도록 보장하는 패턴

### 🔹 사용 예
- 설정 관리, 로그 시스템, DB 연결 관리, 캐시 등

---

## ✅ 1. Lazy Initialization (기본 구현)

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
````

⚠️ 멀티스레드 환경에서는 인스턴스가 2개 생성될 수 있음

---

## ✅ 2. Synchronized 방식

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

✅ 스레드 안전 / ⚠️ 성능 저하 우려

---

## ✅ 3. Double-Checked Locking

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

✅ 성능 + 스레드 안전 모두 만족
🔍 `volatile`: 중간 생성 상태에서 노출 방지

---

## ✅ 4. 내부 정적 클래스 (Lazy Holder Idiom)

```java
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

✅ 가장 안전하고 효율적인 방식
✅ Lazy Loading, 성능 우수

---

## 🧪 테스트 코드

```java
public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        System.out.println(a == b);  // true
    }
}
```

---

## 🔚 요약

| 방식                     | 스레드 안전 | 성능 | 권장 여부 |
| ---------------------- | ------ | -- | ----- |
| Lazy 초기화               | ❌      | ✅  | ❌     |
| synchronized 메서드       | ✅      | ❌  | ⚠️    |
| Double-Checked Locking | ✅      | ✅  | ✅     |
| 내부 정적 클래스              | ✅      | ✅  | ✅👍   |

</details>

---

<details>
<summary><strong>📘 Basic unit 09 – 캡슐화(Encapsulation)</strong></summary>

<br>

## 🔐 캡슐화(Encapsulation)란?

### ✅ 정의

Java에서 **캡슐화**는 클래스의 **필드(멤버 변수)**를 `private`으로 선언하여 **외부에서 직접 접근하지 못하게 막고**, **public getter/setter 메서드**를 통해 간접적으로 접근하도록 만드는 것을 말합니다.

> ➤ 핵심은 "정보 은닉 (Information Hiding)"  
> ➤ 데이터를 보호하고, 객체가 스스로 자신의 상태를 관리하도록 합니다.

---

## 🧪 실습 예제: `Student` 클래스 만들기

### 🎯 목표

- 필드에 직접 접근하지 않고 메서드로만 접근하도록 설계
- 유효성 검사 포함한 setter 메서드 활용

### 📄 `Student.java`

```java
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("점수는 0 ~ 100 사이여야 합니다.");
        }
    }

    public void printInfo() {
        System.out.println("이름: " + name + ", 점수: " + score);
    }
}
````

---

### 📄 `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("홍길동", 85);
        s1.printInfo();

        s1.setScore(95);
        s1.printInfo();

        s1.setScore(150);  // 유효성 검사 실패
    }
}
```

---

## 🔍 요약 정리

| 항목              | 설명            |
| --------------- | ------------- |
| `private`       | 외부에서 직접 접근 방지 |
| `getter/setter` | 안전한 접근 수단 제공  |
| 유효성 검사          | 무결성 유지 가능     |
| `printInfo()`   | 외부 출력 메서드 제공  |

---

## 🧩 연습 과제

1. `grade` 필드를 추가하고 1\~6만 허용하도록 설정
2. 점수를 기준으로 `"A"`, `"B"`, `"C"` 등의 등급을 반환하는 `getGradeLevel()` 메서드 작성
3. 여러 학생을 리스트에 담고 반복 출력

</details>

---

<details>
<summary><strong>📙 Advanced unit 07 – Builder 패턴</strong></summary>

<br>

## 🧱 Builder 디자인 패턴이란?

### ✅ 정의

**Builder 패턴**은 복잡한 객체의 생성 과정을 단계별로 분리하여,  
**객체 생성 로직을 캡슐화**하고 **가독성과 유연성**을 향상시키는 생성(Creational) 디자인 패턴입니다.

---

## 🎯 사용 시점

- 생성자의 매개변수가 많을 때 (가독성 저하 방지)
- 선택 필드가 다양하게 조합될 수 있을 때
- 불변 객체를 생성하고 싶을 때

---

## 📦 예제: `User` 클래스 Builder 적용

```java
public class User {
    private final String name;
    private final String email;
    private final int age;
    private final String address;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class UserBuilder {
        private final String name;
        private final String email;
        private int age;
        private String address;

        public UserBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
````

---

### 🚀 사용 예

```java
public class Main {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("홍길동", "hong@example.com")
                            .age(30)
                            .address("서울시 강남구")
                            .build();

        System.out.println(user1.getName());
        System.out.println(user1.getEmail());
    }
}
```

---

## 🧠 Builder 패턴의 장점

| 장점       | 설명              |
| -------- | --------------- |
| 가독성      | 메서드 체이닝으로 읽기 쉬움 |
| 불변성      | 생성 후 변경 불가      |
| 선택 필드 처리 | 필수/선택 필드 구분 가능  |
| 오버로딩 해결  | 매개변수 수 증가 문제 해소 |

---

## 🧪 Builder 패턴 실습 과제

### 🟢 과제 1: `Computer` 클래스

* 필수: `cpu`, `ram`
* 선택: `storage`, `graphicsCard`, `wifiEnabled`

```java
Computer comp = new Computer.Builder("Intel i7", "16GB")
                    .storage("1TB SSD")
                    .graphicsCard("RTX 4060")
                    .wifiEnabled(true)
                    .build();
```

---

### 🔴 과제 2: `Meal` 클래스

* 필수: `mainDish`, `calories`
* 선택: `sideDish`, `drink`, `dessert`, `note`
* `describe()` 메서드로 출력

```java
Meal breakfast = new Meal.Builder("오트밀", 350)
                      .sideDish("바나나")
                      .drink("두유")
                      .note("아침은 포만감 위주")
                      .build();

breakfast.describe();
```

---

## 📌 참고 팁

* Lombok의 `@Builder`도 가능하지만 직접 구현 추천
* 실무에서 자주 사용됨 (특히 DTO, 설정 객체 등)

</details>

---

<details>
<summary><strong>📘 Basic unit 10 – 제네릭(Generic)</strong></summary>

<br>

## 📌 1. 제네릭이란?

> 클래스나 메서드를 정의할 때 사용할 데이터 타입을 고정하지 않고, 사용하는 시점에서 타입을 지정할 수 있는 기능

```java
List<String> list = new ArrayList<>();
````

* `List`는 제네릭 인터페이스
* `String`은 타입 매개변수 (Type Parameter)

---

## 🎯 2. 제네릭을 사용하는 이유

| 목적        | 설명                        |
| --------- | ------------------------- |
| 타입 안전성 보장 | 컴파일 시 타입 오류 방지            |
| 형변환 제거    | Object → (String) 캐스팅 불필요 |
| 재사용성 향상   | 다양한 타입을 하나의 코드로 처리 가능     |

---

## 🧪 3. 제네릭 클래스 예제

```java
public class Box<T> {
    private T item;
    public void set(T item) { this.item = item; }
    public T get() { return item; }
}
```

```java
Box<String> box = new Box<>();
box.set("Hello");
String value = box.get();  // 형변환 없이 사용 가능
```

---

## 🧪 4. 제네릭 메서드 예제

```java
public class Util {
    public static <T> void print(T value) {
        System.out.println(value);
    }
}
```

```java
Util.print("Hello");
Util.print(123);
```

---

## ⚙️ 5. 제네릭 와일드카드

| 구문              | 의미                  |
| --------------- | ------------------- |
| `<?>`           | 어떤 타입이든 허용          |
| `<? extends T>` | T의 하위 타입 허용 (상한 제한) |
| `<? super T>`   | T의 상위 타입 허용 (하한 제한) |

```java
public void printNumbers(List<? extends Number> list) { ... }
public void addIntegers(List<? super Integer> list) { ... }
```

---

## ✅ 6. 제네릭 제한사항

* 기본형 타입 사용 불가 (`List<int>` ❌ → `List<Integer>`)
* static 필드에 타입 매개변수 사용 불가
* 타입 정보는 런타임에 소거 (Type Erasure)
* `instanceof`에서 타입 매개변수 비교 불가

---

## 📚 7. 실제 컬렉션 사용 예

```java
List<String> names = new ArrayList<>();
Map<String, Integer> scores = new HashMap<>();
```

---

## 💡 8. 제네릭과 상속

```java
List<Dog> dogList = new ArrayList<>();
List<Animal> animalList = dogList; // ❌

List<? extends Animal> animalList = dogList; // ✅
```

---

## 🧾 9. 정리표

| 문법                 | 의미                 |
| ------------------ | ------------------ |
| `class Box<T>`     | 제네릭 클래스 정의         |
| `<T> T getValue()` | 제네릭 메서드 정의         |
| `<?>`              | Unbounded wildcard |
| `<? extends T>`    | 상한 제한              |
| `<? super T>`      | 하한 제한              |

---

## ✅ 1단계: 제네릭 클래스 연습

```java
public class Box<T> {
    private T item;
    public void set(T item) { this.item = item; }
    public T get() { return item; }
}

public class Main {
    public static void main(String[] args) {
        Box<String> strBox = new Box<>();
        strBox.set("Hello");
        System.out.println(strBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());
    }
}
```

---

## ✅ 2단계: 제네릭 메서드 연습

```java
public class Util {
    public static <T> void printAll(T[] arr) {
        for (T element : arr) {
            System.out.println(element);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob"};
        Integer[] nums = {1, 2, 3};
        Util.printAll(names);
        Util.printAll(nums);
    }
}
```

---

## ✅ 3단계: 와일드카드 연습

```java
class Animal {
    public void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("멍멍!");
    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("야옹~");
    }
}

public class AnimalPrinter {
    public static void printAnimalList(List<? extends Animal> list) {
        for (Animal a : list) {
            a.sound();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Cat> cats = List.of(new Cat());
        AnimalPrinter.printAnimalList(dogs);
        AnimalPrinter.printAnimalList(cats);
    }
}
```

---

## ✅ 4단계: 제네릭 + 인터페이스 활용

```java
interface Product {
    double getPrice();
}

class Book implements Product {
    public double getPrice() { return 12000.0; }
}

class Phone implements Product {
    public double getPrice() { return 999000.0; }
}

class PriceCalculator {
    public static <T extends Product> double calculateTotal(List<T> list) {
        double total = 0;
        for (T item : list) {
            total += item.getPrice();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(new Book(), new Book());
        List<Phone> phones = List.of(new Phone());
        System.out.println("총 책 가격: " + PriceCalculator.calculateTotal(books));
        System.out.println("총 폰 가격: " + PriceCalculator.calculateTotal(phones));
    }
}
```

</details>

---

<details>
<summary><strong>📙 Advanced unit 08 – Factory Method 패턴</strong></summary>

<br>

## 🧠 Factory Method 패턴이란?

> 객체 생성을 서브클래스에 위임하는 디자인 패턴  
> 상위 클래스는 객체가 **무엇인지 모른 채**, 하위 클래스에서 생성 책임을 맡습니다.

---

## 🎯 사용 목적

| 목적             | 설명 |
|------------------|------|
| 객체 생성의 유연성 | 새로운 객체를 쉽게 생성할 수 있음 |
| DIP 준수         | 상위 클래스가 하위 구현에 의존하지 않음 |
| OCP 준수         | 기존 코드를 변경하지 않고 기능 확장 가능 |

---

## 📦 구조 구성 요소

```java
Product                // 제품 인터페이스
ConcreteProduct        // 실제 제품 구현체
Creator                // 팩토리 추상 클래스
ConcreteCreator        // 팩토리 구현체
````

---

## ✅ 실전 예제: 결제 시스템

### 1. `Payment` 인터페이스

```java
public interface Payment {
    void pay(int amount);
}
```

---

### 2. 구체 결제 클래스

```java
public class CardPayment implements Payment {
    public void pay(int amount) {
        double fee = amount * 0.02;
        System.out.println("카드 결제 완료. 수수료: " + fee + "원");
    }
}

public class KakaoPay implements Payment {
    public void pay(int amount) {
        double fee = 500;
        System.out.println("카카오페이 결제 완료. 수수료: " + fee + "원");
    }
}
```

---

### 3. 추상 팩토리 클래스

```java
public abstract class PaymentFactory {
    public void process(int amount) {
        Payment payment = createPayment();  // 객체 생성 책임 분리
        payment.pay(amount);
    }

    protected abstract Payment createPayment();  // 팩토리 메서드
}
```

---

### 4. 구체 팩토리 클래스

```java
public class CardPaymentFactory extends PaymentFactory {
    protected Payment createPayment() {
        return new CardPayment();
    }
}

public class KakaoPayFactory extends PaymentFactory {
    protected Payment createPayment() {
        return new KakaoPay();
    }
}
```

---

### 5. 클라이언트 코드

```java
public class Main {
    public static void main(String[] args) {
        PaymentFactory factory1 = new CardPaymentFactory();
        factory1.process(10000);

        PaymentFactory factory2 = new KakaoPayFactory();
        factory2.process(10000);
    }
}
```

---

## 📋 실행 결과

```
카드 결제 완료. 수수료: 200.0원
카카오페이 결제 완료. 수수료: 500.0원
```

---

## 💡 핵심 요약

| 항목     | 설명                                           |
| ------ | -------------------------------------------- |
| 핵심 메서드 | `protected abstract Payment createPayment()` |
| 역할 분리  | 객체 생성 vs 비즈니스 로직 실행 분리                       |
| 확장성    | 새로운 클래스만 추가하면 기능 확장 가능                       |

---

## 🎓 과제: 알림 시스템 – Notification Factory

### 📌 목표

* **SMS, Email, Slack** 각각의 전송 로직을 가지는 `Notification` 객체를 설계
* 팩토리 메서드로 적절한 알림 객체를 생성
* 클라이언트는 `NotificationFactory`만 이용해 전송 처리

### 예시 구조

```java
interface Notification {
    void notify(String msg);
}

class EmailNotification implements Notification { ... }
class SmsNotification implements Notification { ... }
class SlackNotification implements Notification { ... }

abstract class NotificationFactory {
    public void send(String msg) {
        Notification notification = createNotification();
        notification.notify(msg);
    }
    protected abstract Notification createNotification();
}

class EmailNotificationFactory extends NotificationFactory { ... }
class SmsNotificationFactory extends NotificationFactory { ... }
// 등등
```

> 이 구조를 통해 **새로운 알림 방식이 추가되어도 클라이언트는 그대로 유지**됩니다.

</details>

---

<details>
<summary><strong>📘 Basic unit 11 – Java List 컬렉션</strong></summary>

<br>

### Java에서 `List`란?

Java에서 `List`는 **순서가 있는 데이터 집합을 저장**하는 컬렉션 인터페이스입니다.  
중복 요소를 허용하며, 인덱스를 기반으로 요소에 접근할 수 있습니다.

---

### 주요 특징

- **순서 유지**: 삽입된 순서를 그대로 유지
- **중복 허용**: 동일한 값 여러 번 저장 가능
- **인덱스 접근**: `list.get(index)`로 접근

---

### 대표 구현 클래스

| 클래스명 | 특징 |
|----------|------|
| `ArrayList` | 배열 기반, 빠른 조회, 느린 삽입/삭제 |
| `LinkedList` | 연결 리스트 기반, 빠른 삽입/삭제, 느린 조회 |

---

### ✅ 기본 사용 예시

```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("과일 목록: " + fruits.get(0));

        fruits.remove("Banana");
        fruits.add(1, "Mango");

        System.out.println("수정된 목록: " + fruits);
        System.out.println("첫 번째 과일: " + fruits.get(0));

        // 숙제: for문으로 리스트 조회
        for (String fruit : fruits) {
            System.out.println("과일: " + fruit);
        }
    }
}
````

---

## 🧪 과제 1: 학생 이름 목록 다루기

**요구사항:**

1. 학생 이름 5명 이상 추가
2. 특정 학생 이름 삭제
3. 인덱스 기반 조회
4. 전체 목록 출력

```java
import java.util.*;

public class StudentListManager {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David", "Eve"));

        students.remove("Charlie");

        System.out.println("전체 학생 목록: " + students);
        System.out.println("인덱스 1번 학생: " + students.get(1));
    }
}
```

---

## 🧪 과제 2: 숫자 리스트 최대/최소값

**요구사항:**

1. 정수 10개 저장
2. 최대값, 최소값 출력
3. 오름차순 정렬 후 출력

```java
import java.util.*;

public class NumberAnalyzer {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 3, 8, 2, 9, 1, 6, 7, 4, 0));

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);

        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);

        Collections.sort(numbers);
        System.out.println("정렬된 리스트: " + numbers);
    }
}
```

---

## 🧪 과제 3: 사용자 입력 리스트 구성

**요구사항:**

* Scanner로 사용자에게 과일 이름 5개를 입력받아 리스트 구성 후 출력

```java
import java.util.*;

public class FruitCollector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> fruits = new ArrayList<>();

        System.out.println("과일 이름 5개를 입력하세요:");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + "번째 과일: ");
            fruits.add(sc.nextLine());
        }

        System.out.println("입력된 과일 목록: " + fruits);
    }
}
```

---

## ✅ 요약

| 항목                        | 설명                   |
| ------------------------- | -------------------- |
| `List<T>`                 | 순서가 있는 데이터 저장용 인터페이스 |
| `ArrayList`               | 빠른 조회, 느린 삽입/삭제      |
| `LinkedList`              | 빠른 삽입/삭제, 느린 조회      |
| `Collections.sort()`      | 정렬 기능 제공             |
| `Collections.max()/min()` | 최대/최소값 계산            |

</details>

---

<details>
<summary><strong>📙 Advanced unit 09 – Prototype 패턴</strong></summary>

<br>

## 🧭 Prototype 패턴이란?

> 기존 객체를 복제하여 새로운 객체를 생성하는 GoF 생성(Creational) 디자인 패턴 중 하나입니다.

---

### 🔤 정의

- `new` 키워드 대신 `clone()`을 사용하여 **객체 복제**
- 복잡하거나 비용이 큰 객체 생성을 **최소화**
- **런타임에 타입을 몰라도 복제 가능**

---

## 🔧 UML 구조

```

+----------------+       +------------------------+
\|   Prototype    |<------+    ConcretePrototype   |
\| +clone()\:Obj   |       | +clone()\:Obj           |
+----------------+       +------------------------+
^
|
+----------------+
\|    Client      |
+----------------+

````

---

## ✅ 특징

| 항목 | 설명 |
|------|------|
| 복제 방식 | 얕은 복사 vs 깊은 복사 |
| 유연성 | 타입에 독립적으로 객체 생성 가능 |
| 성능 | 복잡한 초기화 생략 가능 |
| 주의점 | 깊은 복사 구현 시 오류 유발 가능 |

---

## 🎯 장단점 요약

### ✅ 장점

- 빠른 객체 생성
- 공통 설정 재사용
- 생성 로직 캡슐화 가능

### ❌ 단점

- 깊은 복사가 필요할 경우 구현 복잡도 증가
- 내부 참조가 많을수록 실수 유발 가능

---

## 📁 클래스 구조

- `Shape`: 추상 클래스 (implements `Cloneable`)
- `Circle`, `Rectangle`: `Shape`를 상속하며 복제 구현
- `PrototypeDemo`: 클라이언트 실행부

---

### 🔤 Shape.java

```java
public abstract class Shape implements Cloneable {
    private String color;

    public void setColor(String color) { this.color = color; }
    public String getColor() { return color; }

    public abstract void draw();

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}
````

---

### 🔵 Circle.java

```java
public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius " + radius + " and color " + getColor());
    }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
}
```

---

### 🟥 Rectangle.java

```java
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle " + width + "x" + height + " with color " + getColor());
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
}
```

---

### 🧪 PrototypeDemo.java

```java
public class PrototypeDemo {
    public static void main(String[] args) {
        // 원형 객체 생성
        Circle circle1 = new Circle(10);
        circle1.setColor("Red");

        // 복제
        Circle circle2 = (Circle) circle1.clone();
        circle2.setColor("Blue");

        circle1.draw();  // Red
        circle2.draw();  // Blue

        // Rectangle 예시
        Rectangle rect1 = new Rectangle(5, 7);
        rect1.setColor("Green");

        Rectangle rect2 = (Rectangle) rect1.clone();
        rect2.setWidth(10);  // 복제 후 개별 속성 변경

        rect1.draw();  // 5x7
        rect2.draw();  // 10x7
    }
}
```

---

## ✅ 실행 결과 예시

```
Drawing Circle with radius 10 and color Red
Drawing Circle with radius 10 and color Blue
Drawing Rectangle 5x7 with color Green
Drawing Rectangle 10x7 with color Green
```

---

## 💡 Prototype 패턴은 언제 유용한가?

* 객체 생성 비용이 클 때
* 설정이 반복되는 객체가 많을 때
* 다형성과 결합하여 객체를 유연하게 생성하고자 할 때

</details>

---

<details>
<summary><strong>📘 Basic unit 12 – 예외 처리 (Exception)</strong></summary>

<br>

## 1. 🧠 예외란 무엇인가?

- 예외(Exception)란 프로그램 실행 중 발생하는 **예기치 못한 상황**
- 예외가 발생하면 프로그램 흐름이 비정상적으로 종료될 수 있음
- 자바는 try-catch 등을 통해 예외를 **안정적으로 처리 가능**

---

## 2. 🧱 예외의 종류

| 분류 | 설명 | 예시 |
|------|------|------|
| Checked Exception | 컴파일 시 반드시 처리해야 함 | `IOException`, `SQLException` |
| Unchecked Exception | 런타임 시 발생 | `NullPointerException`, `ArithmeticException` |
| Error | JVM의 심각한 문제 | `OutOfMemoryError`, `StackOverflowError` |

---

## 3. 🎯 예외 처리 문법

### try-catch-finally

```java
try {
    // 예외 발생 가능 코드
} catch (ExceptionType e) {
    // 예외 처리
} finally {
    // 항상 실행됨 (선택적)
}
````

### throws 키워드

```java
public void readFile(String path) throws IOException {
    // 예외를 호출자에게 위임
}
```

---

## 4. 💡 주요 예외 클래스

| 클래스                              | 설명             |
| -------------------------------- | -------------- |
| `NullPointerException`           | null 접근 시      |
| `ArithmeticException`            | 0 나누기          |
| `ArrayIndexOutOfBoundsException` | 배열 범위 초과       |
| `NumberFormatException`          | 문자열 → 숫자 변환 실패 |
| `IOException`                    | 입출력 에러         |
| `IllegalArgumentException`       | 부적절한 인자 전달     |

---

## 5. 💻 예제 코드

### ✅ 기본 예외 처리

```java
try {
    int result = 10 / 0;
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("예외 발생: " + e.getMessage());
} finally {
    System.out.println("프로그램 종료");
}
```

---

### ✅ 여러 예외 처리

```java
try {
    String s = null;
    System.out.println(s.length());
} catch (NullPointerException e) {
    System.out.println("Null 객체 참조 에러");
} catch (Exception e) {
    System.out.println("기타 예외: " + e);
}
```

---

### ✅ 사용자 정의 예외

```java
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public static void checkAge(int age) throws MyException {
    if (age < 18) {
        throw new MyException("미성년자는 접근할 수 없습니다.");
    }
}
```

---

## 6. 🧪 실습 과제

### 💼 실습 1: 숫자 나누기 프로그램

```java
Scanner sc = new Scanner(System.in);
System.out.print("첫 번째 숫자: ");
int a = sc.nextInt();
System.out.print("두 번째 숫자: ");
int b = sc.nextInt();

try {
    System.out.println("결과: " + (a / b));
} catch (ArithmeticException e) {
    System.out.println("0으로 나눌 수 없습니다.");
}
```

---

### 💼 실습 2: 문자열을 숫자로 변환

```java
Scanner sc = new Scanner(System.in);
System.out.print("숫자로 변환할 문자열: ");
String input = sc.nextLine();

try {
    int num = Integer.parseInt(input);
    System.out.println("변환된 숫자: " + num);
} catch (NumberFormatException e) {
    System.out.println("유효한 숫자가 아닙니다.");
}
```

---

### 💼 실습 3: 사용자 정의 예외

```java
class AgeException extends Exception {
    public AgeException(String msg) {
        super(msg);
    }
}

public static void validateAge(int age) throws AgeException {
    if (age < 19) {
        throw new AgeException("19세 미만은 등록 불가");
    }
}
```

---

## 7. ⚠️ 예외 처리 Best Practice

* `try` 범위는 꼭 필요한 부분만 감싸기
* `Exception e` 남발 지양
* `finally`에서 자원 정리
* Java 7 이상: `try-with-resources` 사용
* 사용자 정의 예외는 도메인 단위로 설계

</details>

---

<details>
<summary><strong>📙 Advanced unit 10 – Adapter 패턴</strong></summary>

<br>

## 🧩 디자인 패턴 – Adapter Pattern (어댑터 패턴)

---

## 1. 개요

### ✅ 정의

> Adapter Pattern은 기존 클래스의 인터페이스를 클라이언트에서 기대하는 다른 인터페이스로 변환해주는 구조 패턴이다.

### ✅ 목적

- 호환되지 않는 인터페이스 간의 **중재자 역할**
- 기존 클래스를 **수정하지 않고 재사용**

---

## 2. 사용 시점

- 기존 시스템에 외부 클래스를 **연동하거나 래핑**할 때
- 레거시 코드를 새로운 인터페이스에 맞게 사용할 때
- 다양한 인터페이스를 가진 객체를 **통합된 방식**으로 처리할 때

---

## 3. 구성 요소

| 구성 요소 | 역할 |
|----------|------|
| Target   | 클라이언트가 기대하는 인터페이스 |
| Adaptee  | 기존 클래스 (호환되지 않음) |
| Adapter  | Target을 구현하고 Adaptee를 내부에 포함 |
| Client   | Target 인터페이스를 통해 작업 수행 |

---

## 4. 구조도 (UML)

```

Client
↓
Target (Interface)
↑
Adapter ----------------→ Adaptee

````

---

## 5. 예제 시나리오

### 🎯 상황

- 한국 콘센트(220V)만 지원하는 전원 공급기
- 미국형 기기는 110V를 사용
- 어댑터가 중간에서 변환 역할 수행

---

## 6. Java 코드 예제

### 🔸 1) Target 인터페이스 (미국 기기)

```java
public interface Electronic110V {
    void powerOn();
}
````

---

### 🔸 2) Adaptee 클래스 (한국 전기 콘센트)

```java
public class Electronic220V {
    public void connect() {
        System.out.println("🔌 220V 기기가 작동합니다.");
    }
}
```

---

### 🔸 3) Adapter 클래스

```java
public class SocketAdapter implements Electronic110V {

    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        System.out.println("🔁 어댑터가 220V → 110V로 변환 중...");
        electronic220V.connect();
    }
}
```

---

### 🔸 4) Client 코드 (사용자)

```java
public class AdapterMain {
    public static void main(String[] args) {

        // 기존 220V 기기
        Electronic220V hairDryer220v = new Electronic220V();

        // 어댑터를 통해 110V 기기로 연결
        Electronic110V device = new SocketAdapter(hairDryer220v);

        device.powerOn(); // 어댑터 통해 작동
    }
}
```

---

## 7. 실행 결과

```
🔁 어댑터가 220V → 110V로 변환 중...
🔌 220V 기기가 작동합니다.
```

---

## 8. 장단점 요약

### ✅ 장점

* 기존 코드 수정 없이 재사용 가능
* 시스템 확장성 높음
* 외부 라이브러리 연동 시 유용

### ⚠️ 단점

* 클래스 수 증가
* 어댑터 남용 시 구조 복잡도 상승

---

## 9. 실제 사례

| 환경               | Adapter 활용 예                                   |
| ---------------- | ---------------------------------------------- |
| Java IO          | `InputStreamReader` (`InputStream` → `Reader`) |
| Spring Framework | `HandlerAdapter`, `ViewResolver`               |
| JDBC → ORM 연동    | ResultSet → DTO 변환 어댑터                         |

---

## 10. 마무리 요약

> Adapter 패턴은 “변경하지 않고 연결한다”는 점에서 매우 실용적인 구조 패턴입니다.
>
> 호환되지 않는 두 객체를 "중간에 통역해주는 것"으로 이해하세요.

</details>

---

<details>
<summary><strong>📘 Basic unit 13 – NullPointerException과 Optional</strong></summary>

<br>

## 🔍 `NullPointerException` 이란?

### ✅ 정의

> `NullPointerException`은 **null 값을 참조하려고 할 때** Java 런타임에서 발생하는 예외입니다.

```

Exception in thread "main" java.lang.NullPointerException

````

---

## ⚠️ 언제 발생하는가?

### 1. 객체가 `null`인데 필드나 메서드에 접근할 때

```java
String name = null;
int len = name.length(); // ❌ NPE 발생
````

### 2. `null` 객체로 메서드를 호출할 때

```java
Person p = null;
p.getName(); // ❌ NPE
```

### 3. `null` 배열에 접근하거나 초기화 안 된 배열 요소에 접근

```java
String[] arr = new String[3];
System.out.println(arr[1].length()); // ❌ arr[1]은 null
```

### 4. 컬렉션에서 가져온 객체가 `null`일 때

```java
Map<String, String> map = new HashMap<>();
String value = map.get("key");  // null 반환
System.out.println(value.length()); // ❌ NPE
```

---

## 📌 NPE 방지 방법

### ✅ 1. null 체크

```java
if (name != null) {
    System.out.println(name.length());
}
```

### ✅ 2. Optional 사용 (Java 8+)

```java
Optional<String> maybeName = Optional.ofNullable(name);
int len = maybeName.map(String::length).orElse(0);
```

### ✅ 3. 초기값 설정

```java
String name = ""; // null 대신 빈 문자열 사용
```

### ✅ 4. Objects.requireNonNull

```java
String name = Objects.requireNonNull(getName(), "이름은 null일 수 없습니다");
```

---

## 🧪 실습 예제: NPE 발생 및 예외 처리

```java
public class NpeExample {
    public static void main(String[] args) {
        String user = null;

        try {
            System.out.println("길이: " + user.length());
        } catch (NullPointerException e) {
            System.out.println("❗ NullPointerException 발생: " + e.getMessage());
        }
    }
}
```

---

## 🧠 Java 14 이상에서 디버깅 메시지 예시

```java
Exception in thread "main" java.lang.NullPointerException: 
Cannot invoke "String.length()" because "name" is null
```

---

## ✅ 요약

| 항목       | 설명                            |
| -------- | ----------------------------- |
| 예외 이름    | `NullPointerException`        |
| 발생 시점    | null 객체에 접근할 때                |
| 해결 방법    | null 체크, Optional 사용, 안전한 초기화 |
| Java 14+ | NPE 발생 변수명 자동 추적 가능           |

---

## 📌 `Optional<T>` 소개 및 사용법

### ✅ 기본 개념

* `Optional<T>`는 null을 직접 다루지 않도록 유도하는 **null-safe 래퍼 클래스**
* `java.util.Optional` (Java 8부터 도입)

---

### ✅ Optional 예제 1: 기본 사용

```java
Optional<String> name = Optional.of("Carrot");

System.out.println(name.isPresent());      // true
System.out.println(name.get());            // Carrot
System.out.println(name.orElse("기본값")); // Carrot
```

---

### ✅ Optional 예제 2: null 방지

```java
String name = null;
Optional<String> optionalName = Optional.ofNullable(name);
String result = optionalName.orElse("기본이름");

System.out.println("결과: " + result); // 기본이름
```

---

### ✅ Optional 예제 3: map과 filter

```java
Optional<String> name = Optional.of("carrot");

name.filter(n -> n.startsWith("c"))
    .map(String::toUpperCase)
    .ifPresent(n -> System.out.println("변환된 이름: " + n));
```

---

### ✅ Optional 예제 4: 함수 리턴값으로 활용

```java
public class UserService {
    public static void main(String[] args) {
        Optional<String> email = findEmailByUsername("admin");
        String result = email.orElse("이메일 없음");
        System.out.println("결과: " + result);
    }

    public static Optional<String> findEmailByUsername(String username) {
        if ("admin".equals(username)) {
            return Optional.of("admin@carrot.com");
        } else {
            return Optional.empty();
        }
    }
}
```

---

## 🎯 Optional을 사용하면 좋은 경우

| 상황       | 추천 여부 | 설명                           |
| -------- | ----- | ---------------------------- |
| DTO 필드   | ❌ 지양  | 직렬화/역직렬화 이슈                  |
| 메서드 반환값  | ✅ 추천  | null 대신 의미 전달 가능             |
| 컬렉션 요소   | ❌ 지양  | `List<Optional<T>>`는 과도      |
| 로직 흐름 제어 | ✅ 추천  | `map`, `filter`, `orElse` 활용 |

</details>

---

<details>
<summary><strong>📙 Advanced unit 11 – Decorator 패턴</strong></summary>

<br>

## 🧩 데코레이터(Decorator) 패턴이란?

데코레이터 패턴은 **기존 객체에 기능을 동적으로 추가**할 수 있게 해주는 구조 패턴입니다.  
상속이 아닌 **조합(Composition)**을 통해 기능을 확장하므로, **유연한 기능 추가**가 필요할 때 자주 사용됩니다.

---

## 📖 핵심 개념 요약

### 🔸 특징

- **객체를 감싸는 형태**로 기능을 덧붙임
- 기존 클래스를 변경하지 않고 **런타임에 기능 확장**
- **공통 인터페이스**를 유지하여 클라이언트 코드는 동일하게 사용 가능

---

## 🧱 UML 구조


```
        +------------------+
        |     Component    |<-------------------------+
        +------------------+                          |
                ^                                     |
                |                                     |
    +----------------------+          +------------------------+
    |   ConcreteComponent  |          |      Decorator        |
    +----------------------+          +------------------------+
                                      | - component: Component |
                                      +------------------------+
                                                 ^
                                                 |
                         +-------------------------------+
                         |       ConcreteDecorator       |
                         +-------------------------------+
```

---

## ☕ Java 예제: 커피 주문 시스템

```java
// 공통 인터페이스
interface Coffee {
    String getDescription();
    int cost();
}

// 기본 컴포넌트
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }
    public int cost() {
        return 3000;
    }
}

// 데코레이터 추상 클래스
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// 구체 데코레이터
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    public int cost() {
        return coffee.cost() + 500;
    }
}

class Mocha extends CoffeeDecorator {
    public Mocha(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Mocha";
    }
    public int cost() {
        return coffee.cost() + 700;
    }
}

// 실행
public class CoffeeShop {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new Milk(coffee);
        coffee = new Mocha(coffee);

        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Price: " + coffee.cost() + "원");
    }
}
```

### ▶️ 출력 예시

```
Order: Basic Coffee, Milk, Mocha
Price: 4200원
```

---

## 🧪 실습 과제: 피자 토핑 주문 시스템 구현

### 🎯 과제 목표

* 데코레이터 패턴 구조에 따라 피자 객체에 토핑을 **동적으로 추가**하는 구조 구현

---

### ✅ 요구사항

1. `Pizza` 인터페이스 정의

  * 메서드: `getDescription()`, `getCost()`

2. `PlainPizza` 클래스 구현

  * 기본 설명: "Plain Pizza", 기본 가격: 6000원

3. 추상 클래스 `PizzaDecorator` 구현

  * `Pizza`를 필드로 가짐

4. 다음 데코레이터 클래스 구현

  * `Cheese`: +1000원
  * `Pepperoni`: +1500원
  * `Olives`: +800원

5. `main()` 메서드에서 다양한 조합 출력

---

### 🧾 예시 코드

```java
interface Pizza {
    String getDescription();
    int getCost();
}

class PlainPizza implements Pizza {
    public String getDescription() {
        return "Plain Pizza";
    }
    public int getCost() {
        return 6000;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
    public int getCost() {
        return pizza.getCost() + 1000;
    }
}

class Pepperoni extends PizzaDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }
    public int getCost() {
        return pizza.getCost() + 1500;
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
    public int getCost() {
        return pizza.getCost() + 800;
    }
}

public class PizzaOrder {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);
        pizza = new Pepperoni(pizza);

        System.out.println("Order: " + pizza.getDescription());
        System.out.println("Price: " + pizza.getCost() + "원");
    }
}
```

---

### ▶️ 출력 예시

```
Order: Plain Pizza, Cheese, Pepperoni
Price: 8500원
```

---

## ✅ 요약

| 항목    | 설명                                      |
| ----- | --------------------------------------- |
| 패턴 유형 | 구조 패턴                                   |
| 핵심 목적 | 기능의 동적 확장 (상속 없이)                       |
| 핵심 구성 | Component, Decorator, ConcreteDecorator |
| 사용 예  | 스트림 처리, UI 컴포넌트, Spring AOP 등           |

</details>

---

<details>
<summary><strong>📘 Basic unit 14 – 자바 어노테이션(Annotation)</strong></summary>

<br>

## 🧩 1. 어노테이션(Annotation)이란?

- 메타데이터의 일종으로, **코드에 대한 정보를 컴파일러나 런타임에 제공**
- 주석처럼 보이지만, **프로그램의 동작에 영향을 줄 수 있음**

---

## ✅ 2. 자바의 내장 어노테이션

| 어노테이션 | 설명 |
|-----------|------|
| `@Override` | 메서드가 상위 클래스의 메서드를 오버라이드하고 있음을 명시 |
| `@Deprecated` | 더 이상 사용되지 않는 API임을 표시 |
| `@SuppressWarnings` | 컴파일러 경고를 억제

🔍 사용 예:

```java
@Override
public String toString() {
    return "Hello";
}
````

---

## 🔄 3. 어노테이션의 동작 시점 (Retention 정책)

| Retention 정책 | 설명                      |
| ------------ | ----------------------- |
| `SOURCE`     | 소스 코드에만 존재, 컴파일 시 제거    |
| `CLASS`      | 컴파일된 클래스 파일에 존재 (기본값)   |
| `RUNTIME`    | 런타임에도 유지되어 리플렉션으로 접근 가능 |

예시:

```java
@Retention(RetentionPolicy.RUNTIME)
```

---

## 🎯 4. 어노테이션의 적용 대상 (Target)

* 어노테이션이 **어디에 붙을 수 있는지** 지정

```java
@Target(ElementType.METHOD)        // 메서드에만 붙도록 설정
@Target({ElementType.TYPE, ElementType.FIELD}) // 복수 지정 가능
```

| ElementType 값 | 의미                 |
| ------------- | ------------------ |
| `TYPE`        | 클래스, 인터페이스, enum 등 |
| `FIELD`       | 필드(멤버 변수)          |
| `METHOD`      | 메서드                |
| `PARAMETER`   | 메서드 파라미터           |

---

## 🧱 5. 커스텀 어노테이션 만들기

* `@interface` 키워드 사용
* 속성 정의 가능 (기본값 설정도 가능)

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String value();          // 필수 속성
    int version() default 1; // 기본값이 있는 속성
}
```

---

## 🧪 6. 실습 예제

### 📁 예제 1: 내장 어노테이션 사용

```java
public class BasicAnnotationExample {

    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated.");
    }

    @Override
    public String toString() {
        return "BasicAnnotationExample";
    }

    public static void main(String[] args) {
        new BasicAnnotationExample().oldMethod();
    }
}
```

---

### 📁 예제 2: 커스텀 어노테이션 정의 및 사용

✅ 어노테이션 정의

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {
    String author();
    String date();
}
```

✅ 어노테이션 사용

```java
public class AnnotatedClass {

    @TestInfo(author = "Jaden", date = "2025-07-30")
    public void sampleTest() {
        System.out.println("Running sample test...");
    }
}
```

✅ 어노테이션 읽기 (리플렉션)

```java
import java.lang.reflect.Method;

public class AnnotationReader {
    public static void main(String[] args) throws Exception {
        Method method = AnnotatedClass.class.getMethod("sampleTest");
        if (method.isAnnotationPresent(TestInfo.class)) {
            TestInfo info = method.getAnnotation(TestInfo.class);
            System.out.println("Author: " + info.author());
            System.out.println("Date: " + info.date());
        }
    }
}
```

---

## 🧠 어노테이션 관련 주요 개념 정리

| 개념           | 설명                        |
| ------------ | ------------------------- |
| `@interface` | 어노테이션 정의 키워드              |
| `@Retention` | 어노테이션 유지 범위               |
| `@Target`    | 어노테이션 사용 위치 제한            |
| 리플렉션 API     | 런타임에 어노테이션 정보 추출          |
| 활용 예         | 테스트 프레임워크, AOP, DI 등에서 사용 |

---

## ✅ 정리

* 어노테이션은 **코드의 의미를 명시적으로 표현**하며 다양한 자동화 도구에 사용됨
* **리플렉션**과 함께 사용하면 **프레임워크 기반 개발의 핵심 도구**가 됨
* 직접 어노테이션을 정의하고 **런타임에 처리하는 구조를 이해**하는 것이 중요

</details>

---

<details>
<summary><strong>📙 Advanced unit 12 – Bridge 패턴</strong></summary>

<br>

## 🌉 Bridge 패턴이란?

> **Bridge 패턴**은 "구현부에서 추상층을 분리"하여 **서로 독립적으로 확장**할 수 있도록 해주는 구조 패턴입니다.
>
> 즉, **상속 대신 구현 객체를 필드로 가지며**, 위임(Delegation)을 통해 기능을 사용하는 방식입니다.

---

## ✅ 언제 사용하는가?

- 기능과 구현이 **각각 독립적으로 변화**할 가능성이 있을 때
- 클래스 계층이 너무 많아지는 것을 방지하고 싶을 때
- 예: TV 종류는 다양하고 리모컨도 다양할 때

---

## 🧱 구조 구성

| 역할 | 설명 |
|------|------|
| `Abstraction` | 기능의 추상화 계층 (ex. 리모컨) |
| `RefinedAbstraction` | 확장된 기능 클래스 (ex. 기본/고급 리모컨) |
| `Implementor` | 구현 계층 인터페이스 (ex. TV 제어 인터페이스) |
| `ConcreteImplementor` | 실제 구현 클래스 (ex. 삼성 TV, LG TV 등) |

---

## 💡 Java 예제: 리모컨과 TV

### ✅ 구현 계층 (TV)

```java
interface TV {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}

class SamsungTV implements TV {
    public void turnOn() {
        System.out.println("Samsung TV 켜짐");
    }
    public void turnOff() {
        System.out.println("Samsung TV 꺼짐");
    }
    public void setChannel(int channel) {
        System.out.println("Samsung TV 채널: " + channel);
    }
}

class LGTV implements TV {
    public void turnOn() {
        System.out.println("LG TV 켜짐");
    }
    public void turnOff() {
        System.out.println("LG TV 꺼짐");
    }
    public void setChannel(int channel) {
        System.out.println("LG TV 채널: " + channel);
    }
}
````

---

### ✅ 추상 계층 (리모컨)

```java
abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setChannel(int channel);
}
```

---

### ✅ 확장된 추상 계층

```java
class BasicRemote extends RemoteControl {
    public BasicRemote(TV tv) {
        super(tv);
    }

    public void turnOn() {
        tv.turnOn();
    }

    public void turnOff() {
        tv.turnOff();
    }

    public void setChannel(int channel) {
        tv.setChannel(channel);
    }
}
```

---

### 🧪 사용 예시 (Main)

```java
public class Main {
    public static void main(String[] args) {
        TV samsung = new SamsungTV();
        RemoteControl remote1 = new BasicRemote(samsung);

        remote1.turnOn();
        remote1.setChannel(7);
        remote1.turnOff();

        System.out.println();

        TV lg = new LGTV();
        RemoteControl remote2 = new BasicRemote(lg);

        remote2.turnOn();
        remote2.setChannel(10);
        remote2.turnOff();
    }
}
```

---

### 🔍 출력 결과

```
Samsung TV 켜짐
Samsung TV 채널: 7
Samsung TV 꺼짐

LG TV 켜짐
LG TV 채널: 10
LG TV 꺼짐
```

---

## ✅ 핵심 요약

| 항목     | 설명                        |
| ------ | ------------------------- |
| 구조적 특징 | 추상화와 구현을 분리               |
| 유연성    | 기능 계층과 구현 계층을 독립적으로 확장 가능 |
| 설계 원칙  | 상속보다는 합성(Composition)     |
| 실무 예   | OS 추상화, 그래픽 API, 가전제어 등   |

---

## 💡 확장 아이디어

* `AdvancedRemote` 클래스를 추가하여 음소거, 볼륨 등 기능 확장
* `SonyTV`, `AppleTV` 등 새로운 구현체 추가도 손쉽게 가능

</details>

---

<details>
<summary><strong>📘 Basic unit 15 – Java 컬렉션 기본</strong></summary>

<br>

## 📦 Java 컬렉션 개요

자바의 컬렉션(Collection)은 **데이터를 효율적으로 저장하고 관리하기 위한 구조**로 다음과 같이 분류됩니다:

```

Collection (인터페이스)
├── List
│   ├── ArrayList
│   └── LinkedList
├── Set
│   ├── HashSet
│   └── TreeSet
└── Queue
├── LinkedList
└── PriorityQueue

Map (별도 인터페이스)
├── HashMap
└── TreeMap

````

---

## ✅ 1. List – 순서 O, 중복 O

### 📌 특징

- 순서 유지
- 인덱스로 접근 가능
- 중복 허용

### 💡 주요 구현체

| 클래스 | 특징 |
|--------|------|
| `ArrayList` | 내부 배열 기반, 조회 빠름 |
| `LinkedList` | 노드 연결 구조, 삽입/삭제 유리 |

### ✏️ 예제

```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // 중복 허용

        for (String name : names) {
            System.out.println(name);
        }
    }
}
````

---

## ✅ 2. Set – 순서 X, 중복 X

### 📌 특징

* 중복 데이터 저장 불가
* 순서 보장 안 됨 (`HashSet`)
* 자동 정렬 가능 (`TreeSet`)

### 💡 주요 구현체

| 클래스       | 특징                                      |
| --------- | --------------------------------------- |
| `HashSet` | 해시 기반, 순서 없음, 빠른 검색                     |
| `TreeSet` | 정렬된 상태 유지 (Comparable 또는 Comparator 필요) |

### ✏️ 예제

```java
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple"); // 중복 무시

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

---

## ✅ 3. Map – 키-값 쌍 저장, 중복 키 X

### 📌 특징

* 키(key)로 고유하게 접근
* 값(value)은 중복 가능
* 순서 없음 (`HashMap`), 키 정렬 가능 (`TreeMap`)

### 💡 주요 구현체

| 클래스       | 특징                    |
| --------- | --------------------- |
| `HashMap` | 가장 많이 쓰이며 키-값 저장에 효율적 |
| `TreeMap` | 키 기준 정렬 지원            |

### ✏️ 예제

```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 90);
        scores.put("Lee", 85);
        scores.put("Kim", 95); // 기존 값 덮어씀

        for (String name : scores.keySet()) {
            System.out.println(name + "의 점수: " + scores.get(name));
        }
    }
}
```

---

## ✅ 4. Queue – FIFO(선입선출)

### 📌 특징

* 한쪽에서 삽입(`offer`), 다른 쪽에서 삭제(`poll`)
* 비동기 처리나 작업 큐 등에 사용

### 💡 주요 구현체

| 클래스             | 특징                    |
| --------------- | --------------------- |
| `LinkedList`    | 큐로 활용 시 FIFO 구조 구현 가능 |
| `PriorityQueue` | 우선순위 기반 처리 지원         |

### ✏️ 예제

```java
import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Job1");
        queue.offer("Job2");

        while (!queue.isEmpty()) {
            System.out.println("처리 중: " + queue.poll());
        }
    }
}
```

---

## 🧠 요약 정리

| 종류    | 구현체                           | 특징                    |
| ----- | ----------------------------- | --------------------- |
| List  | `ArrayList`, `LinkedList`     | 순서 유지, 중복 허용          |
| Set   | `HashSet`, `TreeSet`          | 중복 제거, 순서 없음 또는 자동 정렬 |
| Map   | `HashMap`, `TreeMap`          | 키-값 쌍, 키 중복 불가        |
| Queue | `LinkedList`, `PriorityQueue` | FIFO 구조, 작업 큐 용도      |

---

## 💡 실무 팁

* **조회 위주** 데이터 → `ArrayList`, `HashMap`
* **중복 제거** 필요 → `Set`
* **정렬이 필요한 경우** → `TreeSet`, `TreeMap`
* **작업 대기열, 메시지 큐** → `Queue`, `ConcurrentLinkedQueue` 등

</details>

---

<details>
<summary><strong>📙 Advanced unit 13 – Composite 패턴</strong></summary>

<br>

## 🌳 Composite 패턴이란?

> Composite 패턴은 **부분-전체(Part-Whole) 구조를 트리 형태**로 표현하여,  
> **단일 객체(Leaf)**와 **복합 객체(Composite)**를 **동일한 방식으로 처리**할 수 있도록 해주는 구조 패턴입니다.

---

## ✅ 핵심 개념

- 단일 객체와 복합 객체를 같은 인터페이스로 추상화
- 클라이언트 입장에서는 **구성 요소 내부 구조를 몰라도 동일하게 처리** 가능

---

## 📦 구조 개요

```

Component (인터페이스 또는 추상 클래스)
├── Leaf (단일 객체)
└── Composite (복합 객체: 자식 보관)

````

| 구성 요소 | 설명 |
|-----------|------|
| `Component` | 공통 인터페이스 또는 추상 클래스 |
| `Leaf` | 더 이상 자식이 없는 단일 객체 |
| `Composite` | 자식을 보관하며 재귀적으로 구조를 구성 |

---

## 💡 실전 예: 파일 시스템 시뮬레이션

### 🎯 목표

- `FileComponent`: 공통 인터페이스
- `File`: Leaf 역할
- `Directory`: Composite 역할

---

### ✅ 1. FileComponent (공통 인터페이스)

```java
public interface FileComponent {
    void showInfo(String indent);
}
````

---

### ✅ 2. File 클래스 (Leaf)

```java
public class File implements FileComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "- 파일: " + name);
    }
}
```

---

### ✅ 3. Directory 클래스 (Composite)

```java
import java.util.*;

public class Directory implements FileComponent {
    private String name;
    private List<FileComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "+ 폴더: " + name);
        for (FileComponent child : children) {
            child.showInfo(indent + "  ");
        }
    }
}
```

---

### ✅ 4. 실행 예제 (Main)

```java
public class Main {
    public static void main(String[] args) {
        FileComponent file1 = new File("hello.txt");
        FileComponent file2 = new File("readme.md");
        FileComponent file3 = new File("logo.png");

        Directory imgFolder = new Directory("images");
        imgFolder.add(file3);

        Directory root = new Directory("root");
        root.add(file1);
        root.add(file2);
        root.add(imgFolder);

        root.showInfo("");
    }
}
```

---

### ▶️ 출력 결과

```
+ 폴더: root
  - 파일: hello.txt
  - 파일: readme.md
  + 폴더: images
    - 파일: logo.png
```

---

## ✅ Composite 패턴의 장점

| 장점             | 설명                      |
| -------------- | ----------------------- |
| 클라이언트 코드 단순화   | 단일 객체와 복합 객체를 동일하게 처리   |
| 트리 구조 표현 용이    | 폴더-파일, 조직도, 메뉴 구조 등에 적합 |
| 재귀 호출 구조 자연스러움 | 자식 요소 순회와 동작 위임이 쉬움     |

---

## 📌 요약

* Composite 패턴은 **복잡한 계층적 구조를 단순한 방식으로 표현**하고 처리할 수 있도록 해줍니다.
* 단일 요소와 복합 요소 모두 동일한 방식으로 접근할 수 있기 때문에 **코드의 일관성과 유연성**이 향상됩니다.
* 파일 시스템, 조직 구조, UI 컴포넌트 트리 등에서 자주 활용됩니다.

</details>

---

<details>
<summary><strong>📘 Basic unit 16 – GitHub Actions를 활용한 ECS 자동 배포</strong></summary>

<br>

## 1. ECS 자동화 배포 실습

## 🧑‍💻 **과제 개요**

* **주제**: GitHub Actions를 이용해 본인의 Java 프로젝트를 AWS ECS에 자동 배포
* **목표**:

  * main 브랜치에 push 시 GitHub Actions가 실행되어
  * 도커 이미지 빌드 → ECR 푸시 → ECS 서비스 재배포까지 자동화

---

## 🚀 **과제 상세 내용**

### 1️⃣ 요구사항

| 항목                  | 설명                                          |
| ------------------- | ------------------------------------------- |
| ✅ GitHub Actions 구성 | main 브랜치 push 시 자동 실행                       |
| ✅ Docker 이미지 빌드     | Gradle로 프로젝트 빌드 후 도커 이미지 생성                 |
| ✅ ECR 푸시            | AWS ECR에 이미지 푸시                             |
| ✅ ECS Task 정의       | GitHub Actions에서 task-definition.json 자동 생성 |
| ✅ ECS 재배포           | ECS 서비스가 최신 태스크 정의로 업데이트됨                   |
| ✅ 확인                | 실제 컨테이너 갱신 및 변경 사항 반영 여부 확인                 |

</details>

---

<details>
<summary><strong>📘 Basic unit 17 – 리팩토링(Refactoring)</strong></summary>

<br>

## 📌 과제 개요

* **주제**: Java 리팩토링 개념 학습 및 적용
* **목표**: 조건문 기반 계산기를 전략 패턴 기반 구조로 리팩토링하여, 가독성·확장성·유지보수성을 높이는 구조로 구현

---

## 🎯 학습 포인트

* 리팩토링의 정의와 목적 (기능 유지 + 내부 구조 개선)
* 대표적인 리팩토링 기법 학습

  * 중복 코드 제거
  * 메서드 추출
  * 조건문 제거 → 다형성으로 전환
  * 캡슐화, 클래스 분리 등

---

## 🔧 구현 내용 요약

| 구현 항목                               | 설명                               |
| ----------------------------------- | -------------------------------- |
| `OperatorType` enum                 | 문자열 대신 타입 기반 연산자 식별              |
| `Operation` 인터페이스                   | 전략 패턴 기반 연산 정의용 인터페이스            |
| `AddOperation`, `SubOperation`, ... | 연산별 구현 클래스 분리                    |
| `OperationRegistry`                 | 연산자-전략 객체 매핑 전용 클래스              |
| `Calculator`                        | calculate() 메서드에서 전략 객체 위임 실행    |
| `CalculatorMain`                    | 실행용 클래스에서 runTest()로 테스트 분리 및 출력 |

---

## 🧪 실행 결과 예시

```
add(5, 3) = 8 (예상: 8) [PASS]
sub(10, 4) = 6 (예상: 6) [PASS]
mul(3, 7) = 21 (예상: 21) [PASS]
div(20, 5) = 4 (예상: 4) [PASS]
div(10, 0) 예외 발생 예상대로: 0으로 나눌 수 없습니다. [PASS]
mod(10, 3) 예외 발생 예상대로: 잘못된 연산자입니다: mod [PASS]
```

---

</details>

---

<details>
<summary><strong>📙 Advanced unit 14 – Strategy Pattern</strong></summary>

<br>

## 📌 과제 개요

* **주제**: 전략 패턴(Strategy Pattern)의 구조와 장점 학습
* **목표**: 조건문 없이 전략 객체로 알고리즘을 주입받아 처리할 수 있는 설계 패턴을 이해하고 적용

---

## 🧠 Strategy 패턴이란?

> 알고리즘(전략)을 인터페이스로 추상화하여, 실행 시 구체 전략을 동적으로 바꿔 끼울 수 있는 패턴입니다.

* 조건문 제거
* 테스트 및 유지보수 용이
* OCP/SRP에 부합

---

## 📦 구조

```
[Context] ─────────────┐
                      ▼
            [Strategy interface]
               ▲         ▲
           [StrategyA] [StrategyB]
```

---

## 🧪 자바 예제: 할인 전략 적용

### 1. 전략 인터페이스

```java
public interface DiscountStrategy {
    int calculateDiscount(int price);
}
```

### 2. 전략 구현 클래스

```java
public class FixedDiscount implements DiscountStrategy {
    public int calculateDiscount(int price) {
        return price - 1000;
    }
}
```

```java
public class RateDiscount implements DiscountStrategy {
    public int calculateDiscount(int price) {
        return (int)(price * 0.9);
    }
}
```

### 3. Context 클래스

```java
public class Order {
    private final DiscountStrategy discountStrategy;
    public Order(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public void checkout(int price) {
        int discounted = discountStrategy.calculateDiscount(price);
        System.out.println("최종 결제 금액: " + discounted + "원");
    }
}
```

### 4. 사용 예

```java
public class Main {
    public static void main(String[] args) {
        new Order(new FixedDiscount()).checkout(10000); // 9000원
        new Order(new RateDiscount()).checkout(10000);  // 9000원
    }
}
```

---

## 🔄 리팩토링 효과 비교

| 항목            | Before (조건문) | After (Strategy) |
| ------------- | ------------ | ---------------- |
| 조건문 if/switch | ✅ 있음         | ❌ 없음             |
| 테스트 편의성       | ❌ 낮음         | ✅ 높음             |
| 새로운 전략 추가     | 조건문 수정 필요    | 새 클래스만 추가        |
| SRP           | 위반           | 준수               |

---

## ✅ 마무리 요약

| 항목    | 내용                         |
| ----- | -------------------------- |
| 목적    | 알고리즘 캡슐화, 동적 교체            |
| 장점    | 조건문 제거, 테스트/확장 용이          |
| 패턴 분류 | 행위 패턴 (Behavioral Pattern) |

---

</details>
