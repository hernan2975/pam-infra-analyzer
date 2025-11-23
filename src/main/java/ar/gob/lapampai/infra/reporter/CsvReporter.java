public class CsvReporter {
    public void writeReport(List<Host> hosts, Path outputPath) throws IOException {
        try (PrintWriter pw = new PrintWriter(outputPath.toFile(), StandardCharsets.UTF_8)) {
            pw.println("host,ip,location,metric,value,unit,status,timestamp");
            for (Host h : hosts) {
                for (Metric m : h.getMetrics()) {
                    pw.printf("%s,%s,%s,%s,%.2f,%s,%s,%d%n",
                        h.getHostname(), h.getIp(), h.getLocation(),
                        m.getName(), m.getValue(), m.getUnit(), m.getStatus(), m.getTimestamp());
                }
            }
        }
    }
}
