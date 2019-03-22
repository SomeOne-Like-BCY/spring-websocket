<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<script type="text/javascript">


window.onload=function(){
	//var websocket = null;
	
	var ws = new WebSocket("ws://localhost:18080/acitylion/socket");
	// 建立 web socket 连接成功触发事件
	
	ws.onopen = function () {
		var message = { 
		         time: new Date(), 
		         text: "Hello world!", 
		         clientId: "asdfp8734rew" 
		    };
	  ws.send(JSON.stringify(message));
	  alert("数据发送中...");
	};

	// 接收服务端数据时触发事件
	ws.onmessage = function (evt) {
	  var received_msg = evt.data;
	  var bcy =  typeof(received_msg);
	  console.log(received_msg);
	  console.log(bcy);
	  
	};

	// 断开 web socket 连接成功触发事件
	 ws.onclose = function () {
	  alert("连接已关闭...");
	}; 
	
}

</script>
<body>
登录页面
</body>
</html>