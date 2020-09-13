import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    private static Map<Integer, List<Integer>> microOrganisms = new HashMap<>();
    private static Map<Integer, Integer> lifeTime = new HashMap<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            int years = in.nextInt();
            List<Integer> children = new ArrayList<>();
            children.add(in.nextInt());
            children.add(in.nextInt());
            microOrganisms.put(id, children);
            lifeTime.put(id, years);
        }
        List<Integer> start = new ArrayList<>();
        start.add(1);
        average(start);
    }

    private static void average (List<Integer> generation) {
        double result = 0;
        List<Integer> children = new ArrayList<>();
        for (Integer aGeneration : generation) {
            if (aGeneration != -1) {
                result += lifeTime.get(aGeneration);
                children.addAll(microOrganisms.get(aGeneration));
            }
        }
        long size = generation
                .stream()
                .filter(p -> p != -1 )
                .count();
        if (size != 0) {
            Double rr = result/size;
            System.out.print(String.format("%.2f", rr));
        }
        if (!children.isEmpty()) {
            System.out.print(" ");
            average(children);
        }
    }
}
