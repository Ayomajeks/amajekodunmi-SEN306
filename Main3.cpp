#include <iostream>

// The & means we are passing by reference!
void increment(int &x) { 
    x = x + 1; 
}

int main() {
    int a = 5;
    increment(a);  
    std::cout << a << std::endl; // This will now print 6!
    return 0;
}