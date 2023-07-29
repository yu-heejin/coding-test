import java.util.Scanner;

//반례 : ddz=z=- https://www.acmicpc.net/board/view/93085
//알파벳 소문자와 -, = 로만 이루어져 있다.
//반례2 : 알파벳이나 -, = 하나인 경우
//반례3 : nj, lj 역시 dz=와 같이 하나의 알파벳으로 쓰인다

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int count = 0;
        
        if(str.length() <= 1) {
            char first = str.charAt(0);
            if(str.equals("=") || str.equals("-")) count++;
            else if(first >= 'a' && first <= 'z') count++;
        } else {
            for(int i=0; i<str.length()-1; i++) {
                char a = str.charAt(i);
                char b = str.charAt(i+1);
            
                if(a == 'c' && (b == '=' || b == '-')) {
                    i++;
                } else if(a == 'd' && b == '-') {
                    i++;
                } else if(a == 'd' && (i < str.length()-2 && b == 'z')) {
                    char c = str.charAt(i+2);
                    if(c == '=') {
                        i += 2;
                    }
                } else if(b == 'j' && (a == 'n' || a == 'l')) i++;
                  else if(a == 's' && b == '=') i++;
                  else if(a == 'z' && b == '=') i++;

                count++;
            }
        
            char end = str.charAt(str.length()-1);
            char end2 = str.charAt(str.length()-2);
            if((end2 != 'c' && end2 != 'd') && end == '-') {
                count++;
            } else if(end == '=') {
                if((end2 != 'c' && end2 != 'z') && end2 != 's') {
                    count++;
                }
            } else {
                for(char c='a'; c<='z'; c++) {
                    if(end == c) {
                        if(c == 'j' && (end2 != 'n' && end2 != 'l')) {
                            count++;
                            break;
                        } else if(c != 'j') {
                            count++;
                            break;
                        }
                    }
               }      
            }
        }
        System.out.println(count);
    }
}