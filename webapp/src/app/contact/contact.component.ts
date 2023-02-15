import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormService } from '../services/form.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  fname!: string;
  femail!: string;
  fsubject!: string;
  fmessage!: string;


  constructor(private _snackbar: MatSnackBar, private formService: FormService) { }

submit(){
  this._snackbar.open('Thank you for your question will get back to you as soon as possible', 'Close', { duration: 3000 }); 

  this.formService.submitForm(this.fname, this.femail, this.fsubject, this.fmessage).subscribe(
    (data: any) => {
      console.log(data);
    },
    (error: any) => {
      console.log(error);
    }
  );
}

}
