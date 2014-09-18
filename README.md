# Control-Component-Library
=========================

A Java implementation of standard control theory components (PID, Saturator, etc.).

## Why a Library of Components?

* Modularity. Implement the components once and use them all through your code.
* Simplicity. Extensive use of Java Generics in the design allow highly abstract implementations that are quickly customized to fit the situation. Need to switch from one numeric integrator to another? No problem. It's all in the declaration.
* Numeric Type Safety. Control-Components are declared with a Type that extends Number (e.g., Double, Long, etc.). Mismatched numeric combinations are caught at compile time.
* Tested. Code coverage from Maven-automated tests is very high. (Check out the CI runs on travis-ci.org: https://travis-ci.org/buffetboy2001/Control-Component-Library).

## How To Get It

The compiled artifacts from this library are deployed to Maven Central. Simple include this in your Maven POM.
'''	
<dependency>
  <groupId>org.mitre.caasd</groupId>
  <artifactId>componentlibrary-core</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
'''

## How To Use It

'''

'''