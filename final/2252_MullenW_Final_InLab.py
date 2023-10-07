#!/usr/bin/env python

# FILE: 2252_MullenW_Final_InLab.py
# NAME: Trivia Time
# AUTHOR(s): William Mullen
# DATE: month/day/year  05/10/2023
# PURPOSE: Asks the user 5 trivia questions and displays the results of the quiz to the user

"""This is for the description of the program
"""


# Script main body
def display_question(index, questions):
    print(f'\nQ{index + 1}.', end='\t')
    print(f'{questions[index * 5]}\n')

    correct = ""
    counter = 0
    # the starting and stopping positions of each set of answers based on formatting of questions.txt
    start_pos = (index * 5) + 1
    stop_pos = (index + 1) * 5
    for position in range(start_pos, stop_pos):
        choice_str = 'ABCD'
        answer = questions[position]
        # correct answer marked with an asterisk at the start of the string
        if not answer.startswith('*'):
            print(f'\t{choice_str[counter]}.\t{answer}')
        else:
            # slice off the asterisk before printing to console
            answer = answer[1:]
            # assign to variable for returning after function runs
            correct = choice_str[counter].lower()
            print(f'\t{choice_str[counter]}.\t{answer}')

        counter += 1

    return correct


def check_guess(answer):
    user_input = input('\nWhat is your answer? [A/B/C/D]\t\t')
    guess = user_input[0].lower()
    if guess == answer:
        return True
    else:
        return False


# main func
def main():
    line_break = "#" * 60
    centering_tab = '\t' * 4
    # print out more description for use:
    print(f'{line_break}\n')
    print(f'{centering_tab}***** TRIVIA TIME!!!! *****')
    print(f'\n{line_break}\n')

    # make sure that the file exists and is read in properly before running rest of the program
    questions = []
    try:
        with open('questions.txt') as questions_file:
            for line in questions_file:
                questions.append(line.strip())
    except FileNotFoundError:
        print('questions.txt cannot be found.\nThe file must be in the same folder.')
        print('Exiting program...')
        confirmed = False
    else:
        confirmed = True

    while confirmed:
        score = 0
        # use counter (num) for numbering questions, etc., in display_question function
        total_questions = int(len(questions) / 5)
        for num in range(total_questions):
            # display question returns correct answer letter in lower case (abcd)
            answer = display_question(num, questions)
            # take_guess function returns True or False based on whether answered correctly
            correct = check_guess(answer)

            if correct:
                score += 1
                print('Correct!')
            else:
                print('Incorrect!')
            print(f'Your score is:\t\t{score}')

        print(f'\nTotal incorrect =\t\t{total_questions - score}')
        print(f'FINAL SCORE =\t\t\t{score}')

        replay_input = input('\nWould you like to play again? [y/n]\t\t')
        if not replay_input[0].lower() == 'y':
            confirmed = False
        else:
            confirmed = True

    print(f'\n{line_break}')
    # Keep shell window/script open:
    print(input('\nHit Enter to Close\t'))


# main line logic
if __name__ == '__main__':
    main()
