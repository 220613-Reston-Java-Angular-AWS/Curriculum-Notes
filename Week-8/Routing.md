# Routing

In Single Page Applications, only one page is requested from the server, and it provides multiple views dynamically rather than loading the new pages from the server. 

The Router mechanism in Angular provides a way to navigate from one view to another view in the application.

Angular provides a `RouterModule` that has the necessary service providers and directives for navigating through application views. The **router** defines navigation of views on a single page and interprets URL links to determine which views to create or destroy, and which components to load or unload. 
A **routing component** imports the Router module, and its template contains a `RouterOutlet` element where it can display views produced by the router.

**Example:**

* Run  the `ng new routing-app --routing ` command to generate a basic Angular app with an app routing module, where we can configure our routes.

* To use the Angular router, an app needs to have at least two components so that it can navigate from one to the other. Run these command `ng g c first` and `ng g c second` to generate 2 components - *FirstComponent* and *SecondComponent*.

* Make sure that in index.html file we have `<base href="/">` in the `<head>` section. The `href` attribute is set to "/" so that the application constructs the URL while navigating.

* We need to import these two components in the *app-routing.module.ts* file. 
```typescript 
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
```
* Also, import the *AppRoutingModule* into *AppModule* and add it to the import array. The Angular CLI performs import this by default. When we implement the routing feature in the existing application, we need to import *AppRoutingModule* into *AppModule*.

* In the app routing module, the CLI creates a Routes array used to define our routes.
```typescript
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```
* Each route in the Routes array is an object with two properties: 
    * *path* -  URL path for the route.
    * *component* - the corresponding angular component for the specified path.
```typescript
const routes: Routes = [
  { path: 'first-component', component: FirstComponent },
  { path: 'second-component', component: SecondComponent },
];
```

* `<router-outlet>` - works as a placeholder to load the different components dynamically based on the activated component.

*  *routerLink* - is an attribute to an anchor tag which sets the route for the component.

* In the *AppComponent*, we add our routes to the application. Angular updates the view depending upon the selected route.
```html
<h1>Angular Router App</h1>
<nav>
  <ul>
    <li><a routerLink="/first-component" routerLinkActive="active">First Component</a></li>
    <li><a routerLink="/second-component" routerLinkActive="active">Second Component</a></li>
  </ul>
</nav>
<router-outlet></router-outlet>
```
## References

* [Angular Docs - Routing](https://angular.io/guide/router)