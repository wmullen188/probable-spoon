
/**
 * SimpleClock.java
 *
 * A class that implements a simple clock.
 *
 * @author Bill Mullen
 * @version 20191203
 *
 */
public class SimpleClock {

	/* -------- Private member variables --------------------- */
	private int hours;
	private int minutes;
	private int seconds;
	private boolean morning;

	/* -------- Constructor --------------------------------- */
	/**
	 * The constructor should set the intial value of the clock to 12:00:00AM.
	 */
	public SimpleClock() {
		this.hours = 12;
		this.minutes = 0;
		this.seconds = 0;
		this.morning = true;
	}

	/* --------- Instance methods ------------------------- */

	/**
	 * Sets the time showing on the clock.
	 *
	 * @param hh      - the hours to display
	 * @param mm      - the minutes to display
	 * @param ss      - the seconds to display
	 * @param morning - true for AM, false for PM
	 */
	public void set(int hh, int mm, int ss, boolean morning) {
		this.hours = hh;
		this.minutes = mm;
		this.seconds = ss;
		this.morning = morning;
	}

	/**
	 * Advances the clock by 1 second. Make sure when implementing this method that
	 * the seconds "roll over" correctly - 11:59:59AM should become 12:00:00PM for
	 * example.
	 */
	public void tick() {
		seconds++;
		if (seconds == 60) {
			seconds = 0;
			minutes++;
			if (minutes == 60) {
				minutes = 0;
				hours++;
				if (hours == 12 && morning == true) {
					morning = false;
				} else if (hours == 12 && morning == false) {
					morning = true;
				} else if (hours == 13) {
					hours = 1;
				}
			}
		}
	}

	/**
	 * Returns a string containing the current time formatted as a digital clock
	 * format. For example, midnight should return the string "12:00:00AM" while one
	 * in the morning would return the string "1:00:00AM" and one in the afternoon
	 * the string "1:00:00PM".
	 *
	 * @return - the current time formatted in AM/PM format
	 */
	@Override
	public String toString() {
		StringBuilder clock = new StringBuilder();
		clock.append(hours + ":");
		if (minutes < 10) {
			clock.append("0" + minutes + ":");
		} else {
			clock.append(minutes + ":");
		}
		if (seconds < 10) {
			clock.append("0" + seconds);
		} else {
			clock.append(seconds);
		}
		if (morning == true) {
			clock.append("AM");
		} else if (morning == false) {
			clock.append("PM");
		}
		return clock.toString();
	}

}
