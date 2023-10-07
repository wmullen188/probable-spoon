package edu.cscc;

/**
 * This is a simple class that simulates a water holding tank.
 *
 * @author Bill Mullen
 * @version 1-31-2020
 */
public class HoldingTank {

    private int current;
    private int maxCapacity;

    // Constructor

    /**
     * Constructor method for instantiating a HoldingTank object
     *
     * @param current     current volume of water (measured in gallons) in holding tank
     * @param maxCapacity maximum capacity of the holding tank
     */
    public HoldingTank(int current, int maxCapacity) {
        this.current = current;
        this.maxCapacity = maxCapacity;
        if (current > maxCapacity) {
            this.current = maxCapacity;
        }
    }

    // Getters

    /**
     * Returns the current volume of water in the holding tank
     *
     * @return the current volume of water in the tank as an int
     */
    public int getCurrent() {
        return current;
    }

    /**
     * Returns the maximum capacity of the holding tank
     *
     * @return the maximum capacity of the holding tank as an int
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Other methods

    /**
     * Adds a volume of water to the holding tank, if it exceeds the maximum capacity the current
     * volume is set to the maximum capacity.
     *
     * @param volume the volume of water to be added to the tank
     */
    public void add(int volume) {
        // Add volume gallons to the tank
        current = current + volume;
        // If resulting current volume exceeds maxCapacity, it will be set to maxCapacity
        if (current > maxCapacity) {
            current = maxCapacity;
        }
    }

    /**
     * Try to remove volume gallons from the tank. If resulting current volume is less than zero,
     * it is set to zero.
     *
     * @param volume the volume of water to be removed from the tank
     */
    public void drain(int volume) {
        // Remove volume gallons from the tank
        current = current - volume;
        // If resulting current volume is less than 0, set it to 0
        if (current < 0) {
            current = 0;
        }
    }

    /**
     * Prints the current volume of the tank (in gallons).
     */
    public void print() {
        System.out.println("The tank volume is " + current + " gallons.");
    }
}
