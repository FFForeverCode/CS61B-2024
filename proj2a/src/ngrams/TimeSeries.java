package ngrams;

import java.security.Key;
import java.util.*;

/**
 * An object for mapping a year number (e.g. 1996) to numerical data. Provides
 * utility methods useful for data analysis.
 *
 * @author Josh Hug
 */
public class TimeSeries extends TreeMap<Integer, Double> {

    /** If it helps speed up your code, you can assume year arguments to your NGramMap
     * are between 1400 and 2100. We've stored these values as the constants
     * MIN_YEAR and MAX_YEAR here. */
    /**
     * 常数 需声明定义 且 命名大写 final定义为最终量不可修改 避免出现魔幻数
     */
    public static final int MIN_YEAR = 1400;
    public static final int MAX_YEAR = 2100;

    /**
     * Constructs a new empty TimeSeries.
     */
    public TimeSeries() {
        super();
    }

    /**
     * Creates a copy of TS, but only between STARTYEAR and ENDYEAR,
     * inclusive of both end points.
     */
    /**
     * 将原始表 复制 到该表中
     * @param ts 原年份信息表
     * @param startYear 开始年份
     * @param endYear 结束年份
     */
    public TimeSeries(TimeSeries ts, int startYear, int endYear) {
        super();
        Set<Integer>keyset = ts.keySet();
        Integer[]array = keyset.toArray(new Integer[0]);
        Arrays.sort(array);
        for (Integer i : array) {
            put(i,ts.get(i));
        }

    }

    /**
     * Returns all years for this TimeSeries (in any order).
     * 按照升序存入列表(非必要)
     */
    public List<Integer> years() {
        Set<Integer>keyset = this.keySet();
        Integer[]array = keyset.toArray(new Integer[0]);
        Arrays.sort(array);
        return Arrays.stream(array).toList();
    }

    /**
     * Returns all data for this TimeSeries (in any order).
     * Must be in the same order as years().
     */
    public List<Double> data() {
        List<Double>data = new ArrayList<>();
        List<Integer>year = years();
        for (Integer i : year) {
            data.add(get(i));
        }
        return data;
    }

    /**
     * Returns the year-wise sum of this TimeSeries with the given TS. In other words, for
     * each year, sum the data from this TimeSeries with the data from TS. Should return a
     * new TimeSeries (does not modify this TimeSeries).
     *
     * If both TimeSeries don't contain any years, return an empty TimeSeries.
     * If one TimeSeries contains a year that the other one doesn't, the returned TimeSeries
     * should store the value from the TimeSeries that contains that year.
     */
    public TimeSeries plus(TimeSeries ts) {
        TimeSeries newTime = new TimeSeries();
        Set<Integer>set = new TreeSet<>();
        set.addAll(this.keySet());
        set.addAll(ts.keySet());
        for (Integer i : set) {
            newTime.put(i,this.getOrDefault(i,0.0)+ts.getOrDefault(i,0.0));
        }
        return newTime;
    }

    /**
     * Returns the quotient of the value for each year this TimeSeries divided by the
     * value for the same year in TS. Should return a new TimeSeries (does not modify this
     * TimeSeries).
     *
     * If TS is missing a year that exists in this TimeSeries, throw an
     * IllegalArgumentException.
     * If TS has a year that is not in this TimeSeries, ignore it.
     */
    public TimeSeries dividedBy(TimeSeries ts) {
        TimeSeries newTime = new TimeSeries();
        List<Integer> list1 = this.years();
        for (Integer i : list1) {
            if(!ts.containsKey(i)){
                throw new IllegalArgumentException();
            }else{
                double newdata = this.get(i)/ts.get(i);
                newTime.put(i,newdata);
            }
        }
        return newTime;
    }

    // TODO: Add any private helper methods.
    // TODO: Remove all TODO comments before submitting.
}
