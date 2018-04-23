import { Component, OnInit, Input } from '@angular/core';
import { Characters } from "../Characters"

@Component({
  selector: 'app-char-detail',
  templateUrl: './char-detail.component.html',
  styleUrls: ['./char-detail.component.css']
})
export class CharDetailComponent implements OnInit {

  @Input() char : Characters

  constructor() { }

  ngOnInit() {
  }

}
