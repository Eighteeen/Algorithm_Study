import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int A[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int targets[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int fistHigh = N - 1;
        Arrays.sort(A);

        for(int target : targets){
            if(binarySearch(A, 0, fistHigh, target)) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean binarySearch(int A[], int low, int high, int target){
        if(low > high) return false;
        int mid = (low + high) / 2;
        if(A[mid] == target) return true;
        if(A[mid] > target) return binarySearch(A, low, --mid, target);
        else return binarySearch(A, ++mid, high, target);
    }
}