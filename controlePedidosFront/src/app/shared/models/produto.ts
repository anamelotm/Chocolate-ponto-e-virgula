export class Produto {
  id: number;
  nome: string;
  descricao!: string;
  unidadeMedida: string;
  valorUnitario: number;
  status: boolean;
  urlFotos: string;
  peso: number;
  dataFabricacao: string;
  dataValidade:string;
  quantidadeEstoque: number;

  constructor(id: number, nome: string, descricao: string, unidade_medida: string,
     valor_unitario: number, status: boolean,url_fotos: string, peso: number,
     data_fabricacao: string,data_validade: string, quantidade_estoque: number ){
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.unidadeMedida = unidade_medida;
    this.valorUnitario = valor_unitario;
    this.status = status;
    this.urlFotos = url_fotos;
    this.peso = peso;
    this.dataFabricacao = data_fabricacao;
    this.dataValidade = data_validade;
    this.quantidadeEstoque = quantidade_estoque;
  }
}


