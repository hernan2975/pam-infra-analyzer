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

        // Actualizar status con análisis
        for (Host h : hosts) {
            for (Metric m : h.getMetrics()) {
                if ("cpu.load".equals(m.getName())) {
                    m.setStatus(cpuAnalyzer.assess(m.getValue()));
                }
            }
        }

        try {
            Path out = Path.of("reports", "infra_report_" + System.currentTimeMillis() + ".csv");
            Files.createDirectories(out.getParent());
            new CsvReporter().writeReport(hosts, out);
            System.out.println("✅ Reporte generado: " + out.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Error al generar reporte: " + e.getMessage());
        }
    }
}
