<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="description" content="Male_Fashion Template">
<meta name="keywords" content="Male_Fashion, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Male-Fashion | Template</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
      rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="/static/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="/static/css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="/static/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="/static/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<style>
#main{
    min-height: 100vh;
}
</style>
<body>
<div><tiles:insertAttribute name="navbar" /></div>
<div id="main"><tiles:insertAttribute name="body" /></div>
<div><tiles:insertAttribute name="footer" /></div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
  crossorigin="anonymous"></script>
</body>
