package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImcServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String poidsString = request.getParameter("poids");
            String tailleString = request.getParameter("taille");

            if (poidsString == null || tailleString == null) {
                out.println("Veuillez fournir les paramètres poids et taille.");
                return; 
            }

             
            double poids = Double.parseDouble(poidsString);
            double taille = Double.parseDouble(tailleString);

            
            double imc = poids / (taille * taille);

           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calcul IMC</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Poids: " + poids + " kg</p>");
            out.println("<p>Taille: " + taille + " m</p>");
            out.println("<p>IMC: " + imc + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}