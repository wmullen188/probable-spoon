#!/usr/bin/env python

# FILE: 2252_MullenW_Lesson01_GrLab1.py
# NAME: Drams Calculator
# AUTHOR(s): William Mullen
# DATE: month/day/year  02/2/2023
# PURPOSE: determine the drams ordered by the customer and check if conditions are met
# for a gallon or a pint purchase


"""
drams = ounces * 8
and the number of gills as
gills = ounces / 4
Write a program that asks the user to enter
the number of ounces of apple cider they want
to purchase to take home. It should then calculate
and display the correct number of gills and drams.
If the result is more than 1024 drams, a message
should display indicating that the amount they want
is large and they will need to purchase their cider
in gallons. If the result is less than 100 drams,
a message should display indicating that the amount
they want is too small and perhaps they should just
order a pint.
"""

line_break = "#" * 60
centering_tab = '\t' * 4
# print out more description for use:
print(f'{line_break}\n')
print(f'{centering_tab} Purchase Order Calculator')
print(f'\n{line_break}\n')

customer_ozs = int(input("Enter the number of ounces of apple cider you want to purchase:\t"))
drams = customer_ozs * 8

msg = ""
if drams < 100:
    msg = "The amount entered is too small, you should just order a pint."
elif drams > 1024:
    msg = "The amount entered is too large, you need to purchase your order in gallons."

print(msg)

print(f'\n{line_break}')

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
