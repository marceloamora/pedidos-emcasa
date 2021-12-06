package com.amora.repository.codec;

import com.amora.repository.entity.CarrinhoEntity;
import com.amora.repository.entity.ClienteEntity;
import com.amora.repository.entity.ProdutoEntity;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClienteCodec implements CollectibleCodec<ClienteEntity> {


    private Codec<Document> codec;

    public ClienteCodec(Codec<Document> codec) {
        this.codec = codec;
    }



    @Override
    public void encode(BsonWriter writer, ClienteEntity cliente, EncoderContext encoder) {
        ObjectId id = cliente.getId();
        String nome = cliente.getNome();
        String endereco = cliente.getEndereco();
        String email = cliente.getEmail();
        String senha = cliente.getSenha();


        Document documento = new Document();
        documento.put("_id", id);
        documento.put("nome", nome);
        documento.put("endereco", endereco);
        documento.put("email", email);
        documento.put("senha", senha);

        CarrinhoEntity carrinho = cliente.getCarrinho();
        if(carrinho!=null){
            Document carrinhoDocument = new Document();

            List<Document> produtos = new ArrayList<>();

            for(ProdutoEntity p:carrinho.getProdutos()){
                produtos.add(
                        new Document("_id", p.getId())
                                .append("marca", p.getMarca())
                                .append("modelo", p.getModelo())
                                .append("preco",p.getPreco().doubleValue())


                );
            }
            carrinhoDocument.put("produtos", produtos);
            documento.put("carrinho", carrinhoDocument);

        }

        codec.encode(writer, documento, encoder);
    }

    @Override
    public ClienteEntity decode(BsonReader reader, DecoderContext decoder) {
        Document document = codec.decode(reader, decoder);
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(document.getObjectId("_id"));
        cliente.setNome(document.getString("nome"));
        cliente.setEndereco(document.getString("endereco"));
        cliente.setEmail(document.getString("email"));
        cliente.setSenha(document.getString("senha"));


        Document carrinho = (Document) document.get("carrinho");
        if(carrinho!=null){
            cliente.setCarrinho(new CarrinhoEntity());
            List<Document> produtos = (List<Document>) carrinho.get("produtos");
            if(produtos!=null){
                List<ProdutoEntity> listaProdutos = new ArrayList<>();
                for (Document produto : produtos){
                    ProdutoEntity p = new ProdutoEntity();
                    p.setId( produto.getObjectId("_id"));
                    p.setMarca(produto.getString("marca"));
                    p.setModelo(produto.getString("modelo"));
                    p.setPreco(new BigDecimal(produto.getDouble("preco")));
                    listaProdutos.add(p);
                }
                cliente.getCarrinho().setProdutos(listaProdutos);


            }
        }


        return cliente;
    }

    @Override
    public Class<ClienteEntity> getEncoderClass() {
        return ClienteEntity.class;
    }


    @Override
    public ClienteEntity generateIdIfAbsentFromDocument(ClienteEntity cliente) {
        if (!documentHasId(cliente)) {
            cliente.setId(new ObjectId());
        }
     return  cliente;
    }


    @Override
    public boolean documentHasId(ClienteEntity cliente) {
        return cliente.getId()!=null;
    }

    @Override
    public BsonValue getDocumentId(ClienteEntity cliente) {
        return null;
    }

}
