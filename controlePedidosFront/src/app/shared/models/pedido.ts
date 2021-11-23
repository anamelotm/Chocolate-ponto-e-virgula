import { Cliente } from "./cliente";

export interface Pedido {
    id?: number;
    cliente: Cliente;
    dataPedido?: Date;
    enderecoEntrega?: string;
    aberto?: boolean;
    valorTotal?: number;
    quantidadeTotal?:number;
    percentualDesconto?: number;
}
