#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson03_InLab.py
# NAME: Chessboard Map
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/19/2023
# PURPOSE: creates a map of a chessboard with all the names of the squares


# Script main body
def name_grid():
    alpha = "a b c d e f g h"
    alpha_list = alpha.split(" ")
    for num in range(8, 0, -1):
        for letter in alpha_list:
            if letter != "h":
                print(f"{letter}{num}", end="\t")
            else:
                print(f"{letter}{num}")


def edge_lines():
    line = "-" * 65
    print(line)


# main func
def main():
    # print the top line
    edge_lines()

    # declare the list of alphabet characters a-h
    alpha = "a b c d e f g h"
    alpha_list = alpha.split(" ")
    # use list and range 8-1 counting down to make chessboard grid map
    for num in range(8, 0, -1):
        print("|", end="\t")
        for letter in alpha_list:
            if letter != "h":
                print(f"{letter}{num}", end="\t|\t")
            else:
                print(f"{letter}{num}", end="\t|\n")
            # print the bottom lines
        edge_lines()


line_break = "#" * 69
centering_tab = '\t' * 6
# print out more description for use:
print(f'\n{line_break}\n')
print(f'{centering_tab}Chessboard Map')
print(f'\n{line_break}\n')

# main line logic
if __name__ == '__main__':
    main()

print(f'\n{line_break}')

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
