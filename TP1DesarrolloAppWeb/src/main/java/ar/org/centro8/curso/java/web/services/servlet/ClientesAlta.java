package ar.org.centro8.curso.java.web.services.servlet;

import ar.org.centro8.curso.java.web.entities.Cliente;
import ar.org.centro8.curso.java.web.entities.Direccion;
import ar.org.centro8.curso.java.web.enums.TipoDocumento;
import ar.org.centro8.curso.java.web.interfaces.connectors.Connector;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.web.repositories.list.ClienteRepositoryFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientesAlta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        I_ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                //cliente
                String nombre=request.getParameter("nombre");
                String apellido=request.getParameter("apellido");
                String fenaci=request.getParameter("fenaci");
                TipoDocumento tipoDocumento=TipoDocumento.valueOf(request.getParameter("tipoDocumento"));
                String numeroDocumento=request.getParameter("numeroDocumento");
                String telefono=request.getParameter("telefono");
                String email=request.getParameter("email");
                String comentarios=request.getParameter("comentarios");
                
                //direccion
                String calle=request.getParameter("calle");
                int numero=Integer.parseInt(request.getParameter("numero"));
                String piso=request.getParameter("piso");
                String depto=request.getParameter("depto");
                String torre=request.getParameter("torre");
                String codigoPosta=request.getParameter("codigoPostal");
                String ciudad=request.getParameter("ciudad");
                String provincia=request.getParameter("provincia");
                String pais=request.getParameter("pais");
                
                Direccion dir=new Direccion(calle, numero, piso, depto, torre, codigoPosta, ciudad, provincia, pais);
                Cliente cliente=new Cliente(nombre, apellido, fenaci, tipoDocumento, numeroDocumento, telefono, email, dir, comentarios);
                
                cr.save(cliente);
                out.println(cliente.getId());
                
                //http://localhost:8084/server/ClientesAlta?nombre=Juan&apellido=Perez&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=11111&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x
                //http://localhost:8084/server/ClientesAlta?nombre=Ana&apellido=Garcia&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=11111&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x
                //http://localhost:8084/server/ClientesAlta?nombre=Lorena&apellido=Broca&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=11111&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x
                //http://localhost:8084/server/ClientesAlta?nombre=Jose&apellido=Gomez&fenaci=2005/05/05&tipoDocumento=DNI&numeroDocumento=11111&telefono=222222&email=nada@nada&calle=Viel&numero=10&piso=x&depto=x&codigoPostal=1111&ciudad=CABA&provincia=CABA&pais=Argentina&comentarios=x
        
            } catch (Exception e) {
                out.println("error");
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
