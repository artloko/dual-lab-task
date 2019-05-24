import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Main {

    private static final String GROTTY = "Grotty";

    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            return;
        Scanner scanner = new Scanner(new File(args[0]));
        Writer writer = new FileWriter(new File("output.txt"));

        List<Service> serviceList = new LinkedList<>();

        List<Service> grottyList = new LinkedList<>();
        List<Service> poshList = new LinkedList<>();

        while (scanner.hasNextLine()){
            Service currService = new Service(scanner.nextLine());
            if (!currService.getRoute().isLongerThanAnHour())
                serviceList.add(currService);
        }

        serviceList = modifyList(serviceList);

        for (Service service : serviceList) {
            if (service.getCompany().equals(GROTTY))
                grottyList.add(service);
            else
                poshList.add(service);
        }

        for (Service poshService : poshList)
            for (Service grottyService : grottyList)
                if (poshService.equals(grottyService))
                    grottyList.remove(grottyService);

        poshList.sort(new MyComparator());
        grottyList.sort(new MyComparator());

        for (Service service : poshList)
            writer.write(service.toString() + "\n");

        writer.write("\n");

        for (Service service: grottyList)
            writer.write(service.toString() + "\n");

        writer.close();
        scanner.close();
    }

    private static List<Service> modifyList(List<Service> serviceList){
        List<Service> tempServiceList = new LinkedList<>(serviceList);

        for (Service service : serviceList)
            for (Service innerService : serviceList)
                if (!service.equals(innerService) && isBetter(service, innerService))
                    tempServiceList.remove(innerService);
        return tempServiceList;
    }

    private static boolean isBetter(Service currService, Service comparableService){
        return currService.compareTo(comparableService) > 0;
    }
}
