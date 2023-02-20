package contacts;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validate {

    public Validate() {

    }
    public static String formatName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public static String formatPhone (String phoneNumber) {
        try {
            if (isNotValid(phoneNumber)) {
                throw new InputValidationException("Wrong number format!");
            }
            return phoneNumber;
        } catch (InputValidationException e) {
            //System.out.println(e.getMessage());
            return "[no number]";
        }
    }
    private static boolean isNotValid(String phoneNumber) {
        String p1 = "^(\\+)?(\\d )?(\\()?\\w+(\\))?$";
        String p2 = "^(\\+\\d )?(\\()?\\d{3,}(\\))?[- ](\\()?\\w{2,}(\\))?($|([- ][-\\w ]{2,})$)";
        Pattern p1p = Pattern.compile(p1);
        Pattern p2p = Pattern.compile(p2);
        return !p1p.matcher(phoneNumber).find() && !p2p.matcher(phoneNumber).find();
    }

    public static boolean isValidInput(int input, int max) {
        try {
            if (input < 1 || input > max)
                throw new InputValidationException("Invalid id!");
            return true;
        } catch (InputValidationException e) {
            //System.out.println(e.getMessage());
            return false;
        }
    }

    public static String formatDate(String date){
        try {
            LocalDate.parse(date);
            return date;
        } catch (Exception e){
            //System.out.println("Bad birth date!");
            return "[no data]";
        }
    }

    public static String formatGender(String gender){
        gender = gender.toUpperCase();
        if (gender.equals("M")||gender.equals("F")){
            return gender;
        }else {
            return "[no data]";
        }
    }

    public static String validate(String value, String fieldName){
        String toReturn;
        switch (fieldName.toLowerCase()) {
            case "birthdate" -> toReturn = formatDate(value);
            case "number" -> toReturn = formatPhone(value);
            case "name" -> toReturn = formatName(value);
            case "gender" -> toReturn = formatGender(value);
            default -> toReturn = value;
        };
        return toReturn;
    }
}
