package custome;

import dao.AdminDao;
import dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FileGenerator {

    private static final String FILE_DIRECTORY = "/Users/penpen1112003/NetBeansProjects/CoffeePuppyStore/history/"; // Ensure the path ends with a slash

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        
        // Schedule a task to run every 5 minutes
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    AdminDao dao = new AdminDao();
                    // Retrieve orders each time the task runs
                    List<Order> orders = dao.getOrder();
                    generateFile(orders);
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.MINUTES);
    }

    private static void generateFile(List<Order> orders) throws IOException {
        // Create the output directory if it doesn't exist
        Files.createDirectories(Paths.get(FILE_DIRECTORY));

        // Generate a unique filename based on the current time
        String fileName = FILE_DIRECTORY + "orders_" + System.currentTimeMillis() + ".txt";

        // Write content to the new file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Order Details:\n");
            writer.write("===================================\n");
            for (Order order : orders) {
                writer.write("Order ID: " + order.getOrderID() + "\n");
                writer.write("Phone: " + order.getPhone() + "\n");
                writer.write("Quantity: " + order.getQuanlity() + "\n");
                writer.write("Order Date: " + order.getOrderDate() + "\n");
                writer.write("Total Amount: " + order.getTotal_amount() + " VND\n");
                writer.write("Status: " + order.getOrder_status() + "\n");
                writer.write("Table Number: " + order.getTable_number() + "\n");
                writer.write("-----------------------------------\n");
            }
            writer.write("===================================\n");
        }

        System.out.println("File created: " + fileName);
    }
}
