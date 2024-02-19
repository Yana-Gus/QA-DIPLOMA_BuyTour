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


public class BuyTourOnCreditTests {
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
    public void shouldSuccessfulPaymentOnCredit() {
        var cardInfo = DataHelper.getApprovedCardInfo();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.successfulPayment();
        assertEquals("APPROVED", SQLHelper.getStatusCreditRequest());
    }

    @Test
    public void shouldRefusalPurchaseOnCreditUsingDeclinedCard() {
        var cardInfo = DataHelper.getDeclinedCardInfo();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.refusalPurchaseOnCredit();
        assertEquals("DECLINED", SQLHelper.getStatusCreditRequest());
    }


    @Test
    public void shouldEnterInvalidNameInCyrillic() {
        var cardInfo = DataHelper.getInvalidNameInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidNameWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameInNumbers() {
        var cardInfo = DataHelper.getInvalidNameInNumbers();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithOneLetter() {
        var cardInfo = DataHelper.getInvalidNameWithOneLetter();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameUsingMoreThan64Letters() {
        var cardInfo = DataHelper.getInvalidNameUsingMoreThan64Letters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldNamedAreNotFilled() {
        var cardInfo = DataHelper.getFieldNamedAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.verifyRequiredField();
    }


    @Test
    public void shouldEnterInvalidCardNumberLessThan16Digits() {
        var cardInfo = DataHelper.getInvalidCardNumberLessThan16Digits();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidCardNumberWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberInCyrillic() {
        var cardInfo = DataHelper.getInvalidCardNumberInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCardNumberInLatin() {
        var cardInfo = DataHelper.getInvalidCardNumberInLatin();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldCardNumberAreNotFilled() {
        var cardInfo = DataHelper.getFieldCardNumberAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldInvalidMonth0() {
        var cardInfo = DataHelper.getInvalidMonth0();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonth13() {
        var cardInfo = DataHelper.getInvalidMonth13();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidMonthWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidMonthWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInCyrillic() {
        var cardInfo = DataHelper.getInvalidMonthInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInLatin() {
        var cardInfo = DataHelper.getInvalidMonthInLatin();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldMonthAreNotFilled() {
        var cardInfo = DataHelper.getFieldMonthAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldInvalidYear() {
        var cardInfo = DataHelper.getInvalidYear();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.verifyCardExpired();
    }

    @Test
    public void shouldInvalidYearMore10Years() {
        var cardInfo = DataHelper.getInvalidYearMore10Years();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidYearWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidYearWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInCyrillic() {
        var cardInfo = DataHelper.getInvalidYearInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInOneDigit() {
        var cardInfo = DataHelper.getInvalidYearInOneDigit();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldYearAreNotFilled() {
        var cardInfo = DataHelper.getFieldYearAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldInvalidCodWithSpecialCharacters() {
        var cardInfo = DataHelper.getInvalidCodWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInCyrillic() {
        var cardInfo = DataHelper.getInvalidCodInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInLatin() {
        var cardInfo = DataHelper.getInvalidCodInLatin();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInOneDigit() {
        var cardInfo = DataHelper.getInvalidCodInOneDigit();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldCodAreNotFilled() {
        var cardInfo = DataHelper.getFieldCodAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldAllFieldsAreNotFilled() {
        var cardInfo = DataHelper.getAllFieldsAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour();
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
        buyTourOnCreditPage.verifyRequiredField();
    }
}
