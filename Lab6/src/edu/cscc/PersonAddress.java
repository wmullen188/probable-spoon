package edu.cscc;

public class PersonAddress extends Address {
    private String personName;

    // Constructor

    public PersonAddress(String streetAddress, String city, String state, String zip,
                         String personName) {
        super(streetAddress, city, state, zip);
        this.personName = personName;
    }

    // Getters

    public String getPersonName() {
        return personName;
    }

    // Setters

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    // Other methods

    /**
     * Prints a formatted version of the full address ready for postage labeling
     */
    @Override
    public void printLabel() {
        System.out.println(personName + "\n" + super.toString());
    }
}
