package ua.edu.ucu.tempseries;
import java.lang.Math;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {

    private int tempLen;
    private double[] temperatureSeries;


    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++)
        {
            if (temperatureSeries[i] < -273.0)
            {
                throw new InputMismatchException();
            }
        }
        this.tempLen = temperatureSeries.length;
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < this.tempLen; i++) {
            sum += this.temperatureSeries[i];
        }
        double avg = sum / this.tempLen;
        return avg;
    }

    public double deviation() {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        double avg = this.average();
        double sum = 0;
        for (int i = 0; i < this.tempLen; i++) {
            sum += Math.pow(this.temperatureSeries[i] - avg, 2);
        }
        System.out.println(sum);
        double dev = Math.sqrt(sum / this.tempLen);
        return dev;
    }

    public double min() {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        double min = 100000;
        for (int i = 0; i < this.tempLen; i++) {
            if (this.temperatureSeries[i] < min) {
                min = this.temperatureSeries[i];
            }
        }
        return min;
    }

    public double max() {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        double max = -273;
        for (int i = 0; i < this.tempLen; i++) {
            if (this.temperatureSeries[i] > max) {
                max = this.temperatureSeries[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        double closest_to_zero = 100000;
        for (int i = 0; i < this.tempLen; i++) {
            if (Math.abs(this.temperatureSeries[i]) < Math.abs(closest_to_zero) || this.temperatureSeries[i] == Math.abs(closest_to_zero)) {
                closest_to_zero = this.temperatureSeries[i];
            }
        }
        return closest_to_zero;
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        double closest_to_value = 100000;
        for (int i = 0; i < this.tempLen; i++) {
            if (Math.abs(this.temperatureSeries[i] - tempValue) < Math.abs(closest_to_value - tempValue)) {
                closest_to_value = this.temperatureSeries[i];
            }
        }
        return closest_to_value;
    }

    public double[] findTempsLessThen(double tempValue) {
        int arr_len = 0;
        for (int i = 0; i < this.tempLen; i++) {
            if (this.temperatureSeries[i] < tempValue) {
                arr_len++;
            }
        }
        double[] temps_less = new double[arr_len];
        int j = 0;
        for (int i = 0; i < this.tempLen; i++) {
            if (this.temperatureSeries[i] < tempValue) {
                temps_less[j] = this.temperatureSeries[i];
                j++;
                if (j > arr_len) break;
            }
        }
        return temps_less;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int arr_len = 0;
        for (int i = 0; i < this.tempLen; i++) {
            if (this.temperatureSeries[i] > tempValue) {
                arr_len++;
            }
        }
        double[] temps_greater = new double[arr_len];
        int j = 0;
        for (int i = 0; i < this.tempLen; i++) {
            if (this.temperatureSeries[i] > tempValue) {
                temps_greater[j] = this.temperatureSeries[i];
                j++;
                if (j > arr_len) break;
            }
        }
        return temps_greater;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (this.tempLen == 0) {
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics tss = new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());
        return tss;
    }

    public int addTemps(double... temps) {
        if (temps.length > this.temperatureSeries.length - this.tempLen) {
            this.temperatureSeries = Arrays.copyOf(this.temperatureSeries, 2 * (this.tempLen + temps.length));
        }
        for (int i = 0; i < temps.length; i++) {
            this.temperatureSeries[this.tempLen + i] = temps[i];
            this.tempLen++;
        }
        return this.tempLen;
    }
}

