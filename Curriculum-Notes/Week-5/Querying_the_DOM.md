# Selecting elements from the DOM

JavaScript is used to get or modify the content or value of the HTML elements on the page. To perform any action on the HTML element, we need to select the target HTML element. 

The ways for selecting the elements on a page are listed below:

## Selecting Elements by ID

The `getElementById()` method is used to select an element based on its unique ID. The `getElementById()` method will return the element as an object if the matching element was found, or null if no matching element was found in the document.

**Example:** In the example below, `getElementById()`is a method, while `innerHTML` is a property. It selects the element with the `id = "demo"` attribute and changes the content to "Paragraph Changed".

```html
<body>
    <p id="demo">This is a paragraph.</p>
    
    <script>
        document.getElementById("demo").innerHTML = "Paragraph Changed";
    </script>
</body>
```

## Selecting Elements by Class Name

The `getElementsByClassName()` method used to select all the elements having specific class names. This method returns an array-like object of all child elements which have all of the given class names.

**Example:** selects the list of elements which have `class="test"` attribute and changes the background color as yellow.

```html
<body>
<div class="test"> This is a div element with class="test". </div>

<p>
	<h1 class= "test"> This is a h1 element with class="test". </h1>
	This is a paragraph.
</p>

<p class="test">This is a p element with class="test".</p>

<script>
	var matches = document.getElementsByClassName("test");
	for(var elem in matches) {  
        matches[elem].style.background = "yellow";
    }
</script>
</body>
```

## Selecting Elements by Tag Name

The `getElementsByTagName()` method used to select HTML elements by tag name. This method also returns an array-like object of all child elements with the given tag name.

**Example:** selects all the `<p>` element and changes the background color as red.

```html
<body>
    <h1> Heading </h1>
    <p>This is a paragraph of text.</p>
    <div>This is another paragraph of text.</div>
    <p>This is one more paragraph of text.</p>   
 
    <script>
       	var matches = document.getElementsByTagName("p");
        
        for(var elem in matches) {  
        matches[elem].style.background = "red";
        }
    </script>
</body>
```
## Selecting Elements with CSS Selectors

We can use `querySelector()` and `querySelectorAll()` methods to select elements that matches the specified CSS selector. The `querySelector()` finds the first element that matches a CSS selector whereas the `querySelectorAll()` finds all elements that match a CSS selector.

**Example:**
```html
<body>
    <p id = "para">This is a paragraph</p>
    <ul>
        <li>Apple</li>
        <li>Orange</li>
        <li>Mango</li>
    </ul>
        
    <script>  
    var matches = document.querySelectorAll("ul li");
 
    for(var elem of matches) {  
        document.write(elem.innerHTML + "<br>"); //outputs: "Apple Orange Mango"
    }
      document.write(document.querySelector('#para').textContent); //outputs: "This is a paragraph"
     
    </script>
</body>
```



