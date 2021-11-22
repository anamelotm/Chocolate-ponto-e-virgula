export class Produto {
  id: number;
  nome?: string;
  descricaoProduto?: string;
  unidadeMedida?: string;
  valorUnitario?: number;
  status?: boolean;
  urlFoto?: string;
  peso?: number;
  dataFabricacao?: Date;
  dataValidade?:Date;
  quantidadeEstoque?: number;

  constructor(id: number, nome: string, descricao: string, unidade_medida: string,
     valor_unitario: number, status: boolean,urlFoto: string, peso: number,
     data_fabricacao: Date, data_validade: Date, quantidade_estoque: number ){
    this.id = id;
    this.nome = nome;
    this.descricaoProduto = descricao;
    this.unidadeMedida = unidade_medida;
    this.valorUnitario = valor_unitario;
    this.status = status;
    this.urlFoto = urlFoto;
    this.peso = peso;
    this.dataFabricacao = data_fabricacao;
    this.dataValidade = data_validade;
    this.quantidadeEstoque = quantidade_estoque;
  }
}


