import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { from } from 'rxjs';
import { FormService } from '../services/form.service';
import { Form } from './form';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit{

  name!: string;
  email!: string;
  subject!: string;
  message!: string;

  contactForm:Form = new Form(this.name, this.email, this.subject, this.message);

  constructor(private _snackbar: MatSnackBar, private formService: FormService, private http:HttpClient) { }

  ngOnInit(): void {
  }

  submit(){
    console.log(this.contactForm);
    this.formService.submitForm({form: this.contactForm});

  }
}
