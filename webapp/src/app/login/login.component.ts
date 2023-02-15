import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { RestLoginService } from '../services/rest-login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string;
  password!: string;
  message: any; 

  constructor(private service: RestLoginService, private router:Router, private cartservice: CartService){}

    ngOnInit(){
    }

    doLogin(){
    let resp = this.service.login(this.username, this.password);
    resp.subscribe(data=>{
      this.message = data;
      console.log(this.message);
      this.router.navigate(["/home"])
    })

    this.cartservice.setLoginStatus(true);
  }

}
