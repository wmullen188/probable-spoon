package edu.cscc;

public class Main {

    public static void main(String[] args) {
        Address[] addressList = new Address[6];

        // 3 PersonAddress objects
        PersonAddress saul = new PersonAddress("1200 N. Fourth St.",
                "Worthington", "OH", "43217", "Saul Goodman");
        addressList[0] = saul;
        PersonAddress mike = new PersonAddress("207 Main St.",
                "Reynoldsburg", "OH", "43211", "Mike Ehrmentraut");
        addressList[1] = mike;
        PersonAddress gus = new PersonAddress( "2091 Elm St.",
                "Pickerington", "OH", "43191", "Gustavo Fring");
        addressList[2] = gus;

        // 3 BusinessAddress objects
        BusinessAddress cscc = new BusinessAddress("550 East Spring St.", "Columbus", "OH", "43215",
                "Columbus State", "Eibling 302B");
        addressList[3] = cscc;
        BusinessAddress aep = new BusinessAddress(null, "Columbus", "OH", "43201",
                "AEP", "P.O. Box 2075");
        addressList[4] = aep;
        BusinessAddress billsCoffee = new BusinessAddress("2079 N. Main St.", "Columbus", "OH", "43227",
                "Bill's Builds", null);
        addressList[5] = billsCoffee;

        // Loop to print all the addresses in addressList
        for (Address address : addressList) {
            address.printLabel();
            System.out.println("====================");
        }
    }
}
