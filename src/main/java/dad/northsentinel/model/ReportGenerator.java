package dad.northsentinel.model;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JREmptyDataSource;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    public static void generateReport(int totalEnemigos, int numTorretas, int disparosRealizados) {
        try {
            InputStream jrxmlInputStream = ReportGenerator.class.getClassLoader().getResourceAsStream("reports/partida.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("totalEnemigos", totalEnemigos);
            parameters.put("numTorretas", numTorretas);
            parameters.put("disparosRealizados", disparosRealizados);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Obtener la ruta relativa al directorio de recursos del proyecto
            String relativePath = "src/main/resources/pdf"; // Ruta relativa dentro de tu proyecto
            File directory = new File(relativePath);

            // Crear el directorio si no existe
            if (!directory.exists()) {
                directory.mkdirs(); // Creará el directorio 'pdf' si no existe
            }

            // Construir la ruta completa al archivo PDF, usando la ruta relativa
            String pathToFile = directory.getAbsolutePath() + File.separator + "reportePartida.pdf";

            // Exportar el informe a un archivo PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToFile);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
