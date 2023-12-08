//import javax.mail.MessagingException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileAppender {
    private static final Logger logger = Logger.getLogger(FileAppender.class.getName());

    public static void appendToFile(String text) {
        String fileName = "log.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(text);
            logger.info("Дані були додані у файл " + fileName);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Помилка при додаванні у файл " + fileName, e);
          //  handleCriticalError("Помилка при додаванні у файл " + fileName + ": " + e.getMessage());
        }
    }

    public static void handleCriticalError(String errorMessage) {
        // Виклик функції надсилання електронної пошти для обробки критичних помилок
       // sendCriticalErrorEmail("fdfgg951@gmail.com", "Критична помилка", errorMessage);
    }

  /*  private static void sendCriticalErrorEmail(String recipient, String subject, String body) {
        try {
            EmailSender.sendEmail(recipient, subject, body);
        } catch (MessagingException e) {
            e.printStackTrace(); // Обробка помилки надсилання листа
        }
    }*/
}
