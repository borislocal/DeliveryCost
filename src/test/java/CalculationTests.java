import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculationTests extends BaseTest {

    @Test
    void invalidDistanceTest() {
        try {
            calculation.calculateDeliveryCost(
                    0, true, Dimensions.SMALL, WorkloadCoefficient.VERY_HIGH);
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage()
                    .contains("please set kilometers value greater than 0"));
        }
    }

    @Test
    void invalidFragilityDistanceTest() {
        try {
            calculation.calculateDeliveryCost(
                    31, true, Dimensions.SMALL, WorkloadCoefficient.VERY_HIGH);
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage()
                    .contains("fragile delivery could be sent to 30km maximum."));
        }

    }

    @Test
    void minCostTest() {
        float result = calculation.calculateDeliveryCost(
                4, false, Dimensions.SMALL, WorkloadCoefficient.INCREASED);
        Assertions.assertEquals(400, result);
    }

    @Test
    void pairWiseCombinationsTestTC1() {
        float result = calculation.calculateDeliveryCost(
                15, true, Dimensions.SMALL, WorkloadCoefficient.INCREASED
        );
        Assertions.assertEquals(720, result);
    }

    @Test
    void pairWiseCombinationsTestTC2() {
        float result = calculation.calculateDeliveryCost(
                40, false, Dimensions.BIG, WorkloadCoefficient.HIGH);
        Assertions.assertEquals(700, result);
    }

    @Test
    void pairWiseCombinationsTestTC3() {
        float result = calculation.calculateDeliveryCost(
                5, true, Dimensions.BIG, WorkloadCoefficient.OTHER);
        Assertions.assertEquals(600, result);
    }

    @Test
    void pairWiseCombinationsTestTC4() {
        float result = calculation.calculateDeliveryCost(
                1, false, Dimensions.BIG, WorkloadCoefficient.INCREASED);
        Assertions.assertEquals(400, result);
    }

    @Test
    void pairWiseCombinationsTestTC5() {
        float result = calculation.calculateDeliveryCost(
                300, false, Dimensions.SMALL, WorkloadCoefficient.VERY_HIGH);
        Assertions.assertEquals(640, result);
    }

    @Test
    void pairWiseCombinationsTestTC6() {
        float result = calculation.calculateDeliveryCost(
                10, false, Dimensions.BIG, WorkloadCoefficient.VERY_HIGH);
        Assertions.assertEquals(480, result);
    }

    @Test
    void pairWiseCombinationsTestTC7() {
        float result = calculation.calculateDeliveryCost(
                3, true, Dimensions.SMALL, WorkloadCoefficient.HIGH);
        Assertions.assertEquals(700, result);
    }

    @Test
    void pairWiseCombinationsTestTC8() {
        float result = calculation.calculateDeliveryCost(
                11, false, Dimensions.BIG, WorkloadCoefficient.VERY_HIGH);
        Assertions.assertEquals(640, result);
    }

    @Test
    void pairWiseCombinationsTestTC9() {
        float result = calculation.calculateDeliveryCost(
                2, true, Dimensions.SMALL, WorkloadCoefficient.HIGH);
        Assertions.assertEquals(630, result);
    }

    @Test
    void pairWiseCombinationsTestTC10() {
        float result = calculation.calculateDeliveryCost(
                1000, false, Dimensions.SMALL, WorkloadCoefficient.OTHER);
        Assertions.assertEquals(400, result);
    }

    @Test
    void pairWiseCombinationsTestTC11() {
        float result = calculation.calculateDeliveryCost(
                7, true, Dimensions.SMALL, WorkloadCoefficient.INCREASED);
        Assertions.assertEquals(600, result);
    }

    @Test
    void pairWiseCombinationsTestTC12() {
        float result = calculation.calculateDeliveryCost(
                2, true, Dimensions.BIG, WorkloadCoefficient.VERY_HIGH);
        Assertions.assertEquals(880, result);
    }

    @Test
    void pairWiseCombinationsTestTC13() {
        float result = calculation.calculateDeliveryCost(
                13, true, Dimensions.SMALL, WorkloadCoefficient.OTHER);
        Assertions.assertEquals(600, result);
    }

    @Test
    void pairWiseCombinationsTestTC14() {
        float result = calculation.calculateDeliveryCost(
                1, true, Dimensions.BIG, WorkloadCoefficient.OTHER);
        Assertions.assertEquals(550, result);
    }

    @Test
    void pairWiseCombinationsTestTC15() {
        float result = calculation.calculateDeliveryCost(
                32, false, Dimensions.BIG, WorkloadCoefficient.INCREASED);
        Assertions.assertEquals(600, result);
    }

    @Test
    void pairWiseCombinationsTestTC16() {
        float result = calculation.calculateDeliveryCost(
                25, false, Dimensions.SMALL, WorkloadCoefficient.HIGH);
        Assertions.assertEquals(420, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 400",
            "2, 400",

            "3, 480",
            "9, 480",
            "10, 480",

            "11, 640",
            "29, 640",
            "30, 640",

            "31, 800"})
    void test(int kilometers, float expected) {
        float result = calculation.calculateDeliveryCost(
                kilometers, false, Dimensions.BIG, WorkloadCoefficient.VERY_HIGH);
        Assertions.assertEquals(expected, result);
    }

}
