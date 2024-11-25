<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/7.4.1/tinymce.min.js"
            integrity="sha512-TDS3vtbiUCZzBBZO8LFud171Hw+ykrQgkrvjwV+i+XsI0LC46PR4affO+9VbgcR79KreoN7J0HKup9mrle4gRA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
            integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="./js/mail.js"></script>
    <style>
        .preview-image {
            position: relative;
            display: inline-block;
            margin-right: 10px;
            margin-bottom: 10px;
        }

        .preview-image img {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border-radius: 5px;
        }

        .remove-image {
            position: absolute;
            top: -5px;
            right: -5px;
            background-color: red;
            color: white;
            border: none;
            border-radius: 50%;
            width: 25px;
            height: 25px;
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
            font-size: 12px;
        }

        .remove-image i {
            font-size: 14px;
        }

        .set-cover-image {
            position: absolute;
            bottom: 5px;
            left: 50%;
            transform: translateX(-50%);
            /*background-color: green;*/
            /*color: white;*/
            /*border: none;*/
            /*border-radius: 50%;*/
            width: 100%;
            /*height: 25px;*/
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="container mt-5 ">
    <h2 class="text-center">Gửi Mail</h2>
    <form class="mx-5" action="mail/send" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="mailTo" class="form-label">Người nhận:</label>
            <input type="text" class="form-control" id="mailTo" name="mailTo">
            <button type="button" id="ccButton" class="btn btn-secondary mb-3"
                    onclick="toggleField('ccField', 'ccButton')">
                CC
            </button>
            <button type="button" id="bccButton" class="btn btn-secondary mb-3"
                    onclick="toggleField('bccField', 'bccButton')">
                BCC
            </button>
            <button type="button" id="fileButton" class="btn btn-secondary mb-3"
                    onclick="toggleField('fileField', 'fileButton')">
                File
            </button>
        </div>

        <div class="mb-3" id="ccField" style="display: none;">
            <label for="mailCC" class="form-label">CC:</label>
            <input type="text" class="form-control" id="mailCC" name="mailCC">
        </div>
        <div class="mb-3" id="bccField" style="display: none;">
            <label for="mailBCC" class="form-label">BCC:</label>
            <input type="text" class="form-control" id="mailBCC" name="mailBCC">
        </div>
        <div class="mb-3">
            <label for="mailSubject" class="form-label">Tiêu đề:</label>
            <input type="text" class="form-control" id="mailSubject" name="mailSubject">
        </div>
        <div class="mb-3">
            <label for="mailContent" class="form-label">Nội dung:</label>
            <textarea class="form-control" id="mailContent" name="mailContent"></textarea>
        </div>
        <div class="mb-3" id="fileField" style="display: none">
            <label for="mailFile" class="form-label">Tệp:</label>
            <input type="file" class="form-control" id="mailFile" multiple name="mailFile"/>
            <div id="filePreview" class="mt-3 d-flex flex-wrap"></div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>