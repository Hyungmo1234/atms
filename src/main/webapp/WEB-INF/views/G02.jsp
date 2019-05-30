<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#join {
	text-align: left;
	height: 70%;
	
}

#tab2 {
	margin-top: 20%;
	margin-left: 200%;
	width: 100%;
	
}

#joinbtn1 {
	
}

#joinbtn2 {
	
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="join">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
			<form action="/JoinPOST" id="JoinPOST" method="post">
				<table id="tab1">
					<tr>
						<td><h1>社員登録画面</h1></td>
					</tr>
					<tr>
						<td>
							<table id="tab2">
								<tr>
									<td>ID</td>
									<td>: <input type="text" id="id" name="id"></td>
								</tr>
								<tr>
									<td>パスワード</td>
									<td>: <input type="password" id="password" name="password"></td>
								</tr>
								<tr>
									<td>パスワード確認</td>
									<td>: <input type="password"></td>
								</tr>
								<tr>
									<td>名前</td>
									<td>: <input type="text" id="emp_name" name="emp_name"></td>
								</tr>
								<tr>
									<td>会社</td>
									
									<td>: <select name="com_code" id="com_code">
											<option value="">会社を選択してください。</option>
											<option value="21">PSS</option>
											<option value="11">GCS</option>
											<option value="12">NCB</option>
											<option value="13">CSS</option>
											<option value="22">FOS</option>
											<option value="23">ISS</option>
											</select>
											
									</td>	
									
									
							
								</tr>
								
 								<tr>
									<td>部署</td>
									<td id = "dep_area">: <select name="dep_code" id="dep_code">
											<c:forEach items="${JoinGET}" var="JoinGET">
											<option value="${JoinGET.dep_code}">${JoinGET.dep_name}</option>
											</c:forEach>
											</select>
									</td>
								</tr>
								
								<%-- <jsp:include page="./dddd.jsp"></jsp:include> --%>
								
								<tr>
									<td>職位</td>
									<td>: <select name="pos_code" id="pos_code">
											<option value="">職位を選択してください。</option>
											<option value="ONE">会長</option>
											<option value="PD">社長</option>
											<option value="DIR">室長</option>
											<option value="EM">本部長</option>
											<option value="AEM">本部長代理</option>
											<option value="GM">部長</option>
											<option value="AGM">部長代理</option>
											<option value="MG">マネージャー</option>
											<option value="AMG">マネージャー代理</option>
											<option value="SLD">総括リーダ</option>
											<option value="LD">リーダ</option>
											<option value="MB">メンバー</option>
									</select></td>
								</tr>
								<tr>
									<td>メール</td>
									<td>: <input type="text" id="mail" name="mail"></td>
								</tr>
								<tr>
									<td>性別</td>
									<td>: 男性 <input type="radio" id="gender" name="gender"
										value="1" /> 女性 <input type="radio" id="gender"
										name="gender" value="2" />
									</td>
								</tr>
								<tr>
									<td>入社日 <font size="2" color="red"> ex)20190528</h5> </td>
									<td>: <input type="number" name="entry_date" id="entry_date">
									</td>
								</tr>
								<tr>
									<td>住所</td>
									<td>: <input type="text" name="address" id="address"></td>
								</tr>
								<tr>
									<td rowspan="2">
										<button type="reset" onclick = "check()">キャンセル</button>
										<button  type="submit" id="join" name="join" onclick = "finish()">登録完了</button>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
function check(){
	  if (confirm("本当にキャンセルしますか。") == true){    //확인
	      document.form.submit();
	  		return "G01";
	  }else{   //취소
	      return;
	  }
	}
function finish(){
	  if (confirm("登録が完了しました。") == true){    //확인
	      document.form.submit();
	  }else{   //취소
	      return;
	  }
	}
	
/* function check() { 
	
	var com_name = $("#com_name option:selected").val();
	location ( )
	alert(com_name);
} */
$('#com_code').change(function(){
	$("#dep_code").remove();
	var select = $("#com_code option:selected").val();
    $.ajax({
        url:'G02_1',
        type:'POST',
        data: {
            "com_code": select
        },
        success:function(data){
        	$("#dep_area").append(data);
        }
    })
})


</script>
</html>