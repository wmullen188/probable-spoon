#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson03_GrLab.py
# NAME:
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/19/2023
# PURPOSE:


""" Write a program which simulates rolling dice. It should:
Display the random number rolled
Ask the user if they want to roll again. If they don't want to roll again, the program should end.
If they do want to roll again, the new number should display.
At a minimum, the die should have 6 sides, but if you want to use a d12 or d20, that is fine too.
"""

import random


def roll_dice():
    choice = "y"
    while choice.lower() == "y":
        dice = []
        total_dice = int(input("How many dice would you like to roll?\t"))
        for roll in range(total_dice):
            d6 = random.randint(1, 6)
            dice.append(d6)

        print("You rolled:")
        for die in dice:
            print(die)

        choice = input("\nWould you like to roll again? [y/n]\t")


""" Write a program which gives an easy mathematics quiz.
The program should display two random numbers which are to be added together, like this:

117
+ 213
-----

The program should ask the user to enter their answer. If the answer is correct, the user should be congratulated.
If the answer is wrong, the right answer should be displayed and the user should be scolded. 
Don't forget to:
    Generate random numbers
    Ask the user if they want to be tested again.
        If they don't want another math problem, the program should end.
        If they do want to try again, the new problem should display.
"""


def math_quiz():
    choice = input("Would you like to take a short math quiz? [y/n]\t")
    while choice.lower() == "y":
        number1 = random.randint(0, 1000)
        number2 = random.randint(0, 1000)
        print(number1)
        print("+", number2)
        print("------")
        correct = number1 + number2
        answer = int(input("What is the sum?\t"))
        if answer == correct:
            print("Correct! Great job!")
        else:
            print(f"Wrong! It is {correct}.\nTry harder next time.")
        choice = input("Would you like to try again? [y/n]\t")

    print("\nGoodbye!")


def main():
    roll_dice()
    math_quiz()


if __name__ == "__main__":
    main()

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
