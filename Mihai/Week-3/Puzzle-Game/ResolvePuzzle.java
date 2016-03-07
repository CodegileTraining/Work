import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import java.util.Queue;

/**
 * Created by Mihai on 04.03.2016.
 */

//istanbull dj vulcan

public class ResolvePuzzle {

    static Queue<Nod> fringe = new PriorityQueue<>(new NodComparator());
    static Set<Nod> closed = new HashSet<>();

    public static Dimension findXY(int[][] a) {
        int x = 0;
        int y = 0;
        int aux;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 0) {
                    x = i;
                    y = j;
                }

            }
        }
        return new Dimension(x, y);
    }

    public static void Copy(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[i][j];
            }
    }

    public static List<Nod> generateSolution(Nod puzzle) throws FileNotFoundException {

        Nod nod;
        List<Nod> solutions = new ArrayList<>();
        Dimension point0 = findXY(puzzle.getPuzzle());
        int x = point0.width;
        int y = point0.height;
        int[][] a = new int[puzzle.getPuzzle().length][puzzle.getPuzzle().length];
        int[][] b = new int[puzzle.getPuzzle().length][puzzle.getPuzzle().length];
        Copy(puzzle.getPuzzle(), a);
        Copy(puzzle.getPuzzle(), b);
        int aux;

        if (x != puzzle.getPuzzle().length - 1) {
            aux = a[x][y];
            a[x][y] = a[x + 1][y];
            a[x + 1][y] = aux;
            nod = new Nod(a, puzzle, puzzle.getCost() + 1);
            solutions.add(nod);
        }
        if (y != puzzle.getPuzzle().length - 1) {
            Copy(b, a);
            aux = a[x][y];
            a[x][y] = a[x][y + 1];
            a[x][y + 1] = aux;
            nod = new Nod(a, puzzle, puzzle.getCost() + 1);
            solutions.add(nod);
        }

        if (x != 0) {
            Copy(b, a);
            aux = a[x][y];
            a[x][y] = a[x - 1][y];
            a[x - 1][y] = aux;
            nod = new Nod(a, puzzle, puzzle.getCost() + 1);
            solutions.add(nod);
        }

        if (y != 0) {
            Copy(b, a);
            aux = a[x][y];
            a[x][y] = a[x][y - 1];
            a[x][y - 1] = aux;
            nod = new Nod(a, puzzle, puzzle.getCost() + 1);
            solutions.add(nod);
        }
        return solutions;
    }

    public static boolean isSolution(Nod solution) {
        int ok = 1;
        int[][] a = solution.getPuzzle();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (ok < a.length * a.length)
                    if (a[i][j] != ok++)
                        return false;
        return true;
    }

    public static void main(String[] args) {
        boolean found = false;
        List<Nod> solutions;
        try {
            Nod s = new Nod();
            found = isSolution(s);
            fringe.add(s);
            closed.add(fringe.peek());
            if (found)
                System.out.println(s);
            while (found == false) {
                solutions = generateSolution(fringe.peek());
                closed.add(fringe.poll());
                for (Nod x : solutions) {
                    if ((found = isSolution(x)) == true) {
                        do {
                            System.out.print(x);
                            System.out.println("  ^  ");
                            System.out.println("  |  ");
                            x = x.getParinte();
                        } while (x != null);
                        break;
                    }
                    if (closed.contains(x) == false)
                        fringe.add(x);

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}


class NodComparator implements Comparator<Nod> {

    @Override
    public int compare(Nod o1, Nod o2) {
        int ok = 1;
        int s=0;
        int[][] a = o1.getPuzzle();
        int[][] b = o2.getPuzzle();
        int[] x=new int[a.length*a.length];
        int[] y=new int[a.length*a.length];
        getArray(a,x);
        getArray(b,y);
        if(getNumberOfInversion(x)<getNumberOfInversion(y))
            return -1;
        if(getNumberOfInversion(x)>getNumberOfInversion(y))
            return 1;
        return 0;
    }
    public static void getArray(int[][] a,int[] b){
        int s=0;
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++)
                b[s++]=a[i][j];
    }
    public static int getNumberOfInversion(int[] a){
        int s=0;
        for(int i=0;i<a.length-1;i++)
            for(int j=i+1;j<a.length;j++)
                if(a[i]>a[j])
                    s++;
        return s;
    }
}