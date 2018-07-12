import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @BeforeAll
    static void initAll() {
        System.out.println("init all...");
    }

    @BeforeEach
    void init() {
        System.out.println("each init...");
    }

    @Test
    public void testSample() {
        assertEquals(2, 1 + 1);
    }
}
