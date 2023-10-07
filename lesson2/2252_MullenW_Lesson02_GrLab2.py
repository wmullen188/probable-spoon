#!/usr/bin/env python

# FILE: 2252_MullenW_Lesson01_InLab2.py
# NAME: Color Mixer
# AUTHOR(s): William Mullen
# DATE: month/day/year  02/2/2023
# PURPOSE: determine what color has been made by the user after they pick which to combine
# uses validation to confirm that a primary color has been chosen and different colors

line_break = "#" * 60
centering_tab = '\t' * 5
# print out more description for use:
print(f'{line_break}\n')
print(f'{centering_tab}Color Mixer')
print(f'\n{line_break}\n')

"""Design a program which prompts the user to enter two of the primary colors. If anything 
other than "red" "blue" or "yellow" is entered, the program should display an error message. If they enter
two of the same color, an error message should display. Otherwise, the program should display the name of the 
new secondary color.

red, blue, and yellow - create secondary colors - orange, green, and purple.
Mix red and blue to get purple
Mix blue and yellow to get green
Mix yellow and red to get orange"""

color1 = input('What is your first color?\t')
color1 = color1.lower()

error_msg1 = 'The color must be primary, either: red, blue, or yellow'
if color1 != 'red' and color1 != 'blue' and color1 != 'yellow':
    print(error_msg1)

color2 = input('What is your second color?\t')
color2 = color2.lower()

error_msg2 = 'The color must be different than your first choice.'
if color2 == color1:
    print(error_msg2)
else:
    if color2 != 'red' and color2 != 'blue' and color2 != 'yellow':
        print(error_msg1)

if color1 == 'red':
    if color2 == 'blue':
        mix = 'purple'
    else:
        mix = 'orange'
elif color1 == 'blue':
    if color2 == 'red':
        mix = 'purple'
    else:
        mix = 'green'
elif color1 == 'yellow':
    if color2 == 'red':
        mix = 'orange'
    else:
        mix = 'green'

print(f'You mixed {color1} and {color2}! That makes {mix}!\n')

print(f'\n{line_break}')

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
