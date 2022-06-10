# Mac Java Environment Setup Guide

## Install Using A Package Manager

A *package manager* is a command line tool that allows you to install and manage software. You can use a package manager to install all of the software listed here.

The package manager that we'll be using for this guide is called Homebrew. It's a command-line installer for MacOS, which means that you'll have to be running a macOS in order to use. The examples provided here are utilizing macvscodeOS Catalina version 10.15.5.

<br>

## Step 1: Install Homebrew

<![](./../images/install-homebrew.png)

Open your terminal and run `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`

Then run `brew`.

The result should look like the following:

<![](./../images/run-brew.png)

## Step 2: Install Git

With Homebrew installed, you are now ready to install Git. Open a terminal window and enter <code>brew install git</code>

To verify that Git is installed on your system, type <code>git --version</code>

<br>

## Step 3: Install JDK 8

In your terminal run: <code>brew install adoptopenjdk/openjdk/adoptopenjdk8</code>


### Configure your Environment Variables
#### A. Mac OSX 10.5 or later:
In Mac OSX 10.5 or later, Apple recommends to set the <code>$JAVA_HOME</code> variable to <code>/usr/libexec/java_home</code>, just export <code>$JAVA_HOME</code> in file <code>~/. bash_profile</code> or ~<code>/.profile</code>.

```code
# This will open up a text editor called vim
$ vim .bash_profile

# Inside the text editor, write this
export JAVA_HOME=$(/usr/libexec/java_home)

# To quit vim and save your changes:
# 1. press the ESC key
# 2. You should see the ––INSERT–– label vanish from the lower-left.
# 3. To save your changes before you exit, type :w , and then Enter. This will save any changes made. 
#       Vim will respond by outputting the filename, whether it’s new, and how many characters were written to the hard drive.

# Next, execute the file you created
$ source .bash_profile

# Confirm that the path variable has been set
$ echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home
```

<br>

#### B. Older Mac OSX:
For older Mac OSX, the <code>/usr/libexec/java_home</code> doesn’t exist, so, you should set <code>JAVA_HOME</code> to the fixed path:

```code
$ vim .bash_profile

export JAVA_HOME=/System/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home

$ source .bash_profile

$ echo $JAVA_HOME
/System/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home
```

<br>

## Step 4:  Install IntelliJ

Navigate to https://www.jetbrains.com/idea/download/#section=mac and download the appropriate version of IntelliJ.

If your installation was successful, you should now be able to search for <code>IntelliJ</code> in your spotlight search using <code>cmd+space</code>.

<br>

## Step 5: Install Maven

To install **Maven** with Homebrew, open your terminal window and run: <code>brew install maven</code> 

Once the download is complete, verify the installation by running: <code>mvn -v</code>

<br>

## Step 6: Install DBeaver

Navigate to https://dbeaver.io/download/ and download the appropriate version of DBeaver.

If your installation was successful, you should now be able to search for "dbeaver" in your spotlight with <code>cmd + space</code>.

<br>

## Step 7: Install Apache Tomcat 8
Follow these [instructions](https://medium.com/@jeongwhanchoi/how-to-install-apache-tomcat-on-mac-os-x-605b1cb55252).  The author has downloaded Apache Tomcat 9.  You will download Apache Tomcat **8** and follow the exact same steps and terminal commands.

<br>

## Step 8: Install Postman

The following is the single command required to install Postman on macOS using Homebrew:

<code>brew cask install postman</code>

## Step 9: Install PostgreSQL 13

We will manually download the PostgreSQL installer visiting the official website. Look at the row for **version 13.x**.

Select the download link which corresponds with your system and click it.

You'll then be prompted to save the file. Click **Save File**. The file should now be located in your **Downloads** folder.

Double click the file, which should launch the installer. You might be asked if you want the application to make changes to your device. Click **yes**.

You'll be presented with several menus in the Setup Wizard.  Click <code>Next</code> until you get to the **Select Components** menu. 

Here, you'll want to select and/or deselect the following and then click <code>Next</code>:

Continue to click <code>Next</code> until you reach the **Password** menu. Here you will create a password for the default Postgres user (which is <code>postgres</code>). **DO NOT use a password you use anywhere else.  I recommend making the password `postgres`.** *DO NOT* forget your password as you won't be able to login to your database as the superuser.

After you've decided on a password, click <code>Next</code> on the remaining menus and allow time for Postgres to be installed. 

Once the installation is complete, you might be asked if you want to launch Stack Builder. You can say <code>no</code>.

PostgreSQL should now be successfully installed on your computer.

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

