# Meetingroom_Management_System introduction:
Create front-end user interactive interface crossed with JSP & JSTL, JavaScript & HTML5, JQuery.

Use Ajax, Java Servlet to allow user to create, insert, update, delete meeting rooms, devices, user groups 
and room reservations, tested by JUnit.

Working with MySQL integratred with myBatis as object relational mapping component.

Deployed with Tomcat and ran successfully.

Directory content:

WebContent: view part. JSP, CSS, javascript files and view pages inside.

test: JUnit test codes for module test.

mapper: java class and methods for 5 entities mapped to myBatis SQL statements

src: domain, mapper, service, utils, web files under package. Source code for server-side controller.

domain: object entities mapped to database table properties;

mapper: interfaces for mapper class to extend;

service: interfaces and classes for controlling logic, querying data from database;

utils: single factory class to manipulate database;

web: filter and servlet for URIs.
