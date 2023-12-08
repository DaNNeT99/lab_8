import PlaneTypes.Plane;
import PlaneTypes.PassengerPlane;
import PlaneTypes.CargoPlane;
import PlaneTypes.PrivatePlane;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class AdminDisplayPlanesCommandTest {

    @Test
    public void testDisplayPlanesOfType() {
        // Підготовка тестових даних (список літаків)
        List<Plane> planes = new ArrayList<>();
        planes.add(new PassengerPlane("Гестія", 23000, 15, 200, 2000, "Available"));
        planes.add(new CargoPlane("Ерида", 2500,25, 150, 400, "underMaintanance"));
        planes.add(new PrivatePlane("Тефон", 300, 30, 20, 800, "Available", 2));
        planes.add(new PassengerPlane("Аврора", 28000, 40,  220, 2200, "Available"));
        planes.add(new CargoPlane("Апометей", 3500, 25, 180, 450, "underMaintenance"));
        planes.add(new PrivatePlane("Меркурій", 350, 20, 22, 900, "underMaintanance", 2));
        planes.add(new PassengerPlane("Ікар", 25000, 15, 210, 2100, "Discalled"));
        planes.add(new CargoPlane("Сатурн", 3200, 18, 170, 430, "Available"));
        planes.add(new PrivatePlane("Венера", 380, 40, 24, 950, "Available", 8));

        // Створення об'єкта DisplayPlanesCommand для тестування
        String input = "1\n"; // Симулюємо ввід "1" для пасажирських літаків
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        AdminDisplayPlanesCommand adminDisplayPlanesCommand = new AdminDisplayPlanesCommand(planes, scanner);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Збереження початкового потоку виводу

        System.setOut(new PrintStream(outputStream));

        adminDisplayPlanesCommand.execute();

        System.setOut(originalOut);

        String consoleOutput = outputStream.toString();

        // Створення очікуваного результату (у цьому випадку, очікуваний вивід відображення пасажирських літаків)
        String expectedOutput = "Список літаків якого типу ви бажаєте побачити?\n" +
                "1) Пасажирські літаки\n" +
                "2) Вантажні літаки\n" +
                "3) Приватні літаки\n" +
                "4) Усі літаки\n" +
                "Else) Повернутись до попереднього вибору\n"+"\n"+"Пасажирський літак: Гестія\n" +
                "Внутрішній об'єм баку: 23000 літрів\n" +
                "Швидкість споживання пального: 15 літрів на кілометр\n" +
                "Максимальна кількість пасажирів: 200 людей\n" +
                "Максимальна довжина польоту: 2000 км\n" +
                "Доступність: Available\n" +
                "\n" +
                "Особистий літак: Тефон\n" +
                "Внутрішній об'єм баку: 300 літрів\n" +
                "Швидкість споживання пального: 30 літрів на кілометр\n" +
                "Максимальна кількість пасажирів: 20 людей\n" +
                "Максимальна довжина польоту: 800 км\n" +
                "Доступність: Available\n" +
                "\n" +
                "Пасажирський літак: Аврора\n" +
                "Внутрішній об'єм баку: 28000 літрів\n" +
                "Швидкість споживання пального: 40 літрів на кілометр\n" +
                "Максимальна кількість пасажирів: 220 людей\n" +
                "Максимальна довжина польоту: 2200 км\n" +
                "Доступність: Available\n" +
                "\n" +
                "Особистий літак: Меркурій\n" +
                "Внутрішній об'єм баку: 350 літрів\n" +
                "Швидкість споживання пального: 20 літрів на кілометр\n" +
                "Максимальна кількість пасажирів: 22 людей\n" +
                "Максимальна довжина польоту: 900 км\n" +
                "Доступність: underMaintanance\n" +
                "\n" +
                "Пасажирський літак: Ікар\n" +
                "Внутрішній об'єм баку: 25000 літрів\n" +
                "Швидкість споживання пального: 15 літрів на кілометр\n" +
                "Максимальна кількість пасажирів: 210 людей\n" +
                "Максимальна довжина польоту: 2100 км\n" +
                "Доступність: Discalled\n" +
                "\n" +
                "Особистий літак: Венера\n" +
                "Внутрішній об'єм баку: 380 літрів\n" +
                "Швидкість споживання пального: 40 літрів на кілометр\n" +
                "Максимальна кількість пасажирів: 24 людей\n" +
                "Максимальна довжина польоту: 950 км\n" +
                "Доступність: Available\n";


        // Вручну порівнюємо рядки
        if (consoleOutput.equals(expectedOutput)) {
            System.out.println("Тест успішний");
        } else {
            System.out.println("Тест не пройшов");
        }
    }
}
