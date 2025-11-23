package ar.gob.lapampa.infra.analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CpuAnalyzerTest {

    @Test
    void testCpuLoadAssessment() {
        CpuAnalyzer analyzer = new CpuAnalyzer();
        assertEquals("OK", analyzer.assess(50.0));
        assertEquals("WARNING", analyzer.assess(80.0));
        assertEquals("CRITICAL", analyzer.assess(95.0));
    }
}
