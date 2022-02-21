package br.edu.infnet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.infnet.model.domain.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("email"),request.getParameter("senha"));

		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"	<meta charset=\"ISO-8859-1\">" + 
				"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">" + 
				"	<title>Tp01 - Java</title>" + 
				"</head>" + 
				"<body>" + 
				"	<div class=\"container\">" + 
				"		<form action=\"login\" method=\"get\">" + 
				"			<h2>Cadastro realizado com sucesso!!!</h2>"
				);
		
		out.println("<h3>Usuario:" + usuario.getNome()+ "</h3>");
		out.println("<h3>Email:" + usuario.getEmail()+ "</h3>");
		
		out.println(
				"			<button type=\"submit\">Voltar</button>" + 
				"		</form>"); 

		
		out.println(
				"	</div>" + 
				"</body>" + 
				"</html>"
				);		

	}
}