import PlaneTypes.Plane;

import java.util.List;

public class SortByLengthCommand implements Command {
    private final List<Plane> planes;

    public SortByLengthCommand(List<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public void execute() {
        sortByLength();
    }

    @Override
    public String getDescription() {
        return "Сортувати літаки за дальністю польоту";
    }

    // Опишемо метод sortByLength, аналогічний попередньому коду
    private void sortByLength() {
        planes.sort((x, y) -> y.getMaxFlightLength() - x.getMaxFlightLength());
        FileAppender.appendToFile("Список літаків було посортовано");
    }
}
