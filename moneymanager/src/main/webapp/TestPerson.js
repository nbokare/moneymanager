/**
 * 
 */
function test1(){
    $.ajax({
        type: 'GET',
        dataType: "jsonp",
        processData: false,
        crossDomain: true,
        jsonpCallback: "parseJson",
        url: "http://localhost:8080/moneymanager/api/testing/persons",
        error: function (responseData, textStatus, errorThrown) {
            alert('POST failed : ' + textStatus);
        }
    });
}

function test(){
    $.ajax({
        type: 'GET',
        dataType: "json",
        url: "http://localhost:8080/moneymanager/api/testing/persons",
        error: function (responseData, textStatus, errorThrown) {
            alert('POST failed : ' + textStatus);
        },
        success: function(data){

        	alert("I too have received the data...");
        	alert(data.toSource());
        	alert(data.length);
        	
        	var i;
        	var table = document.getElementById("persons");
        	for(i = 0; i < data.length; i++){
        		var person = data[i];
        		
        		var row = table.insertRow(-1);
        		var cell1 = row.insertCell(-1);
        		var cell2 = row.insertCell(-1);
        		
        		alert(person.name);
        		cell1.innerHTML = person.id;
        		alert(person.id);
        		cell2.innerHTML = person.name;
        	}
        	
//        	var person;
        //	
//        	for(person in data){
//        		alert("Name : " + person.name + " Id : " + person.id);
//        	}

        }
    });
}

function parseJson(data){
	alert("I have received the data...");
	alert(data.toSource());
	alert(data.length);
	
	var i;
	var table = document.getElementById("persons");
	for(i = 0; i < data.length; i++){
		var person = data[i];
		
		var row = table.insertRow(-1);
		var cell1 = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		
		alert(person.name);
		cell1.innerHTML = person.id;
		alert(person.id);
		cell2.innerHTML = person.name;
	}
	
//	var person;
//	
//	for(person in data){
//		alert("Name : " + person.name + " Id : " + person.id);
//	}
}
