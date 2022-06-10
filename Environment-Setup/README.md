# Java Environment Setup Guide
*Authors: Tim Gattie, Christina Russ, Sophia Gavrila*

> *This document provides a list of the required technologies for anyone who will be participating in the Fullstack Java batch. It details why each technology is required and provides some step-by-step instructions on how to install and configure the technologies. This guide also walks you through any needed environment setup.*

**NOTE**: It is VERY important that you install these technologies BEFORE training begins as we will not have much time to devote to environment setup due to the volume of content we'll cover in week 1 and throughout the session.

> 🔴 🔴 Important! If you are on a Mac, please follow the environment guidelines in the [Mac Environment Setup Guide](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Environment-Setup/MAC_Environment-Setup.md). 🔴 🔴 

<br>

## Required Technologies

The following technologies are required in order to complete this phase of the program:

- [**Git**](#step-1-install-git): We'll be using Git as a version control tool during the course of this program. Not only will you use Git to track changes to your projects, but you'll also use it to collaborate with your trainer and with your fellow associates.

<br>

- [**Java SE Development Kit 8**](#step-2-install-java-development-kit): We will be utilizing Java 8 as our primary language for the duration of the program. This software development kit will provide the compiler and runtime environment needed to quickly and efficiently develop Java applications.

<br>

- [**IntelliJ IDEA**](#step-3): We will be using IntelliJ as our *integrated development environment* (IDE). Though you don't need an IDE to write code, an IDE provides several features that make rapid development (e.g. quickly writing and refactoring code) easier.

<br>

- [**Apache Maven**](#step-4-install-maven): Maven is a software project management and build automation tool. We will use it to manage our projects' builds as it provides dependency management and streamlines several aspects of the testing life cycle.

<br>

- [**PostgreSQL**](#step-5-install-postgres-13): PostgreSQL is an open source relational database. We will leverage this technology in order to persist and organize data.

<br>

- [**DBeaver**](#step-6-install-dbeaver): DBeaver is a free, open source universal database tool that is compatible with several external data sources, PostgreSQL included. We'll use DBeaver in order to modify our databases and persist data using a simple user interface provided to us by the tool.

<br>

- [**Postman**](#step-7-install-postman): Postman is used for testing RESTful APIs. We'll use it to set up collections of tests for the RESTful APIs we design throughout the program. It can also be used to quickly test a single endpoint.

<br>

- [**Visual Studio Code**](#step-8-install-visual-studio-code): Visual Studio Code is a text editor that makes viewing and modifying code simple. Do not confuse this tool with an integrated development environment as it does not come equipped with all of the development tools you typically find in an IDE. This tool is optional, but it can be helpful if you are new to programming and wish to familiarize yourself with the syntax of the Java programming language. 

<br>

- [**Apache Tomcat**](#step-9-install-apache-tomcat): During this program, we will explore web development. As a result, we'll need a runtime environment for our web applications. Apache Tomcat provides a web server environment in which we can run our Java code so that we can easily and quickly deploy our web applications.

<br>

- [**Docker**](#step-10-install-docker): Docker is an open source containerization platform. It enables developers to package applications into containers—standardized executable components combining application source code with the operating system (OS) libraries and dependencies required to run that code in any environment.


<br>

## Manual Installation

This method is compatible with all environments as it does not require any platform-specific package managers. You need only visit the official websites for each of the technologies listed and download the version of the tool that is compatible with your system.

Do note, however, that setting system environment variables differs from machine to machine. This guide shows how to set environment variables on a Windows machine.

The first thing you'll want to do is open your web browser of choice. This guide will use *Chrome*.

**Note**: Many of the tools that you will install have different system installers that are platform dependent. It is **very** important that you download the correct installer. The following list details how you should choose the installer for a program:

- If you have a 32-bit version of Windows, use the installer that is marked as the 32-bit version.
- If you have a 64-bit version of Windows, use the installer that is marked as the 64-bit version. ***This is the most common and most likely what you will use***
- If you have a Linux distribution (e.g. Debian, Ubuntu, Red Hat, Fedora), you should choose the installer that matches your distribution.
- If you have a Mac, you should choose the installer that is marked as the Mac installer. **Please refer to the [Mac Install Guide](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Environment-Setup/MAC_Environment-Setup.md)**

These options will be clearly labeled on the websites you visit to download the technologies. If you're not sure how to figure out what version of the Windows operating system you're running, do the following:

1. Type "Control Panel" into the Windows search bar and click on the "Control Panel" app.
2. Select "System and Security".
3. Select "System".

You should now see the following screen:

![](./../images/cpu_settings-info.png)
                                                                                                                                             

You should see your operating system listed ("Windows 10" in the above example) and the system type listed under the "System" tab (a 64-bit operating system in the above example).

<br>

## Step 1: Install Git

1. Navigate in your browser to [Git's Website](https://git-scm.com/download) and click the latest download for Windows. (For those using a different OS click the appropriate OS and look for the most recent stable release.)

![](./../images/install_git.png)


2. Click yes to any security/firewall popup asking if you are sure you want to download the file. 

3. The install file will begin downloading; most browsers will show the file that has just downloaded, click that file when it completes. If you do so skip to step 6. If the download is not apparent on your browser or disappears upon finishing go to step 4. 
![](./../images/git-download2.png)


4. If you were not able to click the install exe file you just downloaded in your browser open your file explorer.

![](./../images/git-download-2.png)


5. In the window that opens click the "Downloads" folder, use the search bar in the upper right to search "git", and then double click on the Git installer exe file.

![](./../images/git-downloads-folder.png)


6. Click yes to any security pop-ups asking you if you want to allow the installer to make changes to your computer. 

7. The install wizard will open to guide you through the process of installing Git. Read the license agreement and click "Next." 
 
![](./../images/git-license.png)

8. Accept the default installation path by clicking "Next."

![](./../images/git-filepath.png)

9. Select your components. It is recommended to add a desktop icon. Leave the other boxes in their default setting. Click "Next."

![](./../images/git-components.png)


10. Leave the rest of the set up as the default configuration clicking Next until you get to the experimental options (which you should leave unchecked) and then click Install. This will run the actual install process. 

![](./../images/git-editor.png)
![](./../images/git-PATH.png)
![](./../images/git-HTTPS.png)
![](./../images/git-line-end-conversions.png)
![](./../images/git-default-pull.png)

<!-- ![](./images/Git-Default-Pull.jpg)
![](.images/Git-Extras.jpg)
![](.images/Git-Experimental.jpg) -->

11. After install you will get a a final window giving you the options to launch Git Bash and view the Readme notes. Select open Git Bash and deselect the view Readme notes. Click "Next."


12. When Git Bash opens type "git --version" and hit Enter. If it return the version of Git you installed it correctly. 

![](./../images/git-finished.png)

<br>

## Step 2: Install Java Development Kit

1. Navigate in your web browser to [Oracle's JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html?) website. NOTE: If you are experiencing errors when trying to load the webpage try another browser. If you still are having trouble, try again later. 


2. In the top right of the website click "View Accounts" and then "Create an Account." (If you already have an Oracle account you can just skip to step 3)

3. Return to Oracle's JDK 8 website. Scroll to find the appropriate JDK for your Operating System and Architecture. (Windows 10 will be Windows x64) and click to download.

A step by step guide can be found here [Install JDK](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Environment-Setup/Installing%20the%20Java%20Development%20Kit.pdf).

 IMPORTANT: Make note of the file path for the installation directory! You WILL need this later. 

4. The install will begin extracting files and will ask to confirm the installation directory of the JRE. Confirm the default directory by clicking "Next."

![](./images/JDK-Wizard3.jpg)
![](./images/JDK-Wizard4.jpg)

5. Java will finish installing and you can then click "Close."

6. Use your system search tool (next to the windows button) to look for "Edit the system environment variables" in the control panel. Be sure that you open the SYSTEM environment not the ones just for your account. 

![](./../images/system-environment.png)

7. Click the "Environment Variables" button in the window that opens.

![](./../images/environment-variables.png)

8. Under "System Variables" click the "New" button. 

![](./../images/system-variables.png)

18. Name the new variable "JAVA_HOME" and give it the value of the directory where your JDK was installed to. (See Step 12.) If you are unsure of your directory path you can go to C:\Program Files\Java in your file explorer then click on the JDK folder to open it. You can then copy the path from the navigation bar at the top of the file explorer. 

![](./../images/java-home-variables.png)

19. In your system variables then select the "Path" variable and click "Edit."

![](./../images/set-path-variable.png)

20. Click "New" to create a new line. Add the path to the JDK bin folder in this line, it will be the same as the path in JAVA_HOME with a "\bin" at the end. 

![](./../images/java-home-bin.png)

21. Click "OK" to close the Environment Variables window. 


22. Open Git Bash, type "java -version" and hit Enter. If the JDK is installed correctly you should see Java with the version number you downloaded. 

![](./../images/java-version.png)


<br>

## Step 3: Install IntelliJ

Choose the community edition and the proper version for your operating system. Once downloaded you should be able to open right away click [here](https://www.jetbrains.com/idea/download/#section=windows) to download.


<br>

## Step 4: Install Maven

1. Navigate in your web browser to the [Maven Download Page](https://maven.apache.org/download.cgi) and scroll down to the "Files" section. Click the Binary zip archive link to download. Approve any firewall/security popups asking if you are sure you want to download the file. 

<img width="697" alt="Screen Shot 2022-06-07 at 7 36 47 PM" src="https://user-images.githubusercontent.com/104151366/172500887-dd4b7f5f-8448-40d5-aae9-c2ab825d4b2a.png">

2. The download should appear in your browser. When it completes right-click and click "Show in folder." Skip to step 4. If you were unable to right-click and show in folder proceed to step 3. 

<img width="524" alt="Screen Shot 2022-06-07 at 7 37 15 PM" src="https://user-images.githubusercontent.com/104151366/172500955-d311baf0-329b-4eca-8c47-a84ea3f73280.png">

3. If you could not open the file location from your browser, open your file explorer, click downloads, and search "maven" in the upper right search bar. You should see the file you just downloaded. 

<img width="779" alt="Screen Shot 2022-06-07 at 7 38 33 PM" src="https://user-images.githubusercontent.com/104151366/172501064-aca44d9a-464a-46b4-8526-8ab83aa4e6f2.png">

4. Right click the Maven zip archive you just downloaded and click "Extract All..."

<img width="762" alt="Screen Shot 2022-06-07 at 7 39 03 PM" src="https://user-images.githubusercontent.com/104151366/172501117-5ca9da3f-e743-4d6d-9357-5bbf198da1f3.png">

5. Your extraction wizard will open. Set the file path to "C:\Maven" and click the box to show extracted files when complete. Then click "Extract."

<img width="733" alt="Screen Shot 2022-06-07 at 7 39 35 PM" src="https://user-images.githubusercontent.com/104151366/172501168-541330c5-0a3b-4974-8234-f08b20f69dcb.png">

6. Your file will be unzipped and your file explore will open a window to C:\Maven containing the folder with your maven version. Double click to open that folder. 

<img width="779" alt="Screen Shot 2022-06-07 at 7 40 02 PM" src="https://user-images.githubusercontent.com/104151366/172501211-3bd46208-43fb-4f4e-bf4f-153e07fe84ac.png">

7. Now inside the versions specific folder, click the navigation bar and the top and copy the file path. You will need this for your environment variables. 

<img width="777" alt="Screen Shot 2022-06-07 at 7 40 19 PM" src="https://user-images.githubusercontent.com/104151366/172501253-f6ff3a89-fc78-44a5-9671-c1528265627b.png">

8. Use your system search tool (next to the windows button) to look for "Edit the system environment variables" in the control panel. Be sure that you open the SYSTEM environment not the ones just for your account. 

<img width="781" alt="Screen Shot 2022-06-07 at 7 41 03 PM" src="https://user-images.githubusercontent.com/104151366/172501315-bf805ca4-836a-4443-a02f-30865637f60d.png">

9. Click the "Environment Variables" button in the window that opens.

<img width="580" alt="Screen Shot 2022-06-07 at 7 41 54 PM" src="https://user-images.githubusercontent.com/104151366/172501375-fa7f596a-d838-4598-a035-255283e04921.png">

10. Under "System Variables" click the "New" button. 


11. Name the new variable "M2_HOME" and give it the value of the file path you copied in step 7. Then click "OK."

<img width="790" alt="Screen Shot 2022-06-07 at 7 42 32 PM" src="https://user-images.githubusercontent.com/104151366/172501441-d617c464-7b92-4a5e-a5d8-e102e2581d83.png">

12. Click the new button again. Give the variable the name "M2" and the file path "%M2_HOME%\bin" then click "OK."

<img width="760" alt="Screen Shot 2022-06-07 at 7 43 11 PM" src="https://user-images.githubusercontent.com/104151366/172501507-38d4dde2-15b1-4870-bd87-9845bd2b33aa.png">


13. In your system variables then select the "Path" variable and click "Edit."

<img width="669" alt="Screen Shot 2022-06-07 at 7 43 58 PM" src="https://user-images.githubusercontent.com/104151366/172501593-60dad87b-70e6-4357-a0e4-cc3f2fcf01fb.png">

14. Click new to open a new line and type in "%M2%" then click "OK."

<img width="640" alt="Screen Shot 2022-06-07 at 7 44 42 PM" src="https://user-images.githubusercontent.com/104151366/172501669-8f873d99-db52-4b85-8afc-c27e6302eea8.png">

15. Click "OK" to close the Environment Variables window. 


16. Open CMD prompt (or a GitBash terminal) and type `mvn --version` then hit Enter. If that returns the maven version you have it set up correctly. 

<img width="660" alt="Screen Shot 2022-06-07 at 7 45 38 PM" src="https://user-images.githubusercontent.com/104151366/172501735-d2272aa9-d4f4-4f6a-9a8e-7eb27ba51383.png">

<br>

> :exclamation: *If you couldn't figure out these steps please refer to [this video tutorial on how to install Maven on Windows](https://www.youtube.com/watch?v=--Iv5vBIHjI)*.

<br>

## Step 5: Install PostgreSQL 13

In order to install PostgreSQL, please visit [PostgreSQL's official download website](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). *This site will direct you to Postgres' certified installer.*

Please look at the row for **version 13.x** as we will downloading this version. Select the download link which corresponds with your system and click it.

You'll then be prompted to save the file. Click "Save File".

<img width="454" alt="Screen Shot 2022-06-07 at 7 46 54 PM" src="https://user-images.githubusercontent.com/104151366/172501840-67fd92e9-9425-4aee-8296-6cb98fa2d56b.png">

The file should now be located in your "Downloads" folder.

<img width="778" alt="Screen Shot 2022-06-07 at 7 48 58 PM" src="https://user-images.githubusercontent.com/104151366/172502047-939b559a-0511-4717-bc3d-74b1fbb5c110.png">

Double click the file, which should launch the installer. You might be asked if you want the application to make changes to your device. Say "yes".

You'll be presented with several menus in the Setup Wizard.

<img width="568" alt="Screen Shot 2022-06-07 at 7 49 30 PM" src="https://user-images.githubusercontent.com/104151366/172502103-97fa3e27-9393-4dbb-8095-e000810dc98d.png">

Hit "Next" until you get to the "Select Components" menu. Here, you'll want to select and/or deselect the following and then click "Next":

<img width="579" alt="Screen Shot 2022-06-07 at 7 50 04 PM" src="https://user-images.githubusercontent.com/104151366/172502160-bee32de9-8b8e-4ddb-885e-655f4630c1ea.png">


Continue to hit "Next" until you reach the "Password" menu. Here you will be tasked with providing a password for the default Postgres user (which is "postgres"). 

> Do *not* make this a password you use anywhere else. **I RECCOMEND MAKING IT `postgres`** <br>
> **DO NOT forget your password as you won't be able to login to your database as the superuser. If you have to, write your password down somewhere or use a password manager. It would be easiest if you just make the password `postgres`**

## ❗ ❗ DO NOT FORGET YOUR POSTGRES PASSWORD AND DON'T MAKE IT A COMMON PASSWORD YOU TYPICALLY USE ❗ ❗

<img width="585" alt="Screen Shot 2022-06-07 at 7 51 00 PM" src="https://user-images.githubusercontent.com/104151366/172502237-244a638a-f55f-4718-860e-4b79d729d542.png">

After you've decided on a password, hit "Next" on the remaining menus and allow time for Postgres to be installed. Once the installation is complete, you might be asked if you want to launch Stack Builder. You can say "no".

PostgreSQL should now be successfully installed on your computer.

<br>

## Step 6: Install DBeaver

In order to install DBeaver, please visit [DBeaver's official website](https://dbeaver.io/download/).

Once you navigate to the website, you should see the following:

<img width="784" alt="Screen Shot 2022-06-07 at 7 51 40 PM" src="https://user-images.githubusercontent.com/104151366/172502313-de778e00-491e-4fd0-a0e7-a4b96db4b80a.png">

Once you click it, you'll notice that there are two options: Community Edition and Enterprise Edition. Please select the **Community Edition** as it is free. Do NOT select the Enterprise Edition.

You will find the installers for the Community Edition if you scroll down the page. They should be located directly beneath the the box which says "Community Edition 21.X.X". As with all other software listed here, please make sure that you choose the correct installer for your system. If you're on Windows, you'll most likely click **Windows 64 bit installer**.

Once you've clicked on the installer that is compatible with your system, you'll be prompted to save the file. Save it and note where you've saved it on your machine. These files are usually stored in your computer's "Downloads" folder by default.

<img width="452" alt="Screen Shot 2022-06-07 at 7 52 16 PM" src="https://user-images.githubusercontent.com/104151366/172502371-2fed7fd5-3752-4017-9093-34567c005b99.png">

Now navigate to the folder where the installer is stored. For this example, we've downloaded the file to the "Downloads" folder.

<img width="773" alt="Screen Shot 2022-06-07 at 7 52 53 PM" src="https://user-images.githubusercontent.com/104151366/172502428-f76e50c9-cea0-4498-89b3-e28faa9b7d92.png">

Double click the installer. Once you've done so, the installer will be launched. The installer should take you through the process of setting up DBeaver. You'll be asked, for instance, to select a language of choice and review license terms before you install the software. 

**When you're prompted to "Choose Users", you may select "For me (...)".**

When you arrive at the portion of the setup which is titled "Choose Components", please select "DBeaver Community", **"Inlcude Java**, and "Associate .SQL files".

<img width="515" alt="Screen Shot 2022-06-07 at 7 53 23 PM" src="https://user-images.githubusercontent.com/104151366/172502481-a0a94af8-753e-420f-95e5-de3dbb793d7b.png">

Click next, then click "Install", then click "Finish".

If your installation was successful, you should now be able to search for and find "DBeaver" using your computer's search bar.

<br>

## Step 7: Install Postman

In order to download Postman, please visit [Postman's official website](https://www.postman.com/downloads/).

Once you've navigated to the site, you should see the following:

<img width="763" alt="Screen Shot 2022-06-07 at 7 54 00 PM" src="https://user-images.githubusercontent.com/104151366/172502541-c2c70ecb-b310-4581-8443-c0a7998ed659.png">


Note that the default download is for Windows. If you wish to download Postman for Mac or Linux, you should click on one of the links highlighted in the small box beneath the version number and "RELEASE NOTES" link. You can see these links at the bottom of the image provided above for reference.

You should now click the "Download" button, at which point you'll be prompted to select either Windows 32-bit or Windows 64-bit (assuming you're downloading Postman for Windows). Choose the option which is compatible with your system. You'll then be prompted to save the file.

<img width="450" alt="Screen Shot 2022-06-07 at 7 54 26 PM" src="https://user-images.githubusercontent.com/104151366/172502599-161a7d28-c006-46dd-aa80-fbf01b82d22c.png">

Once you've saved the file, open your "Downloads" folder and double click the newly downloaded installer.

<img width="770" alt="Screen Shot 2022-06-07 at 7 55 01 PM" src="https://user-images.githubusercontent.com/104151366/172502647-b853d5a3-6945-462a-83d1-5d8425301f79.png">


Upon double clicking the executable, the installer will be launched and the program will be installed. In order to verify that it has been installed correctly, you can search for "Postman" on your machine by using your search bar.

Note that you'll likely have to sign up for an account to use the application. Please do so as signing up for an account is completely free.

<br>

## Step 8: Install Visual Studio Code

In order to download Visual Studio Code, please visit [Visual Studio Code's official website](https://code.visualstudio.com/download).

A step by step can be found here [VS Code Installation Guide](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Environment-Setup/Installing%20Visual%20Studio%20Code.pdf).

If your installation was successful, you should now be able to search for and find "DBeaver" using your computer's search bar.

<br>

## Step 9: Install Apache Tomcat

In order to download Tomcat, please visit [Apache Tomcat's official website](http://tomcat.apache.org/).

Once you've navigated to the site, you should see the following screen:

<img width="770" alt="Screen Shot 2022-06-07 at 7 57 45 PM" src="https://user-images.githubusercontent.com/104151366/172502881-0e0bd4f7-1c94-48c7-a938-b4fc912b16af.png">

Scroll down until you see the section labeled "Tomcat 8.5.56" as shown below. Click the "Download" link at the bottom of this section.

<img width="765" alt="Screen Shot 2022-06-07 at 7 58 09 PM" src="https://user-images.githubusercontent.com/104151366/172502937-8e081211-cf38-40df-921b-86f50db7aa6d.png">

**Note**: At the time of this tutorial, the version of Tomcat 8 was 8.5.56. In the future, this will not be the case. That said, please choose any version of Tomcat 8 that is available. In other words, Tomcat 8.x.xx is a valid choice as well.

After you've clicked the "Download" link, you should be taken to yet another page. Scroll down until you see the following:

<img width="774" alt="Screen Shot 2022-06-07 at 7 58 47 PM" src="https://user-images.githubusercontent.com/104151366/172503083-075cc1ec-c44c-4b37-af26-eb6ff8ca1063.png">


Click the "zip" option under the "Core" section. It should be the first option listed. You should see the following after you've clicked the link, after which you should opt to save the file.

<img width="457" alt="Screen Shot 2022-06-07 at 7 59 09 PM" src="https://user-images.githubusercontent.com/104151366/172503145-b3b6bcaa-4b7f-400f-bcbb-5cec51cabe85.png">

Now go into your system's "Downloads" folder. You should see a folder that is labeled "apache-tomcat-8.x.xx".

<img width="768" alt="Screen Shot 2022-06-07 at 7 59 27 PM" src="https://user-images.githubusercontent.com/104151366/172503212-7c38c8f5-f31c-420f-a351-14dda6a5ad52.png">

Right click the folder. Once you do so, you should see a list of options. Choose the option that reads "Extract All...". You'll then be asked to select a destination for the extracted files. You may choose any location on your computer you wish to by hitting the "Browse" button, but for this tutorial, we will be choosing to place the extracted files in the "Program Files" folder.

**Note**: Please keep note of where you choose to place the extracted files as you'll need this information in the next step.

<img width="585" alt="Screen Shot 2022-06-07 at 7 59 54 PM" src="https://user-images.githubusercontent.com/104151366/172503314-512a18ec-a771-40ed-9596-2047511bd5b6.png">


Once you've selected a destination, hit the "Extract" button at the bottom of the box.

After you've done so, wait for the files to be extracted. Then go the location where you specified the extracted files should be placed. In our case, we are navigating to the "Program Files" directory.

<img width="772" alt="Screen Shot 2022-06-07 at 8 00 20 PM" src="https://user-images.githubusercontent.com/104151366/172503414-1383aeef-d505-4988-a7af-b52c3e15f32b.png">

There you should see the files you just extracted in a folder called "apache-tomcat-8.x.xx". Go inside of this folder by double clicking it. Once inside, copy the path to it by clicking on the bar that shows your file path near the top of the box. It should be directly to the left of the search bar. In this example, the bar contains the text:

    Local Disk (C:) > Program Files > apache-tomcat-8.5.56

<img width="768" alt="Screen Shot 2022-06-07 at 8 01 04 PM" src="https://user-images.githubusercontent.com/104151366/172503597-cfe19d30-6f88-49aa-a1c0-cca310420d29.png">


Once you've clicked on the bar, copy the address. In this example, the address is:

    C:\Program Files\apache-tomcat-8.5.56

**Note**: This next portion will only work if you are running Windows as the process for setting environment variables is different on different systems.

Now go into your search bar and type "Edit the System Environment Variables".

<img width="767" alt="Screen Shot 2022-06-07 at 9 14 01 PM" src="https://user-images.githubusercontent.com/104151366/172510208-1d1a3c99-32c2-402d-ade5-46cea518e004.png">

Then click on the "Environment Variables" button at the bottom of the box that appears.

<img width="584" alt="Screen Shot 2022-06-07 at 9 14 22 PM" src="https://user-images.githubusercontent.com/104151366/172510234-0a5a5820-e494-42b7-80de-e32ea09cb774.png">

A new box should pop up. At this point, you should click the "New" button at the  bottom of the box.

<img width="703" alt="Screen Shot 2022-06-07 at 9 15 13 PM" src="https://user-images.githubusercontent.com/104151366/172510332-5f0a07ff-c7d4-4c23-b469-5f8801890a4a.png">

Yet another box will then pop up. It will prompt you for a "Variable name" and "Variable value". Enter the following into these boxes:

<img width="645" alt="Screen Shot 2022-06-07 at 9 15 33 PM" src="https://user-images.githubusercontent.com/104151366/172510371-99620046-fa49-4776-bf08-f1cc067e3f9e.png">

The variable name MUST be exactly what is typed above. The variable value should equivalent to the path to your Tomcat folder you copied during the last step.

Once you've entered this information, hit "OK". You should then hit "OK" again on the remaining two boxes.

**Note**: If you do not hit OK on all three of the boxes, your environment variable will not be properly set!

In order to verify that your environment variable was properly set, please open your terminal (e.g. type "Command Prompt" into the Windows search bar) and type the following:

<img width="778" alt="Screen Shot 2022-06-07 at 9 16 00 PM" src="https://user-images.githubusercontent.com/104151366/172510438-1f190426-d9a3-4aca-98ef-5d7ab8cf2dc0.png">

At this point, the value of the CATALINA_HOME environment variable should be displayed.

<br>

## Step 10: Install Docker
Docker is an open source containerization platform. It enables developers to package applications into containers—standardized executable components combining application source code with the operating system (OS) libraries and dependencies required to run that code in any environment.

Go [here to download Docker Desktop](https://www.docker.com/products/docker-desktop) 👈

<br>

Additional Resources
====================

*  **Git Cheat Sheet** (This is a GitHub-provided cheat sheet for some simple Git commands.): https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf
*  **Java Docs** (The official API specification for Java 8): https://docs.oracle.com/javase/8/docs/api/
*  **Maven Repository** (This provides a repository of dependencies which we can add to our Project Object Models): https://mvnrepository.com/
*  **PostgreSQL Docs** (This is PostgreSQL's official documentation.): https://www.postgresql.org/docs/


