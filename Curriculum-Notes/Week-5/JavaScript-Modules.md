# JavaScript Modules

The functions written in one program can be called in another program without writing the body of the functions itself using JavaScript Modules.
 
Modules are self-contained units of functionality that can be shared and reused across projects. It uses an `export` keyword to export a module’s public API and an `import` keyword to import it.


## Export Modules

The export statement is used when creating JavaScript modules to export live bindings to functions, objects, or primitive values from the module so they can be used by other programs with the import statement.
You can export members one by one, by placing `export `before it. The menbers which is not exported won’t be available directly outside the module.

**Example:**
```javascript
// module "my-module.js"

// export an array
export let daysinWeek = ["mon", "tue", "wed", "thurs", "fri" ];

// export a constant
export const year = 2020;

//export a function
export function sayHi(user) {
  alert(`Hi, ${user}!`);
}
````

We can export desired members in a single statement at the end.

**Example:**
```javascript
// module "my-module.js"

let daysinWeek = ["mon", "tue", "wed", "thurs", "fri" ];
const year = 2020;
function sayHi(user) {
  alert(`Hi, ${user}!`);
}

export {daysinWeek, year, sayHi};
```
we can also give an aliases to exported members with the as keyword.

**Example:**
```javascript
export { daysinWeek as days, year, sayHi};
```

## Import Modules

The `import` statement is used to import read only live bindings which are exported by another module.

Importing is can be achieved with the `import` keyword, members to be imported in curly brackets and then the location of the module relative to the current file.

**Example:**
```javascript
import {days, sayHi } from 'my-module.js';

//Importing with alias
import {daysinWeek as days, sayHi } from 'my-module.js';

//Importing all exported members
import * as Utils from 'my-module.js';

//access to members with the dot notation
Utils.sayHi('Jack'); // output: Hi, Jack!
```