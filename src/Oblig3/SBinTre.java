package Oblig3;


import java.util.*;

public class SBinTre<T> {


    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }


    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    /***
     * Legg inn metoden er kopiert fra kompendiet.
     * @param verdi er den verdien som legges inn når denne metoden kalles. Altså verdi som legges til i det binære
     *              søke treet.
     * @return denne metoden returnerer true eller false ved innleggelse av e ny node
     */
    public final boolean leggInn(T verdi)    // skal ligge i class SBinTre
    {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        /**
         * Endring som er lagt inn: Når ny node opprettes så legges foreldre også inn i kallet.
         */
        p = new Node<>(verdi, q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }


    public boolean fjern(T verdi)  // hører til klassen SBinTre
    {
        if (verdi == null) return false;  // treet har ingen nullverdier

        Node<T> p = rot, q = null;   // q skal være forelder til p

        while (p != null)            // leter etter verdi
        {
            int cmp = comp.compare(verdi, p.verdi);      // sammenligner
            if (cmp < 0) {
                q = p;
                p = p.venstre;
            }      // går til venstre
            else if (cmp > 0) {
                q = p;
                p = p.høyre;
            }   // går til høyre
            else break;    // den søkte verdien ligger i p
        }
        if (p == null) return false;   // finner ikke verdi

        if (p.venstre == null || p.høyre == null)  // Tilfelle 1) og 2)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
            if (p == rot) {
                rot = b;
                if(rot != null)
                    rot.forelder = null;
            } else if (p == q.venstre) q.venstre = b;
            else q.høyre = b;
        } else  // Tilfelle 3)
        {
            Node<T> s = p, r = p.høyre;   // finner neste i inorden
            while (r.venstre != null) {
                s = r;    // s er forelder til r
                r = r.venstre;
            }

            p.verdi = r.verdi;   // kopierer verdien i r til p

            if (s != p) s.venstre = r.høyre;
            else s.høyre = r.høyre;
        }
        if (q != null) {
            if (q.venstre != null) {
                q.venstre.forelder = q;
            }
            if (q.høyre != null) {
                q.høyre.forelder = q;
            }
        }
        antall--;   // det er nå én node mindre i treet
        return true;
    }


    public int fjernAlle(T verdi) {

        int verdiAntall = 0;
        while (fjern(verdi)) verdiAntall++;
        return verdiAntall;
    }

    public int antall(T verdi) {
        if (verdi == null) return 0;
        int i = 0;
        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else {
                if (cmp == 0) i++;
                p = p.høyre;
            }
        }
        return i;
    }

    public void nullstill() {
        if (!tom()) nullstill(rot);
        rot = null;
        antall = 0;
    }

    private static <T> void nullstill(Node<T> p) {

        if (p.venstre != null) {
            nullstill(p.venstre);
            p.venstre = null;
        }
        if (p.høyre != null) {
            nullstill(p.høyre);
            p.høyre = null;
        }
        p.verdi = null;


    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        while (true) {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p;
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        Node<T> f = p.forelder;

        if (f == null) {
            return null;
        }
        if (p == f.høyre) {
            return p.forelder;
        }
        if (p == f.venstre && p.forelder.høyre == null) {
            return p.forelder;
        }
        return førstePostorden(f.høyre);


    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = førstePostorden(rot);
        while (p != null) {
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        if (!tom()) postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if (p == null) {
            return;
        }
        postordenRecursive(p.venstre, oppgave);
        postordenRecursive(p.høyre, oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        if (tom()) return null;
        Queue<Node<T>> kø = new LinkedList<>();
        kø.add(rot);

        ArrayList<T> l = new ArrayList<>();
        while (!kø.isEmpty()) {
            Node<T> p = kø.poll();
            if (p == null) {
                continue;
            } else {
                l.add(p.verdi);
                kø.add(p.venstre);
                kø.add(p.høyre);
            }
        }

        return l;
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        SBinTre<K> tre = new SBinTre<>(c);
        for (K k : data) {
            tre.leggInn(k);
        }
        return tre;
    }


} // ObligSBinTre
