public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("NEED 2 ARGUMENTS");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int i = 1;
        StringBuilder res = new StringBuilder();
        while (true) {
            res.append(i);
            i = (i + m - 2) % n + 1;
            if (i == 1) {
                break;
            }
        }
        System.out.println(res.toString());
    }
}