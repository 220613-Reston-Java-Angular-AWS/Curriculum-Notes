## Event Object
In JavaScript, events are represented by an Event Object. These objects all derive from the Event prototype, meaning that all events in JavaScript share certain properties.

### Properties and Methods
The following is a selection of the properties and methods of the Event Prototype. A more complete list can be found [here](https://www.w3schools.com/jsref/obj_event.asp).
* `bubbles`: a boolean value. A `true` value indicates that the event is bubbling, `false` indicates that it is capturing. See [Bubbling and Capturing](./bubbling-capturing.md) 
* `currentTarget`: a reference to the DOM element whose event listener triggered this *specific* event. This is different from the event that initially triggered the event as a single event can trigger multiple event listeners through propagation.
* `preventDefault()`: Cancels the event, preventing the default action that would normally occur.
* `stopPropagation()`: Prevents the event from propagating further.
* `target`: a reference to the DOM element which triggered the event.
* `timeStamp`: the time of the event in milliseconds
* `type`: the type of the triggered event.

## Children of the Event Object
There are several subclasses of the Event Object, and here we will discuss the MouseEvent and the KeyboardEvent. Bear in mind that each of these includes all of the properties of the standard Event object. **Note**: There are MANY kinds of events, including the AnimationEvent, ClipboardEvent, DragEvent, FocusEvent, InputEvent, StorageEvent, and WheelEvent. For a more complete list [click here](https://www.w3schools.com/jsref/obj_events.asp)

### MouseEvent
One of the first events most people encounter is the `click` event. That event along with several others, creates a MouseEvent. The MouseEvent has many properties that have to do with the state of the machine when the MouseEvent occured, such as the coordinates of the mouse relative to the window (`clientX` and `clientY`), the coordinates of the mouse relative to the last event (`movementX` and `movementY`), the coordinates of the mouse relateve to the target element (`offsetX` and `offsetY`), the coordinates of the mouse relative to the screen (`screenX` and `screenY`), whether the `alt`, `ctrl`, or `shift` keys were depressed when the event was triggered (`altKey`, `ctrlKey` and `shiftKey`), and which mouse button was pressed (`button`, `buttons`, and `which`)
### KeyboardEvent
The KeyboardEvent is often encountered when trying to add additional functionality to a webform. For example, you may wish to submit a form when the `return` key is pressed. For this, you have to have a KeyboardEvent that checks the `key`, `keyCode`, or `which` properties to determine whether or not the `return` key was the key that was pressed. Like the MouseEvent, we also have the `altKey`, `ctrlKey`, and `shiftKey` fields to determine if those buttons were pressed at the time of the event. Finally, we have a `repeat` property that determines if a key is being held down.


## Example
Create the following files, `index.html` and `index.js` and place them in the same directory.
### index.html

```
<html>
<body>
<h1> Open the console </h1>
<div id="div">
<button id="button">Button</button>
</div>
<script src="index.js"></script>
</body>
</html>
```

### index.js

```
window.onload = () => {
	console.log('Click the button')
	document.getElementById('button').onclick = examineEvent
	// This is the right-click event
	document.getElementById('button').oncontextmenu = examineEvent
	document.getElementById('div').onclick = examinePropagatedEvent
}

function examineEvent(eventObject) {
	// This event is the click event on the button object
	
	// Uncomment this to prevent the default right-click behavior
	eventObject.preventDefault()

	console.log('This is what a ClickEvent looks like:')
	console.log(eventObject)
	
	console.log('Let\'s look at a few specific properties')
	console.log('type='+eventObject.type)
	console.log('0 is left-click, 2 is right-click')
	console.log('button='+eventObject.button)
	console.log('target:')
	console.log(eventObject.target)
	
	console.log('time:'+eventObject.timeStamp)
}

function examinePropagatedEvent(eventObject) {
	// This event is the click event but on the div object
	console.log('PropagatedEvent - target:')
	console.log(eventObject.target)
	console.log('PropagatedEvent - currentTarget:')
	console.log(eventObject.currentTarget)
}
```