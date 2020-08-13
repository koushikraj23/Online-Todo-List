# Online-Todo-List

## Description
The goal of this assessment project is to develop a simple online TODO list


## Secitons
- [Techonlogy Overview](#technology-overview)
- [Imorting using Zip file(Preferred)](#importing-using-zip-file(prefered))
- [Importing project using GIT import in Eclipse IDE](#importing-project-using-git-import-in-eclipse-ide)
- [UserAuth Credentials](#userAuth-credentials)

## Techonlogy Overview
- Java Spring Boot Framework is used to create this spring web mvc.
- Apache Maven is used to manage the libraries and building of project.
- Hibernate ORM with JPA implementations is used to access DB.
- Spring Security basic Auth is used to provide authentication
 

## Imorting using Zip file.
* Download the zip file from the git repository.
* Extract the zip file.
* Open IDE,Click `Import->Import Projects from File System`.
* Browse through the Imported folder and select `Todo`,click `Finish`.
* Wait for maven finsih loading the libraries.

## Importing project using GIT import in Eclipse IDE
### !! The repository has sub module project!!
* Click `File > Import`.
* In the `Import wizard`:
  * Click `Git > Projects from Git`. Click Next.
  * Click `Clone URI` and click Next.
  * In the Source Git Repository window, in the URI field, enter an existing `Git repository URL`,and click Next.
  * In the Local Destination window,click `Browse to select the location`.
  * In the Select a wizard to use for `importing projects window`, `Import as general project` is selected by `default`. Click Next.
  * In the `Import Projects window`,click `Finish`.
  * Click `file-> open projectes from files system or archive`.select the imported folder `todo` as import source in folder.Click finish.
  
## UserAuth Credentials
- Type= Basic Auth
- username= admin
  - password= admin
- username= User  
  - password= User
