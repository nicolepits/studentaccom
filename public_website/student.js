window.addEventListener('DOMContentLoaded', (event) => {
    console.log('DOM fully loaded and parsed');

document.getElementById("myForm").addEventListener('submit', submitApp);

});
function submitApp(event){
	console.log(event)
	
	event.preventDefault();
	
 	var id = document.getElementById("myForm").elements[0].value;
	var income = document.getElementById("myForm").elements[1].value;
	var permanentResidency = document.getElementById("myForm").elements[2].value;
	var yearsOfStudies = document.getElementById("myForm").elements[3].value;
	var yearsOfAccomodation = document.getElementById("myForm").elements[4].value;
	var numberOfSiblings = document.getElementById("myForm").elements[5].value;
	var cityOfStudies = document.getElementById("myForm").elements[6].value;
	
	const data = {
			id : parseInt(id),
			income : parseInt(income),
			permanentResidency : permanentResidency,
			yearsOfStudies : parseInt(yearsOfStudies),
			yearsOfAccomodation : parseInt(yearsOfAccomodation),
			numberOfSiblings : parseInt(numberOfSiblings),
			cityOfStudies : cityOfStudies
	};
	console.log(data);
	
	fetch('http://localhost:8083/distribassignment/api/student/add', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	})
	.then((response) => response.json())
	.then((data) => {
		console.log('Success:', data);
		document.getElementById("alert").innerHTML = "Form submitted successfuly!";
	})
	.catch((error) => {
		console.error('Error:', error);
		document.getElementById("alert").innerHTML = "Sorry, something went wrong. Please enter valid values only.";
	}); 
	

}


