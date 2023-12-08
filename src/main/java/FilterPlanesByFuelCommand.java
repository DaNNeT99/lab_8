import PlaneTypes.Plane;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class FilterPlanesByFuelCommand implements Command {

    private final List<Plane> planes;
    private final Scanner scanner;

    public FilterPlanesByFuelCommand(List<Plane> planes, Scanner scanner) {
        this.planes = planes;
        this.scanner = scanner;
    }



    @Override
    public void execute() {

        System.out.println("Введіть мінімальне споживання пального (у літрах/км):");
        double minFuelConsumption = scanner.nextDouble();
        System.out.println("Введіть максимальне споживання пального (у літрах/км):");
        double maxFuelConsumption = scanner.nextDouble();

        List<Plane> filteredPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane.getFuelConsumption() >= minFuelConsumption && plane.getFuelConsumption() <= maxFuelConsumption) {
                if (plane.getAvailability().equalsIgnoreCase("Available")) {
                    filteredPlanes.add(plane);
                }
            }
        }

        if (!filteredPlanes.isEmpty()) {
            FileAppender.appendToFile("Знайдено літаки зі споживанням пального у вказаному діапазоні.");
            for (Plane filteredPlane : filteredPlanes) {
                FileAppender.appendToFile(filteredPlane.toString());
            }
        } else {
            FileAppender.appendToFile("Літаків у вказаному діапазоні не знайдено.");
        }
    }

    @Override
    public String getDescription() {
        return "Фільтрувати літаки за споживанням пального";
    }
}
