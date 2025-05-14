package org.example.leave.me.alone;

import java.awt.*;

class BadClass {
    public static void main(String[] args) {
        Dimension dimension = new Dimension();
        System.out.println("dimension = " + dimension);
        dimension.height = 3000;
        System.out.println("dimension = " + dimension);
    }
}
