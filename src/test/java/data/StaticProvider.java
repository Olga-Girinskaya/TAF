package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForDivIntTest")
    public static Object[][] dataForDivIntTest() {
        return new Object[][]{
                {12, 2, 6},
                {10, 2, 5}
        };
    }

    @DataProvider(name = "Double")
    public static Object[][] dataForDivDoubleTest() {
        return new Object[][]{
                {17.6, 3.2, 5.5},
                {8.75, 3.5, 2.5}
        };
    }
}