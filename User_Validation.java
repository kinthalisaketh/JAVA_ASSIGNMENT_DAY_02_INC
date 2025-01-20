import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User_Validation{

    // VALIDATE THE NAME OF THE USER
    public static String validateName(Scanner scanner) {
        String name;
        while (true) {
            System.out.print("NAME: ");
            name = scanner.nextLine();
            if (name != null && !name.isEmpty() && name.matches("[a-zA-Z0-9 ]+")) {
                return name;
            } else {
                System.out.println("INVALID NAME. RE-ENTER A VALID NAME");
            }
        }
    }

    // VALIDATE THE EMAIL OF THE USER
    public static String validateEmail(Scanner scanner) {
        String email;
        String emailRegex = "^[a-zA-Z0-9]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        while (true) {
            System.out.print("EMAIL: ");
            email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                System.out.println("INVALID EMAIL. RE-ENTER A VALID EMAIL ADDRESS");
            }
        }
    }

    // VALIDATE DATE OF BIRTH
    public static String validateDob(Scanner scanner) {
        String dob;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print("DOB (DD/MM/YYYY): ");
            dob = scanner.nextLine();
            try {
                Date date = dateFormat.parse(dob);
                if (!date.after(new Date())) {
                    return dob;
                } else {
                    System.out.println("Date of birth cannot be in the future. RE-ENTER A VALID DATE OF BIRTH");
                }
            } catch (ParseException e) {
                System.out.println("INVALID DATE OF BIRTH. RE-ENTER A VALID DATE OF BIRTH");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = validateName(scanner);
        String email = validateEmail(scanner);
        String dob = validateDob(scanner);
       System.out.println();
        // Output valid data
        System.out.println("Valid Name: " + name);
        System.out.println("Valid Email: " + email);
        System.out.println("Valid DOB: " + dob);
    }
}
