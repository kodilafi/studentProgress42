<%--
  Created by IntelliJ IDEA.
  User: Phaincat Epwell
  Date: 20.04.2024
  Time: 5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">

    <title>student-creating</title>
</head>
    <body>
        <aside class="navigation">
<%--            <a href="#" class="navigation-item">на главную</a>--%>
<%--            <a href="#" class="navigation-item">назад</a>--%>

            <form action="../index.jsp" method="get">
                <input type="submit" class="student-btn" value="на главную"/>
            </form>
            <form action="students" method="get">
                <input type="submit" class="student-btn" value="назад"/>
            </form>
        </aside>

        <main class="main">
            <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
            <h2 class="heading-secondary">для создания студента заполните все поля и нажмите кнопку "создать"</h2>

            <form action="/students-create" method="post">
                <table>
                    <tr>
                        <td class="cell1" align="right"> <h3>фамилия</h3></td>
                        <td> <input name="surname" type="text" id="name"></td>
                    </tr>
                </table>
                <br>
                <table>
                    <tr>
                        <td class="cell1" align="right"><h3>имя</h3></td>
                        <td> <input name="name" type="text" id="name"> </td>
                    </tr>
                </table>
                <br>
                <table>
                    <tr>
                        <td class="cell1" align="right"> <h3>группа</h3></td>
                        <td><input name="groups" type="text" id="name"> </td>
                    </tr>
                </table>
                <br>
                <table>
                    <tr>
                        <td class="cell1" align="right"> <h3>дата поступления</h3></td>
                        <td> <input name="date" type="text" id="name"></td>
                    </tr>
                </table>
                <br>

                <input type="submit" value=" создать" class="field">
                <c:if test="${message eq 1}">
                    <h4>Поля не должны быть пустыми!</h4>
                </c:if>

            </form>
        </main>
        <aside class="logout">
            <a href="#" class="logout-btn">logout</a>
        </aside>
    </body>
</html>