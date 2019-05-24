import java.util.Objects;

public class Route implements Comparable<Route>{

    private static final int MINUTES_IN_HOUR = 60;

    private Time departureTime;
    private Time arrivalTime;

    Route(int departureHours, int departureMinutes, int arrivalHours, int arrivalMinutes){
        departureTime = new Time(departureHours, departureMinutes);
        arrivalTime = new Time(arrivalHours, arrivalMinutes);
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public boolean isLongerThanAnHour(){
        if (departureTime.getHours() != arrivalTime.getHours()) {
            if (arrivalTime.getHours() - departureTime.getHours() > 1)
                return true;
            else {
                if (MINUTES_IN_HOUR - departureTime.getMinutes() + arrivalTime.getMinutes() > MINUTES_IN_HOUR)
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(getDepartureTime(), route.getDepartureTime()) &&
                Objects.equals(getArrivalTime(), route.getArrivalTime());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDepartureTime(), getArrivalTime());
    }

    @Override
    public int compareTo(Route o) {              // > 0 - better
        if (this.departureTime.equals(o.departureTime) && this.arrivalTime.compareTo(o.arrivalTime) < 0)
            return 1;
        if (this.departureTime.compareTo(o.departureTime) > 0 && this.arrivalTime.equals(o.arrivalTime))
            return 1;
        if (this.departureTime.compareTo(o.departureTime) > 0 && this.arrivalTime.compareTo(o.arrivalTime) < 0)
            return 1;
        return -1;
    }
}
