

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportingInsightsTest {

    @Test
    void productDefect() {
        // FAILED -> Product defects
        assertEquals(200, 500);
    }

    @Test
    void flakyTimeout() throws TimeoutException {
        // BROKEN + message contains "timeout"
        throw new TimeoutException("Request timeout");
    }

    @Test
    void flakyStaleElement() {
        // BROKEN + message contains "stale element"
        throw new RuntimeException("stale element");
    }

    @Test
    void brokenTest() {
        // BROKEN -> Test defects (doesn't match flaky regex)
        throw new NullPointerException("Something went wrong");
    }
}