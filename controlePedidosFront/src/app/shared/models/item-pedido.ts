export class ItemPedido {
    id: number;
    codigoPedido: number;
    nomeProduto: string;
    valorUnitario: number;
    quantidade: number;
    valorTotalItem: number;
  
    constructor(id: number, codigoPedido: number,
        nomeProduto: string,
        valorUnitario: number,
        quantidade: number,
        valorTotalItem: number){
            this.id = id;
            this.codigoPedido= codigoPedido;
            this.nomeProduto = nomeProduto;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.valorTotalItem = valorTotalItem;
        }
  }