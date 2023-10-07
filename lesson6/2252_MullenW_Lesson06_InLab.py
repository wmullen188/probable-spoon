#!/usr/bin/env python

# FILE: 2252_MullenW_Lesson0X_InLab.py
# NAME: State Quiz
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/19/2023
# PURPOSE: A program used to quiz users on the state abbreviations

"""Write a program that creates a dictionary containing the U.S. states as keys and their abbreviations as values.
The program should then randomly quiz the user by displaying the abbreviation and asking the user to enter that
state's name. The program should keep a count of the number of correct and incorrect responses, as well as which
abbreviation the user missed.
"""

import random


# Script main body
def create_dictionary():
    state_dict = dict()
    with open('StateAbbreviations.txt') as abbr_file:
        abbr_list = abbr_file.readlines()
        for single_state in abbr_list:
            state_name = single_state.strip()[:-4]
            state_abbr = single_state.strip()[-2:]
            state_dict[state_name] = state_abbr

    return state_dict


def random_pick(name_list):
    index_picked = random.randint(0, 49)
    state_name = name_list[index_picked]
    return state_name


def create_name_list():
    name_list = []
    with open('StateAbbreviations.txt') as abbr_file:
        abbr_list = abbr_file.readlines()
        for single_state in abbr_list:
            state_name = single_state.strip()[:-4]
            name_list.append(state_name)

    return name_list


# main func
def main():
    line_break = "#" * 60
    centering_tab = '\t' * 4
    # print out more description for use:
    print(f'{line_break}\n')
    print(f'{centering_tab}State Abbreviations Quiz!')
    print(f'\n{line_break}\n')

    state_dict = create_dictionary()
    name_list = create_name_list()

    correct = 0
    missed = 0
    missed_list = []
    for num in range(5):
        state_name = random_pick(name_list)
        state_abbr = state_dict[state_name]
        user_input = input(f"What is the state associated with this abbreviation?\t{state_abbr}\t")
        answer = user_input.strip().capitalize()
        if answer in state_dict:
            correct += 1
            print("Correct!\n")
        else:
            missed += 1
            missed_list.append(state_abbr)
            print("Incorrect!\n")

    print(f"You had {correct} correct answers.")
    if correct == 5:
        print("Great job! You got all of them correct!")
    if missed > 0:
        print(f"You missed {missed} abbreviations:")
        for num in range(missed):
            print(f"\t{num + 1}. {missed_list[num]}")

    print(f'\n{line_break}')
    # Keep shell window/script open:
    print(input('\n\nHit Enter to Close\n'))


# main line logic
if __name__ == '__main__':
    main()
