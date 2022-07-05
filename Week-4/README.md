# Monday - HAPPY 4th of JULY !

# Tuesday - Intro to 'Front End'

## HTML (Hypertext Markup Language)

### Introduction to HTML

* [HTML](https://en.wikipedia.org/wiki/HTML) stands for Hypertext Markup Language - it is a markup language for creating web pages and applications. 
* HTML contains a particular syntax - namely **elements** and **attributes** - that web browsers parse in order to render the content of the webpage. 
* With HTML, the structure and content of a webpage is defined. Styling and dynamic behavior are introduced with CSS and JavaScript, respectively.

#### HTML5

HTML5 introduced a new **DOCTYPE** declaration `<!DOCTYPE html>` and the character encoding (charset) declaration `<meta charset="UTF-8">`.  The `<DOCTYPE>` declaration is used to inform the browser about the version of HTML used in the document. It is known as the Document Type Declaration (DTD). It just instructs the browser about the document type. A **character encoding** is an approach of converting bytes into characters. For validating the HTML document, a program must choose a character encoding.

HTML5 also introduced features to allow us to embed audio and video files on the web page and provides the support to run JavaScript in the background.

Take a look at the structure of the HTML5 file given below:

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Title of the document</title>
  </head>

  <body>
    Content of the document......
  </body>
</html>
```

> **NOTE:** HTML5 uses UTF-8 as a default character encoding.

> `<!DOCTYPE html>` should be in the beginning of the document before any tags.


### Helpful Resources

* [Mozilla](https://mdn.dev)

### Starting HTML Documents

Every HTML document (ending with `.html` extension) should begin with a special tag known as the DOCTYPE declaration - this lets browsers know what kind of document it is using (HTML, in our case) as well as which version of the markup language is being used. For HTML5, the newest version and the one which we'll be using, the DOCTYPE syntax is:

```html
<!DOCTYPE html>
```

The doctype declaration tag does not have a closing tag and it is not self-closing either.

Next, the tag which begins the root of our HTML document is the `<html>` tag. Everything about our webpage will be nested within this tag.

Within the `html` element we have two important tags - the `<head>` and the `<body>` tags. The `head` element will contain all the metadata associated with this page, including the title, character encodingg, and references to external stylesheets. The `body` element contains the actual content of our page that will be rendered on the screen by the browser.

### Hello World Example

Let's write a simple webpage that will show off our knowledge of HTML thus far. Open up a new file in a simple text editor and save the file as `hello-world.html`. Then write the following HTML markup and save it:

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Hello World!</title>
    <meta charset="utf-8">
  </head>
  <body>
    <div>
      <!-- THIS IS A COMMENT! -->
      <p>This is my first paragraph written in HTML</p>
    </div>
  </body>
</html>
```

The only tag you may be unfamiliar with is the `meta` tag above - this defines the character encoding that the file will be using. Also, the `<!-- ... -->` syntax denotes a comment.

If you now open your `hello-world.html` file in your browser of choice, you'll see your webpage rendered. It may look ugly now, but we'll address that when we talk about CSS.

## HTML Tags

### Common HTML Tags

There are a vast number of HTML tags you could use on your webpage, but below are listed the most common:

* `<div>` - defines a "division of the page"
* `<p>` - defines a paragraph
* `<span>` - an inline tag for grouping text or elements
* `<b>` - bold text
* `<i>` - italicized text
* `<h1>`, `<h2>`, ... `<h6>` - these are headings, h1 is largest and h6 is smallest
* `<br>` - line break
* `<table>` - defines a table
* `<img src="URL">`
* `<ol>` - an ordered list
* `<ul>` - an unordered list
* `<a href="">` - makes a hyperlink

####  Hyperlinks

To make a hyperlink in a webpage, use the `<a>` tag:

```html
<p> Here is a <a href="www.google.com">link to Google!</a></p>
```

#### Tables

To create a table, use the following markup. `<tr>` defines a table row, `<td>` defines a table cell, and `<th>` is used for table headers.

```html
<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Alice</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Bob</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Charlie</td>
    </tr>
  </tbody>
</table>
```

#### Lists

There are two options for making lists in HTML - ordered or unordered lists. Ordered lists are defined with `<ol>`, unordered lists are defined with `<ul>`, and the list items within either are denoted with `<li>`:

```html
<ol> <!-- ordered lists render as 1, 2, 3, etc.. -->
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ol>
<ul> <!-- list items in here will just be bullet points -->
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ul>
```
### Elements

HTML is composed of many different **elements** - these provide the structure of the document. Elements are defined within HTML files using **tags** - for example, one very common tag is the `<div>` tag. The tag is enclosed within angle brackets. Most elements have a closing tag which define the end of the element, using the backslack notation - for example, a closing "div" tag would be `</div>`. HTML elements may be *nested* within other elements, like so:

```html
<div> text inside the div but outside the paragraph
  <p> this text is inside the paragraph </p>
</div>
```

In order for HTML to be **valid**, tags must be properly nested - an outer tag cannot be closed before an inner one. For example, the following markup would not be considered valid:

```html
<div> invalid!
  <p> cannot close the div here => </div>
</p>
```

Not all elements have closing tags, some are self-closing. For example, the `<img />` tag, which defines an image.

###  Attributes

HTML elements can also have **attributes** defined within the tag - these are key/value pairs that give metadata about the tag that are important for the browser to know. For example, image elements must have a URL which the browser can call to retrieve the image file to display on the page - we use the `src` attribute to do this: `<img src="/URL/to/get/cat.png" alt="cool cat!" />`. As you may have guessed, the `alt` attribute specifies an alternative text to show when the image cannot be displayed.

#### Global Attributes

**Global** attributes are those that can be applied to any element on the page. Some important global attributes are:

* class
* id
* hidden
* lang
* style
* tabindex
* title

There are also many attributes that should be applied to only certain elements, including the `src` and `alt` attributes shown above. We'll discuss more about these when relevant.

### HTML Forms

An  **HTML form**  is  _a section of a document_ that contains controls such as text fields, password fields, checkboxes, radio buttons, submit button, menus, etc. Using these elements the page can collect information from a user which is typically submitted to a web server.
To create a form, you would use the `<form>` tag.

 *Why use an HTML Form?*
* We use forms to collect some information/data form the user.
    * For example: If a user wants to purchase some items on the internet, he or she must fill out the form which will collect information such as the shipping address and payment details so that the item can be sent to the given address.

#### Input Element in HTML Forms 

An HTML form collects information from **<input>** elements. You will specify an addition **type** attribute to indicate which field to display. Various fields can be created such as a text field, checkbox, password field, or radio button.

#### Text Field 

A text field is a one-line input field that allows the user to input a line of text. Text Fields are created by specifying the type attribute value as "text".


The below example will display a text field with the label _Email Id:_

**Example**
```html
<form> 
    <label for="email-input">Email Id:</label><br> 
    <input type="text" name="email-input" /> 
</form> 
```


#### Password Field

Password fields are a type of text field in which the text entered is masked using asterisk or dots. This prevents others form viewing the screen to see what is typed in. Also, its created by specifying the type attribute value as "password".

**Example**
```html
    <form> 
        <label for="user-password">Password:</label><br/> 
        <input type="password" name="user-password"/> 
    </form> 
```

>  **NOTE**:
Although a password field is masked, it is NOT encrypted. You will have to use other measures such as HTTPS to encrypt data once the HTML form is submitted. 

#### Radio Buttons

Radio Buttons are used to let the user select exactly one value from a list of predefined options. It is created by specifying the type attribute value as "radio".

**Example**
```html
    <form> 
        SELECT GENDER 
        <br/> 
        <input type="radio" name="gender" id="male"> 
        <label for="male">Male</label><br> 
        <input type="radio" name="gender" id="female"> 
        <label for="female">Female</label> 
    </form> 
```

> **NOTE**: 
A form may have multiple sets of radio buttons. In order to make sure the user only selects one option from a given set, each radio <input> element must have matching `name` attributes.
In the example above, both buttons have a `name` attribute value as **gender**.

#### Checkboxes

Checkboxes are used to let the user select one or more values from a pre-defined set of options. The type attribute value for checkboxes input control is "checkbox".

**Example**
```html
    <form> 
        <b>SELECT SUBJECTS</b> 
        <br> 
        <input type="checkbox" name="subject" id="math" /> 
        <label for="math">Math</label> 
        <input type="checkbox" name="subject" id="science" /> 
        <label for="sceince">Science</label> 
        <input type="checkbox" name="subject" id="english" /> 
        <label for="english">English</label> 
    </form> 
```

> **NOTE**: 
Just like radio buttons, a form may have multiple sets of checkboxes. In order to make sure the user selects options related to a given set, each checkbox <input> element must have matching `name` attributes.
In the example above, each checkbox has a `name` attribute value as **subject**.

## File select boxes 

File select boxes are used to allow the user to select a local file on their computer and send it as an attachment to the webserver. It is similar to a text box with a button that allows the user to browse for a file. Instead of browsing for the file, the path and the name of the file can also be written. They are created by specifying a type attribute value as "file".


**Example**
```html
    <form> 
        <label for="fileselect">Upload:</label> 
        <input type="file" /> 
    </form> 
```

## Text area

A text area is a multi-line text input control which allows users to provide a paragraph or multiple lines of text. It is created by using the "textarea" element. 

This is one of the few input controls that DO NOT use the `<input>` element.

You can control the size of a text area by adding attributes "rows" and "cols" to specify the number of rows and columns of text it supports. Most often text area elements are resizable, but the default size is managed by those two attributes. 


**Example**
```html
    <form> 
        <label for="Description">Description:</label> 
        <textarea rows="5" cols="50" name="Description"
                            id="Description"></textarea> 
    </form> 
```

## Select Boxes (Drop-downs) 

Select boxes are used to allow users to select one or more options from a drop-down list. 
Select boxes are created by using two elements: `<select>` and `<option>`. The `<select>` element defines a drop-down while list items are defined within the select element using `<option>` elements. 


**Example**
```html
   <form> 
        <label for="country">Country:</label> 
        <select name="country" id="country"> 
            <option value="United States">United States</option> 
            <option value="Canada">Canada</option> 
            <option value="Mexico">Mexico</option> 
        </select> 
    </form> 
```



## Reset And Submit Buttons 


The **submit** button allows the user to send the form data to the web server. You can define a submit button by specifying the type attribute as "submit".

The **reset** button is used to reset the form data and will display any default values. You can define a reset button by specifying the type attribute as "reset".

**Example**
```html
    <form action="test.php" method="post" id="users"> 
        <label for="username">Username:</label> 
        <input type="text" name="username" id="Username" /> 
        <input type="submit" value="Submit" /> 
        <input type="reset" value="Reset" /> 
    </form> 
```


### Attributes Used in HTML Forms

There are several attributes that you can use on the `<form>` tag and on `<input>` elements. 
We will cover:

* action
* target
* name
* method
* value
* placeholder
* required

Take a look at the following example and find the different attributes:

```html
<!DOCTYPE html> 
<html> 
<body> 
  
<form action="/test.php" target="_blank" method="GET"> 
  Username:<br /> 
  <input type ="text" name="username" placeholder="Username" required/> 
  <br /> 
  Password:<br /> 
  <input type ="password" name="password" /> 
  <br /><br /> 
  <input type ="submit" value ="Submit" /> 
</form>  
  
</body> 
</html> 
```

#### The Action Attribute

The action attribute indicates where the form data will be processed. Typically the value is a URL of a server. 
Generally, the form data is sent to a webpage on the webserver after the user clicks on the submit button.

>In the above code, after clicking on the *submit* button, the form data would be sent to a page called *test.php*.


#### The Target Attribute

The Target attribute is used to specify whether the submitted result will open in the current window, a new tab or on a new frame. 
The default value used is "self" which results in the form submission in the same window. 
To make the result display in a new browser tab, the value should be set to "blank".

> In the above code, after clicking on the *submit* button, the result will open in a new browser tab. Most often this attribute is not present and the default value of "self" is used.

#### Name Attribute 

The name attribute should be provided for each input element. It is not required, but the value provides a label for the data once the form is submitted. 
If the name attribute is not specified in an input field then the data of that field will not be sent.

> In the above code, after clicking the *submit* button, the form data will be sent to a page called */test.php*. 
> The data sent will include the *username* and *password* fields.

#### The Method Attribute

The method attribute is used to specify the HTTP method used to send data while submitting the form.
There are only two options available: GET and POST.

**GET** - When using the GET method, after the submission of the form, the form values will be visible in the address bar of the browser.

**POST** – When using the POST method, after the submission of the form, the form values will NOT be visible in the address bar of the browser.

#### The value Attribute

The value attribute specifies an initial value for an input field. It also serves as the attribute to use when providing a button label for submit and reset input elements. 

> In the above example, there are no default values. 

#### The placeholder Attribute

The placeholder attribute specifies a hint that describes the expected value of the input field (a sample value or a short description of the expected format).
The short hint is displayed in the input field before the user enters a value.
The placeholder attribute works with the following input types: text, search, url, tel, email, and password.

> In the above example, the text field has a placeholder of "Username".

#### The required Attribute

The required attribute indicates an input field that must be filled out before submitting the form. In most modern browsers, it will prevent the user from submitting the form until an acceptable value is entered.
The required attribute works with the following input types: text, search, url, tel, email, password, date pickers, number, checkbox, radio, and file.

> In the above example, only the text field is required.  
> **NOTE**: The required attribute doesn't have a value portion. You only need to specify the word 'required'. 

#### The min and max Attributes

The min and max attributes specify the minimum and maximum values for an input field.
The min and max attributes work with the following input types: number, range, date, datetime-local, month, time and week.

> **Tip**: Use the max and min attributes together to create a range of legal values. (For example: Set a maximum date or a minimum date)

*Example*
```html
<form>
  <label for="datemax">Enter a date before 1980-01-01:</label>
  <input type="date" id="datemax" name="datemax" max="1979-12-31"><br><br>

  <label for="datemin">Enter a date after 2000-01-01:</label>
  <input type="date" id="datemin" name="datemin" min="2000-01-02"><br><br>

  <label for="quantity">Quantity (between 1 and 5):</label>
  <input type="number" id="quantity" name="quantity" min="1" max="5">
</form>>
```
