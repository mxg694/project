import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * author: mxg
 */
public class test {
    public static void main(String[] args) {
        String str = null;

        BigDecimal decimal = new BigDecimal(0);
        BigDecimal decimal1 = new BigDecimal(1);
        boolean equals = Objects.equals(decimal, null);
        System.out.println(equals);
    }
}
