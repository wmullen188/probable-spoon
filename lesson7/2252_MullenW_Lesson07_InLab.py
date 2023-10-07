#!/usr/bin/env python

# FILE: 2252_MullenW_Lesson07_InLab.py
# NAME: World Series Winners Search Engine
# AUTHOR(s): William Mullen
# DATE: month/day/year  05/3/2023
# PURPOSE: This program will read in a list of World Series winners and then ask for the user to input a team
# which it will then search for. If found, the program will output the number of wins and years those wins occurred.

"""The attached WorldSeriesWinners.txt file contains the name of the winner of the World Series (duh) and the year
in which they won.  1904 and 1994 did not have World Series played, so "No Winner" is displayed for those years.
Your job is to write a program that lets the user enter the name of a team (or "No Winner") and then display the
number of times the team won and a list of the years in which they won.
"""


# Script main body
def read_winners_file():
    with open("WorldSeriesWinners.txt") as winners_file:
        years = []
        teams = []
        for line in winners_file:
            if line.startswith("1") or line.startswith("2"):
                year = line.strip()
                years.append(year)
            else:
                team_name = line.strip()
                teams.append(team_name.lower())

    return years, teams


def create_winners_dict(years, teams):
    winners_dict = dict()
    i = 0
    while i < len(years):
        winners_dict[years[i]] = teams[i]
        i += 1

    return winners_dict


def find_winner(team, winners_dict, years_won):
    if team in winners_dict.values():
        for key in winners_dict:
            if team in winners_dict[key]:
                years_won.append(key)


# main func
def main():
    line_break = "#" * 60
    centering_tab = '\t' * 4
    # print out more description for use:
    print(f'{line_break}\n')
    print(f'{centering_tab}World Series Winners Search')
    print(f'\n{line_break}\n')

    # make sure that the file exists and is read in properly before running rest of the program
    try:
        years, teams = read_winners_file()
    except FileNotFoundError:
        print("WorldSeriesWinners.txt cannot be found.\nThe file must be in the same folder.")
        print("Exiting program...")
        confirm = False
    else:
        winners_dict = create_winners_dict(years, teams)
        confirm = True

    while confirm:
        user_input = input("What team would you like to search for?: [Ex: Chicago Cubs] \t")
        team = user_input.lower()

        years_won = []
        find_winner(team, winners_dict, years_won)
        win_count = len(years_won)

        if win_count > 0:
            if win_count == 1:
                print(f"\nThe {team.title()} have won the World Series {win_count} time.")
                print("They won in the year:")
                for champ in years_won:
                    print(f"\t{champ}")
            else:
                print(f"\nThe {team.title()} have won the World Series {win_count} times.")
                print("They won in these years:")
                for champ in years_won:
                    print(f"\t{champ}")
        else:
            print(f"\nThe {team.title()} have never won the World Series.")

        replay_input = input("\nWould you like to search for another team? [y/n]\t")
        if not replay_input[0].lower() == "y":
            confirm = False

    print(f'\n{line_break}')
    # Keep shell window/script open:
    print(input('\n\nHit Enter to Close\n'))


# main line logic
if __name__ == '__main__':
    main()
