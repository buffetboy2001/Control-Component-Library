# Control-Component-Library
=========================

A Java implementation of standard control theory components (PID, Saturator, etc.) and their associated numerical algorithms (integrators & differentiators).

## Why a Library of Components?

* Simplicity. Extensive use of Java Generics in the design allow highly abstract implementations that are quickly customized to fit the situation. Need to switch from one numeric integrator to another? No problem; it's a quick code change.
* Numeric Type Safety. Control-Components are declared with a Type that extends Number (e.g., Double, Long, etc.). Mismatched numeric combinations are caught at compile time.
* Tested. Code coverage from Maven-automated tests is very high. (Check out the CI runs on travis-ci.org: https://travis-ci.org/buffetboy2001/Control-Component-Library).
* Modularity. Import this library onto your classpath and use them all through your code.

## How To Get It

The compiled artifacts from this library are deployed to Maven Central. Simply include this in your Maven POM.

	<dependency>
	  <groupId>org.mitre.caasd</groupId>
	  <artifactId>componentlibrary-core</artifactId>
	  <version>1.0.0</version>
	</dependency>

## A Quick Tutorial
_Coming Soon_

### Declare Numeric Component(s) & Arguments
_Coming Soon_

### Declare Control Component(s)
_Coming Soon_

### Use the Component
_Coming Soon_

## Design Overview
_Coming Soon_