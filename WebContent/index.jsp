<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/jquery-3.1.0.min.js"></script>
<script src="js/indexActions.js"></script>
<title>Sorting Services</title>
</head>
<body>
	<form name="formSort" id="formSort" enctype="multipart/form-data" method="post">
		<div id="maindiv">
			<h3>Submit File List Books</h3>
			<hr id="hzBar-1" />
			<b>Sorting result</b>
			<div id="sortResult"></div>
			<br/>	
			<div id="divRules">
				<p><b><u>Sort Rules</u></b></p>
				<div class="divAtribs">
			        <input id="chkAuthor" type="checkbox" name="Author" value="0" />Author
			        <span class="spanRules">
				        <input id="rdoAscending1" type="radio" name="Asc1" value="0" checked />Ascending
				        <input id="rdoDescending1" type="radio" name="Desc1" value="1" />Descending
				        <select class="OptionsPriority" id="selAuthorPriori">
						    <option value="1">1</option>
						    <option value="2">2</option>
						    <option value="3">3</option>
						</select>
			        </span>
		        </div>
		        <div class="divAtribs">
		        	<input id="chkTitle" type="checkbox" name="Title" value="1" />Title
		        	<span class="spanRules">
		        		<input id="rdoAscending2" type="radio" name="Asc2" value="0" checked />Ascending
			        	<input id="rdoDescending2" type="radio" name="Desc2" value="1" />Descending
			        	<select class="OptionsPriority" id="selTitlePriori">
						    <option value="1">1</option>
						    <option value="2">2</option>
						    <option value="3">3</option>
						</select>
			        </span>
		        </div>
		        <div class="divAtribs">
		        	<input id="chkEdition" type="checkbox" name="Edition" value="2" />Edition Year
		        	<span class="spanRules">
		        		<input id="rdoAscending3" type="radio" name="Asc3" value="0" checked />Ascending
			        	<input id="rdoDescending3" type="radio" name="Desc3" value="1" />Descending
			        	<select class="OptionsPriority" id="selEditionPriori">
						    <option value="1">1</option>
						    <option value="2">2</option>
						    <option value="3">3</option>
						</select>
			        </span>
		        </div>
		        <br>		        
		        <br/>
	        </div>
	        <br/>
	        <div id="divLabelSelect">Select XML Book File</div>
			<input type="file" name="fUpload" id="fUpload" />
		</div>
	</form>
</body>
</html>