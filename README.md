# ag04-shell-utils

[![CI Build](https://github.com/ag04/ag04-shell-utils/actions/workflows/ci.yml/badge.svg)](https://github.com/ag04/ag04-shell-utils/actions/workflows/ci.yml)
![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white&style=flat)
![](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white&style=flat)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

AG04 Spring shell utils.

**Latest project version: 0.2.10**

## Usage
To use this jar in your project add the following to the dependencies section:

```groovy
dependencies {
    implementation "com.ag04.utils:ag04-shell-utils:0.2.10"
    ...
}
```
(build.gradle)

```xml
<dependency>
  <groupId>com.ag04.utils</groupId>
  <artifactId>ag04-shell-utils</artifactId>
  <version>0.2.10</version>
</dependency>
```
(pom.xml)

And regitser github package as maven repository, as is for example show in the snippet bellow:

```groovy
repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/ag04/ag04-shell-utils")
        credentials {
            username = github_username
            password = github_token
        }
    }
}
```
**github_token** should contain the value of (PAT) "personal access token" that has Access to public repositories.

For more see:
* [Personal GitHub access tokens](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
* [Working with the Gradle registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)


## Development

### Requirements
* [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

### Setup (First time)
1. Clone the repository: `git clone git@github.com:ag04/ag04-shell-utils.git`
4. Build project with: ` ./gradlew clean build `

### Github Actions release

New version of library jar  is released with the "Release next version" github action script.
Once everything is pushed simply run this workflow script.
It will perform the following:
- build new version of jar
- publish built jar to GitHub packages (`https://maven.pkg.github.com/ag04/ag04-shell-utils`)
- Create new Relase with comments from CHANGELOG.md for this release.
- Update README.md to contain latest version number.

### Manual Release
Make sure that file gradle.properties in folder ${USER_HOME}/.gradle/ contains the following two variables defined

* github_username
* github_password : personal github token to be used to install/update packages

1) Commit and push everything
2) `./gradlew release`

And simply follow the instructions on the console

### Github Actions release

New version of library jar  is released with the "Release next version" github action script.
Once everything is pushed simply run this workflow script.
It will perform the following:
- build new jar version
- publish jar to github packages
- Create new Relase with comments from CHANGELOG.md for this release.
- Update README.md to contain latest version number.

## Project Dependencies

| Dependency                       | Version         |
|----------------------------------|-----------------|
| spring-boot                      | 2.1.4.RELEASE   |
| spring-shell                     | 2.0.1.RELEASE   |
| de.vandermeer:asciitable         | 0.3.2           |
| org.apache.commons:commons-lang3 | 3.5             |
| org.slf4j:slf4j-api              | 1.7.25          |
| com.fasterxml.jackson            | 2.9.6           |

## Contributors:
* [Domagoj Madunić](https://github.com/dmadunic)

---
(c) AG04 2022.