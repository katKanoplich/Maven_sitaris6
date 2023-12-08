<%@ page import="java.util.List" %>
<%@ page import="com.example.maven.Game" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="slyLe.css"/>
</head>
<body>

<div class="wapper">
  <header class="heaader">
    <div class="name">
      <div class="container">
        <div class="name_row">
          <div class="name_body">
            <div class="name_titel">LE MANOIR</div>
            <div class="name_text">Компьютерные игры с душой</div>
          </div>
        </div>
      </div>
    </div>

  </header>
  <div class="content">
    <div class="coontent">
      <div class="container">
        <div class="content_row">
          <div class="content_body1">


            <div class="name">
              <table id='table'>

                <tr >
                <tr >

                  <th colspan="8"><h2>Корзина покупателя</h2></th>

                </tr>
                <th>Название</th>
                <th>Жанр</th>
                <th>Плафора</th>
                <th>Разработчик</th>
                <th>Год реализации</th>
                <th>Цена</th>



                </tr>
                <% for (Game game : (List<Game>) request.getAttribute("games")) { %>--%>
                        <tr>
                          <td><%= game.getName() %>
                          </td>
                          <td><%= game.getGenre() %>
                          </td>
                          <td><%= game.getPlatform() %>
                          </td>
                          <td><%= game.getDeveloper() %>
                          </td>
                          <td><%= game.getReleaseYear() %>
                          </td>
                          <td><%= game.getPrice() %>
                          </td>
                        </tr>
                        <% } %>
                        <tr>
                          <td>
                            Итого:
                          </td>
                          <td>
                            <%= request.getAttribute("totalPrice") %>
                          </td>

                          <td></td>
                        </tr>
                      <tr>
                        <td>
                          Итого с учетом промокода:
                        </td>
                        <td>
                          <%= request.getAttribute("promocodePrice") %>

                        </td>
                      </tr>
              </table>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>