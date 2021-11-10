export class Cliente {
  codigo: number;
  tipo: string;
  documento: string;
  nome: string;

  constructor(codigo: number, tipo: string, documento: string, nome:string){
    this.codigo = codigo;
    this.tipo = tipo;
    this.documento = documento;
    this.nome = nome;
  }
}
