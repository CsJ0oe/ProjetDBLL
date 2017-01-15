# ProjetDBLL

we are using in-memory database (H2) so first you need to start with : 
	[http://localhost:8080/install](http://localhost:8080/install)

Package file (.war) is at : ```dist/ProjetDBLL.war```

## What we did :
- [x] JEE Servlets
- [x] JEE DB Connection
- [x] JEE API
- [x] H2 in-memory DB
- [x] HTML/CSS
- [x] AngularJS Routing
- [X] AngularJS App/Controller
- [X] AngularJS AJAX
- [ ] Finishing AngularJS
- [X] Push to GitHub

### JEE API
- Intialazing DB [/install](http://localhost:8080/ProjetDBLL/install)
- Jobs List [/job/list](http://localhost:8080/ProjetDBLL/job/list)
- Add Job [/job/create?id=1&name=name&location=location](http://localhost:8080/ProjetDBLL/job/create?id=1&name=name&location=location)
- Update Job [/job/update?id=1&name=new_name&location=new_location](http://localhost:8080/ProjetDBLL/job/update?id=1&name=new_name&location=new_location)
- Read Job [/job/read?id=1](http://localhost:8080/ProjetDBLL/job/read?id=1)
- Delete Job [/job/delete?id=1](http://localhost:8080/ProjetDBLL/job/delete?id=1)

### AngularJD Routing
- [/](http://localhost:8080/ProjetDBLL/#!/) 		--> main.template 		// Main Page
- [/list](http://localhost:8080/ProjetDBLL/#!/list) 	--> list.template 		// Jobs List Page
- [/about](http://localhost:8080/ProjetDBLL/#!/about) 	--> about.template 		// About Page
- [/contact](http://localhost:8080/ProjetDBLL/#!/contact) 	--> contact.template 	// Contact Page

## our team :
- Aya Taieb
- Tarek Lammouchi