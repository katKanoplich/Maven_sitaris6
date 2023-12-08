package com.example.maven;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class EmployeeXmlParser {
    public List<Employee> parseEmployees(String xmlFilePath) {
        List<Employee> employees = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("file:///" + xmlFilePath);

            Element rootElement = document.getDocumentElement();
            NodeList employeeNodes = rootElement.getElementsByTagName("employee");

            for (int i = 0; i < employeeNodes.getLength(); i++) {
                Element employeeElement = (Element) employeeNodes.item(i);

                String id = employeeElement.getElementsByTagName("id").item(0).getTextContent();
                String name = employeeElement.getElementsByTagName("name").item(0).getTextContent();
                int age = Integer.parseInt(employeeElement.getElementsByTagName("age").item(0).getTextContent());
                String speciality = employeeElement.getElementsByTagName("speciality").item(0).getTextContent();
                String category = employeeElement.getElementsByTagName("category").item(0).getTextContent();
                double salary = Double.parseDouble(employeeElement.getElementsByTagName("salary").item(0).getTextContent());
                employees.add(new Employee(id, name, age, speciality, category, salary));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}


