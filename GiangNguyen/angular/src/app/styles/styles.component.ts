import { Component, OnInit } from '@angular/core';
import { Characters } from '../Characters';
import { aCharacters } from '../mock-characters';

@Component({
  selector: 'app-styles',
  templateUrl: './styles.component.html',
  styleUrls: ['./styles.component.css']
})
export class StylesComponent implements OnInit {
  
  character1: Characters={
    id: 1,
    name: 'Diablo'
  };

  chars = aCharacters;

  constructor() { }

  ngOnInit() {
  }

  truth = 'The cow level is a lie!';

  selectedChar : Characters;
  onSelect(char: Characters): void{
    this.selectedChar = char
  }
}
