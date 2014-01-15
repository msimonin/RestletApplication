RESTlet Sample Application
==========================

This is an archetype with a application skeleton to demonstrate the use of the RESTlet framework.

## Getting the archetype 

```
mvn archetype:generate -DarchetypeCatalog=http://snooze.inria.fr/maven
```

## Compiling 


Move to the root directory, you should see : 

```
.
├── compile.sh
├── configs
├── LICENSE
├── pom.xml
├── README.md
├── src
└── target
```

and run 

```
mvn package
```

## Running it

Go to the target directory and launch : 

```
java -jar uber[...] ../configs/application.cfg yourlogfile
```

## Test it 

Open another shell and run : 

```
curl localhost:4001
```
