package Tester;

public class Oblig1Oppgave3 {

    public static void main(String[] args) {
        int[] a = {5,3,7,4,3,5,7,8,6,7};

        System.out.println(antallUlikeUsortert(a));
    }
    public static int antallUlikeUsortert(int[] a) {
        int teller = 0;
        if (a.length == 0) {
            return 0;
        } else {
            teller = 1;
        }
        for (int i = 1; i < a.length; i++) {
            int j = 0;
            for (j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j)
                teller++;
        }
        return teller;

        /*ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < a.length; i++){
            if(!(list.contains(a[i]))){
                list.add(a[i]);
            }
        }

        return list.size();*/
    }
}


