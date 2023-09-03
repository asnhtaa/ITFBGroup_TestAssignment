package Tests;
import BaseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Epic("Cat Treats Comparison")
@Feature("Adding Cat Treats Products to Comparison list")
public class CatProductsComparisonTest extends BaseTest {
    @Test
    @Description("Test to verify the cat treat products were added to comparison list")
    public void testCompareCatProducts() {
        var catTreatsPage = HomePage.chooseTreats();
        catTreatsPage.setProductFilters("50", "150", "Whiskas");
        var catProduct1Page = catTreatsPage.selectCatProduct1();
        getWindowManager().switchToNewTab();
        String product1Name = catProduct1Page.getProduct1Name();
        catProduct1Page.addToCompareList();
        getWindowManager().switchToTab("Лакомства для кошек — купить по низкой цене на Яндекс Маркете");
        var catProduct2Page = catTreatsPage.selectCatProduct2();
        getWindowManager().switchToNewTab();
        catProduct2Page.addToCompareList();
        String product2Name = catProduct2Page.getProduct2Name();
        var compareList = catProduct2Page.goToCompareList();
        SoftAssert softAssert = new SoftAssert();
        int product1Price = compareList.checkSelectedProduct1Price();
        int product2Price = compareList.checkSelectedProduct2Price();
        int totalPrice = product1Price + product2Price;
        softAssert.assertTrue(totalPrice < 300, "Sum of product prices is incorrect!");
        softAssert.assertEquals(compareList.checkSelectedProduct1(), product1Name, "Product 1 name does not match!");
        softAssert.assertEquals(compareList.checkSelectedProduct2(), product2Name, "Product 2 name does not match!");
        compareList.removeProduct1();
        softAssert.assertTrue(compareList.isProduct1Displayed(), "Product was not deleted successfully!");
        compareList.clickRemoveList();
        softAssert.assertTrue(compareList.areProductsDisplayed(), "Product compare list was not cleared successfully!");
        softAssert.assertAll();
    }
}