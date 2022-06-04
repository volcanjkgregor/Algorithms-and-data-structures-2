
class HTB {
    int p;
    int m;
    int c1;
    int c2;
    int[] tabela;
    int[] tempTabela;
    int kolizije=0;

    public HTB(int p, int m, int c1, int c2) {
        this.p = p;
        this.m = m;
        this.c1 = c1;
        this.c2 = c2;
        this.tabela = new int[m];
    }

    void insert(int key) {
        int counter = 0;
        int ostanek = hash(key);
        if (find(key)==true) {
            return;
        }
        if (isEmpty(ostanek)==true) {
            tabela[ostanek]=key;
        }
        else {
            while(counter<m){
                kolizije++;
                counter++;
                ostanek = hashPlus(key,counter);
                if (isEmpty(ostanek)==true) {
                    tabela[ostanek]=key;
                    return;
                }
            }
            resize();
            insert(key);

        }
    }
    int hash(int k) {
        int ostanek = (k * p) % m;
        return ostanek;
    }

    int hashPlus(int k, int i) {
        int ostanek = (hash(k) + c1 * i + c2 * i * i) % m;
        return ostanek;
    }

    boolean isEmpty(int k) {
        if (tabela[k]>0) {
            return false;
        }
        return true;
    }

    void resize() {
        m = 2*m+1;
        tempTabela = tabela;
        tabela = new int[m];

        for (int i = 0;i<tempTabela.length;i++) {
            if (tempTabela[i]>0) {
                insert(tempTabela[i]);
            }
        }

    }

    boolean find(int key) {
        for(int i=0;i<tabela.length;i++){
            if (tabela[i]==key) return true;
        }

        return false;
    }

    void delete(int key) {
        for(int i=0;i<tabela.length;i++){
            if (tabela[i]==key) tabela[i]=-1;
        }

    }
    void printKeys() {
        for (int i = 0;i<tabela.length;i++){
            if (tabela[i]>0){
                System.out.println(i+": "+tabela[i]);
            }
        }
    }
    void printCollisions() {
        System.out.println(kolizije);
    }

}

public class DN3 {
    public static void main (String [] args){






        HTB ht = new HTB(7, 3, 5, 7);

        ht.insert(19); ht.insert(11); ht.insert(23); ht.insert(19); ht.insert(29);
        ht.insert(17); ht.insert(2); ht.insert(33); ht.insert(99); ht.insert(129);

        ht.printKeys();
        System.out.println("--");
        ht.printCollisions();
    }
}
