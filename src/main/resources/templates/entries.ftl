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

	<#include "navbar.ftl" parse=false>

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