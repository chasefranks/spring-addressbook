<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring Addressbook</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>
<body>

	<#include "navbar.ftl" parse=false>

	<div class="container">

		<p> Add addresses<br>Look them up<br>Pretty simple!</p>

		<ul class="nav nav-pills nav-stacked">
			<#if entryCountList??>
				<#list entryCountList as entryCount>
					<li><a data-toggle="tooltip" data-placement="right" title="${entryCount.count} entries" href="/entry?startsWith=${entryCount.letter}&count=100">${entryCount.letter}</a></li>
				</#list>
    		</#if>			
		</ul>

	</div>
	<!-- /container -->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />
<script src="js/bootstrap.min.js/" />
<script>
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
</script>
</body>
</html>