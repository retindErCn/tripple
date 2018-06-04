package com.tripple.Entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QtestStep is a Querydsl query type for testStep
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QtestStep extends EntityPathBase<testStep> {

    private static final long serialVersionUID = -1572651950L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QtestStep testStep = new QtestStep("testStep");

    public final QBusinessEntity _super;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath leftVar = createString("leftVar");

    public final EnumPath<com.tripple.enumType.customOperator> operator = createEnum("operator", com.tripple.enumType.customOperator.class);

    public final NumberPath<Long> requestid = createNumber("requestid", Long.class);

    public final StringPath rightVar = createString("rightVar");

    public final StringPath stepName = createString("stepName");

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    //inherited
    public final NumberPath<Integer> version;

    public QtestStep(String variable) {
        this(testStep.class, forVariable(variable), INITS);
    }

    public QtestStep(Path<? extends testStep> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QtestStep(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QtestStep(PathMetadata<?> metadata, PathInits inits) {
        this(testStep.class, metadata, inits);
    }

    public QtestStep(Class<? extends testStep> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

