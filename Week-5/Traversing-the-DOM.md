# Traversing the DOM 

The DOM allows us to do anything with elements and their contents, but first we need to reach the corresponding DOM object. The properties used to transverse the DOM or to reach/get a particular DOM object are listed below:

## Topmost nodes

The `document` object is the root of every node in the DOM. The topmost tree nodes are associated with document properties:

* `document.documentElement` property - refers the DOM node of the `<html>` tag.
* `document.head` property - refers the DOM node of the `<head>` tag.
* `document.body` property -  refers the DOM node of the `<body>` tag.

## Parent Nodes

The parent of any node is the node that is one level above in the DOM tree. There are two properties to get the parent — `parentNode` and `parentElement`. The `parentNode` is most commonly used for traversing the DOM.

**Example:**
```html
<body>
    <div id="main">
        <p id="para">This is a note!</p>
    </div>

    <script>
        let elmt = document.querySelector('#para');
        document.write(elmt.parentNode+ "<br>"); // outputs: [object HTMLDivElement]
    </script>
</body>
```

The `parentElement` property returns the “element” parent, whereas `parentNode` returns “any node” parent. With the one exception of `document.documentElement`:
```javascript
alert( document.documentElement.parentNode ); // document
alert( document.documentElement.parentElement ); // null
```

## Child Nodes

The children of a node are the nodes that are one level below it. The properties are listed below:

* `childNodes` property - returns a list of child nodes, including text nodes.
* `firstChild` property - give access to the first child node.
* `lastChild` property - give access to the last child node.

**Example:**
```html
<body>
	<div id="myDiv">
       	<p>This is a paragraph - first child</p>
        <div> this is a div elemt - last child</div> 
    </div>
    <script>
        let elmt = document.querySelector('#myDiv');
       	document.write("<br> Child nodes of div element: <br>");
        for (let i = 0; i < elmt.childNodes.length; i++) {
              document.write(elmt.childNodes[i]  + "<br>");
              }
              
       document.write("<br> First child of div element: <br>" +elmt.firstChild) ; 
       
       document.write("<br> Last child of div element: <br>" +elmt.lastChild) ;        
    </script>
</body>
```
The output will be:
```
This is a paragraph - first child

this is a div elemt - last child

Child nodes of div element: 
[object Text]
[object HTMLParagraphElement]
[object Text]
[object HTMLDivElement]
[object Text]

First child of div element: 
[object Text]
Last child of div element: 
[object Text]
```

## Sibling Nodes

Siblings are nodes that are children of the same parent. The siblings of a node are any node on the same tree level in the DOM.

* `previousElementSibling` property - give access to the previous sibling Node, i.e. the node that immediately precedes the specified node. 
* `nextElementSibling` property - give access to the next sibling vode, i.e. the node that immediately precedes or follows the specified node.

**Example:**
```html
<body>
    <ul >
        <li>list item 1</li>
        <li class="list">list item 2</li>
        <li>list item 3</li>
    </ul>
    <script>             
       const secondListItem = document.querySelector('.list');       
        document.write(secondListItem.previousElementSibling.textContent) ;  // outputs:  "list item 1"
       document.write(secondListItem.nextElementSibling.textContent);   //outputs: "list item 3"           
    </script>
</body>
```