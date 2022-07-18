# DOM Manipulation

We can add, remove, replace, and copy any element into a DOM tree. DOM Manipulation methods are listed below:

## Create Elements

The `createElement()` method is used to create a new element and attach it to the DOM tree.

**Example:**
```javascript
var elmt = document.createElement('div');
elmt.innerHTML = '<p>Hello World!</p>';
```

## Replace Child Elements

The `replaceChild()` method is used to remove an element from the DOM tree and insert a new one in its place.

**Example:**
```html
<body>
<div>
	This is a div element.
<div>

<script>
    // selecting the <div> element
  	var elmt = document.querySelector('div'); 

    //creating new <p> element and adding content inside it. 
	var newElmt = document.createElement('p');  
	newElmt.innerHTML = '<b>The div element is replaced with p element</b>';

    //replacing the <div> element with the <p> element
	elmt.parentNode.replaceChild(newElmt, elmt);

</script>
</body>
```

## Remove Child Elements

The `removeChild()` method is used to remove an element from the DOM tree.

**Example:** Here, first we select the element to remove, then walk up the tree to its parent and remove the child element from there.
```javascript
var elmt = document.querySelector('div'); // select the first returned <div> element 
elmt.parentNode.removeChild(elmt);
```

## Append a Node

The `appendChild()` method is used to add a node to the end of the list of child nodes of a specified parent node.

**Example:** Here, we add three list items to the `<ul>` element
```html
<body>
    <ul id="animals">
    </ul>
    
    <script>
        function createAnimalList(name) {
            let li = document.createElement('li');
            li.textContent = name;
            return li;
        }
        // get the ul #animals
        const list = document.querySelector('#animals');
        // add animals to the list
        list.appendChild(createAnimalList('Lion'));
        list.appendChild(createAnimalList('Tiger'));
        list.appendChild(createAnimalList('Wolf'));
    </script>
</body>
```

##  Insert a Node before another
The `insertBefore()` method is used to insert a node before another node as a child node of a parent node.

**Example:** Here, we insert the new `<li>` element before the first child of `<ul>` element.
```html
<body>
    <ul id="animal">
    <li>Lion</li>
    <li>Tigerr</li>
    </ul>
    
   <script>
        let animal = document.getElementById('animal');
        
        // create a new li node
        let li = document.createElement('li');
        li.textContent = 'Wolf';

        // insert a new node before the first list item
        animal.insertBefore(li, animal.firstElementChild);
    </script>
</body>
```

## Insert a Node After another

JavaScript DOM provides the `insertBefore()` method that allows you to insert a new after an existing node as a child node. However, it hasn’t supported the insertAfter() method yet.

So, we can insert a new node after an existing node as a child node, by selecting a parent node of the existing node and call the `insertBefore()` method on the parent node to insert a new node before that immediate sibling node.

**Example:** Here, we inserts the new `<li>` element after the first child of `<ul>` element.
```html
<body>
    <ul id="animal">
    <li>Lion</li>
    <li>Tiger</li>
    </ul>
    
   <script>
        let animal = document.getElementById('animal');
        
        // create a new li node
        let li = document.createElement('li');
        li.textContent = 'Wolf';

        // insert a new node before the first list item
        animal.insertBefore(li, animal.firstElementChild.nextSibling);
    </script>
</body>
```

## Get or Set text of a Node

The `textContent` property is used to get and set a text content inside a particular node.

**Example:**
```html
<body>
    <div id = "content">
    	This is div element.
    </div>
   <script>
   		// Getting a text content
        let content = document.getElementById('content');
		alert("Getting a text content inside div element: " +  content.textContent);
        
        //setting a text content
       content.textContent = 'New text content in the div element';
        
    </script>
</body>
```

## Get or Set HTML of Element

The `innerHTML` property to get the text and inner HTML elements inside a the particular element and the setting will replace the existing text and inner tags inside an element with the new content.

**innerHTML vs textContent** - The `innerHTML` property returns the text and inner HTML elements. The `textContent` property returns only the text Content.

**Example:**  
```html
<body>
  <div id="myBdy">
    <p id = "para">This is Paragraph.</p>

    <button onclick="myFunction()"  >Try it</button>

    <p id="demo"></p>

  </div>
<script>
  function myFunction() {
      // get HTML of Element
    var x = document.getElementById("para").innerHTML;
    document.getElementById("demo").innerHTML = x;  
  }
// You can understand the difference between innerHTML and textContent property clearly from the output of the
// below two alert boxes
  alert ("textcontent property:" + document.getElementById("myBdy").textContent);
  alert ("innerHTML property:" + document.getElementById("myBdy").innerHTML);
</script>

</body>
```

## Clone a Node

The `cloneNode()` method is used to clone an element. The cloneNode() method accepts an optional parameter. If the parameter value is `true`, then the original node and all of its descendants are cloned. If the parameter value is false, only the original node will be cloned.

**Example:** Here, the parameter value for `cloneNode()` method is `true`. So it clones the target node and all of its descendants.
```html
<body>
    <ul id="animal">
        <li>Lion</li>
        <li>Tiger</li>
        <li>Wolf</li>
    </ul>
   <script>            
        let list = document.querySelector('#animal');
        let clonedList = list.cloneNode(true);
        clonedList.id = 'cloned animal';
        document.body.appendChild(clonedList);
    </script>
</body>
```

## Managing Attributes

* `getAttribute(attribute_name)` method - Used to get the value of an attribute on a specified element
* `setAttribute(attribute_name, attribute_value)` method - Used to set a value of an attribute on a specified element,  
* `removeAttribute(attribute_name)` method - Used to remove an attribute with a specified name from an element
* `hasAttribute(attribute_name)` method - Used to check an element has a specified attribute or not.

