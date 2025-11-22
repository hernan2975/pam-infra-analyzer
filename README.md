# pam-infra-analyzer

Herramienta de análisis de infraestructura para equipos de soporte técnico Nivel 3.  
Diseñada para entornos con recursos limitados, conectividad intermitente y heterogeneidad tecnológica — típicos en organismos públicos y cooperativas de la provincia de La Pampa.

## Características

- Recolección simulada de métricas clave:  
  • Carga de CPU  
  • Uso de disco  
  • Latencia de red local  
  • Estado de servicios críticos  
- Modo *offline-first*: no requiere conexión a internet ni agentes externos  
- Generación automática de reportes en CSV (compatible con planillas y herramientas locales)  
- Soporte para múltiples ubicaciones: Santa Rosa, General Pico, Eduardo Castex, etc.  
- Extensible: interfaz para integrar recolectores reales (SNMP, WMI, SSH)  

## Requisitos

- Java 17 o superior  
- Maven 3.6+ (solo para compilación)  
- 64 MB de espacio libre (aplicación autocontenida < 5 MB)

## Instalación y uso

### Compilación
```bash
git clone https://github.com/tu-usuario/pam-infra-analyzer.git
cd pam-infra-analyzer
mvn clean package
```

### Ejecución
```bash
java -jar target/pam-infra-analyzer-1.0.0.jar
```

Salida esperada:
```
=== Analizador de Infraestructura - La Pampa v1.0 ===
Modo simulado (Nivel 3 - Soporte Técnico)
✅ Reporte generado: reports/infra_report_1732320000000.csv
```

El archivo CSV generado contiene:
```
host,ip,location,metric,value,unit,status,timestamp
srv-web-santarosa,10.0.1.15,Santa Rosa - Secretaría de Modernización,cpu.load,15.30,%,OK,1732320000000
srv-web-santarosa,10.0.1.15,Santa Rosa - Secretaría de Modernización,disk.root.used,72.10,%,WARNING,1732320000000
...
```

## Modo de empleo en campo

1. Ejecutar en servidor o estación de trabajo local  
2. Copiar el archivo CSV generado a una unidad removible  
3. Analizar con planilla local (Excel, LibreOffice) o importar a sistema de monitoreo existente  
4. Priorizar intervenciones según columna `status` (OK / WARNING / CRITICAL)

## Extensibilidad

Para usar con infraestructura real:  
- Implementar `ar.gob.lapampa.infra.collector.LinuxCollector` usando `ProcessBuilder` + comandos (`df`, `top`, `ping`)  
- Implementar `WindowsCollector` mediante JNA o WMI wrappers  
- Reemplazar `MockCollector` en `App.java`

## Licencia

MIT — Uso libre en organismos públicos, cooperativas y entidades sin fines de lucro de La Pampa.

> Proyecto desarrollado con enfoque en autonomía técnica, descentralización y operatividad real en contextos con limitaciones de conectividad y recursos
