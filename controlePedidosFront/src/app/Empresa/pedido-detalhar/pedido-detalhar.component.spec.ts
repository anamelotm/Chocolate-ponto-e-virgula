import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoDetalharComponent } from './pedido-detalhar.component';

describe('PedidoDetalharComponent', () => {
  let component: PedidoDetalharComponent;
  let fixture: ComponentFixture<PedidoDetalharComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PedidoDetalharComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PedidoDetalharComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
