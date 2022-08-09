import { Component, OnInit } from '@angular/core';
import { debounce, debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { HeroService } from 'src/app/services/hero.service';
import { Hero } from '../heroes/hero';

@Component({
  selector: 'app-hero-search',
  templateUrl: './hero-search.component.html',
  styleUrls: ['./hero-search.component.css']
})
export class HeroSearchComponent implements OnInit {

  // because we are going to be interating through an observable array 
  heroes$! : Observable<Hero[]>;

  // A 'Subject' is both a source of observable values and an Observable itself
  //note that you can subscribe to a Subject just as you would an observable
  private searchTerms = new Subject<string>();

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {

    this.heroes$ = this.searchTerms.pipe(

      //wait 300 ms after each keystroke before considering the term
      debounceTime(300),

      //ignore a new term if if its the same as the previous
      distinctUntilChanged(),

      // switch to the new search Observale each time the term changes
      switchMap((term: string) => this.heroService.searchHeroes(term))
    )


  }

  // this method is pushing a search term into the observable stream (Subject)
  //the next() method comes from 'Subject'
  search(term: string): void{
    this.searchTerms.next(term)
  }

}
