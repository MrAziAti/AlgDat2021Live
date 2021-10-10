package VideoForelesninger;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class GenericSorting {

    public static class Person implements Comparable<Person> {
        String first_name;
        String last_name;

        public Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        @Override
        public int compareTo(Person other) {
            int last_compare = this.last_name.compareTo(other.last_name);
            if (last_compare == 0) {
                return this.first_name.compareTo(other.first_name);
            } else {
                return last_compare;
            }
        }
        public String toString(){
            return first_name + " " + last_name;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 8, 3, 7, 98, 5, 31};
        Character[] b = {'A', 'C', 'Z', 'L', 'K', 'Y', 'M'};
        String[] c = {"Kari", "ASF", "Poteter", "Lammelår", "Eple", "Petter"};
        Person[] p = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};

        int person_max = (maks_generic(p,0,p.length));
        System.out.println("Siste person, leksikogragisk, er " + p[person_max]);

        System.out.println("Sorterer personer");

        System.out.println("Før: " + Arrays.toString(p));
        sort(p);

        System.out.println("Etter: " + Arrays.toString(p));
    }

    static
    <T extends Comparable<? super T>>
    void sort(T[] values){
        // Looper over alle unntatt siste element
        for( int i = 0; i < values.length -1; i++){
            //Finn største element i intervallet [i, a.length)
            int maks = maks_generic(values, i, values.length);
            //bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[maks];
            values[maks] = temp;

            //Fortsett

        }
    }


    static
    <T extends Comparable<? super T>> // For sammenligning av objekter - for sortering.
    int maks_generic(T[] values, int begin, int end) {

        T current_maks = values[begin];
        int current_indeks = 0;
        for (int i = begin +1; i < end; i++) {
            //if(values[i] > current_maks){

            if (values[i].compareTo(current_maks) > 0) {
                current_maks = values[i];
                current_indeks = i;
            }
        }

        return current_indeks;
    }
}