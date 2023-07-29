import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int index = -1;
        char al;
        for(char i='a'; i<='z'; i++) {
            index = -1;
            //알파벳 아스키코드표 참조 https://codedragon.tistory.com/2547
            for(int j=0; j<word.length(); j++) {
              al = word.charAt(j);
                if(al == i) {
                    index = j;
                    break;
                }
            }
            
            System.out.print(index + " ");
        }
        
        sc.close();
    }
}