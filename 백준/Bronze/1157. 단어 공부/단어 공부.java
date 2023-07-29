import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine();
        int[] counts = new int[27];  //알파벳 27글자
        word = word.toLowerCase();
        Arrays.fill(counts, 0);
        
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            for(char a='a'; a<='z'; a++) {
                if(c == a) {
                    counts[((int)a - 97)]++;
                    break;
                }
            }
        }
        
        int max = 0;
        int maxIndex = 0;
        boolean dupl = false;
        for(int i=0; i<27; i++) {
            //dupl = false;
            if(max < counts[i]) {
                max = counts[i];
                maxIndex = i;
                dupl = false;
            } else if(max == counts[i]) {
                dupl = true;
            }
        }
        
        if(!dupl)
            System.out.println((char)(maxIndex + 65));
        else
            System.out.println("?");
    }
}