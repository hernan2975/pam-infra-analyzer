public class CpuAnalyzer {
    public String assess(double load) {
        if (load > 90) return "CRITICAL";
        if (load > 75) return "WARNING";
        return "OK";
    }
}
