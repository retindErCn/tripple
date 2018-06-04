package com.tripple.Entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QhttpParams is a Querydsl query type for httpParams
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QhttpParams extends EntityPathBase<httpParams> {

    private static final long serialVersionUID = -384149246L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QhttpParams httpParams = new QhttpParams("httpParams");

    public final QBusinessEntity _super;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath defaultValue = createString("defaultValue");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isMust = createBoolean("isMust");

    public final StringPath paramName = createString("paramName");

    public final StringPath paramValue = createString("paramValue");

    public final NumberPath<Long> requestid = createNumber("requestid", Long.class);

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    //inherited
    public final NumberPath<Integer> version;

    public QhttpParams(String variable) {
        this(httpParams.class, forVariable(variable), INITS);
    }

    public QhttpParams(Path<? extends httpParams> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QhttpParams(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QhttpParams(PathMetadata<?> metadata, PathInits inits) {
        this(httpParams.class, metadata, inits);
    }

    public QhttpParams(Class<? extends httpParams> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

