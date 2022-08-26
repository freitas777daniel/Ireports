package reports;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexao.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;




@WebServlet("/Reports2")
public class Reports2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String codmun = request.getParameter("codmun");
	String ano = request.getParameter("ano");
	
	Map<String, Object> parametros = new HashMap<>();
	parametros.put("CodMunicipio", codmun);
	parametros.put("AnoMultas", ano);
		
	Connection con = Conexao.getConnection();
	
	String src = "/home/daniel_souza/apps/relatorios ireports/locais foram aplicadas mais multas pelo Detran por rodovias no ano de 2021.jasper";
	
	JasperPrint jasperPrint = null;
	
	try {
	
	jasperPrint = JasperFillManager.fillReport(src, parametros, con);
	
	} catch (JRException ex) {
		System.out.println(ex);
	}
	
	
	OutputStream saida = response.getOutputStream();
	
	JRExporter exporter = new JRPdfExporter();
	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);
	
    try {
		exporter.exportReport();
	} catch (JRException e) {
		System.out.println(e);
	}
    
	
	}
	
	
}
