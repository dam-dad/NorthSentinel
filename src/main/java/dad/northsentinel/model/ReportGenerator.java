package dad.northsentinel.model;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JREmptyDataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para generar informes de las partidas jugadas, utilizando JasperReports.
 */
public class ReportGenerator {

    /**
     * Genera un informe PDF con las estadísticas de la partida, incluyendo el número total de enemigos,
     * el número de torretas y el número de disparos realizados.
     *
     * @param totalEnemigos El número total de enemigos durante la partida.
     * @param numTorretas El número de torretas utilizadas durante la partida.
     * @param disparosRealizados El número total de disparos realizados durante la partida.
     */
    public static void generateReport(int totalEnemigos, int numTorretas, int disparosRealizados) {
        try {
            // Cargar el diseño del informe desde un archivo .jrxml
            InputStream jrxmlInputStream = ReportGenerator.class.getClassLoader().getResourceAsStream("reports/partida.jrxml");
            
            // Compilar el diseño del informe a un objeto JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

            // Recopilar los datos necesarios para el informe
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("totalEnemigos", totalEnemigos);
            parameters.put("numTorretas", numTorretas);
            parameters.put("disparosRealizados", disparosRealizados);

            // Llenar y generar el informe con parámetros y utilizando un JREmptyDataSource para evitar ambigüedades
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Definir la ruta completa al archivo PDF, incluyendo el nombre del archivo y su extensión
            String pathToFile = "NorthSentinel/src/main/resources/reports/reportePartida.pdf";

            // Exportar el informe a un archivo PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToFile);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}


