package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import ru.netology.data.DataHelper.CardInfo;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement buyOnCreditButton = $(byText("Купить в кредит"));


    public TourPurchasePage buyTour() {
        buyButton.click();
        return new TourPurchasePage();
    }

    public BuyTourOnCreditPage buyOnCreditTour() {
        buyOnCreditButton.click();
        return new BuyTourOnCreditPage();
    }

}
