#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson0X_InLab.py
# NAME:
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/19/2023
# PURPOSE:

import random


# Script main body
def random_pick():
    num = random.randint(1, 3)
    return num


def determine_pick(pick):
    if pick == 1:
        return "rock"
    elif pick == 2:
        return "paper"
    else:
        return "scissors"


def determine_winner(user_pick, comp_pick):
    if user_pick == comp_pick:
        return "tie"
    elif user_pick == "rock":
        if comp_pick == "scissors":
            return 1
        elif comp_pick == "paper":
            return 0
    elif user_pick == "paper":
        if comp_pick == "rock":
            return 1
        elif comp_pick == "scissors":
            return 0
    elif user_pick == "scissors":
        if comp_pick == "paper":
            return 1
        elif comp_pick == "rock":
            return 0


# main func
def main():
    line_break = '#' * 60
    centering_tab = '\t' * 4
    # print out more description for use:
    print(f'{line_break}\n')
    print(f'{centering_tab}Rock Paper Scissors Game!')
    print(f'\n{line_break}\n')

    username = input("What is your name?\t")

    comp_score = 0
    user_score = 0
    tie = None
    user_input = input("Would you like to play Rock Paper Scissors? [y/n]\t")
    confirm = user_input[0].lower()
    while confirm == "y":
        while tie is None or tie:
            user_num = int(input("What would you like to throw? [R/P/S = 1/2/3]\t"))
            comp_num = random_pick()
            user_pick = determine_pick(user_num)
            comp_pick = determine_pick(comp_num)
            print(f"The computer picked:\t{comp_pick}")

            winner = determine_winner(user_pick, comp_pick)
            if winner == "tie":
                tie = True
                print("There was a tie, throw again until a winner is determined")
                continue
            elif winner == 0:
                comp_score += 1
                tie = False
            elif winner == 1:
                user_score += 1
                tie = False

            print(f"\n{username}'s total score is:\t{user_score}")
            print(f"The computer's total score is:\t{comp_score}")

        user_input = input("Would you like to play Rock Paper Scissors again? [y/n]\t")
        confirm = user_input[0].lower()

    print(f'\n{line_break}')

    input("\n\nHit Enter to close\n")


# main line logic
if __name__ == '__main__':
    main()
