<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Spring Addressbook</title>
	
	<!-- Bootstrap -->
	<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
	<style>
	body {
		padding-top: 60px;
		/* 60px to make the container go all the way to the bottom of the topbar */
	}
	</style>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Spring Addressbook</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ><a href="/index.html">Home</a></li>
            <li><a href="/entry/add">Add Entry</a></li>            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
    
    	<div class="panel panel-default">
    		<div class="panel-heading">${entryListHeader}</div>
    		<div class="panel-body">
    			<table class="table table-striped">
    				<tr>
    					<th>First Name</th>
    					<th>Last Name</th>
    					<th>Address</th>
    					<th>City</th>
    					<th>State</th>
    					<th>Zip</th>
    					<th>Phone</th>
    					<th>Email</th>
    				</tr>
    				<#if entryList??>
    				<#list entryList as entry>
					<tr>
    					<td>${entry.firstName}</td>
    					<td>${entry.lastName}</td>
    					<#if entry.address??>
	    					<td>
	    					<#if entry.address.number?? && entry.address.street??>
	    						${entry.address.number} ${entry.address.street}
	    					</#if>
	    					</td>
	    					<td>
	    					<#if entry.address.city??>
    							${entry.address.city}
    						</#if>    													
	    					</td>
	    					<td>
	    					<#if entry.address.state??>
    							${entry.address.state}
    						</#if>    													
	    					</td>
	    					<td>
	    					<#if entry.address.postalCode??>
    							${entry.address.postalCode}
    						</#if>    													
	    					</td>    					
    					<#else>
	    					<!-- no address specifed -->
	    					<td></td>
	    					<td></td>
	    					<td></td>
	    					<td></td>    					
    					</#if>
    					<td>
    					<#if entry.phoneNumber?? >
    						${entry.phoneNumber.number}
    					</#if>    					
    					</td>
    					<td>
    					<#if entry.emailAddress?? >
    						${entry.emailAddress.address}
    					</#if> 
    					</td>    					
    				</tr>					
    				</#list>
    				</#if>    				
    			</table>	
    		</div>
    	</div>      
      
    </div> <!-- /container -->   

  </body>
  
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script src="/js/bootstrap.min.js/" type="text/javascript" ></script>
</body>
</html>