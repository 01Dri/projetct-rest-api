package me.dri.restproject.utils;

import me.dri.restproject.exception.attributeAlreadyExists;

public class UtilsMath {

    public static  Double converToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(strNumber)) return Double.parseDouble(number);
        return 0D;

    }

    private static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

    public static void isNumeriValidantion(String number, String numberTwo) {
        if (!UtilsMath.isNumeric(number) || !UtilsMath.isNumeric(numberTwo)) {
            throw new attributeAlreadyExists("Please a set a numeric value");
        }

    }

    public static void isNumeriValidantion(String number) {
        if (!UtilsMath.isNumeric(number)) {
            throw new attributeAlreadyExists("Please a set a numeric value");

        }
    }
}
