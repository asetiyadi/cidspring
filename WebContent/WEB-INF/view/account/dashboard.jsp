<div ng-controller="AccountController">
	<p>Progress = {{progress}}</p>
	<div ng-hide="isError">
		<h3>Account Details</h3>
		
		<div>
			{{account.accountNumber}}<br>
			{{account.customer.firstName}} {{account.customer.lastName}}<br>
			{{account.customer.address.address1}}<br>
			{{account.customer.address.city}}, {{account.customer.address.state}} {{account.customer.address.zip}}<br>
			SSN: {{account.customer.ssn}}<br>
			DOB: {{account.customer.dob | date: 'MM/dd/yyyy'}}
		</div>
	
		<h3>LOS Details</h3>
		
		<div>
			<span ng-bind-template="Device Id: {{account.subscribers[0].device.deviceId}}"></span><br>
			MDN: {{account.subscribers[0].mdn}}
		</div>
	</div>
	
	<div ng-show="isError">
		Data = {{errorObj.data}}<br/>
        Error Status = {{errorObj.status}}<br/>
        Status Desc = {{errorObj.statusText}}<br/>
        Url = {{errorObj.restUrl}}
	</div>
</div>
