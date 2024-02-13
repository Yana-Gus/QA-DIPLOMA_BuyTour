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
import static ru.netology.data.SQLHelper.cleanDatabase;

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
        var cardInfo = new DataHelper().getApprovedCardInfo();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.successfulPayment();
        assertEquals("APPROVED", SQLHelper.getStatusPayment());
    }

    @Test
    public void shouldRefusedTransactionOnDeclinedCard() {
        var cardInfo = new DataHelper().getDeclinedCardInfo();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.refusedTransaction();
        assertEquals("DECLINED", SQLHelper.getStatusPayment());
    }

    @Test
    public void shouldEnterInvalidNameInCyrillic() {
        var cardInfo = new DataHelper().getInvalidNameInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidNameWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameInNumbers() {
        var cardInfo = new DataHelper().getInvalidNameInNumbers();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithOneLetter() {
        var cardInfo = new DataHelper().getInvalidNameWithOneLetter();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameUsingMoreThan64Letters() {
        var cardInfo = new DataHelper().getInvalidNameUsingMoreThan64Letters();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldNamedAreNotFilled() {
        var cardInfo = new DataHelper().getFieldNamedAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.verifyRequiredField();
    }


    @Test
    public void shouldEnterInvalidCardNumberLessThan16Digits() {
        var cardInfo = new DataHelper().getInvalidCardNumberLessThan16Digits();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidCardNumberWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberInCyrillic() {
        var cardInfo = new DataHelper().getInvalidCardNumberInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCardNumberInLatin() {
        var cardInfo = new DataHelper().getInvalidCardNumberInLatin();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldCardNumberAreNotFilled() {
        var cardInfo = new DataHelper().getFieldCardNumberAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldInvalidMonth0() {
        var cardInfo = new DataHelper().getInvalidMonth0();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonth13() {
        var cardInfo = new DataHelper().getInvalidMonth13();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidMonthWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidMonthWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInCyrillic() {
        var cardInfo = new DataHelper().getInvalidMonthInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInLatin() {
        var cardInfo = new DataHelper().getInvalidMonthInLatin();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldMonthAreNotFilled() {
        var cardInfo = new DataHelper().getFieldMonthAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldInvalidYear() {
        var cardInfo = new DataHelper().getInvalidYear();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.verifyCardExpired();
    }

    @Test
    public void shouldInvalidYearMore10Years() {
        var cardInfo = new DataHelper().getInvalidYearMore10Years();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidYearWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidYearWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInCyrillic() {
        var cardInfo = new DataHelper().getInvalidYearInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInOneDigit() {
        var cardInfo = new DataHelper().getInvalidYearInOneDigit();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldYearAreNotFilled() {
        var cardInfo = new DataHelper().getFieldYearAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldInvalidCodWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidCodWithSpecialCharacters();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInCyrillic() {
        var cardInfo = new DataHelper().getInvalidCodInCyrillic();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInLatin() {
        var cardInfo = new DataHelper().getInvalidCodInLatin();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInOneDigit() {
        var cardInfo = new DataHelper().getInvalidCodInOneDigit();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }

    @Test
    public void shouldFieldCodAreNotFilled() {
        var cardInfo = new DataHelper().getFieldCodAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
    }


    @Test
    public void shouldAllFieldsAreNotFilled() {
        var cardInfo = new DataHelper().getAllFieldsAreNotFilled();
        var tourPurchasePage = dashboardPage.buyTour(cardInfo);
        tourPurchasePage.allFieldsFilled(cardInfo);
        tourPurchasePage.invalidFormat();
        tourPurchasePage.verifyRequiredField();
    }

}
