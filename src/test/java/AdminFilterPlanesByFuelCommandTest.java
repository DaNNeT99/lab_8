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

public class AdminFilterPlanesByFuelCommandTest {

    @Test
    public void testFilterPlanesByFuelCommand() {
        String input = "20\n30\n"; // Симулюємо введення мінімального і максимального споживання пального
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

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

        AdminFilterPlanesByFuelCommand adminFilterPlanesByFuel = new AdminFilterPlanesByFuelCommand(planes, scanner);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outputStream));

        adminFilterPlanesByFuel.execute();

        System.setOut(originalOut);

        String consoleOutput = outputStream.toString();

        String expectedOutput = "Введіть мінімальне споживання пального (у літрах/км):\n" +
                "Введіть максимальне споживання пального (у літрах/км):\n" +
                "Літаки зі споживанням пального у вказаному діапазоні:\n" +
                "PlaneTypes.Plane{name=Ерида, fuelCapacity=2500, fuelConsumption=25, boardCapacity=0, maxFlightLength=400, availability=underMaintanance}\n" +
                "PlaneTypes.Plane{name=Тефон, fuelCapacity=300, fuelConsumption=30, boardCapacity=20, maxFlightLength=800, availability=Available}\n" +
                "PlaneTypes.Plane{name=Апометей, fuelCapacity=3500, fuelConsumption=25, boardCapacity=0, maxFlightLength=450, availability=underMaintenance}\n" +
                "PlaneTypes.Plane{name=Меркурій, fuelCapacity=350, fuelConsumption=20, boardCapacity=22, maxFlightLength=900, availability=underMaintanance}\n";



        assertEquals(expectedOutput, consoleOutput);
    }
}
