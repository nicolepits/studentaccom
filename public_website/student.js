window.addEventListener('DOMContentLoaded', (event) => {
    console.log('DOM fully loaded and parsed');

document.getElementById("myForm").addEventListener('submit', submitApp);
/*

document.getElementById("showBtn").addEventListenet('submit', showRank);
*/
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
	
	fetch('http://localhost:8083/distributed/api/student/add', {
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
	
/*
 * var HttpClient = function(){ this.get = function(aUrl, aCallback) { var
 * anHttpRequest = new XMLHttpRequest(); anHttpRequest.onreadystatechange =
 * function(){ if(anHttpRequest.readyState == 4 && anHttpRequest.status ==200)
 * aCallback(anHttpRequest.responseText);
 *  } anHttpRequest.open("POST",aUrl, true); anHttpRequest.send(null); } }
 * 
 * var theURL = 'http://localhost:8083/distributed/api/student/add'; var client =
 * new HttpClient(); client.get(theurl, function(response){ var response1 =
 * JSON.parse(response); document.getElementById("application").innerHTML =
 * response1.application; });
 */
}

function changeStudent(event){
	
	event.preventDefault();
	
 	var id = document.getElementById("form").elements[0].value;
 	var email = document.getElementById("form").elements[1].value;
 	var phoneNumber = document.getElementById("form").elements[2].value;
 	
	const data = {
			id : id,
			email : email,
			phone_number : phoneNumber
	};
	
	fetch('http://localhost:8083/distributed/api/student/change', {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	})
	.then((response) => response.json())
	.then((data) => {
		console.log('Success:', data);
	})
	.catch((error) => {
		console.error('Error:', error)
	}); 
}


function showRank(event){
	event.preventDefault();
	
	var id = document.getElementById("thisform").elements[0].value;
	
	// Assemble the full URL
	  url = 'http://localhost:8083/distributed/api/student/rank/?id=' + id;

	  
	// Use fetch() to make the request to the API
	  fetch(url).then(function(result) {
	    return result.json();
	  }).then(function(json) {
	    displayResults(json);
	  });
}

function displayResults(json) {
	  
	// Here we convert JSON to object 
	  var obj = JSON.parse(jsonobj); 
	  alert('Done');
	  document.getElementById("id1").innerHTML = "Hello";
	     
	}
