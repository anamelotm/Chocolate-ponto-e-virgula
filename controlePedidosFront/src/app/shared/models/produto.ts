export class Produto {
  id: number;
  nome: string;
  descricao!: string;
  unidade_medida: string;
  valor_unitario: number;
  status: boolean;
  url_fotos: string;
  peso: number;
  data_fabricacao: Date;
  data_validade: Date;
  quantidade_estoque: number;

  constructor(id: number, nome: string, descricao: string, unidade_medida: string,
     valor_unitario: number, status: boolean,url_fotos: string, peso: number,
     data_fabricacao: Date,data_validade: Date, quantidade_estoque: number ){
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.unidade_medida = unidade_medida;
    this.valor_unitario = valor_unitario;
    this.status = status;
    this.url_fotos = url_fotos;
    this.peso = peso;
    this.data_fabricacao = data_fabricacao;
    this.data_validade = data_validade;
    this.quantidade_estoque = quantidade_estoque;
  }
}


