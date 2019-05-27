<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
		table{
			width: 100%; margin: 0 auto;
		}
		#tb_hd>td{
			background-color: gray; color:white; text-align:center;
		}
		#tb_wrap{
			height:300px; overflow: auto; border:1px solid black; width:90%; margin:0 auto;
		}
		#add{
			width:85%; margin:0 auto;
		}
	</style> 
</head>
<body> 
<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div style="height:70%;">
		<div>
			<div style="margin-left: 20px;"	><h3><li>管理者リスト</li></h3></div>
			<div id="tb_wrap">
				<table id="tb_list" style="text-align:center;" >
					<tr id="tb_hd">
						<td style="width:5%">番号</td>
						<td style="width:10%">グループ</td>
						<td style="width:10%">会社</td>
						<td style="width:15%">部署</td>
						<td style="width:10%">名前</td>
						<td style="width:10%">職位</td>
						<td style="width:10%">性別</td>
						<td style="width:20%">メール</td>
						<td style="width:10%">権限削除</td>
					</tr>
					<c:forEach items="${list}" var="list" varStatus = "status">
						<tr>
							<td>${status.count }</td>
							<td>${list.group }</td>
							<td>${list.com_name }</td>
							<td>${list.dep_name }</td>
							<td>${list.emp_name }</td>
							<td>${list.pos_name1 }</td>
							<td>${list.gender }</td>
							<td>${list.mail }</td>
							<td><input type="button" value="削除"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="margin-left: 20px;"	><h3><li>管理者追加登録</li></h3></div>
			<form>
				<table id="add">
					<tr>
						<td>グループ</td>
						<td><select id="group" name="group" onchange="groupChange(this)">
						<option value="0000">ALL</option>
						<option value="0100">IPSG</option>
						<option value="0200">TSGH</option>
						</select></td>
						<td>会社</td>
						<td><select id="company" name="company">
 						<option value="1000">GCS</option>
						<option value="3000">CSS</option>
						<option value="2000">NCB</option>
						<option value="4000">FOS</option>
						<option value="5000">PSS</option>
						<option value="6000">ISS</option>
						</select></td>
						<td>部署</td>
						<td><select id="department" name="department">
						<option value="dep01">戦略企画室</option>
						<option value="dep04">人事総括本部 対内人事部</option>
						<option value="dep05">人事総括本部 対外人事部</option>
						<option value="dep08">開発事業本部 開発1部</option>
						<option value="dep09">開発事業本部 開発2部</option>
						<option value="dep10">開発事業本部 開発3部</option>
						<option value="dep11">開発事業本部 開発4部</option>
						<option value="dep12">開発事業本部 開発5部</option>
						<option value="dep18">個人契約</option>
						<option value="dep02">営業部</option>
						<option value="dep03">管理部</option>
						</select></td>
						<td>名前</td>
						<td><input type="text" name="name"/></td>
						<td>職位</td>
						<td><select id=position name=position>
							<option value="CHM">会長</option>
							<option value="BO">社長</option>
							<option value="DIR">室長</option>
							<option value="EM">本部長</option>
							<option value="AEM">本部長代理</option>
							<option value="GM">部長</option>
							<option value="AGM">部長代理</option>
							<option value="MG">マネージャー</option>
							<option value="AMG">マネージャー代理</option></td>
						<td>性別</td>
						<td> <input type="radio" name="gender" value="men" /> 男
							  <input type="radio" name="gender" value="women" /> 女 </td>
						<td><input type="submit" value="登録"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function groupChange(e){
	 	var gp_name = ["GCS", "NCB", "CSS", "FOS", "PSS", "ISS"];
	 	var gp_code = ["1000", "2000", "3000", "4000", "5000", "6000"];
		var target = document.getElementById("company");
		target.options.length = 0;
		if(e.value =="0000"){
			for (var i = 0; i < 6; i++) {
			    var opt = document.createElement("option");
			    opt.value = gp_code[i];
			    opt.innerHTML = gp_name[i];
			    target.appendChild(opt); 
			  } 
		}else if(e.value =="0100"){
		 	for (var i = 0; i<3; i++) {
			    var opt = document.createElement("option");
			    opt.value = gp_code[i];
			    opt.innerHTML = gp_name[i];
			    target.appendChild(opt); 
			  } 
		}else{
			for (var i = 3; i<6; i++) {
			    var opt = document.createElement("option");
			    opt.value = gp_code[i];
			    opt.innerHTML = gp_name[i];
			    target.appendChild(opt); 
			  } 
		}
	}
</script>
</html>
