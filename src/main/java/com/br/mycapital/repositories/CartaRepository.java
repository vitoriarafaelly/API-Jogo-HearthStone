package com.br.mycapital.repositories;

import com.br.mycapital.enums.ClasseCarta;
import com.br.mycapital.enums.TipoCarta;
import com.br.mycapital.models.CartaEntity;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class CartaRepository {
    private final static HashMap<Integer, CartaEntity> cartas = new HashMap<>();

    public CartaEntity getById(int id) {
        return cartas.get(id);
    }
    public CartaEntity getByName(String nome) {
        for (CartaEntity carta : cartas.values()) {
            if(carta.getNome().equals(nome)){
                return carta;
            }
        }
        throw new NoSuchElementException("Carta não encontrada!");
    }
    public CartaEntity getByTipo(TipoCarta tipo) {
        for (CartaEntity carta : cartas.values()) {
            if(carta.getTipo().equals(tipo)){
                return carta;
            }
        }
        throw new NoSuchElementException("Carta não encontrada!");
    }
    public CartaEntity getByClasse(ClasseCarta classe) {
        for (CartaEntity carta : cartas.values()) {
            if(carta.getClasse().equals(classe)){
                return carta;
            }
        }
        throw new NoSuchElementException("Carta não encontrada!");
    }
    public void cadastrar(CartaEntity carta) {
            cartas.put(carta.getId(), carta);
    }
    public void deletar(int id) {
        cartas.remove(id);
    }



}
