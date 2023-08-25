package Tests;

import BaseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Cat Treats Comparison")
@Feature("Adding Cat Treats Products to Comparison list")
    public class CatProductsComparisonTest extends BaseTest {

        @Test
        @Description("Test to verify the cat treat products were added to comparison list")
        public void testCompareCatProducts() {
            var catTreatsPage = HomePage.chooseTreats();
            catTreatsPage.set1ProductFilters("50", "150", "Whiskas");
            var catProduct1Page = catTreatsPage.selectCat1Product();
            getWindowManager().switchToNewTab();
            catProduct1Page.addToCompareList();
            getWindowManager().switchToTab(HomePage.returnHomePageTitle());
            var catProduct2Page = catTreatsPage.selectCat2Product();
            catProduct2Page.addToCompareList();
            var compareList = catProduct2Page.goToCompareList();
            Assert.assertEquals(compareList.checkSelectedProduct1(), catProduct1Page.getProduct1Name(), "Product 1 name does not match!");
            Assert.assertEquals(compareList.checkSelectedProduct2(), catProduct2Page.getProduct2Name(), "Product 2 name does not match!");
        }
    }
