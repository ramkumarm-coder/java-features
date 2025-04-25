public class Main {
    public static void main(String[] args) {
        System.out.print("1 2 3 ");
        for (int i = 4; i <= 50; i++) {
            if (i % 2 != 0 && i % 3 != 0)
                System.out.print(i + " ");
        }
    }
}
