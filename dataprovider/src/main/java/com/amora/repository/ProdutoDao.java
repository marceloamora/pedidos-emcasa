package com.amora.repository;

import com.amora.repository.codec.ProdutoCodec;
import com.amora.repository.entity.ProdutoEntity;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProdutoDao {

    private MongoClient connection;
    private MongoDatabase bancoDeDados;

    private void criarConexao() {
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        ProdutoCodec produtoCodec = new ProdutoCodec(codec);

        CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(produtoCodec));

        MongoClientOptions options = MongoClientOptions.builder().codecRegistry(registro).build();

        connection = new MongoClient("localhost:27017",options);
        bancoDeDados = connection.getDatabase("loja");
    }

    private void fecharConexao() {
        this.connection.close();
    }



    public ProdutoEntity obter(String id) {
        criarConexao();
        MongoCollection<ProdutoEntity> produtos = this.bancoDeDados.getCollection("produtos", ProdutoEntity.class);
        ProdutoEntity produtoEncontrado = produtos.find(Filters.eq("_id", new ObjectId(id))).first();
        fecharConexao();
        return produtoEncontrado;

    }

    public List<ProdutoEntity> listar() {
        criarConexao();
        MongoCollection<ProdutoEntity> produtos = this.bancoDeDados.getCollection("produtos", ProdutoEntity.class);
        MongoCursor<ProdutoEntity> iterator = produtos.find().iterator();
        List<ProdutoEntity> lista = new ArrayList<>();
        while (iterator.hasNext()){
            ProdutoEntity cliente = iterator.next();
            lista.add(cliente);
        }
        fecharConexao();
        return lista;

    }

    public void salvar(ProdutoEntity entity) {
        criarConexao();
        MongoCollection<ProdutoEntity> produtos = this.bancoDeDados.getCollection("produtos", ProdutoEntity.class);

        if (entity.getId() == null) {
            produtos.insertOne(entity);
        } else {
            produtos.updateOne(Filters.eq("_id",  entity.getId()), new Document("$set", entity));
        }

        fecharConexao();

    }

}
