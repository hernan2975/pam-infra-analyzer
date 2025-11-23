package ar.gob.lapampa.infra.reporter;

import ar.gob.lapampa.infra.model.Host;
import ar.gob.lapampa.infra.model.Metric;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvReporter {
    public void writeReport(List<Host> hosts) throws IOException {
        Path dir = Paths.get("reports");
        Files.createDirectories(dir);
        Path file = dir.resolve("infra_report_" + System.currentTimeMillis() + ".csv");

        try (PrintWriter pw = new PrintWriter(file.toFile(), StandardCharsets.UTF_8)) {
            pw.println("host,ip,location,metric,value,unit,status,timestamp");
            for (Host h : hosts) {
                for (Metric m : h.getMetrics()) {
                    pw.printf("%s,%s,%s,%s,%.2f,%s,%s,%d%n",
                        h.getHostname(),
                        h.getIp(),
                        h.getLocation(),
                        m.getName(),
                        m.getValue(),
                        m.getUnit(),
                        m.getStatus(),
                        m.getTimestamp()
                    );
                }
            }
        }
    }
}
