# 🚀 제네릭

## 🎯 목표

제네릭은 실무에서 직접 만들어서 잘 사용하지 않는다. 학습 목표는 제네릭으로 이미 잘 구현된 라이브러리나 프레임워크의 코드를 보고 이해하는 정도로 정한다.



## 1️⃣ 제네릭이 필요한 이유?

타입 안정성과 재사용성을 높이기 위해 사용한다.

1) 구현체를 하나씩 생성하여 활용하는 경우
   : 타입 안정성 O, 재사용성 X

   ```java
   StringBox stringBox = new StringBox("문자");
   IntegerBox integerBox = new IntegerBox(1);
   ```

2. 다형성을 활용하는 경우
   : 타입 안정성 X, 재사용성 O

   ```java
   ObjectBox objectStringBox = new ObjectBox("문자");
   ObjectBox objectIntegerBox = new ObjectBox(1);
   ```

3. 제네릭을 활용하는 경우
   : 타입 안정성 O, 재사용성 O

   ```java
   GenericBox<String> stringGenericBox = new GenericBox<String>("문자");
   GenericBox<Integer> integerGenericBox = new GenericBox<Integer>(1);
   ```



## 2️⃣ 제네릭 용어와 관례

- 제네릭 용어

  - 메서드
    : 매개변수에 인자를 전달해서 사용할 값을 결정한다. 

    ```java
    public void createObject(String name) {
        Device device = new Device("Device");
    }
    ```

    ```java
    createObject("Argument")
    ```

  - 제네릭
    : 타입 매개변수에 타입 인자를 전달해서 사용할 타입을 결정한다.

    ```java
    public class GenericBox<T> {
        T value;
    
        public GenericBox(final T value) {
            this.value = value;
        }
    
        public T getValue() {
            return value;
        }
    
        public void setValue(final T value) {
            this.value = value;
        }
    }
    ```

    ```java
    GenericBox<Integer> integerGenericBox = new GenericBox<Integer>(1);
    ```

  - 용어 정리

    - 제네릭(Generic) 단어

      - 제네릭이라는 단어는 일반적인, 범용적인 이라는 영어 단어 뜻이다.
      - 풀어오면 특정 타입에 속한 것이 아니라 일반적으로 사용할 수 있다는 뜻이다.

    - 제네릭 타입(Generic Type)

      - 클래스나 인터페이스를 정의할 때 타입 매개변수를 사용하는 것을 말한다.
      - 예) `GenericBox<T>`

    - 타입 매개변수(Type Parameter)

      - 제네릭 타입이나 메서드에서 사용되는 변수로, 실제 타입으로 대체된다.
      - 예) `GenericBox<T>에서의 T`

    - 타입 인자(Type Argument)

      - 제네릭 타입을 사용할 때 제공되는 실제 타입이다.
      - 예) `GenericBox<Integer>에서의 Integer`

    - 제네릭 명명 관계

      - 타입 매개변수는 일반적인 변수명처럼 소문자로 사용해도 문제가 없다.

      - 하지만 일반적으로 대문자를 사용하고 용도에 맞는 단어의 첫 글자를 사용하는 관례를 따른다.
        ```
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        ```



## 3️⃣ 타입 매개변수 제한

- 타입 매개변수로 들어올 수 있는 타입에 제한을 둔다.
  : 이외의 타입들은 컴파일 에러가 발생한다. (타입 안정성: O)

  ```java
  public class GenericTypeLimit<T extends Device>
  ```

  ```java
  GenericTypeLimit<Device> device = 
  		new GenericTypeLimit<Device>(new Device("Device"));
  GenericTypeLimit<LightDevice> lightDevice = 
  		new GenericTypeLimit<LightDevice>(new LightDevice("LightDevice"));
  GenericTypeLimit<BacnetDevice> BacnetDevice = 
  		new GenericTypeLimit<BacnetDevice>(new BacnetDevice("BacnetDevice"));
  
  // GenericTypeLimit<Object> object = new GenericTypeLimit<Object>(new Object()); 타입 에러 발생
  ```

- 다형성을 통한 타입 제한
  ```java
  public class Polymorphic {
      private Device value;
  
      public Polymorphic() {
      }
      ...
  }
  ```

  ```java
  public class PolymorphicMain {
      public static void main(String[] args) {
          Polymorphic polymorphic = new Polymorphic();
          polymorphic.setValue(new LightDevice("Light Device"));
  
          // 다른 구현체로 삽입이 가능해서, 타입 안정성이 지켜지지 않는다.
          polymorphic.setValue(new BacnetDevice("Bacnet Device"));
      }
  }
  
  ```

  ※ (개인 의견) Polymorphic의 필드를 `final`로 지정하여 다른 타입으로 변경되는 것을 방지할 수 있다.



## 4️⃣ 제네릭 메서드

- 제네릭 메서드는 클래스 전체가 아니라 특정 메서드 단위로 제네릭을 도입할 때 사용한다.

  - 반환 타입 왼쪽에 타입 매개변수를 적어준다.
  - 메서드를 실제 호출하는 시점에 `<Integer>`와 같이 타입을 정하고 호출된다.

  ```java
  public <T> T genericMethod(GenericBox<T> box) {
      T boxValue = box.getValue();
      return boxValue;
  }
  ```



- 인스턴스 메소드와 정적 메소드에 모두 적용이 가능하다.

  ```java
  public class GenericMethod<K> {
      private K value;
  
      public <T> T genericMethod(GenericBox<T> box) {
          T boxValue = box.getValue();
          return boxValue;
      }
  
      public static <T> T genericStaticMethod(GenericBox<T> box) {
          T boxValue = box.getValue();
          return boxValue;
      }
  }
  ```



- 타입 매개변수 제한을 동일하게 적용 가능하다.

  ```java
  public class GenericMethod<K> {
      private K value;
  
      public <T extends Device> T genericMethod(GenericBox<T> box) {
          T boxValue = box.getValue();
          return boxValue;
      }
  }
  ```

  

- 제네릭 타입과 제네릭 메서드의 타입 매개변수를 같은 이름으로 사용할 경우, 제네릭 메서드가 우선 순위를 가진다.
  : 타입 매개변수는 구분될 수 있도록 구성되어야 한다.

  ```java
  public class GenericMethod<T> {
      private T value;
  
      public <T> T genericMethod(GenericBox<T> box) {
          T boxValue = box.getValue();
          return boxValue;
      }
  
  }
  ```

  

## 5️⃣ 와일드카드

> 와일드 카드: 컴퓨터 프로그래밍에서 `*`, `?`와 같이 하나 이상의 문자들을 상징하는 특수 문자를 뜻한다.

와일드카드는 제네릭 타입이나, 제네릭 메서드를 선언하는 것이 아니다. 와일드카드는 이미 만들어진 제네릭 타입을 활용할 때 사용한다.

- 와일드 카드의 사용 예제
  ```java
  public class GenericAndWildcardMethod<K> {
      private K value;
  
      public <T> void genericMethod(GenericBox<T> box) {
          System.out.println("box = " + box);
      }
  
      // ? → ? extends Object이다. 모든 타입이 들어갈 수 있다.
      public void wildcardMethod1(GenericBox<?> box) {
          Object value1 = box.getValue();
          System.out.println("value1 = " + value1);
      }
  
      public <T extends Device> void genericMethodLimit1(GenericBox<T> box) {
          T boxValue = box.getValue();
          System.out.println("boxValue = " + boxValue);
      }
  
      // 와일드 카드도 동일하게 상한 제한을 둘 수 있다.
      public void wildCardLimit1(GenericBox<? extends Device> box) {
          Device value = box.getValue();
          System.out.println("value = " + value);
      }
  
      // 타입 인자와 동일한 타입을 반환
      public <T extends Device> T genericMethodLimit2(GenericBox<T> box) {
          T boxValue = box.getValue();
          return boxValue;
      }
  
      // 타입 추론을 통해 Device로 타입을 받는다.
      public Device wildcardLimit2(GenericBox<? extends Device> box) {
          Device value = box.getValue();
          return value;
      }
  }
  ```

  

- 와일드 카드 상한 제한, 하한 제한
  ```java
  // 와일드 카드 상한 제한
  // 넣어줄 수 있는 인자는 Device, LightDevice, BacnetDevice이다. 상위 타입인 Object는 넣을 수 없다.
  public void wildcardMethodUpperLimit(GenericBox<? extends Device> box) {
      Device value1 = box.getValue();
      System.out.println("value1 = " + value1);
  }
  
  // 와일드 카드 하한 제한
  // 넣어줄 수 있는 인자는 Device, Object이다. 자손인 LightDevice와 BacnetDevice는 인자로 넣지 못한다.
  public void wildcardMethodLowerLimit(GenericBox<? super Device> box) {
      System.out.println("box = " + box);
  }
  ```

- ✅ 제네릭 메서드 vs 와일드 카드
  와일드 카드는 일반적인 메서드에서 사용할 수 있고, 단순히 매개변수로 제네릭 타입을 받을 수 있는 것 뿐이다. 제네릭 메서드처럼 타입을 결정하거나 복잡하게 동작하지 않는다. 제네릭 타입이나 제네릭 메서드를 정의하는 게 꼭 필요한 상황이 아니라면, 더 단순한 와일드 카드 사용을 권장한다.



## 6️⃣ 타입 이레이저

제네릭은 자바 컴파일 단계에서만 사용되고, 컴파일 이후에는 제네릭 정보가 삭제된다. 제네릭에 사용한 타입 매개변수가 모두 사라진다. 컴파일 전인 `.java`에는 제네릭의 타입 매개변수가 존재하지만, 컴파일 이후인 자바 바이트코드 `.class`에는 타입 매개변수가 존재하지 않는다.

> 제네릭은 JDK1.5부터 지원되었고, 하위 호환을 위해 타입 이레이저를 진행한다.

- 예시

  1. 기존 제네릭 타입 코드
     ```java
     public class GenericBox<T> {
      private T value;
         
      public void set(T value) {
      	this.value = value;
         }
      public T get() {
      	return value;
         }
      }
     ```

  2. 제네릭 타입에 `Integer` 타입 전달
     : 자바 컴파일러는 제네릭 정보를 활용해 아래와 같이 이해한다.

     ```java
     public class GenericBox<Integer> {
      private Integer value;
         
      public void set(Integer value) {
      	this.value = value;
         }
      public Integer get() {
          return value;
         }
      }
     ```

  3. 컴파일이 모두 끝나면 제네릭 관련 정보 삭제
     : `.class`는 아래와 같이 변경된다.

     ```java
      public class GenericBox {
      private Object value;
          
      public void set(Object value) {
      	this.value = value;
         }
     
      public Object get() {
     	return value;
         }
      }
     ```

  4. 비즈니스 로직에 캐스팅하는 코드가 추가된다.
     ```java
      void main() {
      	GenericBox box = new GenericBox();
         box.set(10);
      	Integer result = (Integer) box.get(); //컴파일러가 캐스팅 추가
     }
     ```

- 타입 이레이저 방식의 한계
  : `T`는 `Object`로 변경되므로 `instanceof`는 항상 true를 반환하고, `new` 연산은 개발자의 의도를 반영할 수 없다.

  ```java
  class EraserBox<T> {
      
   public boolean instanceCheck(Object param) {
   	return param instanceof T; // 오류
      }
      
   public T create() {
   	return new T(); // 오류
      }
   }
  ```
