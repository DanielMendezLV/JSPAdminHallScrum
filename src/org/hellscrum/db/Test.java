package org.hellscrum.db;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.Date;

//import org.hellscrum.bean.producto;
//import org.pensamiento.manejador.ManejadorProducto;
public class Test extends HttpServlet {
 
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            // Get the text that will be added to the PDF
            String text = request.getParameter("text");
            if (text == null || text.trim().length() == 0) {
                 text = "You didn't enter any text.";
            }
            // step 1
            Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            // step 3
            document.open();
            // step 4
            java.util.Date fecha = new Date();
            System.out.println (fecha.getDay());
            System.out.println (fecha.getMonth());
            document.add(new Paragraph("Registro: "+fecha));
            document.add(new Paragraph("."));
            document.add(new Paragraph("."));
            document.add(new Paragraph("."));
            document.add(new Paragraph("."));
            PdfPTable tabla = new PdfPTable(3);
            int cont=0;
         	tabla.addCell("#");
        	tabla.addCell("Producto");
        	tabla.addCell("Valor");
        	int valor=0;
            /*for(producto a:ManejadorProducto.getInstancia().listado2()){
            	cont++;
            	tabla.addCell(cont+"");
            	tabla.addCell(a.getNombre());
            	tabla.addCell(a.getValor());
            	valor=Integer.parseInt(a.getValor())+valor;
            }*/
            document.add(tabla);
            document.add(new Paragraph("_________________________________"));
            document.add(new Paragraph("Total: ________________"+valor));
            /*document.add(new Paragraph(String.format(
                "You have submitted the following text using the %s method:",
                request.getMethod())));
            document.add(new Paragraph(text));*/
            // step 5
            document.close();
 
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
        catch(DocumentException e) {
            throw new IOException(e.getMessage());
        }
    }
    private static final long serialVersionUID = 6067021675155015602L;
    
}