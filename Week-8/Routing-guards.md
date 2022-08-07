# Routing guards

Router guards are used to check whether the user should grant or remove access to certain parts of the navigation.

There are 4 different interfaces act as routing guards:
* `CanActivate` - decides if the route can be activated.
* `CanActivateChild`- decides if children of a route can be activated.
* `CanLoad`- decides if a route can be loaded. 
* `CanDeactivate`- decides if the user can leave a route. 

**Example:**

Run the `ng g guard <guard-name>` command in your terminal to generate a guard service. When we run the `ng g guard admin` command, the CLI creates a service class that implements any one of the guard interface.

*admin.guard.ts:*
```typescript
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

import { AuthService } from './auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private authService: AuthService){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      return this.authService.isLoggedIn;
  }
}
```
* Adminguard is a class that implements the *CanActivate* interface and overrides the `canActivate()` method. The canActivate() method uses the following parameters:
    * `next: ActivatedRouteSnapshot` - Contains the information about a route associated with a component loaded in an outlet at a particular moment in time. 
    * `state: RouterStateSnapshot` - Contains the information about router state at a particular moment in time. 

* In this example, the `canActivate()` method to only allow access if the user is logged in. 
Here imported the *AuthService* to get the value of `isLoggedIn` property which holds `true` if the user logged in else `false`.

* We apply the guard to the routes, by imposing `canActivate` property of the path object. 
*admin-routing.module.ts* 
```typescript
const routes: Routes = [
    {
        path: 'admin',
        component: ProjectComponent,
        children: [
            {
                path: 'list',
                component: EmployeeListComponent,
                canActivate: [AdminGuard]
            },            
            {
                path: 'create',
                component: EmployeeListComponent,
                canActivate: [AdminGuard]
            }
        ]
    }
```
* Here, we can access the *EmployeeListComponent* and *EmployeeListComponent* only if we had logged in.

## References

* [Angular Docs - Routing](https://angular.io/guide/router)