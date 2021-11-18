export class ItemPedido {
    codigoPedido: number;
    produto: string;
    valorUnitario: number;
    quantidade: number;
    valorTotalItem: number;
  
    constructor(codigoPedido: number,
        produto: string,
        valorUnitario: number,
        quantidade: number,
        valorTotalItem: number){
            this.codigoPedido= codigoPedido;
            this.produto = produto;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.valorTotalItem = valorTotalItem;
        }
  }