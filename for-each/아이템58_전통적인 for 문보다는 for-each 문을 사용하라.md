# 전통적인 for문 보다는 for-each문을 사용하라

### 1. 전통적인 `for`문

- `Iterator`와 `인덱스 변수`는 코드를 지저분하게 만든다.
- 컬렉션이냐 배열이냐에 따라서 코드 형태가 상당히 달라진다.
- 잘못된 변수를 사용할 확률이 높다.

```java
// 컬렉션 순회하기
List<Integer> c = List.of(1, 2, 3);

for (Iterator<Integer> i = c.iterator(); i.hasNext();) {
    Integer number = i.next();
    // number로 무언가를 한다.
    System.out.println("number = " + number);
}
```

```java
// 배열 순회하기
int[] numbers = {1, 2, 3};
for (int i = 0; i < numbers.length; i++) {
    // numbers[i]로 무언가를 한다.
    System.out.println("numbers = " + numbers[i]);
}
```

### 2. `for-each`문을 사용하자

- 정식 이름은 '향상된 for문(`enhanced for statement`)'이다.
- 반복자와 인덱스 변수를 사용하지 않아 코드가 깔끔해지고 오류가 날 일도 없다.
- 하나의 관용구로 컬렉션과 배열을 모두 처리할 수 있다.
- `for-each`문을 사용해도 속도는 그대로이다.

```java
List<String> names = List.of("effective-java", "study")
for (String name : names) {
    // ...
}
```

### 3. `for-each`문을 사용하지 못하는 상황

**(1) 파괴적인 필터링(destructive filtering)**

- 컬렉션을 순회하면서 선택된 원소를 제고하고 싶다면 `Iterator`의 `remove`메서드를 호출해야한다.

```java
List<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

for (Iterator<Integer> i = c.iterator(); i.hasNext();) {
    Integer number = i.next();
    // number로 무언가를 한다.
    if (number % 2 == 0) {
        i.remove();
    }
}
System.out.println("c = " + c); // 출력: c = [1, 3]
```

- 자바 8부터 `Collection`의 `removeIf`가 등장하여 더욱 코드를 짧게 작성할 수 있다.

```java
List<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

c.removeIf(n -> n % 2 == 0);

System.out.println("c = " + c); // 출력: c = [1, 3]
```

**(2) 변형(transforming)**

- 리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야 한다면 `Iterator`나 `index`를 사용해야 한다.

```java
List<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

for (int i = 0; i < c.size(); i++) {
    c.set(i, c.get(i) * 2);
}
System.out.println("c = " + c);
```

**(3) 병렬 반복(parallel iteration)**

- 여러 컬렉션을 병렬로 순회해야 한다면 각각의 `Iterator`와 `Index`변수를 사용해 엄격하고 명시적으로 제어해야 한다.
  → `for-each`문은 **단일 컬렉션에 대한 순회**만 가능하다.

```java
List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
List<String> list2 = Arrays.asList("a", "b", "c", "d");

// 두 리스트의 크기 중 더 작은 크기로 종료 조건 설정
int size = Math.min(list1.size(), list2.size());

// 명시적으로 인덱스를 사용하여 병렬 순회
for (int i = 0; i < size; i++) {
    Integer element1 = list1.get(i);  // list1의 원소
    String element2 = list2.get(i);   // list2의 원소
    System.out.println("list1: " + element1 + ", list2: " + element2);
}
```