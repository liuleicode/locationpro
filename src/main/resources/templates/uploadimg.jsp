<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>abcd</head>
<body>
<form action="/comment/comment.do?commenttype=2" method="post" enctype="multipart/form-data" name="upload_form">

    <label>选择图片文件</label>

    <input name="imgfile" type="file" accept="image/gif, image/jpeg"/>

    <input name="upload" type="submit" value="上传" />

</form>
</body>

</html>