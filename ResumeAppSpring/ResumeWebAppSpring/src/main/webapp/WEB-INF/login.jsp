<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <section class="w-100 p-4 d-flex justify-content-center pb-4" style="margin-top: 200px">
            <div style="width: 45%">
                <form action="login" method="post">
                    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px; color: dodgerblue">Log in</h3>
                    <div class="form-outline mb-4">
                        <input type="email" class="form-control" id="inputEmail" name="username" placeholder="Email">
                    </div>
                    <div class="form-outline mb-4">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                        <label id="error">${errorMsg}</label>
                        <label id="logout">${msg}</label>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block mb-4" name="btn_login">Login</button>
                </form>
            </div>
        </section>
    </div>
</body>
</html>
