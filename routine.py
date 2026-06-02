def modify(lst, num):
    lst.append(4)
    num = 100

my_list = [1, 2, 3]
x = 7
modify(my_list, x)

# This will print: [1, 2, 3, 4] 7
print(my_list, x)