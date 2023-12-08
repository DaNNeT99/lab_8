import PlaneTypes.Plane;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class AdminFilterPlanesByFuelCommand implements Command {

    private final List<Plane> planes;
    private final Scanner scanner;

    public AdminFilterPlanesByFuelCommand(List<Plane> planes, Scanner scanner) {
        this.planes = planes;
        this.scanner = scanner;

    }



    @Override
    public void execute() {
        FileAppender.appendToFile("Виконується команда фільтрації літаків за споживанням пального.");

        System.out.println("Введіть мінімальне споживання пального (у літрах/км):");
        double minFuelConsumption = scanner.nextDouble();
        System.out.println("Введіть максимальне споживання пального (у літрах/км):");
        double maxFuelConsumption = scanner.nextDouble();

        List<Plane> filteredPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane.getFuelConsumption() >= minFuelConsumption && plane.getFuelConsumption() <= maxFuelConsumption) {
                filteredPlanes.add(plane);
            }
        }

        if (!filteredPlanes.isEmpty()) {
            FileAppender.appendToFile("Знайдено літаки зі споживанням пального у вказаному діапазоні.");
            System.out.println("Літаки зі споживанням пального у вказаному діапазоні:");
            for (Plane filteredPlane : filteredPlanes) {
                System.out.println(filteredPlane);
            }
        } else {
            FileAppender.appendToFile("Літаків у вказаному діапазоні не знайдено.");
            System.out.println("Літаків у вказаному діапазоні не знайдено.");
        }
    }

    @Override
    public String getDescription() {
        return "Фільтрувати літаки за споживанням пального";
    }
}
