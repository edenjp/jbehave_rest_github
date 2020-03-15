# jbehave_rest_github

This project were create with purpose of study of Jbehave with serenity and uses github api.


### Tools

This project was developed using:
- **Java**: to write the code;
- **Jbehave**: for BDD.;
- **Serenity**: an open source library to write cleaner and more faster automated acceptance and regression tests.

This test project uses only open-source tools to atend your needs without any major effort. 

## Structure of the project

```
Project
├── .idea 
├── src
│   ├── main
│   │   └── java classes
|   │   └── resources
|   │       └── stories
|   │           └── BDD
│   └── test
│       └── package
│           └── serenity use
│           └── map steps for java
├── Target/reports
│   └── site
│       └── serenity
│           └── index.html report
├── .gitignore
├── pom.xml
└── README.md
```

All the tests results are saved inside the *"Target/site/serenity/index.html"*.  

## Running tests
Just play the *"serenity use file"* or run:

```
$ mvn clean install                                          
```

## Jenkins command
Use this to fix HTML report on jenkins, this command needs to be executed on console scripts.
```
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
```