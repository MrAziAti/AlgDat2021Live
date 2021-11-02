package VideoForelesninger;

import java.util.Arrays;

public class VisitorPatternTest {
    public static class Person {
        String first_name;
        String last_name;

        public Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }


        public String toString() {
            return first_name + " " + last_name;
        }
    }

    /**
     * Et interface - det lover at alle som implementerer dette
     * har de foreskrevne funksjonene.
     *
     * @param <T> Objektet som kommer inn
     */
    @FunctionalInterface
    public interface Komparator<T> {
        int compare(T a, T b);

    }

    public static class DescendingComparator
            implements Komparator<Person> {

        @Override
        public int compare(Person a, Person b) {
            int last_compare = a.last_name.compareTo(b.last_name);
            if (last_compare == 0) {
                return a.first_name.compareTo(b.first_name);
            } else {
                return last_compare;
            }
        }
    }
    public static class AscendingComparator
            implements Komparator<Person> {

        @Override
        public int compare(Person a, Person b) {
            int last_compare = b.last_name.compareTo(a.last_name);
            if (last_compare == 0) {
                return b.first_name.compareTo(a.first_name);
            } else {
                return last_compare;
            }
        }
    }

    public static class OddePartallKomparator
        implements Komparator<Integer>{

        public int compare(Integer a, Integer b){
            //Først sammenlikn "Etternavnet" => partall eller oddetall;

            //Begge er partall eller begge er odde tall
            if(a % 2 == b % 2){
                return a.compareTo(b);
            }
            // A er oddetall, b er partall
            else if(a % 2 > b % 2){
                return 1;
            }
            // B er oddetal, a er partall
            else if(b % 2 > a % 2){
                return -1;
            }

            //Not a number, infinity, burde kaste exception
            return 0;
        }
    }
    public static class OddePartallKomparatorAsc
            implements Komparator<Integer>{

        public int compare(Integer a, Integer b){
            //Først sammenlikn "Etternavnet" => partall eller oddetall;

            //Begge er partall
            if(a % 2 == b % 2 ){
                return b.compareTo(a);
            }
            // A er oddetall, b er partall
            else if(a % 2 > b % 2){
                return 1;
            }
            // B er oddetal, a er partall
            else if(b % 2 > a % 2){
                return -1;
            }
            return 0;
        }
    }
    public static class Asc
            implements Komparator<Integer> {

        public int compare(Integer a, Integer b) {
            if(a > b){
                return -1;
            }
            return 1;
        }
    }

    /**
     * Denn funksjonen finner største verdi values
     * Bruker sammenlinkngsfunksjonene i objektet comp for sammenlinkning

     */
    public static <T> int maks(T[] values, int begin, int end, Komparator<T> comp) {
        T current_maks = values[begin];
        int current_indeks = begin;
        for (int i = begin + 1; i < end; i++) {
            if (comp.compare(values[i], current_maks) > 0) {
                current_maks = values[i];
                current_indeks = i;
            }
        }

        return current_indeks;

    }

    public static <T> void sort(T[] values, Komparator<T> comp) {
        // Looper over alle unntatt siste element
        for (int i = 0; i < values.length - 1; i++) {
            //Finn største element i intervallet [i, a.length)
            int maks_indeks = maks(values, i, values.length, comp);
            //bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[maks_indeks];
            values[maks_indeks] = temp;

            //Fortsett
        }
    }
        public static void main (String[]args) {
            Person[] p = {new Person("Petter", "Pettersen"),
                    new Person("Kari", "Pettersen"),
                    new Person("Nils", "Abrahamsen"),
                    new Person("Tor", "Toresen")};

            System.out.println("Hello World");


            //0 Lag comparator-objektet
            // vi kan nå kjøre comp.compare(a,b)
            AscendingComparator comp_asc = new AscendingComparator();
            DescendingComparator comp_dec = new DescendingComparator();
            OddePartallKomparator odd_Partall = new OddePartallKomparator();
            OddePartallKomparatorAsc oddAsc = new OddePartallKomparatorAsc();

            Asc asc = new Asc();

            //1 Lage sorterings-funksjonen som tar inn både person-arrayet og en sammenlikningsfunksjon

            System.out.println("Før: " + Arrays.toString(p));
            sort(p, comp_asc);
            System.out.println("Etter: (Ascending): " + Arrays.toString(p));
            sort(p, comp_dec);
            System.out.println("Etter: (Deseining): " + Arrays.toString(p));

            Integer[] integers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

            //Vil sortere sånn at vi får oddetall til venstre og partall til høyre.
            //Partall og oddetall skal være inbyrdes sortert.

            System.out.println("Før sortering: " + Arrays.toString(integers));
            sort(integers, odd_Partall);
            System.out.println("Etter sortering: " + Arrays.toString(integers));

            sort(integers, oddAsc);
            System.out.println("Etter sortering: " + Arrays.toString(integers));

            sort(integers, asc);
            System.out.println("Etter sortering: " + Arrays.toString(integers));


        }
    }

