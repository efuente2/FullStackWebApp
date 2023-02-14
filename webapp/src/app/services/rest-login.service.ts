import { Injectable } from '@angular/core';
import { HttpBackend, HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RestLoginService {
  
constructor(private http:HttpClient) { }

  public login(username: String, password: String){
    const headers = new HttpHeaders({Authorization: 'Basic '+ window.btoa(username+':'+password)});
    //const headers = new HttpHeaders({Authorization: 'Basic YWRtaW46YWRtaW4='})
    return this.http.get("http://localhost:9090/login", {headers,responseType: 'text' as 'json'});

  }
}