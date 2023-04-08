package ContestSolutions;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionHH1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line;
        String[] input;

        int n, m, s, result;
        line = scan.nextLine();
        input = line.split("\\s+");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        s = Integer.parseInt(input[2]);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        int nCount = 0, mCount = 0;

        for (int i = 0; i < Math.max(n, m); i++){
            line = scan.nextLine();
            input = line.split("\\s+");
            if(nCount < n){
                a.add(Integer.parseInt(input[0]));
                nCount++;
            }
            if(mCount < m){
                b.add(Integer.parseInt(input[1]));
                mCount++;
            }
        }

        nCount = 0;
        mCount = 0;
        int currentSum = 0;
        for(Integer el : a) {
            if (currentSum + el > s){
                break;
            }
            currentSum += el;
            nCount++;
        }
        result = nCount;

        for(Integer el : b){
            currentSum += el;
            mCount++;
            while (currentSum > s && nCount > 0){
                currentSum -= a.get(nCount - 1);
                nCount--;
            }
            if (currentSum <= s){
                result = Math.max(nCount + mCount, result);
            }
        }
        System.out.println(result);
    }
}
