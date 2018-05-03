import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NG_ASYNC_VALIDATORS, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AgmCoreModule } from '@agm/core';
import { AgmDirectionModule } from 'agm-direction';   // agm-direction

import { AppModuleMaterial } from './app.module-material';

import 'hammerjs'; // Laisse ca là, sinon l'animation du slider foire... Bisous ;* ... Bisous ???? :o

import { appRoutes } from './appRoutes';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AccueilComponent } from './accueil/accueil.component';
import { HeaderComponent } from './shared//header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ApiService } from './services/api.service';
import { AuthService } from './services/auth.service';
import { ConfigService } from './services/config.service';
import { UserService } from './services/user.service';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuard } from './guard/auth.guard';
import { DialogOverviewComponent } from './dialog/dialog-overview.component';
import { MAT_DIALOG_DEFAULT_OPTIONS } from '@angular/material';

import { MapAuthGuard } from './guard/map.auth.guard';
import { TrajetService } from './services/trajet.service';
import { ContactService } from './services/contact.service';
import { NotificationService } from './services/notification.service';

// how to avoid api limit ? use a random api key :P
const apiKeys = ['AIzaSyCHKOinW6VoYCy8y4ogN0nAGXwX9DWhGP8',
  'AIzaSyBiw67fELpJMwyZXXN799Wkx8eb6oQJA2A', 'AIzaSyDi9cqC_wA23bDv4G8l5EgRAHSmPg7UfV4'];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NotFoundComponent,
    AccueilComponent,
    HeaderComponent,
    FooterComponent,
    DialogOverviewComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppModuleMaterial,
    HttpModule,
    HttpClientModule,
    FormsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: apiKeys[Math.floor(Math.random() * apiKeys.length)],
      libraries: ['places']
    }),
    AgmDirectionModule
  ],
  entryComponents: [
    DialogOverviewComponent
  ],
  providers: [AuthGuard, MapAuthGuard, ApiService, AuthService, ConfigService, UserService, TrajetService, ContactService, NotificationService,
    { provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: { hasBackdrop: false } }],
  bootstrap: [AppComponent]
})
export class AppModule { }
