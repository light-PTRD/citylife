<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()%>/"/>
  <title>都市信息网</title>
  <link type="text/css" rel="stylesheet" href="css/style.css">
  <script type="text/javascript">

  </script>
</head>
<body >
	<div align="left">
			
		<table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white" style="text-align:center;margin-left: 10px;">
			
			<tr>
				<td width="690" height="400" align="left" valign="top" bgcolor="#FFFFFF">        
					<!-- 列表显示免费信息 -->
					<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-top:5px">
					
						<tr height="30"> 
							<td style="text-indent:5px" valign="bottom"><font color="#004790"><b>■查看详细信息</b></font>
							<input type="button" value="审核通过" onclick="check()"  <c:if test="${info.infoState == 1}">disabled="disabled" </c:if> >
							<input type="button" value="设置付费" onclick="pay()" <c:if test="${info.infoPayFor == 1}">disabled="disabled" </c:if>>
							</td>
						</tr>            
						<tr height="1">
							<td></td>
						</tr>
						<tr bgcolor="#FAFCF5">
							<td style="border:1px solid">
								<table border="0" width="100%" cellspacing="0" cellpadding="2" style="font-size:14px;">
									<tr height="30">
										<td width="20%" style="text-indent:20px">信息类别：</td>
										<td>${info.typeIntro }</td>
									</tr>
									<tr height="30">
										<td style="text-indent:20px">发布时间：</td>
										<td>${info.infoDate }</td>
									</tr>
									<tr height="30">
										<td style="text-indent:20px">信息标题：</td>
										<td>${info.infoTitle }</td>
									</tr>
									<tr height="30">
										<td colspan="2" style="text-indent:20px">信息内容：</td>
									</tr>
									<tr height="60">
										<td colspan="2" style="text-indent:20px">${info.infoContent }</td>
									</tr>
									<tr height="40">
										<td colspan="2" align="left">
											<table border="0" width="630" cellspacing="0" cellpadding="0"  style="word-break:break-all;font-size:14px;" >
												<tr height="20" align="left">
													<td>联系电话：${info.infoPhone }</td>
													<td>联系人：${info.linkMan }</td>
													<td>E-mail：${info.infoEmail }</td>
												</tr>
											</table>                      
										</td>
									</tr>
									<tr height="40">
										<td align="center" colspan="2" ><a href="javascript:window.history.back(-1)">返回</a></td>
									</tr>                              
								
								</table>
							</td>
						</tr>
					</table>
					<br>
				</td>
			</tr>      
		</table>
		<!-- 页脚 -->
	</div>
</body>

</html>