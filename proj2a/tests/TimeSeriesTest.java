import ngrams.TimeSeries;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/** Unit Tests for the TimeSeries class.
 *  @author Josh Hug
 */
public class TimeSeriesTest {
    @Test
    public void testConstructor(){
        TimeSeries ts = new TimeSeries();
        assertThat(new TimeSeries(ts,0,0).toString()).isEqualTo("{}");
        ts.put(1900,10.0);
        ts.put(1901,20.0);
        ts.put(1904,30.0);
        TimeSeries ts1 = new TimeSeries(ts,1900,1904);
        System.out.println(ts1.toString());
        assertThat(ts1.toString()).isEqualTo("{1900=10.0, 1901=20.0, 1904=30.0}");


    }

    /**
     * 测试years()
     * Testing strategy
     * TimeSeries: 空 非空
     */
    @Test
    public void testYears(){
        TimeSeries ts =new TimeSeries();
        assertThat(ts.years().toString()).isEqualTo("[]");
        ts.put(1900,20.0);
        ts.put(1901,30.0);
        assertThat(ts.years().toString()).isEqualTo("[1900, 1901]");
        ts.put(1904,20.0);
        ts.put(1902,30.0);
        assertThat(ts.years().toString()).isEqualTo("[1900, 1901, 1902, 1904]");

    }

    /**
     * 测试 data()
     * Testing strategy
     * TimeSeries:Empty notEmpty
     */
    @Test
    public void testData(){
        TimeSeries ts = new TimeSeries();
        assertThat(ts.data().toString()).isEqualTo("[]");
        ts.put(1901,20.0);
        ts.put(1905,30.0);
        ts.put(1902,20.0);
        assertThat(ts.years().toString()).isEqualTo("[1901, 1902, 1905]");
        assertThat(ts.data().toString()).isEqualTo("[20.0, 20.0, 30.0]");

    }

    /**
     * 测试将两个时间表相加得到新的时间表
     * Testing strategy
     * 0.两个都为空
     * 1.一个为空 另一个不空
     * 2.两个表 时间不相交
     * 3.两个表时间有相交的部分
     */
    @Test
    public void testPuls(){
        TimeSeries ts = new TimeSeries();
        TimeSeries ts1 = new TimeSeries();
        //0.Expected:"[]"
        TimeSeries newTime = ts.plus(ts1);
        assertThat(newTime.years().toString()).isEqualTo("[]");
        //1.Expected:{1901=20.0,1903=30.0}
        ts.put(1901,20.0);
        ts.put(1903,30.0);
        TimeSeries newTime1 = ts.plus(ts1);
        assertThat(newTime1.toString()).isEqualTo("{1901=20.0, 1903=30.0}");
        //2.Expected:{1901=20.0, 1902=40.0, 1903=30.0, 1905=50.0}
        ts1.put(1902,40.0);
        ts1.put(1905,50.0);
        TimeSeries newTime2 = ts.plus(ts1);
        assertThat(newTime2.toString()).isEqualTo("{1901=20.0, 1902=40.0, 1903=30.0, 1905=50.0}");
        //3.Expected:{1901=50.0, 1902=40.0, 1903=70.0, 1905=50.0}
        ts1.put(1901,30.0);
        ts1.put(1903,40.0);
        TimeSeries newTime3 = ts.plus(ts1);
        assertThat(newTime3.toString()).isEqualTo("{1901=50.0, 1902=40.0, 1903=70.0, 1905=50.0}");
    }

    /**
     * 测试个时间表相除后得到的新时间表
     * Testing strategy
     * 0.两个表均为空
     * 1.前者为空 后者不空
     * 2.前者不空 后者为空
     * 3.两者均不空 两者年份有交集
     * 4.两者年份无交集
     */
    @Test
    public void testDividedBy(){
        //0.
        TimeSeries ts1 = new TimeSeries();
        TimeSeries ts2 = new TimeSeries();
        TimeSeries newTime1 = ts1.dividedBy(ts2);



    }
    @Test
    public void testFromSpec() {
        TimeSeries catPopulation = new TimeSeries();
        catPopulation.put(1991, 0.0);
        catPopulation.put(1992, 100.0);
        catPopulation.put(1994, 200.0);

        TimeSeries dogPopulation = new TimeSeries();
        dogPopulation.put(1994, 400.0);
        dogPopulation.put(1995, 500.0);

        TimeSeries totalPopulation = catPopulation.plus(dogPopulation);
        // expected: 1991: 0,
        //           1992: 100
        //           1994: 600
        //           1995: 500

        List<Integer> expectedYears = new ArrayList<>
                (Arrays.asList(1991, 1992, 1994, 1995));

        assertThat(totalPopulation.years()).isEqualTo(expectedYears);

        List<Double> expectedTotal = new ArrayList<>
                (Arrays.asList(0.0, 100.0, 600.0, 500.0));

        for (int i = 0; i < expectedTotal.size(); i += 1) {
            assertThat(totalPopulation.data().get(i)).isWithin(1E-10).of(expectedTotal.get(i));
        }
    }

    @Test
    public void testEmptyBasic() {
        TimeSeries catPopulation = new TimeSeries();
        TimeSeries dogPopulation = new TimeSeries();

        assertThat(catPopulation.years()).isEmpty();
        assertThat(catPopulation.data()).isEmpty();

        TimeSeries totalPopulation = catPopulation.plus(dogPopulation);

        assertThat(totalPopulation.years()).isEmpty();
        assertThat(totalPopulation.data()).isEmpty();
    }
} 