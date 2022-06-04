
import java.util.Comparator;

class Elt implements Comparator<Elt> {
    public int key;
    public Object data;


    public Elt(int key) {
        this.key=key;
        data=null;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }


    @Override
    public int compare(Elt o1, Elt o2) {
        return Integer.compare(o1.key, o2.key);
    }
}

public class DN1 {
    public static void main(String[] args){
        //Test 1
        Seznam s = null;
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(7));
        s = Seznam.insert(s,new Elt(5));
        Seznam.printElementKeys(s);

        //Test 2
        s = null;
        s = Seznam.insert(s,new Elt(1));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(2));
        s = Seznam.insert(s,new Elt(5));
        Seznam.printElementKeys(s);
        Seznam.printElementKeyComparisons(s);

        //Test 3
        s = null;
        s = Seznam.insert(s,new Elt(1));
        s = Seznam.insert(s,new Elt(2));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.delete(s,3);
        s = Seznam.delete(s,4);
        s = Seznam.delete(s,3);
        s = Seznam.delete(s,4);
        s = Seznam.delete(s,10);
        s = Seznam.insert(s,new Elt(10));
        Seznam.printElementKeys(s);

        //Test 4
        s = null;
        s = Seznam.insert(s,new Elt(1));
        s = Seznam.insert(s,new Elt(2));
        s = Seznam.insert(s,new Elt(3));
        s = Seznam.insert(s,new Elt(4));
        s = Seznam.insert(s,new Elt(5));
        Seznam.find(s,4);
        Seznam.find(s,7);
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(15));
        s = Seznam.insert(s,new Elt(11));
        s = Seznam.insert(s,new Elt(1));
        s = Seznam.delete(s,15);
        s = Seznam.delete(s,15);
        s = Seznam.insert(s,new Elt(23));
        s = Seznam.delete(s,23);
        Seznam.printElementKeyComparisons(s);

        //Test 5
        s = null;
        s = Seznam.insert(s,new Elt(5));
        Seznam.printElementKeys(s);
        Seznam.printElementKeyComparisons(s);
        s = Seznam.delete(s,5);
        Seznam.printElementKeys(s);
        Seznam.printElementKeyComparisons(s);
        Seznam.find(s,5);
        Seznam.printElementKeys(s);
        Seznam.printElementKeyComparisons(s);

        //Test 6
        s = null;
        s = Seznam.insert(s,new Elt(5));
        Seznam.find(s,5);
        s = Seznam.insert(s,new Elt(5));
        s = Seznam.insert(s,new Elt(17));
        s = Seznam.insert(s,new Elt(1));
        s = Seznam.delete(s,15);
        s = Seznam.delete(s,25);
        s = Seznam.insert(s,new Elt(23));
        s = Seznam.delete(s,31);
        s = Seznam.insert(s,new Elt(17));
        s = Seznam.insert(s,new Elt(9));
        s = Seznam.insert(s,new Elt(7));
        s = Seznam.insert(s,new Elt(3));
        Seznam.find(s,5);
        Seznam.printElementKeys(s);
        Seznam.printElementKeyComparisons(s);


    }
}

class Seznam {
    Elt head;
    Seznam tail;
    static int primerjave=0;
    static boolean trigger=false;
    static Object data1 = null;


    public Seznam(Elt e, Seznam s) {
        this.head = e;
        this.tail = s;
    }


    static Seznam insert(Seznam s, Elt e) {
        data1=e.data;
        if(find(s,e.key)==null) return new Seznam(e,s);
        return s;
    }

    static Elt find(Seznam s, int key) {

        if(s==null) return null;
        primerjave++;
        if (s.tail==null && s.head.key!=key) return null;
        if (s.head.key == key)
        {   s.head.data=data1;
            return s.head;}
        else
        {return find(s.tail,key);}

    }

    static Seznam delete(Seznam s, int key) {

        if (s==null) return null;
        primerjave++;
        if (s.head.key == key)
        {
            return s.tail;}
        else
        {return new Seznam(s.head,delete(s.tail,key));}
    }

    static void printElementKeys(Seznam s) {
        if(s==null) return;
        if (s.tail==null) {
            System.out.println(s.head);
            return;
        }
        else {
            System.out.println(s.head);
            printElementKeys(s.tail);
        }
    }

    static void printElementKeyComparisons(Seznam s) {
        if (primerjave>0 && s!=null){
            System.out.println(primerjave);
        }

    }
}
