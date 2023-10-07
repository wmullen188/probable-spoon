#!/usr/bin/env python

# FILE: 2252_MullenW_Lesson05_InLab.py
# NAME: De/Coder
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/27/2023
# PURPOSE: Encode and decode messages for the user using a Caesar Cipher

"""This is for the description of the program
"""

# global constant strings containing the entire alphabet, in order, for cipher
ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz"
# use letters for digits, starting with 0, taken from a slice of the alphabet using every other letter from A-S
# ex: A = 0, C = 1, E = 2,...
DIGITS = ALPHABET_UPPER[:20:2]


# Script main body
def sequence_builder(numbers):
    sequence_str = ""
    for number in numbers:
        if not numbers.index(number) == (len(numbers) - 1):
            sequence_str += f"{number}-"
        else:
            sequence_str += f"{number}"
    return sequence_str


def word_builder(letters):
    word_str = ""
    for letter in letters:
        word_str += f"{letter}"

    return word_str


def message_builder(message_list):
    message = ""
    for item in message_list:
        if not message_list.index(item) == (len(message_list) - 1):
            if message_list.index(item) == 0:
                item = item.capitalize()
            message += f"{item} "
        else:
            message += f"{item}"
    return message


def word_encryption(message):
    message_sequences = []
    message_words = message.split()
    for word in message_words:
        # make word lower for comparison with ALPHABET constant
        word_lower = word.lower()
        numbers = []
        for char in word_lower:
            # reset the encrypted character to None value at beginning of each loop
            encrypted_char = None
            if char.isalnum() and not char.isspace():
                if char.isalpha():
                    encrypted_char = ALPHABET_LOWER.index(char)
                elif char.isdigit():
                    # makes digit into its integer form
                    digit_int = int(char)
                    encrypted_char = DIGITS[digit_int]
            else:
                encrypted_char = char

            numbers.append(encrypted_char)

        # reassemble into words and add them to list of words in the message
        encrypted_word = sequence_builder(numbers)
        message_sequences.append(encrypted_word)

    return message_sequences


def sequence_decryption(message):
    message_words = []
    message_sequences = message.split()
    for sequence in message_sequences:
        # split sequence into individual numbers
        numbers = sequence.split("-")
        letters = []
        for num in numbers:
            # reset the decrypted number to None value at beginning of each loop, debugging purposes
            decrypted_num = None
            if num.isalnum() and not num.isspace():
                if num.isnumeric():
                    decrypted_num = ALPHABET_LOWER[int(num)]
                elif num.isalpha():
                    decrypted_num = DIGITS.index(num)
            else:
                decrypted_num = num

            letters.append(decrypted_num)

        # build the word from the decrypted letters
        decrypted_word = word_builder(letters)
        # add the decrypted word to the list of words in the message
        message_words.append(decrypted_word)

    return message_words


# main func
def main():
    line_break = "#" * 60
    centering_tab = '\t' * 5
    # print out more description for use:
    print(f'{line_break}\n')
    print(f'{centering_tab}De/Coder Program')
    print(f'\n{line_break}\n')

    confirm = "y"
    while confirm == "y":
        # ask user whether encryption or decryption, then for message
        # validate choice input, loop until correct input
        user_input = input("Would you like to Encode or Decode a message? [e/d]\t")
        choice = user_input[0].lower()
        while choice != "e" and choice != "d":
            print("\nEnter either E for Encoding or D for Decoding")
            user_input = input("Would you like to Encode or Decode a message? [e/d]\t")
            choice = user_input[0].lower()

        message = input("What is your message?\t")

        # based on choice, de/code the message and output to the console
        status = ""
        output_str = ""
        if choice == "e":
            # code the message's words into list of sequences consisting of numbers/letters and dashes
            coded_sequences = word_encryption(message)
            # build list of coded sequences into full message string
            output_str = message_builder(coded_sequences)
            status = "encoded"
        elif choice == "d":
            # decode the message's sequences into a list of words
            decoded_words = sequence_decryption(message)
            # build list of decoded words into full message string
            output_str = message_builder(decoded_words)
            status = "decoded"
        # output to the console
        print(f"\nYour {status} message is:\n{output_str}")

        user_confirm = input("\nWould you like to use De/Coder again? [y/n]\t")
        confirm = user_confirm[0].lower()

    print(f'\n{line_break}')
    # Keep shell window/script open:
    print(input('\n\nHit Enter to Close\n'))


# mainline logic
if __name__ == '__main__':
    main()
