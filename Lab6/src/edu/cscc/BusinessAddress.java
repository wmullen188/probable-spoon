package edu.cscc;

public class BusinessAddress extends Address {
    private String businessName;
    private String address2;

    // Constructor

    public BusinessAddress(String streetAddress, String city, String state, String zip,
                           String businessName, String address2) {
        super(streetAddress, city, state, zip);
        this.businessName = businessName;
        this.address2 = address2;
    }

    // Getters

    public String getBusinessName() {
        return businessName;
    }

    public String getAddress2() { return address2; }

    // Setters

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    // Other methods

    /**
     * Returns a formatted string representation of the object
     *
     * @return String representation of the object formatted for postage
     */
    @Override
    public String toString() {
        // Create a StringBuilder to append strings
        StringBuilder sb = new StringBuilder();

        // Check if either address2 and streetAddress are either null or empty
        if ((address2 == null || address2.length() == 0) &&
                (getStreetAddress() != null && getStreetAddress().length() != 0)) {
            sb.append(businessName);
            sb.append("\n");
            sb.append(getStreetAddress());
            sb.append("\n");
            sb.append(getCity());
            sb.append(", ");
            sb.append(getState());
            sb.append("  ");
            sb.append(getZip());
            sb.append("\n");
        } else if ((address2 != null && address2.length() != 0) &&
                (getStreetAddress() == null || getStreetAddress().length() == 0))  {
            sb.append(businessName);
            sb.append("\n");
            sb.append(address2);
            sb.append("\n");
            sb.append(getCity());
            sb.append(", ");
            sb.append(getState());
            sb.append("  ");
            sb.append(getZip());
            sb.append("\n");
        } else if ((address2 != null && address2.length() != 0) &&
                (getStreetAddress() != null && getStreetAddress().length() != 0)) {
            sb.append(businessName);
            sb.append("\n");
            sb.append(address2);
            sb.append("\n");
            sb.append(getStreetAddress());
            sb.append("\n");
            sb.append(getCity());
            sb.append(", ");
            sb.append(getState());
            sb.append("  ");
            sb.append(getZip());
            sb.append("\n");
        } else {
            sb.append(businessName);
            sb.append("\n");
            sb.append(getCity());
            sb.append(", ");
            sb.append(getState());
            sb.append("  ");
            sb.append(getZip());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Prints a formatted version of the full address ready for postage labeling
     */
    @Override
    public void printLabel() {
        System.out.println(toString());
    }
}
