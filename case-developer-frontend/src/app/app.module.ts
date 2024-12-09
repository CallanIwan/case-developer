// app.module.ts
import { HttpClientModule } from '@angular/common/http';
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RouterOutlet} from "@angular/router";
import {AppComponent} from "./app.component";
import {PensionComponent} from "./pension/pension.component";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterOutlet,
    HttpClientModule,
    PensionComponent
  ],
bootstrap: []
})
export class AppModule {}
