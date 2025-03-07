package Servlet;

import Controller.ArticuloController;
import Controller.VentaController;
import Model.ArticuloModel;
import Model.VentaModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MostrarVentasServlet extends HttpServlet {
    
    VentaController ventaController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarVentasServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MostrarVentasServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ventaLista(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void ventaLista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ventaController = new VentaController();

        List<VentaModel> ventas = ventaController.getAllVentas();
        request.setAttribute("ventaslista", ventas);
        request.getRequestDispatcher("/pages/VentasRealizadas/ventas.jsp").forward(request, response);
    }
}
