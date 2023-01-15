import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private final static int ON = 0;
    private final static int IN = 1;
    private final static int OUT = 2;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("NEED 2 ARGUMENTS");
            return;
        }
        Circle circle = parseCircle(args[0]);
        List<float[]> points = parsePoints(args[1]);

        while(points.size() != 0) {
            float[] p = points.get(0);
            points.remove(0);
            float nr = (float)(Math.pow(p[0] - circle.getCx(), 2) + Math.pow(p[1] - circle.getCy(), 2));
            int res = Float.compare(nr, (float)Math.pow(circle.getR(), 2));
            switch (res) {
                case 0:
                    System.out.println(ON);
                    break;
                case -1:
                    System.out.println(IN);
                    break;
                case 1:
                    System.out.println(OUT);
                    break;
            }
        }
    }

    private static Circle parseCircle(String fName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fName));
        String l1 = br.readLine();
        String l2 = br.readLine();
        br.close();
        String[] sl1 = l1.split("[\t ]");
        return new Circle(Float.parseFloat(sl1[0]),
                Float.parseFloat(sl1[1]),
                Float.parseFloat(l2));
    }

    private static List<float[]> parsePoints(String fName) throws Exception {
        List<float[]> points = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(fName));
        String l;
        while((l = br.readLine()) != null) {
            float[] point = new float[2];
            String[] spl = l.split("[\t ]");
            point[0] = Float.parseFloat(spl[0]);
            point[1] = Float.parseFloat(spl[1]);
            points.add(point);
        }
        br.close();
        return points;
    }
}