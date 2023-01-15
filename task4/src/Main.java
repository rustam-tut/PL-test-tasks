import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("NEED 1 ARGUMENT");
            return;
        }
        List<Integer> nums = getNums(args[0]);
        int moves = minMoves(nums);
        System.out.println(moves);
    }

    private static List<Integer> getNums(String fName) {
        List<Integer> nums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
            String line;
            while ((line = br.readLine()) != null) {
                nums.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nums;
    }

    //my code from LeetCode, updated for JDK's ArrayList
    private static int minMoves(List<Integer> nums) {
        nums.sort((x, y) -> x - y);
        int l = 0;
        int r = nums.size() - 1;
        int moves = 0;
        while (l < r) {
            moves += nums.get(r--) - nums.get(l++);
        }
        return moves;
    }
}