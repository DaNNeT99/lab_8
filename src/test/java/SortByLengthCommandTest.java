import PlaneTypes.Plane;
import PlaneTypes.PassengerPlane;
import PlaneTypes.CargoPlane;
import PlaneTypes.PrivatePlane;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SortByLengthCommandTest {

    @Test
    public void testSortByLength() {
        // Створення списку літаків для тесту
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


        // Створення об'єкта SortByLengthCommand для тестування
        SortByLengthCommand sortByLengthCommand = new SortByLengthCommand(planes);

        // Виклик методу execute для сортування
        sortByLengthCommand.execute();

        // Очікуваний порядок літаків після сортування
        List<String> expectedOrder = new ArrayList<>();
        expectedOrder.add("Аврора");
        expectedOrder.add("Ікар");
        expectedOrder.add("Гестія");
        expectedOrder.add("Венера");
        expectedOrder.add("Меркурій");
        expectedOrder.add("Тефон");
        expectedOrder.add("Апометей");
        expectedOrder.add("Сатурн");
        expectedOrder.add("Ерида");
        // Додавання інших назв літаків у очікуваний порядок...

        // Перевірка, чи відсортований список має очікуваний порядок
        List<String> actualOrder = new ArrayList<>();
        for (Plane plane : planes) {
            actualOrder.add(plane.getName());
        }

        assertEquals(expectedOrder, actualOrder);
    }
}
