package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement buyOnCreditButton = $(byText("Купить в кредит"));


    public TourPurchasePage buyTour(DataHelper.CardInfo cardInfo) {
        buyButton.click();
        return new TourPurchasePage();
    }

    public BuyTourOnCreditPage buyOnCreditTour(DataHelper.CardInfo cardInfo) {
        buyOnCreditButton.click();
        return new BuyTourOnCreditPage();
    }

}
