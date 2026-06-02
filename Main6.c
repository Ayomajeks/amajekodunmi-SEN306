#include <stdio.h>

void g(int *p, int q) { 
    *p = 10; 
    q = 20; 
}

int main() {
    int m = 5, n = 5;
    
    g(&m, n);
    
    // This will print: m = 10, n = 5
    printf("m = %d, n = %d\n", m, n);
    
    return 0;
}