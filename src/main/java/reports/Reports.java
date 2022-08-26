package reports;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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




@WebServlet("/Reports")
public class Reports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String orgao_aut = request.getParameter("orgaoaut");
	String tipo_vei = request.getParameter("tipovei");
	String dataini = request.getParameter("dataini");
	String datafim = request.getParameter("datafim");
	
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
	Date datainif = null;
	Date datafimf = null;
	
	try {
		datainif = formato.parse(dataini);
		datafimf = formato.parse(datafim);
	} catch (ParseException e1) {
		
		e1.printStackTrace();
	}
	
	
	Map<String, Object> parametros = new HashMap<>();
	parametros.put("pOrgaoAuto", orgao_aut);
	parametros.put("pTipoVeiculo", tipo_vei);
	parametros.put("pDataInicio", datainif);
	parametros.put("pDataFinal", datafimf);
		
	Connection con = Conexao.getConnection();
	
	String src = "/home/daniel_souza/apps/relatorios ireports/Multas por tipo de veiculos - periodo.jasper";
	
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
