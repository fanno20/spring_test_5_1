<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#p2").click(function(){
			$.ajax({
				url: "./xmltest",
				type: "GET",
				success: function(data){
					alert(data);
					alert($(data).find("writer").text());
				}
			});
		});
		
		$("#p1").click(function(){
			$.ajax({
				url:"./jsontest",
				type: "GET",
				success: function(result){
					for(var i=0;i<result.length;i++){
						alert(result[i].writer);
					}
					/* $(result).each(function(){
						alert(this.writer);
					}); */
					/* alert(result);
					alert(result.writer); */
				}
			});
		});
	})
</script>
</head>
<body>

<input type="button" id="p1" value="json_click">
<input type="button" id="p2" value="xml_click">

</body>
</html>