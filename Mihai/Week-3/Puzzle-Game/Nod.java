import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Mihai on 04.03.2016.
 */
public class Nod {
    int[][] puzzle;
    Nod parinte;
    int cost;

    public Nod(int[][] puzzle, Nod parinte, int cost) {
        this.puzzle = new int[puzzle.length][puzzle.length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++)
                this.puzzle[i][j] = puzzle[i][j];
        }
        this.parinte = parinte;
        this.cost = cost;
    }

    public Nod() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("fis.in"));
        puzzle = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                puzzle[i][j] = sc.nextInt();
        parinte = null;
        cost = 0;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public Nod getParinte() {
        return parinte;
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        String s = new String();
        for (int[] x : puzzle) {
            for (int y : x)
                s = s + y + " ";
            s += "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nod)) return false;

        Nod nod = (Nod) o;
        boolean ok=true;
        int[][] a=nod.getPuzzle();
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++)
                if(a[i][j]!=puzzle[i][j])
                    ok=false;
        return ok;

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(puzzle);
    }
}
