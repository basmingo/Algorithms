package com.basmingo;

class A {
    public int fieldA = 0;
    private int fieldB = 2;

    public void setFieldB(int B) { this.fieldB = B; }
}

class B {
    public Integer fieldA = 0;
    public Integer fieldB = 2;
}
public class Testing {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.fieldA = 5;
        b.fieldA = 10;

        a.fieldA = b.fieldA;
        System.out.println(a.fieldA);
        a.fieldA = 33;
        b.fieldA = 44;
        System.out.println(a.fieldA);
    }
}
