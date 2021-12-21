package com.br.mycapital.resources;

import com.br.mycapital.enums.ClasseCarta;
import com.br.mycapital.enums.TipoCarta;
import com.br.mycapital.models.CartaEntity;
import com.br.mycapital.repositories.CartaRepository;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/carta")
public class CartaResource {

    private CartaRepository cartaRepository = new CartaRepository();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CartaEntity findById(@PathParam("id") int id){
        return cartaRepository.getById(id);
    }
    @GET
    @Path("/nome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public CartaEntity findByName(@PathParam("nome") String nome){
        return cartaRepository.getByName(nome);
    }
    @GET
    @Path("/tipo/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public CartaEntity findByTipo(@PathParam("tipo") TipoCarta tipo){
        return cartaRepository.getByTipo(tipo);
    }
    @GET
    @Path("/classe/{classe}")
    @Produces(MediaType.APPLICATION_JSON)
    public CartaEntity findByClasse(@PathParam("classe") ClasseCarta classe){
        return cartaRepository.getByClasse(classe);
    }
    @POST
    @Path(("/cadastrar"))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(CartaEntity carta) {
        if(carta.getAtaque()>=0 && carta.getDefesa()>=0 && carta.getAtaque()<=10 && carta.getDefesa()<=10){
            try{
                cartaRepository.cadastrar(carta);
                return Response.status(Response.Status.CREATED).entity(carta).build();
            } catch(Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(carta).build();
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") int id)
    {
        CartaEntity carta = cartaRepository.getById(id);
        if(carta == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            try {
                cartaRepository.deletar(id);
                return Response.status(Response.Status.OK).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }
    }


}
