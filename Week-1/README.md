# Monday -  First Day 

🔴 Important! Here you will find your Day 1 [Assessment](https://coding.revature.com/AuthenticateKey?id=4a53e844e7). 

🔴 You will have **1 hour** to complete it


## Computer fundamentals: Types of Memory

![](./../images/Location+External+memory.png)

### Click [here](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Week-1/types-of-memory.md) for more details.

## OS: Operating Systems - Fundamentals 

![](./../images/operating-system-intro.png)

An OS, or operating system, is the software that allows you to interface with your computer. It takes care of managing the different parts of your computer, such as hardware, memory, and processes. Some common operating systems are Microsoft Windows, macOS, and Linux, but mobile operating systems like Android and iOS are also part of this category.

Windows is the most popular operating system, primarily because it comes pre-installed on PCs and is fairly easy to use. Similarly, macOS comes pre-installed on Mac (Apple) computers. Linux is most commonly found on servers, though it can be installed on personal computers as well, and it is an open-source operating system with many different distributions that differ slightly from each other (such as Debian and Red Hat Linux).

### [Memory Usage and Computers](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Week-1/Memory%20Usage%20and%20Computers.md)
More notes here.

## Unix

Unix is a family of operating systems that derive from one built in the 1970s at Bell Labs by AT&T. The current owner of the Unix license is The Open Group, however, Novell, Inc currently holds the copyrights. Linux operating systems and OS X operating systems are based on Unix. One of Unix's standard features is the command-line shell that is used to interface with the operating system. In Linux, this shell is commonly Bash.

 **Bash
The Bourne Again Shell or Bash is based on the original Unix shell, which was called sh. Bash is compatible with sh and incorporates other features as well. Bash was created in 1989.**

Good tutorial that we will use in class [here](https://www.hpc.iastate.edu/guides/unix-introduction/unix-tutorial-1) .


## Commands

### Through the tutorial above we will pratice writing and executing commands in the terminal - however, [here](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Week-1/commands.md) is a breakdown of more commands in detail



## Command-Line Text Editors

You can write/view files in the shell by making use of built-in text editors such as `nano` and `vim` or `vi`.

**Guides -**

* [Beginner's Guide to Nano](https://www.howtogeek.com/howto/42980/the-beginners-guide-to-nano-the-linux-command-line-text-editor/)
* [Beginner's Guide to Vim](https://www.linux.com/training-tutorials/vim-101-beginners-guide-vim/)

[Here](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Week-1/Command-line-Text-Editors.md) we can find more details about command line text editors.

### Text Editors - Not in command line 

> [Sublime Text](https://www.sublimetext.com/) - You can navigate to where it says "Download" if you want.
> TextEdit - that comes on all Mac OS
> Notepad - that comes on all Window OS


## Introduction to SDLC
This module introduces the Software Development Lifecycle, the Waterfall and Agile methodologies, and the Scrum, Kanban, Scrumban, and eXtreme Programming frameworks.
![](./../images/sdlc-diagram.png)
 
* [Lecture Notes](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/main/Week-1/SDLC-Software-Development-Life-Cycle.md)

### Table of Contents

* Team Development in the Software Industry
* Software Development Lifecycle (SDLC)
* The Waterfall Methodology
  * Waterfall Drawbacks
  * Benefits of Waterfall
* Term Definitions
* The Agile Methodology
  * Agile Drawbacks
    * Benefits of Agile
    * The Scrum Framework
      * Scrum Advantages
      * Scrum Disadvantages
    * Kanban
      * Kanban Advantages
      * Kanban Disadvantages
    * Scrumban
    * eXtreme Programming (XP)
      * XP Downsides
      * XP Benefits
    * Agile Planning
* A Home for Waterfall

<br>

# Tuesday

## Environment Variables

Environment variables are values that are accessible in an entire working environment. In Unix, these values are set in the shell when it is started. For example, your home directory is an environment variable called `$HOME`. If you wish to see the value of a particular environment variable, you can use the `echo` command like so: `echo $HOME`.

To set your own environment variables, you can use the `export` command. For example, if you wanted to create an environment variable to store the password to your server, you could issue the following:
```
export SERVER_PASS=password
echo $SERVER_PASS
```

However, if you issue the above command into your console, when you close the shell and open it again, your environment will no longer be present. To keep these environment variables, you will have to place the command in one of your startup files, usually 
```
~/.bashrc
```

You can also remove environment variables with the `unset` command: 
```
unset SERVER_PASS
echo $SERVER_PASS
```
> [Here](https://www.youtube.com/watch?v=bd65z5VZ7L4) && [There](https://www.youtube.com/watch?v=ADh_OFBfdEE&t=194s) are great in depth videos to the explain Environment Variables. 

<!-- While setting up your environment you had to update your envirnonmemt variables a few times. More so on Windows, than on Mac devices.   -->

## Package Managers

Package managers are a type of software that you can use to manage installations and updates for other software on your machine. Typically they allow you to use a CLI (command line interface) to install and update your software. This means that you can easily run commands to install things like Git, Java, .NET, Docker, and more. There are a variety of different package managers, many of which are specific to the operating system that you're using.

- Common Windows package managers:
    - [Scoop](https://scoop.sh/)
    - [Chocolatey](https://chocolatey.org/)
- Common Linux package managers:
    - APT (Debian Linux)
    - YUM (Red Hat Linux)
- Common macOS package managers:
    - [Homebrew](https://brew.sh/)
    - [Fink](https://github.com/fink/fink)


## File Permissions

In Unix, file permissions can become very important. Every file in Unix has three types of permissions.
1. Owner permissions - What the owner of the file is allowed to do to the file.
2. Group permissions - What the group of users that the file belongs to is allowed to do to the file.
3. Other (world) permissions - What everyone else is allowed to do to the file.

Each type of permission can have any combination of read (`r` or `4`), write (`w` or `2`), and execute (`x` or `1`) permissions. You can represent these permissions as either a number or a string of characters. For example, someone with read and write permissions has `6` or `rw` permissions.

![](./../images/file-permissions.png)

## Viewing permissions

You can see the permissions of files in a directory by using the `-l` flag on the `ls` command to get it to print the "long listing format"

`ls -l .`

## Changing permissions

You can change the permissions on a file using the `chmod` or change file mode bits command.

If you are using the numbers, it is as simple as specifying the correct permissions for the `owner`, `groups`, and `other` types and issuing the command targeting the file. For example, if I wished the owner to have read, write, and execute, groups to have read and execute, and other to have read permissions on `hello.text` I would issue the following command:

`chmod 754 hello.txt`

Otherwise, if you are using the strings, you have to specify which groups you are granting or revoking access to. Owner (u), group (g), and other (o) can be specified or all (a) can be used. The `+` indicates a granted privilege, `-` indicates a revoked privilege, and `=` allows you to set privileges.

Examples:
```
# Everyone has all permissions
chmod a+rwx hello.txt
# Revoke write access to other
chmod o-w hello.txt
# Set group access to be the same as other
chmod g=o hello.txt
```


## How To Do Well in QC :pencil2:

Performing well in technical interviews, including QC, requires confidently answering both high-level conceptual questions on specific technologies as well as low-level details about how you’ve worked with them.
<br>
<br>
For example, as a developer you’ve most likely worked with git before. A common interview question to test your proficiency might be **“Tell me about your experience working with git”.** 
- How would you answer this? 
- Take a minute to think about it and then consider the sample responses below. Which answer would impress you more as an interviewer? Which one demonstrates an understanding and proficiency with the tool better?

## Response 1 :cold_sweat:
*“Well, **uh**, for git **uh** I think I’ve used it on a few projects for pushing code… it’s really **helpful, pretty easy** to work with, it lets me **keep track** of **stuff going on** in the project and **work with other** people well.”*

## Response 2 :sunglasses:
*“So I’ve used git for almost all of my projects. It’s a really useful **distributed version control system** for managing **source code** - I’ve used it **on the command line to add, commit, and push** code to an **online repository**, usually **GitHub**, as well as switch between different **feature branches** that my team members and I work on. I like it because it **smooths the process of collaborating** on the same codebase and **merging or integrating changes**.”*

Note a few problems in the first response: the use of filler words (“ummm”, “ahh”) - you should remove these as much as possible. Don’t lower your voice and trail off at the end of sentences, it implies uncertainty. Also note the vague words that are **bolded** - it doesn’t answer **how** git is helpful, how it is easy to work with, or how it lets you keep track of “stuff” (whatever that is). Finally, the only technical word mentioned is “pushing” code.

In contrast, the second answer is well-structured and smooth, and it drops in several technical keywords that demonstrates knowledge in the domain - it explains **what** (“distributed version control”), **how** (“add, commit, push code”), and **why** (“smoothing the process of collaborating”). Putting these together, it **sounds like the person giving the second answer has worked in-depth with git**.

Review one more high-level sample question and answer below.

*Q: “Tell me about the Spring framework”*

*A: “The Spring framework is a **Java framework** for **production-ready enterprise applications** based on the concept of **inversion of control** where we hand off control over **instantiation of our objects** to an external entity. In Spring this entity is the **IOC container** which manages the **lifecycle of the application beans**, provided either through **XML, Java, or annotation configuration**. We can achieve **loose coupling** of our code by letting Spring **inject our bean dependencies** directly into our classes.”*

Remember, there are 3 key questions you should ask for every technology you learn about - **what is it and what does it do, how does it work, and why is it useful?**

As you go through training, think about this approach for structuring your responses in QC, one-on-ones, and panels. To really improve at answering these conceptual questions, you **MUST** practice your own responses. **Also, it’s not enough to memorize the keywords to say - you must fully understand and internalize the knowledge, otherwise you will not be able to back yourself up when asked follow-up questions.**

# Technical Exercise
The exercise below should help you improve your answers in QC, one-on-ones, panels, and interviews. <br>
 **You should complete this exercise each week as you cover new technologies throughout training.** 

1. Find a blank sheet of paper or open a text editor on your laptop
2. List the technologies, languages, libraries, and frameworks you have learned this week (e.g. HTML, CSS, JavaScript)
3. For each one, write a response to the question “Tell me about your experience with X” where X is the given technology.
4. Review your answers and practice saying them out loud. Note any verbal miscues or awkward phrasing
5. Bold the important keywords in your responses
6. Revise your answers. Look for ways to improve clarity, be specific, improve the structure, and make the answers more cohesive.
7. Find a partner (a classmate or your trainer). Practice saying your answers out loud and gather feedback from your partner. Make final revisions to your answers.
8. Record yourself practicing your answer and watch the video to notice any problems you need to correct

If you do this every week, at the end of training you will have a complete set of answers to each language, framework, and major concept you’ve covered. You can use these to improve the bullet points and written sections in your portfolio as well as prepare for the final, cumulative QC session. :shipit:

### Credits
Andrew Crenwelge - Lead Quality Analyst at Revature <br>
Sophia Gavrila - Senior Trainer at Revature

## Coding Challenges - General Guide

<br>

# Wednesday

## Class vs Object
## Pillars of OOP
## Introduction to Java
## JDK, JRE, JVM
## First Java Program: HelloWorld
## Methods and Parameters

<br>

# Thursday

## Constructors
## Packages and Imports
## Wrapper Classes
## Introduction to Git
## Commits
## Committing work
## Working directory
## Branches
## Pull requests

<br>

# Friday

## Control Flow Statements
## Casting

## Agile vs Waterfall (Review)

##### [Waterfall model](https://en.wikipedia.org/wiki/Waterfall_model)

![Waterfall Model](https://user-images.githubusercontent.com/14268523/121416218-8ca56a80-c936-11eb-8926-e978bb9f1807.png)

As seen in the image above, the waterfall model has 5 main stages:

- **Requirements definition**
  - The system's components, goals, functionalities, services, and constraints will be determined and written in detail in the documentation. This documentation will be known as the system specification.
- **System and software design**
  - Determine the overall system architecture
- **Implementation and unit testing**
  - This stage involves breaking down the software design into components and verifying whether the components address requirement specifications
- **Integration and system testing**
  - Every component is combined to form a single system and is tested to see if they components mesh well with each other.
- **Operation and maintenance**
  - The system is shipped out and maintenance (improving the system and fixing any bugs that were not discovered earlier.

The waterfall model is a straight forward model where the software process follows a linear pattern; for it to advance to the next stage, the prior stage must be completed. Only after the "operation and maintenance" step is completed can the project go to earlier steps as it sees fit. The waterfall model is commonly known as a plan-driven model.

In trying to develop innovative software, the model has these shortcomings:

* The users don't really know how they want the software to behave without trying it out.
* The analysis and design phases ignore the difficulties that might be faced in actually implementing this innovative idea.
* The implementation phase proceeds without testing all along the way, so problems aren't detected until after it is completed.
* The "environment" the software was designed for will be changing while this long process, with major decisions locked-in at the start, is proceeding. Examples:
* The laws regarding the real-world activity the software is meant to enhance can change.
* The competitive environment of the real-world activity can change.
* The technological landscape assumed by the analysis phase can change.

However, these strict step-by-step processes and lack of foresight into potential future changes do not mean that this model is useless. Because each stage must be fully completed and understood, this model is very beneficial for large projects that multiple teams from multiple sperate locations work on a workflow would be more efficient if each team was on the same page/understanding as each other.

##### [Agile](https://www.agilealliance.org/)

Rapid development and delivery is an important factor for software engineering as software needs to be able to address new changes to requirements. To address this, agile methods were created to put more emphasis on the end product rather than the documentation that may be made along the way. In other words, of working long hours on documentation, the agile approach aimed to cut the overhead caused by the documentation and focus on the development of the actual code.

Every agile method share these characteristics:

* Specification, design, and implementation are mixed as system specification, design documentation, and user requirements are usually minimized to save time during development or are automatically generated.
* Systems are usually developed in increments so that consumers and other stakeholders can give their input during the development phase
* Many tools are used to aid during development. Examples of such tools are tools that automatically test your code, help you make the process of designing and creating the user interface easier, etc.

Agile has the following limitations:

* It is not the ideal solution for small developer teams.
* It has a higher cost compared to other workflow models.
* The project can go off target if the project manager is not sure of the direction to take.

![](https://user-images.githubusercontent.com/14268523/121416020-5536be00-c936-11eb-8584-5c3f62112840.png)

The above image depicts a plan based development lifecycle vs an agile development cycle.

##Practice Coding Challenge

<br>

