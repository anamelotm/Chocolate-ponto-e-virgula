export class ItemPedido {
    id: number = 0;
    produto: string;
    valorUnitario: number;
    quantidade: number;
    valorTotal: number;

    constructor(
        produto: string,
        valorUnitario: number,
        quantidade: number){
            this.produto = produto;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.valorTotal = quantidade * valorUnitario;
        }
  }
