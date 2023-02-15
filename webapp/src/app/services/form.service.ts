import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http:HttpClient) { }

  public submitForm(fname:string, femail:string, fsubject:string, fmessage:string){
    const headers = new HttpHeaders();
    return this.http.get("http://localhost:9090/login", {headers,responseType: 'text' as 'json'});

  }
}
