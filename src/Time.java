import javafx.util.Pair;

import java.util.Objects;

public class Time implements Comparable<Time>{

    private int hours;
    private int minutes;

    public Time(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours == time.hours &&
                minutes == time.minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public int hashCode() {

        return Objects.hash(hours, minutes);
    }

    @Override
    public int compareTo(Time o) {
        if (this.hours < o.hours)
            return -1;
        else if (this.hours > o.hours)
            return 1;
        else {
            if (this.minutes < o.minutes)
                return -1;
            else if (this.minutes > o.minutes)
                return 1;
        }
        return 0;
    }
}
