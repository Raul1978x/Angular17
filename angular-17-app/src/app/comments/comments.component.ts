import { Component } from '@angular/core';

@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [],
  template: `
    <h3>commentarios graciosos</h3>
    <img src="https://img2.rtve.es/i/?w=1600&i=1614352806474.png" alt="this is fine meme">
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid corrupti expedita eum debitis magnam voluptas non. Animi perspiciatis ipsam eum iste corporis, eligendi odio! Incidunt, sunt quaerat. Aliquid, unde eius.</p>
  `,
  styles: `img {
    width: 100%;
    height: auto;
  }`
})
export class CommentsComponent {

}
