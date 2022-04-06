# Changelog

## [Unreleased]
### Changed
- 

## [0.2.11]
### Changed
- Fixed problem with release.yml github workflow

## [0.2.10]
### Added
- Added CI Build status badge

### Changed
- Modified build.gradle - removed check for existence of github_user and github_password properties

## [0.2.9]
### Added
* CHANGELOG.md with track of made changes
* Added GitHub action for Build CI
* Added GitHub action for Relese

### Changed
- Update README.md sections on "Usage" and "Release"
- Cleaned up build.gradle from unused dependencies
- Extracted all dependency versions to gradle.properties.

## [0.2.5]
* Improved ProgressCounter so it deletes line before printing output.

## [0.2.4]
* Improved Chalk so it can return bold Strings.

## [0.2.3]
* Corrected build.gradle - added maven-publish plugin

## [0.2.2]
### (FAILED RELEASE)
* Corrected build.gradle release step configuration

## [0.2.1]
### (FAILED RELEASE)
* Corrected nexus.ag04.io url (https://nexus.ag04.io/repository/releases)

## [0.2.0]
### (FAILED RELEASE)

* Major refactoring of packages
* Removed ConsoleUserInput class and instead introduced InputReader class
* Added ConsoleSequences class
* Added Chalk util class
* Refactored ShellHelper - removed all input methods
* Added Support for SpringShell tables
* Added ProgressBar and ProgressCounter classes
* Upgraded SpringShell to 2.0.1.RELEASE

## [0.1.8]
* Added simplified constructors to PageableTableRenderer class.

## [0.1.7]
* Introduced new class BasicTableRenderer that renders a single table
* Changed PageableTableRenderer so it uses BasicTableRenderer to show a paginated table
* FIXED bug in display of options in ShellHelper


## [0.1.6]

Introduced new helper class ShellHelper with set of:
- print help methods
- prompt help methods
- select from list help methods

## [0.1.5]

* Changed PageableTableRenderer column width strategy so it does not render all the columns with the same length,
but favors the column with the longest content. 

## [0.1.4]

Added dependencies to:
* com.fasterxml.jackson.core:jackson-core:2.9.6
* compile "com.fasterxml.jackson.core:jackson-databind:2.9.6

Added AsciiTableRenderer class 

## [0.1.3]
FIXED bug in display of prompt in ConsoleUserInput

## [0.1.2]
Declared method PageableTableRenderer.render() as public

## [0.1.0]
First release contains the following util classes:
* ConsoleUserInput - 
* PageableTableRenderer 
