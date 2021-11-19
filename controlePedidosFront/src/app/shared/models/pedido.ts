
export interface Pedido {
    id?: number;
    idCliente?: number;
    dataPedido?: Date;
    enderecoEntrega?: string;
    aberto?: boolean;
    valorSemDesconto?: number;
    valorComDesconto?: number;
    quantidadeTotal?:number;
    percentualDesconto?: number;
}
