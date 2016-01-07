<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring Addressbook</title>

<!-- Bootstrap -->
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
<style type="text/css">
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
			<div class="panel-heading">New Entry</div>
			<div class="panel-body">
				<form method="post" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">First Name</label> 
						<div class="col-sm-4">
							<input type="text" name = "firstName" class="form-control" placeholder="John">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name</label> 
						<div class="col-sm-4">
							<input type="text" name="lastName" class="form-control" placeholder="Doe">
						</div>				
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">House Number</label> 
						<div class="col-sm-4">
							<input type="text" name="address.number" class="form-control" placeholder="123">
						</div>				
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Street</label> 
						<div class="col-sm-4">
							<input type="text" name="address.street" class="form-control" placeholder="Anyroad Rd.">
						</div>				
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">City</label> 
						<div class="col-sm-4">
							<input type="text" name="address.city" class="form-control" placeholder="Anywhere">
						</div>
						
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">State</label>
						<div class="col-sm-4">
							<select name="address.state" class="form-control">
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="DC">District Of Columbia</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Nevada</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virginia</option>
							<option value="WA">Washington</option>
							<option value="WV">West Virginia</option>
							<option value="WI">Wisconsin</option>
							<option value="WY">Wyoming</option>
						</select>
						</div>
						
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Zip</label> 
						<div class="col-sm-4">
							<input type="text" name="address.postalCode" class="form-control" placeholder="12345">
						</div>				
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Phone</label> 
						<div class="col-sm-4">
							<input type="text" name="phoneNumber.number" class="form-control" placeholder="(123) 456-7890">
						</div>
						
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Email</label> 
						<div class="col-sm-4">
							<input type="text" name="emailAddress.address" class="form-control" placeholder="johndoe@example.com">
						</div>				
					</div>
				
					<div class="col-sm-4 col-sm-offset-2">			
						<button type="submit" class="btn btn-primary pull-right">Submit</button>
					</div>
				</form>	
			</div>
		</div>

		
		
		 	

	</div><!-- end container -->
	
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script src="/js/bootstrap.min.js/" type="text/javascript" ></script>

</body>
</html>