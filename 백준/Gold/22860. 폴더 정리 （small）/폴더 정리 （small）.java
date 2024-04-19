import java.io.*;
import java.util.*;

public class Main {
    static Map<String, List<String[]>> folders;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);    // 폴더의 총 개수
        int m = Integer.parseInt(input[1]);    // 파일의 총 개수
        
        folders = new HashMap<>();
        
        for (int i = 0; i < n + m; i++) {
            input = br.readLine().split(" ");
            List<String[]> unders = folders.getOrDefault(input[0], new ArrayList<String[]>());
            unders.add(new String[] {input[1], input[2]});
            folders.put(input[0], unders);
        }
        
        int q = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < q; i++) {
            input = br.readLine().split("/");    // 뒤로 갈수록 하위 폴더
            String key = input[input.length - 1];
            
            Map<String, Integer> fileCounts = new HashMap<>();
            findFiles(key, fileCounts);
        
            if (fileCounts.size() > 0) {
                int fileCategory = fileCounts.size();
                int fileCount = 0;
                for (String fileName : fileCounts.keySet()) {
                    fileCount += fileCounts.get(fileName);
                }
                System.out.println(fileCategory + " " + fileCount);
            } else {
                System.out.println(0 + " " + 0);
            }
        }
    }
    
    private static void findFiles(String key, Map<String, Integer> fileCounts) {
        if (folders.get(key) == null) return;
        
        for (String[] folder : folders.get(key)) {
            if (folder[1].equals("0")) {
                // 해당 위치가 파일인 경우
                fileCounts.put(folder[0], fileCounts.getOrDefault(folder[0], 0) + 1);
            } else {
                // 해당 위치가 폴더인 경우 재귀 수행
                findFiles(folder[0], fileCounts);
            }
        }
    }
}