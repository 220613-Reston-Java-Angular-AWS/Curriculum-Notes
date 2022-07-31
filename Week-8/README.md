# Monday 

## Node.js

[Node.js](https://en.wikipedia.org/wiki/Node.js) is an open-source, cross-platform **run-time environment** built on Chrome's V8 JavaScript engine.

Node.js is used to execute **JavaScript** code outside of a web browser. It provides a library of various JavaScript modules, which simplifies the development of web applications. 

Global companies like Netflix, Facebook, Walmart Linkedin, Uber, etc., use Node.js for building their applications. It has helped companies create various applications like social media apps, video and text chat engines, real-time tracking apps, online games, and collaboration tools.

## npm - node package manager

[npm](https://en.wikipedia.org/wiki/Npm_(software)) is a package manager for the JavaScript programming language. It is the default package manager for the JavaScript runtime environment -Node.js. 

npm consists of three components - the website, the Command Line Interface (CLI), and the registry. The **website** discovers packages, set up profiles, and manage access to public or private packages. The **CLI** runs from a terminal and allow us to interact with npm. The **registry** is a public database of JavaScript packages comprised of software and metadata.

## Why we need Node.js for Angular

We use Node.js and npm as tools for building Angular or React apps. Angular is a front-end framework used to create a web application and is written in Typescript. The browser only understands JavaScript code, so we need to compile Typescript (.ts file) to plain JavaScript (.js file). We use Node.js and npm to perform this compilation, then we can deploy them in production.

### Installation of Node and npm

We need to add Node.js and an npm package manager to our development environment.

* Download Node.js from [nodejs.org](https://nodejs.org/en/download/) and install it. To check the version, run `node -v` in a terminal.

* The npm CLI gets installed with Node.js by default. To check that you have installed npm, run `npm -v` in a  terminal. npm can install packages in a **node_modules** folder in our working directory. 

## References 

* [Angular Docs - Setup](https://angular.io/guide/setup-local)


## package.json file

All npm packages contain a file, usually in the **project root**, called **package.json**. This file is used to give information to npm that allows it to identify the project as well as handle the project's dependencies. This file contains **metadata** relevant to the project, such as project description, the version of the project, license information, etc.,

Node.js generates a package.json file by running the `npm init` command in the terminal. The generated package.json file contains a **name**, **version**, **description**, **main** (entry point), any **scripts**, the **author**, and **license** type of our project. The structure of package.json file is shown below:

```json
{
  "name": "MyApp",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {...},
  "keywords" : ["util", "functional", "server", "client", "browser"],
  "author" : "John Adams",
  "contributors" : [],
  "dependencies" : [],
  "devDependencies" : [],
  "repository" : {..},
  "license": "ISC"
}
```

**dependencies** - The [Dependencies](https://angular.io/guide/npm-packages#dependencies) section in the package.json file is essential for running applications. It contains a list of packages or modules installed using npm that are required to run the project.

**devDependencies** - The [DevDependencies](https://angular.io/guide/npm-packages#dev-dependencies) section in the package.json file is used only for developing applications. It contains a list of packages or modules that are required only for development. These packages are installed only on the developer's machine and will not be run for a production build.

## References

* [npm-package.json](https://docs.npmjs.com/files/package.json)
* [Angular Docs - npm dependencies](https://angular.io/guide/npm-packages)

## TypeScript

* [Typescript](https://www.typescriptlang.org/) is a **typed superset of JavaScript**. 
* It is an **open-source** and  **object-oriented programming language** that supports classes, interfaces, inheritance, modules, etc., developed by **Microsoft**. 
* It can be used to **manipulate the DOM** for adding or removing elements, similar to JavaScript. 
* It is **portable** across browsers, devices, and operating systems.
* It supports **strong typing** or **static typing**, unlike JavaScript. 
* TypeScript files are saved with a `.ts` extension and then compiled into JavaScript using the TypeScript compiler. 
* TypeScript gets compiled to JavaScript, which can run on any JavaScript runtime environment.(Eg: Node.js)

### Setting up Typescript

You can install Typescript using NPM (Node Package Manager) or the TypeScript Visual Studio Plugin.

After installing NPM, run the `npm install -g typescript` command to install TypeScript. To check the version, run the `tsc -v` command in the terminal. 

To compile the TypeScript code, run the `tsc` command, followed by the name of the file you are compiling. For example, `tsc hello.ts`. After compliation, typescript compiler creates a javascript file with the same name (hello.js). Run the javascript file using `node hello.js` command in the terminal. 


## References

* [Get TypeScript](https://www.typescriptlang.org/#download-links)
* [TypeScript Docs - 5 minutes overview of the Language](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)


   * ### []()
   * ### []()
   * ### []()
   

##  History of Angular

Angular is a **TypeScript-based open-source framework** used to develop **dynamic web applications**.

Angular is a [Single Page Application](./spa.md) (SPA) Framework. An SPA is a web application that fits on a single page. All our code (JavaScript , HTML , CSS ) is retrieved with a single page load. Navigation between pages is performed without refreshing the whole page.


### Angular Versions with release dates

* AngularJS or Angular 1 - October 20, 2010
* Angular 2 - September 14, 2016
* Angular 4 - March 23, 2017
* Angular 5 - November 1, 2017
* Angular 6 - May 4th, 2018
* Angular 7 - October 18, 2018
* Angular 8 - May 28, 2019
* Angular 9 - February 6, 2020

**Angular** is commonly referred to as Angular 2+ or by one of the above versions, to distance the modern framework from the original AngularJS. 

![](./../images/angular-version.png)


[AngularJS](https://en.wikipedia.org/wiki/AngularJS) is a **JavaScript-based open-source front-end web framework**. It doesn't support the features of a server-side programming language, nor dynamic loading of the page. 

[Angular](https://en.wikipedia.org/wiki/Angular_(web_framework)) is a **complete rewrite** of AngularJS. AngularJS was completely based on **controllers** and **scopes** whereas, Angular uses **component hierarchy** as its main architecture. 

### Angular JS vs Angular (Angularr 2+)

| Angular JS| Angular 4+|
| ------ | ------ |
| Uses MVC architecture to build the applications. |  Uses component based UI to build the applications.|
| AngularJS is written in JavaScript. | Angular is compatible with the most recent versions of TypeScript that have powerful type checking and object-oriented features. |
| To bind an image/property or an event with AngularJS, you have to remember the right ng directive. | Angular focuses on “( )” for event binding and “[ ]” for property binding.|
|AngularJS doesn't support mobiles. | Angular support mobiles. |

Angular uses the **TypeScript** language, which has features like :

* Static Typing
* Object-Oriented Programming based on classes
* Support for reactive programming using RxJS

The main building blocks of Angular are **modules**, **components**, **templates**, **metadata**, **data binding**, **directives**, **services**, and **dependency injection**. The following diagram shows how these building blocks of an Angular Application are related :

![](./../images/angular-arch.png)


We'll discuss each block later in this section. 

## References

* [AngularJS to Angular - a brief history](https://blog.risingstack.com/angularjs-to-angular-history-and-tips-to-get-started/#angularjstoangularabriefhistory)
* [Angular Versions](https://mindmajix.com/angular-versions)

## Single Page Application

A [Single Page Application](https://en.wikipedia.org/wiki/Single-page_application#:~:text=A%20single%2Dpage%20application%20(SPA,browser%20loading%20entire%20new%20pages.)) (SPA) is a web application that fits on a **single page in the browser**. All our JavaScript, HTML, CSS code retrieved by the browser with a **single page load**. Navigation between pages performed **without refreshing the whole page**. SPA uses AJAX and HTML5 to build responsive web applications. 

**Examples of single-page apps** - Gmail, Google Maps, Facebook, Twitter, Trello, etc.,

**Advantages of SPAs**

* **Fast and responsive** -  SPAs update only the required content instead of the entire page for each request to the server.  The HTML/CSS/Scripts are only loaded once throughout the lifespan of an application. Only data is transmitted back and forth. This significantly improves the website’s speed.

* **Caching capabilities** - SPA sends a request to the server and caches all received data locally. Then it can reuse this data and work even offline. If a user has poor connectivity, local data can be synchronized with the server when the connection allows.

* SPA provides a **pleasant user experience** on desktops as well as on mobile phones, since it only changes the content and not the page.

**Disadvantages of SPAs**

* Doesn’t Perform Well With **SEO** ([Search engine optimization](https://en.wikipedia.org/wiki/Search_engine_optimization)).
* **Security** - SPAs are less secure towards [Cross-site scripting](https://en.wikipedia.org/wiki/Cross-site_scripting) (XSS) attacks.
* While overall performance is better, more data is frontloaded which can make the first page load a little slower


Frameworks like AngularJS, Angular, Ember.js, ExtJS, Knockout.js, Meteor.js, React and Vue.js uses SPA principles to create a web application.

## References

* [What Is a Single Page Application and Why Do People Like Them so Much?](https://www.bloomreach.com/en/blog/2018/07/what-is-a-single-page-application.html)
* [Video Tutuorial- SPA](https://www.youtube.com/watch?v=F_BYg2QGsC0)

## Webpack

In our web application, we use many javascript files that are added into the HTML pages via `<script>` tags.  For each user request, the browser loads these bunch of script files inside the HTML page. This is inefficient as it reduces the page speed since the browser requests each script file separately.

This can be solved by **bundling** several files together into one file to be downloaded by the browser in one single request.

**Module bundlers** are used to bundle a group of JavaScript modules with their dependencies and merge them into a single file in the correct order, which can be executed by the browser.

[Webpack](https://webpack.js.org/) is a powerful static module bundler for JavaScript applications that packages all modules in our application into a bundle and serves it to the browser.

Webpack builds a [dependency graph](https://webpack.js.org/concepts/dependency-graph/) when it processes the application. It starts from a list of modules defined in its config file (`webpack.config.js`) and recursively builds a dependency graph that includes every module our application needs, then packages all of those modules into a small bundle that can be loaded by the browser.

## References

* [WebPack Docs](https://webpack.js.org/concepts/)



    **Click the link below to install Angular**

    * ### [Angular CLI]()
