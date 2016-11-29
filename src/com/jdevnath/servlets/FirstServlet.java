package com.jdevnath.servlets;

import com.jdevnath.pozos.*;
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
        
        Person p1 = new Person(name, height, weight);
        
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            StringWriter sw = new StringWriter();
            m.marshal(p1, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        BodyMassIndex bmi = new BodyMassIndex();
        Double bmiResult = -1.0;
        if (weight != "" && height != "") {
        		bmiResult = bmi.calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));
		}
        
        String result = "The bmi for "+name+" is: "+bmiResult;
        System.out.println("---> "+xmlString);
        if (bmiResult != -1.0) {
            request.setAttribute("result", result);
            request.setAttribute("xmlString", xmlString);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
