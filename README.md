# dragonfly-test

A 'Framework' represents a 'conversation starter'. It describes a pre-selected topic that a user will converse about to the LLM.

Goal: To write some backend code that will be used as a foundation for a system that allows a user to converse with an LLM. 

Steps:

Step 1:
Create a representation of a Framework object, which contains
    - an id (assume this is generated for you elsewhere. Don't worry about uniqueness)
    - a title
    - a detailed description of the framework
    - a one sentence description of the framework
    - date it was last edited

Write a controller class containing one function, which returns a list of frameworks.

Step 2:
We want some frameworks to be marked for testing only. As such - only staff should have access to them.
Add a field, required permission, to the framework objects. The two permission levels are USER and ADMIN.
Update the implementation of the controller to ensure ADMIN level frameworks are not returned to non-admin queries.

Step 3:
Users need to query for individual frameworks to get more detail about the objects.   
Specifically - querying all frameworks should just return the higher level information (not including the detailed description)
And querying an individual framework should include the detailed description 
Add a new function for fetching a framework by id 

Step 4: 
An admin wants to create a new framework.   
Implement a new function on the controller allowing them to do so.