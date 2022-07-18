# Memory Usage and Computers

## Overview 
[Video on Memory Structures in Computers](https://vimeo.com/revature/review/415278307/1684a69c43)

Essentially computer "memory" can be divided into two general categories- *memory* and *storage*. 

*Storage* is persistant, slower, and cheap. When we save files to a hard disk we are adding them to our storage. 

Meanwhile, *memory* typically refers to the volatile and fast portion of memory. When you go to run an application, all the necessary files that store the data and the instructions for the program get loaded into *memory*. This allows the CPU to execute the instructions as they come and quickly gather everything needed to support those actions. 

## Memory Usage of a Program

Thus, when we go to run the programs that we have developed ourselves the same process occurs. Our program is allotted a certain portion of memory based on its needs. As its instructions run, they manipulate the portion of memory that the program was given. 

For the most part the nuts and bolts of this proceess are abstracted away from us, but there are moments where we do have to bear in mind this underlying system. 

As we approach programming our goal is to write efficient programs. Namely efficient in terms of the resources they require. 

One of the manners in which we can be efficient is in regards to the amount of data we store and how we store it, especially because as we scale up our program any inefficiencies become more pronounced. 

One of the first places to consider is the information we store in variables. 

Depending on their datatype and the language being used, the information will be stored in a particular format, but in every case the variable will take up some measurable amount of space. This is space is measured in bits. Each bit can store either a zero or a one. And the computer will understand how to translate that format of zeros and ones into the information we can make sense of. 

So, you may think that then we should just always use the minimum amount of bits and it'll be smooth sailing, but the computer needs structure around its conversion/formatting. 

Therefore, certain datatypes will always take a up a set amount of space. Let's imagine for a minute that we have a number. 

The computer might store it differently if our number might have a decimal or if our number can be negative or if there is a chance that this might reach a certain size. Some programming languages will decide this for you and look to accommodate your needs as the value changes. Other languages might expect you as the developer to let them know what type of information you're storing. 

There are drawbacks and benefits of either case, but one thing that we need to keep in mind in either circumstance is that the operations we perform may cause the program to step outside of what the program can reasonably store in binary(the zeros and ones I mentioned earlier). 

Think for a minute about 1/3. If we try to represent this as a decimal we are guaranteed to fall short- 0.33333333... 

There are numbers that do the same when represented in binary and sometimes when we perform operations this misrepresentation occurs at an intermediary step. As a result, when some operation isn't working as expected, we may need to take a step back and look at how we are storing our variables.

Moreover, because of the finite space alotted, certain datatypes have specific ranges of acceptable values. 

Finally, there is one more consideration to layer on to this foundation. What about more complex datatypes, what if you have something that can grow dynamically, or something that stores some text- but you don't know how much beforehand? 

Well in cases like those, typically, the variable will hold a memory address or a *reference* to the additional information. Essentially the variable just tells the program where to look/add for the information. This allows the program to store the actual information in a portion of it's memory that can be allocated more flexibly. 