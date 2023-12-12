import java.io.*;
import java.util.*;

public class Main {
    
    static final List<String> croatias = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        croatias.add("c=");
        croatias.add("c-");
        croatias.add("dz=");
        croatias.add("d-");
        croatias.add("lj");
        croatias.add("nj");
        croatias.add("s=");
        croatias.add("z=");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int answer = 0;
        boolean[] visited = new boolean[str.length()];
        
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = "" + str.charAt(i) + str.charAt(i + 1);
            
            if (i < str.length() - 2 && str.charAt(i) == 'd' && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                sub += str.charAt(i + 2);
                visited[i] = true;
                visited[i + 1] = true;
                visited[i + 2] = true;
                answer++;
                i += 2;
                continue;
            }
            
            if (croatias.indexOf(sub) != -1) {
                visited[i] = true;
                visited[i + 1] = true;
                answer++;
                i++;
            } else {
                visited[i] = true;
                answer++;
            }
        }
        
        if (!visited[visited.length - 1]) {
            answer++;
        }
        
        System.out.println(answer);
    }
}