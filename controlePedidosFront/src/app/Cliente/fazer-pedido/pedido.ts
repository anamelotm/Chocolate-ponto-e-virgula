
export class FazerPedidoComponent {
    public cep!: number;      // propriedade que liga o html ao ts e vice-versa
  
    cadastrar() {
      console.log(this.cep)  // valor inserido no input
    }
}