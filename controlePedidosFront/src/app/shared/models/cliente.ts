export class Cliente {
  id: number;
  tipo: string;
  documento: string;
  nome: string;

  constructor(codigo: number, tipo: string, documento: string, nome:string){
    this.id = codigo;
    this.tipo = tipo;
    this.documento = documento;
    this.nome = nome;
  }
}
