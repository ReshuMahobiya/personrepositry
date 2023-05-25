# personrepositry

The POC should allow users to save and retrieve information
about a person using their social security number as the identifier.
For each person, the service should store their name, the name of
their spouse (if applicable), and the name and age of their children.
The client also requested an endpoint that returns the name of the
oldest child for a given person, along with the person's social
security number. The number of stored persons is low, and it is
acceptable to lose data on restarts.


It has for endpoints 

1. /persondata/allPerson :- to get all saved persons
2. /persondata/savePerson :- to save personinformation
   for saving the person we need to add for example json given below in Body perameter in the postmen 
   {
        "socialSecurityNumber": 8601018316,
        "personName": "reshu",
        "personSpouseName": "hemnat",
        "personChildName": "ram",
        "childAge": 10
    }

4. /persondata/{id} :- for example /persondata/8017568305(socialSecurityNumber as id)
5. /persondata/oldestchildAge :- for getting oldest child name and Person Personal nummer
