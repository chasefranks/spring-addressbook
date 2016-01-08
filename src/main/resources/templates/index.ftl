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
			<li><a href="/entry?startsWith=a&count=100">A</a></li>
			<li><a href="/entry?startsWith=b&count=100">B</a></li>
			<li><a href="/entry?startsWith=c&count=100">C</a></li>
			<li><a href="/entry?startsWith=d&count=100">D</a></li>
			<li><a href="/entry?startsWith=e&count=100">E</a></li>
			<li><a href="/entry?startsWith=f&count=100">F</a></li>
			<li><a href="/entry?startsWith=g&count=100">G</a></li>
			<li><a href="/entry?startsWith=h&count=100">H</a></li>
			<li><a href="/entry?startsWith=i&count=100">I</a></li>
			<li><a href="/entry?startsWith=j&count=100">J</a></li>
			<li><a href="/entry?startsWith=k&count=100">K</a></li>
			<li><a href="/entry?startsWith=l&count=100">L</a></li>
			<li><a href="/entry?startsWith=m&count=100">M</a></li>
			<li><a href="/entry?startsWith=n&count=100">N</a></li>
			<li><a href="/entry?startsWith=o&count=100">O</a></li>
			<li><a href="/entry?startsWith=p&count=100">P</a></li>
			<li><a href="/entry?startsWith=q&count=100">Q</a></li>
			<li><a href="/entry?startsWith=r&count=100">R</a></li>
			<li><a href="/entry?startsWith=s&count=100">S</a></li>
			<li><a href="/entry?startsWith=t&count=100">T</a></li>
			<li><a href="/entry?startsWith=u&count=100">U</a></li>
			<li><a href="/entry?startsWith=v&count=100">V</a></li>
			<li><a href="/entry?startsWith=w&count=100">W</a></li>
			<li><a href="/entry?startsWith=x&count=100">X</a></li>
			<li><a href="/entry?startsWith=y&count=100">Y</a></li>
			<li><a href="/entry?startsWith=z&count=100">Z</a></li>
		</ul>

	</div>
	<!-- /container -->

</body>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />
<script src="js/bootstrap.min.js/" />
</body>
</html>