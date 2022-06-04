class GRPH{
    int verticesCount;
    int graf[][];
    int nums[];
    int E=0;
    int src;


    public GRPH(int verticesCount) {
        this.verticesCount = verticesCount;
        this.nums = new int[verticesCount];
        for (int i=0;i<verticesCount;i++) {nums[i]=Integer.MAX_VALUE;}
        this.graf = new int[verticesCount*(verticesCount-1)][3];
        //polni();
    }

    /*
    void polni() {
        for (int i=0;i<verticesCount;i++) {
            for (int j=0;j<verticesCount;j++) {
                if (i==j){graf[i][j]=0;}
                else{graf[i][j]=Integer.MAX_VALUE;}
            }
        }
    }

     */

    void addEdge(int from, int to, int cost) {
            if (from >= verticesCount || to >= verticesCount) return;
            graf[E][0]=from;graf[E][1]=to;graf[E][2]=cost;
            E++;
    }

    void printShortestDistsFrom(int from){
        src = from;
        nums[src]=0;

        //sprostimo vertricesCount-1 - krat
        for (int r = 0; r < verticesCount-1; r++) {
            for (int i = 0; i < E; i++) {
                int zacetek = graf[i][0];
                int konec = graf[i][1];
                int cena = graf[i][2];
                if (nums[zacetek] != Integer.MAX_VALUE) {
                    if (nums[zacetek] + cena < nums[graf[i][1]]) {
                        nums[graf[i][1]] = nums[zacetek] + cena;
                    }
                }
            }
        }
        System.out.println("V .. Cena");
        for (int i=0;i<verticesCount;i++) {
            if (nums[i]!=Integer.MAX_VALUE){System.out.println(i+" .. "+nums[i]);}
            else {
                System.out.println(i+" .. None");
            }

        }

    }

    void printGraf(){
        System.out.println("   0  1  2  3");
        for (int i=0;i<E;i++) {
            System.out.print(i+"| ");
            for (int j=0;j<3;j++) {
                System.out.print(graf[i][j]+"  ");
            }
            System.out.println();
        }
    }
    void printValues(){
        System.out.println();
        for (int i=0; i<verticesCount; i++){
            System.out.print(nums[i]+"  ");
        }
    }
}


class LBR{
    int cells[][];
    int x;
    int y;
    public LBR(int cells[][]) {
        this.cells=cells;
        this.y = cells.length;
        this.x = cells[1].length;
    }

    void printPath(int from, int to){
        if (from>x*y || to>x*y) {
            System.out.println("None");
            return;
        }
        int y1 = (from-1) / y;
        int x1 = (from-1) % x;
        int y2 = (to-1) / y;
        int x2 = (to-1) % x;

        if (cells[x1][y1]==1 || cells[x2][y2]==1) System.out.println("None");

    }
}
public class DN4 {
    public static void main(String args[]){
        /*
        GRPH g = new GRPH(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, -1);
        g.addEdge(3, 2, 1);
        g.printShortestDistsFrom(0);

         */
        int cells[][] = new int[][] { { 0, 0, 0, 1 },
                { 0, 0, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 0, 0, 0 } };

        LBR l = new LBR(cells);
        l.printPath(1, 16);



    }
}
