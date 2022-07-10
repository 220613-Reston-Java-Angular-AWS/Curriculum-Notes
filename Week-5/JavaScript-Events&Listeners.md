## JavaScript Events

Events occur when user interaction takes place on a web page, such as when the end-user clicked a link or button, pressed a key on the keyboard, moved the mouse pointer, submits a form, etc. The browser also triggers the events, such as the page load and unload events.

When an event occurs, we use a JavaScript event handler (or an event listener) to detect them and perform a specific task.

Some of the commonly used JavaScript Events are listed below:

* **onclick** -  This is a click event occurs when a user clicks the element on a web page. 

* **ondblclick** -  This is a click event occurs when a user double clicks the element on a web page.

* **onload** - This is a load event occurs when the browser has finished loading the page.

* **onunload** - This is a load event occurs when a user closes the document.

* **onresize** - This is a load event occurs when the browser window is minimized or maximized.

* **onmouseover** -	This is a mouse event occurs when the user moves the mouse over an HTML element.

* **onmouseout** - This is a mouse event occurs when the user moves the mouse away from an HTML element.

* **onkeydown** - This is a keyboard event occurs when the user presses down a key on the keyboard. 

* **onkeyup** - This is a keyboard event occurs when the user releases a key on the keyboard.

* **onfocus** - This is a form-input event occurs when the user gives focus to an element on a web page.

* **onblur** - This is a form-input event occurs when the user takes the focus away from a form element or a window.

* **onchange** - This is a form-input event that occurs when a user changes the value of a form element.

* **onsubmit** - This is a form-input event that occurs when the user submits a form on a web page.

**Example:** 
```html
<body>
    <button onclick= onclickEvent()>Click me!!</button>
    <p id= "para" onmouseover = onmouseoverEvent() onmouseout = onmouseoutEvent() >This is a Paragraph....</p>
    <script>
        function onclickEvent(){
            alert('Hello, You clicked the button');
        }
        function onmouseoverEvent(){
            document.getElementById("para").style.backgroundColor = "green";
        }
        function onmouseoutEvent(){
            document.getElementById("para").style.backgroundColor = "yellow";
        }
    </script>
</body>
```

## JavaScript EventListener

An event listener is a function in JavaScript that waits for an event to occur. The `addEventListener()` function is an inbuilt function in JavaScript used to handle the event.

The Syntax of addEventListener() function: `element.addEventListener(event, function, useCapture)`

Where,
* event - Specifies the name of the event.
* function - Specifies the function to run when the event occurs
* useCapture - It is an optional parameter takes a boolean value. If the parameter value is true then the event handler is executed in the capturing phase. If the parameter value is false then the event handler is executed in the bubbling phase.  

The `removeEventListener()` method used to remove an event handler that has been attached with the `addEventListener() method`.

**Example:**
```html
<body>
    <h2>JavaScript addEventListener()</h2>
    <p id="myBtn">This is a paragraph.</p>
    <p id="demo"></p>
    <script>
        var x = document.getElementById("myBtn");
        x.addEventListener("mouseover", myFunction);
        x.addEventListener("mouseout", mySecondFunction);

        function myFunction() {
        document.getElementById("demo").innerHTML += "Moused over!<br>";
        x.style.backgroundColor = "green";
        }
        function mySecondFunction() {
        document.getElementById("demo").innerHTML += "Moused out!<br>";
        x.style.backgroundColor = "white";
        }
        
    </script>
</body>
```
