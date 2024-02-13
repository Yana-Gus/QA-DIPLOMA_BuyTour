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
        var cardInfo = new DataHelper().getApprovedCardInfo();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.successfulPayment();
        assertEquals("APPROVED", SQLHelper.getStatusCreditRequest());
    }

    @Test
    public void shouldRefusalPurchaseOnCreditUsingDeclinedCard() {
        var cardInfo = new DataHelper().getDeclinedCardInfo();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.refusalPurchaseOnCredit();
        assertEquals("DECLINED", SQLHelper.getStatusCreditRequest());
    }


    @Test
    public void shouldEnterInvalidNameInCyrillic() {
        var cardInfo = new DataHelper().getInvalidNameInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidNameWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameInNumbers() {
        var cardInfo = new DataHelper().getInvalidNameInNumbers();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameWithOneLetter() {
        var cardInfo = new DataHelper().getInvalidNameWithOneLetter();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidNameUsingMoreThan64Letters() {
        var cardInfo = new DataHelper().getInvalidNameUsingMoreThan64Letters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldNamedAreNotFilled() {
        var cardInfo = new DataHelper().getFieldNamedAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.verifyRequiredField();
    }


    @Test
    public void shouldEnterInvalidCardNumberLessThan16Digits() {
        var cardInfo = new DataHelper().getInvalidCardNumberLessThan16Digits();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidCardNumberWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldEnterInvalidCardNumberInCyrillic() {
        var cardInfo = new DataHelper().getInvalidCardNumberInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCardNumberInLatin() {
        var cardInfo = new DataHelper().getInvalidCardNumberInLatin();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldCardNumberAreNotFilled() {
        var cardInfo = new DataHelper().getFieldCardNumberAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldInvalidMonth0() {
        var cardInfo = new DataHelper().getInvalidMonth0();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonth13() {
        var cardInfo = new DataHelper().getInvalidMonth13();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidMonthWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidMonthWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInCyrillic() {
        var cardInfo = new DataHelper().getInvalidMonthInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidMonthInLatin() {
        var cardInfo = new DataHelper().getInvalidMonthInLatin();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldMonthAreNotFilled() {
        var cardInfo = new DataHelper().getFieldMonthAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldInvalidYear() {
        var cardInfo = new DataHelper().getInvalidYear();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.verifyCardExpired();
    }

    @Test
    public void shouldInvalidYearMore10Years() {
        var cardInfo = new DataHelper().getInvalidYearMore10Years();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.InvalidExpirationCard();
    }

    @Test
    public void shouldInvalidYearWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidYearWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInCyrillic() {
        var cardInfo = new DataHelper().getInvalidYearInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidYearInOneDigit() {
        var cardInfo = new DataHelper().getInvalidYearInOneDigit();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldYearAreNotFilled() {
        var cardInfo = new DataHelper().getFieldYearAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldInvalidCodWithSpecialCharacters() {
        var cardInfo = new DataHelper().getInvalidCodWithSpecialCharacters();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInCyrillic() {
        var cardInfo = new DataHelper().getInvalidCodInCyrillic();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInLatin() {
        var cardInfo = new DataHelper().getInvalidCodInLatin();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldInvalidCodInOneDigit() {
        var cardInfo = new DataHelper().getInvalidCodInOneDigit();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }

    @Test
    public void shouldFieldCodAreNotFilled() {
        var cardInfo = new DataHelper().getFieldCodAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
    }


    @Test
    public void shouldAllFieldsAreNotFilled() {
        var cardInfo = new DataHelper().getAllFieldsAreNotFilled();
        var buyTourOnCreditPage = dashboardPage.buyOnCreditTour(cardInfo);
        buyTourOnCreditPage.allFieldsFilled(cardInfo);
        buyTourOnCreditPage.invalidFormat();
        buyTourOnCreditPage.verifyRequiredField();
    }
}
