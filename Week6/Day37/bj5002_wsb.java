import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
    //// 전체적으로 깔끔한거 같습니다.
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        char genders[] = br.readLine().toCharArray();
        Stack<Character> peopleStack = new Stack<>();
        int cntPeople = 0;
        int possibleSize = X + 1;

        for(char g : genders){
            if(peopleStack.empty()){
                peopleStack.push(g);
                continue;
            }

            cntPeople += cntPairEnterClub(peopleStack, g);

            if(peopleStack.size() > possibleSize) break;
        }
        cntPeople += cntOnlyEnterClub(peopleStack, X, possibleSize);

        System.out.print(cntPeople);
        br.close();
    }
    ////신선한 방법이에요
    static int cntPairEnterClub(Stack<Character> peopleStack, char gender){
        if(peopleStack.peek() != gender){
            peopleStack.pop();
            return 2;
        }

        peopleStack.push(gender);
        return 0;
    }

    //// possible이라는 변수가 사실상 remember+1이니, remember만 받아서 안쪽에서 int possible = remember = 1; 하면 매개변수가 줄어서 더 깔끔하지 않을까유?
    static int cntOnlyEnterClub(Stack<Character> peopleStack, int remember, int possible){
        if(peopleStack.size() < possible) return  peopleStack.size();
        return remember;
    }
}
