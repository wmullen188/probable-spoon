#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson01_InLab2.py
# NAME: Ticket Cost Calculator
# AUTHOR(s): William Mullen
# DATE: month/day/year  02/2/2023
# PURPOSE: determine the ticket cost by tier for each height as it is entered
# and display both back to the user


# Script main body
def determine_tier(height):
    # guppy is the last possible case, and thus the starting point for the tier if not reassigned
    tier = "Guppy"
    # start at the top tier and work downwards to determine height tier
    if height >= 48:
        tier = "Adventurer"
    elif height >= 42:
        tier = "Explorer"
    elif height >= 36:
        tier = "Apprentice"
    elif height >= 30:
        tier = "Pollywog"

    return tier


def determine_cost(tier):
    # cost for the guppy tier is free, therefore cost = 0 in that case
    cost = 0
    # start at guppy and work way from top to bottom otherwise
    if tier == "Guppy":
        return cost
    elif tier == "Adventurer":
        cost = 10
    elif tier == "Explorer":
        cost = 8
    elif tier == "Apprentice":
        cost = 5
    elif tier == "Pollywog":
        cost = 2

    return cost


# main func
def main():
    height = int(input("What is the height of the guest in inches?:\t"))

    tier = determine_tier(height)

    cost = determine_cost(tier)

    print(f'\nYour tier is {tier} and your cost is ${cost}.\n')


line_break = "#" * 60
centering_tab = '\t' * 4
# print out more description for use:
print(f'{line_break}\n')
print(f'{centering_tab}Ticket Cost Calculator')
print(f'\n{line_break}\n')

# main line logic
if __name__ == '__main__':
    main()


print(f'\n{line_break}')

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
