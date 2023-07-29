import java.util.Scanner;

public class Main {
    static boolean nextPermutation(int[] arr) {
        int j = -1;
        int n = arr.length;
        
        for(int i=n-1; i>=1; i--) {
            if(arr[i] > arr[i-1]) {
                j = i-1;
                break;
            }
        }
        
        if(j == -1) return false;
        
        for(int i=n-1; i>=j+1; i--) {
            if(arr[j] < arr[i]) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                break;
            }
        }
                   
        for(int i=j+1; i<n; i++) {
            for(int k=i+1; k<n; k++) {
                if(arr[i] > arr[k]) {
                    int tmp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = tmp;
                }
            }
        }
        
        //print(arr);
        return true;
    }
    
    static void print(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        
        print(arr);
        
        while(nextPermutation(arr)) {
            print(arr);
        }
        
        sc.close();
    }
}