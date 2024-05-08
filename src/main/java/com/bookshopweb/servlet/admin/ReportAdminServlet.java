package com.bookshopweb.servlet.admin;

import com.bookshopweb.beans.Category;
import com.bookshopweb.beans.CategorySalesReport;
import com.bookshopweb.beans.Product;
import com.bookshopweb.service.CategoryService;
import com.bookshopweb.service.ProductService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ReportAdminServlet", urlPatterns = {"/admin-report-books-sold", "/category-sales-report"})
public class ReportAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private final ProductService productService = new ProductService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String path = request.getServletPath();
         
         if(path.equals("/admin-report-books-sold")) {
        	 try (OutputStream outputStream = response.getOutputStream()) {
        		 response.setCharacterEncoding("UTF-8");
            	 response.setContentType("application/pdf");
                 response.setHeader("Content-Disposition", "attachment; filename=\"report.pdf\"");
        		 
                 Document document = new Document();
                 PdfWriter.getInstance(document, outputStream);
                 document.open();
                 
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                 Paragraph title = new Paragraph("Thông tin bán sách ngày " + LocalDateTime.now().format(formatter));
                 title.setAlignment(Paragraph.ALIGN_CENTER);
                 document.add(title);
                 document.add(new Paragraph("\n"));
                 
                 
                 String pathtofont = "/Roboto-Black.ttf";
                 String fontname = ReportAdminServlet.class.getResource(pathtofont).toString();
                 FontFactory.register(fontname);
                 BaseFont unicodeBaseFont = BaseFont.createFont("/Roboto-Black.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                 Font unicodeFont = new Font(unicodeBaseFont, 12);
                 
                 PdfPTable table = new PdfPTable(3);
                 
                 table.addCell(new PdfPCell(new Phrase("Tên sách", unicodeFont)));
                 table.addCell(new PdfPCell(new Phrase("Tồn kho", unicodeFont)));
                 table.addCell(new PdfPCell(new Phrase("Đã bán", unicodeFont)));
                 
                 java.util.List<Product> products = productService.getSimpleReportProduct();
                 
                 products.forEach(p -> {
                	 table.addCell(p.getName());
                	 table.addCell(String.valueOf(p.getQuantity()));
                	 table.addCell(String.valueOf(p.getTotalBuy()));
                 });
                 
                 document.add(table);
                 document.close();
             } catch (DocumentException e) {
                 e.printStackTrace();
             }
         }
         else if(path.equals("/category-sales-report")) {
        	 List<CategorySalesReport> categorySalesReports = productService.getAllCategorySalesReport();
        	 List<Category> categories = categoryService.getAll();
        	 request.setAttribute("categorySalesReports", categorySalesReports);
        	 request.setAttribute("categories", categories);
        	 request.getRequestDispatcher("/WEB-INF/views/categorySelesReport.jsp").forward(request, response);
         }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
