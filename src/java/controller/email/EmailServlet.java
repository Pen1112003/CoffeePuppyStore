//package controller.email;
//
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Properties;
//
//@WebServlet("/sendEmail")
//public class EmailServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String to = request.getParameter("email"); // Get the recipient's email address from the request
//        String subject = "Contact Form Submission";
//        String message = request.getParameter("message");
//
//        // SMTP server properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com"); // Change if using another SMTP server
//        properties.put("mail.smtp.port", "587");
//
//        // Set your email and password here
//        final String username = "your-email@gmail.com"; // Change to your email
//        final String password = "your-email-password"; // Change to your email password
//
//        // Create a Session
//        Session session = Session.getInstance(properties,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            // Create a default MimeMessage object
//            Message mimeMessage = new MimeMessage(session);
//            mimeMessage.setFrom(new InternetAddress(username)); // From email
//            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // To email
//            mimeMessage.setSubject(subject);
//            mimeMessage.setText(message);
//
//            // Send the message
//            Transport.send(mimeMessage);
//            System.out.println("Email Sent Successfully");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
