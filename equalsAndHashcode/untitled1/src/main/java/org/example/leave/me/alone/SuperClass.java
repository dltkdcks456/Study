package org.example.leave.me.alone;

public class SuperClass implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SuperClass clone = (SuperClass) super.clone();
        clone.init(); // ❌ 재정의 가능 메서드 호출
        return clone;
    }

    protected void init() {
        System.out.println("SuperClass init");
    }
}
