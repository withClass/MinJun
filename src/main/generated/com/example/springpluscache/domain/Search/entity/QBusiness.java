package com.example.springpluscache.domain.Search.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBusiness is a Querydsl query type for Business
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusiness extends EntityPathBase<Business> {

    private static final long serialVersionUID = -1983031381L;

    public static final QBusiness business = new QBusiness("business");

    public final StringPath businessName = createString("businessName");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath industryName = createString("industryName");

    public final StringPath postCode = createString("postCode");

    public final StringPath registrationNumber = createString("registrationNumber");

    public final StringPath roadAddress = createString("roadAddress");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBusiness(String variable) {
        super(Business.class, forVariable(variable));
    }

    public QBusiness(Path<? extends Business> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusiness(PathMetadata metadata) {
        super(Business.class, metadata);
    }

}

