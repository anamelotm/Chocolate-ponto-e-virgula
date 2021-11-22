export class Pedido {
    id: number;
    nome: string;
    enderecoEntrega: string;
    aberto: boolean;
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
            this.nome = cliente;
            this.enderecoEntrega= enderecoEntrega;
            this.aberto =situacao;
            this.subtotal = subtotal;
            this.desconto = desconto;
            this.total = total;
        }
        
      }
  
  