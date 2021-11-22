export interface Pedido {
    id?: number;
    idCliente?: any;
    dataPedido?: Date;
    enderecoEntrega?: string;
    aberto?: boolean;
    valorTotal?: number;
    quantidadeTotal?:number;
    percentualDesconto?: number;
}
