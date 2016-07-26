package domain;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class CoinTest {
    @DataProvider
    public static Object[][] coinDataProvier() {
        return new Object[][] {
                { 5, true },
                { 10, true },
                { 25, true },
                { 1, false },
                { null, false }
        };
    }

    @Test
    @UseDataProvider("coinDataProvier")
    public void shouldPassIfIsValidCoin(Integer value, boolean expected) {
        assertEquals(expected, new Coin().setValue(value).isValid());
    }
}