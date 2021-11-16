export class Pedido {
    id: number;
    cliente: string;
    enderecoEntrega: string;
    situacao: boolean;
    subtotal: number;
    desconto: number;
    total: number;

    constructor(codigo: number,
        cliente: string,
        enderecoEntrega: string,
        situacao: boolean,
        subtotal: number,
        desconto: number,
        total: number){
            this.id = codigo;
            this.cliente = cliente;
            this.enderecoEntrega= enderecoEntrega;
            this.situacao =situacao;
            this.subtotal = subtotal;
            this.desconto = desconto;
            this.total = total;
        }
        
      }
  
  