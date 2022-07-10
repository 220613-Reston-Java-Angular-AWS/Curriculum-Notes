## Event Bubbling

In Event Bubbling, the event propagates from the target element to its parents, then all its ancestors that are on the way to top.
 Bubbling follows the **Bottom to Top** approach.

**Example:** Event Bubbling works for all handlers, regardless of how they registered with the `addEventListener()`. When we click on any element, event propagates or bubbles back up the DOM tree, from the target element up to the Window, visiting all of the ancestors of the target element one by one. (a-> p -> div)
```html
<body>
<div onclick="alert('Bubbling: ' + this.tagName)">DIV
    <p onclick="alert('Bubbling: ' + this.tagName)">P
        <a href="#" onclick="alert('Bubbling: ' + this.tagName)">Click Me!!</a>
    </p>
</div>
</body>
```
If we click on the `<a>` element in the above example, it results in the alert pop-ups in below order:
1. alert pop-ups saying 'Bubbling: a' 
2. alert pop-ups saying 'Bubbling: p'
3. alert pop-ups saying 'Bubbling: div'


## Event Capturing

In Event Capturing, the event propagates from the top element to the target element. Capturing follows the **Top to Bottom** approach.

**Example:** Event capturing only works with event handlers registered with the `addEventListener()` method when the third argument is set to true. When we click on the any element, the event capturing propagates the element from top element to target element (div -> p -> a). 
```html
<body>
<div id="wrap">DIV
    <p class="hint">P<br>
        <a href="#">Click Me!!</a>
    </p>
</div>

<script>
    function showTagName() {
        alert("Capturing: "+ this.tagName);
    }
    
    var elems = document.querySelectorAll("div, p, a");
    for(let elem of elems) {
        elem.addEventListener("click", showTagName, true);
    }
</script>
```

If we click on the `<a>` element in the above example, it results in the alert pop-ups in below order:
1. alert pop-ups saying 'Capturing: div' 
2. alert pop-ups saying 'Capturing: p'
3. alert pop-ups saying 'Capturing: a'

**Event Target**

Event Target is the target element that has generatd the event in DOM. The `event.target` is used to access the target element. 

**Stopping the Event Propagation**

* event.stopPropagation() method 

It used to stop the event to travel to the bottom to top i.e. Event Bubbling. If you want to stop the event flow from event target to top element in DOM, we use `event.stopPropagation()` method.

* event.stopImmediatePropagation() method

If an element has multiple event handlers on a single event, then even if one of them stops the bubbling, the other ones still execute. The `event.stopPropagation()` stops event bubbling but all other handlers will run. To stop the bubbling and prevent handlers on the current element from running, we use `event.stopImmediatePropagation()` method. 