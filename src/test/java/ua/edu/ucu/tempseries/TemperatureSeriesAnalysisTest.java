package ua.edu.ucu.tempseries;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test(expected = InputMismatchException.class)
    public void testWithInvalidTemps() {
        double[] temperatureSeries = {-1.0, -273.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.741657;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = test.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);

        test.findTempClosestToZero();
    }

    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = test.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = test.findTempClosestToValue(1);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);

        test.findTempClosestToValue(1);
    }

    @Test
    public void testClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = test.findTempClosestToValue(4);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testLessThanWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        double[] actualResult = test.findTempsLessThen(1);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testLessThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = test.findTempsLessThen(1);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testLessThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.0, -1.0};

        double[] actualResult = test.findTempsLessThen(1);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testGreaterThanWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = test.findTempsGreaterThen(1);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testGreaterThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = test.findTempsGreaterThen(1);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testGreaterThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, 5.0};

        double[] actualResult = test.findTempsGreaterThen(1);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double expAvg = -1.0;
        double expDev = 0;
        double expMin = -1.0;
        double expMax = -1.0;

        TempSummaryStatistics actualResult = test.summaryStatistics();
        double actualAvg = actualResult.getAvgTemp();
        double actualDev = actualResult.getDevTemp();
        double actualMin = actualResult.getMinTemp();
        double actualMax = actualResult.getMaxTemp();

        assertEquals(expAvg, actualAvg, 0.00001);
        assertEquals(expDev, actualDev, 0.00001);
        assertEquals(expMin, actualMin, 0.00001);
        assertEquals(expMax, actualMax, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);

        TempSummaryStatistics actualResult = test.summaryStatistics();
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        double expAvg = 1.0;
        double expDev = 3.741657;
        double expMin = -5.0;
        double expMax = 5.0;

        TempSummaryStatistics actualResult = test.summaryStatistics();
        double actualAvg = actualResult.getAvgTemp();
        double actualDev = actualResult.getDevTemp();
        double actualMin = actualResult.getMinTemp();
        double actualMax = actualResult.getMaxTemp();

        assertEquals(expAvg, actualAvg, 0.00001);
        assertEquals(expDev, actualDev, 0.00001);
        assertEquals(expMin, actualMin, 0.00001);
        assertEquals(expMax, actualMax, 0.00001);
    }

    @Test
    public void testAddTempsWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 2;

        int actualResult = test.addTemps(1.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 1;

        int actualResult = test.addTemps(1.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0};
        TemperatureSeriesAnalysis test = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 7;

        int actualResult = test.addTemps(4.0, -2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }
}
