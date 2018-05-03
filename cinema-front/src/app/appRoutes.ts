import { Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AuthGuard } from './guard/auth.guard';
import { MapAuthGuard } from './guard/map.auth.guard';

export const appRoutes: Routes = [
    { path: '', component: AccueilComponent, canActivate: [MapAuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'not-found', component: NotFoundComponent },
    // { path: 'my-messages', component: MyMessagesComponent, canActivate: [AuthGuard] },
    { path: '**', redirectTo: '/not-found' }
];
