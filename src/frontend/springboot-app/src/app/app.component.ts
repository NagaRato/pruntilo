import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'springboot-app';
  colors = ['red','green','blue','orange','magenta','pink'];
  show = true;

  clicked() {
    this.show = !this.show;
  }
}
