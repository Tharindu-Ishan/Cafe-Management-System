import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { SnackbarService } from './snackbar.service';
import { jwtDecode } from 'jwt-decode';
// import jwt_decode from 'jwt-decode';
import { GlobalConstants } from '../shared/global.constants';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService {

  constructor(public auth:AuthService,
    public router:Router,
    private snackbarservice:SnackbarService) { }

    canActivate(route:ActivatedRouteSnapshot):boolean{
      let expectedRoleArray=route.data;
      expectedRoleArray=expectedRoleArray.expectedRole;
      const token:any=localStorage.getItem('token');

      var tokenPayLoad:any;
      try{
        tokenPayLoad=jwtDecode(token);
      }
      catch(err){
        localStorage.clear();
        this.router.navigate(['/']);
      }
      let expectedRole='';
      for(let i=0;i<expectedRoleArray.length;i++){
        if(expectedRoleArray[i]==tokenPayLoad.role){
          expectedRole=tokenPayLoad.role;
        }
      }
      if(tokenPayLoad=='user'|| tokenPayLoad=='admin'){
        if(this.auth.isAuthenticated() && tokenPayLoad.role==expectedRole){
          return true;
        }
        this.snackbarservice.openSnackBar(GlobalConstants.unauthorized,GlobalConstants.error);
        this.router.navigate(['/cafe/dashboard']);
        return false;
      }
      else{
        this.router.navigate(['/']);
        localStorage.clear();
        return false;
      }
    }
}
