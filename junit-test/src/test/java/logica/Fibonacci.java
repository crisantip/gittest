package logica;

public class Fibonacci {
    public static int compute(int n) {
        if (n <= 1) return n;
        else return compute(n-1) + compute(n-2);
    }

//    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
//        for (int i = 1; i <= N; i++)
//            System.out.println(i + ": " + fib(i));
//    }

}