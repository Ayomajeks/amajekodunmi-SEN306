// C
#include <stdio.h>

void increment(int *p) { 
    (*p)++; 
}

int main() {
    int a = 5;
    increment(&a);
    
    // This will print: a = 6
    printf("a = %d\n", a); 
    
    return 0;
}