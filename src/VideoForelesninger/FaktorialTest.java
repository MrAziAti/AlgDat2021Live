package VideoForelesninger;

import java.util.Stack;

public class FaktorialTest {

    public static void main(String[] args) {
        System.out.println("Tester factorial funksjonen");
        System.out.println(fak(5));

        System.out.println(stackBasedFactorial(5));

    }

    /**
     * N! ( fakultet= = n *(n-1) * n*(n-2) .... * 1;
     */

    static int fak(int n){
        // 1 basistilfellet
        // 2 forenkling av argument ( gå mot basistilfellet
        // 3 kalle på seg selv

        if(n == 1){
            return 1;
        }else{
            return n * fak(n-1);
        }
    }

    static int stackBasedFactorial(int n){
        Stack<Integer> fac = new Stack<>();

        fac.add(n);

        int result =1;
        while(!fac.isEmpty()){
            Integer current = fac.pop();
            result = result * current;
            if(n > 1) {
                //n = n -1;
                fac.add(--n);
            }
        }
        return result;
    }
}
