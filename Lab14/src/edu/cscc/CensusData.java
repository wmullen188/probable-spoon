package edu.cscc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CensusData {
    /**
     * Deserializes the data sets into an array of Strings
     * @param fname the file name for the serialized data
     * @return an array of Strings holding the deserialized data
     * @throws IOException exception thrown if the file is not found
     * @throws ClassNotFoundException exception thrown if the data is not of the correct type
     */
    public static String[] deserialize(String fname) throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fname));
        String[] names = (String[]) objIn.readObject();
        objIn.close();
        return names;
    }
}
