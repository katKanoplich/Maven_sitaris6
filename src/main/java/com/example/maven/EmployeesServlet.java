package com.example.maven;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

@WebServlet(name = "EmployeesServlet", value = "/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
    private EmployeeXmlParser employeeXmlParser;

    @Override
    public void init() throws ServletException {
        employeeXmlParser = new EmployeeXmlParser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String xmlFilePath = getServletContext().getRealPath("/WEB-INF/classes/employees.xml");
        List<Employee> employees = employeeXmlParser.parseEmployees(xmlFilePath);

        Statistics statistics = new Statistics();
        int num = statistics.calculateNumberOfEmployees(employees);
        int averageAge = statistics.averageAge(employees);
        double averageSalary = statistics.averageSalary(employees);

        request.setAttribute("employees", employees);
        request.setAttribute("numberOfEmployees", num);
        request.setAttribute("averageAge", averageAge);
        request.setAttribute("averageSalary", averageSalary);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee.jsp");
        dispatcher.forward(request, response);

    }
}