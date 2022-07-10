## strict mode

JavaScript is a loosely typed scripting language. JavaScript allows strictness of code by using `"use strict";` statement at the top of JavaScript code or in a function. 

For example, When we expect the compiler to give an error if we have used a variable before defining it, then we apply "strict mode" to the javascript code. 
```html
<!DOCTYPE html>
<html>
<body>
	<h1>strict mode</h1>
	
	<p id="errorMessage"></p>
	
	<script>
		"use strict";
		try
		{
			var x = 16; // valid in strict mode
			y = 10; // error
		}
		catch(ex)
		{
			document.getElementById("errorMessage").innerHTML = ex;
		}

    </script>
</body>
</html>
```

The output will be:
```
strict mode
ReferenceError: y is not defined
```

The strict mode in JavaScript does not allow us to use undefined variables, reserved keywords as variable or function name, duplicate properties of an object, duplicate parameters of the function, assign values to read-only properties, Modifying arguments object, and Deleting an undeletable property.

Example:
```html
<script>
try
{
	"use strict";

	x = 1; // error
	var for = 19; // error
	var break = 5; // error

	var person = { name: "John", name: "Ben" }; //error
	function divide(val, val){return val / val }; //error

	var arr = [1 ,2 ,3 ,4, 5];
	arr.length = 10; //error

}
catch(ex)
{
    document.getElementById("errorMessage").innerHTML = ex;
}
</script>
```

Strict mode can be applied to function level in order to implement strictness only in that particular function.

Example:
```javascript
x = 1; //valid

function sum(val1, val2){
    "use strict";

     result = val1 + val2; //error

    return result;
}
```
