package VideoForelesninger;

import java.util.Comparator;

public class GenericsTest {
    public static void main(String[] args) {
        int[] a = {1,8,3,7,98,5,31};
        char[] b = {'A','C','Z','L','K','Y','M'};
        String[] e = {"Kari", "ASF","Poteter","Lammelår","Eple","Petter"};

        Person[] p = {new Person("Petter","Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils","Abrahamsen"), new Person("tor","toresen")};

        Integer[] c = {1,8,3,7,98,5,31}; // For generics
        Character[] d = {'A','C','Z','L','K','Y','M'}; // for generics

        System.out.println("Maks av int-Array");
        System.out.println(maks(a));

        System.out.println("Maks av char-Array");
        System.out.println(maks(b)); // uten generics


        System.out.println("Generic Maks av int-Array");
        System.out.println(maks_generic(c));

        System.out.println("Generic Maks av char-Array");
        System.out.println(maks_generic(d)); // uten generics

        System.out.println("Generic Maks av String-Array");
        System.out.println(maks_generic(e)); // uten generics

        System.out.println("Generic Maks av Person-Array");
        System.out.println(maks_generic(p)); // uten generics

    }

    public static class Person implements Comparable<Person>{
        String first_name;
        String last_name;

        public Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        @Override
        public int compareTo(Person other) {
            /**
             * if this.last_name < other.last_name
             * return -1;
             * else if this.last_name == other.last_name;
             * else
             * return 1;
             */
            int last_compare = this.last_name.compareTo(other.last_name);
            if(last_compare == 0){
                return this.first_name.compareTo(other.first_name);
            }else{
                return last_compare;
            }
        }
    }

    static <T extends Comparable<? super T>>
    int maks_generic(T[] values){

        T current_maks = values[0];
        int current_indeks = 0;
        for(int i = 1; i < values.length; i++){
            //if(values[i] > current_maks){

            if(values[i].compareTo(current_maks) > 0){
                current_maks = values[i];
                current_indeks = i;
            }
        }

        return current_indeks;
    }
    public static int maks(int[] values){

        int current_maks = values[0];
        int current_indeks = 0;
        for(int i = 1; i < values.length; i++){
            if(values[i] > current_maks){
                current_maks = values[i];
                current_indeks = i;
            }
        }

        return current_indeks;
    }

    public static int maks(char[] values){

        char current_maks = values[0];
        int current_indeks = 0;
        for(int i = 1; i < values.length; i++){
            if(values[i] > current_maks){
                current_maks = values[i];
                current_indeks = i;
            }
        }

        return current_indeks;
    }
}
