package com.tripple.Model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;
import com.mysema.query.types.PathMetadata;

import javax.annotation.Generated;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;
import com.tripple.Entity.BusinessEntity;


/**
 * QBusinessEntity is a Querydsl query type for BusinessEntity
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QBusinessEntity extends EntityPathBase<BusinessEntity> {

    private static final long serialVersionUID = -848104777L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusinessEntity businessEntity = new QBusinessEntity("businessEntity");

    public final DateTimePath<org.joda.time.DateTime> createDate = createDateTime("createDate", org.joda.time.DateTime.class);

    public final Quser updateBy;

    public final DateTimePath<org.joda.time.DateTime> updatedDate = createDateTime("updatedDate", org.joda.time.DateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QBusinessEntity(String variable) {
        this(BusinessEntity.class, forVariable(variable), INITS);
    }

    public QBusinessEntity(Path<? extends BusinessEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBusinessEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBusinessEntity(PathMetadata<?> metadata, PathInits inits) {
        this(BusinessEntity.class, metadata, inits);
    }

    public QBusinessEntity(Class<? extends BusinessEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.updateBy = inits.isInitialized("updateBy") ? new Quser(forProperty("updateBy"), inits.get("updateBy")) : null;
    }

}

