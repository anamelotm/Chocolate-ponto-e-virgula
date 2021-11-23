export interface Produto {
  id?: number;
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

}


