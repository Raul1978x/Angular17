import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserComponent } from "./user/user.component";
import { CommentsComponent } from "./comments/comments.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, UserComponent, CommentsComponent]
})
export class AppComponent {
  city = 'Mendoza';
}
