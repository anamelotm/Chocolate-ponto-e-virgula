import { Produto } from "./produto";
export interface ItemPedido {
    id?: number;
    idPedido: number;
    valorTotal: number;
    quantidade: number;
<<<<<<< HEAD
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
=======
    produto: Produto;

>>>>>>> feature/ana.melo
  }
