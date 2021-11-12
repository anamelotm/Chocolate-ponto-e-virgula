import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-carrinho-dialog',
  templateUrl: './carrinho-dialog.component.html',
  styleUrls: ['./carrinho-dialog.component.css']
})
export class CarrinhoDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<CarrinhoDialogComponent>
  ) { }

  ngOnInit(): void {
  }

  cancelar(): void {
    this.dialogRef.close();
  }
}
