import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Hero } from '../components/heroes/hero';
import { HEROES } from '../components/heroes/mock-heroes';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  // this method has a synchronous signature : this imply that the heroService can fetch heroes synchronously
  // however this approach wont work in a real application
  //in a real application we want to fetch datt asynchronously

  // getHeroes(): Hero[] {
  //   return HEROES
  // }

  // this is the url that is generated from angular that leads us to our resource in our in-memory-data-service
// when building your appls this is where you would add your http://localhost:8080/whatever
  private serverURL = 'api/heroes';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  }

  constructor(private messageService: MessageService, private http: HttpClient) { }

  // All Get Methods 
  getHeroes(): Observable<Hero[]> {
    // const heroes = of(HEROES);
    // this.messageService.add('Hero Service: fetched all heroes')
    // return heroes; we are not lnger using this code becuase we are not looking at the mock heroes - onstead we are looking to the db

    //  to catch errors you 'pipe' the observable result from http.get() through the rxjs catchError operator
    return this.http.get<Hero[]>(this.serverURL)
    .pipe(
      //with the tap() operators we can see the values and do things with this values
      //but cannot access them directly
      tap(_ => this.log("fetched all heroes")),
      catchError(this.handleError<Hero[]>('getHeroes', []))
      //the catchError operator intercepts an Observable that failed
      // then passes the erro to the handling function (handleError())
      //the handleError method reports the error then returns a result to keep it working
    )
  }

  
getHero(id:Number): Observable<Hero> {

  const url = `${this.serverURL}/${id}`
  return this.http.get<Hero>(url).pipe(
    tap(_ => this.log(`fetched hero with id: ${id}`)),
    catchError(this.handleError<Hero>(`getHero id=${id}`))
  )
  

}

// get hero by id - but return 'undefined' if hero isnot found

getHeroNo404<Data>(id: number): Observable<Hero>{

  const url = `${this.serverURL}/?id=${id}`;

  return this.http.get<Hero[]>(url).pipe(
    map(heroes => heroes[0]),
    tap( h => {
      const outcome = h ? 'fetched' : ' did not find';
      this.log(`${outcome} hero id= ${id}`)
    }),
    catchError(this.handleError<Hero>(`getHero id=${id}`))
  )
}


searchHeroes(term: string): Observable<Hero[]> {

  //  if the search term is empty we will return an empty array
  if(!term.trim()) {
    return of([]);
  }

  return this.http.get<Hero[]>(`${this.serverURL}/?name=${term}`). pipe(
    tap(x => x.length ? this.log(`found heroes matching '${term}'`) : this.log(` no heroes matching '${term}'`)),
    catchError(this.handleError<Hero[]>('searchHero', []))

  )
}

// All POst methods

addHero(hero: Hero): Observable<Hero> {
  return this.http.post<Hero>(this.serverURL, hero, this.httpOptions).pipe(
    tap((newHero: Hero) => this.log(`added hero with id: ${newHero.id}`)),
    catchError(this.handleError<Hero>('addHero'))
  )
}


// update Method

updateHero(hero: Hero): Observable<any> {
  return this.http.put(this.serverURL, hero, this.httpOptions).pipe(
    tap(_ => this.log (`updated hero with id: ${hero.id}`)),
    catchError(this.handleError<any>('updateHero'))
  );
}

// Delete method

deleteHero(id: number): Observable<Hero> {

  const url = `${this.serverURL}/${id}`;

  return this.http.delete<Hero>(url, this.httpOptions).pipe(
    tap(_ => this.log(`deleted hero with id: ${id}`))
  );

}



private handleError<T>(operation = 'operation', result?:T){
  return(error:any): Observable<T> => {

    console.error(error);
    this.log(`${operation} failed: ${error.name}`)
    return of(result as T);

  }
}

private log(message: string) {
  this.messageService.add(`Hero Service: ${message}`)
}
 
}
