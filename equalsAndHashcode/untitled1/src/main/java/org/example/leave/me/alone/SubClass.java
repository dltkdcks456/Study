package org.example.leave.me.alone;

import java.util.ArrayList;
import java.util.List;

public class SubClass extends SuperClass {
    private List<String> data;

    public SubClass() {
        this.data = new ArrayList<>();
        data.add("hello");
    }

    @Override
    protected void init() {
        System.out.println("data size: " + data.size()); // 💥 NPE 가능성
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SubClass subClass = new SubClass();
        SubClass clone = (SubClass) subClass.clone();
    }
}
