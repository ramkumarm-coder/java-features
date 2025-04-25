interface A {
    default void display() {
        System.out.println("A");
    }
}

interface B extends A {
    default void display() {
        System.out.println("B");
    }
}

interface C extends A {
    default void display() {
        System.out.println("C");
    }
}

public class DiamondProblem {
}

class D implements B, C {

    @Override
    public void display() {
        B.super.display();
    }
}
