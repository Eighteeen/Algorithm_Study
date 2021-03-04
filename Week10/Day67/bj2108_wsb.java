import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        for(int i = 0; i < N; i++) numArr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(numArr);

        sb.append(getMean(numArr)).append("\n")
            .append(getMedian(numArr)).append("\n")
            .append(getMode(numArr)).append("\n")
            .append(getRange(numArr)).append("\n");

        System.out.print(sb);
        br.close();
    }

    static int getMean(int[] numArr){
        int sum = 0;
        for(int num : numArr){
            sum += num;
        }
        return Math.round(sum / (float)N);
    }

    static int getMedian(int[] sortedNumArr){
        return sortedNumArr[N / 2];
    }

    static int getMode(int[] sortedNumArr){
        int maxCnt = 0, checkCnt = 1;
        int maxOrSecondMax = sortedNumArr[0], checkNum = sortedNumArr[0];
        boolean isSecond = false;

        for(int i = 1; i < N; i++){
            if(checkNum != sortedNumArr[i]){
                if(maxCnt < checkCnt){
                    maxCnt = checkCnt;
                    maxOrSecondMax = sortedNumArr[i - 1];
                    isSecond = false;
                }else if(maxCnt == checkCnt && !isSecond){
                    maxOrSecondMax = sortedNumArr[i - 1];
                    isSecond = true;
                }

                checkNum = sortedNumArr[i];
                checkCnt = 0;
            }

            checkCnt++;
        }

        if(maxCnt < checkCnt || (maxCnt == checkCnt && !isSecond)){
            maxOrSecondMax = sortedNumArr[N - 1];
        }

        return maxOrSecondMax;
    }

    static int getRange(int[] sortedNumArr){
        return sortedNumArr[N - 1] - sortedNumArr[0];
    }
}