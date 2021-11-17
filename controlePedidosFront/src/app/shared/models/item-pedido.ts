export class ItemPedido {
    codigoPedido: number = 0;
    produto: string;
    valorUnitario: number;
    quantidade: number;
    valorTotalItem: number;

    constructor(
        produto: string,
        valorUnitario: number,
        quantidade: number){
            this.produto = produto;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.valorTotalItem = quantidade * valorUnitario;
        }


  }
