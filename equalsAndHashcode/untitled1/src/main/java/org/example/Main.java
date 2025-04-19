package org.example;

public class Main {
    public static void main(String[] args) {
        Person p1 = Person.create("Alice", 30);
        Person p2 = Person.create("Alice", 30);
        Person p3 = Person.create("Bob", 25);

        // equals() 및 hashCode() 테스트
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode()); // p1과 p2는 같으므로 해시코드도 같아야 합니다
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
    }
}