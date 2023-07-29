#include <stdio.h>

int main(void) {
    int a;
    int flag = 0;
    
    scanf("%d", &a);
    
    if(a % 4 == 0) {
        if(a % 100 != 0 || a % 400 == 0) {
             flag = 1;
        }
    }
    
    //printf(flag);   -> error
    printf("%d", flag);
}