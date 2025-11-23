package ar.gob.lapampa.infra.analyzer;

public class DiskAnalyzer {
    public String assess(double usedPercent) {
        if (usedPercent > 95) return "CRITICAL";
        if (usedPercent > 85) return "WARNING";
        return "OK";
    }
}
