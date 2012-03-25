<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
</head>
<body>
<h1>Hello Spring MVC 3!</h1>
<a href="javascript:getJSONResponse();">New actor request</a>
<br/><br/>
<div id="result">Result will be show here, when request completes...</div>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function() {
        getJSONResponse();
    });

    function getJSONResponse() {
        $.getJSON('<c:url value="/rest/schedule/createActor" />', function(data, responseText) {
            $('#result').html('Result from ajax/json<br/>');
            $('#result').append('JSON: ' + JSON.stringify(data) );
            $('#result').append('<br />');
            console.log(data);
        }).error(function (error) {
                     alert('Fejl!');
                     console.log(error);
                     $('#result').append('Error occurred: ');
                     $('#result').append('Status code: ' + error.status);
                     $('#result').append('Response text: ' + error.responseText);
                 });

    }
</script>
