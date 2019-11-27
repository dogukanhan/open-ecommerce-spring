package com.dogukanhan.ecom.appserver.repository;

import com.dogukanhan.ecom.appserver.entity.CategoryField;
import com.dogukanhan.ecom.appserver.entity.MProduct;
import com.dogukanhan.ecom.appserver.entity.Product;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class MProductRepository {

    private static final String DATABASE_NAME = "ecom";

    private static final String COLLECTION_NAME = "m_product";

    private MongoDatabase mongoDatabase;

    public MProductRepository(MongoClient mongoClient) {
        mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
    }

    public MProduct save(MProduct mProduct) {
        var col = mongoDatabase.getCollection(COLLECTION_NAME);
        col.insertOne(mProductToDocument(mProduct));
        return mProduct;
    }

    public Optional<MProduct> findOne(Long id) {
        var col = mongoDatabase.getCollection(COLLECTION_NAME);

        var mProduct = documentToMProduct(col.find(BsonDocument.parse("{_id:" + id + "}")).first());

        return mProduct == null ? Optional.empty() : Optional.of(mProduct);
    }

    private static MProduct documentToMProduct(Document document) {

        if (document == null)
            return null;

        final var set = Set.of("_id", "name", "thumbnail", "detail", "piece", "price");
        final var mProduct = new MProduct();
        mProduct.setId(document.getLong("_id"));
        mProduct.setName(document.getString("name"));
        mProduct.setThumbnail(document.getString("thumbnail"));
        mProduct.setDetail(document.getString("detail"));
        mProduct.setPiece(document.getInteger("piece"));
        // Fix this after
        mProduct.setPrice(new BigDecimal(String.valueOf(document.get("price"))));

        final var extras = new LinkedHashMap<String, Object>();

        document.forEach((key, value) -> {
            if (!set.contains(key)) {
                extras.put(key, value);
            }
        });

        return mProduct;
    }


    private static Document mProductToDocument(MProduct product) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("_id", product.getId());
        linkedHashMap.put("name", product.getName());
        linkedHashMap.put("detail", product.getDetail());
        linkedHashMap.put("price", product.getPrice());
        linkedHashMap.put("thumbnail", product.getThumbnail());
        linkedHashMap.put("piece", product.getPiece());

        product.getExtra().forEach((key, value) -> {
            linkedHashMap.put(key.getName().toLowerCase(), value);
        });

        var dc = new Document(linkedHashMap);

        return dc;
    }

}
