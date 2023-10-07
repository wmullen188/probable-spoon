#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson03_GrLab.py
# NAME:
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/19/2023
# PURPOSE:

""" Talk like a Pirate! In this activity you are to create an English to Pirate Translator.
Users should input a phrase and your program should translate it into pirate speak.
"""

""" Replaces the specified words in the message that is being translated.
Words are ordered from highest frequency of use to lowest for efficiency.
"""


def replace_words(message, message_split):
    i = 0
    while i < len(message_split):
        if "the" in message:
            found_index = message.find("the ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("the", "th'", 1)
            else:
                found_index = message.find("there ")
                if found_index != -1:
                    message = message[:found_index] + message[found_index:].replace("there", "thar", 1)
        elif "you" in message:
            found_index = message.find("you ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("you", "ye", 1)
        elif "is" in message:
            found_index = message.find("is ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("is", "be", 1)
        elif "my" in message:
            found_index = message.find("my ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("my", "me", 1)
        elif "ing" in message:
            found_index = message.find("ing ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("ing", "in'", 1)
        elif "where" in message:
            found_index = message.find("where ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("where", "whar", 1)
        elif "sir" in message:
            found_index = message.find("sir ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("sir", "matey", 1)
        elif "hello" in message:
            found_index = message.find("hello ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("hello", "ahoy", 1)
        elif "hi" in message:
            found_index = message.find("hi ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("hi", "yo-ho-ho", 1)
        elif "friend" in message:
            found_index = message.find("friend ")
            if found_index != -1:
                message = message[:found_index] + message[found_index:].replace("friend", "bucko", 1)

        i += 1

    return message


def find_indexes(search_str, message):
    indexes = []
    begin = None
    while True:
        try:
            index = message.find(search_str, begin)
        except IndexError:
            break
        except Exception as exc:
            print(f"{exc} was thrown while running, exiting loop")
            break
        else:
            if index == -1:
                break
            indexes.append(index)
            begin = index + 1

    return indexes


# main func
def main():
    line_break = "#" * 60
    centering_tab = '\t' * 5
    # print out more description for use:
    print(f'{line_break}\n')
    print(f'{centering_tab}Pirate Translator')
    print(f'\n{line_break}\n')

    # message_user variable needs to be separated to restrict possible accidental manipulation
    message_user = input("What is your message for translation?\t")

    # create message with all lower case for easy comparisons, split for loop iterations
    message_lower = message_user.lower()
    message_words = message_lower.split()

    # take out punctuation before replacement for sake of comparisons
    # determine all capitalization and find punctuation, save the index values for all of both
    capitalization_indexes = []

    period_indexes = []
    comma_indexes = []
    if "." in message_user:
        period_indexes = find_indexes(".", message_user)

    if "," in message_user:
        comma_indexes = find_indexes(",", message_user)

    message_replaced = replace_words(message_lower, message_words)
    print(message_replaced)

    #

    print(f'\n{line_break}')
    # Keep shell window/script open:
    print(input('\n\nHit Enter to Close\n'))


# main line logic
if __name__ == '__main__':
    main()
