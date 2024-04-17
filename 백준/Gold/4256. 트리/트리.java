import java.io.*;
import java.util.*;

public class Main {
    
    static int[] preorder, inorder;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            preorder = new int[n + 1];
            inorder = new int[n + 1];
            
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                preorder[j] = Integer.parseInt(input[j]);
            }
            
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                inorder[j] = Integer.parseInt(input[j]);
            }
            
            postOrder(0, 0, n - 1);
            System.out.println();
        }
    }
    
    private static void postOrder(int rootIndex, int start, int end) {
        for (int i = start; i <= end; i++) {
            // 만약 중위 순회의 값이 루트 노드라면
            if (preorder[rootIndex] == inorder[i]) {
                // 왼쪽 트리 탐색
                // 전위 순회 다음 값은 왼쪽 서브트리의 루트 값이다.
                postOrder(rootIndex + 1, start, i);
                // 오른쪽 트리 탐색
                // 오른쪽 트리의 루트 값은 rootIndex + left의 자식 수(i - start + 1)
                postOrder(rootIndex + 1 + (i - start), i + 1, end);
                System.out.print(preorder[rootIndex] + " ");
                return;
            }
        }
    }
}