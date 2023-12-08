import PlaneTypes.Plane;
import PlaneTypes.PassengerPlane;
import PlaneTypes.CargoPlane;
import PlaneTypes.PrivatePlane;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Plane> planes = new ArrayList<>();
        Main main = new Main();
        main.clearLogFile();

        planes.add(new PassengerPlane("Гестія", 23000, 15, 200, 2000, "Available"));
        planes.add(new CargoPlane("Ерида", 2500,25, 150, 400, "underMaintanance"));
        planes.add(new PrivatePlane("Тефон", 300, 30, 20, 800, "Available", 2));
        planes.add(new PassengerPlane("Аврора", 28000, 40,  220, 2200, "Available"));
        planes.add(new CargoPlane("Апометей", 3500, 25, 180, 450, "underMaintenance"));
        planes.add(new PrivatePlane("Меркурій", 350, 20, 22, 900, "underMaintanance", 2));
        planes.add(new PassengerPlane("Ікар", 25000, 15, 210, 2100, "Discalled"));
        planes.add(new CargoPlane("Сатурн", 3200, 18, 170, 430, "Available"));
        planes.add(new PrivatePlane("Венера", 380, 40, 24, 950, "Available", 8));

        int serviceCode = 2365847;
        boolean isAdmin = false;
        boolean exit = false;
        String fileName = "planes.txt";
        String errorLogFileName = "errors.txt";

        try {
            FileHandler errorFileHandler = new FileHandler(errorLogFileName);
            errorFileHandler.setFormatter(new SimpleFormatter());
            // Встановлення рівня логування для обробника помилок
            errorFileHandler.setLevel(Level.SEVERE); // Лише критичні помилки
            logger.addHandler(errorFileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Помилка при налаштуванні обробника файлу для помилок", e);
        }

        List<Command> userCommands = new ArrayList<>();
        userCommands.add(new DisplayPlanesCommand(planes, scanner));
        userCommands.add(new FilterPlanesByFuelCommand(planes, scanner));
        userCommands.add(new SortByLengthCommand(planes));


        List<Command> adminCommands = new ArrayList<>();
        adminCommands.add(new AdminDisplayPlanesCommand(planes, scanner));
        adminCommands.add(new AdminFilterPlanesByFuelCommand(planes, scanner));
        adminCommands.add(new SortByLengthCommand(planes));
        adminCommands.add(new SavePlanesToFileCommand(fileName, planes));


        System.out.println("Авіакомпанія Hermes Airlines.");
        System.out.println("Швидкість наш пріорітет!");
        FileAppender.appendToFile("Програма розпочала роботу" );
        System.out.println(" ");
        System.out.println("Чи бажаєте ввести код адміністратора?");
        System.out.println("так(1)");
        System.out.println("ні(2)");
        int adminConfirm = scanner.nextInt();
        if (adminConfirm == 1) {
            if (!isAdmin) {
                System.out.println("Введіть код адміністратора");
                int askCode = scanner.nextInt();
                if (askCode == serviceCode) {
                    isAdmin = true;
                    System.out.println("Ваш рівень доступу було піднято до адміністратора");
                    FileAppender.appendToFile("Користувачу надано роль адміністратора");                }
            } else {
                System.out.println("Ви уже адміністратор");
            }
        }
        if (isAdmin) {


            while (!exit) {
                System.out.println(" ");
                for (int i = 0; i < adminCommands.size(); i++) {
                    System.out.println((i + 1) + ") " + adminCommands.get(i).getDescription());
                }
                System.out.println("Else) Вийти");

                int selectedCommandIndex = scanner.nextInt();

                if (selectedCommandIndex > 0 && selectedCommandIndex <= adminCommands.size()) {
                    adminCommands.get(selectedCommandIndex - 1).execute();
                } else {
                    exit = true;
                }
            }
        }
        else {
            while (!exit) {
                System.out.println(" ");
                for (int i = 0; i < userCommands.size(); i++) {
                    System.out.println((i + 1) + ") " + userCommands.get(i).getDescription());
                }
                System.out.println("Else) Вийти");

                int selectedCommandIndex = scanner.nextInt();

                if (selectedCommandIndex > 0 && selectedCommandIndex <= userCommands.size()) {
                    userCommands.get(selectedCommandIndex - 1).execute();
                }

                if (selectedCommandIndex > userCommands.size()) {
                    exit = true;
                }
            }

        }


    }
    private static void clearLogFile() {
        String logFileName = "log.txt";
        File logFile = new File(logFileName);

        try {
            if (logFile.exists()) {
                PrintWriter writer = new PrintWriter(logFile);
                writer.close();
                logger.info("Файл " + logFileName + " був очищений.");
            } else {
                logFile.createNewFile();
                logger.info("Файл " + logFileName + " був створений.");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Сталася помилка при очищенні файлу " + logFileName, e);
        }
    }




}