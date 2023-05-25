<%@ page import="com.petermann.studentweb.models.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Directory</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/bb20ef855a.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="header.jsp" />
    <form action="student" method="post">
        <div class="container">
            <div class="row">
                <div class="input-group m-3 col">
                    <label for="firstName" class="input-group-text">First Name</label>
                    <input id="firstName" class="form-control" name="firstName" />
                </div>
                <div class="input-group m-3 col">
                    <label for="lastName" class="input-group-text">Last Name</label>
                    <input id="lastName" class="form-control" name="lastName" />
                </div>
                <div class="input-group m-3 col">
                    <label for="grade" class="input-group-text">Grade</label>
                    <input id="grade" class="form-control" name="grade" type="number" min="1" max="12" />
                </div>
            </div>
            <div class="row">
                <div class="input-group m-3 col">
                    <label for="email" class="input-group-text"><i class="fa-solid fa-at"></i></label>
                    <input id="email" class="form-control" name="email" type="email" />
                </div>
                <div class="input-group m-3 col">
                    <label for="phone" class="input-group-text"><i class="fa-solid fa-phone"></i></label>
                    <input id="phone" class="form-control" name="phone" type="number" />
                </div>
                <div class="col m-3"></div>
            </div>
            <button class="btn btn-success m-3" type="submit"><i class="fa-solid fa-plus"></i> Add</button>
        </div>
    </form>
    <hr />
    <% @SuppressWarnings("unchecked")
    ArrayList<Student> students = (ArrayList<Student>)request.getSession().getAttribute("students"); %>
    <div class="container align-contents-center">
        <table class="table table-striped m-3">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Grade</th>
                <th>Email</th>
                <th>Phone</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% for(Student student : students) { %>
            <tr class="align-middle">
                <td>
                    <%= student.getFirstName() %>
                </td>
                <td>
                    <%= student.getLastName() %>
                </td>
                <td>
                    <%= student.getGrade() %>
                </td>
                <td>
                    <%= student.getEmail() %>
                </td>
                <td>
                    <%= student.getPhone() %>
                </td>
                <td>
                    <button class="btn btn-danger delete" data-index="<%= students.indexOf(student) %>"><i class="fa fa-trash"></i></button>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
<script src="student.js"></script>
</html>
