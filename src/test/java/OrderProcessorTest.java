import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {

    private final OrderProcessor processor = new OrderProcessor();

    @Test
    void testProcessWithVIP() {
        double result = processor.process(100.0, true);
        assertEquals(80.0, result, 0.001);
    }

    @Test
    void testProcessWithoutVIP() {
        double result = processor.process(100.0, false);
        assertEquals(100.0, result, 0.001);
    }

    @Test
    void testProcessNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.process(-50.0, false);
        });
    }

    @Test
    void testIsValidStatus() {
        assertTrue(processor.isValidStatus("PAID"));
        assertTrue(processor.isValidStatus("SHIPPED"));
        assertTrue(processor.isValidStatus("DELIVERED"));
        assertFalse(processor.isValidStatus("CANCELLED"));
        assertFalse(processor.isValidStatus(null));
    }

    @Test
    void testCalculateTotal() {
        double[] items = {10.0, 20.0, 30.0};
        double total = processor.calculateTotal(items, 0.1);
        assertEquals(66.0, total, 0.001);
    }

    @Test
    void testCalculateTotalEmpty() {
        double[] items = {};
        double total = processor.calculateTotal(items, 0.1);
        assertEquals(0.0, total, 0.001);
    }

    @Test
    void testCalculateTotalNegativePrice() {
        double[] items = {10.0, -5.0};
        assertThrows(IllegalArgumentException.class, () -> {
            processor.calculateTotal(items, 0.1);
        });
    }
}
