/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.web.services.servlet.articulos;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.Tipo;
import ar.org.centro8.curso.java.web.interfaces.connectors.Connector;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ArticuloRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ralu
 */
@WebServlet(name = "ArticulosAlta", urlPatterns = {"/ArticulosAlta"})
public class ArticulosAlta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        I_ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                /**
                private int id;
                private String nombre;
                private String descripcion;
                private Tipo tipo;
                private EspecieRecomendada especieRecomendada;
                private double costo;
                private double precio;
                private int stock;
                private int stockMinimo;
                private int stockMaximo;
                private String comentario;
                private boolean activo;
                 */
                String nombre=request.getParameter("nombre");
                String descripcion=request.getParameter("descripcion");
                Tipo tipo=Tipo.valueOf(request.getParameter("tipo"));
                EspecieRecomendada especieRecomendada=EspecieRecomendada.valueOf(request.getParameter("especieRecomendada"));
                double costo=Double.parseDouble(request.getParameter("costo"));
                double precio=Double.parseDouble(request.getParameter("precio"));;
                int stock=Integer.parseInt(request.getParameter("stock"));
                int stockMinimo=Integer.parseInt(request.getParameter("stockMinimo"));;
                int stockMaximo=Integer.parseInt(request.getParameter("stockMaximo"));;
                String comentarios=request.getParameter("comentarios");
                boolean activo=Boolean.valueOf(request.getParameter("activo"));
                
                Articulo arti=new Articulo(nombre, descripcion, tipo, especieRecomendada, costo, precio, stock, stockMinimo, stockMaximo, comentarios, activo);
                
                ar.save(arti);
                out.print(arti.getId());
            }catch(Exception e){
                out.println("Error");
                System.out.println(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
