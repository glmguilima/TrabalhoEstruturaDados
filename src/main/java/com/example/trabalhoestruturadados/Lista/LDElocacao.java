package com.example.trabalhoestruturadados.Lista;

import com.example.trabalhoestruturadados.Base.Locacao;
import com.example.trabalhoestruturadados.Noh.NohLocacao;

public class LDElocacao {

	private NohLocacao inicio;
	private NohLocacao fim;
	
	public LDElocacao() {
		this.inicio = null;
		this.fim = null;
	}
	
	public void insereInicio(Locacao info) {
		NohLocacao novo = new NohLocacao(info);
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}
	
	public void insereFim(Locacao info) {
		NohLocacao novo = new NohLocacao(info);
		if(fim == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}
	
	public boolean estaVazia() {
		return inicio == null;
	}
	
	public boolean remove(Locacao info) {
		NohLocacao p = busca(info);
		if(p == null) 
			return false;
		if(p.getAnt() == null) {
			inicio = p.getProx();
			if(inicio != null) {
				inicio.setAnt(null);
			}else if(p.getProx() == null) {
				p.getAnt().setProx(null);
				fim = p.getAnt();
			}else {
				p.getAnt().setProx(p.getProx());
				p.getAnt().setAnt(p.getAnt());
			}
		}return true;
	}
	
	public NohLocacao busca(Locacao info) {
		NohLocacao resultado = null;
		for(NohLocacao i = inicio; i != null && i.getInfo() != null; i.getProx()) {
			if(i.getInfo().getCNH() == info.getCNH()) {
				resultado = i;
			}
		}return resultado;
	}
	
	public int tamanho() {
		int count = 0;
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			count++;
		}return count;
	}
	
	public void imprimeInicio() {
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public void imprimeFim() {
		for(NohLocacao i = fim; i != null; i.getAnt()) {
			System.out.print(i.toString() + "\n");
		}
	}
	
	public Locacao get(String placa) {
		NohLocacao nohLoc = busca(placa);
		if(nohLoc != null) 
			return nohLoc.getInfo();
		return null;
		
	}
	
	public NohLocacao busca(String placa) {
		NohLocacao resultado = null;
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getPlaca().equals(placa))
				resultado = i;
		}
		return resultado;
}
	
	public boolean possuiLocacao(Long CNH) {
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getCNH() == CNH) 
				return true;
		}return false;
	}
	
	public boolean possuiLoacao(String placa) {
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getPlaca() == placa) {
				return true;
			}
		}return false;
	}
	
	
	public boolean estaLocado(Long CNH) {
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getCNH() == CNH) {
				return true;
			}
		}return false;	
	}
	
	public boolean estaLocado(String placa) {
		for(NohLocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getPlaca() == placa) {
				return true;
			}
		}return false;
	}
	
	
}