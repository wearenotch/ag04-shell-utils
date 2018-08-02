# ag04-shell-utils

AG04 Spring shell utils

## Usage
### Requirements
* [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

### Setup (First time)
1. Clone the repository: `git clone https://YoutUserName@bitbucket.org/ag04/ag04-shell-utils.git`
4. Build project with: ` ./gradlew clean build `

### Release
Make sure that file gradle.properties in folder ${USER_HOME}/.gradle/ contains the following two variables defined

* ag04_nexus_username
* ag04_nexus_password

1) Commit everything
2) ./gradlew release

And simply follow the instructions on the console

## Changelog

### Version 0.1.6

Introduced new helper class ShellHelper with set of:
- print help methods
- prompt help methods
- select from list help methods


### Version 0.1.5

* Changed PageableTableRenderer column width strategy so it does not render all the columns with the same length,
but favors the column with the longest content. 

### Version 0.1.4

Added dependencies to:
* com.fasterxml.jackson.core:jackson-core:2.9.6
* compile "com.fasterxml.jackson.core:jackson-databind:2.9.6

Added AsciiTableRenderer class 

### Version 0.1.3
FIXED bug in display of prompt in ConsoleUserInput

### Version 0.1.2
Declared method PageableTableRenderer.render() as public

### Version 0.1.0
First release contains the following util classes:
* ConsoleUserInput - 
* PageableTableRenderer -


#### Dependencies:

* spring-boot : 1.5.14.RELEASE
* org.apache.commons:commons-lang3 : 3.5
* de.vandermeer:asciitable : 0.3.2
* org.jline:jline : 3.4.0
* org.slf4j:slf4j-api : 1.7.25

