package com.tripple.Model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;
import com.tripple.Entity.httpHeader;

/**
 * QhttpHeader is a Querydsl query type for httpHeader
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QhttpHeader extends EntityPathBase<httpHeader> {

    private static final long serialVersionUID = -609992183L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QhttpHeader httpHeader = new QhttpHeader("httpHeader");

    public final QBusinessEntity _super;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath description = createString("description");

    public final StringPath headerName = createString("headerName");

    public final StringPath headerValue = createString("headerValue");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> requestid = createNumber("requestid", Long.class);

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    //inherited
    public final NumberPath<Integer> version;

    public QhttpHeader(String variable) {
        this(httpHeader.class, forVariable(variable), INITS);
    }

    public QhttpHeader(Path<? extends httpHeader> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QhttpHeader(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QhttpHeader(PathMetadata<?> metadata, PathInits inits) {
        this(httpHeader.class, metadata, inits);
    }

    public QhttpHeader(Class<? extends httpHeader> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

