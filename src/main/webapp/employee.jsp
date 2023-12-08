<%@ page import="com.example.maven.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>List of Employees</title>
    <link rel=stylesheet
          href="style.css"
          type="text/css">
</head>
<body>

<div class="cont">
    <header class="cont_header">
        <h1>Сотрудники медицинского учреждения</h1>
    </header>
    <div class="cont_body">
        <div class="cont_article">
            <table>
                <th>Список сотрудников</th>
                <tr>
                    <th>Имя</th>
                    <th>Возраст</th>
                    <th>Специальность</th>
                    <th>Категория</th>
                    <th>Зарплата</th>
                </tr>
                <% for (Employee employee : (List<Employee>) request.getAttribute("employees")) { %>
                <tr>
                    <td><%= employee.getName() %>
                    </td>
                    <td><%= employee.getAge() %>
                    </td>
                    <td><%= employee.getSpeciality() %>
                    </td>
                    <td><%= employee.getCategory() %>
                    </td>
                    <td><%= employee.getSalary() %>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td>
                        Всего сотрудников:
                        <%= request.getAttribute("numberOfEmployees") %>
                    </td>
                    <td><%= request.getAttribute("averageAge") %>
                    </td>
                    <td></td>
                    <td></td>
                    <td><%= request.getAttribute("averageSalary") %>
                    </td>
                </tr>

            </table>
        </div>

        <div class="cont_nav">
        </div>

        <div class="cont_aside">
        </div>
    </div>

    <footer class="cont_footer">
    </footer>
</div>

</body>
</html>
