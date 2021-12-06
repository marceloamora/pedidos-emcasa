package com.amora.repository.codec;


import com.amora.repository.entity.ProdutoEntity;
import org.bson.*;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class ProdutoCodec implements CollectibleCodec<ProdutoEntity> {


    private Codec<Document> codec;

    public ProdutoCodec(Codec<Document> codec) {
        this.codec = codec;
    }




    @Override
    public void encode(BsonWriter writer, ProdutoEntity produto, EncoderContext encoder) {
        ObjectId id = produto.getId();
        String marca = produto.getMarca();
        String modelo = produto.getModelo();
        String descricao = produto.getDescricao();
        String sistema = produto.getSistema();
        String memoria = produto.getMemoria();
        Integer chips = produto.getChips();
        BigDecimal preco = produto.getPreco();
        Integer quantidade = produto.getQuantidade();

        Document documento = new Document();
        documento.put("_id", id);
        documento.put("marca", marca);
        documento.put("modelo", modelo);
        documento.put("descricao", descricao);
        documento.put("sistema", sistema);
        documento.put("memoria", memoria);
        documento.put("chips", chips);
        documento.put("preco", preco);
        documento.put("quantidade", quantidade);

        codec.encode(writer, documento, encoder);
    }

    @Override
    public ProdutoEntity decode(BsonReader reader, DecoderContext decoder) {
        Document document = codec.decode(reader, decoder);
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(document.getObjectId("_id"));
        produto.setMarca(document.getString("marca"));
        produto.setModelo(document.getString("modelo"));
        produto.setDescricao(document.getString("descricao"));
        produto.setSistema(document.getString("sistema"));
        produto.setMemoria(document.getString("memoria"));
        produto.setChips(document.getInteger("chip"));
        produto.setPreco(new BigDecimal(document.getDouble("preco")));
        produto.setQuantidade(document.getInteger("quantidade"));
        return produto;
    }

    @Override
    public Class<ProdutoEntity> getEncoderClass() {
        return ProdutoEntity.class;
    }


    @Override
    public ProdutoEntity generateIdIfAbsentFromDocument(ProdutoEntity produto) {
        if (!documentHasId(produto)) {
            produto.setId(new ObjectId());
        }

        return produto;
    }


    @Override
    public boolean documentHasId(ProdutoEntity produto) {
        return produto.getId()!=null;
    }

    @Override
    public BsonValue getDocumentId(ProdutoEntity produto)
    {
        if (!documentHasId(produto)) {
            throw new IllegalStateException("The document does not contain an _id");
        }

        return new BsonString(produto.getModelo());
    }

}
