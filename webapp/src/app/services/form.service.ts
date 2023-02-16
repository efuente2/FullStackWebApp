import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Form } from '../contact/form';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http:HttpClient, private _snackbar: MatSnackBar) { }

  public submitForm(form: { form: Form; }){
  
    console.log(form);
    
    this.http.post("http://localhost:9090/contact", form, {responseType: 'text' as 'json'})
    .subscribe(
      data => {
        console.log("POST Request is successful ", data);
        this._snackbar.open('Thank you for your question will get back to you as soon as possible', 'Close', { duration: 3000 }); 
      }
    );

  }
}
