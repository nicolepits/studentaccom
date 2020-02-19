
document.getElementById("thisform").addEventListener('submit', showRank);

function showRank(event){
	console.log(event)
	
	event.preventDefault();
	
 	var id = document.getElementById("thisform").elements[0].value;
 	
	console.log(id);
	const data = {
			id : parseInt(id)
	};
	console.log(data);
	
	var url = new URL('http://localhost:8083/distribassignment/api/student/rank');

	url.search = new URLSearchParams(data).toString();
	
	fetch(url)
	.then((response) => response.json())
	.then((data) => {
		console.log('Success:', data);
		document.getElementById("alert").innerHTML = "Rank retrieved successfully!";
	
		document.getElementById("id1").innerHTML = data.index+ 'th';
		document.getElementById("accept").innerHTML= data.result;
	})
	.catch((error) => {
		console.error('Error:', error);
		document.getElementById("alert").innerHTML = "Sorry, something went wrong. Please enter valid values only.";
	}); 

}