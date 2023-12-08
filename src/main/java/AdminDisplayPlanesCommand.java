import PlaneTypes.CargoPlane;
import PlaneTypes.PassengerPlane;
import PlaneTypes.Plane;
import PlaneTypes.PrivatePlane;

import java.util.List;
import java.util.Scanner;

public class AdminDisplayPlanesCommand implements Command {

    private final List<Plane> planes;
    private final Scanner scanner;

    public AdminDisplayPlanesCommand(List<Plane> planes, Scanner scanner) {
        this.planes = planes;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        FileAppender.appendToFile("Виконується команда виведення списку літаків.");

        System.out.println("Список літаків якого типу ви бажаєте побачити?\n"+
                "1) Пасажирські літаки\n"+
                "2) Вантажні літаки\n"+
                "3) Приватні літаки\n"+
                "4) Усі літаки\n"+
                "Else) Повернутись до попереднього вибору\n");

        int planeType = scanner.nextInt();
        switch (planeType) {
            case 1:
                displayPlanesOfType(PassengerPlane.class);
                FileAppender.appendToFile("Виведення усіх пасажирських літаків");
                break;
            case 2:
                displayPlanesOfType(CargoPlane.class);
                FileAppender.appendToFile("Виведення усіх вантажних літаків");
                break;
            case 3:
                displayPlanesOfType(PrivatePlane.class);
                FileAppender.appendToFile("Виведення усіх приватних літаків");
                break;
            case 4:
                FileAppender.appendToFile("Виведення усіх типів літаків.");
                System.out.println("\nПасажирські літаки:");
                displayPlanesOfType(PassengerPlane.class);
                System.out.println(" ");
                System.out.println("\nВантажні літаки");
                displayPlanesOfType(CargoPlane.class);
                System.out.println(" ");
                break;
            default:
                break;
        }
    }

    @Override
    public String getDescription() {
        return "Вивести список літаків";
    }

    private void displayPlanesOfType(Class<? extends Plane> planeClass) {
        FileAppender.appendToFile("Виведення списку літаків типу " + planeClass.getSimpleName());

        for (Plane plane : planes) {
            if (planeClass.isInstance(plane)) {
                if (plane instanceof PrivatePlane privatePlane) {
                    privatePlane.displayPrivatePlaneInfo();
                } else if (plane instanceof CargoPlane) {
                    ((CargoPlane) plane).displayCargoPlaneInfo();
                } else {
                    ((PassengerPlane) plane).displayPassengerPlaneInfo();
                }
            }
        }
    }
}
