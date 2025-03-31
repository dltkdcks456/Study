# 람다

## 람다가 필요한 이유?

> 람다는 JDK 1.8부터 도입되었다.

코드 자체를 간결하고 가독성 좋게 만들어 준다. 함수 자체를 인자로 넣거나 반환할 수 있게 되어 유연성이 더욱 높아졌다.

함수와 메서드

- 함수(Function)
  - 독립적으로 존재하며, 클래스(객체)와 직접적인 연관이 없다.
  - 호출 시에 객체 인스턴스가 필요 없다.
  - 지역 변수, 전역 변수 등과 함께 동작하며, 클래스나 객체 특유의 속성(인스턴스 변수 등)은 다루지 못한다.
- 메서드(Method)
  - 클래스(또는 객체)에 속해 있는 함수이다.
  - 호출될 때, 해당 객체의 필드(속성)나 다른 메서드에 접근 가능하며, 이를 이용해 로직을 수행한다.
  - 인스턴스 메서드, 클래스(정적) 메서드, 추상 메서드 등 다양한 형태가 있다.



### 코드 예시

Q. 하나의 메서드로 실행될 수 있게 리팩토링을 해보자.

```java
public static void helloDice() {
        long startTime = System.nanoTime();

        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 놀이: " + randomValue);

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }

    public static void helloSum() {
        long startTime = System.nanoTime();

        for (int i = 0; i <3; i++) {
            System.out.println(i);
        }

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }
```

> 변경되는 부분과 변경되지 않는 부분을 확인해야 한다.



A1. 공통 메서드를 `interface`로 우선 만든다. 그 후 익명 클래스를 통해 로직을 구현한다.

```java
public interface Procedure {
    void run();
}
```

```java
public static void hello(Procedure procedure) {
        long startTime = System.nanoTime();

        procedure.run();

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }

    public static void main(String[] args) {
        Procedure random = new Procedure() {
            @Override
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 놀이: " + randomValue);
            }
        };
        hello(random);

        Procedure iterator = new Procedure() {
            @Override
            public void run() {
                for (int i = 0; i <10; i++) {
                    System.out.println(i);
                }
            }
        };
        hello(iterator);
    }
```

A2) 익명 클래스를 람다 형태로 변경시킨다.

```java
public static void hello(Procedure procedure) {
        long startTime = System.nanoTime();

        procedure.run();

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }

    public static void main(String[] args) {
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 놀이: " + randomValue);
        });

        hello(() -> {
            for (int i = 0; i <10; i++) {
                System.out.println(i);
            }
        });
    }
```

결과
클래스를 정의하고 메서드를 만들고 인스턴스를 생성하는 복잡한 과정 없이 코드 블럭만 전달할 수 있다.
**훨씬 간결하고 명확한** 코드를 작성할 수 있다.



## 람다

람다는 **익명 함수**이다. 따라서 이름 없이 함수를 표현한다.
람다의 표현은 아래와 같다.

```
반환타입 메서드명(매개변수) {
    본문
}
```

```
 (매개변수) -> {본문}
```

특징

1) 람다는 표현이 간결하다.
   ```java
   Procedure procedure = new Procedure() {
       @Override
    public void run() {
    System.out.println("hello! lambda");
       }
    };
   
   Procedure procedure = () -> {
    System.out.println("hello! lambda");
    }
   ```

2) 람다는 변수처럼 다룰 수 있다.
   ```java
    Procedure procedure = () -> { // 람다를 변수에 담음
   System.out.println("hello! lambda");
    };
   ```

3) 람다도 클래스가 만들어지고, 인스턴스가 생성된다.
   ```java
   // 익명 클래스
   class.class = class lambda.lambda1.InstanceMain$1
   class.instance = lambda.lambda1.InstanceMain$1@506e6d5e
   // 람다
   lambda.class = class lambda.lambda1.InstanceMain$$Lambda/0x00000008000c2618
   lambda.instance = lambda.lambda1.InstanceMain$$Lambda/0x00000008000c2618@3796751b
   ```

   

## 함수형 인터페이스

- 정확히 하나의 추상 메서드를 가지는 인터페이스를 말한다.

- 람다는 추상 메서드가 하나인 함수형 인터페이스에만 할당할 수 있다.

- `@FunctionalInterface`가 있으면 추상 메서드가 하나가 아닐 경우 컴파일 단계에서 오류가 발생한다.

  - 따라서 함수형 인터페이스임을 보장할 수 있다.

  ```java
   @FunctionalInterface // 애노테이션 추가
  public interface SamInterface {
   void run();
   }
  ```

- 람다는 인터페이스의 타입을 가진다. 따라서, 다른 타입끼리는 타입 변환이 불가능하다.

  - 공통 함수형 인터페이스를 사용하면 타입 변환이 가능하다.

  ```java
   @FunctionalInterface
   interface NumberFunction {
       Integer apply(Integer s);
   }
  
  @FunctionalInterface
   interface IntegerFunction {
       Integer apply(Integer s);
   }
  ```

- 자바에서 제공하는 함수형 인터페이스

| 인터페이스     | 입력   | 출력   | 대표 사용 예시            |
| -------------- | ------ | ------ | ------------------------- |
| Function<T, R> | 1개(T) | 1개(R) | 데이터 변환, 필드 추출 등 |
| Consumer<T>    | 1개(T) | 없음   | 로그 출력, DB 저장 등     |
| Supplier<T>    | 없음   | 1개(T) | 객체 생성, 값 반환 등     |
| Runnable       | 없음   | 없음   | 스레드 실행(멀티 스레드)  |
| Predicate      | 1개(T) | 1개(R) | 조건검사, 필터링          |



## 람다 vs 익명 클래스

1. 문법 차이

   - 익명 클래스는 클래스를 선언하고 즉시 인스턴스를 생성하는 방식이다.
   - 메서드를 오버라이드 해서 구현한다.

   ```java
   Procedure iterator = new Procedure() {
               @Override
               public void run() {
                   for (int i = 0; i <10; i++) {
                       System.out.println(i);
                   }
               }
           };
   ```

   - 람다 표현식은 함수를 간결하게 표현할 수 있다.
   - 함수형 인터페이스를 간단히 구현할 때 주로 사용한다.
   - 람다도 인스턴스를 생성한다.

   ```java
   Procedure iterator = () -> {
               for (int i = 0; i <10; i++) {
                   System.out.println(i);
               }
           }
   ```

2. 상속 관계

   - 익명 클래스는 일반적인 클래스처럼 다양한 인터페이스와 클래스를 구현하거나 상속할 수 있다. 여러 메서드를 가진 인터페이스를 구현할 때도 사용할 수 있다.
   - 람다는 메서드를 딱 하나만 가지는 함수형 인터페이스만 구현할 수 있다.
     - 람다는 클래스를 상속할 수 없다. 상태(필드)나 추가적인 메서드 오버라이딩이 불가능하다.

3. 호환성

   - 익명 클래스는 자바의 오래된 버전에서도 사용이 가능하다.
   - 람다 표현식은 자바 8부터 도입되어 그 이전 버전에서는 사용할 수 없다.

4. this의 의미

   - 익명 클래스 내부에서 `this`는 익명 클래스 자신을 가리킨다. 외부 클래스와 별도의 컨텍스트를 가진다.

   - 람다에서 `this`는 람다를 선언한 클래스의 인스턴스를 가리킨다.
     ```java
     public class OuterMain {
         private String message = "외부 클래스";
     
         public void execute() {
             //1.익명 클래스 예시
             Runnable anonymous = new Runnable() {
                 private String message = "익명 클래스";
     
                 @Override
                 public void run() {
                     // 익명 클래스에서의 this는 익명 클래스의 인스턴스를 가리킴
                     System.out.println("익명 클래스 this: " + this);
                     System.out.println("익명 클래스 this: " + this.getClass());
                     System.out.println("익명 클래스 this: " + this.message);
     
                 }
             };
     
             // 2. 람다 예시
             Runnable lambda = () -> {
                 //람다에서의 this는 람다가 선언된 클래스의 인스턴스(즉 외부클래스) 가리킴
                 System.out.println("람다 this: " + this);
                 System.out.println("람다 this: " + this.getClass());
                 System.out.println("람다 this: " + this.message);
             };
             System.out.println("람다 " + lambda);
             System.out.println("람다 " + lambda.getClass());
     //        anonymous.run();
             lambda.run();
         }
     ```

5. 익명 클래스와 람다의 용도 구분

   - 익명 클래스
     - 상태를 유지하거나 다중 메서드를 구현할 필요가 있는 경우
     - 기존 클래스 또는 인터페이스를 상속하거나 구현할 때
     - 복잡한 인터페이스 구현이 필요할 때
   - 람다
     - 상태를 유지할 필요가 없고, 간결함이 중요한 경우
     - 단일 메서드만 필요한 간단한 함수형 인터페이스 구현 시