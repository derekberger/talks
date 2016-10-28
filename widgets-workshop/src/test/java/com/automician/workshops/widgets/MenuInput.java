package com.automician.workshops.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;

public class MenuInput {
    private final SelenideElement container;
    private final String label;

    public MenuInput(SelenideElement container, String label) {
        this.container = container;
        this.label = label;
    }

    public SelenideElement element() {
        return this.container.find(withText(this.label))
                .find(byXpath("../input"));
    }

    public MenuInput setValue(String name) {
        element().click();
        /* needed as work-around for focus issues
         * it's not a "spike" though
         * because actually emulates true user click on edit field
         * before setting its value
         */

        element().setValue(name);
        return this;
    }

    public MenuInput click() {
        element().click();
        return this;
    }
}
