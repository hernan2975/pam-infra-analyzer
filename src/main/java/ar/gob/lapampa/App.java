package ar.gob.lapampa;

import ar.gob.lapampa.infra.analyzer.CpuAnalyzer;
import ar.gob.lapampa.infra.collector.MockCollector;
import ar.gob.lapampa.infra.model.Host;
import ar.gob.lapampa.infra.model.Metric;
import ar.gob.lapampa.infra.reporter.CsvReporter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Analizador de Infraestructura - La Pampa v1.0 ===");
        System.out.println("Modo simulado (Nivel 3 - Soporte Técnico)");

        MockCollector collector = new MockCollector();
        CpuAnalyzer cpuAnalyzer = new CpuAnalyzer();

        List<Host> hosts = Arrays.asList(
            collector.collect("srv-web-santarosa", "Santa Rosa - Secretaría de Modernización"),
            collector.collect("srv-db-generalpico", "General Pico - Centro de Datos Regional"),
            collector.collect("pc-coop-santarosa", "Santa Rosa - Cooperativa de Servicios")
        );

        for (Host h : hosts) {
            for (Metric m : h.getMetrics()) {
                if ("cpu.load".equals(m.getName())) {
                    m.setStatus(cpuAnalyzer.assess(m.getValue()));
                }
            }
        }

        try {
            new CsvReporter().writeReport(hosts);
            System.out.println("✅ Reporte generado en reports/");
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
