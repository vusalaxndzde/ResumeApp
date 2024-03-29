<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/error.css">
</head>
<body>
    <div class="d-flex align-items-center justify-content-center vh-100">
        <div class="error-background">
            <div class="text-center error-text">
                <h1 class="display-1 fw-bold">404</h1>
                <p class="fs-3"><span class="text-danger">Opps!</span> Something went wrong.</p>
                <p class="lead">
                    <%=request.getParameter("msg")%>
                </p>
                <a href="login" class="btn btn-primary">Go Back</a>
            </div>
        </div>
    </div>
</body>
</html>
