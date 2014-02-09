RESTlet Sample Application
==========================

This is an archetype with an application skeleton to demonstrate the use of the RESTlet framework.
It exposes a simple Restful API compatible with [Restfully](https://github.com/crohr/restfully).

# Running from the sources

Clone the repository, compile, run and test.

# Getting the archetype 

Alternatively, if you want to integrates this to your work you can download the archetype skeleton.
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


