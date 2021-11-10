export class Produto {
  codigo: number;
  descricaoProduto: string;
  unidadeMedida: string;
  valorUnitario: number;
  status: boolean;

  constructor(codigo: number, descricaoProduto: string, unidadeMedida: string, valorUnitario: number, status: boolean){
    this.codigo = codigo;
    this.descricaoProduto = descricaoProduto;
    this.unidadeMedida = unidadeMedida;
    this.valorUnitario = valorUnitario;
    this.status = status;
  }
}


