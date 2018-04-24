import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { StylesComponent } from './styles/styles.component';
import { CharDetailComponent } from './char-detail/char-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    StylesComponent,
    CharDetailComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
