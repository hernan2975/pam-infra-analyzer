package ar.gob.lapampa.infra.analyzer;

public class NetworkLatencyAnalyzer {
    public String assess(double latencyMs) {
        if (latencyMs > 200) return "CRITICAL";
        if (latencyMs > 100) return "WARNING";
        return "OK";
    }
}
