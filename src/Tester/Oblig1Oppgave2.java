package Tester;

public class Oblig1Oppgave2 {
    public static void main(String[] args) {
        int[]a = {1,1};

        System.out.println(antallUlikeSortert(a));
    }

    public static int antallUlikeSortert(int[]a){
        int teller = 0;
        if(a.length == 0){
            return 0;
        }else{
            teller = 1;
        }

        for(int i = 0; i < a.length-1; i++){
            if(!(a[i] <= a[i+1])){
                throw new IllegalStateException("Array er ikke sortert");
            }
        }
        for(int i = 1; i < a.length; i++){

            if(!(a[i] == a[i-1] )){
                teller++;
            }
        }
        return teller;
    }

}
