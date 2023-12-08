import PlaneTypes.Plane;
import PlaneTypes.PassengerPlane;
import PlaneTypes.CargoPlane;
import PlaneTypes.PrivatePlane;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SavePlanesToFileCommandTest {

    @Test
    public void testSavePlanesToFile() {
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

        String filename = "test_planes.txt";

        // Створення об'єкта SavePlanesToFileCommand для тестування
        SavePlanesToFileCommand savePlanesToFileCommand = new SavePlanesToFileCommand(filename, planes);

        // Виклик методу execute для запису в файл
        savePlanesToFileCommand.execute();

        // Читання з файлу для перевірки вмісту
        List<String> linesFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Перевірка, чи дані у файлі відповідають очікуваному формату
        List<String> expectedLines = new ArrayList<>();
        for (Plane plane : planes) {
            expectedLines.add(plane.toString());
        }

        assertEquals(expectedLines, linesFromFile);
    }
}
