package DynamicProgramming;

public class FibonacciExample {
    static int F[] = new int[100];
    static void initialize()
    {
        for(int i=0;i<100;i++){
        F[i]=-1;
    }
    }
    public static void main(String[] args) {
        initialize();
        int n = fib(46);
        System.out.println(n);

    }
    static int fib(int n){
        if(n<=1) {
            return n;
        }if(F[n]!=-1){
            return F[n];
        }
        F[n]=fib(n-1)+fib(n-2);
      return F[n];
    }
}

