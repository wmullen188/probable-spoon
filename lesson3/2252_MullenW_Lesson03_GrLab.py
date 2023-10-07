#!/usr/bin/env python  #What is this line for? Watch the SHEBANG video in lesson 01

# FILE: 2252_MullenW_Lesson03_GrLab.py
# NAME:
# AUTHOR(s): William Mullen
# DATE: month/day/year  03/19/2023
# PURPOSE:


# Write a program that Brutus's owner can use to track his distance. It should:
# Allow Brutus's owner to input the speed of his dog
# Allow Brutus's owner to input the hours Brutus was playing fetch
# Loop to display the distance Brutus ran for each hour

time = float(input("How long did Brutus play fetch? (hrs)\t"))
while time < 0:
    print("The time must be a positive number")
    time = int(input("How long did Brutus play fetch? (hrs)\t"))
speed = float(input("How fast did Brutus run? (kmph)\t\t\t"))

line_break = "=" * 50
print(f"\n{line_break}")
print("Hour\tBrutus's Distance")
print(f"{line_break}")

for hour in range(1, int(time + 1)):
    distance = hour * speed
    print(f"{hour:,d}\t\t{distance:.2f} km")


# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
