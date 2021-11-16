import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CarrinhoDialogComponent } from './carrinho-dialog/carrinho-dialog.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public dialog: MatDialog) {
   }

  ngOnInit(): void {
  }

 carrinho(): void {
    const dialogRef = this.dialog.open(CarrinhoDialogComponent, {
      width: '400px',
     
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');

    });

  }

}
