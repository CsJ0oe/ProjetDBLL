# ProjetDBLL

this is a simple school project to learn how to use opensource frameworks.

the idea is to create a site to help find part-time jobs for students.

we are using in-memory database (H2) so first you need to start with : 
	[http://localhost:8080/install](http://localhost:8080/install)

Package file (.war) is at : ```dist/ProjetDBLL.war```

## What we used :
- NetBeans
- Tomcat 8
- JEE Servlet
- AngularJS 1
- HTML5/CSS3

## What we did :
- [x] JEE Servlets
- [x] JEE DB Connection
- [x] JEE API
- [x] H2 in-memory DB
- [x] HTML/CSS (Monopage)
- [x] AngularJS Routing
- [X] AngularJS App/Controller
- [X] AngularJS AJAX
- [ ] Finishing AngularJS
- [X] Push to GitHub

### JEE API :
- initializing DB [/install](http://localhost:8080/ProjetDBLL/install)
- Jobs List [/job/list](http://localhost:8080/ProjetDBLL/job/list)
- Add Job [/job/create?id=1&name=name&location=location&img=img.jpg&time=time&price=100dt](http://localhost:8080/ProjetDBLL/job/create?id=1&name=name&location=location&img=img.jpg&time=time&price=100dt)
- Update Job [/job/update?id=1&name=new_name&location=new_location&img=img.jpg&time=time&price=100dt](http://localhost:8080/ProjetDBLL/job/update?id=1&name=new_name&location=new_location&img=img.jpg&time=time&price=100dt)
- Read Job [/job/read?id=1](http://localhost:8080/ProjetDBLL/job/read?id=1)
- Delete Job [/job/delete?id=1](http://localhost:8080/ProjetDBLL/job/delete?id=1)

### AngularJS Routing :
- [/](http://localhost:8080/ProjetDBLL/#!/) 		--> main.template 		// Main Page
- [/list](http://localhost:8080/ProjetDBLL/#!/list) 	--> list.template 		// Jobs List Page
- [/about](http://localhost:8080/ProjetDBLL/#!/about) 	--> about.template 		// About Page
- [/contact](http://localhost:8080/ProjetDBLL/#!/contact) 	--> contact.template 	// Contact Page
- NB: .template is just an uncompleted .html file

## Our team :
- Aya Taieb (3SIL2)
- Tarek Lammouchi (3SIL2)