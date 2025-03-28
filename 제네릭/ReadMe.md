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

메서드를 비유해서 제네릭을 설명



## 3️⃣ 타입 매개변수 제한

다형성이 또 등장 + 상한 제한



## 4️⃣ 제네릭 메서드

타입 매개변수 제한



## 5️⃣ 와일드카드

이미 결정된 제네릭 타입을 불러와서 편하게 쓸 수 있는 것.

상한, 하한



## 6️⃣ 타입 이레이저

