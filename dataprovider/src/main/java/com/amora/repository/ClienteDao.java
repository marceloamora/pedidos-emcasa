package com.amora.repository;

import com.amora.repository.codec.ClienteCodec;
import com.amora.repository.entity.ClienteEntity;
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
public class ClienteDao {

    private MongoClient connection;
    private MongoDatabase bancoDeDados;

    private void criarConexao() {
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        ClienteCodec clienteCodec = new ClienteCodec(codec);

        CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(clienteCodec));

        MongoClientOptions options = MongoClientOptions.builder().codecRegistry(registro).build();

        connection = new MongoClient("localhost:27017", options);
        bancoDeDados = connection.getDatabase("loja");
    }

    private void fecharConexao() {
        this.connection.close();
    }

    public void salvar(ClienteEntity cliente) {
        criarConexao();
        MongoCollection<ClienteEntity> clientes = this.bancoDeDados.getCollection("clientes", ClienteEntity.class);

        if (cliente.getId() == null) {
            clientes.insertOne(cliente);
        } else {
            clientes.updateOne(Filters.eq("_id",  cliente.getId()), new Document("$set", cliente));
        }

        fecharConexao();

    }

    public ClienteEntity obter(String id) {
        criarConexao();
        MongoCollection<ClienteEntity> clientes = this.bancoDeDados.getCollection("clientes", ClienteEntity.class);
        ClienteEntity clienteEncontrado = clientes.find(Filters.eq("_id", new ObjectId(id))).first();
        fecharConexao();
        return clienteEncontrado;

    }

    public List<ClienteEntity> listar() {
        criarConexao();
        MongoCollection<ClienteEntity> clientes = this.bancoDeDados.getCollection("clientes", ClienteEntity.class);
        MongoCursor<ClienteEntity> iterator = clientes.find().iterator();
        List<ClienteEntity> lista = new ArrayList<>();
        while (iterator.hasNext()){
            ClienteEntity cliente = iterator.next();
            lista.add(cliente);
        }
        fecharConexao();
        return lista;

    }
}
