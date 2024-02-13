package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    public static final Faker faker = new Faker(new Locale("en"));

    public DataHelper() {
    }

    public static String getApprovedCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return ("4444 4444 4444 4442");
    }

    public static String generateValidMonth() {
        return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateValidYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateValidName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateValidCod() {
        return Integer.toString(faker.number().numberBetween(100, 999));
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String name;
        String cod;
    }

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo(
                getDeclinedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }


    public static CardInfo getInvalidNameInCyrillic() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), "Иван Иванов", generateValidCod());
    }

    public static CardInfo getInvalidNameWithSpecialCharacters() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), "Iv@n !v@nov", generateValidCod());
    }

    public static CardInfo getInvalidNameInNumbers() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), "1van 1v4n0v", generateValidCod());
    }

    public static CardInfo getInvalidNameWithOneLetter() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), "I", generateValidCod());
    }

    public static CardInfo getInvalidNameUsingMoreThan64Letters() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(),
                generateValidYear(), "iiiiiiiiiivvvvvvvvvvaaaaaaaaaannnnnnnnnniiiiiiiiiivvvvvvvvvvaaaaaaaaaa",
                generateValidCod());
    }

    public static CardInfo getFieldNamedAreNotFilled() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(),
                generateValidYear(), " ",
                generateValidCod());
    }


    public static CardInfo getInvalidCardNumberLessThan16Digits() {
        return new CardInfo(
                "1111_2222_3333", generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidCardNumberWithSpecialCharacters() {
        return new CardInfo(
                "1111_2@@@_3###_$444", generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidCardNumberInCyrillic() {
        return new CardInfo(
                "1111_22йй_3333_444к", generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidCardNumberInLatin() {
        return new CardInfo(
                "1111_22qq_3ww3_44rr", generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getFieldCardNumberAreNotFilled() {
        return new CardInfo(
                " ", generateValidMonth(), generateValidYear(), generateValidName(), generateValidCod());
    }



    public static CardInfo getInvalidMonth0() {
        return new CardInfo(
                getApprovedCardNumber(), "0", generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidMonth13() {
        return new CardInfo(
                getApprovedCardNumber(), "13", generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidMonthWithSpecialCharacters() {
        return new CardInfo(
                getApprovedCardNumber(), "0*", generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidMonthInCyrillic() {
        return new CardInfo(
                getApprovedCardNumber(), "О8", generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidMonthInLatin() {
        return new CardInfo(
                getApprovedCardNumber(), "O9", generateValidYear(), generateValidName(), generateValidCod());
    }

    public static CardInfo getFieldMonthAreNotFilled() {
        return new CardInfo(
                getApprovedCardNumber(), " ", generateValidYear(), generateValidName(), generateValidCod());
    }



    public static CardInfo getInvalidYear() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), "23", generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidYearMore10Years() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), "36", generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidYearWithSpecialCharacters() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), "2$", generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidYearInCyrillic() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), "2Б", generateValidName(), generateValidCod());
    }

    public static CardInfo getInvalidYearInOneDigit() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), "2", generateValidName(), generateValidCod());
    }

    public static CardInfo getFieldYearAreNotFilled() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), " ", generateValidName(), generateValidCod());
    }



    public static CardInfo getInvalidCodWithSpecialCharacters() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), "23$");
    }

    public static CardInfo getInvalidCodInCyrillic() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), "23Ч");
    }

    public static CardInfo getInvalidCodInLatin() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), "23r");
    }

    public static CardInfo getInvalidCodInOneDigit() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), "2");
    }

    public static CardInfo getFieldCodAreNotFilled() {
        return new CardInfo(
                getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateValidName(), " ");
    }



    public static CardInfo getAllFieldsAreNotFilled() {
        return new CardInfo(
                " ", " ", " ", " ", " ");
    }




}
