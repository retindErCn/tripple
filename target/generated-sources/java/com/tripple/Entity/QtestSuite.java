package com.tripple.Entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QtestSuite is a Querydsl query type for testSuite
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QtestSuite extends EntityPathBase<testSuite> {

    private static final long serialVersionUID = -1507536334L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QtestSuite testSuite = new QtestSuite("testSuite");

    public final QBusinessEntity _super;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath suiteName = createString("suiteName");

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    //inherited
    public final NumberPath<Integer> version;

    public QtestSuite(String variable) {
        this(testSuite.class, forVariable(variable), INITS);
    }

    public QtestSuite(Path<? extends testSuite> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QtestSuite(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QtestSuite(PathMetadata<?> metadata, PathInits inits) {
        this(testSuite.class, metadata, inits);
    }

    public QtestSuite(Class<? extends testSuite> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

