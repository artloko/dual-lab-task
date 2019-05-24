import java.util.Comparator;

public class MyComparator implements Comparator<Service> {

    @Override
    public int compare(Service o1, Service o2) {
        return o1.getRoute().getDepartureTime().compareTo(o2.getRoute().getDepartureTime());
    }
}
