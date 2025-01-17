import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class USERVALIDATION{
	//VALIDATE THE NAME OF THE USER
	public static boolean ValidateName(String name) {
		return name!=null && !name.isEmpty() && name.matches("[a-zA-Z0-9 ]+");
	}
	//VALIDATE THE EMAIL OF THE USER
	public static boolean ValidateEmail(String email) {
		String emailregex = "^[a-zA-Z0-9]+@gmail\\.com$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	} 
	//VALIDATE DATE OF BIRTH 
	public static boolean ValidateDob(String dob) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		dateformat.setLenient(false);
		try {
			Date date=dateformat.parse(dob);
			return !date.after(new Date());
		}catch(ParseException e) {
			return false;
		}	
		
	}
	public static String ValidateUser(String name, String email, String dob) {
		if(!ValidateName(name)) {
			return "INVALID NAME. PLEASE PROVIDE VALID NAME";
		}
		if(!ValidateEmail(email)) {
			return "INVALID EMAIL. PLEASE PROVIDE VALID EMAIL ADDRESS";
		}
		if(!ValidateDob(dob)) {
			return "INVALID DATE OF BIRTH. PLEASE PROVIDE VALID DATE OF BIRTH";
		}
		return "USER IS VALID,";
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("NAME: ");
		String name= scanner.nextLine();
		System.out.print("EMAIL: ");
		String email= scanner.nextLine();
		System.out.print("DOB (DD/MM/YYYY): ");
		String dob= scanner.nextLine();
		String ValidateResult = ValidateUser(name, email, dob);
		System.out.println(ValidateResult);
		scanner.close();
	}
}
