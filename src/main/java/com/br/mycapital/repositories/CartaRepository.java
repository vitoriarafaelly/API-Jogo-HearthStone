package com.br.mycapital.repositories;

import com.br.mycapital.models.CartaEntity;

import java.util.HashMap;

public class CartaRepository {
    private final static HashMap<Integer, CartaEntity> cartas = new HashMap<>();

    public CartaEntity getById(int id) {
        return cartas.get(id);
    }
    public CartaEntity getByName(String nome) {
        return cartas.get(nome);
    }
    public void cadastrar(CartaEntity carta) {
            cartas.put(carta.getId(), carta);
    }
    public void deletar(int id) {
        cartas.remove(id);
    }



}
