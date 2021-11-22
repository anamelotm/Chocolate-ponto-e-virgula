import { Produto } from "./produto";
export interface ItemPedido {
    id?: number;
    idPedido: number;
    valorTotal: number;
    quantidade: number;
    produto: Produto;

  }
