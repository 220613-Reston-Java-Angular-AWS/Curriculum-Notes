# Angular Notes
-Components : are the basic building blocks in the Angular application
    -they caontain the data and UI logic that defines the view and behavior of an application
    - @Component - this is a decorator in Angular that defines a component
    - each component will have a selector, template (html), style(css) and other properties

-@NgModule : every angular application will have at leats one module (root module -App Module)
    -NgModule takes the metadata from declarations,imports,providers,bootstrap (all defnined in the module)
    -and uses that to lauch the application

-Directives: What is the difference between a decorator and a directive?
   - Directives change the appearance/behavior or the layout of the DOM (Documet Object Model)
   - Syntax : `*directiveName="directive value or some logic"`
   -There are 3 types :
        -Structural directive: change the DOM layout by adding or removing DOM elements
             -`*ngIf`, `*ngFor`, `*ngSwitch`
    
        -Attribute directives: change the appearance or behavior of a particular element, component, or another directive
            -`*ngClass`,`*ngStyle`

            
        -You can also build your own directive as an attribute directive :
            The @Input decorator is an example of how we can build our own attribute directive

- Decorators: 
    - These are similar in syntax and purpose when compared to annotations in java. BUT they are NOT the same
    - decorators wll denote any given class, field, or module in Angular with config metadata that the Angular framework will understand - ex: @Component, @NgModule, @Service 