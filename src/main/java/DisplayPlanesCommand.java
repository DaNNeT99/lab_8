import PlaneTypes.CargoPlane;
import PlaneTypes.PassengerPlane;
import PlaneTypes.Plane;
import PlaneTypes.PrivatePlane;

import java.util.List;
import java.util.Scanner;

public class DisplayPlanesCommand implements Command {

    private final List<Plane> planes;
    private final Scanner scanner;

    public DisplayPlanesCommand(List<Plane> planes, Scanner scanner) {
        this.planes = planes;
        this.scanner = scanner;

    }


    @Override
    public void execute() {
        FileAppender.appendToFile("Виконується команда виведення списку літаків.");

        System.out.println("Список літаків якого типу ви бажаєте побачити?\n" +
                "1) Пасажирські літаки\n" +
                "2) Вантажні літаки\n" +
                "3) Приватні літаки\n" +
                "4) Усі літаки\n" +
                "Else) Повернутись до попереднього вибору\n");

        int planeType = scanner.nextInt();
        int privateCode;
        switch (planeType) {
            case 1:
                displayPlanesOfType(PassengerPlane.class, 0);
                FileAppender.appendToFile("Виведення доступних пасажирських літаків");
                break;
            case 2:
                displayPlanesOfType(CargoPlane.class, 0);
                FileAppender.appendToFile("Виведення доступних вантажних літаків");
                break;
            case 3:
                System.out.println("Введіть свій особистий код");
                privateCode = scanner.nextInt();
                displayPlanesOfType(PrivatePlane.class, privateCode);
                FileAppender.appendToFile("Виведення доступних особистих літаків");
                break;
            case 4:
                FileAppender.appendToFile("Виведення усіх типів літаків.");
                System.out.println("Пасажирські літаки:");
                displayPlanesOfType(PassengerPlane.class, 0);
                System.out.println(" ");
                System.out.println("Вантажні літаки");
                displayPlanesOfType(CargoPlane.class, 0);
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

    private void displayPlanesOfType(Class<? extends Plane> planeClass, int code) {
        FileAppender.appendToFile("Виведення списку літаків типу " + planeClass.getSimpleName());

        for (Plane plane : planes) {
            if (planeClass.isInstance(plane)) {
                if (plane.getAvailability().equalsIgnoreCase("Available")) {
                    if (plane instanceof PrivatePlane privatePlane) {
                        if (code == privatePlane.getPersonalCode()) {
                            privatePlane.displayPrivatePlaneInfo();
                        } else {
                            FileAppender.appendToFile("Доступ заборонено");
                            System.out.println();
                            System.out.println("Доступ заборонено");
                            System.out.println();
                        }
                    } else if (plane instanceof CargoPlane) {
                        ((CargoPlane) plane).displayCargoPlaneInfo();
                    } else {
                        ((PassengerPlane) plane).displayPassengerPlaneInfo();
                    }
                }
            }
        }
    }
}
