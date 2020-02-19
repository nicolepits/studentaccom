document.getElementById("form").addEventListener('submit', changeStudent);

function changeStudent(event){
	
	event.preventDefault();
	
 	var id = document.getElementById("form").elements[0].value;
 	var email = document.getElementById("form").elements[1].value;
 	var phoneNumber = document.getElementById("form").elements[2].value;
 	console.log(id);
 	console.log(email);
 	console.log(phoneNumber);
	const data = {
			id : parseInt(id),
			email : email,
			phoneNumber : phoneNumber
	};
	
	fetch('http://localhost:8083/distribassignment/api/student/change', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	})
	.then((response) => response.json())
	.then((data) => {
		console.log('Success:', data);
		document.getElementById("alert").innerHTML = "Info updated successfuly!";
	})
	.catch((error) => {
		console.error('Error:', error);
		document.getElementById("alert").innerHTML = "Sorry, something went wrong. Please enter valid values only.";
	}); 
}
