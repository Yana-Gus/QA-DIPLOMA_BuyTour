package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TourPurchaseTests {
    DashboardPage dashboardPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @BeforeEach
    void setUp() {
        dashboardPage = open("http://localhost:8080", DashboardPage.class);
    }

    @Test
    public void shouldSuccessfulPayment() {
        var cardInfo = DataHelper.getApprovedCardInfo();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.successfulPayment();
        assertEquals("APPROVED", SQLHelper.getStatusPayment());
    }

    @Test
    public void shouldRefusedTransactionOnDeclinedCard() {
        var cardInfo = DataHelper.getDeclinedCardInfo();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.refusedTransaction();
        assertEquals("DECLINED", SQLHelper.getStatusPayment());
    }

    @Test
    public void shouldEnterInvalidNameInCyrillic() {
        var cardInfo = DataHelper.getInvalidNameInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidNameWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameInNumbers() {
        var cardInfo = DataHelper.getInvalidNameInNumbers();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithOneLetter() {
        var cardInfo = DataHelper.getInvalidNameWithOneLetter();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameUsingMoreThan64Letters() {
        var cardInfo = DataHelper.getInvalidNameUsingMoreThan64Letters();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldNamedAreNotFilled() {
        var cardInfo = DataHelper.getFieldNamedAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.verifyRequiredField();
    }


    @Test
    public void shouldEnterInvalidCardNumberLessThan16Digits() {
        var cardInfo = DataHelper.getInvalidCardNumberLessThan16Digits();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidCardNumberWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberInCyrillic() {
        var cardInfo = DataHelper.getInvalidCardNumberInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCardNumberInLatin() {
        var cardInfo = DataHelper.getInvalidCardNumberInLatin();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldCardNumberAreNotFilled() {
        var cardInfo = DataHelper.getFieldCardNumberAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldInvalidMonth0() {
        var cardInfo = DataHelper.getInvalidMonth0();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonth13() {
        var cardInfo = DataHelper.getInvalidMonth13();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidMonthWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidMonthWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInCyrillic() {
        var cardInfo = DataHelper.getInvalidMonthInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInLatin() {
        var cardInfo = DataHelper.getInvalidMonthInLatin();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldMonthAreNotFilled() {
        var cardInfo = DataHelper.getFieldMonthAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldInvalidYear() {
        var cardInfo = DataHelper.getInvalidYear();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.verifyCardExpired();
    }

    @Test
    public void shouldInvalidYearMore10Years() {
        var cardInfo = DataHelper.getInvalidYearMore10Years();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidYearWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidYearWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInCyrillic() {
        var cardInfo = DataHelper.getInvalidYearInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInOneDigit() {
        var cardInfo = DataHelper.getInvalidYearInOneDigit();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldYearAreNotFilled() {
        var cardInfo = DataHelper.getFieldYearAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldInvalidCodWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidCodWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInCyrillic() {
        var cardInfo = DataHelper.getInvalidCodInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInLatin() {
        var cardInfo = DataHelper.getInvalidCodInLatin();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInOneDigit() {
        var cardInfo = DataHelper.getInvalidCodInOneDigit();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldCodAreNotFilled() {
        var cardInfo = DataHelper.getFieldCodAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldAllFieldsAreNotFilled() {
        var cardInfo = DataHelper.getAllFieldsAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour();
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
        tourPurchasePage.verifyRequiredField();
    }

}
