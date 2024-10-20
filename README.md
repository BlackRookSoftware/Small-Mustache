# Black Rook Small Mustache View Driver

Copyright (c) 2024 Black Rook Software.  
[https://github.com/BlackRookSoftware/Small-Mustache](https://github.com/BlackRookSoftware/Small-Mustache)

[Latest Release](https://github.com/BlackRookSoftware/Small-Mustache/releases/latest)    
[Online Javadoc](https://blackrooksoftware.github.io/Small/javadoc/Mustache)


### Required Libraries

Any servlet 2.X+ container implementation (javax.servlet-api.jar).  
[Black Rook Small 1.6.0+](https://blackrooksoftware.github.io/Small)  
[Mustache-Java](https://github.com/spullara/mustache.java)  


### Required Java Modules

[java.xml](https://docs.oracle.com/en/java/javase/11/docs/api/java.xml/module-summary.html)  
* [java.base](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html)  


### Introduction

This library adds Mustache support to Small as a View Driver.


### Why?

For adding Mustache easily to Small as a model-view renderer.


### Library

Contained in this release is a series of classes that facilitate adding Mustache support
to a Small application.


### Compiling with Ant

To download dependencies for this project, type (`build.properties` will also be altered/created):

	ant dependencies

To compile this library with Apache Ant, type:

	ant compile

To make Maven-compatible JARs of this library (placed in the *build/jar* directory), type:

	ant jar

To make Javadocs (placed in the *build/docs* directory):

	ant javadoc

To compile main and test code and run tests (if any):

	ant test

To make Zip archives of everything (main src/resources, bin, javadocs, placed in the *build/zip* directory):

	ant zip

To compile, JAR, test, and Zip up everything:

	ant release

To clean up everything:

	ant clean
	

### Javadocs

Online Javadocs can be found at: [https://blackrooksoftware.github.io/Small/javadoc/Mustache](https://blackrooksoftware.github.io/Small/javadoc/Mustache)

### Other

This program and the accompanying materials are made available under the 
terms of the LGPL v2.1 License which accompanies this distribution.

A copy of the LGPL v2.1 License should have been included in this release (LICENSE.txt).
If it was not, please contact us for a copy, or to notify us of a distribution
that has not included it. 
