import java.util.Scanner;

public class bj2562_jhw_fb {
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numArr[] = new int[9];
		int max = 0;
		int index = 0;
		for(int i = 0; i < numArr.length; i++) {
            //// 탭정리가 아직도 조금 아쉬워요 ㅠㅠ
            ////->수정했습니다.
			 int str = sc.nextInt();
             numArr[i] = str;
             
			 if(max < numArr[i]) {
			    max = numArr[i];
			    index = i+1;
			 }
			 
		}
		System.out.println(max + "\n" + index);

	}
}
