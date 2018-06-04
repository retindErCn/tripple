package com.tripple.Entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QhttpRequest is a Querydsl query type for httpRequest
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QhttpRequest extends EntityPathBase<httpRequest> {

    private static final long serialVersionUID = -1429503341L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QhttpRequest httpRequest = new QhttpRequest("httpRequest");

    public final QBusinessEntity _super;

    public final EnumPath<com.tripple.enumType.apiLevel> apilevel = createEnum("apilevel", com.tripple.enumType.apiLevel.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath description = createString("description");

    public final StringPath httpMethod = createString("httpMethod");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isOn = createBoolean("isOn");

    public final StringPath name = createString("name");

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    public final StringPath url = createString("url");

    //inherited
    public final NumberPath<Integer> version;

    public QhttpRequest(String variable) {
        this(httpRequest.class, forVariable(variable), INITS);
    }

    public QhttpRequest(Path<? extends httpRequest> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QhttpRequest(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QhttpRequest(PathMetadata<?> metadata, PathInits inits) {
        this(httpRequest.class, metadata, inits);
    }

    public QhttpRequest(Class<? extends httpRequest> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

