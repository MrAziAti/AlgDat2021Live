package LinkedLists;


public class DobbeltLenketListe {

    public static void main(String[] args) {
        DobbeltLenketListe list = new DobbeltLenketListe();

        list.add_first(1);
        list.print();
        list.add_last(3);
        list.print();
        list.add_last(7);
        list.add_last(8);
        list.add_last(10);
        list.print();
        list.insert1(2, 5);
        list.print();

        System.out.println(list.finnNode(5).value);

    }

    /**
     * Reperesentashibn av enb node i en dobbelt lenke liste
     */
    static class Node {
        int value; // Burde brukt genereisk // Verdien vi skal lagre
        Node next; // Peker til neste node eller null
        Node prev;// Peker til forrige node eller null

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    //Variabler i klassen min
    Node head; // Peker til første node i listen
    Node tail; // Peker til siste node i listen
    int num_values; // Antall verdier i listen

    /**
     * Konstruktør
     */
    DobbeltLenketListe() {
        this.head = null;
        this.tail = null;
        this.num_values = 0;
    }

   public Node finnNode(int indeks) {
        int r = num_values / 2;
        Node p = head;

       if(indeks <= r) {
           for (int i = 0; i < indeks; i++) {
               p = p.next;
           }
           System.out.println("I indeks < r");
           System.out.println("r verdi " + r);
       }

       else {
           System.out.println("Jeg er her i else");
           System.out.println("r verdi " + r);
           p = tail;
           for (int i = num_values-1; i > indeks; i--) {
               p = p.prev;
           }

       }


        return p;
    }

    public void print() {
        // Alternativ: skriv som for løkke
        Node cur = head;
        for (int i = 0; i < num_values; i++) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        //Alternativ: skriv som while løkke
        Node q = head;
        while (q != null) {
            System.out.print(q.value + " ");
            q = q.next;
        }
        System.out.println();
    }

    /**
     * Add funksjon. Legger til ved hode enden av dobbelt lenkede listen
     * Synonymer: head, front,
     *
     * @return Posisjonen til den nye noden vi har;
     */
    int add_first(int value) {
        Node p = new Node(value);

        //Spesialtilfellet : Tom liste
        //Head = null
        //Tail = null
        if (head == null && tail == null) {
            //alternativt if(num_values == 0)
            head = p;
            tail = p;
            num_values++;
        }
        //Generell tilfellet - vi har noder allerede i listen vår
        else {
            Node q = head;
            head = p;
            q.prev = p;
            p.next = q;
            num_values++;

        }
        return num_values;
    }

    /**
     * Add funksjon. Legger til ved hale enden;
     * Synonymer: back, tail,...
     */
    void add_last(int value) {
        Node p = new Node(value);

        if ((head == null && tail == null)) {
            add_first(value);
        } else {
            Node q = tail;
            tail = p;
            q.next = p;
            p.prev = q;
            num_values++;

        }

    }

    /**
     * Insert fuksjon
     * Legger til ny node med index index
     */
    void insert(int index, int value) {

        if (index == 0) {
            add_first(value);
        }
        if (index == num_values - 1) {
            add_last(value);
        }
        Node q = new Node(value);

        //Finn de nodene vi skal sette in p mellom
        //Slik at vi får p -q -r i listen vår
        Node r = head;
        for (int i = 0; i < index; i++) {
            r = r.next;
        }

        Node p = r.prev;
        p.next = q;
        q.next = r;
        q.prev = p;
        r.prev = q;
        num_values++;

    }

    void insert1(int index, int value) {
        if (index == 0) {
            //Spesialtilfelle!
            add_first(value);
        }
        else if (index == num_values) {
            //spesialtilfelle - add_last
            add_last(value);
        }
        else {
            Node q = new Node(value);

            //Finn de nodene vi skal sette inn p mellom
            //slik at vi får p - q - r i listen vår
            Node r = head;
            for (int i = 0; i < index; ++i) {
                r = r.next;
            }
            Node p = r.prev;

            p.next = q;
            q.next = r;
            q.prev = p;
            r.prev = q;

            num_values += 1;
        }
    }


}
