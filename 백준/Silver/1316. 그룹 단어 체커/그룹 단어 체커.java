//예제를 보면 알파벳이 하나만 나와도 연속해서 나왔다고 가정함
//각 '문자'가 연속해서 나타나는 경우
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
        boolean[] checks = new boolean[27];
        boolean isGroup = true;
        
        for(int i=0; i<n; i++) {
            isGroup = true;
            Arrays.fill(checks, false); 
            //값을 원점으로 초기화 한 후 입력을 받음
            String str = sc.nextLine();
            //System.out.println(str);
            
            char first = str.charAt(0);
            checks[((int)first-97)] = true;
            //첫번째 글자를 미리 check해놓고 들어간다.
            
            for(int j=1; j<str.length(); j++) {
                char c = str.charAt(j);
                for(char a='a'; a<='z'; a++) {
                   if(c == a) {
                       char c2 = str.charAt(j-1);
                       if(checks[((int)a-97)]) {  //만약 이 글자가 이전에 이미 나왔고,
                           if(c != c2) {   //연속적이지 않다면?
                               isGroup = false;  //false
                               break;
                           }
                       } else {  //처음 나온 글자라면
                           checks[((int)a-97)] = true;
                       }
                   }
                }
                
                if(!isGroup) break;   //그룹단어가 아니면 볼 필요도 없음
            }
            
            if(isGroup) {  //그룹단어라면 카운트 증가
                count++;
            }
            //System.out.println(count + "\n");
        }
        
        System.out.println(count);
        
        
    }
}