export class ItemPedido {
    codigoProduto: number;
    produto: string;
    valorUnitario: number;
    quantidade: number;
    valorTotalItem: number;
  
    constructor(codigoProduto: number,
        produto: string,
        valorUnitario: number,
        quantidade: number,
        valorTotalItem: number){
            this.codigoProduto = codigoProduto;
            this.produto = produto;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.valorTotalItem = valorTotalItem;
        }
  }