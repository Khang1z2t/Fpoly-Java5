<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <form action="/result" method="get">
                <div class="mb-3">
                    <label for="message" class="form-label">Message</label>
                    <input type="text" class="form-control" id="message" name="message">
                </div>
                <div class="mb-3">
                    <label for="session" class="form-label">Sesion</label>
                    <input type="text" class="form-control" id="session" name="session">
                </div>
                <div class="mb-3">
                    <label for="country" class="form-label">Countries</label>
                    <select class="form-select" id="country" name="country">
                        <option value="VietNam">Vietnam</option>
                        <option value="USA">USA</option>
                        <option value="Japan">Japan</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div>
        </div>
    </div>
</body>
</html>