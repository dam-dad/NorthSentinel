package dad.northsentinel.model;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

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

            // Exportar el informe a un archivo PDF en el directorio temporal del sistema
            String tempFilePath = System.getProperty("java.io.tmpdir") + "reportePartida.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, tempFilePath);

            // Abrir el archivo PDF exportado con la aplicación predeterminada del sistema
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(tempFilePath));
            }

        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}