#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson01_GrLab1.py
# NAME: Receipt Creator
# AUTHOR(s): William Mullen
# DATE: month/day/year 01/27/2023
# PURPOSE: Create a receipt to print for the customer


# Script main body
# main func
def main():
    meal = float(input("What is the cost of the meal?:\t$"))
    tip = float(input("What is the tip amount?:\t\t$"))

    taxrate = 0.065
    tax = meal * taxrate
    subtotal = meal + tax
    total = subtotal + tip

    print(f"\nMeal Total:\t${meal:.2f}")
    print(f"Tax:\t\t${tax:.2f}")
    print(f"Subtotal:\t${subtotal:.2f}")
    print(f"Tip:\t\t${tip:.2f}")
    print(f"Total:\t\t${total:.2f}")


line_break = "#" * 60
centering_tab = '\t' * 7
# print out more description for use:
print(f'{line_break}\n')
print(f'{centering_tab}Receipt')
print(f'\n{line_break}\n')

# main line logic
if __name__ == '__main__':
    main()


print(f'\n{line_break}')

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
