# PersonData

SpringBoot_PersonData

Import project into work space and Run as 'Sprin Boot App'.

To Add Person:

Goto Postman -> select Method as POST -> url as 'http://localhost:8080/person/create'

Add Body as below {

{    
    "firstName": "Deepu",
    "lastName": "Path",
    "createDate" : "2020-11-12",
    "address": [{
      "streetName": "Hi-Tech City",
      "city": "Hyd1",
      "state": "Telangana1",
      "zip": "500049"
    },
                {
      "streetName": "Gachibowli",
      "city": "Sec",
      "state": "Telangana",
      "zip": "500039"
    
    }]
  
}

Edit Person:

Post man -> Method as 'PUT' -> url as 'http://localhost:8080/person/update/1/rev/bob'
Now last name is modified from 'Path' to 'bob' 

To Delete person:

Postman -> "DELETE' -> url as 'http://localhost:8080/person/2'
Now Person with Id 2 get deleted.
To get persons count:

run url in browser 'http://localhost:8080/person/count' to get count from person table.
To get All list of persons:

Run 'http://localhost:8080/person/count' in browser to get persons data.
Added exception handling:

Run url 'http://localhost:8080/person/exp/1' will give you the list of persons if exists with person Id '1'
http://localhost:8080/person/exp/2 -> give you the exception 'Person not found' as person is not available in table with person id as '2'
