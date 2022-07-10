# Timing Events

In JavaScript we make use of timing events when we are looking to automate tasks or run tasks after waiting a specific length. There are two key timing event methods in JavaScript and both are functions of the `window` object. These methods are `setTimeout()` and `setInterval()`.

## setTimeout
The `setTimeout()` function has the following signature:

```window.setTimeout(callbackFunction, milliseconds)```

This function executes the given callback function after waiting a specified number of milliseconds.

Example:

`index.html`
```
<html>
<body>
<div id="myDiv" style="background-color:grey">
Welcome to Timing Events.
<button id="myButton">Click Me</button>
</div>
<script src="index.js"></script>
</body>
</html>
```

`index.js`
```
// Global variable representing the current color of the div
let color = 'grey'

window.onload = () => {
	// Set the initial color of the div
	document.getElementById('myDiv').style.backgroundColor = color
	document.getElementById('myButton').onclick = waitForLoading
}

// This function will change the button text to "Loading..."
// and then swap the background color of the div from grey to green or vice versa.
function waitForLoading() {
	console.log('Loading...')
	document.getElementById('myButton').innerHTML = 'Loading...'
	// Wait two seconds and then change color
	setTimeout(changeColor, 2000)
}

// This function switches the color of the div
function changeColor() {
	document.getElementById('myButton').innerHTML = 'Click Me'
	
	color = color == 'grey' ? 'green' : 'grey'
	
	document.getElementById('myDiv').style.backgroundColor = color
}
```

In the above example, if the user clicks the button and waits two seconds, the color of the div changes from grey to green. If they press the button a second time, it will wait two seconds and then change back.

### Canceling Timeouts
If you are waiting on a `setTimeout()` to execute and then change your mind, you can do so with the `clearTimeout()` function. This function has the following signature:

```window.clearTimeout(timeoutVariable)```

If the callback function has not been executed when clearTimeout is called, the execution will be cancelled. For this to work, however, we need the `timeoutVariable`, which is the return value of the `setTimeout()` function.

Example:
`index.html`
```
<html>
<body>
<div id="myDiv" style="background-color:grey">
Welcome to Timing Events.
<button id="myButton">Click Me</button>
</div>
<script src="index.js"></script>
</body>
</html>
```

`index.js`
```
// Global variable representing the current color of the div
let color = 'grey'
// Global variable representing the button so we don't have to select it every time.
let myButton = document.getElementById('myButton')

window.onload = () => {
	// Set the initial color of the div
	document.getElementById('myDiv').style.backgroundColor = color
	myButton.onclick = waitForLoading
}

// This function will change the button text to "Loading..."
// and then swap the background color of the div from grey to green or vice versa.
function waitForLoading() {
	console.log('Loading...')
	myButton.innerHTML = 'Cancel!'
	myButton.onclick = cancelTimeout
	// Wait two seconds and then change color
	let timeout = setTimeout(changeColor, 2000)
	
	function cancelTimeout() {
		console.log('Cancel the color change')
		clearTimeout(timeout)
		myButton.innerHTML = 'Click Me'
		myButton.onclick = waitForLoading
	}
}

// This function switches the color of the div
function changeColor() {
	myButton.innerHTML = 'Click Me'
	myButton.onclick = waitForLoading
	
	color = color == 'grey' ? 'green' : 'grey'
	
	document.getElementById('myDiv').style.backgroundColor = color
}
```

The above example is almost identical to the previous example, except that if the user clicks the button again prior to the color changing, we will cancel the color change. The user is then free to try to change the color again.

## SetInterval
What if instead of needing to wait a specific time before executing a function once, we actually needed to execute a function every few seconds? This is where `setInterval()` comes in. It has the following signature:

```window.setInterval(callbackFunction, milliseconds)```

`setInterval()` will execute it's callback repeatedly with an *interval* or pause in milliseconds between executions. Like `setTimeout()`, if we wish to cancel the execution, we can use the function `clearInterval()`.

```window.clearInterval(intervalVariable)```

Example:

`index.html`
```
<html>
<body>
<div id="myDiv" style="background-color:grey">
<h1 id="time">0:00</h1>
<button id="start">Start</button>
<button id="stop">Stop</button>
</div>
<script src="index.js"></script>
</body>
</html>
```

`index.js`
```
let seconds = 0
// declare the intervalVariable for later use.
let intervalVariable = null

window.onload = () => {
	// Set the initial color of the div
	document.getElementById('start').onclick = start
	document.getElementById('stop').onclick = stop
}

// This function will create the interval
function start() {
	seconds = 0
	document.getElementById('time').innerHTML = '0:00'
	intervalVariable = setInterval(tickUp, 1000)
}

// This function will iterate the timer.
function tickUp() {
	seconds = seconds + 1
	timer = `${Math.floor(seconds/60)}:${new String(seconds%60).padStart(2, '0')}`
	document.getElementById('time').innerHTML = timer
}

// This function clears the interval
function stop() {
	clearInterval(intervalVariable)
}
```

In this example, the user is operating a simple stopwatch. It ticks up the stopwatch every second, until the user hits the stop button.