
import PlaneTypes.Plane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SavePlanesToFileCommand implements Command {
    private final String filename;
    private final List<Plane> planes;

    public SavePlanesToFileCommand(String filename, List<Plane> planes) {
        this.filename = filename;
        this.planes = planes;
    }

    @Override
    public void execute() {
        savePlanesToFile(filename, planes);
    }

    @Override
    public String getDescription() {
        return "Записати літаки у файл";
    }

    // Опишемо метод savePlanesToFile, аналогічно попередньому коду
    private void savePlanesToFile(String filename, List<Plane> planes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Plane plane : planes) {
                writer.write(plane.toString());
                writer.newLine(); // Додаємо роздільник між об'єктами
            }
            System.out.println("Список об'єктів записано в файл " + filename);
            FileAppender.appendToFile("Список літаків було записано у файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
