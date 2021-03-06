RESTlet Sample Application
==========================

This is an archetype with an application skeleton to demonstrate the use of the [RESTlet framework](http://restlet.org).
It exposes a simple Restful API compatible with [Restfully](https://github.com/crohr/restfully).

Versions : 

For specific versions, checkout the corresponding tag.
* 0.0.1 : "Hello world" application
* current :The application present a "grid like" resource. A grid is composed of clusters of machines.

# Running from the sources

Clone the repository

```
git clone https://github.com/msimonin/RestletApplication
cd RestletApplication
```
compile it

```
./compile.sh
```

Go to the target directory and launch : 

```
java -jar uber[...] ../configs/application.cfg ../configs/log4j.xml
```

Test it :


* root resources : ```curl localhost:4001/1.0```
* clusters resources: ```curl localhost:4001/1.0/clusters```
* add cluster with a ```POST``` request, remove one with a ```DELETE``` ...


or use Restfully :
```
>> pp root
#<Resource:0xa01018 uri="/1.0" RELATIONSHIPS clusters, self PROPERTIES>
=> nil
>> pp root.clusters
#<Collection:0xe06654 uri="/1.0/clusters"
  RELATIONSHIPS
    clusters
  ITEMS (0..2)/2
    #<Resource:0xe1a834 uri="/1.0/clusters/cluster1">
    #<Resource:0xe20090 uri="/1.0/clusters/cluster2">>
=> nil
>> pp root.clusters[:cluster1]
#<Resource:0x118797c uri="/1.0/clusters/cluster1"
  RELATIONSHIPS
    parent, self
  PROPERTIES
    "uid"=>"cluster1">
=> nil
>> pp root.clusters[:cluster1].delete
#<Resource:0x1265dbc uri="/1.0" RELATIONSHIPS clusters, self PROPERTIES>
=> nil
>> pp root.clusters.submit("test")
#<Resource:0x1244c84 uri="/1.0/clusters"
  RELATIONSHIPS
    parent, self
  PROPERTIES
    "uuid"=>"test"
    "message"=>nil>
=> nil
>> pp root.clusters
#<Collection:0x11b0b38 uri="/1.0/clusters"
  RELATIONSHIPS
    clusters
  ITEMS (0..2)/2
    #<Resource:0x11a6840 uri="/1.0/clusters/cluster2">
    #<Resource:0x119e014 uri="/1.0/clusters/test">>
=> nil

```


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




