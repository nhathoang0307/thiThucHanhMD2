package utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtils{
    static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int min, int max) {
        int option;
        do {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("CHỌN SAI, XIN MỜI NHẬP LẠI");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("NHẬP SAI, XIN NHẬP LẠI");
            }
        } while (true);
        return option;
    }

    public static int retryParseInt() {
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("NHẬP SAI, XIN NHẬP LẠI");
            }
        } while (true);
    }

    public static String retryTitle() {
        String title;
        while ((title = scanner.nextLine()).isEmpty()) {
            System.out.println("KHÔNG ĐƯỢC BỎ TRỐNG");
        }
        return title;
    }

    public static String retryString(String fieldName) {
        String result;
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("%s KHÔNG ĐƯỢC ĐỂ TRỐNG \n", fieldName);
            System.out.print("░░░ ");
        }
        return result;
    }


    public static double retryParseDouble() {
        double result;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("NHẬP SAI, XIN NHẬP LẠI");
            }
        } while (true);
    }

    public static Long retryParseLong() {
        Long result;
        do {
            try {
                result = Long.parseLong(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("NHẬP SAI, XIN NHẬP LẠI");
            }
        } while (true);
    }

    public static float retryParseFloat() {
        float result;
        do {
            try {
                result = Float.parseFloat(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("NHẬP SAI, XIN NHẬP LẠI");
            }
        } while (true);
    }

    public static String doubleToVND(double value) {
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static void exit() {
        System.out.println("░░░ CHÀO TẠM BIỆT, HẸN GẶP LẠI !!! ░░░");
        System.exit(5);
    }
    public static String beNotEmply(String name) {
        String result;
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.println(name + " KHÔNG ĐƯỢC ĐỂ TRỐNG");
        }
        return result;
    }

    public static boolean isRetry() {
        System.out.println("NHẤN 1 ĐỂ TIẾP TỤC \t|\t NHẤN 2 ĐỂ QUAY LẠI \t|\t NHẤN 0 ĐỂ THOÁT CHƯƠNG TRÌNH");
        do {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                   return true;
                case "2":
                   return false;
                case "0":
                    System.out.println("CHÀO TẠM BIỆT, HẸN GĂP LẠI");
                    System.exit(5);
                default:
                    System.out.println("NHẬP SAI, XIN NHẬP LẠI");
                    break;
            }
        } while (true);
    }
}
