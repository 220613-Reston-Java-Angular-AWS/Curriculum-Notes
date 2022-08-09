import { Component, OnInit } from '@angular/core';
import { HeroService } from 'src/app/services/hero.service';
import { MessageService } from 'src/app/services/message.service';
import { Hero } from './hero';
import { HEROES } from './mock-heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[] = [];

  // selectedHero?:Hero;

  // onSelect(hero: Hero): void {
  //   this.selectedHero = hero;
  //   this.messageService.add(`Heroes Component: Selected hero id= ${hero.id}`)
  // we no longer need this method or var because we introduced routing}


  // the constructor of a component gets executed first
  // if we need any dependencies the constructor is the best pplace to inject them
  constructor(private heroService: HeroService, private messageService: MessageService) { }
  

  // ngOnInit is called once to initalize the component and set the inout properties
  ngOnInit(): void {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes().subscribe(heroList => this.heroes = heroList);
   }


  // here we are going to add a new hero
  add(name: string): void {
    name = name.trim();

    if(!name){return;}

    this.heroService.addHero({name} as Hero)
    .subscribe(hero => this.heroes.push(hero))
  }

  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !== hero);
    this.heroService.deleteHero(hero.id).subscribe();
  }

}
