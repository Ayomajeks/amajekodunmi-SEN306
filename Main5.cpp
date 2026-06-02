#include <iostream>

void f(int a, int &b) { 
    a = 2; 
    b = 3; 
}

int main() {
    int x = 1, y = 1;
    f(x, y);
    
    // Prints: 1, 3
    std::cout << x << ", " << y << std::endl; 
    return 0;
}