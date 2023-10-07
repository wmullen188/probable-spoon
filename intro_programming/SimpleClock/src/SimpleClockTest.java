/*
 *   A program that tests the SimpleClock class.  This program instantiates a
 *   new SimpleClock object, sets it to 11:59:00PM and then repeatedly ticks
 *   seconds to show the passage of an hours worth of time.  YOU DO NOT NEED
 *   TO MODIFY THIS CLASS.  Make your modifications to the SimpleClock.java
 *   file instead.
 *
 *
 * @author Jeremy Morris
 * @version 20161212
 *
 */
public class SimpleClockTest {

    public static void main(String[] args) {
        SimpleClock clock = new SimpleClock();
        System.out.println("Clock starts at time: " + clock);
        clock.set(11, 59, 59, false);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 12:00:00AM");
        clock.set(12, 59, 59, true);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 1:00:00AM");
        clock.set(11, 59, 59, true);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 12:00:00PM");
        clock.set(12, 59, 59, false);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 1:00:00PM");
        System.out.println("Clock finally reads: " + clock);
    }

}
