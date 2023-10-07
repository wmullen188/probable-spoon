#!/usr/bin/env python

# FILE:2252_MullenW_Lesson01_InLab.py
# NAME:Short name of script
# AUTHOR(s): William Mullen
# DATE: 01/19/2023
# PURPOSE: Gives the user a recipe for brownies after prompting
# for the number of brownies that are to be baked

# variables for measurements
cups = 'cups'
eggs = 'eggs'
tsps = 'teaspoons'
cup = 'cup'
tsp = 'teaspoon'
# egg_singular = 'egg'
# commented out the egg_singular parts of the singular func because it will never be used as the script is written now
# would need the ability to do non-int numbers, which doesn't really make any sense

measurements = [cups, eggs, tsps, cups, cups, cups, tsps, tsps]

lineBreak = '#' * 60


# Script main body
# function to get a base unit of measurement for a single brownie
def single_brownie():
    # variables for recipe for 9 brownies
    butter = 0.5
    egg = 2
    vanilla = 1
    sugar = 1
    flour = 0.5
    cocoa_powder = 0.5
    baking_powder = 0.25
    salt = 0.25
    brownies = 9

    ingredients_nine = [butter, egg, vanilla, sugar, flour, cocoa_powder, baking_powder, salt]
    ingredients_single = []

    for ingredient in ingredients_nine:
        ingredient = float(ingredient) / brownies
        ingredients_single.append(ingredient)

    return ingredients_single


# multiplication for final output
def totals(prompt_input, ingredients_single):
    recipe_totals = []
    for ingredient in ingredients_single:
        total_ingredient = ingredient * int(prompt_input)
        recipe_totals.append(total_ingredient)

    return recipe_totals


# func for making measurement units into singular forms when unit == 1.00
def singular(recipe_list):
    i = 0
    for num in recipe_list:
        if num == 1.00:
            if measurements[i] == cups:
                measurements[i] = cup
            elif measurements[i] == tsps:
                measurements[i] = tsp
            # elif measurements[i] == eggs:
            # measurements[i] = egg_singular

        i += 1


# makes the ingredients from floats, with 2 decimals, to strings and adds the measurement units
def add_units(recipe_list):
    recipe_str = []
    i = 0
    for ingredient in recipe_list:
        item = f"{ingredient:.2f} {measurements[i]}"
        recipe_str.append(item)
        i += 1

    return recipe_str


# main func
def main():
    # make the list of ingredients for a single brownie to multiply by
    ingredients_single = single_brownie()

    # get the number that the user wants for multiplication
    brownies_total = input("Please input the number of brownies you want to make: ")

    # multiplication for final output, (num brownies,
    recipe_list = totals(brownies_total, ingredients_single)

    # change anything that may need singular forms
    singular(recipe_list)

    # creating strings for final output
    recipe_str = add_units(recipe_list)

    print(f"\nThe recipe for {brownies_total} brownies would be:")
    for ingredient in recipe_str:
        print(ingredient)


print(f"{lineBreak}\n")
print("Welcome to Brownie Recipe Script")
print(f"\n{lineBreak}\n")

# main line logic
if __name__ == '__main__':
    main()

print("\nThe Brownie Recipe Script has finished.\n")
print(lineBreak)

# Keep shell window/script open:
print(input('\n\nHit Enter to Close\n'))
