package ar.gob.lapampa.infra.collector;

import ar.gob.lapampa.infra.model.Host;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MockCollectorTest {

    @Test
    void testCollectReturnsNonNullHost() {
        MockCollector collector = new MockCollector();
        Host host = collector.collect("test", "Test Location");
        assertNotNull(host);
        assertEquals("test", host.getHostname());
        assertNotNull(host.getMetrics());
        assertTrue(host.getMetrics().size() > 0);
    }
}
