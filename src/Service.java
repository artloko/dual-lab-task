import java.util.Objects;
import java.util.StringTokenizer;

public class Service implements Comparable<Service>{

    private String company;

    private Route route;

    public Service(String data){
        StringTokenizer stringTokenizer = new StringTokenizer(data, " :");

        company = stringTokenizer.nextToken();

        String departureHoursString = stringTokenizer.nextToken();
        String departureMinutesString = stringTokenizer.nextToken();

        String arrivalHoursString = stringTokenizer.nextToken();
        String arrivalMinutesString = stringTokenizer.nextToken();

        if (departureHoursString.charAt(0) == '0')
            departureHoursString = departureHoursString.substring(1);
        if (departureMinutesString.charAt(0) == '0')
            departureMinutesString = departureMinutesString.substring(1);

        if (arrivalHoursString.charAt(0) == '0')
            arrivalHoursString = arrivalHoursString.substring(1);
        if (arrivalMinutesString.charAt(0) == '0')
            arrivalMinutesString = arrivalMinutesString.substring(1);

        route = new Route(Integer.parseInt(departureHoursString), Integer.parseInt(departureMinutesString),
                Integer.parseInt(arrivalHoursString), Integer.parseInt(arrivalMinutesString));
    }

    public Route getRoute() {
        return route;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(getRoute(), service.getRoute());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoute());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getCompany() + " ");

        if (route.getDepartureTime().getHours() < 10)
            stringBuilder.append("0");
        stringBuilder.append(route.getDepartureTime().getHours());

        stringBuilder.append(":");

        if (route.getDepartureTime().getMinutes() < 10)
            stringBuilder.append("0");
        stringBuilder.append(route.getDepartureTime().getMinutes());

        stringBuilder.append(" ");

        if (route.getArrivalTime().getHours() < 10)
            stringBuilder.append("0");
        stringBuilder.append(route.getArrivalTime().getHours());

        stringBuilder.append(":");

        if (route.getArrivalTime().getMinutes() < 10)
            stringBuilder.append("0");
        stringBuilder.append(route.getArrivalTime().getMinutes());

        return stringBuilder.toString();
    }


    @Override
    public int compareTo(Service o) {
        return route.compareTo(o.getRoute());
    }
}
